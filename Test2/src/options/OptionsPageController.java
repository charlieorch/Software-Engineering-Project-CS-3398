package options;

import homePage.Main;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class OptionsPageController implements Initializable {

    public static double PREF_WITH = 900;
    public static double PREF_HEIGHT = 600;
    public static boolean FULLSCREEN = false;
    public static boolean NOTIFICATIONS = true;
    public static boolean KEEPMELOGGEDIN = true;
    public static int TIMEBEFORECLASSSTART = 30;
    public static int TIMEBEFORECLASSEND = 10;
    public static boolean PLAYNOTIFICATIONSOUND = true;

    public double defaultPrefWith = 900;
    public double defaultPrefHeight = 600;
    public boolean defaultFullscreen = false;
    public boolean defaultNotifications = true;
    public boolean defaultKeepMeLoggedIn = true;
    public int defaultTimeBeforeClassStart = 30;
    public int defaultTimeBeforeClassEnd = 10;
    public boolean defaultPlayNotificationSound = true;

    @FXML
    public Button backButton;
    public Button saveButton;
    public ChoiceBox<String> choiceBoxFullscreen;
    public ChoiceBox<String> choiceBoxNotifications;
    public TextField beforeStartField;
    public TextField beforeEndField;
    public Label beforeStartLabel;
    public Label beforeEndLabel;
    public ChoiceBox<String> choiceBoxKeepMeLoggedIn;
    public Label notificationSoundLabel;
    public ChoiceBox<String> choiceBoxNotificationSound;

    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxFullscreen.getItems().addAll("Yes","No");
        if(FULLSCREEN)
            choiceBoxFullscreen.setValue("Yes");
        else
            choiceBoxFullscreen.setValue("No");

        choiceBoxNotifications.getItems().addAll("On","Off");
        if(NOTIFICATIONS)
            choiceBoxNotifications.setValue("On");
        else
            choiceBoxNotifications.setValue("Off");

        choiceBoxKeepMeLoggedIn.getItems().addAll("Yes", "No");
        if(KEEPMELOGGEDIN)
            choiceBoxKeepMeLoggedIn.setValue("Yes");
        else
            choiceBoxKeepMeLoggedIn.setValue("No");

        choiceBoxNotificationSound.getItems().addAll("Yes", "No");
        if(PLAYNOTIFICATIONSOUND)
            choiceBoxNotificationSound.setValue("Yes");
        else
            choiceBoxNotificationSound.setValue("No");

        beforeStartField.setText(String.valueOf(TIMEBEFORECLASSSTART));
        beforeEndField.setText(String.valueOf(TIMEBEFORECLASSEND));

        disableOptions();
    }

    public void backButtonPress (ActionEvent actionEvent) throws IOException {
        Stage appStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene= new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        if(FULLSCREEN)
            appStage.setFullScreen(true);
        appStage.show();
    }

    public void changeNotificationSetting (MouseEvent actionEvent){
        disableOptions();
    }

    public static void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("options.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(FULLSCREEN);
        printWriter.println(NOTIFICATIONS);
        printWriter.println(KEEPMELOGGEDIN);
        printWriter.println(TIMEBEFORECLASSSTART);
        printWriter.println(TIMEBEFORECLASSEND);
        printWriter.println(PLAYNOTIFICATIONSOUND);
        if(KEEPMELOGGEDIN && Main.student != null)
            printWriter.println(Main.student.firstName + "_" + Main.student.lastName);
        printWriter.close();
    }

    public void saveButtonPress(ActionEvent actionEvent) throws IOException{
        if(choiceBoxFullscreen.getValue() == "Yes")
            FULLSCREEN = true;
        else
            FULLSCREEN = false;

        if(choiceBoxNotifications.getValue() == "On")
            NOTIFICATIONS = true;
        else
            NOTIFICATIONS = false;

        if(choiceBoxNotificationSound.getValue() == "Yes")
            PLAYNOTIFICATIONSOUND = true;
        else
            PLAYNOTIFICATIONSOUND = false;

        if(choiceBoxKeepMeLoggedIn.getValue() == "Yes")
            KEEPMELOGGEDIN = true;
        else
            KEEPMELOGGEDIN = false;

        TIMEBEFORECLASSSTART = Integer.parseInt(beforeStartField.getText());
        TIMEBEFORECLASSEND = Integer.parseInt(beforeEndField.getText());

        saveData();

        Stage appStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/options/options.fxml"));
        Scene scene = new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);

        if(FULLSCREEN)
            appStage.setFullScreen(true);

        appStage.show();
    }

    public void revertToDefaultSettings(ActionEvent actionEvent) throws IOException {
        if(displayNotification("Are You Sure You Want To Revert To The Default Settings") != true)
            return;

        if(defaultFullscreen)
            choiceBoxFullscreen.setValue("Yes");
        else
            choiceBoxFullscreen.setValue("No");

        if(defaultNotifications)
            choiceBoxNotifications.setValue("On");
        else
            choiceBoxNotifications.setValue("Off");

        if(defaultKeepMeLoggedIn)
            choiceBoxKeepMeLoggedIn.setValue("Yes");
        else
            choiceBoxKeepMeLoggedIn.setValue("No");

        if(defaultPlayNotificationSound)
            choiceBoxNotificationSound.setValue("Yes");
        else
            choiceBoxNotificationSound.setValue("No");

        beforeStartField.setText(String.valueOf(defaultTimeBeforeClassStart));
        beforeEndField.setText(String.valueOf(defaultTimeBeforeClassEnd));

        saveButtonPress(actionEvent);
    }

    public static boolean displayNotification(String text){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, text, ButtonType.YES, ButtonType.NO);
        alert.setHeaderText(null);
        alert.setTitle("Texas State Desktop Application");
        alert.initStyle(StageStyle.UTILITY);
        ((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES)
            return true;
        else
            return false;
    }

    public void disableOptions(){
        if(choiceBoxNotifications.getValue() == "On") {
            beforeStartField.setDisable(false);
            beforeEndField.setDisable(false);
            beforeStartLabel.setDisable(false);
            beforeEndLabel.setDisable(false);
            notificationSoundLabel.setDisable(false);
            choiceBoxNotificationSound.setDisable(false);
        }
        else{
            beforeStartField.setDisable(true);
            beforeEndField.setDisable(true);
            beforeStartLabel.setDisable(true);
            beforeEndLabel.setDisable(true);
            notificationSoundLabel.setDisable(true);
            choiceBoxNotificationSound.setDisable(true);
        }
    }
}
