package com.nbratti.biblioteca.controlers;

import java.util.List;

import com.nbratti.biblioteca.interfaces.IAcervoRepository;
import com.nbratti.biblioteca.model.Livro;

import com.nbratti.biblioteca.model.UserRoles;
import com.nbratti.biblioteca.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private IAcervoRepository acervo;

    @Autowired
    public Controller(IAcervoRepository acervo) {
        this.acervo = acervo;
    }

    //Mensagem de boas vindas (T)
    @GetMapping
    @CrossOrigin("*")
    public String mensagemDeBoasVindas() {
        return "Bem vindo a Biblioteca";
    }

    //Consultar todos os livros do acervo (A)
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/livros")
    @CrossOrigin
    public List<Livro> acervo() {
        return acervo.livrosDoAcervo();
    }

    //Consultar os livros de um determinado autor (A)
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/livros/autor")
    @CrossOrigin("*")
    public List<Livro> livrosDoAutor(@RequestParam("autor") String autor) {
        return acervo.livrosDoAutor(autor);
    }

    //Consultar os livros de um determinado ano (A)
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/livros/ano")
    @CrossOrigin("*")
    public List<Livro> livrosPorAno(@RequestParam("ano") int ano) {
        return acervo.livrosPorAno(ano);
    }

    //Cadastrar um novo livro (B)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/livros/cadastro")
    @CrossOrigin("*")
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        acervo.cadastrarLivro(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAno());
        return ResponseEntity.ok(livro);
    }

    //Cadastrar um novo usuário (T)
    @PostMapping("/cadastro")
    @CrossOrigin("*")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getSenha() == null || usuario.getLogin() == null) {
            return ResponseEntity.badRequest().body("Login ou senha não informados");
        }

        acervo.cadastrarUsuario(
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getAuthorities()
        );

        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }
}