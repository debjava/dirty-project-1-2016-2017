package com.ddlab.rnd.core;

import java.util.concurrent.TimeUnit;

/**
 * Created by PIKU on 8/26/2016.
 */
public class TestOutOfMemory {

    public static void generateOOM_1() throws Exception {
        System.out.println("Going to create OutOfMemory Error ...");
        TimeUnit.SECONDS.sleep(1);
        long[] l = new long[Integer.MAX_VALUE];
    }

    public static void generateOOM() throws Exception {
        int mb = 1024*1024;
        int iteratorValue = 20;
        System.out.println("\n=================> OOM test started..\n");
        for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
            System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory()/mb +" MB");
            int loop1 = 2;
            int[] memoryFillIntVar = new int[iteratorValue];
            // feel memoryFillIntVar array in loop..
            do {
                memoryFillIntVar[loop1] = 0;
                loop1--;
            } while (loop1 > 0);
            iteratorValue = iteratorValue * 5;
            System.out.println("\nRequired Memory for next loop: " + iteratorValue);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws Exception {
        generateOOM();
//        generateOOM_1();
    }


}
