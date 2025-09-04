package com.nbratti.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private List<Livro> livros;

    public Controller() {
        livros = new ArrayList<>();
        livros.add(new Livro(1,"The Hobbit", "J.R.R. Tolkien", 1937));
        livros.add(new Livro(2,"1984", "George Orwell", 1949));
        livros.add(new Livro(3,"To Kill a Mockingbird", "Harper Lee", 1960));
        livros.add(new Livro(4,"Pride and Prejudice", "Jane Austen", 1813));
        livros.add(new Livro(5,"The Great Gatsby", "F. Scott Fitzgerald", 1925));
        livros.add(new Livro(6,"Moby-Dick", "Herman Melville", 1851));
        livros.add(new Livro(7,"War and Peace", "Leo Tolstoy", 1869));
        livros.add(new Livro(8,"Crime and Punishment", "Fyodor Dostoevsky", 1866));
        livros.add(new Livro(9,"Brave New World", "Aldous Huxley", 1932));
        livros.add(new Livro(10,"The Catcher in the Rye", "J.D. Salinger", 1951));
        livros.add(new Livro(11,"The Lord of the Rings", "J.R.R. Tolkien", 1954));
        livros.add(new Livro(12,"One Hundred Years of Solitude", "Gabriel García Márquez", 1967));
        livros.add(new Livro(13,"The Divine Comedy", "Dante Alighieri", 1320));

    }
    @GetMapping
    @CrossOrigin("*")
    public String welcomeMessage() {
        return "Bem vindo a Biblioteca";
    }

    @GetMapping("/acervo")
    @CrossOrigin
    public List<Livro> acervo() {
        return livros;
    }

    @GetMapping("/autoresDoAcervo")
    @CrossOrigin("*")
    public List<String> autoresDoAcervo() {
        return (livros.stream()
                .map(Livro::getAutor)
                .collect(Collectors.toList()));
    }

    @GetMapping("/livrosDoAutor")
    @CrossOrigin("*")
    public List<Livro> livrosDoAutor(@RequestParam("autor") String autor) {
        return (livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .toList());
    }
    @GetMapping("/livrosDoAno")
    @CrossOrigin("*")
    public List<Livro> livrosDoAutor(@RequestParam("ano") int ano) {
        return (livros.stream()
                .filter(livro -> livro.getAno() == ano)
                .toList());
    }
}