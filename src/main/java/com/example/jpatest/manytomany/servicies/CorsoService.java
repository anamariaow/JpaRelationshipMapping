package com.example.jpatest.manytomany.servicies;

import com.example.jpatest.manytomany.entities.Corso;
import com.example.jpatest.manytomany.repositories.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoService {
    @Autowired
    private CorsoRepository corsoRepository;

    public Corso addCorso(Corso corso) {
        return corsoRepository.save(corso);
    }

    public List<Corso> getListaCorsi() {
        return corsoRepository.findAll();
    }

    public Optional<Corso> getCorsoById(Long id) {
        return corsoRepository.findById(id);
    }

    public Optional<Corso> updateCorso(Long id, Corso corso) {
        Optional<Corso> corsoOpt = corsoRepository.findById(id);
        Corso corsoUpdate;
        if (corsoOpt.isPresent()) {
            corsoOpt.get().setNome(corso.getNome());
            corsoUpdate = corsoRepository.save(corsoOpt.get());
        } else {
            return Optional.empty();
        }
        return Optional.of(corsoUpdate);
    }

    public Optional<Corso> deleteCorsoById(Long id) {
        Optional<Corso> corsoOpt = corsoRepository.findById(id);
        if (corsoOpt.isPresent()) {
            corsoRepository.delete(corsoOpt.get());
            return corsoOpt;
        } else {
            return Optional.empty();
        }
    }
}
