package com.psoft.atvprat2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lote {

    private Long id;

    private Produto produto;

    private int numeroDeItens;

}

