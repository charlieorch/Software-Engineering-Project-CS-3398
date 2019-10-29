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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GPACalculatorController {
    // algorithym for calculating GPA
    //(4 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f)) + 3 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f))
    // + 2 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f)) + 1 credit hours * completed((4*a)/(3*b)/(2*c)/(1*d)/(0*f))) = score
    // score/total credit hours = GPA

   /* public double gpaAlg(){
        double a4, a3, a2, a1, tA;
        double b4, b3, b2, b1, tB;
        double c4, c3, c2, c1, tC;
        double d4, d3, d2, d1, tD;
        double score, GPA, total;

        tA = (4 * ((4 * a4)/(3 * a3)/(2 * a2)/(1 * a1)));
        tB = (3 * ((4 * b4)/(3 * b3)/(2 * b2)/(1 * b1)));
        tC = (2 * ((4 * c4)/(3 * c3)/(2 * c2)/(1 * c1)));
        tD = (1 * ((4 * d4)/(3 * d3)/(2 * d2)/(1 * d1)));

        score = tA + tB + tC + tD;

        score / total = GPA;

        return GPA;
    }*/

    @FXML
    public Button calcButton;

    public void gpaCalc(ActionEvent actionEvent) throws IOException {
        //call to button to calculate GPA
    }

    public static void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("GPA.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //printWriter.println(GPA);
        printWriter.close();
    }

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
