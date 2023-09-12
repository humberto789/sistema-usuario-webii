package com.imd.humberto789.sistemausuariowebii.controllers;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Pessoa;
import com.imd.humberto789.sistemausuariowebii.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> obterPessoaPorId(@PathVariable("id") Integer id){
        try{
            Pessoa pessoa = pessoaService.obterPorId(id);
            return ResponseEntity.ok(pessoa);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> obterTodasPessoas(){
        try{
            return ResponseEntity.ok(pessoaService.obterTodasPessoas());
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> cadastrarPessoa(@RequestBody Pessoa pessoa){
        try{
            return ResponseEntity.ok(pessoaService.cadastrar(pessoa));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> atualizarPessoa(@RequestBody Pessoa pessoa){
        try{
            return ResponseEntity.ok(pessoaService.cadastrar(pessoa));
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable("id") Integer id){
        try{
            pessoaService.excluirPorId(id);
            return ResponseEntity.ok("Pessoa excluida com sucesso");
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
