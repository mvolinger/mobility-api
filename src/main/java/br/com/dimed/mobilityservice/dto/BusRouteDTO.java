package br.com.dimed.mobilityservice.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({"idlinha", "nome", "codigo", "geographicCoordinates"})
public class BusRouteDTO extends BusLineDTO {

    private Map<String, GeographicCoordinatesDTO> geographicCoordinates = new HashMap<>();

    @JsonAnySetter
    public void setGeographicCoordinates(String key, GeographicCoordinatesDTO value) {
        geographicCoordinates.put(key, value);
    }

    @Override
    @JsonProperty("idlinha")
    public String getId() {
        return super.getId();
    }

}
