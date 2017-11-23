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
	}
}