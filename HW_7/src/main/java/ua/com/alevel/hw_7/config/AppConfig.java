package ua.com.alevel.hw_7.config;

import javafx.stage.Stage;

public class AppConfig {

    public static void init(Stage stage, Class<?> mainClass) {
        LoaderFactory factory = new LoaderFactory(mainClass);
        PageConfig pageConfig = new PageConfig(stage, factory.getLoaderPageMap());
    }
}