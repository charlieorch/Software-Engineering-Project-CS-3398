package Grade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import options.OptionsPageController;

import javax.xml.namespace.QName;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GradeController implements Initializable {
    @FXML
    public Button backButton;
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
    private AnchorPane pane;


    public void gradeBack(ActionEvent actionEvent)  throws IOException {
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    public ArrayList<TextField> getFields(){
        ArrayList<TextField> feilds = new ArrayList<TextField>();
        for (Node node : pane.getChildren()) {

            if (node instanceof GridPane)
                for (Node node2 : ((GridPane) node).getChildren()) {
                    feilds.add((TextField)node2);
                }
            else if(node instanceof TextField){
                feilds.add((TextField)node);
            }
        }
        return feilds;
    }
    public void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("Grade.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        ArrayList<TextField> feilds = getFields();

        for(TextField field: feilds){
            printWriter.println(field.getText());
        }

        printWriter.close();
    }

    @FXML
    private void calculateGrade(ActionEvent event) throws IOException {
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

        if(gOne.trim().isEmpty()){
            gOne = "0";
        }
        if(gTwo.trim().isEmpty()){
            gTwo = "0";
        }
        if(gThree.trim().isEmpty()){
            gThree = "0";
        }
        if(gThree.trim().isEmpty()){
            gThree = "0";
        }
        if(gFour.trim().isEmpty()){
            gFour = "0";
        }
        if(gFive.trim().isEmpty()){
            gFive = "0";
        }
        if(gSix.trim().isEmpty()){
            gSix = "0";
        }
        if(gSeven.trim().isEmpty()){
            gSeven = "0";
        }
        if(gEight.trim().isEmpty()){
            gEight = "0";
        }
        if(gNine.trim().isEmpty()){
            gNine = "0";
        }
        if(gTen.trim().isEmpty()){
            gTen = "0";
        }



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

        if(pOne.trim().isEmpty()){
            pOne = "0";
        }
        if(pTwo.trim().isEmpty()){
            pTwo = "0";
        }
        if(pThree.trim().isEmpty()){
            pThree = "0";
        }
        if(pThree.trim().isEmpty()){
            pThree = "0";
        }
        if(pFour.trim().isEmpty()){
            pFour = "0";
        }
        if(pFive.trim().isEmpty()){
            pFive = "0";
        }
        if(pSix.trim().isEmpty()){
            pSix = "0";
        }
        if(pSeven.trim().isEmpty()){
            pSeven = "0";
        }
        if(pEight.trim().isEmpty()){
            pEight = "0";
        }
        if(pNine.trim().isEmpty()){
            pNine = "0";
        }
        if(pTen.trim().isEmpty()){
            pTen = "0";
        }

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


        double total = 0;

        total = ((grade1 * percent1)/100) + ((grade2 * percent2)/100) + ((grade3 * percent3)/100) + ((grade4 * percent4)/100) + ((grade5 * percent5)/100) + ((grade6 * percent6)/100) + ((grade7 * percent7)/100) + ((grade8 * percent8)/100) + ((grade9 * percent9)/100) + ((grade10 * percent10)/100);
        String calcTotal = Double.toString(total);
        calcResults.setText(calcTotal);

        saveData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(new File("Grade.txt").exists()) {
            BufferedReader reader = null;
            try {
                ArrayList<TextField> feilds = getFields();
                reader = new BufferedReader(new FileReader("Grade.txt"));
                String line = reader.readLine();
                for(TextField field: feilds){
                    field.setText(line);
                    line = reader.readLine();
                }
                } catch(IOException e){
                    e.printStackTrace();
                }
        }
    }
}
