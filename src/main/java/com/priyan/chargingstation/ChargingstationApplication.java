package com.priyan.chargingstation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.repository.ChargingRepository;
import com.priyan.chargingstation.repository.CompanyRepository;
import com.priyan.chargingstation.service.ChargingService;

@SpringBootApplication
public class ChargingstationApplication implements CommandLineRunner{

	@Autowired
	private ChargingService chargingService;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ChargingRepository chargingRepository;
	
	public static void main(String[] args) {
    	System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(ChargingstationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Company companyABC = new Company();
		companyABC.setName("ABC Company");
		chargingService.createCompanies(companyABC);
		
		Company companyABCsub = new Company();
		companyABCsub.setName("ABC sub Company");
		companyABCsub.setParentCompany(companyABC);
		chargingService.createCompanies(companyABCsub);

		Company companyPQR = new Company();
		companyPQR.setName("PQR Company");
		chargingService.createCompanies(companyPQR);

		Company companyPQRsub = new Company();
		companyPQRsub.setName("PQR sub Company");
		companyPQRsub.setParentCompany(companyPQR);
		chargingService.createCompanies(companyPQRsub);
		
		Company companyXYZ = new Company();
		companyXYZ.setName("XYZ Company");
		chargingService.createCompanies(companyXYZ);

		Company companyXyzSub = new Company();
		companyXyzSub.setName("Xyz sub company");
		companyXyzSub.setParentCompany(companyXYZ);
		chargingService.createCompanies(companyXyzSub);
		
		Company companyXyzOneSub = new Company();
		companyXyzOneSub.setName("Xyz sub sub company");
		companyXyzOneSub.setParentCompany(companyXyzSub);
		chargingService.createCompanies(companyXyzOneSub);
	
		

		ChargingStation chargingStationNorrbotten = new ChargingStation();
		chargingStationNorrbotten.setName("Luleå, Norrbotten");
		Optional<Company> companyOneOpt = companyRepository.findById(1);
		if (companyOneOpt.isPresent()) {
			chargingStationNorrbotten.setCompany(companyOneOpt.get());
		}
		chargingStationNorrbotten.setLatitude(65.584816);
		chargingStationNorrbotten.setLongitude(22.156704);
		chargingService.createChargingStation(chargingStationNorrbotten);

		ChargingStation chargingStationVasteras = new ChargingStation();
		chargingStationVasteras.setName("Västerås");
		Optional<Company> companyTwoOpt = companyRepository.findById(2);
		if (companyTwoOpt.isPresent()) {
			chargingStationVasteras.setCompany(companyTwoOpt.get());
		}
		chargingStationVasteras.setLatitude(59.611366);
		chargingStationVasteras.setLongitude(16.545025);
		chargingService.createChargingStation(chargingStationVasteras);
		
		
		ChargingStation chargingStationUmea = new ChargingStation();
		chargingStationUmea.setName("Umeå");
		
		if (companyTwoOpt.isPresent()) {
			chargingStationUmea.setCompany(companyTwoOpt.get());
		}
		chargingStationUmea.setLatitude(63.825848);
		chargingStationUmea.setLongitude(16.545025);
		chargingService.createChargingStation(chargingStationUmea);
		
		ChargingStation chargingStationStockholm = new ChargingStation();
		chargingStationStockholm.setName("Stockholm");
		
		if (companyOneOpt.isPresent()) {
			chargingStationStockholm.setCompany(companyOneOpt.get());
		}
		chargingStationStockholm.setLatitude(59.334591);
		chargingStationStockholm.setLongitude(18.063240);
		chargingService.createChargingStation(chargingStationStockholm);
		
		ChargingStation chargingStationGothenburg = new ChargingStation();
		chargingStationGothenburg.setName("Gothenburg");
		Optional<Company> companySixOpt = companyRepository.findById(6);
		if (companySixOpt.isPresent()) {
			chargingStationGothenburg.setCompany(companySixOpt.get());
		}
		chargingStationGothenburg.setLatitude(57.708870);
		chargingStationGothenburg.setLongitude(11.974560);
		chargingService.createChargingStation(chargingStationGothenburg);
	
	}

}
