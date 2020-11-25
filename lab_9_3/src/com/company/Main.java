package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //9.3
        NavigableMap<Student,Integer> students = new TreeMap<>();

        //9.4
        //Comparator<Student> comparator = new StudentSurnameComparator().thenComparing(new StudentAgeComparator()).thenComparing(new StudentAvMarkComparator());
        //NavigableMap<Student,Integer> students = new TreeMap<>(comparator);

        students.put(new Student(5f,"Ivanov",15),1);
        students.put(new Student(4.0f,"Sidorov",14),2);
        students.put(new Student(4.1f,"Newman",25),3);
        students.put(new Student(4.5f,"Petrov",23),4);
        students.put(new Student(4.0f,"Fero",22),5);
        students.put(new Student(4.4f,"Fero",21),6);
        students.put(new Student(4.4f,"Fero",21),6);

        //TreeMap<Integer,Student> tree = new TreeMap<Integer, Student>(students);

        for(Map.Entry<Student,Integer> value: students.entrySet()){
            System.out.println(value.getKey().getSurname()+" "+value.getKey().getAvMark()/*+" "+value.getKey().getAge()*/);
        }
        System.out.println("\r");

        //9.5
        /*
        HashSet<Student> students1 = new HashSet<>(students.keySet());


        for(Student student: students1){
            System.out.println(student.getSurname()+" "+student.getAvMark());
        }
        */
    }

}
