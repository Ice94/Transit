package com.bratek.transit.controller;

import com.bratek.transit.model.Transit;
import com.bratek.transit.service.TransitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/transit")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<Transit>> getAllTransits (Pageable pageable) {
        return new ResponseEntity<>(transitService.getAllTransits(pageable), HttpStatus.OK);
    }

}
