package com.nbratti.biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private List<Livro> livros;

    public Controller() {
        livros = new ArrayList<>();
        livros.add(new Livro(1,"The Hobbit", "J.R.R. Tolkien", 1937));
        livros.add(new Livro(2,"1984", "George Orwell", 1949));
        livros.add(new Livro(4,"1985", "George Orwell", 1949));
        livros.add(new Livro(3,"To Kill a Mockingbird", "Harper Lee", 1960));
    }
    @GetMapping
    @CrossOrigin("*")
    public String welcomeMessage() {
        return "Welcome to the Book API!";
    }

    @GetMapping("/books")
    @CrossOrigin
    public List<Livro> livros() {
        return livros;
    }

    @GetMapping("/livrosAutor")
    @CrossOrigin("*")
    public List<Livro> livrosAutor(@RequestParam("autor") String autor) {
        return (livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .toList());
    }
}