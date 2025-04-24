package org.elink.renov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tipomanutencao")
public class TipoManutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipoManutencaoId")
    private Long tipoManutencaoId;

    @Column(name = "Descricao", nullable = false, length = 100)
    private String descricao;

}
