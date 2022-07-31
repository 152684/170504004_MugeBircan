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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane anchorLogin;

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

    /**
     * Wenn beim Passwort Field an Enter-Taste gedruecht wird, werden die Daten ueberprueft und falls richtig der User eingeloggt
     * @param event
     */
    @FXML
    private void passIN(ActionEvent event) 
    {
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
                Chef chef = SelectRecords.findChef(id);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginChefNeu.fxml"));
                Parent root = loader.load();                
                Stage stage = (Stage) anchorLogin.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

                //The following both lines are the only addition we need to pass the arguments
                LoginChefNeuController controller2 = loader.getController();
                controller2.fromLogin(id, chef.getNeuRegister());                
            }catch(IOException e){
                e.printStackTrace();
            }
        }else if(loginType == 2){
            sceneText.setText("richtige Eingabe. Willkommen " + user);
            try{
                Mitarbeiter m = SelectRecords.findMitarbeiter(id);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginMitNeu.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) anchorLogin.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                //The following both lines are the only addition we need to pass the arguments
                LoginMitNeuController controller2 = loader.getController();
                controller2.fromLogin(id, m.getNeuRegister());
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            sceneText.setText("falseche Eingabe");            
        }
        
    }

    @FXML
    private void turnOff(MouseEvent event) {
        Stage stage = (Stage) anchorLogin.getScene().getWindow();
        stage.close();
    }
    
    
}
