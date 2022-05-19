/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import java.net.URL;
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
public class HotelFunktionenController implements Initializable {

    Chef currentChef;
    Mitarbeiter currentMit;
    int currentTyp = 0; //1 chef, 2 mit

    @FXML
    private TextField name;
    @FXML
    private TextField anschr;
    @FXML
    private TextField tel;
    @FXML
    private TextField email;
    @FXML
    private TextField preis;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void currentAnlegen(Mitarbeiter m){
        textArea.setText("Der Löschvorgang funktioniert nach dem Namen des Hotels.\n Der Hotelname kann deshalb nicht verändert werden und alle andere Eingaben beim Löschen werden vernachlässigt!");
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void currentAnlegen(Chef c){
        textArea.setText("Der Löschvorgang funktioniert nach dem Namen des Hotels.\n Der Hotelname kann deshalb nicht verändert werden und alle andere Eingaben beim Löschen werden vernachlässigt!");
        currentChef = c;
        currentTyp = 1;                
    }

    @FXML
    private void hotelHinzuButton(ActionEvent event) {
        String name = this.name.getText();
        String anchr = this.anschr.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(this.tel.getText());
        float preis = Float.parseFloat(this.preis.getText());
        
        int insertErfolg = 3;
        
        if(currentTyp == 1){
            insertErfolg = currentChef.setHotel(name, anchr, tel, email, preis);
        }else{
            insertErfolg = currentMit.setHotel(name, anchr, tel, email, preis);
        }
        switch (insertErfolg) {
            case 1:
                textArea.setText("Das Hotel mit den Namen " + name + " wird gespeichert.");
                break;
            case 2:
                textArea.setText("Das Hotel mit den Namen " + name + " existiert schon.");
                break;
            default:
                textArea.setText("Das Hotel mit den Namen " + name + " kann nicht hinzugefügt werden.");
                break;
        }
    }

    @FXML
    private void hotelAktButton(ActionEvent event) {
        String name = this.name.getText();
        String anchr = this.anschr.getText();
        String email = this.email.getText();
        int tel = Integer.parseInt(this.tel.getText());
        float preis = Float.parseFloat(this.preis.getText());

        int aktualErfolg = 3;
        
        if(currentTyp == 1){
            aktualErfolg = currentChef.updateHotelInfo(name, anchr, tel, email, preis);
        }else{
            aktualErfolg = currentMit.updateHotelInfo(name, anchr, tel, email, preis);
        }
        switch (aktualErfolg) {
            case 1:
                textArea.setText("Das Hotel mit den Namen " + name + " wird aktualisiert.");
                break;
            case 2:
                textArea.setText("Das Hotel mit den Namen " + name + " existiert nicht.");
                break;
            default:
                textArea.setText("Das Hotel mit den Namen " + name + " kann nicht aktualisiert werden.");
                break;
        }
    }

    @FXML
    private void hotelLoeschButton(ActionEvent event) {
        String name = this.name.getText();

        int loeschErfolg = 3;
        
        if(currentTyp == 1){
            loeschErfolg = currentChef.deleteHotel(name);
        }else{
            loeschErfolg = currentMit.deleteHotel(name);
        }
        switch (loeschErfolg) {
            case 1:
                textArea.setText("Das Hotel mit den Namen " + name + " wird gelöscht.");
                break;
            case 2:
                textArea.setText("Das Hotel mit den Namen " + name + " existiert nicht.");
                break;
            default:
                textArea.setText("Das Hotel mit den Namen " + name + " kann nicht geloescht werden.");
                break;
        }
    }
    
}
