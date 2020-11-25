package com.company;

public class Student implements Comparable<Student>{

	private String surname;
	private float AvMark;
	private int Age;

	public Student(float avMark, String surname) {
		AvMark = avMark;
		this.surname = surname;
	}

	public Student(float avMark,String surname,int age) {
		AvMark = avMark;
		this.surname = surname;
		Age = age;
	}

	public int getAge() {
		return Age;
	}

	public float getAvMark() {
		return AvMark;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public int compareTo(Student o) {
		if(getAvMark()-o.getAvMark()>0){
			return -1;
		}else if(getAvMark()-o.getAvMark()<0){
			return 1;
		}else {
			return -1;
		}
	}

	//9.5
	/*
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Float.compare(student.AvMark, AvMark) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(AvMark);
	}
	*/
}
