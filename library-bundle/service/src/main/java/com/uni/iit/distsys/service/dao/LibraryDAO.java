package com.uni.iit.distsys.service.dao;

import java.util.Collection;

import com.uni.iit.distsys.core.model.Book;

public interface LibraryDAO {

	void addNew(Book book);

	boolean reserve(Book book);

	boolean checkout(Book book);

	Collection<Book> listAllAvailableBook();

	Collection<Book> listAllBookByTitle(String title);

	Collection<Book> listAllBookByAuthor(String author);
}
