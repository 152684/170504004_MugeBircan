/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import databaseFunctions.UpdateRecords;
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


    public void currentAnlegen(Mitarbeiter m){
        textField.setText("Lassen Sie den Geburtsdatumfeld leer fuers Aktualisieren. (Der Geburtsdatum kann nicht aktualisiert werden und irgendeine Eingabe bei diesem Feld wird vernachlässigt.");
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void currentAnlegen(Chef c){
        textField.setText("Lassen Sie den Geburtsdatumfeld leer fuers Aktualisieren. (Der Geburtsdatum kann nicht aktualisiert werden und irgendeine Eingabe bei diesem Feld wird vernachlässigt.");
        currentChef = c;
        currentTyp = 1;                
    }

    @FXML
    private void kundeHin(ActionEvent event) {
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

        if(burgerID < 99999999999L && burgerID > 10000000000L){
            boolean insertErfolg = false;
            if(currentTyp == 1){
                insertErfolg = currentChef.setKunde(name, burgerID, anschrift, email, tel, geburtsDatum);
                if(insertErfolg){
                    textField.setText("Der Kunde mit den Namen " + name + " wird gespeichert.");                
                }else{
                    textField.setText("Der Kunde mit den Namen " + name + " existiert schon.");            
                }
            }else if(currentTyp == 2){
                insertErfolg = currentMit.setKunde(name, burgerID, anschrift, email, tel, geburtsDatum);
                if(insertErfolg){
                    textField.setText("Der Kunde mit den Namen " + name + " wird gespeichert.");  
                    UpdateRecords.updateMitarbeiterErfolg(currentMit.getBurgerID(), 1);
                }else{
                    textField.setText("Der Kunde mit den Namen " + name + " existiert schon.");            
                }
            }else{
                textField.setText("Der Kunde mit den Namen " + name + " kann nicht gespeichert werden.");            
            }                    
        }else{
            textField.setText("Die Bürger ID darf nur eine 11 stellige Zahl sein!");                        
        }
    }
  
    @FXML
    private void kundeAkt(ActionEvent event) {        
        String name = this.name.getText();
        long burgerID = Long.parseLong(this.burgerID.getText());
        String anschrift = this.anschrift.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(this.tel.getText());

        boolean updateErfolg = false;
        if(currentTyp == 1){
            updateErfolg = currentChef.updateKundenInfo(name, burgerID, anschrift, email, tel);            
        }else if(currentTyp == 2){
            updateErfolg = currentMit.updateKundenInfo(name, burgerID, anschrift, email, tel);            
        }
        
        if(updateErfolg){
            textField.setText("Der Kunde mit den Namen " + name + " wird aktualisiert.");
        }else{
            textField.setText("Der Kunde mit den Namen " + name + " existiert nicht");
        }

    }

    @FXML
    private void reiseLHinButton(ActionEvent event) {
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

        if(burgerID < 99999999999L && burgerID > 10000000000L){
            boolean insertErfolg = false;
            if(currentTyp == 1){
                insertErfolg = currentChef.setReiseL(name, burgerID, anschrift, email, tel, geburtsDatum);
                if(insertErfolg){
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " wird gespeichert.");                
                }else{
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " existiert schon.");            
                }
            }else if(currentTyp == 2){
                insertErfolg = currentMit.setReiseL(name, burgerID, anschrift, email, tel, geburtsDatum);
                if(insertErfolg){
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " wird gespeichert.");                
                }else{
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " existiert schon.");            
                }
            }else{
                textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " kann nicht gespeichert werden.");            
            }        
            
        }else{
            textField.setText("Die Bürger ID darf nur eine 11 stellige Zahl sein.");                        
        }
                    
    }

    @FXML
    private void reiseLAktButton(ActionEvent event) {
        String name = this.name.getText();
        long burgerID = Long.parseLong(this.burgerID.getText());
        String anschrift = this.anschrift.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(this.tel.getText());

        boolean updateErfolg = false;
        if(currentTyp == 1){
            updateErfolg = currentChef.updateReiseLInfo(name, anschrift, email, tel, burgerID);
        }else if(currentTyp == 2){
            updateErfolg = currentMit.updateReiseLInfo(name, anschrift, email, tel, burgerID);
        }

        if(updateErfolg){
            textField.setText("Der ReiseLeiter mit den Namen " + name + " wird aktualisiert.");
        }else{
            textField.setText("Der ReiseLeiter mit den Namen " + name + " existiert nicht");
        }
       
    }

    @FXML
    private void kundeLoeschButton(ActionEvent event) {
        long burgerID = Long.parseLong(this.burgerID.getText());

        boolean loeschErfolg = false;
        switch (currentTyp) {
            case 1:
                loeschErfolg = currentChef.deleteKunde(burgerID);
                if(loeschErfolg){
                    textField.setText("Der Kunde mit der burgerID " + burgerID + " wird geloescht.");
                }else{
                    textField.setText("Der Kunde mit der burgerID " + burgerID + " existiert nicht.");
                }   break;
            case 2:
                loeschErfolg = currentMit.deleteKunde(burgerID);
                if(loeschErfolg){
                    textField.setText("Der Kunde mit der burgerID " + burgerID + " wird geloescht.");
                    UpdateRecords.updateMitarbeiterErfolg(currentMit.getBurgerID(), 2);
                }else{
                    textField.setText("Der Kunde mit der burgerID " + burgerID + " existiert nicht.");
                }   break;
            default:            
                textField.setText("Der Kunde mit der burgerID " + burgerID + " kann nicht geloescht werden.");
                break;
        }
    }

    @FXML
    private void reiseLeitLoeschButton(ActionEvent event) {
        long burgerID = Long.parseLong(this.burgerID.getText());

        boolean loeschErfolg = false;
        switch (currentTyp) {
            case 1:
                loeschErfolg = currentChef.deleteReiseL(burgerID);
                if(loeschErfolg){
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " wird geloescht.");
                }else{
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " existiert nicht.");
                }   break;
            case 2:
                loeschErfolg = currentMit.deleteReiseL(burgerID);
                if(loeschErfolg){
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " wird geloescht.");
                }else{
                    textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " existiert nicht.");
                }   break;
            default:            
                textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " kann nicht geloescht werden.");
                break;
        }
    }
}
