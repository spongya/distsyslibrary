package com.uni.iit.distsys.core.service;

import java.util.Collection;
import java.util.Date;

import com.uni.iit.distsys.core.model.BookFine;

public interface FineCalculatorManagerService {
	
	void addNewCheckedoutBook(String author, String title, String language, Date checkoutDate);
	
	Collection<BookFine> listAllBookFineInHuf(String date);

}
