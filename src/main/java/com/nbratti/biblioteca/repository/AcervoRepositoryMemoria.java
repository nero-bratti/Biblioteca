package com.nbratti.biblioteca.repository;

import com.nbratti.biblioteca.interfaces.IAcervoRepository;
import com.nbratti.biblioteca.model.Usuario;
import com.nbratti.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AcervoRepositoryMemoria implements IAcervoRepository {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public AcervoRepositoryMemoria() {
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
        usuarios.add(new Usuario("Bibliotecario", "123",1));
        usuarios.add(new Usuario("Usuario 1", "1", 0));
        usuarios.add(new Usuario("Usuario 2", "2", 0));
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
    public boolean cadastrarLivro(int id, String titulo, String autor, int ano) {
        livros.add(new Livro(id,titulo,autor,ano));
        return true;
    }

    @Override
    public boolean removerLivro(int id) {
        return false;
    }

    @Override
    public boolean cadastrarUsuario(String nome, String senha, int autoridade) {
        usuarios.add(new Usuario(nome, senha, autoridade));
        return true;
    }

    @Override
    public boolean removerUsuario(String nome) {
        usuarios.removeIf(u -> u.getNome().equals(nome));
        return true;
    }

    @Override
    public boolean existeUsuario(String nome) {
        if (usuarios.stream().anyMatch(u -> u.getNome().equals(nome))) {
            return true;
        } else return false;
    }


}
