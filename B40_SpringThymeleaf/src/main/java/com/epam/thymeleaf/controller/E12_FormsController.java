package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.thymeleaf.domain.Customer;
import com.epam.thymeleaf.domain.Gender;
import com.epam.thymeleaf.domain.PaymentMethod;

@Controller
public class E12_FormsController {

	@GetMapping("/e12forms")
	public String getFormsPage(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("genders", Gender.values());
		model.addAttribute("paymentMethods", PaymentMethod.values());

		return "e12forms";
	}

	@PostMapping("/e12forms")
	public String saveCustomer() {
		
		// TODO: Complete.
		
		return "e12forms";
	}
}
