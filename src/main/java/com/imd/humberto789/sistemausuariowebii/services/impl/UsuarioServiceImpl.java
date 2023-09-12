package com.imd.humberto789.sistemausuariowebii.services.impl;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Papel;
import com.imd.humberto789.sistemausuariowebii.domain.entity.Usuario;
import com.imd.humberto789.sistemausuariowebii.repositories.PessoaRepository;
import com.imd.humberto789.sistemausuariowebii.repositories.UsuarioRepository;
import com.imd.humberto789.sistemausuariowebii.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Usuario cadastrar(Usuario usuario) {

        if(usuario.getPessoa() != null){
            if(usuario.getPessoa().getId() == null
             || pessoaRepository.findById(usuario.getPessoa().getId()).isEmpty()){
                usuario.setPessoa(pessoaRepository.save(usuario.getPessoa()));
            }

            String senhaEncriptada = new BCryptPasswordEncoder().encode(usuario.getSenha());
            usuario.setSenha(senhaEncriptada);

            return usuarioRepository.save(usuario);
        }

        return null;
    }

    @Override
    public Usuario obterPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        if(usuarioRepository.findById(usuario.getId()).isPresent()){
            usuario.setPessoa(pessoaRepository.save(usuario.getPessoa()));
            return usuarioRepository.save(usuario);
        }else{
            return null;
        }
    }

    @Override
    public void excluirPorId(Integer id) {
        if(usuarioRepository.findById(id).isPresent()){
            usuarioRepository.deleteById(id);
        }
    }

    @Override
    public List<Usuario> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obterUsuarioPorEmailESenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
    }
}
