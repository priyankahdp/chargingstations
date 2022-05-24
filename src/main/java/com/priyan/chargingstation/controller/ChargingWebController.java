package com.priyan.chargingstation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.priyan.chargingstation.entity.ChargingStation;
import com.priyan.chargingstation.entity.Company;
import com.priyan.chargingstation.service.ChargingService;

@Controller
@CrossOrigin
public class ChargingWebController {

	@Autowired
	private ChargingService chargingService;

	@GetMapping("/")
	public String loadStationsHomePage(Model model) {
		model.addAttribute("listStations",chargingService.getChargingStations());
		model.addAttribute("listCompanies",chargingService.getCompanies());
		return "index";
	}
	
	@GetMapping("/searchStations")
	public String searchStations(Model model) {
		return "searchStations";
	}
	
	@GetMapping("/searchCompanies")
	public String searchCompanies(Model model) {
		return "searchCompanies";
	}
	
	@PostMapping("/stations/find")
	public String getStationsByRadius(String radius,String latitude,String longitude,Model model) {
		Double radiusD=Double.valueOf(radius);
		Double latitudeD=Double.valueOf(latitude);
		Double longitudeD=Double.valueOf(longitude);
		Map<Double,ChargingStation> stations = chargingService.getStationsByRadius(radiusD,latitudeD,longitudeD);
		model.addAttribute("nearby", stations);
		return "searchStations";
	}
	
	@PostMapping("/companies/find")
	public String getSubCompanies(String companyName,Model model) {
		List<Company> companies = chargingService.getChildCompanies(companyName);
		model.addAttribute("subCompanies", companies);
		return "searchCompanies";
	}
}
