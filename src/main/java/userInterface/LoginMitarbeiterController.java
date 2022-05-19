/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import databaseFunctions.SelectRecords;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class LoginMitarbeiterController implements Initializable {

    Mitarbeiter currentUser;
    
    @FXML
    private TextArea sceneText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void fromLogin(long id) throws UngueltigeIDException{
        currentUser = SelectRecords.findMitarbeiter(id);
        sceneText.setText("Willkommen Herr/Frau " + currentUser.getName() );
    }

    
    @FXML
    private void loginDatenAendern(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLoginAendern.fxml"));
            Parent root = loader.load();
            //The following both lines are the only addition we need to pass the arguments
            UserLoginAendernController controller2 = loader.getController();
            controller2.LoginCurrentMit(currentUser);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Daten Aendern");
            stage.show();
                
        }catch(IOException e){
            e.printStackTrace();
        }
 
    }

    @FXML
    private void kundeReiseLHinzuAkt(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeHinzufuegen.fxml"));
            Parent root = loader.load();
            //The following both lines are the only addition we need to pass the arguments
            KundeHinzufuegenController controller2 = loader.getController();
            controller2.currentAnlegen(currentUser);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
                
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void kundeReiseLLoeschen(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeLoeschen.fxml"));
            Parent root = loader.load();
            //The following both lines are the only addition we need to pass the arguments
            KundeLoeschenController controller2 = loader.getController();
            controller2.currentAnlegen(currentUser);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
                
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void tourHinzuAktLoesch(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TourHinzuLoesch.fxml"));
            Parent root = loader.load();
            //The following both lines are the only addition we need to pass the arguments
            TourHinzuLoeschController controller2 = loader.getController();
            controller2.currentAnlegen(currentUser);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
                
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
