package com.hp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hp.DAO.EmployeeSpringDAO;
import com.hp.bean.Emp;
import com.hp.bean.EmployeeBean;

@RestController
@RequestMapping("/emp")
public class EmployeeJdbcController {
	@Autowired
	private EmployeeSpringDAO empdao;
	
	
	@RequestMapping(value="/insert" ,method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Integer insertEmp(@RequestBody Emp emp) {
		
		
		System.out.println("fetching empdetails");
		return empdao.insertEmp(emp);
		
		
	}
	@RequestMapping(value="/get/{empId}" ,method=RequestMethod.GET)
	public EmployeeBean getEmp(@PathVariable("empId") Integer eId) {
		
		
		System.out.println("fetching empdetails");
		return empdao.getEmp(eId);
		
		
	}
	@RequestMapping(value="/getAll" ,method=RequestMethod.GET)
	public List<EmployeeBean> getAllEmp() {
		
		
		System.out.println("fetching empdetails");
		return empdao.getAllEmp();
		
		
	}
	
	@PostMapping(value="/UpdateEmployee" )
	public EmployeeBean updateEmp(@RequestBody EmployeeBean emp) {
		
		System.out.println("updating empdetails");
		return empdao.updateEmp(emp);
		
		
	}
	
	
	

}
