package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class E11_LinksController {

	@GetMapping("/e11links")
	public String getLinksPage() {
		return "e11links";
	}
}
