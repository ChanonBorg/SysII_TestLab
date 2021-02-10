package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chanon Borgström and Sofia Hallberg
 * @created 05/02/2021
 * @project SysII-Labb-Testning
 */
class ClockTest {
    private Clock testClock;
    private State state;

    @BeforeEach
    void setUp() {
        testClock=new Clock();
        System.out.println("Clock is created");
    }

    @Test
    void changeMode() {

        Assert.assertEquals(testClock.changeMode(), "2000-1-1");  //hamnar i S2
        Assert.assertEquals(testClock.changeMode(), "0:0:0");     // hamnar i S1
    }

    @Test
    void ready() {
        Assert.assertEquals(testClock.ready(), "Ready to accept time"); // Från S1 till S3
        set();
        Assert.assertEquals(testClock.ready(),"Ready to accept date");
    }

    @Test
    void set() {
        System.out.println("inne i set()");
        changeMode(); // Hamnar i S2

        //Testar olika inparametrar till timeSet
        Assert.assertEquals(testClock.set(07,07,07), "07:07:07"); // Från S2 till S4
        Assert.assertEquals(testClock.set(-1,07,07), "Invalid time");
        Assert.assertEquals(testClock.set(07,-1,07), "Invalid time");
        Assert.assertEquals(testClock.set(07,07,-1), "Invalid time");
        Assert.assertEquals(testClock.set(24,07,07), "Invalid time");
        Assert.assertEquals(testClock.set(07,60,07), "Invalid time");
        Assert.assertEquals(testClock.set(07, 07, 60), "Invalid time");
        Assert.assertEquals(testClock.set(-1, 07, 60), "Invalid time");
        Assert.assertEquals(testClock.set(-1, -1, -1), "Invalid time");
        Assert.assertEquals(testClock.set(24, 60, 60), "Invalid time");

        //Testar olika inparametrar till dateSet
        Assert.assertEquals(testClock.set(2010,12,12), "07:07:07");
        Assert.assertEquals(testClock.set(1999,07,07), "Invalid date");
        Assert.assertEquals(testClock.set(2010,0,07), "Invalid date");
        Assert.assertEquals(testClock.set(2010,07,0), "Invalid date");
        Assert.assertEquals(testClock.set(2010,07,07), "Invalid date");
        Assert.assertEquals(testClock.set(07,60,07), "Invalid date");
        Assert.assertEquals(testClock.set(07, 07, 60), "Invalid date");
        Assert.assertEquals(testClock.set(-1, 07, 60), "Invalid date");
        Assert.assertEquals(testClock.set(-1, -1, -1), "Invalid date");
        Assert.assertEquals(testClock.set(25, 60, 60), "Invalid date");
    }
}