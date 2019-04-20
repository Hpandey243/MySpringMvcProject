package com.hp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hp.bean.EmployeeBean;
import com.hp.service.EmployeeServiceImpl;
@RequestMapping("/empl")
@RestController
public class EmployeeOrmController {
	/*@Autowired
	EmployeeOrmDAO empOdao;*/
	
	@Autowired
	EmployeeServiceImpl empservice;
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	
	@RequestMapping(value="/insertEmp" ,method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertOrmEmp(@RequestBody EmployeeBean emp) {		
		System.out.println("inserting empdetails");
		//empOdao.insert(emp);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/search/{empId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeBean searchEmploye(@PathVariable Integer empId) {
	//return empOdao.searchEmployee(empId);
		return null;
		
		 
	}
	
	@RequestMapping(value="/getAllEmp" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeBean> getAllOrmEmp() {
		
		
		System.out.println("fetching empdetails");
	    List<EmployeeBean> res=empservice.getAllEmp();
	return res;
		//return empOdao.getAllEmp();
		
		
	}

	@RequestMapping(value="/delEmp" ,method=RequestMethod.DELETE)
	public ResponseEntity<Void> delEmp(Integer empId) {
		System.out.println("deleting  empdetails");
		//empOdao.delete(empId);
		return new ResponseEntity<>(HttpStatus.GONE);
		
		
	}
	
	

}
