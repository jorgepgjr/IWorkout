package br.com.iworkout.db.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class User implements Serializable {

    @DatabaseField(generatedId = true)
    Long id;
    @DatabaseField
    String nome;

    public User() {
        // needed by ormlite
    }

    public User(String nome){
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
