package com.uni.iit.distsys.service.impl;

import com.uni.iit.distsys.core.model.Book;
import com.uni.iit.distsys.core.service.LibraryManagerService;
import com.uni.iit.distsys.service.dao.LibraryDAO;

public class LibraryManagerServiceImpl implements LibraryManagerService {

	private LibraryDAO dao;

	public LibraryManagerServiceImpl(LibraryDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addNewBook(Book book) {
		this.dao.addNew(book);
	}

	@Override
	public void addNewBook(String author, String title, String publisher, String language, String isbnNumber) {
		this.dao.addNew(new Book(author, title, publisher, language, isbnNumber));
	}

	@Override
	public boolean reserveBook(Book book) {
		return this.dao.reserve(book);
	}

	@Override
	public boolean checkOutBook(Book book) {
		return this.dao.checkout(book);
	}

}
