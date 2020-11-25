package com.company;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "student")
public class Student {
	@XmlElement(name = "firstName")
	private String name;
	@XmlElement(name = "lastName")
	private String surname;
	@XmlElement(name = "age")
	private int age;
	@XmlElement(name = "AvMark")
	private float avMark;

	public Student() {
	}

	public Student(String name, String surname, int age, float avMark) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.avMark = avMark;
	}

	@Override
	public String toString() {
		return "Student{" +
						"name='" + name + '\'' +
						", surname='" + surname + '\'' +
						", age=" + age +
						", avMark=" + avMark +
						'}';
	}
}
