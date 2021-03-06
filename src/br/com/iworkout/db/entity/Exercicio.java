package br.com.iworkout.db.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "exercicio")
public class Exercicio implements Serializable {

    // id is generated by the database and set on the object automagically
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String nome;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Musculo musculo;

    public Exercicio() {
        // needed by ormlite
    }

    public Exercicio (String nome){
        this.nome = nome;
    }

    public Exercicio (String nome, Musculo musculo){
        this.nome = nome;
        this.musculo = musculo;
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

    public Musculo getMusculo() {
        return musculo;
    }

    public void setMusculo(Musculo musculo) {
        this.musculo = musculo;
    }
}
