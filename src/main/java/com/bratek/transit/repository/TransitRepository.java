package com.bratek.transit.repository;

import com.bratek.transit.model.Transit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitRepository extends JpaRepository <Transit, Long>{
}
