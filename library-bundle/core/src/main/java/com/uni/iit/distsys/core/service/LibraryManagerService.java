package com.uni.iit.distsys.core.service;

import com.uni.iit.distsys.core.model.Book;

public interface LibraryManagerService {

	void addNewBook(Book book);

	void addNewBook(String author, String title, String publisher, int publishingYear, String language, int version,
			String isbnNumber);

	void reserveBook(Book book);
	
	void checkOutBook(Book book);
}
