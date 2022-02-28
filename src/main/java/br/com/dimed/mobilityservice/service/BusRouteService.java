package br.com.dimed.mobilityservice.service;

import br.com.dimed.mobilityservice.dto.BusRouteDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface BusRouteService {

    BusRouteDTO getBusRouteById(String id) throws JsonProcessingException;

}
