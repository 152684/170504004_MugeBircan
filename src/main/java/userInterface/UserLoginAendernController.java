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
public class UserLoginAendernController implements Initializable {
    Chef currentChef; /**< aktueller chef*/
    Mitarbeiter currentMit; /**< aktueller Mitarbeiter*/
    int currentTyp = 0; /**<1 falls der aktuelle User Chef ist, 2 falls Mitarbeiter ist*/
    boolean neuReg; /**<true falls neu registriert is, false andernfalls*/

    @FXML
    private TextField neuUserName;
    @FXML
    private TextField neuPass;
    @FXML
    private TextArea textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * aktueller Chef anlegen
     * @param c -- Chef
     */
    public void LoginCurrentChef(Chef c){   
        currentChef = c;
        currentTyp = 1;
        neuReg = c.getNeuRegister();
        if(neuReg){
            textField.setText("Bitte ändern Sie Ihre Login Daten bevor fortzufahren.");
        }
    }
    
    /**
     * aktueller Mitarbeiter anlegen
     * @param m -- Mitarbeiter
     */
    public void LoginCurrentMit(Mitarbeiter m){   
        currentMit = m;
        currentTyp = 2;
        neuReg = m.getNeuRegister();
        if(neuReg){
            textField.setText("Bitte ändern Sie Ihre Login Daten bevor fortzufahren.");
        }
    }

    /**
     * Wenn OK Button gelicked wird, werden die Daten aktualisiert
     * @param event 
     */
    @FXML
    private void buttonOK(ActionEvent event) {
        String user = neuUserName.getText();
        String pass = neuPass.getText();  
        boolean anderungGemacht = false;
        if(currentTyp == 1){
            anderungGemacht = currentChef.setLogin(user, pass, currentTyp);
            if(anderungGemacht){
                textField.setText("Login Daten wurden erfolgreich aktualisiert!");            
            }else{
                textField.setText("Login Daten konnten nicht aktualisiert werden!");                
            }              
        }else if(currentTyp == 2){
            anderungGemacht = currentMit.setLogin(user, pass, currentTyp);
            if(anderungGemacht){
                textField.setText("Login Daten wurden erfolgreich aktualisiert!");            
            }else{
                textField.setText("Login Daten konnten nicht aktualisiert werden!");                
            }
        }       
    }   
}
