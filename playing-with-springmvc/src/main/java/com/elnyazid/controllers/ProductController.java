package com.elnyazid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elnyazid.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	@GetMapping("/form")
	public String showProductForm() {
		return "products/prodForm";
	}

	@GetMapping("/showproduct")
	// http://localhost:8080/playing-with-springmvc/products/showproduct?name=myProd&qte=1200
	public String showProduct(@RequestParam String name,
			@RequestParam(/* value="qte", */required = false, defaultValue = "0") Integer quantity) {
		System.out.println("Prouct name : " + name + " quantity : " + quantity);
		return "home";
	}
	
	@GetMapping("/showproduct2")
	public String showProductWithDataBinding(Product product) {
		System.out.println("Prouct name : " + product.getName() + " quantity : " + product.getQuantity());
		return "home";
	}
	
	//using Model
	@GetMapping("/prodDetails")
	public String passingProductToView(Model model) {
		Product p = new Product();
		p.setName("Product-One");
		p.setQuantity(150);
		model.addAttribute("prod", p);
		return"products/showProd";
	}
	//Using @ModelAttribute as a Method Parameter
	@GetMapping("/prodDetails2")
	public String passingProductToView2(@ModelAttribute("prod") Product p) {
		//Product p = new Product();
		p.setName("Product-two");
		p.setQuantity(200);
		//model.addAttribute("prod", p);
		return"products/showProd";
	}

}
