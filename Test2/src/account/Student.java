package account;

import com.jaunt.*;
import com.jaunt.component.Table;
import homePage.HomePageController;
import homePage.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import options.OptionsPageController;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.action.Action;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Student implements Serializable{
    public String firstName;
    public String lastName;
    public String id;
    public Schedule schedule;

    public static void createNewStudent(File file) throws ResponseException, IOException, NotFound {
        Main.student = new Student();
        Main.student.generateStudent(file);
        Main.student.saveStudentData();
        Main.student.startNotifications();
    }

    public void startNotifications(){
        Thread thread = new Thread(new Runnable() {
            private void postMessage(final String message) {
                Platform.runLater(() -> Notifications.create().title("Course Reminder").text(message).hideCloseButton().darkStyle().show());
            }
            @Override
            public void run() {
                while(Main.student != null){
                    if(OptionsPageController.NOTIFICATIONS != false) {
                        LocalTime now = LocalTime.now();
                        for(Course course: schedule.courses){

                            String start = course.startTime.split(" ")[0] + " " + course.startTime.split(" ")[1].toUpperCase();
                            if(start.split(":")[0].length() == 1)
                                start = "0" + start;

                            String end = course.endTime.split(" ")[0] + " " + course.endTime.split(" ")[1].toUpperCase();
                            if(end.split(":")[0].length() == 1)
                                end = "0" + end;

                            LocalTime classStart = LocalTime.parse(start, DateTimeFormatter.ofPattern("hh:mm a"));
                            LocalTime classEnd = LocalTime.parse(end, DateTimeFormatter.ofPattern("hh:mm a"));

                            if(now.isAfter(classStart) && now.isBefore(classEnd))
                                course.inSession = true;
                            else
                                course.inSession = false;

                            if(ChronoUnit.MINUTES.between(now, classStart) == OptionsPageController.TIMEBEFORECLASSSTART) {
                                postMessage("\n             " + course.name + " Starts In " + OptionsPageController.TIMEBEFORECLASSSTART + " Minutes!");
                                try { Thread.sleep(60000); } catch (InterruptedException e) { e.printStackTrace();}
                            }
                            else if(ChronoUnit.MINUTES.between(now, classEnd) == OptionsPageController.TIMEBEFORECLASSEND) {
                                postMessage("\n             " + course.name + " Ends In " + OptionsPageController.TIMEBEFORECLASSSTART + " Minutes!");
                                try { Thread.sleep(60000); } catch (InterruptedException e) { e.printStackTrace();}
                            }
                        }
                    }
                    try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
                }
            }
        });
        thread.start();
    }

    public void saveStudentData() throws IOException {
        FileOutputStream file = new FileOutputStream(firstName + "_" + lastName + ".ser");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(this);
        out.close();
        file.close();
    }

    public void generateStudent(File file) throws NotFound, IOException, ResponseException {
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
    }
}
