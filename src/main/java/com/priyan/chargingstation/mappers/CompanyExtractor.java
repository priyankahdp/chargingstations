package com.priyan.chargingstation.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.priyan.chargingstation.entity.Company;

public class CompanyExtractor implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int i) throws SQLException {
		Company p = new Company();
		p.setCompanyId(rs.getInt("company_id"));
		p.setName(rs.getString("name"));
		//p.getParentCompany().setCompanyId(rs.getInt("parent_company_id"));
		return p;
	}
}