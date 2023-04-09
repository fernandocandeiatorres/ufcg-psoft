package com.psoft.atvprat2.utils;

public class TestUtils {
    public static Produto criarProduto(Long id, String nome, String fabricante, String codigoDeBarras, Double preco){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setId(id);
        produto.setCodigoBarra(codigoDeBarras);
        produto.setFabricante(fabricante);
        return produto;
    }
}
