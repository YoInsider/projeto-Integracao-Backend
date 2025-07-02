package org.example.controller;

import org.example.dao.ProductCategoriesDTO;
import org.example.dao.ProductLinesDTO;
import org.example.service.ProductCategoriesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductCategoriesController.class)
class ProductCategoriesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductCategoriesService productCategoriesService;

    @Test
    void testGetAllCategories() throws Exception {
        ProductLinesDTO line = new ProductLinesDTO(1L, "Line A");

        List<ProductCategoriesDTO> mockCategories = Arrays.asList(
                new ProductCategoriesDTO(1L, "Category A", line),
                new ProductCategoriesDTO(2L, "Category B", line)
        );

        when(productCategoriesService.getAllCategories()).thenReturn(mockCategories);

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].name").value("Category A"))
                .andExpect(jsonPath("$.[0].line.id").value(1))
                .andExpect(jsonPath("$.[0].line.name").value("Line A"))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].name").value("Category B"))
                .andExpect(jsonPath("$.[1].line.id").value(1));

        verify(productCategoriesService).getAllCategories();
    }

    @Test
    void testGetCategoryByLineId() throws Exception {
        Long lineId = 1L;
        ProductLinesDTO line = new ProductLinesDTO(lineId, "Line A");

        List<ProductCategoriesDTO> mockCategories = Arrays.asList(
                new ProductCategoriesDTO(1L, "Category A", line),
                new ProductCategoriesDTO(2L, "Category B", line)
        );

        when(productCategoriesService.getCategoryByLineId(lineId)).thenReturn(mockCategories);

        mockMvc.perform(get("/api/categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].name").value("Category A"))
                .andExpect(jsonPath("$.[0].line.id").value(1))
                .andExpect(jsonPath("$.[0].line.name").value("Line A"))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].name").value("Category B"))
                .andExpect(jsonPath("$.[1].line.id").value(1));

        verify(productCategoriesService).getCategoryByLineId(lineId);
    }
}