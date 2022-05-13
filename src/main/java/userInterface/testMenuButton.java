/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userInterface;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.text.Text.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

/**
 *
 * @author mbirc
 */
public class testMenuButton extends Application{
    private static Scene scene;

 
    @Override
    public void start(Stage s) throws IOException {
        // set title for the stage
        s.setTitle("creating MenuButton ");
 
        // create a tile pane
        TilePane r = new TilePane();
 
        // create a label
        Label l1 = new Label("This is a MenuButton example ");
 
        // create a menu button
        MenuButton m = new MenuButton("menuButton");
 
        // create menuitems
        MenuItem m1 = new MenuItem("menu item 1");
        MenuItem m2 = new MenuItem("menu item 2");
        MenuItem m3 = new MenuItem("menu item 3");
 
        // add menu items to menu
        m.getItems().add(m1);
        m.getItems().add(m2);
        m.getItems().add(m3);

        
        // label to display the selected menuitem
        Label l2 = new Label("default menuitem selected");
 
        // create action event
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l2.setText(((MenuItem)e.getSource()).getText() + " selected");
            }
        };
 
        // add action events to the menuitems
        m1.setOnAction(event1);
        m3.setOnAction(event1);
        m2.setOnAction(event1);
 
        // create a tilepane
        TilePane vb = new TilePane(l1);
 
        vb.getChildren().add(m);
        vb.getChildren().add(l2);



        
        
        
        // create a tilepane
        //TilePane vb = new TilePane(l1, m);
 
        // create a scene
        Scene sc = new Scene(vb, 400, 400);
 
        // set the scene
        s.setScene(sc);
 
        s.show();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMain.class.getResource(fxml + ".fxml"));

        return fxmlLoader.load();
    }
    
        public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
    
}
