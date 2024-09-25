package com.teambluespring.srb2rotations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SRB2Application extends Application {
    public static Scene scene;

    public static Scene returnCurrentScene() {
        // Currently only for current scene, but possible complications might happen later.
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SRB2Application.class.getResource("DocumentsScene.fxml"));
        scene = new Scene(fxmlLoader.load(), 1060, 920);
        stage.setTitle("SRB2 16 Rotation App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}