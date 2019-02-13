package com.Strings;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class removeAdjDup
{
    public static void main (String[] args) throws IOException
    {
        // code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream( new File("input/dummy") )));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            char[] str = input.readLine().toCharArray();
            char[] st2 = new char[2];

            removeduplicates(str);

            System.out.println();
        }
    }

    static void removeduplicates(char[] str){
        int size = str.length;
        Stack<Character> unique = new Stack<>();

        if(size == 0){
            return;
        }
        unique.push(str[0]);
        for(int i = 1; i < size; i++){
            if(unique.peek() != str[i])
                unique.push(str[i]);
            else
            {
                while(unique.peek() == str[i]){
                    i++;
                }
                unique.pop();
                i--;
            }
        }

        for( char element : unique){
            System.out.print(element);
        }
    }
}