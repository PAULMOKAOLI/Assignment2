package com.example.assign2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String style=getClass().getResource("/Style.css").toExternalForm();
        BorderPane root=new BorderPane();
        Label menu=new Label("MENU");
        menu.setId("menu");
        VBox.setMargin(menu,new  Insets(5, 10, 5,40));

        VBox left=new VBox();
        left.setPrefSize(150,600);
        left.setId("left");
        root.setLeft(left);

        VBox middle=new VBox();
        middle.setPrefSize(200,600);
        middle.setId("middle");
        root.setCenter(middle);

        VBox right=new VBox();
        right.setAlignment(Pos.CENTER);
        right.setPrefSize(200,600);
        right.setId("right");
        root.setRight(right);

//================GETTING IMAGE FROM FILE=============================================================================//
        Button Strt=new Button("File Img");
        Strt.setId("Strt");
        VBox.setMargin(Strt,new  Insets(5, 10, 5,50));

        ImageView imageView=new ImageView();
        Strt.setOnAction(actionEvent -> {
            FileChooser chooser=new FileChooser();
            var file=chooser.showOpenDialog(stage);
            var imgFilter = new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png");
            chooser.getExtensionFilters().add(imgFilter);
            Image img=new Image(file.getAbsolutePath());
            imageView.setImage(img);
            imageView.setFitHeight(600);
            imageView.setFitWidth(200);
        });

        Button Heading=new Button("Heading");
        TextField text=new TextField("Edit Heading");
        text.setId("text");
        Label para=new Label(text.getText());
        para.setId("para");
        VBox.setMargin(para,new  Insets(5, 20, 5,0));
        VBox.setMargin(Heading,new  Insets(5, 10, 5,50));
//=================RADIO BUTTONS======================================================================================//
        RadioButton Black= new RadioButton("Black");
        RadioButton Blue= new RadioButton("blue");
        ToggleGroup radioGroup = new ToggleGroup();

        Black.setToggleGroup(radioGroup);
        Blue.setToggleGroup(radioGroup);

        TilePane tilePane = new TilePane();
        VBox.setMargin(tilePane,new  Insets(5, 0, 0,20));
        tilePane.getChildren().add(Black);
        tilePane.getChildren().add(Blue);

        Heading.setOnAction(actionEvent -> {
            right.getChildren().addAll(para);
            text.setText("");
        });

//=============CHANGING COLOR OF TEXT=================================================================================//
        Black.setOnAction(actionEvent -> {
            Black.setId("Black");
            para.setTextFill(Paint.valueOf("black"));
        });
        Blue.setOnAction(actionEvent -> {
            Blue.setId("Blue");
            para.setTextFill(Paint.valueOf("blue"));
        });

//================ADD LABEL===========================================================================================//
        Button label=new Button("Add Label");
        TextField text1=new TextField("Edit Label");
        text1.setId("text1");
        label.setOnAction(actionEvent -> {
            Label para1=new Label(text1.getText());
            para1.setId("para1");
            VBox.setMargin(para1,new  Insets(5, 10, 5,0));
            right.getChildren().addAll(para1);
            text1.setText("");
        });
        VBox.setMargin(label,new  Insets(5, 10, 5,50));

//================CREATE TEXTFIELD====================================================================================//
        Button TextField=new Button("TextField");
        VBox.setMargin(TextField,new  Insets(5, 10, 5,50));
        TextField.setOnAction(actionEvent -> {
            TextField newTx=new TextField();
            newTx.setId("new");
            VBox.setMargin(newTx,new  Insets(10, 40, 10,20));
            right.getChildren().addAll(newTx);
        });

//==================ADDING NEW BUTTON=================================================================================//
        Button Butt=new Button("AddButton");
        VBox.setMargin(Butt,new  Insets(5, 10, 5,50));
        TextField but=new TextField();
        but.setId("but");
        but.setPromptText("Enter Button Name");
        Butt.setOnAction(actionEvent -> {
            Button New=new Button(but.getText());
            right.getChildren().add(New);
            but.setText("");
            //Button add=new Button("Submit");
            //VBox.setMargin(add,new  Insets(10));
            //right.getChildren().addAll(add);
        });

        left.getChildren().addAll(menu,Strt,text,Heading,tilePane,text1,label,TextField,but,Butt);
        middle.getChildren().addAll(imageView);

        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(style);
        stage.setTitle("Assignment 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}