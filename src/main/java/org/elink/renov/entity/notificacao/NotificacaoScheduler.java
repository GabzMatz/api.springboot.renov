package org.elink.renov.entity.notificacao;

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

    @Scheduled(fixedRate = 20000) // A cada 10 segundos
    public void verificarNotificacoes() {
        List<Notificacao> notificacoes = notificacaoRepository.findByStatusFalseAndDataHoraAlertaBefore(LocalDateTime.now());
        for (Notificacao notificacao : notificacoes) {
            messagingTemplate.convertAndSend("/topic/notificacoes", notificacao.getDescricao());
            notificacao.setStatus(true);
            notificacaoRepository.save(notificacao);
        }
    }
}
