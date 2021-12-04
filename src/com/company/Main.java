package com.company;

public class Main {
    public static void main(String[] args) {
        ATCThread ats = new ATCThread();
        Thread thread1 = new Thread(ats);
        Thread thread2 = new Thread(new Operator(ats),"Анна" );
        Thread thread3 = new Thread(new Operator(ats),"Влад" );
        Thread thread4 = new Thread(new Operator(ats),"Олег" );
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все звонки обработаны");
    }
}
