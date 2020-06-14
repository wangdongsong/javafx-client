package com.wds;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private static final Logger LOGGER = LogManager.getLogger(Application.class);

    private static Scene scene;


    private static Stage stage1 = null;
    public static Stage getStage() {
        return stage1;
    }


    public static void main(String[] args) {
        //获取硬件信息

        launch(args);
    }

    public static void setRoot(String fxml) {
        //scene.disposePeer();
        scene.getWindow().setHeight(800);
        scene.getWindow().setWidth(600);
        scene.setRoot(loadFXML(fxml));
    }

    @Override
    public void start(Stage stage) {
        scene = new Scene(loadFXML("main/main"));
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage1 = stage;

        stage.setScene(scene);
        stage.show();
    }


    private static Parent loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxml + ".fxml"));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }


}