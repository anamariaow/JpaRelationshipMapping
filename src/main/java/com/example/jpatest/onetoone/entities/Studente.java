package com.example.jpatest.onetoone.entities;

import com.example.jpatest.onetoone.entities.Indirizzo;
import jakarta.persistence.*;

@Entity
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne
    @JoinColumn(name = "indirizzo_id")
    private Indirizzo indirizzo;

    public Studente(Long id, String nome, Indirizzo indirizzo) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
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

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
}
