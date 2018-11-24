package sample;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Gallery extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        ScrollPane root = new ScrollPane();
        TilePane tile = new TilePane();
        tile.setHgap(50);
        String path = null;
        primaryStage.setTitle("Galeria zdjęć");

        DirectoryChooser directory = new DirectoryChooser();
        File selected = directory.showDialog(stage);

        if(selected == null){
            path="zdjecia";
        }else{
            path = selected.getAbsolutePath();
        }

        primaryStage.getIcons().add(new Image("https://png.pngtree.com/svg/20161012/gallery_1245283.png"));


        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (final File file : listOfFiles) {
            ImageView image;
            image = createImageView(file);
            tile.getChildren().addAll(image);
        }

        root.setContent(tile);

        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private ImageView createImageView(final File imageFile) {
        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 150, 0, true,
                    true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {

                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                        if(mouseEvent.getClickCount() == 2){
                            try {
                                BorderPane borderPane = new BorderPane();
                                ImageView imageView = new ImageView();
                                Image image = new Image(new FileInputStream(imageFile));
                                imageView.setImage(image);
                                imageView.setFitHeight(stage.getHeight());
                                Stage newStage = new Stage();
                                newStage.setWidth(1000);
                                newStage.setHeight(1000);
                                borderPane.setCenter(imageView);
                                newStage.setTitle(imageFile.getName());
                                Scene scene = new Scene(borderPane);
                                newStage.setScene(scene);
                                newStage.show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }

}