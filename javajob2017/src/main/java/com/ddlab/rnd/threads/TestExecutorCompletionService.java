package com.ddlab.rnd.threads;

import java.util.concurrent.*;

/**
 * Created by PIKU on 5/3/2017.
 */
public class TestExecutorCompletionService {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletionService completionService = new ExecutorCompletionService(executorService);

        for (int i = 1; i < 6; i++) {
            MyThread t1 = new MyThread("T" + i);
            completionService.submit(t1);
        }

        for( int i = 1 ; i < 6 ; i++ ) {
            Future future = completionService.take();
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
