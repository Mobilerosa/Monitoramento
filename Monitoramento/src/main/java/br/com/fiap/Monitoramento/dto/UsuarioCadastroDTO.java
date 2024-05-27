package br.com.fiap.Monitoramento.dto;

import br.com.fiap.Monitoramento.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDTO(
        Long usuarioId,

        @NotBlank(message = "Usuário obrigatório")

        String nome,

        @NotBlank(message = "E-mail obrigatório")

        @Email(message = "E-mail invalido")

        String email,

        @NotBlank(message = "Senha é obrigatória")

        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres!")

        String senha,

        UsuarioRole role

) {
}
