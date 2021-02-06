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
        theYear=2000;
        theMonth=01;
        theDay=01;
        System.out.println("Date is created");
    }

    protected String dateSet(int year, int month, int day){
        theYear=year;
        theMonth=month;
        theDay=day;

        return theYear+"-"+theMonth+"-"+theDay;
    }

    protected String showDate(){
        return theYear+"-"+theMonth+"-"+theDay;
    }
}
