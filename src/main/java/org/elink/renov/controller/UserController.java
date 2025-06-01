package org.elink.renov.controller;

import org.elink.renov.DTO.UsuarioDTO;
import org.elink.renov.entity.usuario.Usuario;
import org.elink.renov.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;


    //GetAll
    @GetMapping
    public List<Usuario> obterUsuarios() {
        return usuarioService.obterTodosUsuarios();
    }

    //SearchById
    @GetMapping("/{id}")
    public Optional<Usuario> obterUsuario(@PathVariable Integer id) {
        return usuarioService.obterUsuarioPorId(id);
    }



    //Registro
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsuarioDTO usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok("Usuario Registrado");

    }


    //Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.findByEmailAndSenha(usuarioDTO.getEmail(), usuarioDTO.getSenha());

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }


}
