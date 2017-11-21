package com.uni.iit.distsys.melibrary.gateway;

import java.util.Collection;

import org.springframework.integration.annotation.Payload;

import com.uni.iit.distsys.melibrary.model.Book;

public interface LibraryGateway {
	@Payload("new java.util.Date()")
	Collection<Book> listAllAvailableBook();

	@Payload("new java.util.Date()")
	Collection<Book> listAllNotAvailableBook();

	Collection<Book> getAllByAuthor(@Payload String author);
	
	Collection<Book> getAllByTitle(@Payload String title);
	
	void addBook(@Payload Book book);
	
	void reserveBook(@Payload Book book);
	
	void checkoutBook(@Payload Book book);
}
