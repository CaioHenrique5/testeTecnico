package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.PautaRepository;

@Entity
public class Voto {
	
    @Autowired
    private PautaRepository pautaRepository;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long associadoId;
    private Long pautaId;
    private String voto;
    private String cpf;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAssociadoId() {
        return associadoId;
    }
    
    public void setAssociadoId(Long associadoId) {
        this.associadoId = associadoId;
    }
    
    public Long getPautaId() {
        return pautaId;
    }
    
    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }
    
    public String getVoto() {
        return voto;
    }
    
    public void setVoto(String voto) {
        this.voto = voto;
    }


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

    public Long getSessionId(Long pautaId) {
        if (pautaId == null) {
            return null;
        }
        Pauta pauta = pautaRepository.findById(pautaId).orElse(null);
        if (pauta == null) {
            return null;
        }
        return pauta.getSessionId();
    }

}
