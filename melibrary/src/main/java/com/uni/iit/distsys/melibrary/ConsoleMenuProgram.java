package com.uni.iit.distsys.melibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import com.uni.iit.distsys.melibrary.gateway.FineCalcGateway;
import com.uni.iit.distsys.melibrary.gateway.LibraryGateway;
import com.uni.iit.distsys.melibrary.model.Book;
import com.uni.iit.distsys.melibrary.model.BookFine;

public class ConsoleMenuProgram {
	private LibraryGateway libraryGateway;
	private FineCalcGateway calcGateway;
	private BufferedReader reader;
	private Date fineCalcDate;

	public ConsoleMenuProgram(ApplicationContext context) {
		this.libraryGateway = (LibraryGateway) context.getBean("libraryGateway", LibraryGateway.class);
		this.calcGateway = (FineCalcGateway) context.getBean("fineCalcGateway", FineCalcGateway.class);

		this.fineCalcDate = new Date();

		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void showMainMenu() {
		System.out.println("+============================================+");
		System.out.println("[1] Add new book");
		System.out.println("[2] Reserve book");
		System.out.println("[3] Checkout book");
		System.out.println("[4] List my checkedout book(s)");
		System.out.println("[5] Calculate fines");
		System.out.println("[6] Search for books");
		System.out.println("[7] Change fine specific options");
		System.out.println("[8] Exit");
		System.out.println("+============================================+");
		System.out.println("Selected menu point: ");

		try {
			switch (Integer.valueOf(this.reader.readLine())) {
			case 1:
				addNewBook();
				break;
			case 2:
				reserveBook();
				break;
			case 3:
				checkoutBook();
				break;
			case 4:
				listAllCheckoutBooks();
				break;
			case 5:
				calculateFines();
				break;
			case 6:
				showSearchForBookMenu();
				break;
			case 7:
				showFineOptionsMenu();
				break;
			case 8:
				exitConsoleProgram();
				break;
			default:
				System.out.println("Invalid menu point.");
				showMainMenu();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addNewBook() {
		String author;
		String title;
		String publisher;
		String language;
		String isbnNumber;

		try {
			System.out.println("New book's author");
			author = reader.readLine();

			System.out.println("New book's title");
			title = reader.readLine();

			System.out.println("New book's publisher");
			publisher = reader.readLine();

			System.out.println("New book's language");
			language = reader.readLine();

			System.out.println("New book's ISBN number");
			isbnNumber = reader.readLine();

			this.libraryGateway.addBook(new Book(author, title, publisher, language, isbnNumber));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void reserveBook() {
		Object[] books = libraryGateway.listAllAvailableBook().toArray();

		System.out.println("+============================================+");

		for (int i = 0; i < books.length; i++) {
			System.out.println("[" + (i + 1) + "] " + books[i]);
		}
		System.out.println("[" + (books.length + 1) + "] " + "Back");
		System.out.println("+============================================+");
		System.out.println("Choose a book to reserve");

		try {
			int choice = Integer.valueOf(this.reader.readLine());

			if (choice == books.length + 1) {
				showMainMenu();
			} else if (choice > (books.length + 2) || choice <= 0) {
				System.out.println("Invalid book to reserve");
			} else {
				libraryGateway.reserveBook((Book) books[choice - 1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkoutBook() {
		Object[] books = libraryGateway.listAllAvailableBook().toArray();

		System.out.println("+============================================+");

		for (int i = 0; i < books.length; i++) {
			System.out.println("[" + (i + 1) + "] " + books[i]);
		}
		System.out.println("[" + (books.length + 1) + "] " + "Back");
		System.out.println("+============================================+");
		System.out.println("Choose a book to checkout");

		try {
			int choice = Integer.valueOf(this.reader.readLine());

			if (choice == books.length + 1) {
				showMainMenu();
			} else if (choice > (books.length + 2) || choice <= 0) {
				System.out.println("Invalid book to checkout");
			} else {
				this.libraryGateway.checkoutBook((Book) books[choice - 1]);
//				this.calcGateway.addNewCheckedoutBook(new Book("Asd", "Asd", "Hun", new Date()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listAllCheckoutBooks() {
		for (BookFine fine : this.calcGateway.getAllBookFines()) {
			System.out.println(fine);
		}
	}

	private void calculateFines() {
		calcGateway.calculateFinesInHuf(this.fineCalcDate);
	}

	private void showSearchForBookMenu() {
		System.out.println("+============================================+");
		System.out.println("[1] List all available");
		System.out.println("[2] List all NOT available");
		System.out.println("[3] Search by title");
		System.out.println("[4] Search by author");
		System.out.println("[5] Back");
		System.out.println("+============================================+");
		System.out.println("Selected menu point: ");

		try {
			switch (Integer.valueOf(this.reader.readLine())) {
			case 1:
				listAllAvailableBook();
				break;
			case 2:
				listAllNotAvailableBook();
				break;
			case 3:
				listAllBooksByTitle();
				break;
			case 4:
				listAllBooksByAuthor();
				break;
			case 5:
				showMainMenu();
				break;
			default:
				System.out.println("Invalid menu point.");
				showSearchForBookMenu();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listAllAvailableBook() {
		for (Book book : this.libraryGateway.listAllAvailableBook()) {
			System.out.println(book);
		}
	}

	private void listAllNotAvailableBook() {
		for (Book book : this.libraryGateway.listAllNotAvailableBook()) {
			System.out.println(book);
		}
	}

	private void listAllBooksByTitle() {
		try {
			System.out.println("Book's title");
			String title = reader.readLine();

			for (Book book : this.libraryGateway.getAllByTitle(title)) {
				System.out.println(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listAllBooksByAuthor() {
		try {
			System.out.println("Book's author");
			String author = reader.readLine();

			for (Book book : this.libraryGateway.getAllByAuthor(author)) {
				System.out.println(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showFineOptionsMenu() {
		System.out.println("+============================================+");
		System.out.println("[1] Set fine per day (HUF)");
		System.out.println("[2] Set loan period (days)");
		System.out.println("[3] Set fine calculation date");
		System.out.println("[4] Back");
		System.out.println("+============================================+");
		System.out.println("Selected menu point: ");

		try {
			switch (Integer.valueOf(this.reader.readLine())) {
			case 1:
				listAllAvailableBook();
				break;
			case 2:
				listAllNotAvailableBook();
				break;
			case 3:
				listAllBooksByTitle();
				break;
			case 4:
				listAllBooksByAuthor();
				break;
			case 5:
				showMainMenu();
				break;
			default:
				System.out.println("Invalid menu point.");
				showSearchForBookMenu();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exitConsoleProgram() {
		System.out.println("Bye!");
		System.exit(0);
	}
}
