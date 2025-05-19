package org.elink.renov.DTO;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class EquipamentoDTO {

    private Integer equipamentoID;
    private Integer usuarioID;
    private String tipoEquipamento;
    private String modelo;
    private String numeroSerie;
    private LocalDate dataInstalacao;
    private Integer vidaUtilEstimada;
    private String status;
    private String localizacao;
    private Integer usoAcumulado;
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

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Integer getVidaUtilEstimada() {
        return vidaUtilEstimada;
    }

    public void setVidaUtilEstimada(Integer vidaUtilEstimada) {
        this.vidaUtilEstimada = vidaUtilEstimada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getUsoAcumulado() {
        return usoAcumulado;
    }

    public void setUsoAcumulado(Integer usoAcumulado) {
        this.usoAcumulado = usoAcumulado;
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
