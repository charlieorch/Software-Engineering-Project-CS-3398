package GPA;

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
    private TextField b34;

    @FXML
    private TextField b33;

    @FXML
    private TextField b32;

    @FXML
    private TextField b31;

    @FXML
    private TextField c24;

    @FXML
    private TextField c23;

    @FXML
    private TextField c22;

    @FXML
    private TextField c21;

    @FXML
    private TextField d14;

    @FXML
    private TextField d13;

    @FXML
    private TextField d12;

    @FXML
    private TextField d11;

    @FXML
    private TextField calcResults;

    @FXML
    private void gradeCalculate(ActionEvent event){
        String totalG = total.getText();
        String a4 = a44.getText();
        String a3 = a43.getText();
        String a2 = a42.getText();
        String a1 = a41.getText();
        String b4 = b34.getText();
        String b3 = b33.getText();
        String b2 = b32.getText();
        String b1 = b31.getText();
        String c4 = c24.getText();
        String c3 = c23.getText();
        String c2 = c22.getText();
        String c1 = c21.getText();
        String d4 = d14.getText();
        String d3 = d13.getText();
        String d2 = d12.getText();
        String d1 = d11.getText();

        double gtotal = Double.parseDouble(totalG);
        double ca4 = Double.parseDouble(a4);
        double ca3 = Double.parseDouble(a3);
        double ca2 = Double.parseDouble(a2);
        double ca1 = Double.parseDouble(a1);
        double cb4 = Double.parseDouble(b4);
        double cb3 = Double.parseDouble(b3);
        double cb2 = Double.parseDouble(b2);
        double cb1 = Double.parseDouble(b1);
        double cc4 = Double.parseDouble(c4);
        double cc3 = Double.parseDouble(c3);
        double cc2 = Double.parseDouble(c2);
        double cc1 = Double.parseDouble(c1);
        double cd4 = Double.parseDouble(d4);
        double cd3 = Double.parseDouble(d3);
        double cd2 = Double.parseDouble(d2);
        double cd1 = Double.parseDouble(d1);

        double score, GPA, tA, tB, tC, tD;
        double caa4 = 1, caa3 = 1, caa2 = 1, caaa = 1;
        double cbb4 = 1, cbb3 = 1, cbb2 = 1, cbbb = 1;
        double ccc4 = 1, ccc3 = 1, ccc2 = 1, cccc = 1;
        double cdd4 = 1, cdd3 = 1, cdd2 = 1, cddd = 1;

        if (ca4 == 0)
            caa4 = 1;
        else if (ca4 != 0)
            caa4 = (ca4 * 4);
        System.out.println(caa4);
        if (ca3 == 0)
            caa3 = 1;
        else if (ca3 != 0)
            caa3 = (ca3 * 3);
        System.out.println(caa3);
        if (ca2 == 0)
            caa2 = 1;
        else if (ca2 != 0)
            caa2 = (ca2 * 2);

        if (cb4 == 0)
            cbb4 = 1;
        else if (cb4 != 0)
            cbb4 = (cb4 * 4);
        if (cb3 == 0)
            cbb3 = 1;
        else if (cb3 != 0)
            cbb3 = (cb3 * 3);
        if (cb2 == 0)
            cbb2 = 1;
        else if (cb2 != 0)
            cbb2 = (cb2 * 2);

        if (cc4 == 0)
            ccc4 = 1;
        else if (cc4 != 0)
            ccc4 = (cc4 * 4);
        if (cc3 == 0)
            ccc3 = 1;
        else if (cc3 != 0)
            ccc3 = (cc3 * 3);
        if (cc2 == 0)
            ccc2 = 1;
        else if (cc2 != 0)
            ccc2 = (cc2 * 2);

        if (cd4 == 0)
            cdd4 = 1;
        else if (cd4 != 0)
            cdd4 = (cd4 * 4);
        if (cd3 == 0)
            cdd3 = 1;
        else if (cd3 != 0)
            cdd3 = (cd3 * 3);
        if (cd2 == 0)
            cdd2 = 1;
        else if (cd2 != 0)
            cdd2 = (cd2 * 2);

        if (ca1 == 0)
            ca1 = 1;
        if (cb1 == 0)
            cb1 = 1;
        if (cc1 == 0)
            cc1 = 1;
        if (cd1 == 0)
            cd1 = 1;

        if (caa4 == 1 && caa3 == 1 && caa2 == 1 && ca1 == 1)
            caaa = 0;
        else
            caaa = (caa4/caa3/caa2/ca1);
        if (cbb4 == 1 && cbb3 == 1 && cbb2 == 1 && cb1 == 1)
            cbbb = 0;
        else
            cbbb = (cbb4/cbb3/cbb2/cb1);
        if (ccc4 == 1 && ccc3 == 1 && ccc2 == 1 && cc1 == 1)
            cccc = 0;
        else
            cccc = (ccc4/ccc3/ccc2/cc1);
        if (cdd4 == 1 && cdd3 == 1 && cdd2 == 1 && cd1 == 1)
            cddd = 0;
        else
            cddd = (cdd4/cdd3/cdd2/cd1);

        System.out.println((caaa));
        System.out.println((cbbb));
        System.out.println((cccc));
        System.out.println((cddd));

        tA = (4 * caaa);
        tB = (3 * cbbb);
        tC = (2 * cccc);
        tD = (1 * cddd);

        System.out.println((tA));
        System.out.println((tB));
        System.out.println((tC));
        System.out.println((tD));

        score = tA + tB + tC + tD;

        GPA = score / gtotal;

        String totalCalculated = Double.toString(GPA);
        calcResults.setText(totalCalculated);
    }


}
