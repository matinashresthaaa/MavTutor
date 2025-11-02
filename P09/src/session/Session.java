package session;

import java.util.ArrayList;
import java.util.List;

import people.Tutor;
import people.Student;

/**
 * Stores information about the tutoring session which includes the course, tutor, schedule and list of students.
 * @author Matina Shree Shrestha
 * @version 1.0
 * @since 1.0
 * @license.agreement Gnu General Public License 3.0
 */

public class Session {
    private Course course;
    private DateRange dates;
    private Tutor tutor;
    private List <Student> students= new ArrayList<>();

    /**
     * Creates a new session for the course
     * @param course  name of course which is being taught
     * @param tutor  name of the tutor
     */

    public Session(Course course, Tutor tutor){
        this.course=course;
        this.tutor=tutor;
    }

    /**
     * Sets the date, start time and duration of the tutoring session
     * @param dates  date of the session
     * @param startTime  starting time of the session
     * @param duration  duration of the session in minutes
     */

    public void setSchedule(String dates, String startTime, long duration){
        this.dates=new DateRange(dates,startTime,duration);
    }

    /**
     * Adds student to the session
     * @param student name of the student who is attending the session
     */
    public void addStudent(Student student){
        students.add(student);
    }

    /**
     * returns the course, schedule,tutor and list of students attending the tutoring session
     * @return description of the session 
     */
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Session on ").append(course).append(" at ").append(dates).append('\n');
        sb.append(" Tutor: ").append(tutor).append('\n');
        sb.append(" Students: ");
        if (students.isEmpty()) sb.append("(none)");
        else {
            sb.append("\n");
            for (int i = 0; i < students.size(); ++i) {
                if (i > 0) sb.append(", ");
                sb.append(students.get(i));
            }
        }
        sb.append("\n");
        return sb.toString();
    }    
}

