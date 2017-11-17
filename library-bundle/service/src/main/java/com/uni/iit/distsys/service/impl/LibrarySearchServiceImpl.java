package com.uni.iit.distsys.service.impl;

import java.util.Collection;

import com.uni.iit.distsys.core.model.Book;
import com.uni.iit.distsys.core.service.LibrarySearchService;
import com.uni.iit.distsys.service.dao.LibraryDAO;

public class LibrarySearchServiceImpl implements LibrarySearchService {
	
	private LibraryDAO dao;

	public LibrarySearchServiceImpl(LibraryDAO dao) {
		this.dao = dao;
	}

	@Override
	public Collection<Book> listAllAvailableBook() {
		return this.dao.listAllAvailableBook();
	}
	
	@Override
	public Collection<Book> listAllNotAvailableBook() {
		return this.dao.listAllNotAvailableBook();
	}

	@Override
	public Collection<Book> listAllBookByTitle(String title) {
		return this.dao.listAllBookByTitle(title);
	}

	@Override
	public Collection<Book> listAllBookByAuthor(String author) {
		return this.dao.listAllBookByAuthor(author);
	}

}
