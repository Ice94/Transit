package com.bratek.transit.controller;

import com.bratek.transit.model.Transit;
import com.bratek.transit.service.TransitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransitController {

    private TransitService transitService;

    public TransitController(TransitService transitService) {
        this.transitService = transitService;
    }


    @PostMapping(value = "/transit", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransit(@RequestBody Transit transit) {
        transitService.save(transit);
    }

}
