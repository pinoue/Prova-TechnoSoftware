package com.example.demo.repository;

import com.example.demo.model.Cidade;
import net.minidev.json.JSONObject;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.List;

@Repository
public interface CidadeRespository extends JpaRepository<Cidade, Integer> {

    List<Cidade> findByibgeid(int ibgeid);
    List<Cidade> findByName(String name);
    List<Cidade> findByCapitalIgnoreCase(String capital);
    List<Cidade> findByUfIgnoreCase(String uf);


    @Query(value = "SELECT c.uf, COUNT(c.ibgeid) as Cidades FROM cidade c GROUP BY c.uf ORDER BY COUNT(c.ibgeid) DESC LIMIT 1;",nativeQuery = true)
    //@Query(value = "SELECT uf FROM Cidade;",nativeQuery = true)
    JSONObject findByMaiorNumeroCidadesPorEstado();

    @Query(value = "SELECT c.uf, COUNT(c.ibgeid) as Cidades FROM Cidade c GROUP BY c.uf ORDER BY COUNT(c.ibgeid) LIMIT 1;", nativeQuery = true)
    JSONObject findByMenorNumeroCidadesPorEstado();

    @Query(value = "SELECT c.uf, COUNT(c.ibgeid) as Cidades FROM Cidade c GROUP BY c.uf;", nativeQuery = true)
    List<JSONObject>findNumeroCidadesPorEstado();

    @Query(value = "SELECT COUNT(DISTINCT (?1)) FROM Cidade c", nativeQuery = true)
    JSONObject countPorColuna(String columnName);

    @Query(value = "SELECT COUNT(ibgeid) FROM Cidade", nativeQuery = true)
    JSONObject totalRegistros();

}
