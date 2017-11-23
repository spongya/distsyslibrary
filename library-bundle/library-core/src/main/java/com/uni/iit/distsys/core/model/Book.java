package com.uni.iit.distsys.core.model;

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

	public Book(String author, String title, String publisher, String language, Date registrationDate,
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

	public Book(String author, String title, String publisher, String language, String isbnNumber) {
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.registrationDate = new Date();
		this.language = language;
		this.isbnNumber = isbnNumber;
		this.isReserved = false;
		this.isAvailable = true;
		this.checkoutDate = null;
	}

	public Book(String author, String title, String language) {
		this.author = author;
		this.title = title;
		this.language = language;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void reserve() {
		this.isReserved = true;
	}

	public void checkout() {
		this.isAvailable = false;
		this.checkoutDate = new Date();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)) {
			return false;
		}
		return this.author.equals(((Book) obj).author) && this.title.equals(((Book) obj).title)
				&& this.language.equals(((Book) obj).language);
	}
}
