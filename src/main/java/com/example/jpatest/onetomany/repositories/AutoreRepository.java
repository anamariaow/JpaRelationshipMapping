package com.example.jpatest.onetomany.repositories;

import com.example.jpatest.onetomany.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
}
