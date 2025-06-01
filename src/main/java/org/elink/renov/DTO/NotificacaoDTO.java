package org.elink.renov.DTO;

import org.elink.renov.entity.notificacao.Notificacao;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class NotificacaoDTO {

    private Integer id;
    private Integer equipamentoId;
    private LocalDate dataDiaAlerta;
    private LocalDateTime dataHoraAlerta;
    private String descricao;
    private Boolean status;
    private String titulo;

    public NotificacaoDTO(Notificacao notificacao) {
        this.id = notificacao.getId();
        this.equipamentoId = notificacao.getEquipamento() != null ? notificacao.getEquipamento().getEquipamentoID() : null;
        this.dataDiaAlerta = notificacao.getDataDiaAlerta();
        this.dataHoraAlerta = notificacao.getDataHoraAlerta();
        this.descricao = notificacao.getDescricao();
        this.status = notificacao.getStatus();
        this.titulo = notificacao.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public LocalDate getDataDiaAlerta() {
        return dataDiaAlerta;
    }

    public void setDataDiaAlerta(LocalDate dataDiaAlerta) {
        this.dataDiaAlerta = dataDiaAlerta;
    }

    public LocalDateTime getDataHoraAlerta() {
        return dataHoraAlerta;
    }

    public void setDataHoraAlerta(LocalDateTime dataHoraAlerta) {
        this.dataHoraAlerta = dataHoraAlerta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}