package com.priyan.chargingstation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.repository.ChargingRepository;
import com.priyan.chargingstation.repository.CompanyRepository;
import com.priyan.chargingstation.service.ChargingService;

@SpringBootTest
class ChargingstationApplicationTests {

	@Autowired
	private ChargingService chargingService;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ChargingRepository chargingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getStationsTest() {
		List<ChargingStation> chargingStations = chargingService.getChargingStations();
		assertNotNull(chargingStations);
	}

	@Test
	public void getCompaniesTest() {
		List<Company> companies = chargingService.getCompanies();
		assertNotNull(companies);
	}

	@Test
	public void createCompany() {
		Company companyABC = new Company();
		companyABC.setName("ABC Company");
		assertNotNull(chargingService.createCompanies(companyABC));

		Company companyPQR = new Company();
		companyPQR.setName("PQR Company");
		assertNotNull(chargingService.createCompanies(companyPQR));

		Company companyXYZ = new Company();
		companyXYZ.setName("XYZ Company");
		assertNotNull(chargingService.createCompanies(companyXYZ));

		Company companyXyzSub = new Company();
		companyXyzSub.setName("Xyz sub-company");
		companyXyzSub.setParentCompany(companyXYZ);
		assertNotNull(chargingService.createCompanies(companyXyzSub));
		
		Company companyXyzOneSub = new Company();
		companyXyzOneSub.setName("Xyz sub-one-company");
		companyXyzOneSub.setParentCompany(companyXyzSub);
		assertNotNull(chargingService.createCompanies(companyXyzOneSub));
	}

	@Test
	public void createStation() {
		ChargingStation chargingStationGampaha = new ChargingStation();
		chargingStationGampaha.setName("Gampaha Station");
		Optional<Company> companyOneOpt = companyRepository.findById(1);
		if (companyOneOpt.isPresent()) {
			chargingStationGampaha.setCompany(companyOneOpt.get());
		}
		chargingStationGampaha.setLatitude(7.0840);
		chargingStationGampaha.setLongitude(80.0098);
		assertNotNull(chargingService.createChargingStation(chargingStationGampaha));

		ChargingStation chargingStationColombo = new ChargingStation();
		chargingStationColombo.setName("Colombo Station");
		Optional<Company> companyTwoOpt = companyRepository.findById(2);
		if (companyTwoOpt.isPresent()) {
			chargingStationColombo.setCompany(companyTwoOpt.get());
		}
		chargingStationColombo.setLatitude(6.9271);
		chargingStationColombo.setLongitude(79.8612);
		assertNotNull(chargingService.createChargingStation(chargingStationColombo));
	}

	@Test
	public void getAllStationsByJpa() {
		List<ChargingStation> chargingStations = chargingRepository.findAll();
		assertNotNull(chargingStations);
	}

	@Test
	public void getAllCompaniesByJpa() {
		List<Company> companies = companyRepository.findAll();
		assertNotNull(companies);
	}
}
