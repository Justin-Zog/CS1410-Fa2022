// Justin Herzog October 2022

import java.util.TimeZone;

public class GregorianDate {

    private int year;
    private int month;
    private int day;

    public GregorianDate() {

        int[] currentDate = getCurrentDate();

        this.year = currentDate[2];
        this.month = currentDate[1];
        this.day = currentDate[0];

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

    public void subtractDays(int days) {

        // subtract the days from the 'Date' object's day.
        while (days > 0) {

            if (this.day == 1 & this.month == 1) {

                this.year -= 1;
                this.month = 12;
                this.day = 31;

            }
            else if (this.day == 1 & (this.month == 2 || this.month == 4 || this.month == 6 || this.month == 8 || this.month == 9 || this.month == 11)) {
                this.month -= 1;
                this.day = 31;

            }
            else if (this.day == 1 & (this.month == 5 || this.month == 7 || this.month == 10 || this.month == 12)) {
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

    public boolean isLeapYear() {

        if (this.year % 4 == 0) {

            if (this.year % 400 == 0) {
                return true;
            }
            else if (this.year % 100 == 0) {
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

    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {

            if (year % 400 == 0) {
                return true;
            }
            else if (year % 100 == 0) {
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

    private int getNumberOfDaysInMonth(int year, int month) {

        switch (month) {
            case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12:
                return 31;
            case 4 : case 6 : case 9 : case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                }
                else {
                    return 28;
                }
        }

        return -1;

    }

    private int getNumberOfDaysInYear(int year) {

        if (isLeapYear(year)) {
            return 366;
        }
        else {
            return 365;
        }

    }

    public void printShortDate() {
        System.out.printf("%d/%d/%d", this.month, this.day, this.year);
    }

    public void printLongDate() {
        System.out.printf("%s %d, %d", this.getMonthName(), this.day, this.year);
    }

    // Gets the current date
    public int[] getCurrentDate() {
        int[] currentDate = new int[3];

        // I'm gonna try to run the rework right here.
        // [0] is the day, [1] is the month, [2] is the year
        // GETS THE CURRENT YEAR
        int yearsSince1970 = 0;
        // Number of seconds since Jan 1st 1970, adjusted for the timezone.
        long currentSecs = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000;
        // There are 86400 seconds in a day.
        long daysSince1970 = (long) (currentSecs / 86400);
        // The date starts at Jan 1st 1970 and slowly adds up until we get the current year, date, and time.
        // If it is a leap year there are 366 days in a year. Otherwise, there are only 365.
        while (true) {
            if ((yearsSince1970 - 2) % 4 == 0 & daysSince1970 > 366) {
                daysSince1970 -= 366;
                yearsSince1970 += 1;
            }
            else if ((yearsSince1970 - 2) % 4 != 0 & daysSince1970 > 365) {
                daysSince1970 -= 365;
                yearsSince1970 += 1;
            }
            else if ((yearsSince1970 - 2) % 4 == 0 & daysSince1970 <= 366) {
                // We want to get the specific month and date now.
                currentDate[2] = 1970 + yearsSince1970;
                // Check which month
                if (1 <= daysSince1970 & daysSince1970 <= 31) {
                    currentDate[1] = 1;
                    currentDate[0] = (int) daysSince1970;
                    break;
                }
                else if (32 <= daysSince1970 & daysSince1970 <= 60) {
                    currentDate[1] = 2;
                    currentDate[0] = (int) (daysSince1970 - 30);
                    break;
                }
                else if (61 <= daysSince1970 & daysSince1970 <= 91) {
                    currentDate[1] = 3;
                    currentDate[0] = (int) (daysSince1970 - 59);
                    break;
                }
                else if (92 <= daysSince1970 & daysSince1970 <= 121) {
                    currentDate[1] = 4;
                    currentDate[0] = (int) (daysSince1970 - 90);
                    break;
                }
                else if (122 <= daysSince1970 & daysSince1970 <= 152) {
                    currentDate[1] = 5;
                    currentDate[0] = (int) (daysSince1970 - 120);
                    break;
                }
                else if (153 <= daysSince1970 & daysSince1970 <= 182) {
                    currentDate[1] = 6;
                    currentDate[0] = (int) (daysSince1970 - 151);
                    break;
                }
                else if (183 <= daysSince1970 & daysSince1970 <= 213) {
                    currentDate[1] = 7;
                    currentDate[0] = (int) (daysSince1970 - 181);
                    break;
                }
                else if (214 <= daysSince1970 & daysSince1970 <= 244) {
                    currentDate[1] = 8;
                    currentDate[0] = (int) (daysSince1970 - 212);
                    break;
                }
                else if (245 <= daysSince1970 & daysSince1970 <= 274) {
                    currentDate[1] = 9;
                    currentDate[0] = (int) (daysSince1970 - 243);
                    break;
                }
                else if (275 <= daysSince1970 & daysSince1970 <= 305) {
                    currentDate[1] = 10;
                    currentDate[0] = (int) (daysSince1970 - 273);
                    break;
                }
                else if (306 <= daysSince1970 & daysSince1970 <= 335) {
                    currentDate[1] = 11;
                    currentDate[0] = (int) (daysSince1970 - 304);
                    break;
                }
                else if (336 <= daysSince1970 & daysSince1970 <= 366) {
                    currentDate[1] = 12;
                    currentDate[0] = (int) (daysSince1970 - 334);
                    break;
                }
            }
            else if ((yearsSince1970 - 2) % 4 != 0 & daysSince1970 <= 365) {
                // We want to get the specific month and date now.
                // We want to get the specific month and date now.
                currentDate[2] = 1970 + yearsSince1970;
                // Check which month
                if (1 <= daysSince1970 & daysSince1970 <= 31) {
                    currentDate[1] = 1;
                    currentDate[0] = (int) daysSince1970;
                    break;
                }
                else if (32 <= daysSince1970 & daysSince1970 <= 59) {
                    currentDate[1] = 2;
                    currentDate[0] = (int) (daysSince1970 - 30);
                    break;
                }
                else if (60 <= daysSince1970 & daysSince1970 <= 90) {
                    currentDate[1] = 3;
                    currentDate[0] = (int) (daysSince1970 - 58);
                    break;
                }
                else if (91 <= daysSince1970 & daysSince1970 <= 120) {
                    currentDate[1] = 4;
                    currentDate[0] = (int) (daysSince1970 - 89);
                    break;
                }
                else if (121 <= daysSince1970 & daysSince1970 <= 151) {
                    currentDate[1] = 5;
                    currentDate[0] = (int) (daysSince1970 - 119);
                    break;
                }
                else if (152 <= daysSince1970 & daysSince1970 <= 181) {
                    currentDate[1] = 6;
                    currentDate[0] = (int) (daysSince1970 - 150);
                    break;
                }
                else if (182 <= daysSince1970 & daysSince1970 <= 212) {
                    currentDate[1] = 7;
                    currentDate[0] = (int) (daysSince1970 - 180);
                    break;
                }
                else if (213 <= daysSince1970 & daysSince1970 <= 243) {
                    currentDate[1] = 8;
                    currentDate[0] = (int) (daysSince1970 - 211);
                    break;
                }
                else if (244 <= daysSince1970 & daysSince1970 <= 273) {
                    currentDate[1] = 9;
                    currentDate[0] = (int) (daysSince1970 - 242);
                    break;
                }
                else if (274 <= daysSince1970 & daysSince1970 <= 304) {
                    currentDate[1] = 10;
                    currentDate[0] = (int) (daysSince1970 - 272);
                    break;
                }
                else if (305 <= daysSince1970 & daysSince1970 <= 334) {
                    currentDate[1] = 11;
                    currentDate[0] = (int) (daysSince1970 - 303);
                    break;
                }
                else if (335 <= daysSince1970 & daysSince1970 <= 365) {
                    currentDate[1] = 12;
                    currentDate[0] = (int) (daysSince1970 - 333);
                    break;
                }
            }
        }

        return currentDate;

    }

}

