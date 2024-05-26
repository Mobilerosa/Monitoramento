package br.com.fiap.Monitoramento.service;

import br.com.fiap.Monitoramento.model.LeituraQualidadeAr;
import br.com.fiap.Monitoramento.repository.LeituraQualidadeArRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeituraQualidadeArService {

    @Autowired
    private LeituraQualidadeArRepository leituraQualidadeArRepository;

    public List<LeituraQualidadeAr> findAll(){
        return leituraQualidadeArRepository.findAll();
    }

    public LeituraQualidadeAr findById(Long id){
        return leituraQualidadeArRepository.findById(id).orElse(null);
    }


    public LeituraQualidadeAr save(LeituraQualidadeAr leitura){
        return leituraQualidadeArRepository.save(leitura);
    }

    public LeituraQualidadeAr update(LeituraQualidadeAr leitura){
        return leituraQualidadeArRepository.save(leitura);
    }

    public void delete(Long id){
        leituraQualidadeArRepository.deleteById(id);
    }

}
