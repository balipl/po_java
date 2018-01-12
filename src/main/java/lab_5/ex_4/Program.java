package lab_5.ex_4;

import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application {
    View v = new View();
    //modelx
    PhotosSort m = new PhotosSort();

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) {
        v.Scena1(primaryStage,m);
    }
}
