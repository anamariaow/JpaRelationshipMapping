package com.example.jpatest.onetoone.servicies;

import com.example.jpatest.onetoone.entities.Indirizzo;
import com.example.jpatest.onetoone.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndirizzoService {
    @Autowired
    private IndirizzoRepository indirizzoRepository;

    public Indirizzo addIndirizzo(Indirizzo indirizzo) {
        return indirizzoRepository.save(indirizzo);
    }

    public List<Indirizzo> getListaIndirizzi() {
        return indirizzoRepository.findAll();
    }

    public Optional<Indirizzo> getIndirizzoById(Long id) {
        return indirizzoRepository.findById(id);
    }

    public Optional<Indirizzo> updateIndirizzo(Long id, Indirizzo indirizzo) {
        Optional<Indirizzo> indirizzoOpt = indirizzoRepository.findById(id);
        Indirizzo indirizzoUpdate;
        if (indirizzoOpt.isPresent()) {
            indirizzoOpt.get().setVia(indirizzo.getCitta());
            indirizzoOpt.get().setVia(indirizzo.getVia());
            indirizzoUpdate = indirizzoRepository.save(indirizzoOpt.get());
        } else {
            return Optional.empty();
        }
        return Optional.of(indirizzoUpdate);
    }

    public Optional<Indirizzo> deleteIndirizzoById(Long id) {
        Optional<Indirizzo> indirizzoOpt = indirizzoRepository.findById(id);
        if (indirizzoOpt.isPresent()) {
            indirizzoRepository.delete(indirizzoOpt.get());
            return indirizzoOpt;
        } else {
            return Optional.empty();
        }
    }
}
