/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class KundeHinzufuegenController implements Initializable {
    Chef currentChef;
    Mitarbeiter currentMit;
    int currentTyp = 0; //chef=1, mit=2
    
    @FXML
    private TextField name;
    @FXML
    private TextField burgerID;
    @FXML
    private TextField anschrift;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField geburt;
    @FXML
    private TextArea textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nameIN(ActionEvent event) {
    }

    @FXML
    private void burgerIDIN(ActionEvent event) {
    }

    @FXML
    private void anschriftIN(ActionEvent event) {
    }

    @FXML
    private void emailIN(ActionEvent event) {
    }

    @FXML
    private void telIN(ActionEvent event) {
    }

    @FXML
    private void geburtIN(ActionEvent event) {
    }

    @FXML
    private void buttonOK(ActionEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String name = this.name.getText();
        long burgerID = Long.parseLong(this.burgerID.getText());
        String anschrift = this.anschrift.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(this.tel.getText());
        String g = this.geburt.getText();
        Date geburtsDatum = null;
        try{
            geburtsDatum = dateFormat.parse(g);        
        }catch(ParseException e){
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }             
        
    }
    
}
