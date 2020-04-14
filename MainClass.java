package ru.geekbrains.java3_lesson4;

public class MainClass {

    protected static volatile int condition = 0;

    public static void main(String[] args) {

        MainClass mc = new MainClass();

        Thread thread1 = new Thread(new Symbols('A', mc,1));
        Thread thread2 = new Thread(new Symbols('B', mc,2));
        Thread thread3 = new Thread(new Symbols('C', mc,3));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

