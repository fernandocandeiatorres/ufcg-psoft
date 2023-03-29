package com.psoft.atvprat2.repository;

import com.psoft.atvprat2.model.Lote;
import com.psoft.atvprat2.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class VolatilLoteRepositoryTest {


    @Autowired
    VolatilLoteRepository driver = new VolatilLoteRepository();

    Lote lote;
    Lote resultado;
    Produto produto;

    @BeforeEach
    void setup() {
        produto = Produto.builder()
                .id(1L)
                .nome("Produto Base")
                .codigoBarra("123456789")
                .fabricante("Fabricante Base")
                .preco(125.36)
                .build();

        lote = Lote.builder()
                .id(1L)
                .numeroDeItens(100)
                .produto(produto)
                .build();
    }

    @AfterEach
    void tearDown() {
        produto = null;
        driver.deleteAll();
    }

    @Test
    @DisplayName("Adicionar o primeiro Lote no repositorio de dados")
    void salvarPrimeiroLote() {
        resultado = driver.save(lote);

        assertEquals(driver.findAll().size(), 1);
        assertEquals(resultado.getId().longValue(), lote.getId().longValue());
        assertEquals(resultado.getProduto(), produto);
    }

    @Test
    @DisplayName("Adicionar o segundo Lote (ou posterior) no repositorio de dados")
    void salvarSegundoLoteOuPosterior() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(lote);

        resultado = driver.save(loteExtra);

        assertEquals(driver.findAll().size(), 2);
        System.out.println(resultado.getId());
        System.out.println(loteExtra.getId());
        assertEquals(resultado.getId().longValue(), loteExtra.getId().longValue());
        assertEquals(resultado.getProduto(), produtoExtra);



    }

    @Test
    @DisplayName("Adicionar segundo Lote no repositório de lotes e ver se a quantidade de lotes é 1.")
    void updateTest() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("029349042")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(3L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(lote);

        resultado = driver.update(loteExtra);

        assertEquals(driver.findAll().size(), 1);
        assertEquals(resultado.getId().longValue(), loteExtra.getId().longValue());
        assertEquals(resultado.getProduto(), produtoExtra);
    }

    @Test
    @DisplayName("Recuperar lote adicionado no repositorio, utilizando o ID")
    void findTest() {
        driver.save(lote);


        assertEquals(driver.findAll().size(), 1);
        resultado = driver.find(1L);


        assertEquals(resultado.getId().longValue(), lote.getId().longValue());
        assertEquals(resultado.getProduto(), produto);
    }

    @Test
    @DisplayName("Tentar recuperar lote que não existe no repositorio por meio do ID")
    void findInvalidTest() {


        RuntimeException thrown = assertThrows(
                RuntimeException.class, () -> driver.find(1L));

        assertEquals("Lote não existe no repositorio", thrown.getMessage());
    }

    @Test
    @DisplayName("Recuperar os lotes adicionados no repositorio.")
    void findAllTest() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(lote);
        driver.save(loteExtra);

        List<Lote> saidaEsperada = new ArrayList<>();
        saidaEsperada.add(lote);
        saidaEsperada.add(loteExtra);

        assertEquals(saidaEsperada, driver.findAll());

    }

    @Test
    @DisplayName("Adicionar o segundo Lote no repositorio de dados e depois deletá-lo")
    void deleteTest() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(lote);

        resultado = driver.save(loteExtra);
        driver.delete(loteExtra);

        assertEquals(driver.findAll().size(), 1);

    }

    @Test
    @DisplayName("Adicionar o segundo Lote no repositorio de dados e depois deletar todos os lotes")
    void deleteAllTest() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(lote);

        resultado = driver.save(loteExtra);
        driver.deleteAll();

        assertEquals(driver.findAll().size(), 0);
    }

}

