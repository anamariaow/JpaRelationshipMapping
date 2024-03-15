package com.example.jpatest.manytomany.repositories;

import com.example.jpatest.manytomany.entities.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {
}
