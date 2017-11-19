package com.uni.iit.distsys.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.iit.distsys.core.model.BookFine;
import com.uni.iit.distsys.core.service.FineCalculatorManagerService;
import com.uni.iit.distsys.core.service.FineCalculatorSearchService;

@Controller
@RequestMapping("fine")
public class FineController {
	private FineCalculatorManagerService managerService;
	private FineCalculatorSearchService searchService;

	public FineController(FineCalculatorManagerService managerService, FineCalculatorSearchService searchService) {
		this.managerService = managerService;
		this.searchService = searchService;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void addNewCheckedoutBook(@RequestParam("author") String author, @RequestParam("title") String title,
			@RequestParam("lang") String language,
			@RequestParam("checkdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkoutDate) {
		this.managerService.addNewCheckedoutBook(author, title, language, checkoutDate);
	}
	
	@RequestMapping(value = "getBookFines")
	@ResponseBody
	public Collection<BookFine> getAllBookFines() {
		return this.searchService.listAllBookFine();
	}
}
