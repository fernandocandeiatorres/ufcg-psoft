package com.psoft.atvprat2.service;

import com.psoft.atvprat2.model.Produto;

@FunctionalInterface
public interface ProdutoAlterarService {
    Produto alterar(Produto produtoAlterado);
}
