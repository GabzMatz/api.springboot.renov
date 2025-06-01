package org.elink.renov.entity.notificacao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.elink.renov.entity.equipamento.Equipamento;


@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificacaoid")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipamentoid", nullable = false)
    private Equipamento equipamento;

    @Column(name = "datadiaalerta")
    private LocalDate dataDiaAlerta;

    @Column(name = "datahoraalerta")
    private LocalDateTime dataHoraAlerta;

    @Column(name = "descricao")
    private String descricao;

    @Column(name="status")
    private Boolean status;

    @Column(name="titulo")
    private String titulo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
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