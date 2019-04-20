
package com.hp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.hp.bean.Emp;
import com.hp.bean.EmployeeBean;
import com.hp.rowmapper.EmpRowMapper;

@Component

public class EmployeeSpringDAO {

	@SuppressWarnings("unused")
	private NamedParameterJdbcTemplate namedjdbc;

	@Autowired
	public void setNamedJdbcTemp(DataSource ds) {
		this.namedjdbc = new NamedParameterJdbcTemplate(ds);
	}

	private JdbcTemplate jdbctemplate;

	@Autowired
	public void setJdbcTemp(DataSource ds) {
		this.jdbctemplate = new JdbcTemplate(ds);
	}

	public Integer insertEmp(Emp emp) {
		String query = "insert into employee values(?,?)";
		Object[] params = { emp.getEmpId(), emp.geteName() };
		int r = jdbctemplate.update(query, params);
		return r;

	}

	public EmployeeBean getEmp(Integer empId) {
		String query = "select * from employee where empid=?";
		// String query="select * from employee where empid=:emp_Id";
		// SqlParameterSource namedparam =new MapSqlParameterSource("emp_Id", empId);

		RowMapper<EmployeeBean> rowMapper = new RowMapper<EmployeeBean>() {

			@Override
			public EmployeeBean mapRow(ResultSet rs, int arg1) throws SQLException {
				EmployeeBean em = new EmployeeBean();
				em.setEmpId(rs.getInt("empId"));
				em.seteName(rs.getString("eName"));

				return em;
			}
		};

		return jdbctemplate.queryForObject(query, rowMapper, empId);

	}
	/*
	 * public List<EmployeDB> getEmpUsingNamedJdbc(Integer empId) { String
	 * query="select * from employee where empid=:emp_Id"; SqlParameterSource
	 * namedparam =new MapSqlParameterSource("emp_Id", empId); RowMapper<EmployeDB>
	 * rowMapper=new RowMapper<EmployeDB>() {
	 * 
	 * @Override public EmployeDB mapRow(ResultSet rs, int arg1) throws SQLException
	 * { EmployeDB em=new EmployeDB(); em.setEmpId(rs.getInt("empId"));
	 * em.seteName(rs.getString("eName"));
	 * 
	 * return em; } }; return namedjdbc.query(query, namedparam,rowMapper);
	 * 
	 * 
	 * }
	 */

	public List<EmployeeBean> getAllEmp() {
		String query = "select * from employee";
		return jdbctemplate.query(query, new EmpRowMapper());

	}

	public EmployeeBean updateEmp(EmployeeBean emp) {
		String query = "update employee set ename=? where empId=?";
		jdbctemplate.update(query, emp.geteName(), emp.getEmpId());
		EmployeeBean e = this.getEmp(emp.getEmpId());
		return e;

	}

}
