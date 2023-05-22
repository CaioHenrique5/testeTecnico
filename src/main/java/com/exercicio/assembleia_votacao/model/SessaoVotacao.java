package com.exercicio.assembleia_votacao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.exercicio.assembleia_votacao.model.builder.SessaoVotacaoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sessao_votacao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SessaoVotacao implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id; 
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	@NotNull(message = "O campo id_pauta é obrigatório.")
    @OneToOne
    @JoinColumn(name = "pauta_id")
	public Pauta pauta;
             
	public LocalDateTime dataInicio; 
    
	public LocalDateTime dataFim;

	public static SessaoVotacaoBuilder builder() {
		return new SessaoVotacaoBuilder();
	}
    
}
