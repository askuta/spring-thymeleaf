package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AboutController {

	@ModelAttribute("module")
	String module() {
		return "about";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}
}
