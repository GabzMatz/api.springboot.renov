package org.elink.renov.services;

import org.elink.renov.DTO.EquipamentoDTO;
import org.elink.renov.entity.equipamento.Equipamento;
import org.elink.renov.entity.usuario.Usuario;
import org.elink.renov.repository.EquipamentoRepository;
import org.elink.renov.repository.UsuarioRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private UsuarioRepositorty usuarioRepositorty;



    //PESQUISA POR ID DO USUARIO
    public List<Equipamento> obterEquipamentosPorUsuario(Integer idUsuario) {
        return equipamentoRepository.findByUsuarioId(idUsuario);
    }



    //CADASTRO
    public Equipamento cadastrarEquipamento(EquipamentoDTO equipamentoDTO) {
        Usuario usuario = usuarioRepositorty.findById(equipamentoDTO.getUsuarioID())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Equipamento equipamento = new Equipamento();
        equipamento.setUsuario(usuario);
        equipamento.setTipoEquipamento(equipamentoDTO.getTipoEquipamento());
        equipamento.setModelo(equipamentoDTO.getModelo());
        equipamento.setNumeroSerie(equipamentoDTO.getNumeroSerie());
        equipamento.setDataInstalacao(equipamentoDTO.getDataInstalacao());
        equipamento.setVidaUtilEstimada(equipamentoDTO.getVidaUtilEstimada());
        equipamento.setStatus(equipamentoDTO.getStatus());
        equipamento.setLocalizacao(equipamentoDTO.getLocalizacao());
        equipamento.setUsoAcumulado(equipamentoDTO.getUsoAcumulado());

        return equipamentoRepository.save(equipamento);
    }



    // DELETE
    public boolean deletarEquipamento(Integer id) {
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // UPDATE
    public Optional<Equipamento> atualizarEquipamento(Integer id, Equipamento novoEquipamento) {
        return equipamentoRepository.findById(id)
                .map(equipamentoExistente -> {
                    equipamentoExistente.setTipoEquipamento(novoEquipamento.getTipoEquipamento());
                    equipamentoExistente.setModelo(novoEquipamento.getModelo());
                    equipamentoExistente.setNumeroSerie(novoEquipamento.getNumeroSerie());
                    equipamentoExistente.setDataInstalacao(novoEquipamento.getDataInstalacao());
                    equipamentoExistente.setVidaUtilEstimada(novoEquipamento.getVidaUtilEstimada());
                    equipamentoExistente.setStatus(novoEquipamento.getStatus());
                    equipamentoExistente.setLocalizacao(novoEquipamento.getLocalizacao());
                    equipamentoExistente.setUsoAcumulado(novoEquipamento.getUsoAcumulado());
                    return equipamentoRepository.save(equipamentoExistente);
                });
    }
}
