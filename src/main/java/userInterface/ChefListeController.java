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
public class ChefListeController implements Initializable {

    private ObservableList<Chef> chefData = FXCollections.observableArrayList();
    public static TableView<Chef> table_info_app;
    
    @FXML
    private TableView<Chef> chefTable;
    @FXML
    private TableColumn<Chef, String> nameColumn;
    @FXML
    private TableColumn<Chef, Long> burgerIdColumn;
    @FXML
    private TableColumn<Chef, String> anschriftColumn;
    @FXML
    private TableColumn<Chef, String> emailColumn;
    @FXML
    private TableColumn<Chef, Integer> telColumn;
    @FXML
    private TableColumn<Chef, String> geburtColumn;
    @FXML
    private TableColumn<Chef, Integer> persIdColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table_info_app = chefTable;
        initializeCols();
        try {
            loadData();
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(ChefListeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void initializeCols(){
      
      nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      burgerIdColumn.setCellValueFactory(new PropertyValueFactory<>("burgerID"));
      anschriftColumn.setCellValueFactory(new PropertyValueFactory<>("anschrift"));
      emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
      telColumn.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
      geburtColumn.setCellValueFactory(new PropertyValueFactory<>("geburtsdatum"));
      persIdColumn.setCellValueFactory(new PropertyValueFactory<>("personalID"));
    }   
    
    private void loadData() throws UngueltigeIDException{

        ArrayList<Chef> chefs = new ArrayList();
        SelectRecords.allChefInArray(chefs);
        Iterator<Chef> iter = chefs.iterator();
                
        while(iter.hasNext()){
            chefData.add(iter.next());  
        }

        chefTable.setItems(chefData);
    }    
    
}
