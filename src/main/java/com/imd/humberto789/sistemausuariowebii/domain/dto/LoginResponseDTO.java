package com.imd.humberto789.sistemausuariowebii.domain.dto;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Usuario;

public class LoginResponseDTO {
    private String token;

    private Usuario usuario;

    public LoginResponseDTO(){

    }

    public LoginResponseDTO(String token, Usuario usuario) {
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
