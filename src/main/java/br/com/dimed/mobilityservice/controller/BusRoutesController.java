package br.com.dimed.mobilityservice.controller;

import br.com.dimed.mobilityservice.dto.BusRouteDTO;
import br.com.dimed.mobilityservice.service.BusRouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(BusRoutesController.BASE_URL)
public class BusRoutesController {

    private final BusRouteService busService;

    public static final String BASE_URL = "/api/bus/routes";

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BusRouteDTO getBusRouteById(
            @PathVariable("id") String id)
            throws JsonProcessingException {
        return busService.getBusRouteById(id);
    }
}
