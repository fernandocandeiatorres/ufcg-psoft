package com.psoft.atvprat2;

import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("Testes para a alteração de Produto")
public class ProdutoAlterarServiceTest {
//
//    @Autowired
//    ProdutoAlterarService driver;
//
//    @MockBean
//    ProdutoRepository<Produto, Long> produtoRepository;
//    Produto produto;
//
//    @BeforeEach
//    void setup() {
//        Mockito.when(produtoRepository.find(10L))
//                .thenReturn(Produto.builder()
//                        .id(10L)
//                        .codigoBarra("19238719283")
//                        .nome("Produto Dez")
//                        .fabricante("EMpresa Dez")
//                        .preco(450.00)
//                        .build()
//                );
//
//        produto = produtoRepository.find(10L);
//
//        Mockito.when(produtoRepository.update(produto))
//                .thenReturn(Produto.builder()
//                        .id(10L)
//                        .codigoBarra("19238719283")
//                        .nome("Nome Produto Alterado")
//                        .fabricante("Nome EMpresa Alterado")
//                        .preco(450.00)
//                        .build()
//                );
//    }
//
//    @Test
//    @DisplayName("Quando altero o nome do produto com um nome válido")
//    void alterarNomeDoProduto() {
//        produto.setNome("Nome Produto Al")
//
//        Produto resultado = driver.alterar(produto);
//
//        assertEquals("Nome", resultado.getNome());
//
//
//    }
//
//    void pre
}
