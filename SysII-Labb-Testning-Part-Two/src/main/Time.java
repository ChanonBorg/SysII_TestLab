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
    }

    protected String timeSet(int hour, int minute, int second) {
        String returnStatement="";
        if(hour>=0 && hour<24 && minute>=0 && minute<59 && second>=0 && second<59) {
            theHour = hour;
            theMinute = minute;
            theSecond = second;
            returnStatement=theHour+":"+theMinute+":"+theSecond;
        }
        else {
            returnStatement="Invalid time";
        }
        return returnStatement;
    }

    protected String showTime() {

        return theHour+":"+theMinute+":"+theSecond;
    }
}
