package com.example.jpatest.manytomany.repositories;

import com.example.jpatest.manytomany.entities.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {
}
