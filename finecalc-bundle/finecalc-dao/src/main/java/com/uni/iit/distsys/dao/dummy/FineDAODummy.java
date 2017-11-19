package com.uni.iit.distsys.dao.dummy;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import com.uni.iit.distsys.core.model.BookFine;
import com.uni.iit.distsys.service.dao.FineDAO;

public class FineDAODummy implements FineDAO {
	private int loanPeriodInDays;
	private int fineForADayInHuf;

	private Collection<BookFine> fines;

	public FineDAODummy(int loanPeriodInDays, int fineForADayInHuf) {
		this.fines = new HashSet<>();

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
