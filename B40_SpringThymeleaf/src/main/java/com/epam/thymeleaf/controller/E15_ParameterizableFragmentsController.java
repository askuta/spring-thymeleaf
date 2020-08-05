package com.epam.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.thymeleaf.domain.Customer;
import com.epam.thymeleaf.domain.Gender;
import com.epam.thymeleaf.domain.PaymentMethod;
import com.epam.thymeleaf.domain.Product;

@Controller
public class E15_ParameterizableFragmentsController {

	@GetMapping("/e15parameterizablefragments")
	public String getParameterizableFragmentsPage(Model model) {
		@SuppressWarnings("deprecation")
		Date availableFrom = new Date(113, 2, 18, 0, 0, 0);
		model.addAttribute("product", new Product("Wooden wardrobe with glass doors", 850, availableFrom));
		model.addAttribute("customer", new Customer(1, "Peter", "Jackson", Gender.MALE, PaymentMethod.DIRECT_DEBIT, 2500000, ""));

		return "e15parameterizablefragments";
	}
}
