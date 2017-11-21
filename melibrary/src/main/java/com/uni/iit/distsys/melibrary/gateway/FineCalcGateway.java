package com.uni.iit.distsys.melibrary.gateway;

import java.util.Collection;
import java.util.Date;

import org.springframework.integration.annotation.Payload;

import com.uni.iit.distsys.melibrary.model.Book;
import com.uni.iit.distsys.melibrary.model.BookFine;

public interface FineCalcGateway {
	
	void addNewCheckedoutBook(@Payload Book book);
	
	void calculateFinesInHuf(@Payload Date date);
	
	@Payload("new java.util.Date()")
	Collection<BookFine> getAllBookFines();
	
	void setLoanPeriod(@Payload int newDays);
	
	void setFinePerDay(@Payload int newFineInHuf);
}
