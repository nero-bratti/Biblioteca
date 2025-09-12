package com.nbratti.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Usuario {

    private String nome;
    private String senha;
    private int autoridade;
}
