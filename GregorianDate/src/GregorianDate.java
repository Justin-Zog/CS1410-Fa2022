/*
TODO: Class GregorianDate to have a default constructor that sets the date to the current date.
Check TODO: Overloaded Constructor that takes year, month and date values and sets the date to that date. GregorianDate(int year, int month, int day)
Check TODO: Method that adds a specified number of days to the calendar date: void addDays(int days)
Check TODO: Method that subtracts a specified number of days to the calender date: void subtractDays(int days)
Check TODO: Method that returns true if a leap year and false otherwise: boolean isLeapYear()
TODO: Method that prints the calendar date (with no carriage return): mm/dd/yyyy: void printShortDate()
TODO: Method that prints the calender date (with no carriage return): Monthname dd, yyyy: void printLongDate()
TODO: 'getter' methods for the month's name, month, year, and day.
 */

import java.util.TimeZone;

public class GregorianDate {

    private int year;
    private int month;
    private int day;

    public GregorianDate() {

        this.year = getCurrentDate()[2];
        this.month = getCurrentDate()[1];
        this.day = getCurrentDate()[0];

    }

    public GregorianDate(int year, int month, int day) {

        this.year = year;
        this.month = month;
        this.day = day;

    }

    public String getMonthName() {
        switch (this.month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }

        return "";
    }

    public int getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    // TODO: Done I think...
    public void addDays(int days) {

        // add the days to the 'Date' object's day.
        this.day += days;

        // Now we have to convert the month and year to match the current day.
        // Run a loop that converts the days and months, etc.
        boolean translated = false;
        while (!translated) {
            // The month has 31 days.
            if (this.day > 31 & (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)) {
                this.day -= 31;
                if (this.month == 12) {
                    this.month = 1;
                    this.year += 1;
                }
                else {
                    this.month += 1;
                }

            }
            // The month has 30 days.
            else if (this.day > 30 & (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)) {

                this.day -= 30;
                this.month += 1;

            }
            // The month has 28 days
            else if (this.day > 28 & (this.month == 2)) {

                if (this.isLeapYear() & this.day > 29) {
                    this.day -= 29;
                    this.month += 1;
                }
                // Checking to see if this.day is redundant but helps make the code more readable.
                else if (!this.isLeapYear() & this.day > 28) {
                    this.day -= 28;
                    this.month += 1;
                }
                // Otherwise this loop got hit exactly on Leap Day and needs to set 'translated' to true.
                else {
                    translated = true;
                }

            }
            // This.day is in an accurate range for the current month and we can exit the loop.
            else {
                translated = true;
            }

        }


    }

    // TODO: Done I think...
    public void subtractDays(int days) {

        // subtract the days from the 'Date' object's day.
        while (days > 0) {

            if (this.day == 1 & this.month == 1) {

                this.year -= 1;
                this.month = 12;
                this.day = 31;

            }
            else if (this.day == 1 & (this.month == 2 || this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)) {
                this.month -= 1;
                this.day = 31;

            }
            else if (this.day == 1 & (this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)) {
                this.month -= 1;
                this.day = 30;

            }
            else if (this.day == 1 & this.month == 3) {

                this.month -= 1;

                if (this.isLeapYear()) {
                    this.day = 29;
                }
                else {
                    this.day = 28;
                }

            }
            else {
                this.day -= 1;
            }

            days --;
        }

    }

    // TODO: Done I think...
    public Boolean isLeapYear() {

        if (this.year % 4 == 0) {

            if (this.year % 100 == 0) {
                return false;
            }
            else {
                return true;
            }


        }
        else {
            return false;
        }

    }

    // TODO
    public void printShortDate() {
        System.out.printf("%d%n/%d%n/%d%n", this.month, this.day, this.year);
    }

    public void printLongDate() {
        System.out.printf("%s %d%n, %d%n", this.getMonthName(), this.day, this.year);
    }

    // Gets the current date
    public int[] getCurrentDate() {
        int[] currentDate = new int[3];

        // [0] is the day, [1] is the month, [2] is the year
        // GETS THE CURRENT YEAR
        // Gets how many seconds have happened since January 1st, 1970. In the current timezone.
        long currentSecs = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000;
        // There are 86400 seconds in a day
        double daysSince1970 = (double) (currentSecs / 86400);
        // There are usually 365 days in a year. (Leap Year there are 366).
        double yearsSince1970 = daysSince1970 / 365.2425;

        currentDate[2] = (int) (1970 + yearsSince1970);

        // GETS THE CURRENT MONTH
        int leapYears = (int) (yearsSince1970 - 1968) / 4;
        double amountOfMonths = (yearsSince1970 - 1970 - leapYears) * 12;
        double currentMonth = (amountOfMonths / 12);

        currentDate[1] = (int) currentMonth;

        // GETS THE CURRENT DAY
        // @!@#$%^&*(*^%$#@@!@#$

        currentDate[0] = 24;


        return currentDate;

    }

}

