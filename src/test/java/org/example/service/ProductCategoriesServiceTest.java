package org.example.service;

import org.example.dao.ProductCategoriesDTO;
import org.example.model.ProductCategories;
import org.example.model.ProductLines;
import org.example.repository.ProductCategoriesRepository;
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
public class ProductCategoriesServiceTest {
    @Mock
    private ProductCategoriesRepository repo;

    @InjectMocks
    private ProductCategoriesService productCategoriesService;

    @Test
    public void testGetAllCategories() {
        ProductLines line = new ProductLines(1L, "Line A");

        List<ProductCategories> mockCategories = Arrays.asList(
                new ProductCategories(1L, "Category A", line),
                new ProductCategories(2L, "Category B", line)
        );

        when(repo.findAll()).thenReturn(mockCategories);

        List<ProductCategoriesDTO> result = productCategoriesService.getAllCategories();

        assertEquals(1L, result.get(0).getId());
        assertEquals("Category A", result.get(0).getName());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Category B", result.get(1).getName());
        assertEquals("Line A", result.get(0).getLine().getName());
        assertEquals(2, result.size());

        verify(repo).findAll();
    }

    @Test
    public void testGetCategoryByLineIdSuccess() {
        Long lineId = 1L;
        ProductLines line = new ProductLines(lineId, "Line A");

        List<ProductCategories> mockCategories = Arrays.asList(
                new ProductCategories(1L, "Category A", line),
                new ProductCategories(2L, "Category B", line)
        );

        when(repo.existsById(lineId)).thenReturn(true);
        when(repo.findByLineId(lineId)).thenReturn(mockCategories);

        List<ProductCategoriesDTO> result = productCategoriesService.getCategoryByLineId(lineId);

        assertEquals(2, result.size());
        assertEquals("Category A", result.get(0).getName());
        assertEquals("Line A", result.get(0).getLine().getName());
        assertEquals("Category B", result.get(1).getName());
        assertEquals("Line A", result.get(1).getLine().getName());

        verify(repo).existsById(lineId);
        verify(repo).findByLineId(lineId);
    }

    @Test
    public void testGetCategoryByLineIdError() {
        Long lineId = 999L;

        when(repo.existsById(lineId)).thenReturn(false);

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            productCategoriesService.getCategoryByLineId(lineId);
        });

        assertEquals("This category id doesn't have a related line", exception.getMessage());

        verify(repo).existsById(lineId);
        verify(repo, never()).findByLineId(lineId);
    }
}