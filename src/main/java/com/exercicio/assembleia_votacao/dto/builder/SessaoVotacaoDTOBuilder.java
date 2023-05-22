package com.exercicio.assembleia_votacao.dto.builder;

import com.exercicio.assembleia_votacao.dto.SessaoVotacaoDTO;

public class SessaoVotacaoDTOBuilder {
	private Long idPauta;
	private Integer tempoAberturaSessao;
	public SessaoVotacaoDTOBuilder idPauta(Long id) {
		this.idPauta = id;
		return this;
	}

	public SessaoVotacaoDTOBuilder tempoAberturaSessao(Integer diferencaEmMinutos) {
		this.tempoAberturaSessao = diferencaEmMinutos;
		return this;
	}

	public SessaoVotacaoDTO build() {
		SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO();
		sessaoVotacaoDTO.idPauta = this.idPauta;
		sessaoVotacaoDTO.tempoAberturaSessao = this.tempoAberturaSessao;
		return sessaoVotacaoDTO;
	}

}
