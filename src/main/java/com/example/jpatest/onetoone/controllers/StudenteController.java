package com.example.jpatest.onetoone.controllers;

import com.example.jpatest.onetoone.entities.Studente;
import com.example.jpatest.onetoone.servicies.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studente")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("/create")
    public ResponseEntity<Studente> createStudente(@RequestBody Studente studente) {
        return ResponseEntity.ok(studenteService.addStudente(studente));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Studente>> findAllStudente() {
        return ResponseEntity.ok(studenteService.getListaStudenti());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Studente>> findByIdStudente(@RequestParam Long id) {
        Optional<Studente> studenteOpt = studenteService.getStudenteById(id);
        if (studenteOpt.isPresent()) {
            return ResponseEntity.ok(studenteOpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Studente> modifyStudente(@PathVariable Long id, @RequestBody Studente studente) {
        Optional<Studente> studenteOpt = studenteService.updateStudente(id, studente);
        if (studenteOpt.isPresent()) {
            return ResponseEntity.ok(studenteOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Studente> deleteStudente(Long id) {
        Optional<Studente> studenteOpt = studenteService.deleteStudenteById(id);
        if (studenteOpt.isPresent()) {
            return ResponseEntity.ok(studenteOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
