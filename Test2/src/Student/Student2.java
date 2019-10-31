package Student;

import Classes.*;
import java.util.List;
import java.util.ArrayList;

public class Student2 {

    /*
        Student id, unique to each student
     */
    private int studentId;
    String studentName = "Josh Peck";

    /*
     * List for currently active courses
     */
    List<OpenCourse> courseList;

    /*
     *  List for completed courses, might not be used
     */
    //List<Course> completedCourses;

    public Student2(int studentId) {
        this(studentId, "");
    }

    public Student2(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        courseList = new ArrayList<OpenCourse>();
    }

    public void nameChange(String newName) {
        this.studentName = newName;
    }

    public void addCourse(OpenCourse c) {
        courseList.add(c);
    }

    public int checkId() {
        return studentId;
    }


}
