package com.nbratti.biblioteca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private IAcervo acervo;

    @Autowired
    public Controller(IAcervo acervo) {
        this.acervo = acervo;
    }

    @GetMapping
    @CrossOrigin("*")
    public String mensagemDeBoasVindas() {
        return "Bem vindo a Biblioteca";
    }

    @GetMapping("/acervo")
    @CrossOrigin
    public List<Livro> acervo() {
        return acervo.livrosDoAcervo();
    }

    @GetMapping("/autoresDoAcervo")
    @CrossOrigin("*")
    public List<String> autoresDoAcervo() {
        return acervo.autoresDoAcervo();
    }

    @GetMapping("/livrosDoAutor")
    @CrossOrigin("*")
    public List<Livro> livrosDoAutor(@RequestParam("autor") String autor) {
        return acervo.livrosDoAutor(autor);
    }

    @GetMapping("/livrosDoAno")
    @CrossOrigin("*")
    public List<Livro> livrosPorAno(@RequestParam("ano") int ano) {
        return acervo.livrosPorAno(ano);
    }

    @GetMapping("/cadastrarLivro")
    @CrossOrigin("*")
    public void cadastrarLivro(@RequestParam("id") int id,
                               @RequestParam("titulo") String titulo,
                               @RequestParam("autor") String autor,
                               @RequestParam("ano") int ano) {
        acervo.cadastrarLivro(id, titulo, autor, ano);
    }
}