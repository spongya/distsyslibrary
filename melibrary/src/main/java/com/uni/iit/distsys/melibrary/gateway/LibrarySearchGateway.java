package com.uni.iit.distsys.melibrary.gateway;

import java.util.Collection;

import org.springframework.integration.annotation.Payload;

import com.uni.iit.distsys.melibrary.model.Book;

public interface LibrarySearchGateway {
	@Payload("new java.util.Date()")
	Collection<Book> listAllAvailableBook();

}
