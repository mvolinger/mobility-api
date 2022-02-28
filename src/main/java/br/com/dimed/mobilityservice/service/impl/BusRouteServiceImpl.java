package br.com.dimed.mobilityservice.service.impl;

import br.com.dimed.mobilityservice.dto.BusRouteDTO;
import br.com.dimed.mobilityservice.integration.DataPoaClient;
import br.com.dimed.mobilityservice.service.BusRouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BusRouteServiceImpl implements BusRouteService {

    private final DataPoaClient dataPoaClient;
    private final ObjectMapper objectMapper;

    @Override
    public BusRouteDTO getBusRouteById(String id) throws JsonProcessingException {
        var busRoute = dataPoaClient.getBusRoutesById("il", id);
        return objectMapper.readValue(busRoute, BusRouteDTO.class);

    }
}
