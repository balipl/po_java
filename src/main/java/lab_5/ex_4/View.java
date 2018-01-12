package lab_5.ex_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import javafx.scene.image.ImageView;

public class View {


    public LinkedList<String> list=new LinkedList<>();
    public String[] lista;

    public void Scena1(Stage s, PhotosSort k) {

        DirectoryChooser dirChooser = new DirectoryChooser();
        Button button2 = new Button("Wybierz folder");

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String path = "";
                File selectedDirectory = dirChooser.showDialog(s);

                if (selectedDirectory != null) {
                    path = selectedDirectory.getPath();
                }
                Scena2(path, k);
            }
        });

        //rysowanie Sceny1
        Pane root = new Pane();
        root.getChildren().add(button2);
        s.setScene(new Scene(root, 500, 500, Color.WHITE));
        s.show();

    }

        public void Scena2(String dir_path, PhotosSort k) {
            Stage stage = new Stage();
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 250, Color.WHITE);
            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(5));
            gridpane.setHgap(10);
            gridpane.setVgap(10);
            ColumnConstraints column1 = new ColumnConstraints(150, 150,
                    Double.MAX_VALUE);
            ColumnConstraints column2 = new ColumnConstraints(50);
            column1.setHgrow(Priority.ALWAYS);
            gridpane.getColumnConstraints().addAll(column1, column2);

            Label candidatesLbl = new Label("Zdjęcia");
            GridPane.setHalignment(candidatesLbl, HPos.CENTER);
            gridpane.add(candidatesLbl, 0, 0);


            try {
                lista = PhotosSort.Pobierz_zdjecia(dir_path);
            } catch (Exception e) {
            }
            for (String element : lista) {
                list.add(element);

            }
            final ObservableList<String> candidates = FXCollections
                    .observableArrayList(list);
            final ListView<String> candidatesListView = new ListView<>(candidates);
            gridpane.add(candidatesListView, 0, 1);


            Button sendRightButton = new Button("Wybierz");

            sendRightButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    String potential = candidatesListView.getSelectionModel()
                        .getSelectedItem();

                    if (potential != null) {

                        candidatesListView.getSelectionModel().clearSelection();

                        try {
                            Scena3(potential, dir_path, k.Rozdzielaj(potential));
                        }catch(Exception e){System.out.println("ERROR");}
                }
            }});


            //rysowanie
            VBox vbox = new VBox(5);
            vbox.getChildren().addAll(sendRightButton);

            gridpane.add(vbox, 1, 1);
            root.setCenter(gridpane);

            GridPane.setVgrow(root, Priority.ALWAYS);
            stage.setScene(scene);
            stage.show();
        }

    public void Scena3(String name, String dir_path, Map<String,Double> mapa){
        Stage stage=new Stage();
        String img_path=name;

        File file=new File(img_path);
        Image image=new Image(file.toURI().toString());

        ImageView iv1 = new ImageView();
        iv1.setImage(image);


        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        iv1.setLayoutY(200);
        iv1.setLayoutX(10);
        scene.setFill(Color.BLUE);
        root.getChildren().add(iv1);


        //wykres


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();

        for (Map.Entry<String, Double> entry : mapa.entrySet()) {
            if(entry.getValue()>0.05) {

                pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
            }
        }


        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("WYKRES");
        chart.setLayoutX(200);
        chart.setLayoutY(200);
        chart.setMaxSize(800,800);
        root.getChildren().add(chart);


        stage.setTitle("Tytuł");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

}



}

