package com.marketMakers.repository;

import com.marketMakers.model.Promocao;
import com.marketMakers.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
}
