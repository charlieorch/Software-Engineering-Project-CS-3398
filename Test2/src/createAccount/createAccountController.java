package createAccount;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class createAccountController implements Initializable {

    @FXML
    public Button backButton;
    public TextField userNameField;
    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public Button uploadScheduleButton;
    public Button createAccountButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        passwordField.setFocusTraversable(false);
        confirmPasswordField.setFocusTraversable(false);
        userNameField.requestFocus();
    }

    public void createAccountBack(ActionEvent actionEvent) throws IOException {
        Stage appStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }
}
