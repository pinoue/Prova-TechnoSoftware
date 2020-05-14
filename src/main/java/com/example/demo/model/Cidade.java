package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cidade implements Serializable {
    @Id
    private  Integer ibgeid ;
    private  String uf;
    private  String name;
    private  String capital;
    private  String lon;
    private  String lat;
    private  String no_accents;
    private  String alternative_names;
    private  String microregion;
    private  String mesoregion;


    public Cidade(@JsonProperty("ibgeid") int ibgeid, @JsonProperty("uf") String uf, @JsonProperty("name") String name,
                  @JsonProperty("capital") String capital, @JsonProperty("lon") String lon, @JsonProperty("lat") String lat,
                  @JsonProperty("no_accents") String no_accents, @JsonProperty("alternative_names") String alternative_names,
                  @JsonProperty("microregion")String microregion, @JsonProperty("mesoregion") String mesoregion) {
        this.ibgeid = ibgeid;
        this.uf = uf;
        this.name = name;
        this.capital = capital;
        this.lon = lon;
        this.lat = lat;
        this.no_accents = no_accents;
        this.alternative_names = alternative_names;
        this.microregion = microregion;
        this.mesoregion = mesoregion;
    }

    public Cidade() {
    }

    public int getIbgeid() {
        return ibgeid;
    }

    public void setIbgeid(int ibgeid) {
        this.ibgeid = ibgeid;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getNo_accents() {
        return no_accents;
    }

    public void setNo_accents(String no_accents) {
        this.no_accents = no_accents;
    }

    public String getAlternative_names() {
        return alternative_names;
    }

    public void setAlternative_names(String alternative_names) {
        this.alternative_names = alternative_names;
    }

    public String getMicroregion() {
        return microregion;
    }

    public void setMicroregion(String microregion) {
        this.microregion = microregion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }
}
