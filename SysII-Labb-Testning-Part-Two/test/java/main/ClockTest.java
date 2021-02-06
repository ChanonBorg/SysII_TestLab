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

    @BeforeEach
    void setUp() {
        testClock=new Clock();
    }

    @Test
    void changeMode() {
        Assert.assertEquals("2000-1-1",testClock.changeMode());  //hamnar i DisplayDate
        Assert.assertEquals("0:0:0",testClock.changeMode());        // hamnar i DisplayTime
    }

    @Test
    void ready() {
        Assert.assertEquals("Ready to accept time", testClock.ready()); // Från DisplayTime till ChangeTime
        Assert.assertEquals("Ready to accept date", testClock.ready());
    }

    @Test
    void set() {
        Assert.assertEquals("07:07:07", testClock.set(07,07,07)); // Från ChangeTime till DisplayTime
        Assert.assertEquals("07:07:07", testClock.set(2021,12,12));
    }
}