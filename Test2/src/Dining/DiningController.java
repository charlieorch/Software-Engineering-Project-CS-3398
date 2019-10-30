package Dining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import options.OptionsPageController;

import java.io.IOException;

public class DiningController {

    @FXML
    public Button backButton;

    @FXML
    public void loginBack(ActionEvent actionEvent) throws IOException {
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
    private void addDiningDollars(ActionEvent event){
        String startingAmount = dollarStartingAmount.getText();
        String addAmount = dollarAddOrSubtract.getText();

        double starting = Double.parseDouble(startingAmount);
        double add = Double.parseDouble(addAmount);

        double total;

        total = starting + add;
        String resultTotal = Double.toString(total);
        dollarResult.setText(resultTotal);
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
    }
}
