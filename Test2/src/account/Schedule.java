package account;

import java.io.Serializable;
import java.util.ArrayList;

public class Schedule implements Serializable {
    public int creditHours;
    public String semester;
    public int year;
    public ArrayList<Course> courses = new ArrayList<Course>();
}
