/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            try{
                System.out.println("in try");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("optionsAfterLogin.fxml"));
                Parent root = loader.load();
                System.out.println("after root");
                //The following both lines are the only addition we need to pass the arguments
                OptionsAfterLoginController controller2 = loader.getController();
                controller2.fromLayout1(sceneText.getText());
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Layout2 + Controller2");
                stage.show();

            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            sceneText.setText("falseche Eingabe");
        }
        
    }
    
    
}
