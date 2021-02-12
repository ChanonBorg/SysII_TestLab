package main;

/**
 * @author Chanon Borgström & Sofia Hallberg
 * @created 05/02/2021
 * @project SysII_TestLab
 */
public class Date {
    private int theYear;
    private int theMonth;
    private int theDay;

    public Date() {
        theYear = 2000;
        theMonth = 01;
        theDay = 01;
    }

    protected String dateSet(int year, int month, int day) {
        String returnstatement = "";

        if (year > 1999 && year < 2101 && month > 0 && month < 13 && day > 0 && day < 32) {
            theYear = year;
            theMonth = month;
            theDay = day;
            returnstatement = theYear + "-" + theMonth + "-" + theDay;
        } else {
            returnstatement = "Invalid Date";
        }

        return returnstatement;
    }

    protected String showDate() {
        return theYear + "-" + theMonth + "-" + theDay;
    }
}
