package com.example.demo.service;

import com.example.demo.dao.CidadeDao;
import com.example.demo.model.Cidade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class FakeCidadeAccessService implements CidadeDao {
    public static List<String> DB = new ArrayList<>();

    @Override
    public int insertCidade(Cidade cidade) {
        //DB.add(new Cidade(cidade.getIbge_id(),cidade.getUf(), cidade.getName(),cidade.getCapital(), cidade.getLon(), cidade.getLat(),cidade.getNo_accents(),cidade.getAlternative_names(),cidade.getMicroregion(),cidade.getMesoregion()));
        //DB.add(cidade.getIbge_id());
        return 0;
    }

    @Override
    public List<String> SelectAllCidade() {
        return DB;
    }

    @Override
    public int deleteCidadebyId(String id) {
        Optional<String> cidadeMaybe = selectCidadeById(id);
        if (cidadeMaybe.isEmpty()){
            return 0;
        }
        DB.remove(cidadeMaybe.get());
        return 1;
        }

    @Override
    public Optional<String> selectCidadeById(String id) {
        return Optional.empty();
    }

    /*@Override
    public Optional<String> selectCidadeById(String id) {
        return DB.stream()
                .filter(cidade -> cidade.getIbge_id().equals(id))
                .findFirst();
    }*/


}
