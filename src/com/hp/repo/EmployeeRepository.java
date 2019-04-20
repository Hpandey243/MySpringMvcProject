package com.hp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hp.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	

}