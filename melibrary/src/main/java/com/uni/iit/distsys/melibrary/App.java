package com.uni.iit.distsys.melibrary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("si-config.xml");

		ConsoleMenuProgram program = new ConsoleMenuProgram(context);

		while (true) {
			program.showMainMenu();
		}

		/*
		 * MessageChannel stoutChannel = (MessageChannel) context.getBean("chatChannel",
		 * MessageChannel.class);
		 * 
		 * fineCalcGateway.addNewCheckedoutBook(new Book("Asd", "Asd", "Hun", new
		 * Date())); fineCalcGateway.setLoanPeriod(30);
		 * fineCalcGateway.setFinePerDay(20); fineCalcGateway.calculateFinesInHuf(new
		 * GregorianCalendar(2020, 1, 1).getTime());
		 * 
		 * for (BookFine fine : fineCalcGateway.getAllBookFines()) {
		 * System.out.println(fine); }
		 * 
		 * 
		 * 
		 * 
		 * libraryGateway.checkoutBook(new Book("Asd", "Asd", "Asd", "Hun", "123123"));
		 * libraryGateway.addBook(new Book("Asd2", "Asd2", "Asd2", "Hun", "123123"));
		 * libraryGateway.reserveBook(new Book("Asd2", "Asd2", "", "Hun", ""));
		 * 
		 * for (Book book : libraryGateway.getAllByAuthor("Asd")) {
		 * System.out.println(book); }
		 * 
		 * for (Book book : libraryGateway.getAllByTitle("Asd2")) {
		 * System.out.println(book); }
		 */
	}
}