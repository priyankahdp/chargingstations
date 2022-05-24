package com.priyan.chargingstation.service;

import java.util.List;
import java.util.Map;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;

public interface ChargingService {

	public ChargingStation createChargingStation(ChargingStation chargingStationEntity);

	public List<ChargingStation> getChargingStations();

	public List<Company> getCompanies();

	public Company createCompanies(Company company);

	public Map<Double, ChargingStation> getStationsByRadius(Double radius, Double latitude, Double longitude);

	public List<Company> getChildCompanies(String companyName);

}
