package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class E05_EscapedUnescapedTextController {

	private static final String HTML = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";

	@GetMapping("/e05escapedunescapedtext")
	public String getEscapedUnescapedTextPage(ModelMap model) {
		model.put("html", HTML);

		return "e05escapedunescapedtext";
	}
}
