package br.com.iworkout.db.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Metrics implements Serializable {

    @DatabaseField(generatedId = true)
    Long id;
    @DatabaseField
    Integer peso;
    @DatabaseField
    Integer altura;
    @DatabaseField
    String sexo;
    @DatabaseField
    Integer braco;
    @DatabaseField
    Integer antebraco;
    @DatabaseField
    Integer peitoral;
    @DatabaseField
    Integer cintura;
    @DatabaseField
    Integer quadril;
    @DatabaseField
    Integer coxa;

    public Metrics() {
        // needed by ormlite
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getBraco() {
        return braco;
    }

    public void setBraco(Integer braco) {
        this.braco = braco;
    }

    public Integer getAntebraco() {
        return antebraco;
    }

    public void setAntebraco(Integer antebraco) {
        this.antebraco = antebraco;
    }

    public Integer getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(Integer peitoral) {
        this.peitoral = peitoral;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Integer getQuadril() {
        return quadril;
    }

    public void setQuadril(Integer quadril) {
        this.quadril = quadril;
    }

    public Integer getCoxa() {
        return coxa;
    }

    public void setCoxa(Integer coxa) {
        this.coxa = coxa;
    }
}
