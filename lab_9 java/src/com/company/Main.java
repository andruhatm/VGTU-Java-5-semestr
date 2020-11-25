package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        //get input from user
        for (int i = 0;i<10;i++){
            String input = scanner.next();
            list.add(input);
        }
        //sort filled ArrayList
        Collections.sort(list);

        //outputs full sorted list with repeat count
        for (String surname: list) {
            System.out.print(surname);
            int counter = 0;
            for (String s : list) {
                if (surname.equals(s))
                    counter++;
            }
            System.out.println(" "+counter);
        }

        //removing duplicates using LinkedHashSet
        LinkedHashSet<String> newlist = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(newlist);
        System.out.println("After duplicates removing: ");
        for (String surname: list)
            System.out.println(surname);
    }
}

