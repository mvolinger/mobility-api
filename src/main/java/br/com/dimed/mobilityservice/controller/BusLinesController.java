package br.com.dimed.mobilityservice.controller;

import br.com.dimed.mobilityservice.dto.BusLineDTO;
import br.com.dimed.mobilityservice.service.BusLineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(BusLinesController.BASE_URL)
public class BusLinesController {

    private final BusLineService busService;

    public static final String BASE_URL = "/api/bus/lines";

    @GetMapping(
            value = "/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BusLineDTO> getBusLinesByName(
            @PathVariable("name") String name)
            throws JsonProcessingException {
        return busService.getBusLinesByName(name);
    }

}
