package com.exercicio.assembleia_votacao.model.builder;

import java.time.LocalDateTime;

import com.exercicio.assembleia_votacao.dto.builder.SessaoVotacaoDTOBuilder;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;

public class SessaoVotacaoBuilder {

	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private Pauta pauta;

	public SessaoVotacaoBuilder dataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
		return this;
	}

	public SessaoVotacaoBuilder dataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
		return this;
	}

	public SessaoVotacaoBuilder pauta(Pauta pauta) {
		this.pauta = pauta;
		return this;
	}

	public SessaoVotacao build() {
		SessaoVotacao sessaoVotacao = new SessaoVotacao();
		sessaoVotacao.dataFim = this.dataFim;
		sessaoVotacao.dataInicio = this.dataInicio;
		sessaoVotacao.pauta = this.pauta;
		return sessaoVotacao;
	}

}
