package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author
 * @created 05/02/2021
 * @project SysII_TestLab
 */
class ClockTest {
    private Clock testClock;

    @BeforeEach
    void setUp() {
        testClock=new Clock();
    }

    @Test
    void changeMode() {
// börjar vid s1 med defaultvärden
        Assert.assertEquals("2000-01-01",testClock.changeMode());
        testClock.changeMode();
        Assert.assertEquals("00:00:00",testClock.changeMode());

        // TODO: 2021-02-05 testa igenom alla states för varje metod

    }

    @Test
    void ready() {
    }

    @Test
    void set() {
    }
}