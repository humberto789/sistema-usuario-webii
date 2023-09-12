package com.imd.humberto789.sistemausuariowebii.services.impl;

import com.imd.humberto789.sistemausuariowebii.repositories.UsuarioRepository;
import com.imd.humberto789.sistemausuariowebii.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username).get();
    }
}
