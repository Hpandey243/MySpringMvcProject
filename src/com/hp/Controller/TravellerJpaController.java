package com.hp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hp.DAO.JpaDao;
import com.hp.bean.TravellerBean;
@RestController
@RequestMapping("/jpaTraveller")
public class TravellerJpaController {
	
	@Autowired
	JpaDao jpaDao;
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome() {
		return "welcome jpa traveller";
	}
	
	
	@RequestMapping(value="/insertTraveller" ,method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TravellerBean> insertEmp(@RequestBody TravellerBean traveller) {		
		System.out.println("inserting jpa empdetails");
		jpaDao.insertTraveller(traveller);
		return new ResponseEntity<>(traveller,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/getAllTravellers" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TravellerBean> getAllOrmEmp() {
		
		
		System.out.println("fetching empdetails");
	    List<TravellerBean> res=jpaDao.fetchAllTravellers();
	return res;
		//return empOdao.getAllEmp();
		
		
	}
	@GetMapping(value="/searchTravellers/{travelId}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TravellerBean> searchTraveller(@PathVariable Integer travelId) {
		
		
		System.out.println("fetching empdetails");
	    List<TravellerBean> res=jpaDao.searchTravellers(travelId);
	return res;

		
		
	}

}
