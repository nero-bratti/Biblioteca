package com.nbratti.biblioteca.service;

import com.nbratti.biblioteca.model.Livro;
import com.nbratti.biblioteca.repository.AcervoRepositoryPostgre;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {

    private final AcervoRepositoryPostgre acervo;

    public LivroService(AcervoRepositoryPostgre acervo) {
        this.acervo = acervo;
    }

    public void cadastrar(Livro livro) {
        acervo.cadastrarLivro(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAno());
    }

    public List<Livro> listar() {
        return acervo.livrosDoAcervo();
    }

    public List<Livro> buscarPorAutor(String autor) {
        return acervo.livrosDoAutor(autor);
    }

    public void deletar(int id) {
        acervo.removerLivro(id);
    }
}
