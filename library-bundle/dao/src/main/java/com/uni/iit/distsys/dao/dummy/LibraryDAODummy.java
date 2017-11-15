package com.uni.iit.distsys.dao.dummy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import com.uni.iit.distsys.core.model.Book;
import com.uni.iit.distsys.service.dao.LibraryDAO;

public class LibraryDAODummy implements LibraryDAO {

	private Collection<Book> books;

	public LibraryDAODummy() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		this.books = new HashSet<>();

		try {
			this.books.add(
					new Book("J. R. R. Tolkien", "The hobbit", "HarperCollins", 2013, "English", 5, "9780007525508"));
			this.books.add(new Book("J. R. R. Tolkien", "The hobbit", "Ciceró", 2004, "Hungarian", 4, "9780007525507"));
			this.books.add(new Book("J. R. R. Tolkien", "The Fellowship of the Ring", "HarperCollins", 2014, "English",
					2, "9780007525506"));
			this.books.add(new Book("J. R. R. Tolkien", "The Fellowship of the Ring", "Ciceró", 2004, "Hungarian", 3,
					"9780007525505"));

			this.books.add(new Book("George R. R. Martin", "A Feast for Crows", "Pécsi Direkt Kft.", 2006, "Hungarian",
					dateFormat.parse("2016-12-31"), 3, "9780007525504", false, false));
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
	public void reserve(Book book) {
		for (Book b : books) {
			System.out.println(b);
			if (b.equals(book)) {
				System.out.println(b);
				b.reserve();
				break;
			}
		}
	}

	@Override
	public void checkout(Book book) {
		for (Book b : books) {
			if (b.equals(book)) {
				b.checkout();
				break;
			}
		}
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
