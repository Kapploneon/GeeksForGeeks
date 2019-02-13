package com.Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class reducedString {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        boolean num = true;
        boolean low = true;
        boolean upp = true;
        boolean spe = true;
        int rq = 0;
        char[] c = password.toCharArray();
        int size = c.length;

        for(int i = 0; i < size; i++){
            if(num && numbers.indexOf(c[i]) >= 0 ){
                num = false;
            }
            if(low && lower_case.indexOf(c[i]) >= 0 ){
                low = false;
            }
            if(upp && upper_case.indexOf(c[i]) >= 0 ){
                upp = false;
            }
            if(spe && special_characters.indexOf(c[i]) >= 0 ){
                spe = false;
            }
        }

        if(num)
            rq++;
        if(low)
            rq++;
        if(upp)
            rq++;
        if(spe)
            rq++;

        if(rq+size < 6){
            rq = rq + 6-(rq+size);
        }
        return rq;

    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(String.valueOf(answer));

        scanner.close();
    }
}
