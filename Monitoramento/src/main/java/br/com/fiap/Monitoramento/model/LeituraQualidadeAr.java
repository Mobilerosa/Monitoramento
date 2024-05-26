package br.com.fiap.Monitoramento.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_qualidade_ar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LeituraQualidadeAr {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_QUALIDADE_AR"
    )
    @SequenceGenerator(
            name = "SEQ_QUALIDADE_AR",
            sequenceName = "SEQ_QUALIDADE_AR",
            allocationSize = 1
    )
    @Column(name = "leitura_qualidade_ar_id")
    private Long id;

    @Column(name = "data_leitura")
    private LocalDate dataLeitura;

    private Double pm25;
    private Double pm10;
    private Double no2;
    private Double o3;

    @Column(name = "local_monitoramento_id")
    private Long localMonitoramentoId;

}
