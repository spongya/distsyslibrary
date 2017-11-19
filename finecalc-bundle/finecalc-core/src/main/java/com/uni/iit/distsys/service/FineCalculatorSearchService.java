package com.uni.iit.distsys.service;

import java.util.Collection;

import com.uni.iit.distsys.core.BookFine;

public interface FineCalculatorSearchService {
	
	Collection<BookFine> listAllCheckedOutBooks();

}
