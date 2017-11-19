package com.uni.iit.distsys.service.impl;

import java.util.Collection;

import com.uni.iit.distsys.core.model.BookFine;
import com.uni.iit.distsys.core.service.FineCalculatorSearchService;
import com.uni.iit.distsys.service.dao.FineDAO;

public class FineCalculatorSearchServiceImpl implements FineCalculatorSearchService {
	
	private FineDAO dao;
	
	public FineCalculatorSearchServiceImpl(FineDAO dao) {
		this.dao = dao;
	}

	@Override
	public Collection<BookFine> listAllBookFine() {
		return this.dao.listAllBookFine();
	}

}
