package com.priyan.chargingstation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.repository.ChargingRepository;
import com.priyan.chargingstation.repository.CompanyRepository;

@Repository
public class ChargingDaoImpl implements ChargingDao {

	@Autowired
	private ChargingRepository chargingRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public ChargingStation createChargingStation(ChargingStation chargingStationEntity) {
		return chargingRepository.save(chargingStationEntity);
	}

	@Override
	public List<ChargingStation> getChargingStations() {
		return chargingRepository.findAll();
	}

	@Override
	public List<Company> getCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company createCompanies(Company company) {
		return companyRepository.save(company);
	}
	
	/*
		WITH RECURSIVE substations AS (
		select company_id, parent_company_id, name FROM company WHERE company_id = 6
		UNION
		select e.company_id, e.parent_company_id, e.name from company e INNER JOIN substations s ON s.company_id = e.parent_company_id
		) select * FROM substations;
	 */

}