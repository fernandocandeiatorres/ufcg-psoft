package com.psoft.atvprat2.repository;

import com.psoft.atvprat2.model.Produto;

import java.util.List;

public interface ProdutoRepository<T, ID> {
    T save(T produto);
    T find(ID id);

    List<T> findAll();
    Produto update(T produto);
    void delete(T produto);
    void deleteAll();
}
