package com.example.demo.dao;

import com.example.demo.model.Cidade;

import java.util.List;
import java.util.Optional;

public interface CidadeDao {

    int insertCidade (Cidade cidade);

    List<String> SelectAllCidade();

    int deleteCidadebyId(String id);

    Optional<String> selectCidadeById(String id);
}

