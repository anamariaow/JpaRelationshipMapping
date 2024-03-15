package com.example.jpatest.manytomany.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "corsi")
    private List<Studente> studenti;

    public Corso(Long id, String nome, List<Studente> studenti) {
        this.id = id;
        this.nome = nome;
        this.studenti = studenti;
    }

    public Corso() {
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

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }
}
