package com.imd.humberto789.sistemausuariowebii.services.impl;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Pessoa;
import com.imd.humberto789.sistemausuariowebii.repositories.PessoaRepository;
import com.imd.humberto789.sistemausuariowebii.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa cadastrar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa obterPorId(Integer id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        if(pessoaRepository.findById(pessoa.getId()).isPresent()){
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    @Override
    public void excluirPorId(Integer id) {
        if(pessoaRepository.findById(id).isPresent()){
            pessoaRepository.deleteById(id);
        }
    }

    @Override
    public List<Pessoa> obterTodasPessoas() {
        return pessoaRepository.findAll();
    }
}
