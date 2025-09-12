package com.nbratti.biblioteca.domain.interfaces;

import java.util.List;

import com.nbratti.biblioteca.domain.model.Livro;


public interface IAcervoRepository {

    List<Livro> livrosDoAcervo();
    List<String> autoresDoAcervo();

    List<Livro> livrosDoAutor(String autor);
    List<Livro> livrosPorAno(int ano);

    boolean cadastrarLivro(int id, String titulo, String autor, int ano);
    boolean removerLivro(int id);

    boolean cadastrarUsuario(String nome, String senha, int autoridade);
    boolean removerUsuario(String nome);
    boolean existeUsuario(String nome);
}
