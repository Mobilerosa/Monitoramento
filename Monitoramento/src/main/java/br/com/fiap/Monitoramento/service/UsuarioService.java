package br.com.fiap.Monitoramento.service;

import br.com.fiap.Monitoramento.dto.UsuarioCadastroDTO;
import br.com.fiap.Monitoramento.dto.UsuarioExibicaoDTO;
import br.com.fiap.Monitoramento.exception.UsuarioNaoEncontradoException;
import br.com.fiap.Monitoramento.model.Usuario;
import br.com.fiap.Monitoramento.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuarioDTO){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDTO.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioExibicaoDTO(usuarioSalvo);

    }

    public UsuarioExibicaoDTO buscarPorId(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDTO(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não consta em nosso banco de dados");
        }
    }

    public List<UsuarioExibicaoDTO> listarTodos() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long id) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Leitura de qualidade ar não encontrada!");
        }
    }

    public Usuario atualizar(Usuario usuario) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(usuario.getId());

        if (usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }

    }


}