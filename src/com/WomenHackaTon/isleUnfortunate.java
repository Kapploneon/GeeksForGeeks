package com.WomenHackaTon;

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

public class isleUnfortunate {

    // Complete the solve function below.
    static int solve(List<Integer> customer, int k, int customerCount) {

        Collections.sort(customer);
        int nextO = 0;
        int count = 0;
        for(Integer ele : customer){


            if(nextO == 0 || Math.abs(nextO - ele) > k ){
                nextO = ele + k;
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = scanner.nextInt();

            while(t-- > 0){
                int customerCount = scanner.nextInt();

                List<Integer> customer = new ArrayList<Integer>();
                int c = 0;
                while (c++ < customerCount) {
                    customer.add(scanner.nextInt());
                };

                int customerCount2 = scanner.nextInt();

                List<Integer> customer2 = new ArrayList<Integer>();
                int c2 = 0;
                while (c2++ < customerCount2) {
                    customer2.add(scanner.nextInt());
                };

//                int k = scanner.nextInt();

//                int result = solve(customer, k, customerCount);

                int result = solveC(customer, customer2);

                System.out.println(result);

        };

    }

    // Complete the solve function below.
    static int solveC(List<Integer> list1, List<Integer> list2) {

        int changes = 0;

        List<Integer> tempList = new ArrayList<>(list1);

        // Remove not found elements.
        for(Integer ele : tempList){

            if(!list2.contains(ele)){
                list1.remove(ele);
                changes++;
            }

        }

        List<Integer> tempList2 = new ArrayList<>(list2);

        // Remove not found elements.
        for(Integer ele : list2){

            if(!tempList.contains(ele)){
                tempList2.remove(ele);
            }

        }

        // Now the both list should be equal so only the positions need to be change.
        // Re-arranging the positions of the element so that they are in sync.
        int i = 0;
        tempList = new ArrayList<>(list1);
        for(Integer ele : tempList){
            if(ele != tempList2.get(i)){

            }
        }


        for(Integer ele : list2) {
            if (list1.contains(ele)) {
                if (ele != list1.get(i)) {
                    if (list1.indexOf(ele) > 0) {
                        list1.remove(ele);
                        list1.add(i, ele);
                        changes++;
                    }
                    i++;
                }
            }
        }

        // Add the elements which are required(are there in list2) but are not there in list1.
        i = 0;
        for(Integer ele : list2){
            if(!list1.contains(ele)){
                list1.add(i,ele);
                changes++;
            }
            i++;
        }

        return changes;

    }

}
