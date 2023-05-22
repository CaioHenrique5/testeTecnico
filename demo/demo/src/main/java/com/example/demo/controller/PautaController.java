package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Pauta;
import com.example.demo.model.Session;
import com.example.demo.repository.PautaRepository;
import com.example.demo.repository.SessionRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/pautas")
public class PautaController {
	@Autowired
    private PautaRepository pautaRepository;
	@Autowired
    private SessionRepository sessionRepository;

    @PostMapping("/{pautaId}/abrir-sessao")
    public ResponseEntity<?> abrirSessaoVotacao(@PathVariable Long pautaId,
                                                @RequestParam(required = false) Integer duracaoMinutos) {
        Optional<Pauta> optionalPauta = pautaRepository.findById(pautaId);
        if (optionalPauta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pauta pauta = optionalPauta.get();

        if (pauta.getSessionId() != null) {
            return ResponseEntity.badRequest().body("Já existe uma sessão de votação aberta para esta pauta.");
        }

        int duracao = duracaoMinutos != null ? duracaoMinutos : 1;
        LocalDateTime dataEncerramento = LocalDateTime.now().plusMinutes(duracao);
        Session session = new Session();
        session.setPauta(pauta);
        session.setDataHoraFechamento(dataEncerramento);
        
        sessionRepository.save(session);
        pauta.setSessionId(session.getId());
        pautaRepository.save(pauta);
        Map<String, Long> response = new HashMap<>();
        response.put("sessionId", session.getId());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{pautaId}/resultado")
    public ResponseEntity<?> obterResultadoVotacao(@PathVariable Long pautaId) {
        Optional<Pauta> optionalPauta = pautaRepository.findById(pautaId);
        if (optionalPauta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pauta pauta = optionalPauta.get();

        if (pauta.getSessionId() != null) {
            return ResponseEntity.badRequest().body("A sessão de votação ainda está aberta. Aguarde o encerramento para obter o resultado.");
        }

        String resultado = pauta.obterResultadoVotacao();

        return ResponseEntity.ok(resultado);
    }
}
