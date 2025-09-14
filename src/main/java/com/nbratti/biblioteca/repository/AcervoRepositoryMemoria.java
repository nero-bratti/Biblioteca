package com.nbratti.biblioteca.repository;

import com.nbratti.biblioteca.interfaces.IAcervoRepository;
import com.nbratti.biblioteca.model.Livro;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Primary
@Repository
public class AcervoRepositoryMemoria implements IAcervoRepository {
    private List<Livro> livros;

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
        livros.add(new Livro(14,"The Silmarillion", "J.R.R. Tolkien", 1977));
        livros.add(new Livro(15,"Animal Farm", "George Orwell", 1945));
        livros.add(new Livro(16,"Sense and Sensibility", "Jane Austen", 1811));
        livros.add(new Livro(17,"Emma", "Jane Austen", 1815));
        livros.add(new Livro(18,"The Brothers Karamazov", "Fyodor Dostoevsky", 1880));
        livros.add(new Livro(19,"Notes from Underground", "Fyodor Dostoevsky", 1864));
        livros.add(new Livro(20,"Go Set a Watchman", "Harper Lee", 2015));
        livros.add(new Livro(21,"Tender Is the Night", "F. Scott Fitzgerald", 1934));
        livros.add(new Livro(22,"The Adventures of Tom Sawyer", "Mark Twain", 1876));
        livros.add(new Livro(23,"Adventures of Huckleberry Finn", "Mark Twain", 1884));
        livros.add(new Livro(24,"Anna Karenina", "Leo Tolstoy", 1877));
        livros.add(new Livro(25,"Meditations", "Marcus Aurelius", 180));
        livros.add(new Livro(26,"Frankenstein", "Mary Shelley", 1818));
        livros.add(new Livro(27,"Dracula", "Bram Stoker", 1897));
        livros.add(new Livro(28,"Fahrenheit 451", "Ray Bradbury", 1953));
        livros.add(new Livro(29,"Dune", "Frank Herbert", 1965));
        livros.add(new Livro(30,"The Trial", "Franz Kafka", 1925));
    }

    @Override
    public List<Livro> livrosDoAcervo() {
        return livros;
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
    public boolean cadastrarUsuario(String nome, String senha, Collection<? extends GrantedAuthority> roles) {
        return true;
    }
}
