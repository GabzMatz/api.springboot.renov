package org.elink.renov.DTO;

import org.elink.renov.entity.TipoUsuario;

import java.time.LocalDateTime;


public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private LocalDateTime dataCriacao;
    private LocalDateTime ultimaAtualizacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
