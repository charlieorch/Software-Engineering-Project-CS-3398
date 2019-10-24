package homePage;

import account.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import options.OptionsPageController;

public class Main extends Application {

    public static Student student = new Student();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("Texas State Desktop Application");
        primaryStage.getIcons().add(new Image("/img/icon.png"));
        primaryStage.setScene(new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
