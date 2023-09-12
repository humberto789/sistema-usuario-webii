package com.imd.humberto789.sistemausuariowebii.services;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario cadastrar(Usuario usuario);

    Usuario obterPorId(Integer id);

    Usuario atualizar(Usuario usuario);

    void excluirPorId(Integer id);

    List<Usuario> obterTodosUsuarios();

    Usuario obterUsuarioPorEmailESenha(String email, String senha);
}
