/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.ReiseLeiter;
import com.mycompany.inf202.UngueltigeIDException;
import databaseFunctions.SelectRecords;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class ReiseLeitListeController implements Initializable {

    private ObservableList<ReiseLeiter> reiseLData = FXCollections.observableArrayList();
    public static TableView<ReiseLeiter> table_info_app;

    @FXML
    private TableView<ReiseLeiter> reiseLeitTable;
    @FXML
    private TableColumn<ReiseLeiter, String> nameColumn;
    @FXML
    private TableColumn<ReiseLeiter, Long> burgerIdColumn;
    @FXML
    private TableColumn<ReiseLeiter, String> anschriftColumn;
    @FXML
    private TableColumn<ReiseLeiter, String> emailColumn;
    @FXML
    private TableColumn<ReiseLeiter, Integer> telColumn;
    @FXML
    private TableColumn<ReiseLeiter, String> geburtColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table_info_app = reiseLeitTable;
        initializeCols();
        try {        
            loadData();
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(MitarbeiterListeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 
    private void initializeCols(){
      
      nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      burgerIdColumn.setCellValueFactory(new PropertyValueFactory<>("burgerID"));
      anschriftColumn.setCellValueFactory(new PropertyValueFactory<>("anschrift"));
      emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
      telColumn.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
      geburtColumn.setCellValueFactory(new PropertyValueFactory<>("geburtsdatum"));
    }   
    
    private void loadData() throws UngueltigeIDException{

        ArrayList<ReiseLeiter> reiseLeitern = new ArrayList();
        SelectRecords.allReiseLInArray(reiseLeitern);
        Iterator<ReiseLeiter> iter = reiseLeitern.iterator();
                
        while(iter.hasNext()){
            reiseLData.add(iter.next());
        }

        reiseLeitTable.setItems(reiseLData);
    }    
}
