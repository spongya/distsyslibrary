package com.uni.iit.distsys.service.impl;

import java.util.Collection;

import com.uni.iit.distsys.core.BookFine;
import com.uni.iit.distsys.service.FineCalculatorSearchService;
import com.uni.iit.distsys.service.dao.FineDAO;

public class FineCalculatorSearchServiceImpl implements FineCalculatorSearchService {
	
	private FineDAO dao;
	
	public FineCalculatorSearchServiceImpl(FineDAO dao) {
		this.dao = dao;
	}

	@Override
	public Collection<BookFine> listAllCheckedOutBooks() {
		return this.dao.listAllCheckedOutBooks();
	}

}
