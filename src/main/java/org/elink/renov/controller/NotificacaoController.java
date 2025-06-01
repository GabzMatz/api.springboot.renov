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


    @PostMapping
    public ResponseEntity<Notificacao> criarNotificacao(@RequestBody NotificacaoDTO dto) {
        try {
            Notificacao novaNotificacao = notificacaoService.criarNotificacao(dto);
            return new ResponseEntity<>(novaNotificacao, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<NotificacaoDTO>> listarPorUsuario(@PathVariable Integer usuarioId) {
        return ResponseEntity.ok(notificacaoService.listarPorUsuario(usuarioId));
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Notificacao notificacao) {
        try {
            Notificacao atualizada = notificacaoService.updateNotificacao(id, notificacao);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            notificacaoService.deleteNotificacao(id);
            return ResponseEntity.ok("Notificação deletada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
