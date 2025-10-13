package session;
import java.util.ArrayList;
import java.util.List;

import people.Tutor;
import people.Student;

public class Session {
    private Course course;
    private DateRange dates;
    private Tutor tutor;
    private List <Student> students= new ArrayList<>();

    public Session(Course course, Tutor tutor){
        this.course=course;
        this.tutor=tutor;
    }

    public void setSchedule(String date, String startTime, long duration){
        this.dates=new DateRange(date,startTime,duration);
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
