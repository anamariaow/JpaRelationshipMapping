package com.example.jpatest.onetomany.servicies;

import com.example.jpatest.onetomany.entities.Autore;
import com.example.jpatest.onetomany.repositories.AutoreRepository;
import com.example.jpatest.onetoone.entities.Indirizzo;
import com.example.jpatest.onetoone.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public Autore addAutore(Autore autore) {
        return autoreRepository.save(autore);
    }

    public List<Autore> getListaAutori() {
        return autoreRepository.findAll();
    }

    public Optional<Autore> getAutoreById(Long id) {
        return autoreRepository.findById(id);
    }

    public Optional<Autore> updateAutore(Long id, Autore autore) {
        Optional<Autore> autoreOpt = autoreRepository.findById(id);
        Autore autoreUpdate;
        if (autoreOpt.isPresent()) {
            autoreOpt.get().setNome(autore.getNome());
            autoreUpdate = autoreRepository.save(autoreOpt.get());
        } else {
            return Optional.empty();
        }
        return Optional.of(autoreUpdate);
    }

    public Optional<Autore> deleteAutoreById(Long id) {
        Optional<Autore> autoreOpt = autoreRepository.findById(id);
        if (autoreOpt.isPresent()) {
            autoreRepository.delete(autoreOpt.get());
            return autoreOpt;
        } else {
            return Optional.empty();
        }
    }
}
