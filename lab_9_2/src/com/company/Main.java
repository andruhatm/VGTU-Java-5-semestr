package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
 
        //creating ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        int testChar = 5;

        //creating before time var
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:ms:SS");

        //filling ArrayList
        for(int i=0;i<1000000;i++){
            list.add(testChar);
        }

        //creating after time var
        Date date2 = new Date();

        System.out.println("Start: "+format.format(date1)+"\t Finish: "+format.format(date2));
        System.out.println("Difference: "+(date2.getTime()-date1.getTime()));

        //start var time for deleting
        Date date3 = new Date();

        for(int i =0;i<1000;i++){
            list.remove(0);
        }

        //finish var time for deleting
        Date date4 = new Date();

        System.out.println("Start: "+format.format(date3)+"\t Finish: "+format.format(date4));
        System.out.println(date4.getTime()-date3.getTime());
    }
}
