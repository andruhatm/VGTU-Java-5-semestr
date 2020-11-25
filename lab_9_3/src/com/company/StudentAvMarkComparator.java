package com.company;

import java.util.Comparator;

public class StudentAvMarkComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getAvMark()<o2.getAvMark()){
			return 1;
		}
		else if(o1.getAvMark()>o2.getAvMark()){
			return -1;
		}else {
			return 0;
		}
	}
}
