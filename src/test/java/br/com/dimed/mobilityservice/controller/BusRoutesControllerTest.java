package br.com.dimed.mobilityservice.controller;

import br.com.dimed.mobilityservice.dto.BusRouteDTO;
import br.com.dimed.mobilityservice.dto.GeographicCoordinatesDTO;
import br.com.dimed.mobilityservice.service.BusRouteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class BusRoutesControllerTest {

    @Mock
    private BusRouteService busRouteService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        BusRoutesController busRoutesController = new BusRoutesController(busRouteService);

        mockMvc = MockMvcBuilders.standaloneSetup(busRoutesController).build();
    }

    @Test
    public void shouldGetBusLinesByName() throws Exception {

        var geographicCoordinates = new GeographicCoordinatesDTO();
        geographicCoordinates.setLat("-30.05954957845100000");
        geographicCoordinates.setLng("-51.21237511462900000");

        var busRouteDTO = new BusRouteDTO();
        busRouteDTO.setId("ID");
        busRouteDTO.setCodigo("CODE");
        busRouteDTO.setNome("NAME");
        busRouteDTO.setGeographicCoordinates("0", geographicCoordinates);

        when(busRouteService.getBusRouteById(anyString())).
                thenReturn(busRouteDTO);

        mockMvc.perform(get(BusRoutesController.BASE_URL + "/ID")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idlinha", equalTo("ID")))
                .andExpect(jsonPath("$.codigo", equalTo("CODE")))
                .andExpect(jsonPath("$.nome", equalTo("NAME")))
                .andExpect(jsonPath("$.geographicCoordinates", notNullValue()));
    }
}
