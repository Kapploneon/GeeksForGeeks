package com.Misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class test2 {

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner( new FileInputStream(new File("input/dummy")));
        while (sc.hasNext()) {
            String input=sc.next();
            Stack<Character> bar = new Stack<Character>();
            char[] b = input.toCharArray();
            int size = b.length;
            boolean flag = true;
            for( int i = 0; i < size; i++){
                if(b[i] == '{' || b[i] == '(' || b[i] == '[' || bar.isEmpty()){
                    bar.push(b[i]);
                }else{
                    char p = bar.peek();

                    if(p == '{' && b[i] == '}'){
                        bar.pop();
                    }else if(p == '(' && b[i] == ')'){
                        bar.pop();
                    }else if(p == '[' && b[i] == ']'){
                        bar.pop();
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && bar.isEmpty())
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}