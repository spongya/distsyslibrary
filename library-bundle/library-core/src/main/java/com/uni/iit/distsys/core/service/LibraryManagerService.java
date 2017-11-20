package com.uni.iit.distsys.core.service;

import com.uni.iit.distsys.core.model.Book;

public interface LibraryManagerService {

	void addNewBook(Book book);

	void addNewBook(String author, String title, String publisher, String language, String isbnNumber);

	boolean reserveBook(Book book);
	
	boolean checkOutBook(Book book);
}
