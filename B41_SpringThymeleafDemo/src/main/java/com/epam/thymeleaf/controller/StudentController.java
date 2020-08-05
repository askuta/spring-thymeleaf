package com.epam.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.thymeleaf.domain.Gender;
import com.epam.thymeleaf.domain.Student;

@Controller
public class StudentController {

	private List<Student> students;

	public StudentController() {
		this.students = getStudents();
	}

	@GetMapping({ "", "/", "/index" })
	public String indexPage() {
		return "index";
	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", students);

		return "students";
	}

	@GetMapping("/studentForm")
	public String studentForm(Model model) {
		model.addAttribute("student", new Student());
		//model.addAttribute("genders", Gender.values());

		return "studentForm";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student student, BindingResult errors, Model model) {
		students.add(student);

		return "redirect:students";
	}

	private List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Tudor", Gender.FEMALE));
		students.add(new Student(2, "Vidor", Gender.MALE));
		students.add(new Student(3, "Morgó", Gender.FEMALE));
		students.add(new Student(4, "Szundi", Gender.MALE));
		students.add(new Student(5, "Szende", Gender.FEMALE));
		students.add(new Student(6, "Hapci", Gender.MALE));
		students.add(new Student(7, "Kuka", Gender.FEMALE));

		return students;
	}
}
