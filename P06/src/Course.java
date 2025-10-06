import java.util.Objects;

public class Course {
   private String dept;
   private int number;
   
   public Course(String dept, int number){
    if(dept ==null || (dept.length()!=3 && dept.length()!=4))
    throw new InvalidCourseException(dept);
    if(number <1000 || number >9999)
    throw new InvalidCourseException(dept,number);
    this.dept=dept;
    this.number=number;
   }

   @Override
   public String toString(){
        return dept + " "+ number;
   }

   @Override
   public boolean equals(Object o){
    if(this == o) return true;
    if(o == null || o.getClass()!=getClass()) return false;
    Course c= (Course) o;
    return dept.equals(c.dept) && number==c.number;
   }

   @Override
   public int hashCode(){
    return Objects.hash(dept, number);
   }
    
}
