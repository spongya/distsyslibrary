package com.uni.iit.distsys.dao.dummy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.uni.iit.distsys.core.model.BookFine;
import com.uni.iit.distsys.service.dao.FineDAO;

public class FineDAODummy implements FineDAO {
	private int loanPeriodInDays;
	private int fineForADayInHuf;

	private Collection<BookFine> fines;

	public FineDAODummy(int loanPeriodInDays, int fineForADayInHuf) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.fines = new ArrayList<>();
		
		try {
			this.fines.add(new BookFine("George R. R. Martin: A Game of Thrones (Hungarian)", format.parse("2017-09-01")));
			this.fines.add(new BookFine("George R. R. Martin: A Clash of Kings (Hungarian)", format.parse("2017-11-01")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.loanPeriodInDays = loanPeriodInDays;
		this.fineForADayInHuf = fineForADayInHuf;
	}

	@Override
	public int getLoanPeriodInDays() {
		return this.loanPeriodInDays;
	}

	@Override
	public void setLoanPeriodInDays(int newLoanPeriodInDays) {
		this.loanPeriodInDays = newLoanPeriodInDays;
	}

	@Override
	public int getFineForADayInHuf() {
		return this.fineForADayInHuf;
	}

	@Override
	public void setFineForADayInHuf(int newFineForADayInHuf) {
		this.fineForADayInHuf = newFineForADayInHuf;
	}

	@Override
	public void addNewCheckedoutBook(String author, String title, String language, Date checkoutDate) {
		this.fines.add(new BookFine(author + ": " + title + " (" + language + ")", checkoutDate));
	}

	@Override
	public Collection<BookFine> listAllBookFine() {
		return this.fines;
	}
}
