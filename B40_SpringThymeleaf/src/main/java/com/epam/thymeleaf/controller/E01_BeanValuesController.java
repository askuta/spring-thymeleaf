package com.epam.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.thymeleaf.domain.Product;

@Controller
public class E01_BeanValuesController {

	@GetMapping("/e01beanvalues")
	public String getBeanValuesPage(ModelMap model) {
		@SuppressWarnings("deprecation")
		Date availableFrom = new Date(113, 2, 18, 0, 0, 0);
		Product product = new Product("Wooden wardrobe with glass doors", 850, availableFrom);
		model.put("product", product);

		return "e01beanvalues";
	}
}
