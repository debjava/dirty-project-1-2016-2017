package com.ddlab.rnd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by PIKU on 2/20/2017.
 */
public class InnerThread implements Runnable {

    private String zipCode = null;

    private static AtomicLong idCounter = new AtomicLong();

    public InnerThread(String zipCode) {
        this.zipCode = zipCode;
        Thread.currentThread().setName("FooName");
    }

    public static String getID() {
        return String.valueOf(idCounter.getAndIncrement());
    }

    @Override
    public void run() {

        try {
            for (int j = 0; j < 50; j++) {
                String courseCode = "COURSE" + String.format("%05d", j);
                String id = getID();
                System.out.println(id + "-" + zipCode + "<---->" + courseCode);
                //Do some operation
                TimeUnit.MILLISECONDS.sleep(200);
            }
        }
        catch(Exception e ) {
            e.printStackTrace();
        }

    }
}
