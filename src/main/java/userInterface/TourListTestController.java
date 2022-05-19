/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import databaseFunctions.SelectRecords;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class TourListTestController implements Initializable {
    
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private ListView<Menu> tourList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addTour();
    }  
    
    private void addTour(){
        list.removeAll(list);
        
        ArrayList<String> tours = new ArrayList();
        int tourZahl = SelectRecords.tourNamenInArray(tours);
        Iterator<String> iter = tours.iterator();
        
        while(tourZahl != 0){        

            Menu tourMenu = new Menu(iter.next());
            
            MenuItem updateTour = new MenuItem("update Tour");
            MenuItem addKunde = new MenuItem("add Kunde");
            MenuItem deleteKunde = new MenuItem("delete Kunde");
            
            tourMenu.getItems().addAll(updateTour, addKunde, deleteKunde);
            
            updateTour.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLoginAendern.fxml"));
                        Parent root = loader.load();
                        //The following both lines are the only addition we need to pass the arguments
                        UserLoginAendernController controller2 = loader.getController();
                        //controller2.LoginCurrentMit(currentUser);
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Login Daten Aendern");
                        stage.show();

                    }catch(IOException e){
                        e.printStackTrace();
                    } 
                }
            
            });
            
            list.add(tourMenu);
            tourList.getItems().addAll(list);
            //tourList.getItems().add(tourMenu);
            tourZahl--;


        }
        
    }
    
}
