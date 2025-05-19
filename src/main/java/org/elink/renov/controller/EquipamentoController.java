package org.elink.renov.controller;

import org.elink.renov.DTO.EquipamentoDTO;
import org.elink.renov.DTO.UsuarioDTO;
import org.elink.renov.entity.equipamento.Equipamento;
import org.elink.renov.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    //REGISTRO
    @PostMapping("/cadastrar")
    public ResponseEntity<Equipamento> cadastrarEquipamento(@RequestBody EquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = equipamentoService.cadastrarEquipamento(equipamentoDTO);
        return ResponseEntity.ok(equipamento);
    }

    //BuscarPORID

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Equipamento>> obterEquipamentosPorUsuario(@PathVariable Integer usuarioId) {
        List<Equipamento> equipamentos = equipamentoService.obterEquipamentosPorUsuario(usuarioId);
        if (equipamentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipamentos);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizarEquipamento(@PathVariable Integer id, @RequestBody Equipamento equipamento) {
        Optional<Equipamento> atualizado = equipamentoService.atualizarEquipamento(id, equipamento);
        return atualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEquipamento(@PathVariable Integer id) {
        boolean removido = equipamentoService.deletarEquipamento(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
