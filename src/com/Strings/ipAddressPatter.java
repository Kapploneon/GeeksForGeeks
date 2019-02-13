package com.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class ipAddressPatter{

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream( new File("input/dummy")));
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }

}
class MyRegex{
    // IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
    // 000.12.12.034
    // 121.234.12.12
    // 23.45.12.56
    String pattern = "((\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])[.]){3}(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
}