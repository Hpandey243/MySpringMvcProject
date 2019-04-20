package com.hp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hp.DAO.JpaDao;
import com.hp.bean.EmployeeBean;


@RestController
@RequestMapping("/jpaEmployee")
public class EmployeeJpaController {
	@Autowired
	JpaDao employejpadao;

	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome() {
		return "welcome hp";
	}
	@RequestMapping(value="/insertEmp" ,method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertEmp(@RequestBody EmployeeBean emp) {		
		System.out.println("inserting jpa empdetails");
		employejpadao.insertEmp(emp);
		return new ResponseEntity<>(HttpStatus.CREATED);
				
	}

	@RequestMapping(value="/getAllEmployees" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeBean> getAllOrmEmp() {
		
		
		System.out.println("fetching empdetails");
	    List<EmployeeBean> res=employejpadao.fetchEmployee();
	return res;
		//return empOdao.getAllEmp();
		
		
	}

/*	@RequestMapping(value="/delEmp" ,method=RequestMethod.DELETE)
	public ResponseEntity<Void> delEmp(Integer empId) {
		System.out.println("deleting  empdetails");
		employejpadao.delete(empId);
		return new ResponseEntity<>(HttpStatus.GONE);
		
		
	}*/
}
