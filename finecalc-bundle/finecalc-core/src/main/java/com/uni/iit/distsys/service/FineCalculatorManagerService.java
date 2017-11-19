package com.uni.iit.distsys.service;

import java.util.Date;

public interface FineCalculatorManagerService {
	
	void addNewCheckedoutBook(String author, String title, String language, Date checkoutDate);
	
	void calculateFeeInHuf(String date);

}
