package com.exercicio.assembleia_votacao.dto.builder;

import com.exercicio.assembleia_votacao.dto.PautaDTO;

public class pautaDTOBuilder{
		private String descricao;
		
		public pautaDTOBuilder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		
		public PautaDTO build() {
			PautaDTO dto = new PautaDTO();
			dto.descricao = this.descricao;
			return dto;
		}
	}