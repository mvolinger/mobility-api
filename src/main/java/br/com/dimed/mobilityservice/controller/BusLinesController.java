package br.com.dimed.mobilityservice.controller;

import br.com.dimed.mobilityservice.dto.BusLineDTO;
import br.com.dimed.mobilityservice.service.BusLineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Get information about bus lines by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Information about bus lines gotten successfully")
    })
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
