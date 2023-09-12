package com.imd.humberto789.sistemausuariowebii.domain.dto;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Papel;
import com.imd.humberto789.sistemausuariowebii.domain.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private Integer id;

    private String email;
    private String senha;
    private String nome;

    private List<Papel> permissoes = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Papel> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Papel> permissoes) {
        this.permissoes = permissoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario obterEntidadeUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.getPessoa().setNome(this.nome);
        usuario.setPermissoes(this.permissoes);
        usuario.setId(this.id);

        return usuario;
    }
}
