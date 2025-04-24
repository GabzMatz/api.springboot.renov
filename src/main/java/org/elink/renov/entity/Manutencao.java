package org.elink.renov.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManutencaoID")
    private Integer id;

    @Column(name = "EquipamentoID", nullable = false)
    private Integer equipamentoId;

    @ManyToOne
    @JoinColumn(name = "TipoManutencaoId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TipoManutencao tipoManutencao;

    @Column(name = "DataManutencao", nullable = false)
    private LocalDate dataManutencao;

    @Column(name = "Descricao", length = 255)
    private String descricao;

    @Column(name = "CustoEstimado", precision = 10, scale = 2)
    private BigDecimal custoEstimado;

    @Column(name = "Responsavel", length = 100)
    private String responsavel;

    @Column(name = "DataCriacao", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name = "UltimaAtualizacao", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ultimaAtualizacao;
}