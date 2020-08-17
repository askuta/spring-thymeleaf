package com.epam.thymeleaf.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

	@ModelAttribute("module")
	String module() {
		return "home";
	}

	@GetMapping({ "", "/" })
	public String defaultHome() {
		return "redirect:home";
	}

	@GetMapping("/home")
	String home(Principal principal) {
		// return principal != null ? "homeSignedIn" : "homeNotSignedIn";
		return "home";
	}
}
