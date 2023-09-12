package com.imd.humberto789.sistemausuariowebii.controllers;

import com.imd.humberto789.sistemausuariowebii.config.security.TokenService;
import com.imd.humberto789.sistemausuariowebii.domain.dto.AuthenticationDTO;
import com.imd.humberto789.sistemausuariowebii.domain.dto.LoginResponseDTO;
import com.imd.humberto789.sistemausuariowebii.domain.dto.UsuarioDTO;
import com.imd.humberto789.sistemausuariowebii.domain.entity.Usuario;
import com.imd.humberto789.sistemausuariowebii.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getSenha());
        Authentication auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token, (Usuario) auth.getPrincipal()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterUsuarioPorId(@PathVariable("id") Integer id){
        try{
            Usuario usuario = usuarioService.obterPorId(id);
            return ResponseEntity.ok(usuario);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> obterTodosUsuarios(){
        try{
            return ResponseEntity.ok(usuarioService.obterTodosUsuarios());
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try{

            Usuario usuario = usuarioDTO.obterEntidadeUsuario();

            return ResponseEntity.ok(usuarioService.cadastrar(usuario));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){

        Usuario usuario = usuarioDTO.obterEntidadeUsuario();

        try{
            return ResponseEntity.ok(usuarioService.atualizar(usuario));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable("id") Integer id){
        try{
            usuarioService.excluirPorId(id);
            return ResponseEntity.ok("Usuario excluido com sucesso");
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
