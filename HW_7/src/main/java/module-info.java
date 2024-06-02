module ua.com.alevel.hw_7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ua.com.alevel.hw_7 to javafx.fxml;
    exports ua.com.alevel.hw_7;
    exports ua.com.alevel.hw_7.controller;
    exports ua.com.alevel.hw_7.entity;
    exports ua.com.alevel.hw_7.service;
    exports ua.com.alevel.hw_7.db;

    opens ua.com.alevel.hw_7.controller to javafx.fxml;
}