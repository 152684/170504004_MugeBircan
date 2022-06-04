/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.Tour;
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

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class ToursTableController implements Initializable {

    private ObservableList<Tour> tourData = FXCollections.observableArrayList();
    public static TableView<Tour> table_info_app;

    @FXML
    private TableView<Tour> toursTable;
    @FXML
    private TableColumn<Tour, String> tourNameColumn;
    @FXML
    private TableColumn<Tour, String> tourDatumColumn;
    @FXML
    private TableColumn<Tour, String> tourInfoColumn;
    @FXML
    private TableColumn<Tour, String> reiseLColumn;
    @FXML
    private TableColumn<Tour, String> hotelNameColumn;
    @FXML
    private TableColumn<Tour, Integer> maxTColumn;
    @FXML
    private TableColumn<Tour, Integer> freiePColumn;
    @FXML
    private TableColumn<Tour, Float> preisColumn;
    @FXML
    private TableColumn<Tour, String> kundenColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table_info_app = toursTable;
        initializeCols();
        loadData();
    }    
    
    private void initializeCols(){
      
      tourNameColumn.setCellValueFactory(new PropertyValueFactory<>("tourName"));
      tourDatumColumn.setCellValueFactory(new PropertyValueFactory<>("tourDatum"));
      tourInfoColumn.setCellValueFactory(new PropertyValueFactory<>("tourInfo"));
      preisColumn.setCellValueFactory(new PropertyValueFactory<>("preis"));
      reiseLColumn.setCellValueFactory(new PropertyValueFactory<>("reiseL"));
      hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
      maxTColumn.setCellValueFactory(new PropertyValueFactory<>("maxTeilnehmer"));
      freiePColumn.setCellValueFactory(new PropertyValueFactory<>("freiePlaetze"));
      kundenColumn.setCellValueFactory(new PropertyValueFactory<>("kunden"));
    }   
    
    private void loadData(){

        ArrayList<String> tourNamen = new ArrayList();
        int tourZahl = SelectRecords.tourNamenInArray(tourNamen);
        Iterator<String> iter = tourNamen.iterator();
        
        
        while(tourZahl != 0){
            Tour currentTour = SelectRecords.findTour(iter.next());
            tourData.add(currentTour);  
            tourZahl--;
        }

        toursTable.setItems(tourData);
    }    

}
