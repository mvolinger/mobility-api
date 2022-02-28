package br.com.dimed.mobilityservice.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "data-poa",
        url = "http://www.poatransporte.com.br/php/facades/process.php")
public interface DataPoaClient {

    //https://github.com/gustavosf/api.poatransporte.com.br/wiki/PoaTransporte

    @GetMapping
    String getBusLinesByParams(
            @RequestParam("a") String action,
            @RequestParam("p") String name,
            @RequestParam("t") String type);

    @GetMapping
    String getBusRoutesById(
            @RequestParam("a") String action,
            @RequestParam("p") String idBus);

}
