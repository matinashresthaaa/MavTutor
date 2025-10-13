package session;

public class DataRange{
    private String date;
    private String startTime;
    private String endTime;

    public DataRange(String date, String startTime, string endTime){
        if(date ==null || date.isEmpty() || startTime==null || startTime.isEmpty() || endTime==null || endTime.isEmpty())        
        throw new IllegalArgumentException("null entry");
        this.date=date;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public DataRange(String date, String startTime, long duration){
    if(data ==null || date.isEmpty() || startTime==null || startTime.isEmpty() || duration<=0)        
    throw new IllegalArgumentException("null entry");
    this.date=date;
    this.startTime=startTime;
    this.endTime=add(startTime,duration);
    }


    

    


}
