package com.example.jpatest.manytomany.servicies;

import com.example.jpatest.manytomany.entities.Studente;
import com.example.jpatest.manytomany.repositories.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {
    @Autowired
    private StudenteRepository studenteRepository;

    public Studente addStudente(Studente studente) {
        return studenteRepository.save(studente);
    }

    public List<Studente> getListaStudenti() {
        return studenteRepository.findAll();
    }

    public Optional<Studente> getStudenteById(Long id) {
        return studenteRepository.findById(id);
    }

    public Optional<Studente> updateStudente(Long id, Studente studente) {
        Optional<Studente> studenteOpt = studenteRepository.findById(id);
        Studente studenteUpdate;
        if (studenteOpt.isPresent()) {
            studenteOpt.get().setNome(studente.getNome());
            studenteUpdate = studenteRepository.save(studenteOpt.get());
        } else {
            return Optional.empty();
        }
        return Optional.of(studenteUpdate);
    }

    public Optional<Studente> deleteStudenteById(Long id) {
        Optional<Studente> studenteOpt = studenteRepository.findById(id);
        if (studenteOpt.isPresent()) {
            studenteRepository.delete(studenteOpt.get());
            return studenteOpt;
        } else {
            return Optional.empty();
        }
    }
}
