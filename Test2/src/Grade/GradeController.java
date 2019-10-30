package Grade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import options.OptionsPageController;

import javax.xml.namespace.QName;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GradeController {

    @FXML
    public Button backButton;

    public void gradeBack(ActionEvent actionEvent) throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    public static void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("Grade.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //printWriter.println(Grade);
        printWriter.close();
    }

    @FXML
    private TextField calcResults;
    @FXML
    private TextField gradeOne;
    @FXML
    private TextField gradeTwo;
    @FXML
    private TextField gradeThree;
    @FXML
    private TextField gradeFour;
    @FXML
    private TextField gradeFive;
    @FXML
    private TextField gradeSix;
    @FXML
    private TextField gradeSeven;
    @FXML
    private TextField gradeEight;
    @FXML
    private TextField gradeNine;
    @FXML
    private TextField gradeTen;

    @FXML
    private TextField percentOne;
    @FXML
    private TextField percentTwo;
    @FXML
    private TextField percentThree;
    @FXML
    private TextField percentFour;
    @FXML
    private TextField percentFive;
    @FXML
    private TextField percentSix;
    @FXML
    private TextField percentSeven;
    @FXML
    private TextField percentEight;
    @FXML
    private TextField percentNine;
    @FXML
    private TextField percentTen;

    @FXML
    private void calculateGrade(ActionEvent event){
        String gOne = gradeOne.getText();
        String gTwo = gradeTwo.getText();
        String gThree = gradeThree.getText();
        String gFour = gradeFour.getText();
        String gFive = gradeFive.getText();
        String gSix = gradeSix.getText();
        String gSeven = gradeSeven.getText();
        String gEight = gradeEight.getText();
        String gNine = gradeNine.getText();
        String gTen = gradeTen.getText();

        String pOne = percentOne.getText();
        String pTwo = percentTwo.getText();
        String pThree = percentThree.getText();
        String pFour = percentFour.getText();
        String pFive = percentFive.getText();
        String pSix = percentSix.getText();
        String pSeven = percentSeven.getText();
        String pEight = percentEight.getText();
        String pNine = percentNine.getText();
        String pTen = percentTen.getText();

        double grade1 = Double.parseDouble(gOne);
        double grade2 = Double.parseDouble(gTwo);
        double grade3 = Double.parseDouble(gThree);
        double grade4 = Double.parseDouble(gFour);
        double grade5 = Double.parseDouble(gFive);
        double grade6 = Double.parseDouble(gSix);
        double grade7 = Double.parseDouble(gSeven);
        double grade8 = Double.parseDouble(gEight);
        double grade9 = Double.parseDouble(gNine);
        double grade10 = Double.parseDouble(gTen);

        double percent1 = Double.parseDouble(pOne);
        double percent2 = Double.parseDouble(pTwo);
        double percent3 = Double.parseDouble(pThree);
        double percent4 = Double.parseDouble(pFour);
        double percent5 = Double.parseDouble(pFive);
        double percent6 = Double.parseDouble(pSix);
        double percent7 = Double.parseDouble(pSeven);
        double percent8 = Double.parseDouble(pEight);
        double percent9 = Double.parseDouble(pNine);
        double percent10 = Double.parseDouble(pTen);

        double total;

        total = ((grade1 * percent1 + grade2 * percent2 + grade3 * percent3 + grade4 * percent4 + grade5 * percent5 + grade6 * percent6 + grade7 * percent7 + grade8 * percent8 + grade9 * percent9 + grade10 + percent10) / 100);
        String calcTotal = Double.toString(total);
        calcResults.setText(calcTotal);

    }
}
