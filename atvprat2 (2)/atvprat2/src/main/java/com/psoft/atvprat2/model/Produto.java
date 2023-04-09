package com.psoft.atvprat2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="produtos")
public class Produto {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("preco")
    @Column(nullable = false)
    private double preco;

    @JsonProperty("codigoBarra")
    @Column(nullable = false)
    private String codigoBarra;

    @JsonProperty("fabricante")
    @Column(nullable = false)
    private String fabricante;

}