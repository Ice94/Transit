package com.bratek.transit.service;

import com.bratek.transit.model.Transit;
import com.bratek.transit.repository.TransitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransitServiceImpl implements TransitService {

    private TransitRepository transitRepository;

    public TransitServiceImpl(TransitRepository transitRepository) {
        this.transitRepository = transitRepository;
    }

    @Override
    public Transit save(Transit transit) {
        return transitRepository.save(transit);
    }

    @Override
    public Page<Transit> getAllTransits(Pageable pageable) {
        return transitRepository.findAll(pageable);
    }
}
