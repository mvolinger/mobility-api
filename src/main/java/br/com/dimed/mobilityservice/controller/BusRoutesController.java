package br.com.dimed.mobilityservice.controller;

import br.com.dimed.mobilityservice.dto.BusRouteDTO;
import br.com.dimed.mobilityservice.service.BusRouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Get information about bus routes by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Information about bus routes gotten successfully")
    })
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
