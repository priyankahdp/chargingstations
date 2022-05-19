package com.priyan.chargingstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyan.chargingstation.dao.ChargingDao;
import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;


@Service
public class ChargingServiceImpl implements ChargingService {

	@Autowired
	private ChargingDao chargingDao;

	@Override
	public ChargingStation createChargingStation(ChargingStation chargingStationEntity) {
		return chargingDao.createChargingStation(chargingStationEntity);
	}

	@Override
	public List<ChargingStation> getChargingStations() {
		return chargingDao.getChargingStations();
	}

	@Override
	public List<Company> getCompanies() {
		return chargingDao.getCompanies();
	}

	@Override
	public Company createCompanies(Company company) {
		return chargingDao.createCompanies(company);
	}

}
