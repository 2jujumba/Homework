package dev.jujumba;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private static Main main;

    @BeforeEach
    void init() {
        main = new Main();
        main.iterFunction(0.0,3.0,0.004);
    }
    @Test
    void testFunction() {
        double x = 1.1;
        double expected = -0.025042574520726175;

        assertEquals(expected, main.function(x),0.001);
    }

    @Test
    void testCalculateSteps() {
        int expected = 750;
        assertEquals(expected, main.calculateSteps(0.0,3.0,0.004),0.001);
    }
    @Test
    void testIterFunction() {
        assertEquals(0.7, main.getX()[175],0.001);
        assertEquals(0.037, main.getY()[175],0.001);

        assertEquals(1.4, main.getX()[350],0.001);
        assertEquals(-0.467, main.getY()[350],0.001);

        assertEquals(3.0, main.getX()[750],0.001);
        assertEquals(0.214,main.getY()[750],0.001);
    }
    @Test
    void testGetMinY() {
        assertEquals(-0.47,main.getMinY(),0.001);
    }

    @Test
    void testGetMaxY() {
        assertEquals(1.0,main.getMaxY(),0.01);
    }

    @Test
    void testSumY() {
        assertEquals(123.556,main.sumY(),0.001);
    }

    @Test
    void testAverageY() {
        assertEquals(0.164,main.averageY(),0.001);
    }
}
