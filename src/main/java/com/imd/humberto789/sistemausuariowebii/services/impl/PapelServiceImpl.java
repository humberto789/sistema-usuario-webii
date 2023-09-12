package com.imd.humberto789.sistemausuariowebii.services.impl;

import com.imd.humberto789.sistemausuariowebii.domain.entity.Papel;
import com.imd.humberto789.sistemausuariowebii.repositories.PapelRepository;
import com.imd.humberto789.sistemausuariowebii.services.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PapelServiceImpl implements PapelService {

    @Autowired
    private PapelRepository papelRepository;

    @Override
    public Papel cadastrar(Papel papel) {
        return papelRepository.save(papel);
    }

    @Override
    public Papel obterPorId(Integer id) {
        return papelRepository.findById(id).orElse(null);
    }

    @Override
    public Papel atualizar(Papel papel) {
        if(papelRepository.findById(papel.getId()).isPresent()){
            return papelRepository.save(papel);
        }
        return null;
    }

    @Override
    public void excluirPorId(Integer id) {
        if(papelRepository.findById(id).isPresent()){
            papelRepository.deleteById(id);
        }
    }

    @Override
    public List<Papel> obterTodosPapeis() {
        return papelRepository.findAll();
    }
}
