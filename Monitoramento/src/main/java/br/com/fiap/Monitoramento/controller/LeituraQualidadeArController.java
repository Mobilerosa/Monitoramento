package br.com.fiap.Monitoramento.controller;

import br.com.fiap.Monitoramento.model.LeituraQualidadeAr;
import br.com.fiap.Monitoramento.repository.LeituraQualidadeArRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qualidade-ar")
public class LeituraQualidadeArController {

    @Autowired
    private LeituraQualidadeArRepository leituraQualidadeArRepository;

    @GetMapping()
    public ResponseEntity<List<LeituraQualidadeAr>> findAll(){
        List<LeituraQualidadeAr> leituras = leituraQualidadeArRepository.findAll();
        return ResponseEntity.ok(leituras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeituraQualidadeAr> findById(@PathVariable Long id) {
        LeituraQualidadeAr leitura = leituraQualidadeArRepository.findById(id).orElse(null);
        if (leitura == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(leitura);
    }

    public ResponseEntity<LeituraQualidadeAr> save(@Valid @RequestBody LeituraQualidadeAr leitura) {
        LeituraQualidadeAr novaLeitura = leituraQualidadeArRepository.save(leitura);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLeitura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeituraQualidadeAr> update(@PathVariable Long id, @Valid @RequestBody LeituraQualidadeAr leitura) {
        leitura.setId(id);
        LeituraQualidadeAr leituraAtualizada = leituraQualidadeArRepository.save(leitura);
        return ResponseEntity.ok(leituraAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        leituraQualidadeArRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
