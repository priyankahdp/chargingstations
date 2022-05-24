package com.priyan.chargingstation.dao;

import java.util.List;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;

public interface ChargingDao {

	public ChargingStation createChargingStation(ChargingStation chargingStationEntity);

	public List<ChargingStation> getChargingStations();

	public List<Company> getCompanies();

	public Company createCompanies(Company company);
	
	public List<Company> getChildCompanies(String companyName);
}
