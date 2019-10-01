package GPA;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import options.OptionsPageController;

import javax.xml.namespace.QName;
import java.io.IOException;

public class GPACalculatorController {
    // algorithym for calculating GPA
    //(4 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f)) + 3 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f))
    // + 2 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f)) + 1 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f))) = score
    // score/total credit hours = GPA

    @FXML
    public Button backButton;

    public void gpaBack(ActionEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }
}
