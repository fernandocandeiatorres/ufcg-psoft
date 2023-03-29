package com.psoft.atvprat2.repository;

import com.psoft.atvprat2.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoVolatilRepository implements ProdutoRepository<Produto, Long>{
    @Override
    public Produto save(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produto find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Produto> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produto update(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Produto produto) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }
}
