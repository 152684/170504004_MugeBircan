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


    public void kundeHinzu(Mitarbeiter m){
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void kundeHinzu(Chef c){
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
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }     

        boolean insertErfolg = false;
        if(currentTyp == 1){
            insertErfolg = currentChef.setKunde(name, burgerID, anschrift, email, tel, geburtsDatum);
            if(insertErfolg){
                textField.setText("Der Kunde mit den Namen " + name + " wird gespeichert.");                
            }else{
                textField.setText("Der Kunde mit den Namen " + name + " kann nicht gespeichert werden.");            
            }
        }else if(currentTyp == 2){
            insertErfolg = currentMit.setKunde(name, burgerID, anschrift, email, tel, geburtsDatum);
            if(insertErfolg){
                textField.setText("Der Kunde mit den Namen " + name + " wird gespeichert.");                
            }else{
                textField.setText("Der Kunde mit den Namen " + name + " kann nicht gespeichert werden.");            
            }
        }else{
            textField.setText("Der Kunde mit den Namen " + name + " kann nicht gespeichert werden.");            
        }        
    }

    public void kundeAkt(Mitarbeiter m){
        textField.setText("Lassen Sie den Geburtsdatumfeld leer. (Der Geburtsdatum kann nicht aktualisiert werden und irgendeine Eingabe bei diesem Feld wird vernachlässigt.");
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void kundeAkt(Chef c){
        textField.setText("Lassen Sie den Geburtsdatumfeld leer. (Der Geburtsdatum kann nicht aktualisiert werden und irgendeine Eingabe bei diesem Feld wird vernachlässigt.");
        currentChef = c;
        currentTyp = 1;                
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
            currentChef.updateKundenInfo(name, burgerID, anschrift, email, tel);
            textField.setText("Der Kunde mit den Namen " + name + " wird aktualisiert.");

        }else if(currentTyp == 2){
            currentMit.updateKundenInfo(name, burgerID, anschrift, email, tel);
            textField.setText("Der Kunde mit den Namen " + name + " wird aktualisiert.");
        }else{
            textField.setText("Der Kunde mit den Namen " + name + " kann nicht aktualisiert werden.");            
        }        

    }
    public void ReiseLHin(Mitarbeiter m){
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void ReiseLHin(Chef c){
        currentChef = c;
        currentTyp = 1;                
    }

        public void ReiseLAkt(Mitarbeiter m){
        textField.setText("Lassen Sie den Geburtsdatumfeld leer. (Der Geburtsdatum kann nicht aktualisiert werden und irgendeine Eingabe bei diesem Feld wird vernachlässigt.");
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void ReiseLAkt(Chef c){
        textField.setText("Lassen Sie den Geburtsdatumfeld leer. (Der Geburtsdatum kann nicht aktualisiert werden und irgendeine Eingabe bei diesem Feld wird vernachlässigt.");
        currentChef = c;
        currentTyp = 1;                
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
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }     

        boolean insertErfolg = false;
        if(currentTyp == 1){
            insertErfolg = currentChef.setReiseL(name, burgerID, anschrift, email, tel, geburtsDatum);
            if(insertErfolg){
                textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " wird gespeichert.");                
            }else{
                textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " kann nicht gespeichert werden.");            
            }
        }else if(currentTyp == 2){
            insertErfolg = currentMit.setKunde(name, burgerID, anschrift, email, tel, geburtsDatum);
            if(insertErfolg){
                textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " wird gespeichert.");                
            }else{
                textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " kann nicht gespeichert werden.");            
            }
        }else{
            textField.setText("Der ReiseLeiter mit der burgerID " + burgerID + " kann nicht gespeichert werden.");            
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
            currentChef.updateReiseLInfo(name, anschrift, email, tel, burgerID);
            textField.setText("Der ReiseLeiter mit der BurgerID " + burgerID + " wird aktualisiert.");

        }else if(currentTyp == 2){
            currentMit.updateReiseLInfo(name, anschrift, email, tel, burgerID);
            textField.setText("Der ReiseLeiter mit der BurgerID " + burgerID + " wird aktualisiert.");
        }else{
            textField.setText("Der ReiseLeiter mit der BurgerID " + burgerID + " kann nicht aktualisiert werden.");            
        }        
    }
}
