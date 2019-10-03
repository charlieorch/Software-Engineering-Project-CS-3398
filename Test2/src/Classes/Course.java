package Classes;

public class Course {

    /*
     * Identifier for the course offered in specific department
     * The numerical value in course abbreviation (3398)
     */
    protected int courseDeptId;

    /*
     * Full course name (Software Engineering)
     */
    protected String courseName;

    /*
     *  Abbreviation of department offering course (CS, MATH)
     */
    protected String courseDept;

    /*
     * Brief decription of course.
     */
    protected String courseDescription;

    public Course() {
        super();
    }

    public Course(String courseDept, int courseDeptId) {
        this(courseDept, courseDeptId, "" , "");
    }

    public Course(String courseDept, int courseDeptId, String courseName, String courseDescription) {
        this.courseDept = courseDept;
        this.courseDeptId = courseDeptId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    public void changeCourseName (String courseName) {
        this.courseName = courseName;
    }

    public void addDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseDeptId() {
        return courseDeptId;
    }

    public String getCourseDept() {
        return courseDept;
    }

    /*
     * Checks to see if deptName and deptId are the same = it's the same course
     * true if the same course, false if not
     */
    public boolean sameCourse(Course c) {
        if(this.courseDept.equals(c.getCourseDept()) && this.courseDeptId == c.courseDeptId)
            return true;

        return false;
    }
}
