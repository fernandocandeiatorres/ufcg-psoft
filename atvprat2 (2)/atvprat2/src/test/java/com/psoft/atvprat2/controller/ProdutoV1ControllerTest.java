package com.psoft.atvprat2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do Controlador de Produtos")
public class ProdutoV1ControllerTest {

    @Autowired
    MockMvc mockMvc;

    Produto produto;

    @Qualifier("produtoVolatilStubRepository")
    @Autowired
    ProdutoRepository<Produto, Long> produtoRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        produto = produtoRepository.find(10L);
    }

    @Test
    @DisplayName("Quando altero produto com nome válido")
    void alteroProdutoCOmNomeValido() throws Exception {
        // Arrange
        produto.setNome("Produto Dez Alterado");

        // Act
        String produtoModificadoJSONString = mockMvc.perform(
                put("/v1/produtos/" + produto.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        // Assert
        Produto produtoModificado = objectMapper.readValue(produtoModificadoJSONString, Produto.ProdutoBuilder.class).build();
        assertEquals("Produto Dez Alterado", produtoModificado.getNome());
    }
}
