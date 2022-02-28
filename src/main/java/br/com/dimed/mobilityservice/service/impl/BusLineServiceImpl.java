package br.com.dimed.mobilityservice.service.impl;

import br.com.dimed.mobilityservice.dto.BusLineDTO;
import br.com.dimed.mobilityservice.integration.DataPoaClient;
import br.com.dimed.mobilityservice.service.BusLineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusLineServiceImpl implements BusLineService {

    private final DataPoaClient dataPoaClient;
    private final ObjectMapper objectMapper;

    @Override
    public List<BusLineDTO> getBusLinesByName(String name) throws JsonProcessingException {
        var busLines = dataPoaClient.getBusLinesByParams("nc", name, "o");
        return List.of(objectMapper.readValue(busLines, BusLineDTO[].class));
    }
}
