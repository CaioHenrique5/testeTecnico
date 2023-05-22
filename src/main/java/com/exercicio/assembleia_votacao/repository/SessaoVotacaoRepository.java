package com.exercicio.assembleia_votacao.repository;

import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {
    
    @Query(value = "SELECT * FROM sessao_votacao sv WHERE sv.pauta_id = :pauta_id", nativeQuery = true)
    Optional<SessaoVotacao> findSessaoVotacaoByPautaId(@Param("pauta_id") Long pautaId); 
        
    Optional<SessaoVotacao> findByPautaId(Long pautaId);
    
    List<SessaoVotacao> findByDataFimGreaterThanAndDataInicioLessThanEqual(LocalDateTime dataFinal, LocalDateTime dataInicio);
    
}
