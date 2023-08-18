// Justin Herzog 2022

import java.util.TimeZone;

public class JulianDate extends Date {

    public JulianDate() {

        super();

        JulianDate currentDate = getCurrentDate();

        this.setYear(currentDate.getYear());
        this.setMonth(currentDate.getMonth());
        this.setDay(currentDate.getDayOfMonth());

    }

    public JulianDate(int year, int month, int day) {

        super(year, month, day);

    }

    @Override
    public void addDays(int days) {

        while (days > 0) {

            this.setDay(this.getDayOfMonth() + 1);

            // Update the month and year if needed.
            switch (this.getMonth()) {
                case 1 : case 3 : case 5 : case 7 : case 8 : case 10:
                    if (this.getDayOfMonth() > 31) {
                        this.setMonth(this.getMonth() + 1);
                        this.setDay(1);
                    }
                    break;

                case 4 : case 6 : case 9 : case 11:
                    if (this.getDayOfMonth() > 30) {
                        this.setMonth(this.getMonth() + 1);
                        this.setDay(1);
                    }
                    break;

                case 2:
                    if (this.isLeapYear() & this.getDayOfMonth() > 29) {
                        this.setMonth(this.getMonth() + 1);
                        this.setDay(1);
                    }
                    else if (!this.isLeapYear() & this.getDayOfMonth() > 28) {
                        this.setMonth(this.getMonth() + 1);
                        this.setDay(1);
                    }
                    break;

                case 12:
                    if (this.getDayOfMonth() > 31) {
                        this.setYear(this.getYear() + 1);
                        this.setMonth(1);
                        this.setDay(1);
                    }
                    break;
            }

            days --;
        }

    }

    @Override
    public void subtractDays(int days) {

        while (days > 0) {

            // Update the month and year if needed.
            switch (this.getMonth()) {
                case 2 : case 4 : case 6 : case 8 : case 9 : case 11:
                    if (this.getDayOfMonth() == 1) {
                        this.setMonth(this.getMonth() - 1);
                        this.setDay(31);
                    }
                    else {
                        this.setDay(this.getDayOfMonth() - 1);
                    }
                    break;

                case 5 : case 7 : case 10 : case 12:
                    if (this.getDayOfMonth() == 1) {
                        this.setMonth(this.getMonth() - 1);
                        this.setDay(30);
                    }
                    else {
                        this.setDay(this.getDayOfMonth() - 1);
                    }
                    break;

                case 3:
                    if (this.isLeapYear() & this.getDayOfMonth() == 1) {
                        this.setMonth(this.getMonth() - 1);
                        this.setDay(29);
                    }
                    else if (!this.isLeapYear() & this.getDayOfMonth() == 1) {
                        this.setMonth(this.getMonth() - 1);
                        this.setDay(28);
                    }
                    else {
                        this.setDay(this.getDayOfMonth() - 1);
                    }
                    break;

                case 1:
                    if (this.getDayOfMonth() == 1) {
                        this.setYear(this.getYear() - 1);
                        this.setMonth(12);
                        this.setDay(31);
                    }
                    else {
                        this.setDay(this.getDayOfMonth() - 1);
                    }
                    break;

                default:
                    this.setDay(this.getDayOfMonth() - 1);
                    break;
            }
            days --;
        }

    }

    @Override
    public boolean isLeapYear() {

        return this.getYear() % 4 == 0;

    }


    private boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    public JulianDate getCurrentDate() {
        // This 'magic number' is the time between *Julian Calendar start date* and Jan 1st 1970
        int daysTo1970 = 719164;

        JulianDate return_date = new JulianDate(1, 1, 1);

        // Gets the number of days since 1970 then uses our built-in methods to get the current date.
        // Number of seconds since Jan 1st 1970, adjusted for the timezone.
        long daysSince1970 = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / (1000 * 86400);

        return_date.addDays((int) (daysSince1970 + daysTo1970));

        return return_date;

    }

}
