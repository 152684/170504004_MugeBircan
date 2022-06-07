/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.Chef;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class ChefMitarbHinzufuegenController implements Initializable {
    
    Chef currentUser;

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
    @FXML
    private TextField userName;
    @FXML
    private TextField passwort;
    @FXML
    private TextField persID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    public void currentAnlegen(Chef c){
        textField.setText("Lassen Sie den Geburtsdatumfeld leer fuers Aktualisieren. (Der Geburtsdatum kann nicht aktualisiert werden und irgendeine Eingabe bei diesem Feld wird vernachlässigt.");
        currentUser = c;
    }

    @FXML
    private void chefHinButton(ActionEvent event) {
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
            textField.setText("Der eingegebene Datum ist nicht gueltig.\nGeben Sie den Datum in folgendes Format ein: 'TT.MM.JJJJ'");
        }   
        String user = this.userName.getText();
        String pass = this.passwort.getText();
        int persID = Integer.parseInt(this.persID.getText());

        if(burgerID < 99999999999L && burgerID > 10000000000L){
            boolean insertErfolg = false;
            insertErfolg = currentUser.setChef(name, burgerID, anschrift, email, tel, geburtsDatum, persID, user, pass);
            if(insertErfolg){
                textField.setText("Der Chef mit den Namen " + name + " wird gespeichert.");                            
            }else{
                textField.setText("Der Chef mit den Namen " + name + " existiert schon.");                        
            }
        }else{
            textField.setText("Die Bürger ID darf nur eine 11 stellige Zahl sein.");
        }

    }

    @FXML
    private void chefAktButton(ActionEvent event) {
        String name = this.name.getText();
        long burgerID = Long.parseLong(this.burgerID.getText());
        String anschrift = this.anschrift.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(this.tel.getText());
        
        currentUser.updateChef(name, anschrift, email, tel, burgerID);
    }

    @FXML
    private void MitHinButton(ActionEvent event) {
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
            textField.setText("Der eingegebene Datum ist nicht gültig.\nGeben Sie den Datum in folgendes Format ein: 'TT.MM.JJJJ'");
        }   
        String user = this.userName.getText();
        String pass = this.passwort.getText();
        int persID = Integer.parseInt(this.persID.getText());

        if(burgerID < 99999999999L && burgerID > 10000000000L){
            boolean insertErfolg = false;
            insertErfolg = currentUser.setMitarb(name, burgerID, anschrift, email, tel, geburtsDatum, persID, user, pass);
            if(insertErfolg){
                textField.setText("Der Mitarbeiter mit den Namen " + name + " wird gespeichert.");                            
            }else{
                textField.setText("Der Mitarbeiter mit den Namen " + name + " existiert schon.");                        
            }            
        }else{
            textField.setText("Die B[rger ID darf nur eine 11 stellige Zahl sein");
        }
    }

    @FXML
    private void MitAktButton(ActionEvent event) {
        String name = this.name.getText();
        long burgerID = Long.parseLong(this.burgerID.getText());
        String anschrift = this.anschrift.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(this.tel.getText());
        
        currentUser.updateMitarb(name, anschrift, email, tel, burgerID);

    }

    @FXML
    private void chefLoeschButton(ActionEvent event) {
        long burgerID = Long.parseLong(this.burgerID.getText());
        
        boolean loeschErfolg = currentUser.deleteChef(burgerID);
        if(loeschErfolg){
            textField.setText("Der Chef mit der burgerID " + burgerID + " wird geloescht.");                            
        }else{
            textField.setText("Der Chef mit der burgerID " + burgerID + " existiert nicht.");                        
        }
    }

    @FXML
    private void mitarbLoeschButton(ActionEvent event) {
        long burgerID = Long.parseLong(this.burgerID.getText());
        
        boolean loeschErfolg = currentUser.deleteMitarb(burgerID);
        if(loeschErfolg){
            textField.setText("Der Mitarbeiter mit der burgerID " + burgerID + " wird geloescht.");                            
        }else{
            textField.setText("Der Mitarbeiter mit der burgerID " + burgerID + " existiert nicht.");                        
        }
    }
    
}
