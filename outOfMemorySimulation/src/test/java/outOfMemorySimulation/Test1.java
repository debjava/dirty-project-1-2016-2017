package outOfMemorySimulation;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by PIKU on 8/27/2016.
 */

public class Test1 {

    @Test
    public void test1() {
        try {
            generateOOM_1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateOOM_1() throws Exception {
        System.out.println("Going to create OutOfMemory Error ...");
        TimeUnit.SECONDS.sleep(1);
        long[] l = new long[Integer.MAX_VALUE];
    }
}
