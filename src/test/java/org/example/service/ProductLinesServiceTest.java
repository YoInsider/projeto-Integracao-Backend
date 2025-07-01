package org.example.service;

import org.example.dao.ProductLinesDTO;
import org.example.model.ProductLines;
import org.example.repository.ProductLinesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductLinesServiceTest {
    @Mock
    private ProductLinesRepository repo;

    @InjectMocks
    private ProductLinesService productLinesService;

    @Test
    void testGetAllLines() {
        List<ProductLines> mockLines = Arrays.asList(
                new ProductLines(1L, "Line A"),
                new ProductLines(2L, "Line B")
        );

        when(repo.findAll()).thenReturn(mockLines);

        List<ProductLinesDTO> result = productLinesService.getAllLines();

        assertAll(
                () -> assertEquals(1L, result.get(0).getId()),
                () -> assertEquals("Line A", result.get(0).getName()),
                () -> assertEquals(2L, result.get(1).getId()),
                () -> assertEquals("Line B", result.get(1).getName()),
                () -> assertEquals(2, result.size())
        );

        verify(repo).findAll();
    }

    @Test
    void testGetLineByIdSuccess() {
        ProductLines mockLines = new ProductLines(1L, "Line A");

        when(repo.existsById(1L)).thenReturn(true);
        when(repo.findLineById(1L)).thenReturn(mockLines);

        String result = productLinesService.getLineById(1L);

        assertEquals("Line A", result);

        verify(repo).existsById(1L);
        verify(repo).findLineById(1L);
    }

    @Test
    void testGetLineByIdError() {
        Long id = 999L;

        when(repo.existsById(id)).thenReturn(false);

        String result = productLinesService.getLineById(id);

        assertEquals("This id doesn't have a related line", result);

        verify(repo).existsById(id);
        verify(repo, never()).findLineById(anyLong());
    }
}