package com.uni.iit.distsys.core.model;

import java.util.Date;

public class BookFine {

	private int amount;
	private String currency;
	private String details;
	private Date checkoutDate;

	public BookFine(int amount, String currency, String details, Date checkoutDate) {
		this.amount = amount;
		this.currency = currency;
		this.details = details;
		this.checkoutDate = checkoutDate;
	}
	
	public BookFine(String details, Date checkoutDate) {
		this.amount = 0;
		this.currency = "";
		this.details = details;
		this.checkoutDate = checkoutDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookFine [amount=");
		builder.append(amount);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", details=");
		builder.append(details);
		builder.append(", checkoutDate=");
		builder.append(checkoutDate);
		builder.append("]");
		return builder.toString();
	}	
}
