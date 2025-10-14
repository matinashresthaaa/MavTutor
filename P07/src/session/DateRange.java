package session;

public class DateRange{
    private String date;
    private String startTime;
    private String endTime;

    public DateRange(String date, String startTime, String endTime){
        if(date ==null || date.isEmpty() || startTime==null || startTime.isEmpty() || endTime==null || endTime.isEmpty())        
        throw new IllegalArgumentException("null entry");
        this.date=date;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public DateRange(String date, String startTime, long duration){
    if(date ==null || date.isEmpty() || startTime==null || startTime.isEmpty() || duration<=0)        
    throw new IllegalArgumentException("null entry");
    this.date=date;
    this.startTime=startTime;
    this.endTime=add(startTime,duration);
    }

    public long duration(){
        return toMinutes(endTime)-toMinutes(startTime);
    }

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