package com.hp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.DAO.EmployeeOrmDAO;
import com.hp.DAO.JpaDao;
import com.hp.Entity.Address;
import com.hp.Entity.Employee;
import com.hp.bean.EmployeeBean;
import com.hp.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeServiceI {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeOrmDAO empDao;

	@Autowired
	private JpaDao jpaDao;

	@Override
	public EmployeeBean searchEmployee(Integer empId) {
		// TODO Auto-generated method stub

		return empDao.searchEmployee(empId);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		// TODO Auto-generated method stub
		return empDao.getAllEmp();
	}

	@Override
	public String saveAddress(Address address) {
		return jpaDao.saveAddress(address);

	}

	public Employee findEmployee() {
		return employeeRepository.findById(1).orElse(null);
		// employeeRepository.findOne(1)

	}

}
