package com.epam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TasksController {

	@ModelAttribute("module")
	String module() {
		return "tasks";
	}

	@GetMapping("/tasks")
	public String about() {
		return "tasks";
	}
}
