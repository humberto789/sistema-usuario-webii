package com.imd.humberto789.sistemausuariowebii.repositories;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario>{

    Optional<Usuario> findByEmailAndSenha(String email, String senha);

    Optional<Usuario> findByEmail(String email);
}
