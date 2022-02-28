package br.com.dimed.mobilityservice.service;

import br.com.dimed.mobilityservice.dto.BusLineDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface BusLineService {

    List<BusLineDTO> getBusLinesByName(String name) throws JsonProcessingException;

}
