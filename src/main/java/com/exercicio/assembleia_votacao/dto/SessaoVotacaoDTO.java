package com.exercicio.assembleia_votacao.dto;

import javax.validation.constraints.NotNull;

import com.exercicio.assembleia_votacao.dto.builder.SessaoVotacaoDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessaoVotacaoDTO    {
    
    public int getTEMPO_DEFAULT() {
		return TEMPO_DEFAULT;
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public Integer getTempoAberturaSessao() {
		return tempoAberturaSessao;
	}

	public void setTempoAberturaSessao(Integer tempoAberturaSessao) {
		this.tempoAberturaSessao = tempoAberturaSessao;
	}

	private final int TEMPO_DEFAULT = 1;
    
    @NotNull(message = "O campo id_pauta é obrigatório.")
    public Long idPauta;  
    
    public Integer tempoAberturaSessao;

	public static SessaoVotacaoDTOBuilder builder() {
		return null;
	}
    
}
