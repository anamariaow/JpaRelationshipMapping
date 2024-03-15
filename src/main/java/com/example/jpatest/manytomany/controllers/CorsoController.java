package com.example.jpatest.manytomany.controllers;

import com.example.jpatest.manytomany.entities.Corso;
import com.example.jpatest.manytomany.servicies.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/corso")
public class CorsoController {
    @Autowired
    private CorsoService corsoService;

    @PostMapping("/create")
    public ResponseEntity<Corso> createCorso(@RequestBody Corso corso) {
        return ResponseEntity.ok(corsoService.addCorso(corso));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Corso>> findAllCorso() {
        return ResponseEntity.ok(corsoService.getListaCorsi());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Corso>> findByIdCorso(@RequestParam Long id) {
        Optional<Corso> corsoOpt = corsoService.getCorsoById(id);
        if (corsoOpt.isPresent()) {
            return ResponseEntity.ok(corsoOpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Corso> modifyStudente(@PathVariable Long id, @RequestBody Corso corso) {
        Optional<Corso> corsoOpt = corsoService.updateCorso(id, corso);
        if (corsoOpt.isPresent()) {
            return ResponseEntity.ok(corsoOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Corso> deleteStudente(Long id) {
        Optional<Corso> studenteOpt = corsoService.deleteCorsoById(id);
        if (studenteOpt.isPresent()) {
            return ResponseEntity.ok(studenteOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
