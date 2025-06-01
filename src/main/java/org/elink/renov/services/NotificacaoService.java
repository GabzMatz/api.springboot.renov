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



    public Notificacao updateNotificacao(Integer id, Notificacao novaNotificacao) {
        return notificacaoRepository.findById(id).map(existing -> {
            existing.setDataDiaAlerta(novaNotificacao.getDataDiaAlerta());
            existing.setDataHoraAlerta(novaNotificacao.getDataHoraAlerta());
            existing.setDescricao(novaNotificacao.getDescricao());
            existing.setStatus(novaNotificacao.getStatus());
            existing.setTitulo(novaNotificacao.getTitulo());
            existing.setEquipamento(novaNotificacao.getEquipamento());
            return notificacaoRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Notificação não encontrada com id: " + id));
    }

    public void deleteNotificacao(Integer id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new RuntimeException("Notificação não encontrada com id: " + id);
        }
        notificacaoRepository.deleteById(id);
    }




}


