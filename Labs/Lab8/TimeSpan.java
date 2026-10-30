package Lab8;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        this.hours = 0;
        this.minutes = 0;
        add(hours, minutes);
    }

    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }
}
