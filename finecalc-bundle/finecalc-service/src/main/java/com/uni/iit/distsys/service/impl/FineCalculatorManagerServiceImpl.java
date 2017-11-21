package com.uni.iit.distsys.service.impl;

import java.time.Duration;
import java.util.Collection;
import java.util.Date;

import com.uni.iit.distsys.core.model.BookFine;
import com.uni.iit.distsys.core.service.FineCalculatorManagerService;
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
	public int calculateFinesInHuf(Date date) {
		int retSum = 0;
		
		if (date == null) {
			date = new Date();
		}

		Collection<BookFine> bookFines = this.dao.listAllBookFine();
		int loanPeriodInDays = this.dao.getLoanPeriodInDays();
		int fine = this.dao.getFineForADayInHuf();

		for (BookFine bookFine : bookFines) {
			int diff = (int) Duration.between(bookFine.getCheckoutDate().toInstant(), date.toInstant()).toDays();

			if (diff > loanPeriodInDays) {
				int amount = (diff - loanPeriodInDays) * fine;
				
				bookFine.setAmount(amount);
				bookFine.setCurrency("HUF");
				
				retSum += amount;
			} else {
				bookFine.setAmount(0);
				bookFine.setCurrency("HUF");
			}
		}
		
		return retSum;
	}

	@Override
	public void setLoanPeriod(int newDays) {
		this.dao.setLoanPeriodInDays(newDays);
	}

	@Override
	public void setFinePerDay(int newFineInHuf) {
		this.dao.setFineForADayInHuf(newFineInHuf);
	}
}
