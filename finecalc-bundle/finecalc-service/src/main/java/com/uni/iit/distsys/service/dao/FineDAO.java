package com.uni.iit.distsys.service.dao;

import java.util.Collection;
import java.util.Date;

import com.uni.iit.distsys.core.model.BookFine;

public interface FineDAO {
	
	int getLoanPeriodInDays();
	
	void setLoanPeriodInDays(int newLoanPeriodInDays);
	
	int getFineForADayInHuf();
	
	void setFineForADayInHuf(int newFineForADayInHuf);
	
	void addNewCheckedoutBook(String author, String title, String language, Date checkoutDate);
	
	Collection<BookFine> listAllBookFine();

}
