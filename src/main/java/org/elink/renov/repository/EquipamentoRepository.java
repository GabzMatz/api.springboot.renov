package org.elink.renov.repository;

import org.elink.renov.entity.equipamento.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipamentoRepository  extends JpaRepository<Equipamento, Integer> {

    List<Equipamento> findByUsuarioId(Integer usuarioId);


}
