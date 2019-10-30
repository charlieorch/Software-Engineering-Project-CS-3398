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
import javafx.stage.Stage;
import options.OptionsPageController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountPageController implements Initializable {

    @FXML
    public Label titleLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Main.student != null)
            titleLabel.setText("Student: " + Main.student.firstName + " " + Main.student.lastName + " ID: "
                + Main.student.id + " Hours: " + Main.student.schedule.creditHours);
        else
            titleLabel.setText("No User");
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

    public static void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("account.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //printWriter.println(name);
        //printWriter.println(ID);
        //printWriter.println(hours);
        //printWriter.println(major);
        //printWriter.println(minor);
        //printWriter.println(classes);
        printWriter.close();
    }
}
