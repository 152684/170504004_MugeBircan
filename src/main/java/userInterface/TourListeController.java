/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import databaseFunctions.SelectRecords;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class TourListeController implements Initializable {
    
    ObservableList list = FXCollections.observableArrayList();
    Chef currentChef; /**< aktueller chef*/
    Mitarbeiter currentMit; /**< aktueller Mitarbeiter*/
    int currentTyp = 0; /**<1 falls der aktuelle User Chef ist, 2 falls Mitarbeiter ist*/

    @FXML
    private ListView<String> tourList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addTour();
    }    
 
    /**
     * aktueller Mitarbeiter anlegen
     * @param m -- Mitarbeiter
     */
    public void currentAnlegen(Mitarbeiter m){
        currentMit = m;
        currentTyp = 2;        
    }
    
    /**
     * aktueller Chef anlegen
     * @param c -- Chef
     */
    public void currentAnlegen(Chef c){
        currentChef = c;
        currentTyp = 1;                
    }

    /**
     * Liste den Tour erstellen
     */
    private void addTour(){
        list.removeAll(list);
        
        ArrayList<String> tours = new ArrayList();
        int tourZahl = SelectRecords.tourNamenInArray(tours);
        Iterator<String> iter = tours.iterator();
        
        while(tourZahl != 0){    
            
            String a = iter.next();
            list.add(a);
            tourZahl--;
        }
        tourList.getItems().addAll(list);

    }

    /**
     * Wenn ein Tour mit dem Klicken gewaehlt wird
     * @param event 
     */
    @FXML
    private void listMouseClicked(MouseEvent event) {
        String a = tourList.getSelectionModel().getSelectedItem();
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FromTourList.fxml"));
            Parent root = loader.load();
            //The following both lines are the only addition we need to pass the arguments
            FromTourListController controller2 = loader.getController();
            if(currentTyp == 1){
                controller2.currentAnlegen(currentChef);                
            }else{
                controller2.currentAnlegen(currentMit);                                
            }
            controller2.fromTourList(a);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
                
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    
}
