package com.exercicio.assembleia_votacao.dto.builder;

import javax.validation.constraints.NotNull;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.dto.VotoDTO;

public class votoDTOBuilder {
	

    private Long idAssociado;
    
    private Long id_sessao_votacao;
    
    private boolean voto;

	public votoDTOBuilder idAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
		return this;
	}
	public votoDTOBuilder id_sessao_votacao(Long idSessaoVotacao) {
		this.id_sessao_votacao = idSessaoVotacao;
		return this;
	}
	public votoDTOBuilder voto(boolean voto) {
		this.voto = voto;
		return this;
	}
	public VotoDTO build() {
		VotoDTO dto = new VotoDTO();
		dto.idAssociado = this.idAssociado;
		dto.id_sessao_votacao = this.id_sessao_votacao;
		dto.voto = this.voto;
		return dto;
	}
}
