package br.com.fiap.Monitoramento.dto;

import br.com.fiap.Monitoramento.model.LeituraQualidadeAr;

import java.time.LocalDate;

public record LeituraQualidadeArExibicaoDTO(
        Long id,
        LocalDate dataLeitura,
        Double pm25,
        Double pm10,
        Double no2,
        Double o3,
        Long localMonitoramentoId

) {

    public LeituraQualidadeArExibicaoDTO(LeituraQualidadeAr leituraQualidadeAr) {
        this(
                leituraQualidadeAr.getId(),
                leituraQualidadeAr.getDataLeitura(),
                leituraQualidadeAr.getPm25(),
                leituraQualidadeAr.getPm10(),
                leituraQualidadeAr.getNo2(),
                leituraQualidadeAr.getO3(),
                leituraQualidadeAr.getLocalMonitoramentoId());

    }
}
