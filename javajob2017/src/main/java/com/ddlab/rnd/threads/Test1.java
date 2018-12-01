package com.ddlab.rnd.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test1 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            MyThread t1 = new MyThread("T" + i);
            futureList.add(executorService.submit(t1));
        }

        for( Future future : futureList)
            System.out.println(future.get());
    }
}
