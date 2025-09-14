package com.nbratti.biblioteca.repository;

import com.nbratti.biblioteca.interfaces.IAcervoRepository;
import com.nbratti.biblioteca.model.Livro;

import com.nbratti.biblioteca.model.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Repository
public class AcervoRepositoryPostgre implements IAcervoRepository {
    private JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AcervoRepositoryPostgre(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Livro> livrosDoAcervo() {
    List<Livro> resp = this.jdbcTemplate.query("SELECT * from livros",
            (rs, rowNum) ->
                new Livro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"), rs.getInt("ano")));
        return resp;
    }

    @Override
    public List<Livro> livrosDoAutor(String autor) {
        String sql = "SELECT * FROM livros WHERE autor = ?";
        return jdbcTemplate.query(sql,
                new Object[]{autor},
                (rs, rowNum) ->
                        new Livro(rs.getInt("id"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("ano")));
    }

    @Override
    public List<Livro> livrosPorAno(int ano) {
        String sql = "SELECT * FROM livros WHERE ano = ?";
        return jdbcTemplate.query(sql,
                new Object[]{ano},
                (rs, rowNum) ->
                        new Livro(rs.getInt("id"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("ano")));
    }

    @Override
    public boolean cadastrarLivro(int id, String titulo, String autor, int ano) {
        jdbcTemplate.update(
                "INSERT INTO livros(id, titulo, autor, ano) VALUES (?, ?, ?, ?)",
                id,
                titulo,
                autor,
                ano
        );
        return true;
    }

    @Override
    public boolean cadastrarUsuario(String login, String senha, Collection<? extends GrantedAuthority> authorities) {
        // Criptografa a senha
        String senhaCriptografada = passwordEncoder.encode(senha);

        // Converte authorities em uma String separada por vírgula
        String rolesStr = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        // Insere no banco
        jdbcTemplate.update(
                "INSERT INTO usuarios (login, senha, roles) VALUES (?, ?, ?)",
                login, senhaCriptografada, rolesStr
        );

        return true;
    }
}
