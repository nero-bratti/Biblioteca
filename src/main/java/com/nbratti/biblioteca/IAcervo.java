package com.nbratti.biblioteca;

import java.util.List;


public interface IAcervo {
    public List<Livro> livrosDoAcervo();
    public List<String> autoresDoAcervo();
    public List<Livro> livrosDoAutor(String autor);
    public List<Livro> livrosPorAno(int ano);
    public void cadastrarLivro(int id, String titulo, String autor, int ano);
    public void cadastrarUsuario(int id, String nome, String senha);
    public void removerUsuario(int id);
    public boolean existeUsuario(int id);
}
