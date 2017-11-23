package com.uni.iit.distsys.melibrary.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private String author;
	private String title;
	private String publisher;
	private Date registrationDate;
	private String language;
	private String isbnNumber;
	private boolean isReserved;
	private boolean isAvailable;
	private Date checkoutDate;

	public Book() {

	}

	public Book(String author, String title, String publisher, String language, String isbnNumber) {
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.language = language;
		this.isbnNumber = isbnNumber;
	}

	public Book(String author, String title, String language, Date checkoutDate) {
		this.author = author;
		this.title = title;
		this.language = language;
		this.checkoutDate = checkoutDate;
	}

	public Book(String author, String title, String publisher, Date registrationDate, String language,
			String isbnNumber, boolean isReserved, boolean isAvailable, Date checkoutDate) {
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.registrationDate = registrationDate;
		this.language = language;
		this.isbnNumber = isbnNumber;
		this.isReserved = isReserved;
		this.isAvailable = isAvailable;
		this.checkoutDate = checkoutDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		StringBuilder builder = new StringBuilder();
		builder.append("Book [author=");
		builder.append(author);
		builder.append(", title=");
		builder.append(title);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", registrationDate=");
		builder.append(registrationDate);
		builder.append(", language=");
		builder.append(language);
		builder.append(", isbnNumber=");
		builder.append(isbnNumber);
		builder.append(", isReserved=");
		builder.append(isReserved);
		builder.append(", isAvailable=");
		builder.append(isAvailable);
		builder.append(", checkoutDate=");
		if (checkoutDate != null) {
			builder.append(dateFormat.format(checkoutDate));
		}
		builder.append("]");
		return builder.toString();
	}
}
