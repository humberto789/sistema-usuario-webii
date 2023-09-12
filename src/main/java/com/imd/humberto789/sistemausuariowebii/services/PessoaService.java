package com.imd.humberto789.sistemausuariowebii.services;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Pessoa;

import java.util.List;

public interface PessoaService {
    Pessoa cadastrar(Pessoa pessoa);

    Pessoa obterPorId(Integer id);

    Pessoa atualizar(Pessoa pessoa);

    void excluirPorId(Integer id);

    List<Pessoa> obterTodasPessoas();
}
