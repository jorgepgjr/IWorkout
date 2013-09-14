package br.com.iworkout.db.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long qtd;

    @Column
    private Long repiticoes;

    @Column
    private String intervalo;

    @Column
    private Long carga;

    @OneToOne(mappedBy = "exercicio", fetch = FetchType.EAGER)
    private Exercicio exercicio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQtd() {
        return qtd;
    }

    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    public Long getRepiticoes() {
        return repiticoes;
    }

    public void setRepiticoes(Long repiticoes) {
        this.repiticoes = repiticoes;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public Long getCarga() {
        return carga;
    }

    public void setCarga(Long carga) {
        this.carga = carga;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }
}