package com.WomenHackaTon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class busyDay {

    // Complete the solve function below.
    static String solve(List<List<String>> reservations) throws ParseException {

        TreeMap<Date, Integer> map = new TreeMap<>();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");

        for(List<String> range : reservations){
            Date from = formatter1.parse(range.get(0));
            Date to = formatter1.parse(range.get(1));
            to = new Date(to.getTime() + 24*60*60*1000);

            while(!from.equals(to)){

                if(map.containsKey(from)){
                    map.put(from, map.get(from) + 1);
                }else{
                    map.put(from, 1);
                }

                from = new Date(from.getTime() + 24*60*60*1000);

            }

        }

        int max = 0;
        Date y = null;

        for(Map.Entry<Date, Integer> ele : map.entrySet()){
            if(max < ele.getValue() ){
                max = ele.getValue();
                y = ele.getKey();
            }
        }

        return formatter1.format(y);
//        Date date1 = formatter1.parse(x);
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date1);
//        cal.add(Calendar.DATE, 1);
//
//        String date2 = formatter1.format(cal.getTime());
//
//        System.out.println("original" + "\t" + date1);
//        System.out.println("new"+"\t" + date2);


    }

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(new FileInputStream(new File("input/dummy")));

        int t = scanner.nextInt();

        while (t-- > 0){
                int n = scanner.nextInt();
                scanner.nextLine();

                List<List<String>> reservations = new ArrayList<>();

                while(n-- > 0){
                        reservations.add(
                                Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                                        .collect(toList())
                        );

                };

                String result = solve(reservations);

                System.out.println(result);
        };
    }
}

