package com.stackAndQueue;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class balanceBracket {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        // String pattern = "({).*([).*(\\().*\\1\\2\\3"
        char[] c = s.toCharArray();
        int size = c.length;
        int i = -1;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;

        while(++i < size && flag){
            switch(c[i]){
                case '(':
                    stack.push(c[i]);
                    break;
                case '{':
                    stack.push(c[i]);
                    break;
                case '[':
                    stack.push(c[i]);
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        flag = false;
                    }
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        flag = false;
                    }
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    }else{
                        flag = false;
                    }
                    break;
            }
        }

        if(flag && stack.isEmpty())
            return "YES";
        else
            return "NO";

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}

