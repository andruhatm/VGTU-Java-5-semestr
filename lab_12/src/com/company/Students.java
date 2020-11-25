package com.company;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(name = "students")
public class Students {
	@XmlElementWrapper(name = "allStudents")
	public List<Student> student = new ArrayList<>();

}
