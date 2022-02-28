package br.com.dimed.mobilityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeographicCoordinatesDTO {

    private String lat;

    private String lng;

}
