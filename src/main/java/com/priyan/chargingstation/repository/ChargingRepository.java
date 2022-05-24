package com.priyan.chargingstation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.priyan.chargingstation.entity.ChargingStation;

@Repository
public interface ChargingRepository extends JpaRepository<ChargingStation, Integer> {

	@Query(value = "select * from charging_station cs where company_id in (?1);",nativeQuery = true)
	public List<ChargingStation> findAllStationsByCompanyId(List<Integer> companyIds);

}
