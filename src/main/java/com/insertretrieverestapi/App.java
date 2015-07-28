package com.insertretrieverestapi;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.insertretrieverestapi.util.RandomUtils;
import com.insertretrieverestapi.vo.Element;

public class App {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			InsertRetrieveRESTAPIClient client = (InsertRetrieveRESTAPIClient)context.getBean("insertRetrieveRESTAPIClient");
			
			//TODO scanner.in
			//client.insert(RandomUtils.generateRandomString(12));
			client.insert("ram");
			List<Entry<String, Element>> insert = client.retrieve();
			/*for (Entry<String, Element> entry : insert) {
				System.out.println(entry.getValue());
			}*/
			Iterator<Map.Entry<String, Element>> iterator = insert.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}

	}

}
