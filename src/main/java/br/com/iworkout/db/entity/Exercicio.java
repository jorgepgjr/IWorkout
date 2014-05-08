package br.com.iworkout.db.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exercicio")
public class Exercicio implements Serializable {

    // id is generated by the database and set on the object automagically
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "exercicio", fetch = FetchType.EAGER)
    private List<Musculo> musculos;

    public Exercicio() {
        // needed by ormlite
    }

    public Exercicio (String nome){
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

    public List<Musculo> getMusculos() {
        return musculos;
    }

    public void setMusculos(List<Musculo> musculos) {
        this.musculos = musculos;
    }
}
