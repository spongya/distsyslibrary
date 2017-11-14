package com.uni.iit.distsys.core.service;

import java.util.Collection;

import com.uni.iit.distsys.core.model.Book;

public interface LibrarySearchService {

	Collection<Book> listAllAvailableBook();

	Collection<Book> listAllBookByTitle(String title);

	Collection<Book> listAllBookByAuthor(String author);

}
