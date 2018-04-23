package com.alayam.core;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Customer {
 
	String name;
	//static final int a;
	//final int b;
	int age;
	int id;
	ArrayList<String> phone;
	
	public String getName() {
		return name;
	}
 
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
 
	public int getAge() {
	//static int i=0;
		return age;
	}
 
	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}
 
	public int getId() {
		return id;
	}
 
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return new String(""+name +":"+id+":" +age);
	}

	public ArrayList<String> getPhone() {
		return phone;
	}

	public void setPhone(ArrayList<String> phone) {
		this.phone = phone;
	}

	
}