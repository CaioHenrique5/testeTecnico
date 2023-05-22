package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.dto.VotoDTO;
import com.exercicio.assembleia_votacao.mapper.VotoMapper;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.model.Voto;
import com.exercicio.assembleia_votacao.repository.SessaoVotacaoRepository;
import com.exercicio.assembleia_votacao.repository.VotoRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    
    @Autowired
    VotoRepository votoRepository;
    
    @Autowired
    SessaoVotacaoRepository sessaoVotacaoRepository;
    
    public Voto salvarVoto(VotoDTO votoDTO){
               
        Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoRepository.findById(votoDTO.getId_sessao_votacao());            
        if(sessaoVotacao.isEmpty())
            throw new IllegalArgumentException("Sessão não existe.");          
        else{
            LocalDateTime dataAtual = LocalDateTime.now(); 
            if(sessaoVotacao.get().getDataFim().isBefore(dataAtual) || sessaoVotacao.get().getDataInicio().isAfter(dataAtual))
               throw new IllegalArgumentException("Sessão fechada para votos.");      
            else{
                Optional<Voto> votoProcurado = votoRepository.findByidAssociadoEqualsAndSessaoVotacaoIdEquals(votoDTO.getIdAssociado(),votoDTO.getId_sessao_votacao());       
                if(votoProcurado.isPresent())               
                    throw new IllegalArgumentException("Voto já registrado na Sessão.");                
                else{
                    return votoRepository.save(VotoMapper.dtoParaVoto(votoDTO, sessaoVotacao.get()));
                }                   
            }       
        }          
    }
    
}
