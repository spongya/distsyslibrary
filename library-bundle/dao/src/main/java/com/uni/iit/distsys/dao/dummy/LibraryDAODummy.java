package com.uni.iit.distsys.dao.dummy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import com.uni.iit.distsys.core.model.Book;
import com.uni.iit.distsys.service.dao.LibraryDAO;

public class LibraryDAODummy implements LibraryDAO {

	private Collection<Book> books;

	public LibraryDAODummy() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		this.books = new HashSet<>();

		try {
			this.books.add(new Book("J. R. R. Tolkien", "The Lord of the Rings: The Fellowship of the Ring",
					"HarperCollins", "English", dateFormat.parse("2016-12-31"),
					String.valueOf(ThreadLocalRandom.current().nextInt(9999999)), false, true, null));
			this.books.add(new Book("J. R. R. Tolkien", "The Lord of the Rings: The Fellowship of the Ring",
					"HarperCollins", "English", dateFormat.parse("2017-01-29"),
					String.valueOf(ThreadLocalRandom.current().nextInt(9999999)), false, true, null));
			this.books.add(new Book("J. R. R. Tolkien", "The Lord of the Rings: The Fellowship of the Ring",
					"HarperCollins", "English", dateFormat.parse("2017-01-30"),
					String.valueOf(ThreadLocalRandom.current().nextInt(9999999)), false, false, dateFormat.parse("2017-09-15")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addNew(Book book) {
		this.books.add(book);
	}

	@Override
	public boolean reserve(Book book) {
		for (Book b : books) {
			System.out.println(b);
			if (b.equals(book)) {
				if (!b.isReserved() && b.isAvailable()) {
					b.reserve();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean checkout(Book book) {
		for (Book b : books) {
			if (b.equals(book)) {
				if (!b.isReserved() && b.isAvailable()) {
					b.checkout();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Collection<Book> listAllAvailableBook() {
		Collection<Book> ret = new ArrayList<>();
		for (Book b : books) {
			if (b.isAvailable()) {
				ret.add(b);
			}
		}
		return ret;
	}
	
	@Override
	public Collection<Book> listAllNotAvailableBook() {
		Collection<Book> ret = new ArrayList<>();
		for (Book b : books) {
			if (!b.isAvailable()) {
				ret.add(b);
			}
		}
		return ret;
	}

	@Override
	public Collection<Book> listAllBookByTitle(String title) {
		Collection<Book> ret = new ArrayList<>();
		for (Book b : books) {
			if (b.getTitle().contains(title)) {
				ret.add(b);
			}
		}
		return ret;
	}

	@Override
	public Collection<Book> listAllBookByAuthor(String author) {
		Collection<Book> ret = new ArrayList<>();
		for (Book b : books) {
			if (b.getAuthor().contains(author)) {
				ret.add(b);
			}
		}
		return ret;
	}

}
