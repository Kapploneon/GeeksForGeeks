package com.Misc;

class Base {
    private static void display() {
        System.out.println("Static or class method from Base");
    }

    public void print() {
        System.out.println("Non-static or instance method from Base");
    }
    public void dis(){

    }
}

class Derived extends Base {
    private static void display() {
        System.out.println("Static or class method from Derived");
    }

    public void print() {
        System.out.println("Non-static or instance method from Derived");
    }

    public void dis(){
        display();
    }

}

public class test12312 {
    public static void main(String args[]) {
        Base obj1 = new Derived();
        obj1.dis();
        obj1.print();
    }
}