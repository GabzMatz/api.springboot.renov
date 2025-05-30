package org.elink.renov.DTO;

import java.time.LocalDateTime;

public class EquipamentoDTO {

    private Integer equipamentoID;
    private Integer usuarioID;
    private String tipoEquipamento;
    private String modelo;
    private String numeroSerie;
    private String fabricante;
    private Boolean temNotificacao;
    private Integer vidaUtilEstimada;
    private LocalDateTime dataCriacao;
    private LocalDateTime ultimaAtualizacao;

    public Integer getEquipamentoID() {
        return equipamentoID;
    }

    public void setEquipamentoID(Integer equipamentoID) {
        this.equipamentoID = equipamentoID;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Boolean getTemNotificacao() {
        return temNotificacao;
    }

    public void setTemNotificacao(Boolean temNotificacao) {
        this.temNotificacao = temNotificacao;
    }

    public Integer getVidaUtilEstimada() {
        return vidaUtilEstimada;
    }

    public void setVidaUtilEstimada(Integer vidaUtilEstimada) {
        this.vidaUtilEstimada = vidaUtilEstimada;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
