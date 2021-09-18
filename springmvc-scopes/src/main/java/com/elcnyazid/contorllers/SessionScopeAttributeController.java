package com.elcnyazid.contorllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/session")
@SessionAttributes({ "Login" })
public class SessionScopeAttributeController {
	@GetMapping("/")
	// we still get access to Login because it's in the session scope
	public String setSessionAttributes(Model model, HttpSession session) {
		model.addAttribute("Login", "YazidEl");
		model.addAttribute("other", " Irrelevant");
		session.setAttribute("Login", "Can't override");
		session.setAttribute("Pass", "Dummy123");
		// When you use HttpSession to add Session Attribute, it will add immedidately
		// when you use @SessionAttribute to add attribute, it will add just before the
		// page rendering,
		// before the current request ends
		//session.invalidate(); -> Remove all attribute in httpSession 
		//session.removeAttribute("Login");
		return "redirect:/session/display";
	}

	@GetMapping("/display")
	public String displaySession(SessionStatus status) {
		 //Only remove attributes set by using @SessionAttribute
        //It removes attributes from session scope after the page rendering
        status.setComplete();
		return "display";
	}
}
