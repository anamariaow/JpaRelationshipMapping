package com.example.jpatest.onetomany.controllers;

import com.example.jpatest.onetomany.entities.Libro;
import com.example.jpatest.onetomany.servicies.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/create")
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.addLibro(libro));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Libro>> findAllLibri() {
        return ResponseEntity.ok(libroService.getListaLibri());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Libro>> findByIdLibro(@RequestParam Long id) {
        Optional<Libro> libroOpt = libroService.getLibroById(id);
        if (libroOpt.isPresent()) {
            return ResponseEntity.ok(libroOpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Libro> modifyLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Optional<Libro> libroOpt = libroService.updateLibro(id, libro);
        if (libroOpt.isPresent()) {
            return ResponseEntity.ok(libroOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Libro> deleteLibro(Long id) {
        Optional<Libro> libroOpt = libroService.deleteLibroById(id);
        if (libroOpt.isPresent()) {
            return ResponseEntity.ok(libroOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
