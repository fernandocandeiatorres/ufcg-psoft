package com.psoft.atvprat2.controller;

import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.service.ProdutoAlterarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/v1/produtos",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProdutoV1Controller {

    @Autowired
    ProdutoAlterarService produtoAtualizarService;

    @PutMapping("/{id}")
    public Produto atualizarProduto(
            @PathVariable Long id,
            @RequestBody Produto produto) {
        return produtoAtualizarService.alterar(produto);
    }
}