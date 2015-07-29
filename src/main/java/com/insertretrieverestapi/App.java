package com.insertretrieverestapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.insertretrieverestapi.vo.Element;

public class App {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {
			InsertRetrieveRESTAPIClient client = (InsertRetrieveRESTAPIClient) context
					.getBean("insertRetrieveRESTAPIClient");
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Please, enter a word :: ");
				// client.insert(RandomUtils.generateRandomString(1));
				client.insert(sc.nextLine());
			}
			client.retrieve();
		}
	}
}
