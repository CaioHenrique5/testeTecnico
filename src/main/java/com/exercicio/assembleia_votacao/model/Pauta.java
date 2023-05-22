package com.exercicio.assembleia_votacao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.exercicio.assembleia_votacao.dto.builder.pautaDTOBuilder;
import com.exercicio.assembleia_votacao.model.builder.pautaBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pauta")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pauta implements Serializable {
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
       
	public String descricao; 
    
    public Pauta(Long idPauta) {
        this.id = idPauta;
    }
    public Pauta() {
    }

	public static pautaBuilder builder() {
		return new pautaBuilder();
	}
 
}
