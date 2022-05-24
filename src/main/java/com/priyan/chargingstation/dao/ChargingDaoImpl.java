package com.priyan.chargingstation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.mappers.CompanyExtractor;
import com.priyan.chargingstation.repository.ChargingRepository;
import com.priyan.chargingstation.repository.CompanyRepository;


@Repository
public class ChargingDaoImpl implements ChargingDao {

	private static final Logger LOG = Logger.getLogger(ChargingDaoImpl.class.getName());
	
	@Autowired
	private ChargingRepository chargingRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
	@Override
	public ChargingStation createChargingStation(ChargingStation chargingStationEntity) {
		LOG.info("createChargingStation");
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

	@Override
	public List<Company> getChildCompanies(String companyName) {
	    Map<String, String> namedParameters = new HashMap<>();
	    namedParameters.put("companyName", companyName);
	    String sql=" WITH RECURSIVE substations AS (select company_id, parent_company_id, name FROM company WHERE name = :companyName "
	    		+ "	UNION "
	    		+ "	select e.company_id, e.parent_company_id, e.name from company e INNER JOIN substations s ON s.company_id = e.parent_company_id "
	    		+ "	) select * FROM substations ";
	    return jdbcTemplate.query(sql, namedParameters, new CompanyExtractor());
	}
}