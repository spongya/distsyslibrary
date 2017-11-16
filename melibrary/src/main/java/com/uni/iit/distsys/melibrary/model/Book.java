package com.uni.iit.distsys.melibrary.model;

import java.util.Date;

public class Book {
	private String author;
	private String title;
	private String publisher;
	private int publishingYear;
	private Date registrationDate;
	private String language;
	private int version;
	private String isbnNumber;
	private boolean isReserved;
	private boolean isAvailable;
	
	public Book() {
		
	}

	public Book(String author, String title, String publisher, int publishingYear, String language,
			Date registrationDate, int version, String isbnNumber, boolean isReserved, boolean isAvailable) {
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
		this.registrationDate = registrationDate;
		this.language = language;
		this.version = version;
		this.isbnNumber = isbnNumber;
		this.isReserved = isReserved;
		this.isAvailable = isAvailable;
	}

	public Book(String author, String title, String publisher, int publishingYear, String language, int version,
			String isbnNumber) {
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
		this.registrationDate = new Date();
		this.language = language;
		this.version = version;
		this.isbnNumber = isbnNumber;
		this.isReserved = false;
		this.isAvailable = true;
	}
	
	public Book(String author, String title, String language) {
		this.author = author;
		this.title = title;
		this.publisher = "";
		this.publishingYear = 0;
		this.registrationDate = new Date();
		this.language = language;
		this.version = 0;
		this.isbnNumber = "";
		this.isReserved = false;
		this.isAvailable = true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [author=");
		builder.append(author);
		builder.append(", title=");
		builder.append(title);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", publishingYear=");
		builder.append(publishingYear);
		builder.append(", registrationDate=");
		builder.append(registrationDate);
		builder.append(", language=");
		builder.append(language);
		builder.append(", version=");
		builder.append(version);
		builder.append(", isbnNumber=");
		builder.append(isbnNumber);
		builder.append(", isReserved=");
		builder.append(isReserved);
		builder.append(", isAvailable=");
		builder.append(isAvailable);
		builder.append("]");
		return builder.toString();
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

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	
}
