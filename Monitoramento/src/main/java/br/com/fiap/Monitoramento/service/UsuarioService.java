package br.com.fiap.Monitoramento.service;

import br.com.fiap.Monitoramento.dto.UsuarioCadastroDTO;
import br.com.fiap.Monitoramento.dto.UsuarioExibicaoDTO;
import br.com.fiap.Monitoramento.model.Usuario;
import br.com.fiap.Monitoramento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuarioDTO){


        Usuario usuarioSalvo = usuarioRepository.save(new Usuario()); //verificar esse trecho

        return new


    }


}
