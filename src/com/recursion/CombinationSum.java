package com.recursion;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class CombinationSum {
    public static void main(String args[]){

        // Read file.
        Scanner sc= null;
        try {
            sc = new Scanner(new File("input/CombinationSum"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CombinationSum cs= new CombinationSum();
        // Number of test cases.
        int t=sc.nextInt();

        while(t>0){

            List<List<Integer>> result = new ArrayList<>();

            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            int target=sc.nextInt();
            List<Integer> comb = new ArrayList<>();

            Arrays.sort(arr);

            cs.findComb(arr,result,comb,target,0);

            if(result.size()==0)
                System.out.println("Empty");
            else{
                for(int i=0;i<result.size();i++){
                    System.out.print("(");
                    List<Integer> res=result.get(i);
                    for(int j=0;j<res.size();j++){
                        System.out.print(res.get(j));
                        if(j!=res.size()-1)
                            System.out.print(" ");
                    }
                    System.out.print(")");
                }
                System.out.print("\n");
            }
            t--;
        }
    }

    void findComb(int[] arr,List<List<Integer>> res,List<Integer> comb,int target,int sind){

        if(target==0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int i=sind; i<arr.length; i++){
            if(i!=sind && arr[i]==arr[i-1])
                continue;
            if(arr[sind]>target)
                break;
            comb.add(arr[i]);
            findComb(arr,res,comb,target-arr[i],i+1);
            comb.remove(comb.size()-1);
        }

    }
}

