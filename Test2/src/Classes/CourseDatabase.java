package Classes;

import java.util.ArrayList;
import java.util.List;

public class CourseDatabase {
    /*
     * Stores all courses being offered
     */

    private List<Course> courseListing;

    public CourseDatabase() {
        courseListing = new ArrayList<Course>();
    }

    public void addNewCourse(Course c) {

        if(!this.courseExists(c))
            courseListing.add(c);
    }

    public void removeCourse(Course c) {
        int index = this.getCourseIndex(c);

        if(index != -1)
            courseListing.remove(index);
    }

    private int getCourseIndex(Course c) {
        int index = -1;

        for(int i = 0; i < courseListing.size(); i++) {
            if(courseListing.get(i).sameCourse(c))
                index = i;
        }

        return index;
    }

    public boolean courseExists(Course c) {

        for(Course e : courseListing) {
            if(e.sameCourse(c))
                return true;
        }

        return false;
    }

}
