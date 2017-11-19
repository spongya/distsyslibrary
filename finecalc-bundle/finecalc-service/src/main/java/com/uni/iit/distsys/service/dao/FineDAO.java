package com.uni.iit.distsys.service.dao;

import java.util.Collection;
import java.util.Date;

import com.uni.iit.distsys.core.BookFine;

public interface FineDAO {
	
	void addNewCheckedoutBook(String author, String title, String language, Date checkoutDate);
	
	Collection<BookFine> listAllCheckedOutBooks();

}
