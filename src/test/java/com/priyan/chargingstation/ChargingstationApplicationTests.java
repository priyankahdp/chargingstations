package com.priyan.chargingstation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.repository.ChargingRepository;
import com.priyan.chargingstation.repository.CompanyRepository;
import com.priyan.chargingstation.service.ChargingService;

@TestMethodOrder(OrderAnnotation.class)
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
	@Order(1)  
	public void createCompany() {
		Company companyABC = new Company();
		companyABC.setName("ABC Company");
		assertNotNull(chargingService.createCompanies(companyABC));
		
		Company companyABCsub = new Company();
		companyABCsub.setName("ABC sub Company");
		companyABCsub.setParentCompany(companyABC);
		assertNotNull(chargingService.createCompanies(companyABCsub));

		Company companyPQR = new Company();
		companyPQR.setName("PQR Company");
		assertNotNull(chargingService.createCompanies(companyPQR));

		Company companyPQRsub = new Company();
		companyPQRsub.setName("PQR sub Company");
		companyPQRsub.setParentCompany(companyPQR);
		assertNotNull(chargingService.createCompanies(companyPQRsub));
		
		Company companyXYZ = new Company();
		companyXYZ.setName("XYZ Company");
		assertNotNull(chargingService.createCompanies(companyXYZ));

		Company companyXyzSub = new Company();
		companyXyzSub.setName("Xyz sub company");
		companyXyzSub.setParentCompany(companyXYZ);
		assertNotNull(chargingService.createCompanies(companyXyzSub));
		
		Company companyXyzOneSub = new Company();
		companyXyzOneSub.setName("Xyz sub sub company");
		companyXyzOneSub.setParentCompany(companyXyzSub);
		assertNotNull(chargingService.createCompanies(companyXyzOneSub));
	}

	@Test
	@Order(2)  
	public void createStation() {
		ChargingStation chargingStationNorrbotten = new ChargingStation();
		chargingStationNorrbotten.setName("Luleå, Norrbotten");
		Optional<Company> companyOneOpt = companyRepository.findById(1);
		if (companyOneOpt.isPresent()) {
			chargingStationNorrbotten.setCompany(companyOneOpt.get());
		}
		chargingStationNorrbotten.setLatitude(65.584816);
		chargingStationNorrbotten.setLongitude(22.156704);
		assertNotNull(chargingService.createChargingStation(chargingStationNorrbotten));

		ChargingStation chargingStationVasteras = new ChargingStation();
		chargingStationVasteras.setName("Västerås");
		Optional<Company> companyTwoOpt = companyRepository.findById(2);
		if (companyTwoOpt.isPresent()) {
			chargingStationVasteras.setCompany(companyTwoOpt.get());
		}
		chargingStationVasteras.setLatitude(59.611366);
		chargingStationVasteras.setLongitude(16.545025);
		assertNotNull(chargingService.createChargingStation(chargingStationVasteras));
		
		
		ChargingStation chargingStationUmea = new ChargingStation();
		chargingStationUmea.setName("Umeå");
		
		if (companyTwoOpt.isPresent()) {
			chargingStationUmea.setCompany(companyTwoOpt.get());
		}
		chargingStationUmea.setLatitude(63.825848);
		chargingStationUmea.setLongitude(16.545025);
		assertNotNull(chargingService.createChargingStation(chargingStationUmea));
		
		ChargingStation chargingStationStockholm = new ChargingStation();
		chargingStationStockholm.setName("Stockholm");
		
		if (companyOneOpt.isPresent()) {
			chargingStationStockholm.setCompany(companyOneOpt.get());
		}
		chargingStationStockholm.setLatitude(59.334591);
		chargingStationStockholm.setLongitude(18.063240);
		assertNotNull(chargingService.createChargingStation(chargingStationStockholm));
		
		ChargingStation chargingStationGothenburg = new ChargingStation();
		chargingStationGothenburg.setName("Gothenburg");
		
		if (companyTwoOpt.isPresent()) {
			chargingStationGothenburg.setCompany(companyTwoOpt.get());
		}
		chargingStationGothenburg.setLatitude(57.708870);
		chargingStationGothenburg.setLongitude(11.974560);
		assertNotNull(chargingService.createChargingStation(chargingStationGothenburg));
	}

	@Test
	@Order(3)
	public void getStationsTest() {
		List<ChargingStation> chargingStations = chargingService.getChargingStations();
		assertNotNull(chargingStations);
	}

	@Test
	@Order(4)
	public void getCompaniesTest() {
		List<Company> companies = chargingService.getCompanies();
		assertNotNull(companies);
	}
	
	@Test
	@Order(5)
	public void getAllStationsByJpa() {
		List<ChargingStation> chargingStations = chargingRepository.findAll();
		assertNotNull(chargingStations);
	}

	@Test
	@Order(6)
	public void getAllCompaniesByJpa() {
		List<Company> companies = companyRepository.findAll();
		assertNotNull(companies);
	}
	
	@Test
	@Order(7)
	public void getAllStationsCount() {
		List<ChargingStation> chargingStations = chargingRepository.findAll();
		assertEquals(true,chargingStations.size()>0);
	}

	@Test
	@Order(8)
	public void getAllCompaniesCount() {
		List<Company> companies = companyRepository.findAll();
		assertEquals(true,companies.size()>0);
	}
}
