package com.exercicio.assembleia_votacao.model;

import com.exercicio.assembleia_votacao.dto.builder.votoDTOBuilder;
import com.exercicio.assembleia_votacao.model.builder.votoBuilder;
import com.exercicio.assembleia_votacao.model.enums.VotoEnum;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="voto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voto implements Serializable {
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public SessaoVotacao getSessaoVotacao() {
		return sessaoVotacao;
	}

	public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
		this.sessaoVotacao = sessaoVotacao;
	}

	public VotoEnum getVoto() {
		return voto;
	}

	public void setVoto(VotoEnum voto) {
		this.voto = voto;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "O campo id_associado é obrigatório.")
	public Long idAssociado;
    
    @NotNull(message = "O campo id_sessao_votacao é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "fk_sessao_votacao")
	public SessaoVotacao sessaoVotacao;
    
    @NotNull(message = "O campo voto é obrigatório.")
	public VotoEnum voto;

	public static votoBuilder builder() {
		return new votoBuilder();
	}
    
}
