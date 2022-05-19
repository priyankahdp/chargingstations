package com.priyan.chargingstation.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

	private Integer companyId;
	private String name;
	private Integer parentCompanyId;
	private Set<ChargingStationDto> chargingStationDtos = new HashSet<>();

}