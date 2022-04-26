/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class In202fxmlController implements Initializable {

    @FXML
    private PasswordField passID;
    @FXML
    private TextField userID;
    @FXML
    private TextArea sceneText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void passIN(ActionEvent event) {
        System.out.println("passIN icinde");
                
        String pwd = passID.getText();
        if(pwd.equals("abc123")) {
            System.out.println("sifre doğru");
            sceneText.setText("richtiges Einloggen");
         } else {
            System.out.println("sifre yanlis");
            sceneText.setText("falseche Eingabe");
         }  
    }

    @FXML
    private void userIN(ActionEvent event) {
        System.out.println("userIN icinde");
                
        String pwd = userID.getText();
        if(pwd.equals("muge")) {
            System.out.println("user doğru");
            sceneText.setText("richtiges Einloggen");
         } else {
            System.out.println("user yanlis");
            sceneText.setText("falseche Eingabe");
         }  
        
    }
    
}
