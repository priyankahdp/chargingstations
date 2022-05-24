package com.priyan.chargingstation.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "charging_station" )
@Getter
@Setter
public class ChargingStation{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer stationId;

	@Column(name = "name")
	private String name;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Override
	public int hashCode() {
		return Objects.hash(stationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargingStation other = (ChargingStation) obj;
		return Objects.equals(stationId, other.stationId);
	}
	
	

}