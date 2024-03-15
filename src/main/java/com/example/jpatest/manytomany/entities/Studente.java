package com.example.jpatest.manytomany.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany
    @JoinTable(name = "iscrizioni",
            joinColumns = @JoinColumn(name = "studente_id"),
            inverseJoinColumns = @JoinColumn(name = "corso_id"))
    private List<Corso> corsi;

    public Studente(Long id, String nome, List<Corso> corsi) {
        this.id = id;
        this.nome = nome;
        this.corsi = corsi;
    }

    public Studente() {
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

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }
}