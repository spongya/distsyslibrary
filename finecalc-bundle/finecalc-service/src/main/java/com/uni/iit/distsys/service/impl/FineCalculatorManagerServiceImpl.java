package com.uni.iit.distsys.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public Collection<BookFine> listAllBookFineInHuf(String date) {
		Date dateForCalculate = new Date();

		if (!date.toLowerCase().equals("today")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				dateForCalculate = dateFormat.parse(date);
			} catch (ParseException e) {
				System.err.println("Date parse error in FineCalculatorManagerServiceImpl");
				e.printStackTrace();
			}
		}

		Collection<BookFine> bookFines = this.dao.listAllBookFine();
		int loanPeriodInDays = this.dao.getLoanPeriodInDays();
		int fine = this.dao.getFineForADayInHuf();

		for (BookFine bookFine : bookFines) {
			int diff = (int) Duration.between(bookFine.getCheckoutDate().toInstant(), dateForCalculate.toInstant()).toDays();

			if (diff > loanPeriodInDays) {
				bookFine.setAmount((diff - loanPeriodInDays) * fine);
				bookFine.setCurrency("HUF");
			} else {
				bookFine.setAmount(0);
				bookFine.setCurrency("HUF");
			}
		}
		return bookFines;
	}
}
