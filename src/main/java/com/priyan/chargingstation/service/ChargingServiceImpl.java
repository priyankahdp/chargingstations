package com.priyan.chargingstation.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

	@Override
	public Map<Double,ChargingStation> getStationsByRadius(Double radius, Double latitude, Double longitude) {
		List<ChargingStation> chargingStations = chargingDao.getChargingStations();
		Map<Double,ChargingStation> distances = new TreeMap<>();
		chargingStations.forEach(chargingStation -> {
			Double distance = calculateDistance(latitude, longitude, chargingStation.getLatitude(),chargingStation.getLongitude());
			DecimalFormat df = new DecimalFormat("#.#");
			Double formattedDistance=Double.valueOf(df.format(distance));
			if (radius > distance) {
				distances.put(formattedDistance,chargingStation);
			}
		});
		return distances;
	}

	public Double calculateDistance(Double latitude1, Double longitude1, Double latitude2, Double longitude2) {
		// applied Haversine formula, it will be returned result in meters within given
		// two locations
		final int R = 6371;
		Double latDistance = Math.toRadians(latitude2 - latitude1);
		Double lonDistance = Math.toRadians(longitude2 - longitude1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(latitude1))
				* Math.cos(Math.toRadians(latitude2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return R * c;
	}

	@Override
	public List<Company> getChildCompanies(String companyName) {
		return chargingDao.getChildCompanies(companyName);
	}

}
