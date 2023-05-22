package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}
