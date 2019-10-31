package account;

import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import homePage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import options.OptionsPageController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountPageController implements Initializable {

    @FXML
    public Label titleLabel;
    public VBox vBoxMain1;
    public VBox vBoxMain2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Main.student != null)
            titleLabel.setText("Student: " + Main.student.firstName + " " + Main.student.lastName);
        else
            titleLabel.setText("No User");

        String cssLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: solid;\n";

        vBoxMain1.setSpacing(30);
        //vBoxMain1.setStyle(cssLayout);
        vBoxMain2.setSpacing(30);
        //vBoxMain2.setStyle(cssLayout);

        int i = 0;
        for(Course course: Main.student.schedule.courses) {

            VBox vBox = new VBox();
            vBox.setStyle(cssLayout);

            vBox.getChildren().add(new Label("Course: " + course.name + " - " + course.courseNumber));
            vBox.getChildren().add(new Label("Type: " + course.type));
            vBox.getChildren().add(new Label("Subject: " + course.subject));
            vBox.getChildren().add(new Label("Section: " + course.section));
            vBox.getChildren().add(new Label("Professor: " + course.professor));
            vBox.getChildren().add(new Label("Professor Email: " + course.professorEmail));
            vBox.getChildren().add(new Label("Building: " + course.building + " " + course.room));
            vBox.getChildren().add(new Label("Time: " + course.startTime + " - " + course.endTime));

            if(i<=2)
                vBoxMain1.getChildren().add(vBox);
            else
                vBoxMain2.getChildren().add(vBox);
            i++;
        }
    }

    @FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        Main.student = null;
        accountBack(new ActionEvent());
    }

    public void accountBack(ActionEvent actionEvent) throws IOException {
        Stage appStage = (Stage) titleLabel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene = new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }
}
