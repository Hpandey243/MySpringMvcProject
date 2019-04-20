package com.hp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.bean.StudentBean;



@Controller
@RequestMapping("/rest")
public class RestController {
	
	@RequestMapping("/test")
	public String test() {
		return "admission";
	}
	
	@ResponseBody
	@RequestMapping(value="/getAddress")
	public StudentBean getAddress() {
		
		StudentBean s=new StudentBean();
		s.setName("hp");
		return s;
	}

}
