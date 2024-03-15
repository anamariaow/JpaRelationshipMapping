package com.example.jpatest.onetomany.servicies;

import com.example.jpatest.onetomany.entities.Libro;
import com.example.jpatest.onetomany.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro addLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> getListaLibri() {
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    public Optional<Libro> updateLibro(Long id, Libro libro) {
        Optional<Libro> libroOpt = libroRepository.findById(id);
        Libro libroUpdate;
        if (libroOpt.isPresent()) {
            libroOpt.get().setTitolo(libro.getTitolo());
            libroUpdate = libroRepository.save(libroOpt.get());
        } else {
            return Optional.empty();
        }
        return Optional.of(libroUpdate);
    }

    public Optional<Libro> deleteLibroById(Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);
        if (libroOpt.isPresent()) {
            libroRepository.delete(libroOpt.get());
            return libroOpt;
        } else {
            return Optional.empty();
        }
    }
}
