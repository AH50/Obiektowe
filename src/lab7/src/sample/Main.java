package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(15, 15, 15, 15));
        tile.setHgap(15);


        String path = "C:\\Users\\Adam\\Documents\\java\\zad2\\src\\lab7\\src\\sample\\Nowy folder";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (final File file : listOfFiles) {
            ImageView imageView;
            imageView = createImageView(file);
            tile.getChildren().addAll(imageView);
        }


        ImageView xxxxx=new ImageView();
        xxxxx.getImage();
        ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);
        root.setContent(tile);
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("People");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    private ImageView createImageView(final File imageFile) {
        // DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
        // The last two arguments are: preserveRatio, and use smooth (slower)
        // resizing

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 150, 0, true,
                    true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }


   // public static void main(String[] args) {
      //  launch(args);
    //}
}