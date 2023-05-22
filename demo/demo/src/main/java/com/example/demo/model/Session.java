package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraAbertura;
    private Integer duracao;
    private LocalDateTime dataHoraFechamento;
    @OneToOne
    private Pauta pauta;

    public Session() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public LocalDateTime getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(LocalDateTime dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }
    
    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public boolean isFechada() {
        if (dataHoraFechamento != null) {
            return true;
        }

        if (dataHoraAbertura == null || duracao == null) {
            return false;
        }

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        LocalDateTime dataHoraFechamentoPrevista = dataHoraAbertura.plusMinutes(duracao);
        return dataHoraAtual.isAfter(dataHoraFechamentoPrevista);
    }

    public void fechar() {
        if (!isFechada()) {
            dataHoraFechamento = LocalDateTime.now();
        }
    }
}
