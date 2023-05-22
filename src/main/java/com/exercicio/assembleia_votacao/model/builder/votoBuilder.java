package com.exercicio.assembleia_votacao.model.builder;

import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.model.Voto;
import com.exercicio.assembleia_votacao.model.enums.VotoEnum;

public class votoBuilder {

	private Long idAssociado;
	private SessaoVotacao sessaoVotacao;
	private VotoEnum voto;

	public votoBuilder idAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
		return this;
	}

	public votoBuilder sessaoVotacao(SessaoVotacao sessaoVotacao) {
		this.sessaoVotacao = sessaoVotacao;
		return this;
	}

	public votoBuilder voto(VotoEnum voto) {
		this.voto = voto;
		return this;
	}

	public Voto build() {
		Voto voto = new Voto();
		voto.voto = this.voto;
		voto.idAssociado = this.idAssociado;
		voto.sessaoVotacao = this.sessaoVotacao;
		return voto;
	}

}
