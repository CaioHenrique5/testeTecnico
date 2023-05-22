package com.exercicio.assembleia_votacao.dto;

import com.exercicio.assembleia_votacao.model.enums.VotoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class VotoResponseDTO {
    
	public VotoResponseDTO(Long idAssociado, VotoEnum voto) {
		super();
		this.idAssociado = idAssociado;
		this.voto = voto;
	}
	public Long getIdAssociado() {
		return idAssociado;
	}
	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}
	public VotoEnum getVoto() {
		return voto;
	}
	public void setVoto(VotoEnum voto) {
		this.voto = voto;
	}
	private Long idAssociado;
    private VotoEnum voto;
    
}
