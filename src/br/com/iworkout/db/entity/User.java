package br.com.iworkout.db.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.sql.Date;

@DatabaseTable(tableName = "user")
public class User implements Serializable {

    // id is generated by the database and set on the object automagically
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private Date dataNascimento;

    @DatabaseField
    private String imageProfile;

    public User() {
        // needed by ormlite
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }
}
