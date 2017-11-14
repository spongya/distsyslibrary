package com.uni.iit.distsys.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.iit.distsys.core.model.Book;
import com.uni.iit.distsys.core.service.LibraryManagerService;
import com.uni.iit.distsys.core.service.LibrarySearchService;

@Controller
public class LibraryController {

	private LibraryManagerService managerService;
	private LibrarySearchService searchService;

	public LibraryController(LibraryManagerService managerService, LibrarySearchService searchService) {
		this.managerService = managerService;
		this.searchService = searchService;
	}

	@RequestMapping(value = "/library/getAll")
	@ResponseBody
	public Collection<Book> getAllAvailable() {
		return this.searchService.listAllAvailableBook();
	}

}
