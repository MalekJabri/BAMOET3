package ${package}.model.rules;

public class ExecutionDuration {

    private long days = 0;
    private long hours = 0;
    private long minutes = 0;
    private long seconds = 0;
    private long milliseconds = 0L;

    public long getDays() {
        return this.days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public long getHours() {
        return this.hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public long getMinutes() {
        return this.minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public long getMilliseconds() {
        return this.milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public String toString() {
        return "days=" + days + ", hours=" + hours + ", minutes=" + minutes + ", seconds=" + seconds + ", milliseconds=" + milliseconds;
    }
}