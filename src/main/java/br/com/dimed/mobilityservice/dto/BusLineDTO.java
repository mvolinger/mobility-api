package br.com.dimed.mobilityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusLineDTO {

    private String id;

    private String codigo;

    private String nome;

}
