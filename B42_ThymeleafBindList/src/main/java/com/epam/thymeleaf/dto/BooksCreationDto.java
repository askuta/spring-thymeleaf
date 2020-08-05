package com.epam.thymeleaf.dto;

import java.util.ArrayList;
import java.util.List;

import com.epam.thymeleaf.domain.Book;

public class BooksCreationDto {

	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
