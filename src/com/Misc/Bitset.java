//package com.Misc;
//
//import java.io.*;
//import java.util.*;
//
//import static jdk.nashorn.internal.parser.TokenType.CASE;
//
//public class Bitset {
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int testcases = input.nextInt();
//        BitSet a = new BitSet(n);
//        BitSet b = new BitSet(n);
//
//        while(testcases-- > 0){
//            String what = input.next();
//            int which = input.nextInt();
//            int j = input.nextInt();
//
//            if(which == 1){
//                switch(what){
//                    case "AND":
//                        a.and(b);
//                        break;
//                    case "OR":
//                        a.or(b);
//                        break;
//                    case "XOR":
//                    a.xor(b);
//                    break;
//                    case "FLIP":
//                    a.flip(j);
//                    break;
//                    case "SET":
//                    a.set(j);
//                    break;
//                }
//            }
//            }
//
//
//
//
//
//        }
//
//    }
