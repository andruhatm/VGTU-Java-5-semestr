package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Collection;

public class Main {
    /*	С помошью JAXB создать xml файл (students.xml) на основе ArrayList классов Student.
        С помощью JAXB прочитать файл students.xml и создать ArrayList классов Student.
    */

    public static void main(String[] args) throws JAXBException {

        Students students = new Students();
        students.student.add(new Student("Ilya","Petrov",17,4.5F));
        students.student.add(new Student("Andrey","Gerasimov",19,4.75F));
        students.student.add(new Student("Vova","Sidorov",20,4F));
        students.student.add(new Student("Mark","Fursov",23,4.2F));
        students.student.add(new Student("John","Polev",33,4.4F));

        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class,Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        marshaller.marshal(students,new File("./students.xml"));

    }
}
