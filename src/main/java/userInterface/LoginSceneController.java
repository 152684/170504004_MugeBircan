/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField userID;
    @FXML
    private PasswordField passID;
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
    private void userIN(ActionEvent event) {
    }

    @FXML
    private void passIN(ActionEvent event) {
        String user = userID.getText();
        String pwd = passID.getText();
        long id = Login.loginRichtig(user, pwd);
        if(id != 0){
            sceneText.setText("richtige Eingabe");
        }else{
            sceneText.setText("falseche Eingabe");
        }
    }
    
    
}
