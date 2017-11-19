package com.uni.iit.distsys.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import com.uni.iit.distsys.core.BookFine;
import com.uni.iit.distsys.service.FineCalculatorManagerService;
import com.uni.iit.distsys.service.dao.FineDAO;

public class FineCalculatorManagerServiceImpl implements FineCalculatorManagerService {
	
	private FineDAO dao;
	
	public FineCalculatorManagerServiceImpl(FineDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addNewCheckedoutBook(String author, String title, String language, Date checkoutDate) {
		this.dao.addNewCheckedoutBook(author, title, language, checkoutDate);
	}

	@Override
	public void calculateFeeInHuf(String date) {
		Date dateForCalculate;
		
		if (date.toLowerCase().equals("today")) {
			dateForCalculate = new Date();
		} else {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				dateForCalculate = dateFormat.parse(date);
			} catch (ParseException e) {
				System.err.println("Date parse error in FineCalculatorManagerServiceImpl");
				e.printStackTrace();
			}
		}
		
		Collection<BookFine> bookFines = this.dao.listAllCheckedOutBooks();
		
		for (BookFine bookFine : bookFines) {
//			if (LocalDateTime.from(bookFine.getCheckoutDate().toInstant()).plusDays(60).tod)
		}

	}

}
