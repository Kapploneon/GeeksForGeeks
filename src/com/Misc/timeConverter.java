package com.Misc;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class timeConverter {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String ampm = s.substring(s.length()-2);
        if(ampm.equals("AM")){
            if(s.substring(0,2).equals("12")){
                return "00"+s.substring(2,8);
            }else{
                return s.substring(0,s.length()-2);
            }
        }

        // For PM.
        if(s.substring(0,2).equals("12")){
            return s.substring(0,s.length()-2);
        }

        int hour = Integer.parseInt(s.substring(0,2));
        hour = hour + 12;

        return String.valueOf(hour) + s.substring(2,8);
    }

    private static Scanner scan = null;

    static {
        try {
            scan = new Scanner(new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);
    }
}

