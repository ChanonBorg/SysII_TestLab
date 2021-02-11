package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Testing transition S1 to S2")
    void changeModeS1ToS2() {
        Assert.assertEquals(testClock.changeMode(), "2000-1-1");
    }

    @Test
    @DisplayName("Testing transition S2 to S1")
    void changeModeS2ToS1() {
        testClock.changeMode();
        Assert.assertEquals(testClock.changeMode(), "0:0:0");
    }

    @Test
    @DisplayName("Testing transition S1 to S3")
    void readyS1ToS3() {
        Assert.assertEquals(testClock.ready(), "Ready to accept time");
    }


    @Test
    @DisplayName("Testing S2 to S4")
    void readyS2ToS4() {
        testClock.changeMode();
        Assert.assertEquals(testClock.ready(), "Ready to accept date");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no1() {
        testClock.ready();
        Assert.assertEquals(testClock.set(-1,-1,-1), "Hours minutes and seconds below limit");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with correct values")
    void setS3ToS1no2() {
        testClock.ready();
        Assert.assertEquals(testClock.set(0,0,0), "0:0:0");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with correct values")
    void setS3ToS1no3() {
        testClock.ready();
        Assert.assertEquals(testClock.set(23,59,59) ,"23:59:59");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no4() {
        testClock.ready();
        Assert.assertEquals(testClock.set(24,60,60), "Hours, minutes and seconds above limit");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no5() {
        testClock.ready();
        Assert.assertEquals(testClock.set(-1,59,59), "Hours below limit");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no6() {
        testClock.ready();
        Assert.assertEquals(testClock.set(23,-1,59), "Minutes below limit");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no7() {
        testClock.ready();
        Assert.assertEquals(testClock.set(23,59,-1), "Seconds below limit ");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no8() {
        testClock.ready();
        Assert.assertEquals(testClock.set(24,59,59), "Hours above limit");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no9() {
        testClock.ready();
        Assert.assertEquals(testClock.set(23,60,59), "Minutes above limit");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with incorrect values")
    void setS3ToS1no10() {
        testClock.ready();
        Assert.assertEquals(testClock.set(23,59,60), "Seconds above limit");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with correct values")
    void setS3ToS1no11() {
        testClock.ready();
        Assert.assertEquals(testClock.set(0,59,59), "0:59:59");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with correct values")
    void setS3ToS1no12() {
        testClock.ready();
        Assert.assertEquals(testClock.set(23,0,59), "23:0:59");
    }

    @Test
    @DisplayName("Testing transition S3 to S1 with correct values")
    void setS3ToS1no13() {
        testClock.ready();
        Assert.assertEquals(testClock.set(23,59,0), "23:59:0");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no1() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(1999,0,0), "Year, month and day below limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with correct values")
    void setS4ToS2no2() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2000,1,1), "2000-1-1");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with correct values")
    void setS4ToS2no3() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2100,12,31), "2100-12-31");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no4() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2101,13,32), "Year, month and day above limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no5() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(1999,1,1), "Year below limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no6() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2000,0,1), "Month below limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no7() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2000,1,0), "Day below limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no8() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2101,1,1), "Year above limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no9() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2000,13,1), "Month above limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no10() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(2000,1,32), "Day above limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no11() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(1999, 12, 31), "Year below limit");
    }

    @Test
    @DisplayName("Testing transition S4 to S1 with incorrect values")
    void setS4ToS2no12() {
        testClock.changeMode();
        testClock.ready();
        Assert.assertEquals(testClock.set(1999, 1, 32), "Year below limit and day above limit");
    }
}