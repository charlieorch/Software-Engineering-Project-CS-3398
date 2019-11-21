package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import options.OptionsPageController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    @FXML
    public Button backButton;
    public Button loginButton;
    public Button createNewAccountButton;
    public TextField userNameField;
    public PasswordField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        passwordField.setFocusTraversable(false);
        userNameField.requestFocus();
    }

    public void createAccountButtonPress(ActionEvent actionEvent) throws IOException {
        Stage appStage = (Stage) loginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/createAccount/createAccountPage.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    public void loginBack(ActionEvent actionEvent) throws IOException {
        Stage appStage = (Stage) loginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    public static void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("login.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //printWriter.println(user);
        //printWriter.println(password);
        printWriter.close();
    }
}
