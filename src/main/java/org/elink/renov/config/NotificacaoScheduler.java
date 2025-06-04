package org.elink.renov.config;

import org.elink.renov.entity.notificacao.Notificacao;
import org.elink.renov.repository.NotificacaoRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NotificacaoScheduler {

    private final NotificacaoRepository notificacaoRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public NotificacaoScheduler(NotificacaoRepository notificacaoRepository, SimpMessagingTemplate messagingTemplate) {
        this.notificacaoRepository = notificacaoRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void verificarNotificacoes() {
        List<Notificacao> notificacoes = notificacaoRepository.findByStatusTrueAndDataHoraAlertaBefore(LocalDateTime.now());
        for (Notificacao notificacao : notificacoes) {
            messagingTemplate.convertAndSend("/topic/notificacoes", notificacao);
            notificacao.setStatus(false);
            notificacaoRepository.save(notificacao);
        }
    }
}
