package org.elink.renov.entity.equipamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.elink.renov.entity.notificacao.Notificacao;
import org.elink.renov.entity.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Equipamento")

public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipamentoID;


    @ManyToOne(optional = false)
    @JoinColumn(name = "UsuarioID", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @Column(name = "TipoEquipamento")
    private String tipoEquipamento;

    @Column(length = 100)
    private String modelo;

    @Column(length = 100)
    private String numeroSerie;

    private String fabricante;

    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Notificacao> notificacoes;

    private Boolean temNotificacao = false;

    private Boolean status = true;

    public Boolean getStatus(Boolean status) {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

    public Boolean getTemNotificacao() {
        return temNotificacao;
    }

    public void setTemNotificacao(Boolean temNotificacao) {
        this.temNotificacao = temNotificacao;
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
