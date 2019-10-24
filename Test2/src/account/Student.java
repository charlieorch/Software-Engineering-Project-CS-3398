package account;

import com.jaunt.*;
import com.jaunt.component.Table;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
    public String firstName;
    public String lastName;
    public String id;
    public Schedule schedule;

    public Schedule generateStudent(File file) throws NotFound, IOException, ResponseException {
        UserAgent userAgent = new UserAgent();
        userAgent.open(file);
        Document doc = userAgent.doc;

        String[] header = doc.findFirst("<div class=staticheaders>").getChildText().split(" ");

        id = header[0].trim();
        firstName = header[1];
        lastName = header[2].split("\n")[0];

        schedule = new Schedule();

        schedule.semester = header[2].split("\n")[1];
        schedule.year = Integer.valueOf(header[3].split("\n")[0]);

        String hours = doc.findFirst("<div class=pagebodydiv>").getChildText().trim().substring(20).replaceAll(".000", "");
        schedule.creditHours = Integer.valueOf(hours);

        ArrayList<Course> courses = new ArrayList<Course>();

        Elements tables = doc.findEach("<table class=datadisplaytable>");

        for(int i=0; i<tables.size(); i+=2){
            Course course = new Course();
            Table table1 = new Table(tables.getElement(i));
            Table table2 = new Table(tables.getElement(i+1));
            String title[] = tables.getElement(i).getElement(0).getTextContent().split(" - ");

            course.name = title[0];
            course.subject = title[1].split(" ")[0];
            course.courseNumber = Integer.valueOf(title[1].split(" ")[1]);
            course.section = title[2];

            course.professor = table1.getCell(2,3).getTextContent().trim();
            course.credits = Integer.valueOf(table1.getCell(2,5).getTextContent().trim().replaceAll(".000", ""));
            course.campus = table1.getCell(2,7).getTextContent();

            course.startTime = table2.getCell(1,1).getTextContent().split(" - ")[0];
            course.endTime = table2.getCell(1,1).getTextContent().split(" - ")[1];
            course.days = table2.getCell(2,1).getTextContent();
            course.building = table2.getCell(3,1).getTextContent().split(" 00")[0];
            course.room = Integer.valueOf(table2.getCell(3,1).getTextContent().split(" 00")[1]);
            course.type = table2.getCell(5,1).getTextContent();
            course.professorEmail = table2.getCell(6,1).findFirst("<a href>").getAt("href").substring(7);
            courses.add(course);
        }
        schedule.courses = courses;
        return schedule;
    }


}
