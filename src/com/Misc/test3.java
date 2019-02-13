package com.Misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student{
    int id;
    String name;
    float cgpa;

    public Student(int id, String name, float cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getCGPA(){
        return cgpa;
    }
}

class Priorities{

    public List<Student> getStudents(List<String> events){
        int size = events.size();
        PriorityQueue<Student> list = new PriorityQueue<>(size,studentComparator);
        List<Student> students = new ArrayList<>();
        int i = 0;
        while(i < size){
            String temp = events.get(i);
            String[] query = temp.split(" ");

            if(query[0].equals("ENTER")){
                list.add(new Student(Integer.parseInt(query[3]), query[1], Float.parseFloat(query[2])));
            }else if(query[0].equals("SERVED")){
                list.poll();
            }

            i++;
        }

        Student first = list.poll();
        if(first == null){
            return students;
        }else{
            while(first != null){
                students.add(first);
                first = list.poll();
            }
        }

        return students;
    }

    public static Comparator<Student> studentComparator = new Comparator<Student>(){

        @Override
        public int compare(Student a, Student b){

            if(a.getCGPA() > b.getCGPA())
                return -1;
            if(a.getCGPA() < b.getCGPA())
                return 1;

            int x = a.getName().compareTo(b.getName());

            if(x != 0)
                return x;

            if(a.getID() < b.getID())
                return -1;

            if(a.getID() > b.getID())
                return 1;

            return 0;
        }

    };

}

class test3 {
    private static Scanner scan = null;

    static {
        try {
            scan = new Scanner( new FileInputStream(new File("input/dummy")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}