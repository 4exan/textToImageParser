module ua.kusakabe.desktopdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ua.kusakabe.desktopdemo to javafx.fxml;
    exports ua.kusakabe.desktopdemo;

    exports ua.kusakabe.desktopdemo.controller;
    opens ua.kusakabe.desktopdemo.controller to javafx.fxml;
}