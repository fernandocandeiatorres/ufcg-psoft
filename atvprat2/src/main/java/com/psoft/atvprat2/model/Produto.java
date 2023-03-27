package com.psoft.atvprat2.model;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produto {

    private Long id;

    private String nome;

    private double preco;

    private String codigoBarra;

    private String fabricante;

}

