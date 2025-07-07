package org.example.controller;

import org.example.dao.ProductLinesDTO;
import org.example.service.ProductLinesService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductLinesController.class)
public class ProductLinesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductLinesService productLinesService;

    @Test
    public void testGetAllLines() throws Exception {
        List<ProductLinesDTO> mockLines = Arrays.asList(
                new ProductLinesDTO(1L, "Line A"),
                new ProductLinesDTO(2L, "Line B")
        );

        when(productLinesService.getAllLines()).thenReturn(mockLines);

        mockMvc.perform(get("/api/lines"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].name").value("Line A"))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].name").value("Line B"));

        verify(productLinesService).getAllLines();
    }

    @Test
    public void testGetLineById() throws Exception {
        when(productLinesService.getLineById(1L)).thenReturn("Line A");

        mockMvc.perform(get("/api/lines/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Line A"));

        verify(productLinesService).getLineById(1L);
    }
}