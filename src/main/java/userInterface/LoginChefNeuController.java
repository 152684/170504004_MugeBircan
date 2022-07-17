/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.Chef;
import databaseFunctions.SelectRecords;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class LoginChefNeuController implements Initializable {
    
    Chef currentUser; /**< aktueller chef*/

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label labelUser;
    @FXML
    private Label labelTyp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void fromLogin(long id){
        currentUser = SelectRecords.findChef(id);
        labelUser.setText(currentUser.getName().toUpperCase());
        labelTyp.setText("Chef");        
    }

    @FXML
    private void logout(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void eigeneDatenMouseClc(MouseEvent event) {
        loadFenster("UserLoginAendern");
    }

    @FXML
    private void arbeiterMouseClc(MouseEvent event) {
        loadFenster("ChefMitarbHinzufuegen");
    }

    @FXML
    private void personenMouseCLc(MouseEvent event) {
        loadFenster("KundeHinzufuegen");
    }

    @FXML
    private void tourMouseClc(MouseEvent event) {
        loadFenster("TourHinzuLoesch");
    }

    @FXML
    private void hotelMouseClc(MouseEvent event) {
        loadFenster("HotelFunktionen");
    }
    
    private void loadFenster(String fenster){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fenster + ".fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            pane.setLayoutX(160);
            pane.setLayoutY(140);
            anchorPane.getChildren().set(2, pane);
            
            switch(fenster){
                case "UserLoginAendern":
                    UserLoginAendernController controller = loader.getController();
                    controller.LoginCurrentChef(currentUser);            
                break;
                case "ChefMitarbHinzufuegen":
                    ChefMitarbHinzufuegenController controller1 = loader.getController();
                    controller1.currentAnlegen(currentUser);            
                    break;
                case "KundeHinzufuegen":
                    KundeHinzufuegenController controller2 = loader.getController();
                    controller2.currentAnlegen(currentUser);            
                    break;
                case "TourHinzuLoesch":
                    TourHinzuLoeschController controller3 = loader.getController();
                    controller3.currentAnlegen(currentUser);            
                    break;
                case "HotelFunktionen":
                    HotelFunktionenController controller4 = loader.getController();
                    controller4.currentAnlegen(currentUser);            
                    break;
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginChefNeuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
