package com.priyan.chargingstation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.service.ChargingService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChargingController {

	@Autowired
	private ChargingService chargingService;

	@PostMapping("/stations")
	public ResponseEntity createChargingStation(@RequestBody ChargingStation chargingStationEntity) {
		try {
			return new ResponseEntity<>(chargingService.createChargingStation(chargingStationEntity),HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/stations")
	public ResponseEntity getChargingStations() {
		try {
			List<ChargingStation> chargingStations = chargingService.getChargingStations();
			if (chargingStations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(chargingStations, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/companies")
	public ResponseEntity createCompanies(@RequestBody Company company) {
		try {
			return new ResponseEntity<>(chargingService.createCompanies(company),HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/companies")
	public ResponseEntity getCompanies() {
		try {
			List<Company> companies = chargingService.getCompanies();
			if (companies.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(companies, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/stations/{radius}/{latitude}/{longitude}")
	public ResponseEntity getStationsByRadius(@PathVariable Double radius,@PathVariable Double latitude,@PathVariable Double longitude) {
		try {
			Map<Double,ChargingStation> companies = chargingService.getStationsByRadius(radius,latitude,longitude);
			if (companies.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(companies, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/companies/{companyName}")
	public ResponseEntity getSubCompanies(@PathVariable String companyName) {
		try {
			List<Company> companies = chargingService.getChildCompanies(companyName);
			if (companies.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(companies, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
