package com.Misc;

class Singleton{

    public String str;
    private Singleton(){}

    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }

    static Singleton getSingleInstance(){
        return SingletonHolder.instance;
    }
}
