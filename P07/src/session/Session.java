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
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Session on ").append(course).append(" at ").append(dates).append('\n');
        sb.append(" Tutor: ").append(tutor).append('\n');
        sb.append(" Students: ");
        if (students.isEmpty()) sb.append("(none)");
        else {
            for (int i = 0; i < students.size(); ++i) {
                if (i > 0) sb.append(", ");
                sb.append(students.get(i));
            }
        }
        return sb.toString();
    }    
}