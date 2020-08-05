package com.epam.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.thymeleaf.domain.Book;
import com.epam.thymeleaf.dto.BooksCreationDto;

@Controller
public class BookController {

	private List<Book> books;

	public BookController() {
		books = getBooks();
	}

	@GetMapping({ "", "/" })
	public String getHomePage() {
		return "redirect:books";
	}

	@GetMapping("/books")
	public String getAllBooks(Model model) {
		model.addAttribute("books", books);

		return "books";
	}

	@GetMapping("booksForm")
	public String showBooksForm(Model model) {
		BooksCreationDto booksForm = new BooksCreationDto();
		for (int i = 0; i < 3; i++) {
			booksForm.addBook(new Book());
		}
		model.addAttribute("form", booksForm);

		return "createBooksForm";
	}

	@PostMapping("saveBooks")
	public String createBooks(@ModelAttribute BooksCreationDto booksForm, BindingResult errors, Model model) {
		if (!booksForm.getBooks().isEmpty()) {
			books.addAll(booksForm.getBooks());
		}

		return "redirect:books";
	}

	@GetMapping("editBooksForm")
	public String editBooksForm(Model model) {
		BooksCreationDto booksForm = new BooksCreationDto();
		for (Book book : books) {
			booksForm.addBook(book);
		}
		model.addAttribute("form", booksForm);

		return "editBooksForm";
	}

	@PostMapping("editBooks")
	public String editBooks(@ModelAttribute BooksCreationDto booksForm, BindingResult errors, Model model) {
		if (!booksForm.getBooks().isEmpty()) {
			books.clear();
			books.addAll(booksForm.getBooks());
		}

		return "redirect:books";
	}

	private List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "Book title", "Book author"));

		return books;
	}
}
