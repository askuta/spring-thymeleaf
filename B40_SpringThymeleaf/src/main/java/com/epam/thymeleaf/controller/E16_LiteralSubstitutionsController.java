package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class E16_LiteralSubstitutionsController {

	@GetMapping("/e16literalsubstitutions")
	public String getLiteralSubstitutionsPage(Model model) {
		model.addAttribute("customerName", "Peter");

		return "e16literalsubstitutions";
	}
}
