package org.elink.renov.entity.equipamento;

import jakarta.persistence.*;
import org.elink.renov.entity.usuario.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Equipamento")

public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipamentoID;


    @ManyToOne(optional = false)
    @JoinColumn(name = "UsuarioID", nullable = false)
    private Usuario usuario;

    @Column(name = "TipoEquipamento", nullable = false)
    private String tipoEquipamento;

    @Column(length = 100)
    private String modelo;

    @Column(length = 100)
    private String numeroSerie;

    private LocalDate dataInstalacao;

    private Integer vidaUtilEstimada;

    @Column(length = 50)
    private String status;

    @Column(length = 255)
    private String localizacao;

    private Integer usoAcumulado;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    private LocalDateTime ultimaAtualizacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
        this.ultimaAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.ultimaAtualizacao = LocalDateTime.now();
    }

    public Integer getEquipamentoID() {
        return equipamentoID;
    }

    public void setEquipamentoID(Integer equipamentoID) {
        this.equipamentoID = equipamentoID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
