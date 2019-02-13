package com.Strings;

import java.io.*;

public class checkAnagrams {
    public static void main (String[] args) throws IOException
    {
        // code
        BufferedReader input = null;
        input = new BufferedReader(new InputStreamReader(new FileInputStream( new File("input/dummy") )));

        int testCases = Integer.parseInt(input.readLine());
        String s = "Helo There";
        s = s.substring(2,4);

        for(int i = 0; i < testCases; i++){
            char[] str1 = input.readLine().toCharArray();
            char[] str2 = input.readLine().toCharArray();
            int size = str1.length;
            Boolean ana = true;

            if(size != str2.length){
                System.out.println("NO");
            }else{

                for( char element : str1 ){
                    int j = 0;
                    while(j < size && str2[j] != element){
                        j++;
                    }
                    if(j < size){
                        str2[j] = Character.MIN_VALUE;
                    }
                }

                for( char element : str2 ){
                    if(element != Character.MIN_VALUE){
                        ana = false;
                    }
                }
                if(ana)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}