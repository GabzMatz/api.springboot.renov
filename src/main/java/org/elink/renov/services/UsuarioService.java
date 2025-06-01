package org.elink.renov.services;

import org.elink.renov.DTO.UsuarioDTO;
import org.elink.renov.entity.usuario.Usuario;
import org.elink.renov.repository.UsuarioRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorty usuarioRepository;


    //GetAll
    public List<Usuario> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    //SearchById
    public Optional<Usuario> obterUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }


    //REGISTER
    public Usuario salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setCpf(usuarioDTO.getCpf());

        return usuarioRepository.save(usuario);
    }
    //LOGIN
    public Usuario findByEmailAndSenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
    }
}
