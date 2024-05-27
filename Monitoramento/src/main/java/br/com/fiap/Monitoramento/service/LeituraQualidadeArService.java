package br.com.fiap.Monitoramento.service;

import br.com.fiap.Monitoramento.dto.LeituraQualidadeArCadastroDTO;
import br.com.fiap.Monitoramento.dto.LeituraQualidadeArExibicaoDTO;
import br.com.fiap.Monitoramento.model.LeituraQualidadeAr;
import br.com.fiap.Monitoramento.repository.LeituraQualidadeArRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeituraQualidadeArService {

    @Autowired
    private LeituraQualidadeArRepository leituraQualidadeArRepository;

    public LeituraQualidadeArExibicaoDTO salvar(LeituraQualidadeArCadastroDTO leituraQualidadeArCadastroDTO) {
        LeituraQualidadeAr leituraQualidadeAr = new LeituraQualidadeAr();
        BeanUtils.copyProperties(leituraQualidadeArCadastroDTO, leituraQualidadeAr);
        LeituraQualidadeAr leituraSalva = leituraQualidadeArRepository.save(leituraQualidadeAr);
        return new LeituraQualidadeArExibicaoDTO(leituraSalva);
    }

    public List<LeituraQualidadeArExibicaoDTO> findAll() {
        List<LeituraQualidadeAr> leituras = leituraQualidadeArRepository.findAll();
        return leituras.stream()
                .map(LeituraQualidadeArExibicaoDTO::new)
                .collect(Collectors.toList());
    }

    public LeituraQualidadeArExibicaoDTO findById(Long id) {
        Optional<LeituraQualidadeAr> leitura = leituraQualidadeArRepository.findById(id);
        return leitura.map(LeituraQualidadeArExibicaoDTO::new).orElse(null);
    }

    public LeituraQualidadeArExibicaoDTO update(Long id, LeituraQualidadeArCadastroDTO leituraQualidadeArCadastroDTO) {
        Optional<LeituraQualidadeAr> leituraExistente = leituraQualidadeArRepository.findById(id);
        if (leituraExistente.isPresent()) {
            LeituraQualidadeAr leitura = leituraExistente.get();
            BeanUtils.copyProperties(leituraQualidadeArCadastroDTO, leitura, "id");
            LeituraQualidadeAr leituraAtualizada = leituraQualidadeArRepository.save(leitura);
            return new LeituraQualidadeArExibicaoDTO(leituraAtualizada);
        }
        return null;  // ou lançar uma exceção
    }

    public void delete(Long id) {
        leituraQualidadeArRepository.deleteById(id);
    }
}
