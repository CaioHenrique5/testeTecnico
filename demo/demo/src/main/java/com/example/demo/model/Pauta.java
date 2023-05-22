package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Long sessionId;

    private int votosSim;
	private int votosNao;


    public Pauta() {
        this.votosSim = 0;
        this.votosNao = 0;
    }
    
    public String obterResultadoVotacao() {
        if (votosSim > votosNao) {
            return "Aprovada";
        } else if (votosSim < votosNao) {
            return "Reprovada";
        } else {
            return "Empate";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
    public int getVotosSim() {
		return votosSim;
	}

	public void setVotosSim(int votosSim) {
		this.votosSim = votosSim;
	}

	public int getVotosNao() {
		return votosNao;
	}

	public void setVotosNao(int votosNao) {
		this.votosNao = votosNao;
	}
}
