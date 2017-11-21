package com.uni.iit.distsys.melibrary;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;

import com.uni.iit.distsys.melibrary.gateway.FineCalcGateway;
import com.uni.iit.distsys.melibrary.gateway.LibraryGateway;
import com.uni.iit.distsys.melibrary.model.Book;
import com.uni.iit.distsys.melibrary.model.BookFine;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("si-config.xml");
		MessageChannel stoutChannel = (MessageChannel) context.getBean("chatChannel", MessageChannel.class);

		LibraryGateway libraryGateway = (LibraryGateway) context.getBean("libraryGateway", LibraryGateway.class);
		FineCalcGateway fineCalcGateway = (FineCalcGateway) context.getBean("fineCalcGateway", FineCalcGateway.class);
		
		fineCalcGateway.addNewCheckedoutBook(new Book("Asd", "Asd", "Hun", new Date()));
		fineCalcGateway.setLoanPeriod(30);
		fineCalcGateway.setFinePerDay(20);
		fineCalcGateway.calculateFinesInHuf(new GregorianCalendar(2020, 1, 1).getTime());
		
		for (BookFine fine : fineCalcGateway.getAllBookFines()) {
			System.out.println(fine);
		}

		for (Book book : libraryGateway.listAllAvailableBook()) {
			System.out.println(book);
		}

		for (Book book : libraryGateway.listAllNotAvailableBook()) {
			System.out.println(book);
		}

		libraryGateway.addBook(new Book("Asd", "Asd", "Asd", "Hun", "123123"));
		libraryGateway.checkoutBook(new Book("Asd", "Asd", "Asd", "Hun", "123123"));
		libraryGateway.addBook(new Book("Asd2", "Asd2", "Asd2", "Hun", "123123"));
		libraryGateway.reserveBook(new Book("Asd2", "Asd2", "", "Hun", ""));

		for (Book book : libraryGateway.getAllByAuthor("Asd")) {
			System.out.println(book);
		}

		for (Book book : libraryGateway.getAllByTitle("Asd2")) {
			System.out.println(book);
		}
	}
}