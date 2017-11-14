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
	public void addNewBook(String author, String title, String publisher, int publishingYear, String language,
			int version, String isbnNumber) {
		this.dao.addNew(new Book(author, title, publisher, publishingYear, language, version, isbnNumber));
	}

	@Override
	public void reserveBook(Book book) {
		this.dao.reserve(book);
	}

	@Override
	public void checkOutBook(Book book) {
		this.dao.checkout(book);
	}

}
