package Classes;

public class OpenCourse extends Course{

    /*
     * -- Needs a currently offered course in order to open an active course --
     * For courses currently being offered
     * Each one contains the following:
     * Professor, class time, room number, section number
     */

    /*
     * The class section
     */
    private int sectionNumber;

    /*
     * Recall number
     * Unique identifier for open active courses
     */
    private String recallNum;

    String professorName;
    String classTime;
    String roomNum;


    public OpenCourse(Course c, int section) {
        this(c, section, "", "", "");
    }

    public OpenCourse(Course c, int section, String professor, String classTime, String roomNum) {
        this.courseDeptId = c.courseDeptId;
        this.courseDept = c.courseDept;
        this.courseName = c.courseName;
        this.courseDescription = c.courseDescription;

        this.professorName = professor;
        this.classTime = classTime;
        this.roomNum = roomNum;

    }

    public void setClassInformation(String professorName, String classTime, String roomNum) {
        this.professorName = professorName;
        this.classTime = classTime;
        this.roomNum = roomNum;
    }

}
