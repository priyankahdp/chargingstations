package com.priyan.chargingstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyan.chargingstation.entity.ChargingStation;

@Repository
public interface ChargingRepository extends JpaRepository<ChargingStation, Integer> {

}
