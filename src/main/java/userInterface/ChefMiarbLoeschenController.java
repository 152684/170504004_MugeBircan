/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class ChefMiarbLoeschenController implements Initializable {
    Chef currentUser;

    @FXML
    private TextField burgerID;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void currentAnlegen(Chef m){
        currentUser = m;
    }


    @FXML
    private void chefLoeschenButton(ActionEvent event) {
        long burgerID = Long.parseLong(this.burgerID.getText());
        
        boolean loeschErfolg = currentUser.deleteChef(burgerID);
        if(loeschErfolg){
            textArea.setText("Der Chef mit der burgerID " + burgerID + " wird geloescht.");                            
        }else{
            textArea.setText("Der Chef mit der burgerID " + burgerID + " existiert nicht.");                        
        }
    }

    @FXML
    private void mitarbLoeschenButton(ActionEvent event) {
        long burgerID = Long.parseLong(this.burgerID.getText());
        
        boolean loeschErfolg = currentUser.deleteMitarb(burgerID);
        if(loeschErfolg){
            textArea.setText("Der Mitarbeiter mit der burgerID " + burgerID + " wird geloescht.");                            
        }else{
            textArea.setText("Der Mitarbeiter mit der burgerID " + burgerID + " existiert nicht.");                        
        }
    }
    
}
