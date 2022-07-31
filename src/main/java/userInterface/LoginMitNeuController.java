/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.Mitarbeiter;
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
public class LoginMitNeuController implements Initializable {
    
    Mitarbeiter currentUser; /**< aktueller mitarbeiter*/

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

    public void fromLogin(long id, boolean neuReg){
        currentUser = SelectRecords.findMitarbeiter(id);
        labelUser.setText(currentUser.getName().toUpperCase());
        labelTyp.setText("Mitarbeiter");        
        if(neuReg){
            loadFenster("UserLoginAendern");        
        }
    }

    @FXML
    private void logout(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
            Parent root = loader.load();                
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            LoginSceneController controller2 = loader.getController();                
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void eigeneDatenMouseClc(MouseEvent event) {
        loadFenster("UserLoginAendern");
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
            pane.setLayoutX(160);
            pane.setLayoutY(140);
            anchorPane.getChildren().set(2, pane);
            
            switch(fenster){
                case "UserLoginAendern":
                    UserLoginAendernController controller = loader.getController();
                    controller.LoginCurrentMit(currentUser);            
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
