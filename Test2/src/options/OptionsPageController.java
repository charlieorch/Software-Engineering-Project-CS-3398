package options;

import homePage.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    public double defaultPrefWith = 900;
    public double defaultPrefHeight = 600;
    public boolean defaultFullscreen = false;
    public boolean defaultNotifications = true;
    public boolean defaultKeepMeLoggedIn = true;
    public int defaultTimeBeforeClassStart = 30;
    public int defaultTimeBeforeClassEnd = 10;

    @FXML
    public Button backButton;
    @FXML
    public Button saveButton;
    @FXML
    public ChoiceBox<String> choiceBoxFullscreen;
    @FXML
    public ChoiceBox<String> choiceBoxNotifications;

    @Override
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
    }

    @FXML
    public void backButtonPress (ActionEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        if(FULLSCREEN)
            appStage.setFullScreen(true);
        appStage.show();
    }

    public static void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("options.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(FULLSCREEN);
        printWriter.println(NOTIFICATIONS);
        printWriter.println(KEEPMELOGGEDIN);
        printWriter.println(TIMEBEFORECLASSSTART);
        printWriter.println(TIMEBEFORECLASSEND);
        if(KEEPMELOGGEDIN && Main.student != null)
            printWriter.println(Main.student.firstName + "_" + Main.student.lastName);
        printWriter.close();
    }

    @FXML
    public void saveButtonPress(ActionEvent actionEvent) throws IOException{
        if(choiceBoxFullscreen.getValue() == "Yes")
            FULLSCREEN = true;
        else
            FULLSCREEN = false;

        if(choiceBoxNotifications.getValue() == "On")
            NOTIFICATIONS = true;
        else
            NOTIFICATIONS = false;

        saveData();

        Stage appStage=(Stage) backButton.getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("/options/options.fxml"));
        Scene scene = new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);

        if(FULLSCREEN)
            appStage.setFullScreen(true);

        appStage.show();
    }

    public void revertToDefaultSettings() throws IOException {
        PREF_WITH = defaultPrefWith;
        PREF_HEIGHT = defaultPrefHeight;
        FULLSCREEN = defaultFullscreen;
        NOTIFICATIONS = defaultNotifications;
        KEEPMELOGGEDIN = defaultKeepMeLoggedIn;
        TIMEBEFORECLASSSTART = defaultTimeBeforeClassStart;
        TIMEBEFORECLASSEND = defaultTimeBeforeClassEnd;

        saveButtonPress(new ActionEvent());
    }

    public static void displayNotification(String text){
        if(!NOTIFICATIONS)
            return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Texas State Desktop Application");
        alert.setContentText(text);
        alert.initStyle(StageStyle.UTILITY);
        ((Stage) alert.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        alert.setX(bounds.getMaxX() - 430);
        alert.setY(10);
        Thread thread = new Thread(() -> {
            try {
                // Wait for 5 secs
                Thread.sleep(10000);
                if (alert.isShowing()) {
                    Platform.runLater(() -> alert.close());
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        alert.showAndWait();
    }
}
