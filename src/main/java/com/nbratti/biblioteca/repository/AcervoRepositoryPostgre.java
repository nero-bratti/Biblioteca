package com.nbratti.biblioteca.repository;

import com.nbratti.biblioteca.interfaces.IAcervoRepository;
import com.nbratti.biblioteca.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class AcervoRepositoryPostgre implements IAcervoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AcervoRepositoryPostgre(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Livro> livrosDoAcervo() {
    List<Livro> resp = this.jdbcTemplate.query("SELECT * from livros",
            (rs, rowNum) ->
                new Livro(rs.getInt("codigo"),rs.getString("titulo"),rs.getString("autor"), rs.getInt("ano")));
        return resp;
    }

    @Override
    public List<String> autoresDoAcervo() {
        return List.of();
    }

    @Override
    public List<Livro> livrosDoAutor(String autor) {
        return List.of();
    }

    @Override
    public List<Livro> livrosPorAno(int ano) {
        return List.of();
    }

    @Override
    public void cadastrarLivro(int id, String titulo, String autor, int ano) {
        Livro livro = new Livro(id, titulo, autor, ano);
        this.jdbcTemplate.update(
                "INSERT INTO livros(codigo,titulo,autor,ano) VALUES (?,?,?,?)",
                livro.getId(),livro.getTitulo(),livro.getAutor(),livro.getAno());
    }

    @Override
    public void cadastrarUsuario(int id, String nome, String senha) {

    }

    @Override
    public void removerUsuario(int id) {

    }

    @Override
    public boolean existeUsuario(int id) {
        return false;
    }

    @Override
    public boolean removerLivro(long codigo){
        this.jdbcTemplate.update("DELETE FROM livros WHERE codigo = ?", codigo);
        return true;
    }
}
