package ua.com.alevel.hw_7;

import javafx.application.Application;
import javafx.stage.Stage;
import ua.com.alevel.hw_7.config.AppConfig;



public class HelloApplication extends Application {

    public void start(Stage stage) {
        AppConfig.init(stage, HelloApplication.class);
    }

    public static void main(String[] args) {
        launch();
    }
}
