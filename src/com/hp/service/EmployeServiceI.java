package com.hp.service;

import java.util.List;

import com.hp.Entity.Address;
import com.hp.bean.EmployeeBean;

public interface EmployeServiceI {
	public EmployeeBean searchEmployee(Integer empId);
	 
	public List<EmployeeBean> getAllEmp();
	
	

	public String saveAddress(Address address);

}
