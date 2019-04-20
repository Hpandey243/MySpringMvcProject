package com.hp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hp.bean.EmployeeBean;

public class EmpRowMapper implements RowMapper<EmployeeBean>{

	@Override
	public EmployeeBean mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		EmployeeBean em=new EmployeeBean();
		em.setEmpId(rs.getInt("empId"));
		em.seteName(rs.getString("eName"));
		return em;
	}
	

}
