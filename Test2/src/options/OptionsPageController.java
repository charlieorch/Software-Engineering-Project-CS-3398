package options;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

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
    public double defaultPrefWith = 900;
    public double defaultPrefHeight = 600;
    public boolean defaultFullscreen = false;
    public boolean defaultNotifications = true;

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

    @FXML
    public void saveButtonPress(ActionEvent actionEvent) throws IOException{

        FileWriter fileWriter = new FileWriter("options.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(FULLSCREEN);
        printWriter.println(NOTIFICATIONS);
        printWriter.close();

        if(choiceBoxFullscreen.getValue() == "Yes")
            FULLSCREEN = true;
        else
            FULLSCREEN = false;

        if(choiceBoxNotifications.getValue() == "On")
            NOTIFICATIONS = true;
        else
            NOTIFICATIONS = false;

        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/options/options.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        if(FULLSCREEN)
            appStage.setFullScreen(true);
        appStage.show();
    }
}
