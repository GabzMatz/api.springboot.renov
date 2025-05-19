package org.elink.renov.entity.alerta;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.elink.renov.entity.equipamento.Equipamento;

@Getter
@Setter
@Entity
@Table(name = "alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManutencaoID")
    private Integer id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "equipamentoid", nullable = false)
    private Equipamento equipamento;


    @Column(name = "tipomanutencao")
    private String tipoManutencao;


    @Column(name = "DataManutencao", nullable = false)
    private LocalDate dataManutencao;

    @Column(name = "Descricao", length = 255)
    private String descricao;

    @Column(name = "CustoEstimado", precision = 10, scale = 2)
    private BigDecimal custoEstimado;

    @Column(name = "DataCriacao", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name = "UltimaAtualizacao", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ultimaAtualizacao;

    @Column(name = "status")
    private STATUS status;

    @Column(name = "alerta")
    private LocalDate alerta;

}