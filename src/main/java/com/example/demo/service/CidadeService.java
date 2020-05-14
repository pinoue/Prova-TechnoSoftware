package com.example.demo.service;
import com.example.demo.dao.CidadeDao;
import com.example.demo.model.Cidade;
import com.example.demo.repository.CidadeRespository;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class CidadeService {
    public CidadeRespository cidadeRespository;
    public CidadeDao cidadeDao;

    @Autowired
    CidadeRespository respository;

    public int addCidade(Cidade cidade){
        return cidadeDao.insertCidade(cidade);
    }

    public List<String> getAllCidade(){
        return cidadeDao.SelectAllCidade();
    }

    public List<Cidade> getCidadeById(int id){
        return cidadeRespository.findByibgeid(id);
    }

    public List<Cidade> getCidadeByUF(String uf){
        return respository.findByUfIgnoreCase(uf);
    }

    public List<Cidade> getCidadeByName(String name){
        return cidadeRespository.findByName(name);
    }

    public List<Cidade> getCapital(String capital){
        return cidadeRespository.findByCapitalIgnoreCase(capital);
    }

    public JSONObject getMaiorMenorNumeroCidadePorEstado(){
        JSONObject json1 = respository.findByMaiorNumeroCidadesPorEstado();
        JSONObject json2 = respository.findByMenorNumeroCidadesPorEstado();
        JSONObject combined = new JSONObject();

        combined.put("Estado com mais cidades", json1);
        combined.put("Estado com menos cidades", json2);
        return combined;
    }

    public List<JSONObject> getNumeroCidadePorEstado(){
        return respository.findNumeroCidadesPorEstado();
    }

    public int deleteCidade(String id){
        return cidadeDao.deleteCidadebyId(id);

    }

    public JSONObject getRegistroPorColuna(String columnName){
        return respository.countPorColuna(columnName);
    }

    public JSONObject getTotalRegistros(){
        return respository.totalRegistros();
    }

}
