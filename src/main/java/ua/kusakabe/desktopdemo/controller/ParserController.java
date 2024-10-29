package ua.kusakabe.desktopdemo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ua.kusakabe.desktopdemo.service.ImageService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class ParserController {

    @FXML
    private ImageView imagePreview;

    @FXML
    private Label actionLabel;

    @FXML
    private Button decodeImageBtn;

    @FXML
    private Button generateImageBtn;

    @FXML
    private Button loadImageBtn;

    @FXML
    private Button saveImageBtn;

    @FXML
    private TextArea textArea;


    ImageService imageService = new ImageService();
    private BufferedImage image;

    @FXML
    void decodeImage(ActionEvent event) {
        textArea.setText(imageService.decodeImage(image));
        actionLabel.setText("Image successfully decoded");
    }

    @FXML
    void generateImage(ActionEvent event) {
        ArrayList<Color> colorScheme = imageService.generateColorScheme(textArea.getText());
        image = imageService.writeImage(colorScheme);
        actionLabel.setText("Image successfully generated");
    }

    @FXML
    void loadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load image");
        fileChooser.getExtensionFilters().addAll();
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg");

        Stage stage = (Stage)loadImageBtn.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file !=null) {
            image = imageService.loadFile(file.getAbsolutePath());
            actionLabel.setText("Image successfully loaded");
            Image deisplayImage = new Image("file:"+file.getAbsolutePath());
            imagePreview.setImage(deisplayImage);
        } else {
            actionLabel.setText("Image could not be loaded");
        }
    }

    @FXML
    void saveImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save image");
        fileChooser.getExtensionFilters().addAll();
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg");
        Stage stage = (Stage)saveImageBtn.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if(file != null) {
            imageService.saveFile(image, file.getAbsolutePath());
            actionLabel.setText("Image successfully saved");
        } else {
            actionLabel.setText("Image could not be saved");
        }
    }

}