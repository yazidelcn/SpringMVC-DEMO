package com.elcnyazid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elcnyazid.models.Product;

@Controller
public class ProductController {
	
	
	@GetMapping("/")
	public String showCart() {
		return"form";
	}
	
	@PostMapping("/addProd")
	public String processForm(Product prod, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("prod",prod);
		System.out.println("Saving to DB  Produt :" + prod.getName() + " Qte : "+prod.getQuantity());
		return"redirect:/thankyou";
	}
	
	@GetMapping("/thankyou")
	public String showThankU() {
		return"thankyou";
	}
	
}
