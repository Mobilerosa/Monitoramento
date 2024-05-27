package br.com.fiap.Monitoramento.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LeituraQualidadeArCadastroDTO(
        Long id,

        @NotNull(message = "Data da leitura é obrigatória")
        LocalDate dataLeitura,

        @NotNull(message = "PM2.5 é obrigatório")
        Double pm25,

        @NotNull(message = "PM10 é obrigatório")
        Double pm10,

        @NotNull(message = "NO2 é obrigatório")
        Double no2,

        @NotNull(message = "O3 é obrigatório")
        Double o3,

        @NotNull(message = "ID do local de monitoramento é obrigatório")
        Long localMonitoramentoId
) {

}


