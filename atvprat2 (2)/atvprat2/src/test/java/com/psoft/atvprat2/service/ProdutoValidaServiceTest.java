package com.psoft.atvprat2.service;


import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes para a alteração do Produto")
public class ProdutoValidaServiceTest {

    @Autowired
    ProdutoValidaService driver;

    @MockBean
    ProdutoRepository<Produto, Long> produtoRepository;

    Produto produto;

    @BeforeEach
    void setup(){
        Mockito.when(produtoRepository.find(10L))
                .thenReturn(Produto.builder()
                        .id(1L)
                        .nome("Produto Dez")
                        .codigoBarra("123456789")
                        .fabricante("Fabricante Dez")
                        .preco(450.00)
                        .build()
                );
        produto = produtoRepository.find(10L);
        Mockito.when(produtoRepository.update(produto))
                .thenReturn(Produto.builder()
                        .id(1L)
                        .nome("Nome Produto Alterado")
                        .codigoBarra("123456789")
                        .fabricante("Nome Fabricante Alterado")
                        .preco(500.00)
                        .build()
                );
    }

    @Test
    @DisplayName("Quando o código de barras é válido")
    void codigoDeBarrasValido(){
        produto.setCodigoBarra("4012345678901");

        boolean isValid = driver.validaCodigo(produto);

        assertEquals(true, isValid);

    }

    @Test
    @DisplayName("Quando o código de barras é inválido")
    void codigoDeBarrasInvalido(){
        boolean isValid = driver.validaCodigo(produto);

        assertEquals(false, isValid);

    }
}
