package Dining;

import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import options.OptionsPageController;

import java.util.ResourceBundle;

public class DiningController implements Initializable {

    @FXML
    public Button backButton;
    @FXML
    private TextField swipeCounter;

    @FXML
    public void loginBack(ActionEvent actionEvent) throws IOException {
        saveData();
        Stage appStage;
        Parent root;
        appStage=(Stage) backButton.getScene().getWindow();
        root= FXMLLoader.load(getClass().getResource("/homePage/home.fxml"));
        Scene scene=new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private TextField dollarStartingAmount;
    @FXML
    private TextField dollarAddOrSubtract;
    @FXML
    private TextField dollarResult;
    @FXML
    public Button addButton;
    @FXML
    public Button subtractButton;

    @FXML
    public void addDiningDollars(ActionEvent event){
        String startingAmount = dollarStartingAmount.getText();
        String addAmount = dollarAddOrSubtract.getText();

        double starting = Double.parseDouble(startingAmount);
        double add = Double.parseDouble(addAmount);

        double total;

        total = starting + add;
        String resultTotal = Double.toString(total);
        dollarResult.setText(resultTotal);

        //saveData();
    }

    @FXML
    private void subtractDiningDollars(ActionEvent event){
        String startingAmount = dollarStartingAmount.getText();
        String subtractAmount = dollarAddOrSubtract.getText();

        double starting = Double.parseDouble(startingAmount);
        double subtract = Double.parseDouble(subtractAmount);

        double total;

        total = starting - subtract;
        String resultTotal = Double.toString(total);
        dollarResult.setText(resultTotal);

        //saveData();
    }

    @FXML
    public LineChart chart;

    @FXML
    private void handleButtonAction (ActionEvent event) {
        String starting_amt = dollarStartingAmount.getText();
        double starting = Double.parseDouble(starting_amt);

    }

    public  void saveData() throws IOException {
        FileWriter fileWriter = new FileWriter("Dining.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(swipeCounter.getText());
        if(dollarResult.getText().equals(""))
            printWriter.println(dollarStartingAmount);
        else
            printWriter.println(dollarResult.getText());

        printWriter.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(new File("Dining.txt").exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Dining.txt"));
                swipeCounter.setText(reader.readLine());
                dollarStartingAmount.setText(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
