package com.company;

public class Operator implements Runnable {
    ATCThread ats;
    private final int TIMEOUT = 4000;

    public Operator(ATCThread ats) {
        this.ats = ats;
    }

    @Override
    public void run() {
        String call;
        while (ats.isGeneration() || !ats.getCalls().isEmpty()) {
            if ((call = ats.getCalls().poll()) != null) {
                System.out.println("Оператор " + Thread.currentThread().getName() + " ответил на звонок " + call);
                try {
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Оператор " + Thread.currentThread().getName() + " закончил разговор.");
            }
        }
    }
}
