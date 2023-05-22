package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.dto.SessaoVotacaoDTO;
import com.exercicio.assembleia_votacao.mapper.SessaoVotacaoMapper;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.repository.SessaoVotacaoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoVotacaoService {
    
    @Autowired
    SessaoVotacaoRepository sessaoVotacaoRepository;
    
    @Autowired
    PautaService pautaService;
    
    public SessaoVotacao salvarSessaoVotacao (SessaoVotacaoDTO sessaoVotacaoDTO){      
        
        Optional<SessaoVotacao> verificaSeExiste = sessaoVotacaoRepository.findByPautaId(sessaoVotacaoDTO.getIdPauta());
        
        if(verificaSeExiste.isPresent())
            throw new IllegalArgumentException("Sessão já existe");     
        else{
            Optional<Pauta> pautaReferida = pautaService.getPautaById(sessaoVotacaoDTO.getIdPauta());
            if(pautaReferida.isEmpty()){
                throw new IllegalArgumentException("Pauta não existe");
            }
            else{
                return sessaoVotacaoRepository.save(SessaoVotacaoMapper.dtoParaNovaSessaoVotacao(sessaoVotacaoDTO, pautaReferida.get()));
            }
        }
    }
    
    public List<SessaoVotacao> buscarSessoes(){ 
        return sessaoVotacaoRepository.findAll();
    }
    
    public List<SessaoVotacao> buscarSessoesAbertas(){   
        LocalDateTime dataAtual = LocalDateTime.now();
        return sessaoVotacaoRepository.findByDataFimGreaterThanAndDataInicioLessThanEqual(dataAtual,dataAtual);
    }
}
