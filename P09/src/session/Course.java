
package session;

import java.util.Objects;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Create a course with department code and course number.
 * @author Matina Shree Shrestha
 * @version 1.0
 * @since 1.0
 * @license.agreement Gnu General Public License 3.0
 */

public class Course {
   private String dept;
   private int number;

   /**
    * Creates a new object 
    * @param dept the department code
    * @param number the course number
    * @throws InvalidCourseException if dept code or course number is invalid.
    */
   
   public Course(String dept, int number){
    if(dept ==null || (dept.length()!=3 && dept.length()!=4))
    throw new InvalidCourseException(dept);
    if(number <1000 || number >9999)
    throw new InvalidCourseException(dept,number);
    this.dept=dept;
    this.number=number;
   }

   public Course(Scanner in){
    this.dept=in.nextLine();
    this.number=in.nextInt();
   }

   public void save(PrintStream out){
    out.println(dept);
    out.println(number);
   }

   /**
    * returns the string version of course
    @return department name and number
    */

   @Override
   public String toString(){
        return dept + " "+ number;
   }
   
   /**
    * Checks if this course is equal to another course
    *@param o the object to compare
    *@return true if the dept and number match
    */

   @Override
   public boolean equals(Object o){
    if(this == o) return true;
    if(o == null || o.getClass()!=getClass()) return false;
    Course c= (Course) o;
    return dept.equals(c.dept) && number==c.number;
   }

   /**
    * returns the hash code for the course
    *@return hash value based on dept and number 
    */

   @Override
   public int hashCode(){
    return Objects.hash(dept, number);
   }
    
}
