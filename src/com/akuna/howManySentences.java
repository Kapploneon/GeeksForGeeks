package com.akuna;
/*
*     // Complete the countSentences function below.
    static List<Long> countSentences(List<String> wordSet, List<String> sentences) {

        // List<Long> wordACount = new ArrayList<>();

        int size = wordSet.size();
        long[] wordACount = new long[size];

        for(int i = 0; i < size; i++){
            String cur = wordSet.get(i);
            char[] c = cur.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            long y = 1;

            for(int x = 0; x < c.length; x++){
                if(!map.containsKey(c[x])){
                    map.put(c[x], 1);
                }else{
                    map.put(c[x], map.get(c[x]) + 1);
                }
            }

            // Loop through all the words except the current and those whose length do not match.
            for(int j = 0; j < size; j++){

                String curTemp = wordSet.get(j);
                char[] ct = curTemp.toCharArray();

                // If the length of words are not same then they cannot be anagram.
                if(i == j || ct.length != c.length){
                    continue;
                }

                HashMap<Character, Integer> mapTemp = new HashMap<>(map);
                boolean flag = true;

                for(int x = 0; x < ct.length; x++){
                    if(!mapTemp.containsKey(ct[x])){
                        flag = false;
                        break;
                    }else{
                        int t = mapTemp.get(ct[x]);
                        if(t <= 0){
                            flag = false;
                            break;
                        }
                        mapTemp.put(ct[x], t - 1);
                    }
                }

                if(flag){
                    for(Map.Entry<Character, Integer> entry : mapTemp.entrySet()){
                        if(entry.getValue() > 0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        // If anagram found then check the wordAcount of the matching word. If > 0 then we do not have to recalculate.
                        if(wordACount[j] > 0){
                            wordACount[i] = wordACount[j];
                            break;
                        }
                        y++;
                    }
                }
            }

            if(wordACount[i] == 0){
                wordACount[i] = y;
            }
        }

        size = sentences.size();
        List<Long> sent = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String s = sentences.get(i);
            String[] arr = s.split(" ");
            long temp = 1;

            for(String ss : arr){
                for(int j = 0; j < wordSet.size(); j++){
                    if(ss.equals(wordSet.get(j))){
                        temp *= wordACount[j];
                    }
                }
            }

            sent.add(temp);
        }

        return sent;
    }


Sample Input:
6
the
bats
tabs
in
cat
act
3
cat the bats
in the act
act tabs in

Sample Output:
4
2
4

**/

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

public class howManySentences {

    // Complete the countSentences function below.
    static List<Long> countSentences(List<String> wordSet, List<String> sentences) {

        // List<Long> wordACount = new ArrayList<>();

        int size = wordSet.size();
        long[] wordACount = new long[size];

        for(int i = 0; i < size; i++){
            String cur = wordSet.get(i);
            char[] c = cur.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            long y = 1;

            for(int x = 0; x < c.length; x++){
                if(!map.containsKey(c[x])){
                    map.put(c[x], 1);
                }else{
                    map.put(c[x], map.get(c[x]) + 1);
                }
            }

            // Loop through all the words except the current and those whose length do not match.
            for(int j = 0; j < size; j++){

                String curTemp = wordSet.get(j);
                char[] ct = curTemp.toCharArray();

                // If the length of words are not same then they cannot be anagram.
                if(i == j || ct.length != c.length){
                    continue;
                }

                HashMap<Character, Integer> mapTemp = new HashMap<>(map);
                boolean flag = true;

                for(int x = 0; x < ct.length; x++){
                    if(!mapTemp.containsKey(ct[x])){
                        flag = false;
                        break;
                    }else{
                        int t = mapTemp.get(ct[x]);
                        if(t <= 0){
                            flag = false;
                            break;
                        }
                        mapTemp.put(ct[x], t - 1);
                    }
                }

                if(flag){
                    for(Map.Entry<Character, Integer> entry : mapTemp.entrySet()){
                        if(entry.getValue() > 0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        // If anagram found then check the wordAcount of the matching word. If > 0 then we do not have to recalculate.
                        if(wordACount[j] > 0){
                            wordACount[i] = wordACount[j];
                            break;
                        }
                        y++;
                    }
                }
            }

            if(wordACount[i] == 0){
                wordACount[i] = y;
            }
        }

        size = sentences.size();
        List<Long> sent = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String s = sentences.get(i);
            String[] arr = s.split(" ");
            long temp = 1;

            for(String ss : arr){
                for(int j = 0; j < wordSet.size(); j++){
                    if(ss.equals(wordSet.get(j))){
                        temp *= wordACount[j];
                    }
                }
            }

            sent.add(temp);
        }

        return sent;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordSetCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> wordSet = new ArrayList<>();

        IntStream.range(0, wordSetCount).forEach(i -> {
            try {
                wordSet.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int sentencesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> sentences = new ArrayList<>();

        IntStream.range(0, sentencesCount).forEach(i -> {
            try {
                sentences.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Long> res = countSentences(wordSet, sentences);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
