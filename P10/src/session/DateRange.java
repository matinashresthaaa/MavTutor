package session;

import java.io.PrintStream;
import java.util.Scanner;
/**
 * Stores date, start time and end time for a tutoring session using 24 hour time.
 * @author Matina Shree Shrestha
 * @version 1.0
 * @since 1.0
 * @license.agreement Gnu General Public License 3.0
 */

public class DateRange{
    private String date;
    private String startTime;
    private String endTime;

/**
     * Creates a DateRange with a given start and end time.
     * @param date  the date of session
     * @param startTime  the starting time of session
     * @param endTime   the ending time of the session
     * @throws IllegalArgumentException if any argument is null
     */
    public DateRange(String date, String startTime, String endTime){
        if(date ==null || date.isEmpty() || startTime==null || startTime.isEmpty() || endTime==null || endTime.isEmpty())        
        throw new IllegalArgumentException("null entry");
        this.date=date;
        this.startTime=startTime;
        this.endTime=endTime;
    }
 /**
     * Creates DateRange using start time and duration in minutes
     * @param date  the date of session
     * @param startTime   the starting time of session
     * @param duration  duration of the session in minutes
     * @throws IllegalArgumentException if any argument is null
*/
    public DateRange(String date, String startTime, long duration){
    if(date ==null || date.isEmpty() || startTime==null || startTime.isEmpty() || duration<=0)        
    throw new IllegalArgumentException("null entry");
    this.date=date;
    this.startTime=startTime;
    this.endTime=add(startTime,duration);
    }

    public DateRange(Scanner in){
        this.date=in.nextLine();
        this.startTime=in.nextLine();
        this.endTime=in.nextLine();
    }

    public void save(PrintStream out){
        out.println(date);
        out.println(startTime);
        out.println(endTime);
    }
 /**
     *  calculates the minutes between start and end time.
     * @return duration in minutes
     */
    public long duration(){
        return toMinutes(endTime)-toMinutes(startTime);
    }
    
    /**
     * shows the date and time
     * @return string with date, start time, end time and duration of th session
     */

    @Override
    public String toString(){
        return date + " " + startTime + " - " + endTime + " (" + duration() + " minutes)";
    }

    
private static long toMinutes(String time) {
    int colon = time.indexOf(':');
    long hours = Long.parseLong(time.substring(0, colon));
    long minutes = Long.parseLong(time.substring(colon + 1));
    return hours * 60 + minutes;
}


private static String add(String time, long addMinutes) {
    long total = toMinutes(time) + addMinutes;
    long hours = (total / 60) % 24;
    long minutes = total % 60;
    return (hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes;
}
}