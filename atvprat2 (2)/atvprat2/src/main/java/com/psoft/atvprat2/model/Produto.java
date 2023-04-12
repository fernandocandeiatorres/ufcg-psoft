package com.psoft.atvprat2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("preco")
    private double preco;

    @JsonProperty("codigoBarra")
    private String codigoBarra;

    @JsonProperty("fabricante")
    private String fabricante;
}