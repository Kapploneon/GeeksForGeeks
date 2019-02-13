package com.stackAndQueue;

import java.io.*;
import java.util.*;

public class simpleTextEditor {

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(new FileInputStream(new File("input/dummy")));

        int testcases = input.nextInt();
        StringBuilder S = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();

        while(testcases-- > 0){
            int what = input.nextInt();

            switch(what){
                case 1:
                    stack.push(new StringBuilder(S));
                    String word = input.next();
                    S.append(word);
                    break;
                case 2:
                    stack.push(new StringBuilder(S));
                    S.delete(S.length() - input.nextInt(), S.length());
                    break;
                case 3:
                    System.out.println(S.charAt(input.nextInt() - 1));
                    break;
                case 4:
                    S = stack.pop();
                    break;
            }
        }
    }
}
