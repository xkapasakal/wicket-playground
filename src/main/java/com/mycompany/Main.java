package com.mycompany;

public class Main {

    public void hello(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.hello("world");
    }
}
