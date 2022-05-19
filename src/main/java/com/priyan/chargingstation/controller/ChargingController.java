package com.priyan.chargingstation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.service.ChargingService;

@RestController
@RequestMapping("/api")
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
	
}
