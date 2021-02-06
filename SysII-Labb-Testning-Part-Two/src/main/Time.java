package main;

/**
 * @author Chanon Borgström & Sofia Hallberg
 * @created 05/02/2021
 * @project SysII_TestLab
 */
public class Time {
    private int theHour;
    private int theMinute;
    private int theSecond;

    public Time() {
        theHour=00;
        theMinute=00;
        theSecond=00;
        System.out.println("Time is created");
    }

    protected String timeSet(int hour, int minute, int second) {
        theHour = hour;
        theMinute = minute;
        theSecond = second;
        return theHour+":"+theMinute+":"+theSecond;
    }

    protected String showTime() {

        return theHour+":"+theMinute+":"+theSecond;
    }
}
