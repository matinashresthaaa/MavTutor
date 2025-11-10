package mdi;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

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
    private File file;

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Tutor> tutors;
    private ArrayList<Session> sessions;

    public MavTutor(){

        courses =new ArrayList<>();
        students=new ArrayList<>();
        tutors=new ArrayList<>();
        sessions=new ArrayList<>();
        file=null;

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

 menu.addMenuItem(new MenuItem("Review a Student", new Runnable(){ 
    public void run(){ review(students); }
    }));
    menu.addMenuItem(new MenuItem("Review a Tutor",   new Runnable(){ 
        public void run(){ review(tutors); }
    }));
    menu.addMenuItem(new MenuItem("Review a Session", new Runnable(){ 
        public void run(){ review(sessions); }
    }));

    menu.addMenuItem(new MenuItem("Quit", new Runnable() {
        public void run() { quit(); }
    }));

    menu.addMenuItem(new MenuItem("New MavTutor", new Runnable() {
    public void run() { newz(); }
    }));
    menu.addMenuItem(new MenuItem("Save As...", new Runnable() {
    public void run() { saveAs(); }
    }));
    menu.addMenuItem(new MenuItem("Save", new Runnable() {
    public void run() { save(); }
    }));
    menu.addMenuItem(new MenuItem("Open...", new Runnable() {
    public void run() { open(); }
    }));
        
    menu.run();
    }

    public static void main(String[] args){
        new MavTutor();   
    }

    private void newz(){

        courses.clear();
        students.clear();
        tutors.clear();
        sessions.clear();
        file=null;

        menu.result= new StringBuilder("\n All data erased. New MavTutor can be created.");
    }

    private void save(){
    if (file == null) {
        file = Menu.selectFile("\n Select a file", null, null);
    }
    if (file == null) {
        menu.result.append("\n No file selected");
        return;
    }
    try (PrintStream out = new PrintStream(file)) {
        out.println(courses.size());
        for (Course c : courses) {
            c.save(out);
        }

        out.println(students.size());
        for (Student s : students) {
            s.save(out);
        }

        out.println(tutors.size());
        for (Tutor t : tutors) {
            t.save(out);
        }

        out.println(sessions.size());
        for (Session sess : sessions) {
            sess.save(out);
        }

        menu.result.append("\n Data saved successfully to ").append(file.getName());
    } catch (Exception e) {
        menu.result.append("\n Error saving data: ").append(e.getMessage());
    }
}

    private void saveAs(){
        file=null;
        save();

    }

 private void open() {
    file = Menu.selectFile("\nSelect a file to open", null, null);
    if (file == null) {
        menu.result.append("\nNo file selected.");
        return;
    }

    try (Scanner in = new Scanner(file)) {
        ArrayList<Course> newCourses = new ArrayList<>();
        ArrayList<Student> newStudents = new ArrayList<>();
        ArrayList<Tutor> newTutors = new ArrayList<>();
        ArrayList<Session> newSessions = new ArrayList<>();

        int n;

        n = Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < n; ++i) newCourses.add(new Course(in));

        n = Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < n; ++i) newStudents.add(new Student(in));

        n = Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < n; ++i) newTutors.add(new Tutor(in));

        n = Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < n; ++i) newSessions.add(new Session(in));

        courses = newCourses;
        students = newStudents;
        tutors = newTutors;
        sessions = newSessions;

        menu.result.append("\nData loaded successfully from ").append(file.getName());
    } catch (Exception e) {
        menu.result.append("\nError opening file: ").append(e.getMessage());
        newz();
    }
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
            return;
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
    if (courses.isEmpty()){
        menu.result = new StringBuilder("\n Error. No course exists");
        return;
    }

    String name  = Menu.getString("Name: ");
    String email = Menu.getString("Email: ");
    Student s = new Student(name, email);

    String sel = Menu.getString("\n Select course index (Enter to finish): ");
    int safety = 0;
    while (sel != null && !sel.isEmpty()) {
        try {
            int idx = Integer.parseInt(sel.trim());
            if (idx >= 0 && idx < courses.size()) s.addCourse(courses.get(idx));
            else menu.result = new StringBuilder("\nInvalid Selection");
        } catch (NumberFormatException e) {
            menu.result = new StringBuilder("\nInvalid Selection");
        }
        if (s.getCourses().length >= courses.size()) break;
        if (++safety > 1000) break;
        sel = Menu.getString("\n Select another course index (Enter to finish): ");
    }

    if (students.indexOf(s) < 0) {
        students.add(s);
        menu.result = new StringBuilder("\nStudent added: " + s);
    } else {
        menu.result = new StringBuilder("\nStudent already exists: " + s);
    }
}

    private void newSession() {
    try {
        if (courses.isEmpty()) {
            menu.result.append("Please define a course first!");
            return;
        }
        if (tutors.isEmpty()) {
            menu.result.append("Please define a tutor first!");
            return;
        }
        if (students.isEmpty()) {
            menu.result.append("Please define a student first!");
            return;
        }
        Integer i1 = Menu.selectItemFromList("Select course: ", courses);
        if (i1 == null) return;
        Course course = courses.get(i1);

        Integer i2 = Menu.selectItemFromList("Select tutor: ", tutors);
        if (i2 == null) return;
        Tutor tutor = tutors.get(i2);

        if (!tutor.getCourse().equals(course)) {
            menu.result.append("Error adding Session: " + tutor + " lacks expertise in " + course);
            return;
        }

        Session session = new Session(course, tutor);
        session.setSchedule(
            Menu.getString("Enter date (YYYY-MM-DD): "),
            Menu.getString("Enter starting time (HH:mm): "),
            Menu.getInt("Enter duration in minutes: ")
        );

        Integer index = null;
        int studentsAdded = 0;
        do {
            index = Menu.selectItemFromList("Select student to add: ", students);
            if (index != null) session.addStudent(students.get(index));
        } while (index != null && students.size() > ++studentsAdded);

        sessions.add(session);
        menu.result.append("Added " + session);
    } catch (Exception e) {
        menu.result.append("Error adding Session: " + e.getMessage());
    }
    selectView(sessions);
}

    private void selectView(List <?> list){
        this.view=list;
        menu.result.append(this.toString());
    }

    @Override
public String toString() {

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

private Person login(){
    String [] options =new String[]{"Tutor","Student","None"};
    Integer choice=Menu.selectItemFromArray("Login as: ",options);
    if (choice == null) return null;

    if (choice == 0) {
        if (tutors.isEmpty()) return null;
        Integer i = Menu.selectItemFromList("Select tutor: ", tutors);
        return (i == null) ? null : tutors.get(i);
    } else if (choice == 1) {
        if (students.isEmpty()) return null;
        Integer i = Menu.selectItemFromList("Select student: ", students);
        return (i == null) ? null : students.get(i);
    } else {
        return null;

}
}
private void review(List<? extends Rateable> list){

}

}