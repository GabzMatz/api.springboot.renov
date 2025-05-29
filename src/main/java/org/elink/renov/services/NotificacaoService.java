package org.elink.renov.services;

import lombok.RequiredArgsConstructor;
import org.elink.renov.DTO.NotificacaoDTO;
import org.elink.renov.entity.equipamento.Equipamento;
import org.elink.renov.entity.notificacao.Notificacao;
import org.elink.renov.repository.EquipamentoRepository;
import org.elink.renov.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    @Autowired
    private  NotificacaoRepository notificacaoRepository;
    @Autowired
    private  EquipamentoRepository equipamentoRepository;


    //CREATE
    public Notificacao criarNotificacao(NotificacaoDTO dto) {
        Optional<Equipamento> equipamentoOpt = equipamentoRepository.findById(dto.getEquipamentoId());

        if (equipamentoOpt.isEmpty()) {
            throw new IllegalArgumentException("Equipamento não encontrado com ID: " + dto.getEquipamentoId());
        }

        Notificacao notificacao = new Notificacao();
        notificacao.setEquipamento(equipamentoOpt.get());
        notificacao.setDataDiaAlerta(dto.getDataDiaAlerta());
        notificacao.setDataHoraAlerta(dto.getDataHoraAlerta());
        notificacao.setDescricao(dto.getDescricao());
        notificacao.setStatus(dto.getStatus());
        notificacao.setTitulo(dto.getTitulo());

        return notificacaoRepository.save(notificacao);
    }


    //TODAS AS NOTIFICACOES POR ID DE USUARIO
    public List<Notificacao> buscarPorUsuarioId(Integer usuarioId) {
        return notificacaoRepository.findByEquipamentoUsuarioId(usuarioId);
    }

}


