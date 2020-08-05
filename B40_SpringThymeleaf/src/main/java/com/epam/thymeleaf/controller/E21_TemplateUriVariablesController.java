package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class E21_TemplateUriVariablesController {

	@GetMapping("/e21templateurivariables")
	public String getConditionalThRemovePage(Model model) {
		model.addAttribute("productId", 42);
		model.addAttribute("productName", "SomeProductName");

		return "e21templateurivariables";
	}
}
