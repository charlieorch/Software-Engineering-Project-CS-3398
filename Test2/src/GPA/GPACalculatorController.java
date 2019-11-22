package GPA;

import homePage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import options.OptionsPageController;

import javax.xml.namespace.QName;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GPACalculatorController {
    @FXML
    public Button backButton;
    @FXML
    public Button calcButton;
    @FXML
    private TextField total;
    @FXML
    private TextField a44;
    @FXML
    private TextField a43;
    @FXML
    private TextField a42;
    @FXML
    private TextField a41;
    @FXML
    private TextField a40;
    @FXML
    private TextField b34;
    @FXML
    private TextField b33;
    @FXML
    private TextField b32;
    @FXML
    private TextField b31;
    @FXML
    private TextField b30;
    @FXML
    private TextField c24;
    @FXML
    private TextField c23;
    @FXML
    private TextField c22;
    @FXML
    private TextField c21;
    @FXML
    private TextField c20;
    @FXML
    private TextField d14;
    @FXML
    private TextField d13;
    @FXML
    private TextField d12;
    @FXML
    private TextField d11;
    @FXML
    private TextField d10;
    @FXML
    private TextField calcResults;

    public void gpaBack(ActionEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    public void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("GPA.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(total);
        printWriter.println(a44);
        printWriter.println(a43);
        printWriter.println(a42);
        printWriter.println(a41);
        printWriter.println(a40);
        printWriter.println(b34);
        printWriter.println(b33);
        printWriter.println(b32);
        printWriter.println(b31);
        printWriter.println(b30);
        printWriter.println(c24);
        printWriter.println(c23);
        printWriter.println(c22);
        printWriter.println(c21);
        printWriter.println(c20);
        printWriter.println(d14);
        printWriter.println(d13);
        printWriter.println(d12);
        printWriter.println(d11);
        printWriter.println(d10);
        printWriter.println(calcResults);

        printWriter.close();
    }

    @FXML
    public void gradeCalculate(ActionEvent event){
        String totalG = total.getText();
        String a4 = a44.getText();
        String a3 = a43.getText();
        String a2 = a42.getText();
        String a1 = a41.getText();
        String a0 = a40.getText();
        String b4 = b34.getText();
        String b3 = b33.getText();
        String b2 = b32.getText();
        String b1 = b31.getText();
        String b0 = b30.getText();
        String c4 = c24.getText();
        String c3 = c23.getText();
        String c2 = c22.getText();
        String c1 = c21.getText();
        String c0 = c20.getText();
        String d4 = d14.getText();
        String d3 = d13.getText();
        String d2 = d12.getText();
        String d1 = d11.getText();
        String d0 = d10.getText();

        double gtotal = Double.parseDouble(totalG);
        double ca4 = Double.parseDouble(a4);
        double ca3 = Double.parseDouble(a3);
        double ca2 = Double.parseDouble(a2);
        double ca1 = Double.parseDouble(a1);
        double ca0 = Double.parseDouble(a0);
        double cb4 = Double.parseDouble(b4);
        double cb3 = Double.parseDouble(b3);
        double cb2 = Double.parseDouble(b2);
        double cb1 = Double.parseDouble(b1);
        double cb0 = Double.parseDouble(b0);
        double cc4 = Double.parseDouble(c4);
        double cc3 = Double.parseDouble(c3);
        double cc2 = Double.parseDouble(c2);
        double cc1 = Double.parseDouble(c1);
        double cc0 = Double.parseDouble(c0);
        double cd4 = Double.parseDouble(d4);
        double cd3 = Double.parseDouble(d3);
        double cd2 = Double.parseDouble(d2);
        double cd1 = Double.parseDouble(d1);
        double cd0 = Double.parseDouble(d0);

        double score, GPA, tA, tB, tC, tD;

        tA = (4 * ((4 * ca4)/(3 * ca3)/(2 * ca2)/(ca1)));
        tB = (3 * ((4 * cb4)/(3 * cb3)/(2 * cb2)/(cb1)));
        tC = (2 * ((4 * cc4)/(3 * cc3)/(2 * cc2)/(cc1)));
        tD = (1 * ((4 * cd4)/(3 * cd3)/(2 * cd2)/(cd1)));

        score = tA + tB + tC + tD;

        GPA = score / gtotal;

        String totalCalculated = Double.toString(GPA);
        calcResults.setText(totalCalculated);

        //saveData();
    }
}
