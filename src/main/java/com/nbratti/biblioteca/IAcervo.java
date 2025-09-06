package com.nbratti.biblioteca;

import java.util.List;


public interface IAcervo {
    public List<Livro> livrosDoAcervo();
    public List<String> autoresDoAcervo();
    public List<Livro> livrosDoAutor(String autor);
    public List<Livro> livrosPorAno(int ano);
}
