package com.exercicio.assembleia_votacao.dto;

import com.exercicio.assembleia_votacao.dto.builder.pautaDTOBuilder;

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
public class PautaDTO {
    
    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String descricao;

	public PautaDTO() {
	}

	public static pautaDTOBuilder builder() {
		return new pautaDTOBuilder();
	}
  
}