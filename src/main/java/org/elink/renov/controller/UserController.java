package org.elink.renov.controller;

import org.elink.renov.DTO.UsuarioDTO;
import org.elink.renov.entity.Usuario;
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

    @GetMapping
    public List<Usuario> obterUsuarios() {
        return usuarioService.obterTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obterUsuario(@PathVariable Integer id) {
        return usuarioService.obterUsuarioPorId(id);
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody UsuarioDTO usuario) {
        System.out.println(usuario);
        return usuarioService.salvarUsuario(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO usuario) {
        boolean isValid = usuarioService.validateUser(usuario.getEmail(), usuario.getSenha());

        if (isValid) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }

}
