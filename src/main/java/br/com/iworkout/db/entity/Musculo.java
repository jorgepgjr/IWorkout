package br.com.iworkout.db.entity;


import com.j256.ormlite.field.DatabaseField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Musculo {

    @Id
    @GeneratedValue
    Long id;
    @Column
    String nome;

    public Musculo() {
        // needed by ormlite
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
}
