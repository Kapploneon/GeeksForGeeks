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

public class twoCharacter {

    // Complete the solve function below.
    static int solve(String s) {

        // Clear the initial string.
        s = check(s);

        HashMap<String, Integer> map = MapRed(s);
        HashMap<String, Integer> tempMap;
        int res = 0;
        String temp = s;

        if(map.size() > 2){

            for(Map.Entry<String, Integer> ele : map.entrySet()){
                for(Map.Entry<String, Integer> ele2 : map.entrySet()) {
                    if(ele.getKey() == ele2.getKey())
                        continue;
                    String pattern = "[^"+ele.getKey()+ele2.getKey()+"]";
                    temp = s.replaceAll(pattern, "");
                    temp = check(temp);
                    tempMap = MapRed(temp);
                    if (temp.length() > res && tempMap.size() == 2) {
                        res = temp.length();
                    }
                }
            }
        }else{
            res = s.length();
        }

        return res;

    }

    public static HashMap<String, Integer> MapRed(String s){
        char[] c = s.toCharArray();
        int size = s.length();

        HashMap<String, Integer> map = new HashMap<>();

        for( int i = 0; i < size; i++){
            if(map.containsKey(c[i])){
                map.put(c[i]+"", map.get(c[i]) + 1);
            }else{
                map.put(c[i]+"", 1);
            }
        }
        return map;
    }

    public static String check(String s){
        char[] c = s.toCharArray();
        int size = s.length();
        boolean flag = true;

        // Clear the initial string.
        while(flag){
            flag = false;
            for(int i = 1; i < size; i++){
                if(c[i-1] == c[i]){
                    s = s.replaceAll(c[i]+"","");
                    flag = true;
                    c = s.toCharArray();
                    size = c.length;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) throws IOException {


        String s = "uyetuppelecblwipdsqabzsvyfaezeqhpnalahnpkdbhzjglcuqfjnzpmbwprelbayyzovkhacgrglrdpmvaexkgertilnfooeazvulykxypsxicofnbyivkthovpjzhpohdhuebazlukfhaavfsssuupbyjqdxwwqlicbjirirspqhxomjdzswtsogugmbnslcalcfaxqmionsxdgpkotffycphsewyqvhqcwlufekxwoiudxjixchfqlavjwhaennkmfsdhigyeifnoskjbzgzggsmshdhzagpznkbahixqgrdnmlzogprctjggsujmqzqknvcuvdinesbwpirfasnvfjqceyrkknyvdritcfyowsgfrevzon";

        int result = solve(s);

        System.out.println(String.valueOf(result));

    }
}

