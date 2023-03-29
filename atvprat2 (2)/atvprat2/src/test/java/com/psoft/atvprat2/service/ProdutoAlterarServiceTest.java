package com.psoft.atvprat2.service;

import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.repository.ProdutoRepository;
import com.psoft.atvprat2.service.ProdutoAlterarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes para a alteração do Produto")
public class ProdutoAlterarServiceTest {


    @Autowired
    ProdutoAlterarService driver;

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
    @DisplayName("Quando altero o nome do produto com um nome válido")
    void alterarNomeDoProduto(){
        /* AAA */
        // Arrange
        produto.setNome("Nome Produto Alterado");

        //Act
        Produto resultado = driver.alterar(produto);

        //Assert
        assertEquals("Nome Produto Alterado", resultado.getNome());
    }

    @Test
    @DisplayName("Quando o preco é menor ou igual a zero")
    void precoMenorOuIgualAZero(){
        //Arrange
        produto.setPreco(0.0);

        //Act
        Produto resultado = driver.alterar(produto);

        //Assert
        RuntimeException thrown = assertThrows(
                RuntimeException.class, () -> driver.alterar(produto));

        assertEquals("Preço Inválido", thrown.getMessage());
    }


}
