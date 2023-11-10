package Logic;

import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;

public class TimeUnite {


    private long startTime;
    private long Time;
    private boolean isRunning;

    public TimeUnite() {
            startTime = 0;
            Time = 0;
            isRunning = false;
    }

    public void start() {
        startTime = System.currentTimeMillis();
        isRunning = true;
    }

    public void stop() {
        if (isRunning) {
            Time += System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }

    public void reset() {
        Time = 0;
        isRunning = false;
    }

    public long getElapsedTime() {

        if (isRunning) {
            return (Time +System.currentTimeMillis() - startTime) ;
        }
        return Time;
    }

    public long getElapsedTime(TimeUnit unit) {
        long elapsed = getElapsedTime();
        return unit.convert(elapsed, TimeUnit.MILLISECONDS);
    }

}
