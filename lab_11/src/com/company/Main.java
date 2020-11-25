package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class Main {
    /*
        С помошью DOM создать xml файл (students.xml) на основе ArrayList классов Student.
        С помощью SAX прочитать файл students.xml и создать ArrayList классов Student.
  */

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Ivan","Ivanov",15,5f));
        list.add(new Student("Andrey","Sidorov",14,4.6f));
        list.add(new Student("Petr","Newman",25,4.66f));
        list.add(new Student("Fedya","Petrov",23,4.56f));
        list.add(new Student("Nick","Fero",22,4.78f));
        list.add(new Student("Ivan","Fero",21,4.6f));
        list.add(new Student("Tom","Fero",21,4.6f));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            //creating root element
            Element rootElement = document.createElement("Students");
            document.appendChild(rootElement);

            for(Student student: list){
                rootElement.appendChild(
                        getStudent(
                            document,
                            student.getName(),
                            student.getSurname(),
                            student.getAge(),
                            student.getAvMark()
                        )
                );
            }

            StreamResult file = new StreamResult(new File("/Users/andruha.tm/IdeaProjects/Java labs/lab_11/list.xml"));

            //transformer for saving in file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            transformer.transform(domSource,file);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }
    //new node of XML
    private static Node getStudent(Document document, String name, String surname,int age,float AvMark){
        Element student = document.createElement("Student");

        student.appendChild(getStudentElements(document,"name",name));
        student.appendChild(getStudentElements(document,"surname",surname));
        student.appendChild(getStudentElements(document,"age",String.valueOf(age)));
        student.appendChild(getStudentElements(document,"AvMark",String.valueOf(AvMark)));

        return student;
    }

    //new node for student element
    private static Node getStudentElements(Document document,String name,String value){
        Element node = document.createElement(name);
        node.appendChild(document.createTextNode(value));
        return node;
    }
}
