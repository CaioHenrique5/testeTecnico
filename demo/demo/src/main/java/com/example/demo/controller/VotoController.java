package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Pauta;
import com.example.demo.model.Voto;
import com.example.demo.repository.PautaRepository;
import com.example.demo.repository.VotoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/votos")
public class VotoController {
    
	
	@Autowired
    private VotoRepository votoRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private PautaRepository pautaRepository;

    @PostMapping
    public ResponseEntity<String> registrarVoto(@RequestBody Voto voto) {

        if (votoRepository.existsByPautaIdAndAssociadoId(voto.getPautaId(), voto.getAssociadoId())) {
            return ResponseEntity.badRequest().body("O associado já votou nesta pauta.");
        }
        ResponseEntity<String> response = restTemplate.getForEntity("https://user-info.herokuapp.com/users/{cpf}", String.class, voto.getCpf());
        if (response.getStatusCode().is2xxSuccessful() && response.getBody().equalsIgnoreCase("ABLE_TO_VOTE")) {
            Optional<Pauta> optionalPauta = pautaRepository.findById(voto.getPautaId());
            
            if (optionalPauta.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Pauta pauta = optionalPauta.get();
            if (pauta.getSessionId() == null) {
                return ResponseEntity.badRequest().body("A sessão de votação está encerrada.");
            }

            if (voto.getVoto().equalsIgnoreCase("sim")) {
                pauta.setVotosSim(pauta.getVotosSim() + 1);
            } else if (voto.getVoto().equalsIgnoreCase("nao")) {
                pauta.setVotosNao(pauta.getVotosNao() + 1);
            }

            pautaRepository.save(pauta);
            votoRepository.save(voto);

            return ResponseEntity.ok("Voto registrado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("UNABLE_TO_VOTE");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Voto>> listarVotos() {
        List<Voto> votos = votoRepository.findAll();
        return new ResponseEntity<>(votos, HttpStatus.OK);
    }
    
}
