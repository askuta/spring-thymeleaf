package com.epam.thymeleaf.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.thymeleaf.domain.Amount;

@Controller
public class E20_ConversionServiceController {

	@SuppressWarnings("deprecation")
	@GetMapping("/e20conversionservice")
	public String getConditionalThRemovePage(Model model) {
		model.addAttribute("price", new Amount(new BigDecimal(2599.50)));
		model.addAttribute("releaseDate", new Timestamp(114, 1, 31, 15, 0, 0, 0));

		return "e20conversionservice";
	}
}
