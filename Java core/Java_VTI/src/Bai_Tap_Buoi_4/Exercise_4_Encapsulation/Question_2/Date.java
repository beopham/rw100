package Bai_Tap_Buoi_4.Exercise_4_Encapsulation.Question_2;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    public void setDay(int day) { this.day = day; }
    public void setMonth(int month) { this.month = month; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        // Định dạng lại ngày/tháng có 2 chữ số (ví dụ: 01/05/2026)
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}