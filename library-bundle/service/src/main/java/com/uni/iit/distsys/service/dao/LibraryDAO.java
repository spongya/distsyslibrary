package com.uni.iit.distsys.service.dao;

import java.util.Collection;

import com.uni.iit.distsys.core.model.Book;

public interface LibraryDAO {

	void addNew(Book book);

	void reserve(Book book);

	void checkout(Book book);

	Collection<Book> listAllAvailableBook();

	Collection<Book> listAllBookByTitle(String title);

	Collection<Book> listAllBookByAuthor(String author);
}
