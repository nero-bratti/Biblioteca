package com.nbratti.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
}