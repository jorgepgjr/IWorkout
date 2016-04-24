package br.com.iworkout.db.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "serie")
public class Serie implements Serializable{

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private Long qtd;

    @DatabaseField
    private Long repiticoes;

    @DatabaseField
    private String intervalo;

    @DatabaseField
    private Long carga;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Exercicio exercicio;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Treino treino;

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

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }
}