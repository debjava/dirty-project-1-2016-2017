package com.ddlab.rnd.core;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by PIKU on 8/27/2016.
 */
public class TestOutOfMemoryGenerator {

    private OutOfMemoryGenerator oomGenerator;

    @Before
    public void init() {
        oomGenerator = new OutOfMemoryGenerator();
    }

    @Test
    public void testSimpleOOM() {
        try {
            oomGenerator.generateSimpleOOM();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testComplexOOM() {
        try {
            oomGenerator.generateComplexOOM();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
