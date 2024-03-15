package com.example.jpatest.onetoone.controllers;

import com.example.jpatest.onetoone.entities.Indirizzo;
import com.example.jpatest.onetoone.servicies.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/indirizzo")
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    @PostMapping("/create")
    public ResponseEntity<Indirizzo> createIndirizzo(@RequestBody Indirizzo indirizzo) {
        return ResponseEntity.ok(indirizzoService.addIndirizzo(indirizzo));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Indirizzo>> findAllIndirizzo() {
        return ResponseEntity.ok(indirizzoService.getListaIndirizzi());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Indirizzo>> findByIdIndirizzo(@RequestParam Long id) {
        Optional<Indirizzo> indirizzoOpt = indirizzoService.getIndirizzoById(id);
        if (indirizzoOpt.isPresent()) {
            return ResponseEntity.ok(indirizzoOpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Indirizzo> modifyIndirizzo(@PathVariable Long id, @RequestBody Indirizzo indirizzo) {
        Optional<Indirizzo> indirizzoOpt = indirizzoService.updateIndirizzo(id, indirizzo);
        if (indirizzoOpt.isPresent()) {
            return ResponseEntity.ok(indirizzoOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Indirizzo> deleteIndirizzo(Long id) {
        Optional<Indirizzo> indirizzoOpt = indirizzoService.deleteIndirizzoById(id);
        if (indirizzoOpt.isPresent()) {
            return ResponseEntity.ok(indirizzoOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
