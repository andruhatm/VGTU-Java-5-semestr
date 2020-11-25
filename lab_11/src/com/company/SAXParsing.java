package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class SAXParsing {

	private final Stack<String> elements = new Stack<>();
	private final Stack<Student> objects = new Stack<>();

	ArrayList<Student> list = new ArrayList<>();

	public static void main(String[] args) {
		SAXParsing saxParsing = new SAXParsing();
		saxParsing.run();
	}

	public void run(){

		try{

			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();

			DefaultHandler defaultHandler = new DefaultHandler(){

				public void startElement(String uri, String localName,String qName, Attributes attributes){

					elements.push(qName);

					if ("Student".equals(qName)){
						Student student = new Student();
						objects.push(student);
						list.add(student);
					}
				}

				public void endElement(String uri,String localName,String qName){
					elements.pop();
				}

				public void characters(char[] ch, int start, int length) throws SAXException {

					String value = new String(ch,start,length);
					if(value.isEmpty()){
						return;
					}
					if("name".equals(currentElement())){
						Student student = objects.peek();
						student.setName(value);
					}
					if("surname".equals(currentElement())) {
						Student student = objects.peek();
						student.setSurname(value);
					}
					if("age".equals(currentElement())) {
						Student student = objects.peek();
						student.setAge(Integer.parseInt(value));
					}
					if("AvMark".equals(currentElement())) {
						Student student = objects.peek();
						student.setAvMark(Float.parseFloat(value));
					}
				}

			};

			saxParser.parse("list.xml",defaultHandler);

			for (Student student: list){
				System.out.println(student.getSurname()+" "+student.getName()+" "+student.getAvMark()+" "+student.getAge());
			}
			System.out.println(list.size());

		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}

	private String currentElement(){
		return elements.peek();
	}
}
