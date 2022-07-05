/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import databaseFunctions.SelectRecords;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//import static userInterface.TableViewTestController.table_info_app;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class MitarbeiterListeController implements Initializable {

    private ObservableList<Mitarbeiter> mitarbData = FXCollections.observableArrayList();
    public static TableView<Mitarbeiter> table_info_app;
    
    @FXML
    private TableView<Mitarbeiter> mitarbeiterTable;
    @FXML
    private TableColumn<Mitarbeiter, String> nameColumn;
    @FXML
    private TableColumn<Mitarbeiter, Long> burgerIdColumn;
    @FXML
    private TableColumn<Mitarbeiter, String> anschriftColumn;
    @FXML
    private TableColumn<Mitarbeiter, String> emailColumn;
    @FXML
    private TableColumn<Mitarbeiter, Integer> telColumn;
    @FXML
    private TableColumn<Mitarbeiter, String> geburtColumn;
    @FXML
    private TableColumn<Mitarbeiter, String> persIdColumn;
    @FXML
    private TableColumn<Mitarbeiter, Float> erfolgColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table_info_app = mitarbeiterTable;
        initializeCols();
        loadData();
    }    

    /**
     * Initialisieren den Spalten 
     */
    private void initializeCols(){
      
      nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      burgerIdColumn.setCellValueFactory(new PropertyValueFactory<>("burgerID"));
      anschriftColumn.setCellValueFactory(new PropertyValueFactory<>("anschrift"));
      emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
      telColumn.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
      geburtColumn.setCellValueFactory(new PropertyValueFactory<>("geburtsdatum"));
      persIdColumn.setCellValueFactory(new PropertyValueFactory<>("personalID"));
      erfolgColumn.setCellValueFactory(new PropertyValueFactory<>("erfolgsRate"));
    }   
    
    /**
     * Daten in die Tabelle speichern
     */
    private void loadData() 
    {
        ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();
        SelectRecords.allMitarbeiterInArray(mitarbeitern);
        Iterator<Mitarbeiter> iter = mitarbeitern.iterator();
                
        while(iter.hasNext()){
            mitarbData.add(iter.next());
        }

        mitarbeiterTable.setItems(mitarbData);
    }    
    
}
