package com.hp.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hp.bean.EmployeeBean;

@Controller
@RequestMapping("/first")
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		/*ModelAndView mdv=new ModelAndView();
		mdv.setViewName("NewFile1");
		return mdv;*/
		return "NewFile1";
		
	}
	
	
	@RequestMapping("/something")
	public String doSomething(){
		/*model.addAttribute("userName",userN);
		return "NewFile";*/
		
		return "admission";
		
	
		
	}
	
	@RequestMapping(value="/doSomething",method=RequestMethod.POST)
	public String doSomething1(@RequestParam Map<String, String> param ,Model model){
		model.addAttribute("userName",param.get("userName"));
		return "NewFile";
		
		
		
	
		
	}
	
	
	@RequestMapping("/setPathVar/{userName}/{countryName}")
	public ModelAndView hello(@PathVariable Map<String,String> param)  {
		ModelAndView model =new ModelAndView("NewFile");
		/*model.setViewName("NewFile");*/
		model.addObject("user", "himanshu  "+param.get("userName")+ param.get("countryName"));
		return model;
	}
	
	@RequestMapping(value="/employee.html",method=RequestMethod.POST)
	public ModelAndView employee(@Valid @ModelAttribute("emp") EmployeeBean emp ,BindingResult result)  {
		if (result.hasErrors()) {
			ModelAndView model =new ModelAndView("NewFile");
			model.addObject("att","hellooo");
			  return model;
			
		}
		ModelAndView model =new ModelAndView("NewFile");
	   /*model.setViewName("NewFile");*/
	 
		return model;
	}
	
	@ModelAttribute
	public void addCommonObject(Model model)
	{
		model.addAttribute("msg","details using model attribute");
	}
	
	

}
