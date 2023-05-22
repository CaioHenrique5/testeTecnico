package com.exercicio.assembleia_votacao.dto;

import javax.validation.constraints.NotNull;

import com.exercicio.assembleia_votacao.dto.builder.pautaDTOBuilder;
import com.exercicio.assembleia_votacao.dto.builder.votoDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {
    
    public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public Long getId_sessao_votacao() {
		return id_sessao_votacao;
	}

	public void setId_sessao_votacao(Long id_sessao_votacao) {
		this.id_sessao_votacao = id_sessao_votacao;
	}

	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}

	@NotNull(message = "O campo id_associado é obrigatório.")
	public Long idAssociado;
    
    @NotNull(message = "O campo id_sessao_votacao é obrigatório.")
    public Long id_sessao_votacao;
    
    @NotNull(message = "O campo voto é obrigatório.")
    public boolean voto;

	public static votoDTOBuilder builder() {
		return new votoDTOBuilder();
	}
    
}
