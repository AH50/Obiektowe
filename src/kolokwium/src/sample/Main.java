package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



//nie gotowe okno z grą


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Game");
        primaryStage.setScene(new Scene(root, 700, 700));
        //primaryStage.show();
        DBConnect db = new DBConnect();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
