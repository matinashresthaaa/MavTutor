import java.util.ArrayList;

public class Student extends Person{
    private static int nextStudentID;
    private int studentID;
    private ArrayList<Course> courses;

    public Student(String name,String email){
        super(name,email);
        this.studentID=nextStudentID++;
        this.courses= new ArrayList<>();
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void getCourses(){
        return courses.toArray(new Course[0]);
    }

