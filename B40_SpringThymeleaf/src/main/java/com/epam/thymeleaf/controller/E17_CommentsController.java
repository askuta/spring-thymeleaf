package com.epam.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.thymeleaf.domain.Product;

@Controller
public class E17_CommentsController {

	@GetMapping("/e17comments")
	public String getCommentsPage(Model model) {
		@SuppressWarnings("deprecation")
		Date availableFrom = new Date(113, 2, 18, 0, 0, 0);
		model.addAttribute("product", new Product("Wooden wardrobe with glass doors", 850, availableFrom));

		return "e17comments";
	}
}
