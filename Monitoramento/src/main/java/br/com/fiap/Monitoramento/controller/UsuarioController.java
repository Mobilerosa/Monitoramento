package br.com.fiap.Monitoramento.controller;

import br.com.fiap.Monitoramento.dto.UsuarioCadastroDTO;
import br.com.fiap.Monitoramento.dto.UsuarioExibicaoDTO;
import br.com.fiap.Monitoramento.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO save(@RequestBody @Valid UsuarioCadastroDTO usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioService.listarTodos();
    }


}
