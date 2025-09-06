package com.nbratti.biblioteca;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class Acervo implements IAcervo {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Acervo() {
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

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "Bibliotecario", "123"));
        usuarios.add(new Usuario(2, "Usuario 1", "1"));
        usuarios.add(new Usuario(3, "Usuario 2", "2"));
    }

    @Override
    public List<Livro> livrosDoAcervo() {
        return livros;
    }

    @Override
    public List<String> autoresDoAcervo() {
        return (livrosDoAcervo().stream()
                .map(Livro::getAutor)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Livro> livrosDoAutor(String autor) {
        return (livrosDoAcervo().stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .toList());
    }

    @Override
    public List<Livro> livrosPorAno(int ano) {
        return (livrosDoAcervo().stream()
                .filter(livro -> livro.getAno() == ano)
                .toList());
    }

    @Override
    public void cadastrarLivro(int id, String titulo, String autor, int ano) {
        livros.add(new Livro(id,titulo,autor,ano));
    }

    @Override
    public void cadastrarUsuario(int id, String nome, String senha) {
        usuarios.add(new Usuario(id,nome,senha));
    }

    @Override
    public void removerUsuario(int id) {
        usuarios.remove(id);
    }

    @Override
    public boolean existeUsuario(int id) {
        if (usuarios.contains(id)) return true;
        return false;
    }


}
