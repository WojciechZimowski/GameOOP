package org.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        double width = 500;
        double height = 500;

        GameCanvas gameCanvas = new GameCanvas(width, height);
        gameCanvas.draw();

        Group root = new Group(gameCanvas);
        Scene scene = new Scene(root);

        primaryStage.setTitle("SwietnaGra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
