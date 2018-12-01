package com.ddlab.rnd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by PIKU on 2/20/2017.
 */
public class Test1 {

    private static AtomicLong idCounter = new AtomicLong();

    public static String getID() {
        return String.valueOf(idCounter.getAndIncrement());
    }

    public static void storeDocsSequentially() throws Exception {
        for (int i = 0; i < 100; i++) {
            String zipCode = "ZIP" + String.format("%05d", i);
            for (int j = 0; j < 50; j++) {
                String courseCode = "COURSE" + String.format("%05d", j);
                String id = getID();
                System.out.println(id + "-" + zipCode + "<---->" + courseCode);
                //Do some operation
                TimeUnit.MILLISECONDS.sleep(200);
            }
        }
    }

    public static void storeDocs() throws Exception {
        ExecutorService exService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            String zipCode = "ZIP" + String.format("%05d", i);
            InnerThread inner = new InnerThread(zipCode);
            exService.execute(inner);
        }
        while (!exService.isTerminated())
            exService.shutdown();
        //You can try below
//        taskExecutor.shutdown();
//        try {
//            taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//        } catc
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();

        storeDocs();
//        storeDocsSequentially();

        System.out.println("Indexing completed successfully ...");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.NANOSECONDS);
        long seconds = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
        System.out.println("Total time taken :::" + minutes + " minutes" + " OR " + seconds + " " +
                "seconds");

    }
}
