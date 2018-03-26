package com.bratek.transit.service;

import com.bratek.transit.model.Transit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransitService {
    Transit save(Transit transit);
    Page<Transit> getAllTransits(Pageable pageable);
}
