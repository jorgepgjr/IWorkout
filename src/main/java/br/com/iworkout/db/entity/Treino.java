package br.com.iworkout.db.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "treino")
public class Treino {

    @Id
    private int id;

    @Column
    private String nome;

    @Column
    private Date valInic;

    @Column
    private Date valFim;

    @Column
    private String valQtd;

    @OneToMany(mappedBy = "serie", fetch = FetchType.EAGER)
    private List<Serie> series;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
