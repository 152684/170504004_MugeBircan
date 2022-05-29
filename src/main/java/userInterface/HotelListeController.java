/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.Hotel;
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
import static userInterface.TableViewTestController.table_info_app;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class HotelListeController implements Initializable {

    private ObservableList<Hotel> hotelData = FXCollections.observableArrayList();
    public static TableView<Hotel> table_info_app;
    @FXML
    private TableView<Hotel> hotelTable;
    @FXML
    private TableColumn<Hotel, String> nameColumn;
    @FXML
    private TableColumn<Hotel, String> anschriftColumn;
    @FXML
    private TableColumn<Hotel, Integer> telColumn;
    @FXML
    private TableColumn<Hotel, String> emailColumn;
    @FXML
    private TableColumn<Hotel, Float> preisColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table_info_app = hotelTable;
        initializeCols();
        loadData();
    }    

    private void initializeCols(){
      
      nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      anschriftColumn.setCellValueFactory(new PropertyValueFactory<>("anschrift"));
      emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
      telColumn.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
      preisColumn.setCellValueFactory(new PropertyValueFactory<>("preis"));
    }   
    
    private void loadData(){
        ArrayList<String> hotels = new ArrayList();
        int hotelZahl = SelectRecords.hotelNamenInArray(hotels);
        Iterator<String> iter = hotels.iterator();
        
        
        while(hotelZahl != 0){
            Hotel currentHotel = SelectRecords.findHotel(iter.next());
            if(currentHotel != null){
                System.out.println(currentHotel.getTel());
            }else{
                System.out.println("null pointer");
            }
            hotelData.add(currentHotel); 
            
            hotelZahl--;
        }

        hotelTable.setItems(hotelData);
    }    
            
}
