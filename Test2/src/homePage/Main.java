package homePage;

import account.Student;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import options.OptionsPageController;

import java.io.*;

public class Main extends Application {

    public static Student student = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadSaveData();

        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("Texas State Desktop Application");
        primaryStage.getIcons().add(new Image("/img/icon.png"));
        primaryStage.setScene(new Scene(root, OptionsPageController.PREF_WITH, OptionsPageController.PREF_HEIGHT));
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                try {
                    OptionsPageController.saveData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        primaryStage.show();
    }

    public void loadSaveData()  {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("options.txt"));
            OptionsPageController.FULLSCREEN = Boolean.valueOf(reader.readLine());
            OptionsPageController.NOTIFICATIONS = Boolean.valueOf(reader.readLine());
            OptionsPageController.KEEPMELOGGEDIN = Boolean.valueOf(reader.readLine());

            String lastLogin;
            if(OptionsPageController.KEEPMELOGGEDIN && (lastLogin = reader.readLine()) != null){
                    try{
                        FileInputStream file = new FileInputStream(lastLogin + ".ser");
                        ObjectInputStream in = new ObjectInputStream(file);

                        Main.student = (Student)in.readObject();

                        in.close();
                        file.close();

                        System.out.println(Main.student.firstName);
                    }catch(ClassNotFoundException ex){
                        System.out.println("No Student File Found");
                    }
            }
            reader.close();
            }catch (IOException e){
            System.out.println("No options file found");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
