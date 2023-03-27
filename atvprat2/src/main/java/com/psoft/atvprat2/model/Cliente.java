package com.psoft.atvprat2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {
    private Long id;

    private Long cpf;

    private String nome;

    private Integer idade;

    private String endereco;
}
