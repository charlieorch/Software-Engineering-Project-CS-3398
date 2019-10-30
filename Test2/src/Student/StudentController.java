package Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import options.OptionsPageController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentController {

    @FXML
    public Button backButton;

    public void studentBack(ActionEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    public static void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("student.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //printWriter.println(ID);
        //printWriter.println(courses);
        printWriter.close();
    }
}
