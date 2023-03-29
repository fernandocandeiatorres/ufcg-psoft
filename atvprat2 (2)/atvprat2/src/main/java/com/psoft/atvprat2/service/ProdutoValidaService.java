package com.psoft.atvprat2.service;

import com.psoft.atvprat2.model.Produto;

@FunctionalInterface
public interface ProdutoValidaService {
    boolean validaCodigo(Produto produto);
}
