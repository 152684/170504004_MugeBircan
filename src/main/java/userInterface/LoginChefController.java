/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import databaseFunctions.SelectRecords;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class LoginChefController implements Initializable {
    Chef currentUser;

    @FXML
    private TextArea sceneText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void LoginDatenAendern(ActionEvent event) {
        System.out.println("Login daten andern");
    }

    public void fromLogin(long id){
        System.out.println("from login");
        //currentUser = SelectRecords.findChef(id);

        sceneText.setText("Willkommen Herr/Frau Chef" );
    }

    @FXML
    private void loginDatenAendern(ActionEvent event) {
        
    }

    @FXML
    private void chefHinzu(ActionEvent event) {
    }

    @FXML
    private void chefLoeschen(ActionEvent event) {
    }

    @FXML
    private void mitarbHinzu(ActionEvent event) {
    }

    @FXML
    private void mitarbLoeschen(ActionEvent event) {
    }

    @FXML
    private void kundeHinzu(ActionEvent event) {
    }

    @FXML
    private void kundeLoeschen(ActionEvent event) {
    }
}
