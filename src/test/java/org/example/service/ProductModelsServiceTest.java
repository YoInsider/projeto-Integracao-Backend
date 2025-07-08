package org.example.service;

import org.example.dao.ProductModelsDTO;
import org.example.model.ProductCategories;
import org.example.model.ProductLines;
import org.example.model.ProductModels;
import org.example.repository.ProductModelsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductModelsServiceTest {
    @Mock
    private ProductModelsRepository repo;

    @InjectMocks
    private ProductModelsService productModelsService;

    @Test
    public void testGetAllModels() {
        ProductCategories category = new ProductCategories(1L, "Category A", new ProductLines(1L, "Line A"));

        List<ProductModels> mockModels = Arrays.asList(
                new ProductModels(1L, "Model A", category),
                new ProductModels(2L, "Model B", category)
        );

        when(repo.findAll()).thenReturn(mockModels);

        List<ProductModelsDTO> result = productModelsService.getAllModels();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Model A", result.get(0).getName());
        assertEquals(1L, result.get(0).getCategory().getId());
        assertEquals("Category A", result.get(0).getCategory().getName());
        assertEquals(1L, result.get(0).getCategory().getLine().getId());
        assertEquals("Line A", result.get(0).getCategory().getLine().getName());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Model B", result.get(1).getName());
        assertEquals(1L, result.get(1).getCategory().getId());
        assertEquals("Category A", result.get(1).getCategory().getName());
        assertEquals(1L, result.get(1).getCategory().getLine().getId());
        assertEquals("Line A", result.get(1).getCategory().getLine().getName());

        verify(repo).findAll();
    }

    @Test
    public void testGetModelByCategoryIdSuccess() {
        Long categoryId = 1L;
        ProductCategories category = new ProductCategories(categoryId, "Category A", new ProductLines(1L, "Line A"));

        List<ProductModels> mockModels = Arrays.asList(
                new ProductModels(1L, "Model A", category),
                new ProductModels(2L, "Model B", category)
        );

        when(repo.existsById(categoryId)).thenReturn(true);
        when(repo.findByCategoryId(categoryId)).thenReturn(mockModels);

        List<ProductModelsDTO> result = productModelsService.getModelByCategoryId(categoryId);

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Model A", result.get(0).getName());
        assertEquals(1L, result.get(0).getCategory().getId());
        assertEquals("Category A", result.get(0).getCategory().getName());
        assertEquals(1L, result.get(0).getCategory().getLine().getId());
        assertEquals("Line A", result.get(0).getCategory().getLine().getName());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Model B", result.get(1).getName());
        assertEquals(1L, result.get(1).getCategory().getId());
        assertEquals("Category A", result.get(1).getCategory().getName());
        assertEquals(1L, result.get(1).getCategory().getLine().getId());
        assertEquals("Line A", result.get(1).getCategory().getLine().getName());

        verify(repo).existsById(categoryId);
        verify(repo).findByCategoryId(categoryId);
    }

    @Test
    public void testGetModelByCategoryIdError() {
        Long categoryId = 999L;

        when(repo.existsById(categoryId)).thenReturn(false);

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            productModelsService.getModelByCategoryId(categoryId);
        });

        assertEquals("This model id doesn't have a related category", exception.getMessage());

        verify(repo).existsById(categoryId);
        verify(repo, never()).findByCategoryId(categoryId);
    }
}