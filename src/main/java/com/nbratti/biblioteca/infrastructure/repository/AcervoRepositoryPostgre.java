package com.nbratti.biblioteca.infrastructure.repository;

import com.nbratti.biblioteca.domain.interfaces.IAcervoRepository;
import com.nbratti.biblioteca.domain.model.Livro;

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
                new Livro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"), rs.getInt("ano")));
        return resp;
    }

    @Override
    public List<String> autoresDoAcervo() {
        String sql = "SELECT DISTINCT autor FROM livros ORDER BY autor";
        return jdbcTemplate.queryForList(sql, String.class);
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
    public boolean cadastrarLivro(int id, String titulo, String autor, int ano) {
        Livro livro = new Livro(id, titulo, autor, ano);
        this.jdbcTemplate.update(
                "INSERT INTO livros(id,titulo,autor,ano) VALUES (?,?,?,?)",
                livro.getId(),livro.getTitulo(),livro.getAutor(),livro.getAno());
        return true;
    }

    @Override
    public boolean cadastrarUsuario(String nome, String senha, int autoridade) {
        this.jdbcTemplate.update("INSERT INTO usuarios (nome,senha,autoridade) VALUES (?,?,?)"
        ,nome,senha,autoridade);
        return true;
    }

    @Override
    public boolean removerUsuario(String nome) {
        return this.jdbcTemplate.update("DELETE FROM usuarios WHERE nome = ?", nome) > 0;
    }

    @Override
    public boolean existeUsuario(String nome) {
        return false;
    }

    @Override
    public boolean removerLivro(int id){
        this.jdbcTemplate.update("DELETE FROM livros WHERE id = ?", id);
        return true;
    }
}
