package br.com.fiap.Monitoramento.dto;

import br.com.fiap.Monitoramento.model.Usuario;

public record UsuarioExibicaoDTO(
     Long usuarioId,
     String nome,
     String email) {

    public UsuarioExibicaoDTO(Usuario usuario){
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
