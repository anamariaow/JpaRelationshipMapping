package com.example.jpatest.onetomany.controllers;

import com.example.jpatest.onetomany.entities.Autore;
import com.example.jpatest.onetomany.servicies.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("/create")
    public ResponseEntity<Autore> createAutore(@RequestBody Autore autore) {
        return ResponseEntity.ok(autoreService.addAutore(autore));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Autore>> findAllAutore() {
        return ResponseEntity.ok(autoreService.getListaAutori());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Autore>> findByIdAutore(@RequestParam Long id) {
        Optional<Autore> autoreOpt = autoreService.getAutoreById(id);
        if (autoreOpt.isPresent()) {
            return ResponseEntity.ok(autoreOpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Autore> modifyAutore(@PathVariable Long id, @RequestBody Autore autore) {
        Optional<Autore> autoreOpt = autoreService.updateAutore(id, autore);
        if (autoreOpt.isPresent()) {
            return ResponseEntity.ok(autoreOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Autore> deleteAutore(Long id) {
        Optional<Autore> autoreOpt = autoreService.deleteAutoreById(id);
        if (autoreOpt.isPresent()) {
            return ResponseEntity.ok(autoreOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
