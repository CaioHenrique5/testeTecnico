package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

	boolean existsBySessionIdAndAssociadoId(Long sessionId, Long associadoId);

	boolean existsByPautaIdAndAssociadoId(Long pautaId, Long associadoId);
	
}