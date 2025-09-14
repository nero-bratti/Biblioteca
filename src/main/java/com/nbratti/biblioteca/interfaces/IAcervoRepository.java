package com.nbratti.biblioteca.interfaces;

import java.util.Collection;
import java.util.List;

import com.nbratti.biblioteca.model.Livro;
import org.springframework.security.core.GrantedAuthority;


public interface IAcervoRepository {

    //Consultar todos os livros do acervo (A)
    List<Livro> livrosDoAcervo();
    //Consultar os livros de um determinado autor (A)
    List<Livro> livrosDoAutor(String autor);
    //Consultar os livros de um determinado ano (A)
    List<Livro> livrosPorAno(int ano);
    //Cadastrar um novo livro (B)
    boolean cadastrarLivro(int id, String titulo, String autor, int ano);
    //Cadastrar um novo usuário (T)
    boolean cadastrarUsuario(String nome, String senha, Collection<? extends GrantedAuthority> roles);
}
