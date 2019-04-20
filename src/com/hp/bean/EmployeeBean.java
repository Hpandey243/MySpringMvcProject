package com.hp.bean;

import java.util.List;

public class EmployeeBean {
	private Integer empId;
	
	private String eName;	
	
	
	private List<AddressBean> address;
	
	
	
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public List<AddressBean> getAddress() {
		return address;
	}

	public void setAddress(List<AddressBean> address) {
		this.address = address;
	}

}
