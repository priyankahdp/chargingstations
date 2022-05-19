package com.priyan.chargingstation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargingStationDto {

	private Integer stationId;
	private String name;
	private Double latitude;
	private Double longitude;
	private CompanyDto companyDto;

}