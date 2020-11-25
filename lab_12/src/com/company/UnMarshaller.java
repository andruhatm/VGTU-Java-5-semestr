package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UnMarshaller {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Students.class,Student.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		InputStream is = new FileInputStream("students.xml");
		Students students = (Students) unmarshaller.unmarshal(is);

		for(Student student: students.student){
			System.out.println(student.toString());
		}
	}
}
