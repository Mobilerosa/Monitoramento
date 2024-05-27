package br.com.fiap.Monitoramento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

public record LoginDTO(

        @NotBlank(message = "O e-mail do usuário é obrigatório!")
        @Email(message = "O e-mail do usuário não é válido!")
        String email,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres!")
        String senha
) {
}
