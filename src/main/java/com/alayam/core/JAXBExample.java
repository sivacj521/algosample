package com.alayam.core;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
 

public class JAXBExample {
	enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	
	public static void main(String[] args) {
		boolean test = true;
		try{
			System.out.println("I am in try block");
			return;
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			System.out.println("I am in finally block!!!");
		}
		if(test)
			return;
		
		System.out.println(Day.SUNDAY);
		int price = 5;
		switch (price) {
			case 2: System.out.println("It is: 2");
			default: System.out.println("It is: default");
			case 5: System.out.println("It is: 5");			
			case 9: System.out.println("It is: 9");
		}
		
		
		
	 try {
 
		File file = new File("file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer c1 = (Customer) jaxbUnmarshaller.unmarshal(file);
		
		System.out.println(c1);
 
	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
 
	}
}