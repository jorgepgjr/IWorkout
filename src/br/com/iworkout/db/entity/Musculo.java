package br.com.iworkout.db.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Musculo implements Serializable {

    @DatabaseField(generatedId = true)
    Long id;
    @DatabaseField
    String nome;
    @ForeignCollectionField(columnName = "id")
    private Collection<Exercicio> exercicios;

    public Musculo() {
        // needed by ormlite
    }

    public Collection<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(Collection<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public Musculo (String nome){
        this.nome = nome;
    }

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
}
