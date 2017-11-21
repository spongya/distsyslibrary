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

	@RequestMapping(value = "add", method = RequestMethod.GET)
	@ResponseBody
	public String addNewCheckedoutBook(@RequestParam("author") String author, @RequestParam("title") String title,
			@RequestParam("lang") String language,
			@RequestParam("checkdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkoutDate) {
		this.managerService.addNewCheckedoutBook(author, title, language, checkoutDate);
		
		return "New checked out book added!";
	}
	
	@RequestMapping(value = "calculate", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String calculateFinesInHuf(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		int total = this.managerService.calculateFinesInHuf(date);
		
		return "Fines calculated successfully in HUF. Total: " + total + " HUF";
	}
	
	@RequestMapping(value = "getFines")
	@ResponseBody
	public Collection<BookFine> getAllBookFines() {
		return this.searchService.listAllBookFine();
	}
	
	@RequestMapping(value = "set/loanperiod", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String setLoanPeriod(@RequestParam("days") int newDays) {
		this.managerService.setLoanPeriod(newDays);
		
		return "The loan period has been set to " + newDays + " day(s)";
	}
	
	@RequestMapping(value = "set/fine", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String setFinePerDay(@RequestParam("fine") int newFineInHuf) {
		this.managerService.setFinePerDay(newFineInHuf);
		
		return "The fine per day has been set to " + newFineInHuf + " HUF";
	}
}
