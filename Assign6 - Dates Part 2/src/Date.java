// Justin Herzog 2022

public abstract class Date {

    private int year;
    private int month;
    private int day;

    protected Date() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    protected Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDayOfMonth() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public String getMonthName() {
        return switch (this.month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };

    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printShortDate() {
        System.out.printf("%d/%d/%d", this.month, this.day, this.year);
    }

    public void printLongDate() {
        System.out.printf("%s %d, %d", this.getMonthName(), this.day, this.year);
    }

    public abstract void addDays(int days);

    public abstract void subtractDays(int days);

    public abstract boolean isLeapYear();

}
