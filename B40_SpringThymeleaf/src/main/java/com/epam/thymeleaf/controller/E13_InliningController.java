package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class E13_InliningController {

	@GetMapping("/e13inlining")
	public String getInliningPage(Model model) {
		model.addAttribute("customerName", "Tasziló");

		return "e13inlining";
	}
}
