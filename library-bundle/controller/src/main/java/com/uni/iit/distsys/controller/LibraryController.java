package com.uni.iit.distsys.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.iit.distsys.core.model.Book;
import com.uni.iit.distsys.core.service.LibraryManagerService;
import com.uni.iit.distsys.core.service.LibrarySearchService;

@Controller
@RequestMapping(value = "library")
public class LibraryController {

	private LibraryManagerService managerService;
	private LibrarySearchService searchService;

	public LibraryController(LibraryManagerService managerService, LibrarySearchService searchService) {
		this.managerService = managerService;
		this.searchService = searchService;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String addNewBook(@RequestParam("a") String author, @RequestParam("t") String title,
			@RequestParam("p") String publisher, @RequestParam("py") int publishingYear,
			@RequestParam("l") String language, @RequestParam("v") int version, @RequestParam("i") String isbnNumber) {
		this.managerService.addNewBook(author, title, publisher, publishingYear, language, version, isbnNumber);

		return "New book added";
	}

	@RequestMapping(value = "reserve", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String reserveBook(@RequestParam("author") String author, @RequestParam("title") String title,
			@RequestParam("lang") String language) {
		this.managerService.reserveBook(new Book(author, title, language));
		
		System.out.println(author + title + language);
		
		return "Book reserved";
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String checkoutBook(@RequestParam("author") String author, @RequestParam("title") String title,
			@RequestParam("lang") String language) {
		this.managerService.checkOutBook(new Book(author, title, language));
		
		System.out.println(author + title + language);
		
		return "Book checked out";
	}

	@RequestMapping(value = "getAll")
	@ResponseBody
	public Collection<Book> getAllAvailable() {
		return this.searchService.listAllAvailableBook();
	}

	@RequestMapping(value = "getByAuthor")
	@ResponseBody
	public Collection<Book> getAllByAuthor(@RequestParam("author") String author) {
		return this.searchService.listAllBookByAuthor(author);
	}

	@RequestMapping(value = "getByTitle")
	@ResponseBody
	public Collection<Book> getAllByTitle(@RequestParam("title") String title) {
		return this.searchService.listAllBookByTitle(title);
	}

}
