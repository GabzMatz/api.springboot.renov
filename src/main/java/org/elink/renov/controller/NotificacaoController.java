package org.elink.renov.controller;

import lombok.RequiredArgsConstructor;
import org.elink.renov.DTO.NotificacaoDTO;
import org.elink.renov.entity.notificacao.Notificacao;
import org.elink.renov.services.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;


    //Criar Notificacao
    @PostMapping
    public ResponseEntity<Notificacao> criarNotificacao(@RequestBody NotificacaoDTO dto) {
        try {
            Notificacao novaNotificacao = notificacaoService.criarNotificacao(dto);
            return new ResponseEntity<>(novaNotificacao, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Buscar todas as notificações por ID de usuário
    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Notificacao>> buscarPorUsuarioId(@PathVariable Integer usuarioId) {
        List<Notificacao> notificacoes = notificacaoService.buscarPorUsuarioId(usuarioId);
        if (notificacoes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notificacoes, HttpStatus.OK);
    }
}
