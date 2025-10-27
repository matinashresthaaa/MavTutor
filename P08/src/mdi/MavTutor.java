package mdi;

import java.util.ArrayList;
import java.util.List;

import menu.Menu;
import menu.MenuItem;

import session.Course;
import session.Session;
import session.InvalidCourseException;

import people.Student;
import people.Tutor;


public class MavTutor {
    private Menu menu;
    private List <?> view;

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Tutor> tutors;
    private ArrayList<Session> sessions;

    public MavTutor(){
        courses =new ArrayList<>();
        students=new ArrayList<>();
        tutors=new ArrayList<>();
        sessions=new ArrayList<>();

    String title = "\nMAV TUTOR MENU\n";
    String prompt = "Selection? ";

    menu = new Menu(new Object[]{ title }, new Object[]{ "\n", prompt });

    menu.addMenuItem(new MenuItem("Create Course", new Runnable() {
        public void run() { newCourse(); }
    }));
    menu.addMenuItem(new MenuItem("Create Student", new Runnable() {
        public void run() { newStudent(); }
    }));
    menu.addMenuItem(new MenuItem("Create Tutor", new Runnable() {
        public void run() { newTutor(); }
    }));
    menu.addMenuItem(new MenuItem("Create Session", new Runnable() {
        public void run() { newSession(); }
    }));
    menu.addMenuItem(new MenuItem("View Courses", new Runnable() {
        public void run() { selectView(courses); }
    }));
    menu.addMenuItem(new MenuItem("View Students", new Runnable() {
        public void run() { selectView(students); }
    }));
    menu.addMenuItem(new MenuItem("View Tutors", new Runnable() {
        public void run() { selectView(tutors); }
    }));
    menu.addMenuItem(new MenuItem("View Sessions", new Runnable() {
        public void run() { selectView(sessions); }
    }));
    menu.addMenuItem(new MenuItem("Quit", new Runnable() {
        public void run() { quit(); }
    }));
        
    menu.run();

    }

    public static void main(String[] args){
        new MavTutor();   
    }

    private void quit(){
        menu.result=null;
    }

    private void newCourse(){
        String dept= Menu.getString("Department: ");
        int num= Menu.getInt("Course number: ");

        try{
            Course c= new Course(dept,num);
            if(courses.indexOf(c)<0){
                courses.add(c);
                menu.result.append("\nCourse added: "+c);   
            }
            else{
            menu.result.append("\nCourse exists: "+c);  
        }
    }
    catch(InvalidCourseException e){
        menu.result.append("\nInvalid Course: "+e.getMessage());   
    }
}

    private void newTutor(){
        if(courses.isEmpty()){
            menu.result= new StringBuilder("\n Error. No course exists");
        }

        String name=Menu.getString("Name: ");
        String email= Menu.getString("Email: ");
        String bio =Menu.getString("Bio: ");
        int ssn= Menu.getInt("SSN: ");

        Integer index=Menu.selectItemFromList("\n Selectt course index: ",courses);
        if(index ==null || index<0 || index >=courses.size()){
            menu.result=new StringBuilder("\n Invalid Selection");
            return;
        }

        Course course=courses.get(index);

        Tutor t= new Tutor(name,email,ssn,bio,course);
        if(tutors.indexOf(t)<0){
            tutors.add(t);
            menu.result=new StringBuilder("\n Tutor added: "+t);
        }
        else{
            menu.result=new StringBuilder("\n Tutor already exists: "+t);
        }


    }
    
    private void newStudent(){

    }

    private void newSession(){

    }

    private void selectView(List <?> list){
        this.view=list;
        menu.result.append(this.toString());
    }

    @Override
public String toString() {
    if(view==null)
        return "";

    String title;

    if (view == courses) {
        title = "Courses\n";
    } else if (view == students) {
        title = "Students\n";
    } else if (view == tutors) {
        title = "Tutors\n";
    } else if (view == sessions) {
        title = "Sessions\n";
    } else {
        title= "No view selected\n";
    }

    return Menu.listToString(title, view,'•');
}

}
