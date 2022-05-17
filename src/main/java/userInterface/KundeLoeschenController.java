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
public class KundeLoeschenController implements Initializable {
    Chef currentChef;
    Mitarbeiter currentMit;
    int currentTyp = 0; //chef=1, mit=2
 
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

    @FXML
    private void burgerIDIN(ActionEvent event) {
    }

    @FXML
    private void buttonOK(ActionEvent event) {
        long burgerID = Long.parseLong(this.burgerID.getText());

        boolean loeschErfolg = false;
        if(currentTyp == 1){
            loeschErfolg = currentChef.deleteKunde(burgerID);
            if(loeschErfolg){
                textArea.setText("Der Kunde mit der burgerID " + burgerID + " wird geloescht.");                
            }else{
                textArea.setText("Der Kunde mit der burgerID " + burgerID + " kann nicht geloescht werden.");            
            }
        }else if(currentTyp == 2){
            loeschErfolg = currentMit.deleteKunde(burgerID);
            if(loeschErfolg){
                textArea.setText("Der Kunde mit der burgerID " + burgerID + " wird geloescht.");                
            }else{
                textArea.setText("Der Kunde mit der burgerID " + burgerID + " kann nicht geloescht werden.");            
            }
        }else{
            textArea.setText("Der Kunde mit der burgerID " + burgerID + " kann nicht geloescht werden.");            
        }
        
    }

    public void kundeLoesch(Mitarbeiter m){
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void kundeLoesch(Chef c){
        currentChef = c;
        currentTyp = 1;                
    }

    
}
