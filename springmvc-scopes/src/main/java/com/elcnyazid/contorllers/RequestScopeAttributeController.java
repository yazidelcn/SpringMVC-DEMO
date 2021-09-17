package com.elcnyazid.contorllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestScopeAttributeController {
	//forward happens on the server side , the request attributes are carried to the next request, (the request scope is still available)
	//the URL remain the same
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("nom", "yazid");
		model.addAttribute("age", 26);
		return "forward:/target";
	}
	
	/*the browser make a new request, we can no longer retrieve the request attributes 
	 * the URL change (we can ignore the default mode on the configuration)
	 * @GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("nom", "yazid");
		model.addAttribute("age", 26);
		return "redirect:/target";
	}
	*/
	
	@GetMapping("/target")
	public String getTarget() {
		return "home";
	}
	
	
}
