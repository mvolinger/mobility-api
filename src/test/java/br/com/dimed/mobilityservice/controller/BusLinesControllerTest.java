package br.com.dimed.mobilityservice.controller;

import br.com.dimed.mobilityservice.dto.BusLineDTO;
import br.com.dimed.mobilityservice.service.BusLineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class BusLinesControllerTest {

    @Mock
    private BusLineService busLineService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        BusLinesController busLinesController = new BusLinesController(busLineService);

        mockMvc = MockMvcBuilders.standaloneSetup(busLinesController).build();
    }

    @Test
    public void shouldGetBusLinesByName() throws Exception {
        var busLineDTO = BusLineDTO.builder()
                .id("5566")
                .codigo("busCode")
                .nome("GRUTINHA")
                .build();

        when(busLineService.getBusLinesByName(anyString())).
                thenReturn(List.of(busLineDTO));

        mockMvc.perform(get(BusLinesController.BASE_URL + "/GRUTINHA")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", equalTo("5566")))
                .andExpect(jsonPath("$.[0].codigo", equalTo("busCode")))
                .andExpect(jsonPath("$.[0].nome", equalTo("GRUTINHA")));
    }
}
