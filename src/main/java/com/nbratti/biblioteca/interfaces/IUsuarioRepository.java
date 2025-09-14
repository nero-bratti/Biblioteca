package com.nbratti.biblioteca.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepository {
    UserDetails findByLogin(String login);
}
