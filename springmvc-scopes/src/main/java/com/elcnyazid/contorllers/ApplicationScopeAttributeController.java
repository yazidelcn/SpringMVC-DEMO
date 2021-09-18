package com.elcnyazid.contorllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("application")
public class ApplicationScopeAttributeController {
	
	@Autowired
	ServletContext servletContext;
	
	
	@GetMapping("/")
	public String setApplicationContextAttribute() {
		servletContext.setAttribute("appName", "Spring MVC Scopes");
		return "redirect:/application/display";
	}
	
	@GetMapping("/display")
	public String display() {
		return "scopeAttribute";
	}

}
