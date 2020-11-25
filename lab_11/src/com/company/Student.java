package com.company;

public class Student {
	private String name;
	private String surname;
	private int age;
	private float AvMark;

	public Student(String name, String surname, int age, float avMark) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		AvMark = avMark;
	}

	public Student() {

	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public float getAvMark() {
		return AvMark;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAvMark(float avMark) {
		AvMark = avMark;
	}
}
