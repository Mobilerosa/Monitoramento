package br.com.fiap.Monitoramento.repository;

import br.com.fiap.Monitoramento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
