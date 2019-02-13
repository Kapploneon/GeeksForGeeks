package com.Strings;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class ParenthesisChecker
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            char[] array;

            array = input.readLine().toCharArray();

            checkBalanced(array);
        }
    }

    private static void checkBalanced(char[] array) {
        int curly = 0;
        int round = 0;
        int square = 0;

        for(char element : array){
            if(element == '{'){
                curly++;
            }
            if(element == '}'){
                curly--;
            }
            if(element == '('){
                round++;
            }
            if(element == ')'){
                round--;
            }
            if(element == '['){
                square++;
            }
            if(element == ']'){
                square--;
            }
        }

        if(curly == 0 && round == 0 && square == 0 ){
            System.out.println("balanced");
            return;
        }
        System.out.println("not balanced");
    }
}