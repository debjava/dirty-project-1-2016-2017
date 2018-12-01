package com.ddlab.rnd.threads;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by PIKU on 5/3/2017.
 */
public class MyThread implements Callable {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Date date = new Date();
        TimeUnit.SECONDS.sleep(1);
        return (name+"-"+date.toString());
    }
}
