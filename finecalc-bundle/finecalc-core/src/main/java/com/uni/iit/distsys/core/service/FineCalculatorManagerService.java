package com.uni.iit.distsys.core.service;

import java.util.Date;

public interface FineCalculatorManagerService {
	
	void addNewCheckedoutBook(String author, String title, String language, Date checkoutDate);
	
	void calculateFinesInHuf(Date date);
	
	void setLoanPeriod(int newDays);
	
	void setFinePerDay(int newFineInHuf);

}
