package com.Strings;

import java.util.*;
import java.lang.*;
import java.io.*;

/* By Kapple */

class reverseWordsInString
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/dummy"))));

        int testCases = Integer.parseInt(input.readLine());

        for(int i = 0; i < testCases; i++){
            String[] array;
            String temp = input.readLine();
//            String temp = "Hello.there.how.are.you";

            array = temp.split("\\.");
            reverseWords(array);
        }
    }

    private static void reverseWords(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = array.length;
        for(int i = size - 1; i >= 0; i--){
            stringBuilder.append(array[i]).append(".");
        }
        String toRet = stringBuilder.toString();
        toRet = toRet.substring(0,toRet.length() - 1 );
        System.out.println(toRet);
    }
}