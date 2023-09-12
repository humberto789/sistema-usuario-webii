package com.imd.humberto789.sistemausuariowebii.services;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Papel;

import java.util.List;

public interface PapelService {
    Papel cadastrar(Papel papel);

    Papel obterPorId(Integer id);

    Papel atualizar(Papel papel);

    void excluirPorId(Integer id);

    List<Papel> obterTodosPapeis();
}
