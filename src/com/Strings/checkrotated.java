package com.Strings;

import java.io.*;

public class checkrotated {
    public static void main (String[] args) throws IOException
    {
        // code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream( new File("input/dummy") )));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            String str1 = input.readLine();
            String str2 = input.readLine();
            String dou = str2 + str2;

            int x = dou.indexOf(str1);
            int size = str1.length();

            if( x == 2 || x == (size - 2))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}