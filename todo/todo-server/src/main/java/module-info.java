module com.example.todoserver {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.persistence;
    requires spring.data.jpa;
    requires spring.context;
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.core;


    opens com.example.todoserver to javafx.fxml;
    exports com.example.todoserver;
}