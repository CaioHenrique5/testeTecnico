package com.exercicio.assembleia_votacao.model.builder;

import com.exercicio.assembleia_votacao.model.Pauta;

public class pautaBuilder {

	private String descricao;

	public pautaBuilder descricao(String descricao) {
		descricao = this.descricao;
		return this;
	}

	public Pauta build() {
		Pauta pauta = new Pauta();
		pauta.descricao = this.descricao;
		return pauta;
	}

}
