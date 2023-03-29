package com.psoft.atvprat2.service;

import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAlterarImplService implements ProdutoAlterarService {

    @Autowired
    ProdutoRepository<Produto, Long> produtoRepository;

    @Override
    public Produto alterar(Produto produtoalterado){
        if (produtoalterado.getPreco()<=0){
            throw new RuntimeException("Preço Inválido");
        }
        return produtoRepository.update(produtoalterado);
    }
}
