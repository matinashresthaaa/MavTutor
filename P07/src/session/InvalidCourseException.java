package session;

/**Execption is thrown for invalid course information i.e. number, department name.
 * @author Matina Shree Shrestha
 * @version 1.0
 * @since 1.0
 * @license.agreement Gnu General Public License 3.0
 */

public class InvalidCourseException extends IllegalArgumentException {
    /**
     * creates an exception when department name is invalid
     * @param dept invalid dept name
     * @throws InvalidCourseException when the departmemnt code is not 3-4 letters.
     */

    public InvalidCourseException(String dept){
        super("Invalid dept in new Course: "+dept);
    }

    /**
     * creates an exception when number is invalid
     * @param dept the department name
     * @param number invalid course number
     * @throws InvalidCourseException when the course number is not 1000-9999
     * 
     */
    public InvalidCourseException(String dept, int number){
        super("Invalid course number in new Course: "+number);
    }     
}