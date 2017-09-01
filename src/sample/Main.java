package sample;

import javafx.application.Application;
import java.io.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);

        // add controls
        Label titleLbl = new Label(" Title:");
        Label bodyLbl = new Label(" Body:");
        TextField titleTxtField = new TextField();
        TextArea poemBody = new TextArea();
        Button saveButton = new Button("Save");

        grid.getChildren().addAll(titleLbl, titleTxtField, bodyLbl, poemBody, saveButton);
        GridPane.setConstraints(titleLbl, 0, 0);
        GridPane.setConstraints(titleTxtField, 1, 0);
        GridPane.setConstraints(bodyLbl, 0, 1);
        GridPane.setConstraints(poemBody, 1, 1);
        GridPane.setConstraints(saveButton, 1, 2, 1, 1, HPos.RIGHT, VPos.CENTER);

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try (FileWriter fw =
                             new FileWriter(titleTxtField.getText())) {

                    fw.write(poemBody.getText());

                    // make fields blank
                    titleTxtField.setText(" ");
                    poemBody.setText(" ");

                } catch(IOException e) {
                    e.printStackTrace();
                }
            };

        });



        primaryStage.setTitle("Poems");
        primaryStage.setScene(new Scene(grid, 600, 300));
        primaryStage.show();

    }
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//


    public static void main(String[] args) {
        launch(args);
    }
}
