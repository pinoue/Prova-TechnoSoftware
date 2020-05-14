package com.example.demo.api;

import com.example.demo.model.Cidade;
import com.example.demo.repository.CidadeRespository;
import com.example.demo.service.CidadeService;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("api/v1/cidade")
@RestController
public class CidadeController {

    private final CidadeRespository cidadeRespository;

    @Autowired
    private final CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeRespository cidadeRespository, CidadeService cidadeService) {
        this.cidadeRespository = cidadeRespository;
        this.cidadeService = cidadeService;
    }

    @GetMapping("/CarregarBanco")
    public void carregarBanco() {
        // Hashmap to map CSV data to
        // Bean attributes.
        Map<String, String> mapping = new HashMap<String, String>();
        //ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion
        mapping.put("ibge_id", "ibgeid");
        mapping.put("uf", "uf");
        mapping.put("name", "name");
        mapping.put("capital", "capital");
        mapping.put("lon", "lon");
        mapping.put("lat", "lat");
        mapping.put("no_accents", "no_accents");
        mapping.put("alternative_names", "alternative_names");
        mapping.put("microregion", "microregion");
        mapping.put("mesoregion", "mesoregion");

        // HeaderColumnNameTranslateMappingStrategy
        // for Student class
        HeaderColumnNameTranslateMappingStrategy<Cidade> strategy =
                new HeaderColumnNameTranslateMappingStrategy<Cidade>();
        strategy.setType(Cidade.class);
        strategy.setColumnMapping(mapping);

        // Create castobaen and csvreader object
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader("doc\\BackEnd.csv"));
        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        // call the parse method of CsvToBean
        // pass strategy, csvReader to parse method
        List<Cidade> list = csvToBean.parse(strategy, csvReader);

        // print details of Bean object
        for (Cidade e : list) {
            cidadeRespository.save(e);
        }

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCidade(@RequestBody Cidade cidade) {
        cidadeRespository.save(cidade);

    }

    @GetMapping
    public List<Cidade> getAllCidade() {
        return (List<Cidade>) cidadeRespository.findAll();
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable("id") int id) {
        Optional<Cidade> cidadedata = cidadeRespository.findById(id);
        if (cidadedata.isPresent()) {
            return new ResponseEntity<>(cidadedata.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path = "/ByName/{name}")
    public ResponseEntity<List<Cidade>> getCidadeByName(@PathVariable("name") String name) {
        List<Cidade> cidadedata = cidadeRespository.findByName(name);
        if (cidadedata.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(cidadedata, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/Capital")
    public List<Cidade> getCapital() {
        return (List<Cidade>) cidadeRespository.findByCapitalIgnoreCase("True");
    }

    @DeleteMapping(path = "/DeleteById/{id}")
    public ResponseEntity<HttpStatus> deleteCidadeById(@PathVariable("id") int id) {
        try {
            cidadeRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/MaiorMenorNumeroCidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getMaioMenorNumeroCidadePorEstado() throws SQLException {
        JSONObject json = cidadeService.getMaiorMenorNumeroCidadePorEstado();
        return new ResponseEntity(json, HttpStatus.OK);
        //return new ResponseEntity(cidadeRespository.findByMenorNumeroCidadesPorEstado(), HttpStatus.OK);
    }

    @GetMapping(path = "/numeroCidadeEstado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> getNumeroCidadeEstado(){
        return new ResponseEntity(cidadeService.getNumeroCidadePorEstado(),HttpStatus.OK);
    }

    @GetMapping(path = "/cidadePorUF/{uf}")
    public ResponseEntity<List<Cidade>> getCidadeUF(@PathVariable("uf") String uf){
        List<Cidade> cidadedata = cidadeService.getCidadeByUF(uf);
        if (cidadedata.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(cidadedata, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/registroPorColuna/{coluna}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getCountPorColuna(@PathVariable("coluna") String columnName){
        JSONObject json = cidadeService.getRegistroPorColuna(columnName);
        return new ResponseEntity(json,HttpStatus.OK);
    }

    @GetMapping(path = "/totalRegistros", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getTotalRegistros(){
        JSONObject json = cidadeService.getTotalRegistros();
        return new ResponseEntity(json,HttpStatus.OK);
    }
}


