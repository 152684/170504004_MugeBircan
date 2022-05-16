/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import databaseFunctions.SelectRecords;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
    private void passIN(ActionEvent event) throws UngueltigeIDException{
        //für Chef wird loginType = 1, für Mitarbeiter = 2 
        String user = userID.getText();
        String pwd = passID.getText();
        long id = Login.loginRichtig(user, pwd);
        int loginType = 0;
        
        ArrayList<Chef> chefs = new ArrayList();        
        SelectRecords.allChefInArray(chefs);
        
        Iterator<Chef> c = chefs.iterator();
        while(c.hasNext()){
            if(c.next().getBurgerID() == id){
                loginType = 1;
            }
        }
        if(loginType == 0){
            ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();
            SelectRecords.allMitarbeiterInArray(mitarbeitern);
            Iterator<Mitarbeiter> m = mitarbeitern.iterator();
            while(m.hasNext()){
                if(m.next().getBurgerID() == id){
                    loginType = 2;
                }
            }
        }
        
        if(loginType == 1){
            sceneText.setText("richtige Eingabe. Willkommen " + user);
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginChef.fxml"));
                Parent root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
                LoginChefController controller2 = loader.getController();
                controller2.fromLogin(id);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Layout2 + Controller2");
                stage.show();
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }else if(loginType == 2){
            sceneText.setText("richtige Eingabe. Willkommen " + user);
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginMitarbeiter.fxml"));
                Parent root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
                LoginMitarbeiterController controller2 = loader.getController();
                //controller2.fromLogin();
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
