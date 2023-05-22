package com.exercicio.assembleia_votacao.dto;

import com.exercicio.assembleia_votacao.model.enums.StatusPautaEnum;
import com.exercicio.assembleia_votacao.model.enums.StatusSessaoVotacaoEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoPautaDTO {
    
    public List<VotoResponseDTO> getListaVotos() {
		return listaVotos;
	}

	public void setListaVotos(List<VotoResponseDTO> listaVotos) {
		this.listaVotos = listaVotos;
	}

	public StatusSessaoVotacaoEnum getStatusSessao() {
		return statusSessao;
	}

	public void setStatusSessao(StatusSessaoVotacaoEnum statusSessao) {
		this.statusSessao = statusSessao;
	}

	public StatusPautaEnum getStatusPauta() {
		return statusPauta;
	}

	public void setStatusPauta(StatusPautaEnum statusPauta) {
		this.statusPauta = statusPauta;
	}

	private List<VotoResponseDTO> listaVotos;
    
    private StatusSessaoVotacaoEnum statusSessao; 
    
    private StatusPautaEnum statusPauta; 
    
}
