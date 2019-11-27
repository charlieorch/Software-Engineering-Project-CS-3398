package resources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import options.OptionsPageController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResourcePage implements Initializable {

    @FXML
    public ComboBox comboBox;
    public Button backButton;
    public TextArea textArea00;
    public TextArea textArea01;
    public TextArea textArea10;
    public TextArea textArea11;
    public TextArea textArea02;
    public TextArea textArea12;
    public TextArea textArea03;
    public TextArea textArea13;
    public TextArea textArea04;
    public TextArea textArea14;
    public TextArea textArea05;
    public TextArea textArea15;
    public TextArea textArea06;
    public TextArea textArea16;
    public TextArea textArea07;
    public TextArea textArea17;
    public TextArea textArea08;
    public TextArea textArea18;
    public TextArea textArea09;
    public TextArea textArea19;
    public GridPane gridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().addAll("Advising", "Campus Resources", "Emergency Services", "Future Students");
    }


    @FXML
    public void comboBoxSelect(ActionEvent actionEvent) throws IOException {
        String option = (String)comboBox.getValue();

        clearText();

        switch(option) {

            case "Advising" :
                advisingTextFill();
                break;
            case "Campus Resources" :
                campusTextFill();
                break;
            case "Emergency Services" :
                emergencyServiceTextFill();
                break;
            case "Future Students" :
                futureStudentsTextFill();
                break;
            default:
                textArea00.setText("No option selected.");
        }
    }

    private void advisingTextFill() {
        textArea00.setText("University College Advising Center");
        textArea10.setText("Location: UAC 120\nPhone: 512.245.2218");

        textArea01.setText("PACE Academic Advising");
        textArea11.setText("Location: UAC First Floor\nPhone: 512.245.7223");

        textArea02.setText("College of Applied Arts");
        textArea12.setText("Location: AG 201\nPhone: 512.245.1490");

        textArea03.setText("McCoy College of Business Administration");
        textArea13.setText("Location: MCOY 115\nPhone: 512.245.1993");

        textArea04.setText("College of Education");
        textArea14.setText("Location: ED 2143\nPhone: 512.245.3050");

        textArea05.setText("College of Fine Arts and Communication");
        textArea15.setText("Location: OM 110\nPhone: 512.245.1932");

        textArea06.setText("College of Health Professions");
        textArea16.setText("Location: ENC 207\nPhone: 512.245.3506");

        textArea07.setText("College of Liberal Arts");
        textArea17.setText("Location: FH 322\nPhone: 512.245.1852");

        textArea08.setText("Round Rock Campus");
        textArea18.setText("Location: Avery 201\nPhone: 512.716.4001");

        textArea09.setText("College of Science and Engineering");
        textArea19.setText("Location: CENT 202\nPhone: 512.245.1315");
    }

    private void campusTextFill() {
        textArea00.setText("Financial Aid and Scholarships");
        textArea10.setText("Location: J. C. Kellam, Suite 240\n" +
                "601 University Dr.\n" +
                "San Marcos, TX 78666 \nPhone: 512.245.2315 ");

        textArea01.setText("Student Business Services");
        textArea11.setText("Location: J.C. Kellam Room 188\n" +
                "601 University Drive\n" +
                "San Marcos, Texas 78666 \nPhone: 512-245-2544");

        textArea02.setText("Student Diversity and Inclusion");
        textArea12.setText("Location: 700 Student Center Drive \n" +
                "LBJ Student Center, Suite 5-2.1 \nPhone: 512.245.2278");

        textArea03.setText("Career Services");
        textArea13.setText("Location: LBJ Student Center\n" +
                "Suite 5-7.1\n" +
                "601 University Drive\n" +
                "San Marcos, TX 78666 \nPhone: 512.245.2645");

        textArea04.setText("Dean of Students Office");
        textArea14.setText("Location: LBJ Student Center, Suite 5-9.1\n" +
                "601 University Drive\n" +
                "San Marcos, Texas 78666-4684 \nPhone: 512.245.2124 ");

    }

    private void emergencyServiceTextFill() {
        textArea00.setText("Student Health Center");
        textArea10.setText("Location: 298 Student Center Drive\n" +
                "San Marcos, TX 78666\nPhone: 512.245.2161");

        textArea01.setText("Student Health Center - Thorpe Lane");
        textArea11.setText("Location: 1347 Thorpe Lane\n" +
                "San Marcos, TX 78666\nPhone: 512.245.2161");

        textArea02.setText("Student Health Center - Round Rock");
        textArea12.setText("Location: Nursing Building #116\n" +
                "1555 University Blvd.\n" +
                "Round Rock, TX 78665\nPhone: 512.245.2161");

        textArea03.setText("University Police Department");
        textArea13.setText("Nueces Building\n" +
                "615 North L.B.J. Drive\n" +
                "San Marcos, Texas 78666\n" +
                "Phone: 512.245.8336\nNonemergency: 512.245.2805\n" +
                "Records: 512.245.2890 ");

        textArea04.setText("Bobcat Bobbies");
        textArea14.setText("Nueces Building\n" +
                "615 North L.B.J. Drive\n" +
                "San Marcos, Texas 78666\n" +
                "Phone: 512.245.7233");
    }

    private void futureStudentsTextFill() {
        textArea00.setText("Undergraduate Admissions");
        textArea10.setText("Location: Richard A. Castro Undergraduate Admissions Center\n" +
                "429 N. Guadalupe Street\n" +
                "San Marcos, TX 78666\nPhone: 512.245.2364");

        textArea01.setText("Graduate College");
        textArea11.setText("Location: JC Kellam 280\n" +
                "601 University Drive\n" +
                "San Marcos, TX 78666-4684\nPhone: 512.245.2581");
    }

    private void clearText() {

        textArea00.clear();
        textArea01.clear();
        textArea10.clear();
        textArea11.clear();
        textArea02.clear();
        textArea12.clear();
        textArea03.clear();
        textArea13.clear();
        textArea04.clear();
        textArea14.clear();
        textArea05.clear();
        textArea15.clear();
        textArea06.clear();
        textArea16.clear();
        textArea07.clear();
        textArea17.clear();
        textArea08.clear();
        textArea18.clear();
        textArea09.clear();
        textArea19.clear();
    }


    @FXML
    public void pageBack(ActionEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void AcademicCalenderPress(MouseEvent actionEvent) throws IOException {
        Stage appStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/academicCalender/calender.fxml"));

        Scene scene = new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void SchoolMapPress(MouseEvent actionEvent) throws IOException {
        Stage appStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/map.fxml"));

        Scene scene = new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }
}