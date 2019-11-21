package createAccount;

import account.Student;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import homePage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import options.OptionsPageController;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class createAccountController implements Initializable {

    public File studentScheduleFile;

    @FXML
    public Button backButton;
    public TextField userNameField;
    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public Button uploadScheduleButton;
    public Button createAccountButton;
    public Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        passwordField.setFocusTraversable(false);
        confirmPasswordField.setFocusTraversable(false);
        userNameField.requestFocus();
    }

    public void createAccountButtonPushed(ActionEvent actionEvent) throws IOException, NotFound, ResponseException {
        if(isInfoValid() == false){
            errorLabel.setText("Some Fields Are Missing Information*");
            return;
        }
        else if(isAvailable() == false){
            errorLabel.setText("User Name or Password is Already Taken*");
            return;
        }
        else if(!passwordField.getText().equals(confirmPasswordField.getText())) {
            errorLabel.setText("Passwords Do Not Match*");
            return;
        }
        else{
            Student.createNewStudent(studentScheduleFile);
            saveAccountInfo();
        }

        Stage appStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    public void saveAccountInfo() throws IOException {
        File file = new File("accounts.txt");
        PrintWriter printWriter = null;

        if (file.exists()) {
            printWriter = new PrintWriter(new FileOutputStream(new File("accounts.txt"), true));
        }
        else{
            printWriter = new PrintWriter("accounts.txt");
        }

        printWriter.append(userNameField.getText() + " " + passwordField.getText() + " " + Main.student.firstName + "_" + Main.student.lastName + "\n");
        printWriter.close();
    }

    public boolean isInfoValid() throws FileNotFoundException {
        if(userNameField.getText().equals("") || passwordField.getText().equals("") || studentScheduleFile == null)
            return false;

        return true;
    }

    public boolean isAvailable() throws FileNotFoundException {
        File file = new File("accounts.txt");
        if(file.exists() == false)
            return true;
        else{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String user = line.split(" ")[0];
                String pass = line.split(" ")[1];
                if(userNameField.getText().equals(user) || passwordField.getText().equals(pass)){
                    return false;
                }
            }
        }
        return true;
    }

    public void uploadScheduleButtonPushed(ActionEvent actionEvent) throws IOException {
        Stage appStage = (Stage) uploadScheduleButton.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Class Schedule File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML", "*.html"));
        File htmlFile = fileChooser.showOpenDialog(appStage);
        if(htmlFile == null)
            return;

        studentScheduleFile = htmlFile;
    }

    public void createAccountBack(ActionEvent actionEvent) throws IOException {
        Stage appStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }
}
