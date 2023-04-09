package com.psoft.atvprat2.controller;

import com.psoft.atvprat2.model.Produto;
import com.psoft.atvprat2.service.ProdutoAlterarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value="/v1/produtos/",
        produces = MediaType.APPLICATION_JSON_VALUE
)

public class ProdutoV1Controller {
    @Autowired
    ProdutoAlterarService produtoAlterarService;



    @PutMapping("/{id}")
    public Produto updateProduct(
            @PathVariable Long id,
            @RequestBody Produto produto) {
        return produtoAlterarService.alterar(produto);
    }

}