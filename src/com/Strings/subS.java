package com.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class subS {
    public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

    public static void main(String[] args) {
        String s = "000.12";
        // Write your code here.
        String[] x = s.split("[0-2]?");
        System.out.println(x.length);
        for(String el : x){
            System.out.println(el);
        }
    }
}
