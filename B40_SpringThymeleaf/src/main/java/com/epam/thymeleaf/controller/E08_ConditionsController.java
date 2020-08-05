package com.epam.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.thymeleaf.domain.Product;

@Controller
public class E08_ConditionsController {

	@SuppressWarnings("deprecation")
	@GetMapping("/e08conditions")
	public String getConditionsPage(ModelMap model) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("Chair", 25, new Date(113, 2, 18)));
		products.add(new Product("Table", 150, new Date(113, 2, 15)));
		products.add(new Product("Armchair", 85, new Date(113, 2, 20)));
		products.add(new Product("Wardrobe", 450, new Date(113, 2, 21)));
		products.add(new Product("Kitchen table", 49, new Date(113, 2, 15)));
		products.add(new Product("Bookcase", 80, new Date(113, 2, 17)));
		products.add(new Product("White table", 200, new Date(113, 7, 15)));
		products.add(new Product("Red table", 200, new Date(113, 7, 15)));
		products.add(new Product("Blue table", 200, new Date(113, 7, 15)));

		model.put("productList", products);

		return "e08conditions";
	}
}
