package br.com.iworkout.db.entity;


import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@DatabaseTable(tableName = "treino")
public class Treino implements Serializable{

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private Date valInic;

    @DatabaseField
    private Date valFim;

    @DatabaseField
    private String valQtd;

    @DatabaseField
    private Date dtInc;

    @DatabaseField
    private Date dtAlt;

    @ForeignCollectionField(columnName = "id")
    private ForeignCollection<Serie> series;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getValInic() {
        return valInic;
    }

    public void setValInic(Date valInic) {
        this.valInic = valInic;
    }

    public Date getValFim() {
        return valFim;
    }

    public void setValFim(Date valFim) {
        this.valFim = valFim;
    }

    public String getValQtd() {
        return valQtd;
    }

    public void setValQtd(String valQtd) {
        this.valQtd = valQtd;
    }

    public Date getDtInc() {
        return dtInc;
    }

    public void setDtInc(Date dtInc) {
        this.dtInc = dtInc;
    }

    public ForeignCollection<Serie> getSeries() {
        return series;
    }

    public void setSeries(ForeignCollection<Serie> series) {
        this.series = series;
    }

    public Date getDtAlt() {
        return dtAlt;
    }

    public void setDtAlt(Date dtAlt) {
        this.dtAlt = dtAlt;
    }
}
