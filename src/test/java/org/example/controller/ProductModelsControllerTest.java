package org.example.controller;

import org.example.dao.ProductCategoriesDTO;
import org.example.dao.ProductLinesDTO;
import org.example.dao.ProductModelsDTO;
import org.example.service.ProductModelsService;
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
@WebMvcTest(ProductModelsController.class)
public class ProductModelsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductModelsService productModelsService;

    @Test
    public void testGetAllModels() throws Exception {
        ProductCategoriesDTO category = new ProductCategoriesDTO(1L, "Category A", new ProductLinesDTO(1L, "Line A"));
        List<ProductModelsDTO> mockModels = Arrays.asList(
                new ProductModelsDTO(1L, "Model A", category),
                new ProductModelsDTO(2L, "Model B", category)
        );

        when(productModelsService.getAllModels()).thenReturn(mockModels);

        mockMvc.perform(get("/api/models"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].name").value("Model A"))
                .andExpect(jsonPath("$.[0].category.id").value(1))
                .andExpect(jsonPath("$.[0].category.name").value("Category A"))
                .andExpect(jsonPath("$.[0].category.line.name").value("Line A"))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].name").value("Model B"));

        verify(productModelsService).getAllModels();
    }

    @Test
    public void testGetModelsByCategoryId() throws Exception {
        Long categoryId = 1L;
        ProductCategoriesDTO category = new ProductCategoriesDTO(categoryId, "Category A", new ProductLinesDTO(1L, "Line A"));

        List<ProductModelsDTO> mockModels = Arrays.asList(
                new ProductModelsDTO(1L, "Model A", category),
                new ProductModelsDTO(2L, "Model B", category)
        );

        when(productModelsService.getModelByCategoryId(categoryId)).thenReturn(mockModels);

        mockMvc.perform(get("/api/models/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].name").value("Model A"))
                .andExpect(jsonPath("$.[0].category.id").value(1))
                .andExpect(jsonPath("$.[0].category.name").value("Category A"))
                .andExpect(jsonPath("$.[0].category.line.name").value("Line A"))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].name").value("Model B"));

        verify(productModelsService).getModelByCategoryId(categoryId);
    }
}