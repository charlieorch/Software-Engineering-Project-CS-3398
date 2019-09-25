package homePage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomePageController implements Initializable {

    @FXML
    public Label loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void loginButtonPress(MouseEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) loginButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/login/login.fxml"));

        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void AcademicCalenderPress(MouseEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) loginButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/academicCalender/calender.fxml"));

        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void GPACalculatorPress(MouseEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) loginButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/GPA/GPA.fxml"));

        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

}
