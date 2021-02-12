package main;


import static main.State.*;

/**
 * @author Chanon Borgström & Sofia Hallberg
 * @created 05/02/2021
 * @project SysII_TestLab
 */
public class Clock {

    private Time theTime;
    private Date theDate;
    private State state;

    public Clock() {
        theTime = new Time();
        theDate = new Date();
        state = DisplayTime;
    }

    public String changeMode() {
        String returnStatement = null;

        switch (state) {
            case DisplayTime:
                returnStatement = theDate.showDate();
                state = DisplayDate;
                break;

            case DisplayDate:
                returnStatement = theTime.showTime();
                state = DisplayTime;
                break;

            default:
                returnStatement = "Error changeMode";
        }
        return returnStatement;
    }

    public String ready() {
        String returnStatement = null;

        switch (state) {
            case DisplayTime:
                returnStatement = "Ready to accept time";
                state = ChangeTime;
                break;

            case DisplayDate:
                returnStatement = "Ready to accept date";
                state = ChangeDate;
                break;

            default:
                returnStatement = "Error ready";
        }

        return returnStatement;
    }

    public String set(int p1, int p2, int p3) {
        String returnStatement = null;

        switch (state) {
            case ChangeTime:
                if (theTime.timeSet(p1, p2, p3).equals("Invalid Time")) {
                    returnStatement = "Invalid Time";
                } else {
                    returnStatement = theTime.showTime();
                    state = DisplayTime;
                }
                break;

            case ChangeDate:
                if (theDate.dateSet(p1, p2, p3).equals("Invalid Date")) {
                    returnStatement = "Invalid Date";
                } else {
                    returnStatement = theDate.showDate();
                    state = DisplayDate;
                }
                break;

            default:
                returnStatement = "Error set";
        }

        return returnStatement;
    }
}
