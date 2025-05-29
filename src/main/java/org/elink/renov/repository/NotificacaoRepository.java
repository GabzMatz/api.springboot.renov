package org.elink.renov.repository;

import org.elink.renov.entity.notificacao.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {

    List<Notificacao> findByEquipamentoUsuarioId(Integer usuarioId);


}
