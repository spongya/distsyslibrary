package com.uni.iit.distsys.melibrary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;

import com.uni.iit.distsys.melibrary.gateway.LibrarySearchGateway;
import com.uni.iit.distsys.melibrary.model.Book;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("si-config.xml");
		MessageChannel stoutChannel = (MessageChannel) context.getBean("chatChannel", MessageChannel.class);

		LibrarySearchGateway gateway = (LibrarySearchGateway) context.getBean("LibrarySearchGateway",
				LibrarySearchGateway.class);

		for (Book book : gateway.listAllAvailableBook()) {
			System.out.println(book);
		}
		
		for (Book book : gateway.listAllNotAvailableBook()) {
			System.out.println(book);
		}
	}
}