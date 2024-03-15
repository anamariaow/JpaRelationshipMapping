package com.example.jpatest.onetoone.repositories;

import com.example.jpatest.onetoone.entities.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {



}
