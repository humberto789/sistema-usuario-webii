package com.imd.humberto789.sistemausuariowebii.controllers;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Papel;
import com.imd.humberto789.sistemausuariowebii.services.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/papeis")
public class PapelController {

    @Autowired
    private PapelService papelService;

    @GetMapping("/{id}")
    public ResponseEntity<?> obterPapelPorId(@PathVariable("id") Integer id){
        try{
            Papel papel = papelService.obterPorId(id);
            return ResponseEntity.ok(papel);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> obterTodosPapeis(){
        try{
            return ResponseEntity.ok(papelService.obterTodosPapeis());
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> cadastrarPapel(@RequestBody Papel papel){
        try{
            return ResponseEntity.ok(papelService.cadastrar(papel));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> atualizarPapel(@RequestBody Papel papel){
        try{
            return ResponseEntity.ok(papelService.cadastrar(papel));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPapel(@PathVariable("id") Integer id){
        try{
            papelService.excluirPorId(id);
            return ResponseEntity.ok("Papel excluido com sucesso");
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
