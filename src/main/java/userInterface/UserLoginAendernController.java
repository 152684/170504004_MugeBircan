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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class UserLoginAendernController implements Initializable {

    @FXML
    private TextField neuUserName;
    @FXML
    private TextField neuPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void userNameIn(ActionEvent event) {
    }

    @FXML
    private void neuPassIn(ActionEvent event) {        
    }
    
    public void LoginChefAendern(Chef c){
        String user = neuUserName.getText();
        String pass = neuPass.getText();
        c.setLogin(user, pass);
    }
    
}
