/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.Chef;
import com.mycompany.inf202.Mitarbeiter;
import java.io.IOException;
import java.net.URL;
//import java.time.ZoneId;
//import java.util.Date;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class ArbeiterFnkNeuController implements Initializable {

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
    private TextField userName;
    @FXML
    private TextField passwort;
    @FXML
    private TextField persID;
    @FXML
    private DatePicker geburt;
    @FXML
    private AnchorPane tableAnchor;
    @FXML
    private ChoiceBox<String> choiceboxArbeiter;    
    @FXML
    private TextArea textArea;

    private String[] arbeiter = {"Chef", "Mitarbeiter"}; /**< choices in the choiceBox>*/
    Chef currentChef; /**< aktueller chef*/
    Mitarbeiter currentMit; /**< aktueller Mitarbeiter*/
    int currentTyp = 0; /**<1 falls der aktuelle User Chef ist, 2 falls Mitarbeiter ist*/
    
    /**
     * Initializes the controller class.
     * sets choiceBox and sets Text in TextArea
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choiceboxArbeiter.getItems().addAll(arbeiter);
        textArea.setText("Wählen Sie Chef oder Arbeiter, um weiterzumachen.");
        choiceboxArbeiter.setOnAction(this::arbeiterTyp);
    }    

    /**
     * aktueller Mitarbeiter anlegen
     * @param m -- Mitarbeiter
     */
    public void currentAnlegen(Mitarbeiter m){
        currentMit = m;
        currentTyp = 2;        
    }
    
    /**
     * aktueller Chef anlegen
     * @param c -- Chef
     */
    public void currentAnlegen(Chef c){
        currentChef = c;
        currentTyp = 1;                
    }

    /**
     * chef oder Mitarbeiter je nach choiceBox choice hinzugefuegt
     * @param event 
     */
    @FXML
    private void hinzuButton(ActionEvent event) {
        String typ = choiceboxArbeiter.getValue();
        if(typ == null){
            textArea.setText("Wählen Sie Chef oder Mitarbeiter!");            
        }else{
            String name = this.name.getText();
            long burgerID = Long.parseLong(this.burgerID.getText());
            String anschrift = this.anschrift.getText();
            String email = this.email.getText();
            int tel = Integer.parseInt(this.tel.getText());
            //Date geburtsDatum = Date.from(geburt.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            Date geburtsDatum = Date.valueOf(geburt.getValue());
            String user = this.userName.getText();
            String pass = this.passwort.getText();
            int persID = Integer.parseInt(this.persID.getText());

            if(burgerID < 99999999999L && burgerID > 10000000000L){
                if(persID < 99999999 && persID > 10000000){
                    boolean insertErfolg = false;                
                    switch (typ){
                        case "Chef":
                            Chef neuC = new Chef(name, burgerID, anschrift, email, tel, geburtsDatum, persID, user, pass);
                            insertErfolg = currentChef.setChefNeu(neuC);
                            //insertErfolg = currentChef.setChef(name, burgerID, anschrift, email, tel, geburtsDatum, persID, user, pass);
                            if(insertErfolg){
                                textArea.setText("Der Chef mit den Namen: " + name + ", BürgerID: " + burgerID + " wird gespeichert.");                            
                            }else{
                                textArea.setText("Der Chef mit den Namen " + name + " existiert schon.");                        
                            }                
                            break;
                        case "Mitarbeiter":
                            Mitarbeiter neuM = new Mitarbeiter(name, burgerID, anschrift, email, tel, geburtsDatum, persID, user, pass);
                            insertErfolg = currentChef.setMitarbNeu(neuM);
                            //insertErfolg = currentChef.setMitarb(name, burgerID, anschrift, email, tel, geburtsDatum, persID, user, pass);
                            if(insertErfolg){
                                textArea.setText("Der Mitarbeiter mit den Namen: " + name + ", BürgerID: " + burgerID + " wird gespeichert.");                            
                            }else{
                                textArea.setText("Der Mitarbeiter mit den Namen " + name + " existiert schon.");                        
                            }                
                            break;
                    }
                }else{
                    textArea.setText("Die PersonalID darf nur eine 8 stellige Zahl sein.");
                }
            }else{
                textArea.setText("Die Bürger ID darf nur eine 11 stellige Zahl sein.");
            }
            
        }
        
    }

    /**
     * 
     * @param event 
     */
    @FXML
    private void aktualisierenButton(ActionEvent event) {
    }

    @FXML
    private void loeschButton(ActionEvent event) {
        boolean loeschErfolg = false;
        String typ = choiceboxArbeiter.getValue();

        if(typ == null){
            textArea.setText("Wählen Sie Chef oder Mitarbeiter!");            
        }else{
            long burgerID;
            switch (typ){
                case "Chef":
                    burgerID = Long.parseLong(this.burgerID.getText());
                    loeschErfolg = currentChef.deleteChef(burgerID);
                    if(loeschErfolg){
                        textArea.setText("Der Chef mit der burgerID " + burgerID + " wird geloescht.");                            
                    }else{
                        textArea.setText("Der Chef mit der burgerID " + burgerID + " existiert nicht.");                        
                    }
                    break;
                case "Mitarbeiter":
                    burgerID = Long.parseLong(this.burgerID.getText());
                    loeschErfolg = currentChef.deleteMitarb(burgerID);
                    if(loeschErfolg){
                        textArea.setText("Der Mitarbeiter mit der burgerID " + burgerID + " wird geloescht.");                            
                    }else{
                        textArea.setText("Der Mitarbeiter mit der burgerID " + burgerID + " existiert nicht.");                        
                    }
                    break;                
            }            
        }

    }
    
    /**
     * selects Arebiter Typ from choiceBox and loads the right table
     * @param event 
     */
    public void arbeiterTyp(ActionEvent event){
        String typ = choiceboxArbeiter.getValue();
         if("Chef".equals(typ)){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChefListe.fxml"));
                AnchorPane pane = loader.load();
                tableAnchor.getChildren().setAll(pane);
                ChefListeController controller = loader.getController();
            } catch (IOException ex) {
                Logger.getLogger(ArbeiterFnkNeuController.class.getName()).log(Level.SEVERE, null, ex);
            }             
         }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MitarbeiterListe.fxml"));
                AnchorPane pane = loader.load();
                tableAnchor.getChildren().setAll(pane);
                MitarbeiterListeController controller = loader.getController();
            } catch (IOException ex) {
                Logger.getLogger(ArbeiterFnkNeuController.class.getName()).log(Level.SEVERE, null, ex);
            }                          
         }
         textArea.setText("");
    }
}
