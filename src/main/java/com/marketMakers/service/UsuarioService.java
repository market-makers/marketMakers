package com.marketMakers.service;

import com.marketMakers.model.Produto;
import com.marketMakers.model.Usuario;
import com.marketMakers.repository.ProdutoRepository;
import com.marketMakers.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Iterable<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }
}