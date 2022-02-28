package br.com.dimed.mobilityservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.encoding.FeignClientEncodingProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "data-poa",
        url = "http://www.poatransporte.com.br/php/facades/process.php",
        configuration = FeignClientEncodingProperties.class)
public interface DataPoaClient {

    //https://github.com/gustavosf/api.poatransporte.com.br/wiki/PoaTransporte

    @GetMapping
    String getBusLinesByParams(
            @RequestParam("a") String id,
            @RequestParam("p") String name,
            @RequestParam("t") String type)
            throws JsonProcessingException;

}
