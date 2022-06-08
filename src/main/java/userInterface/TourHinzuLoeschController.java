/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.mycompany.inf202.*;
import databaseFunctions.SelectRecords;
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
public class TourHinzuLoeschController implements Initializable {
    
    Chef currentChef;
    Mitarbeiter currentMit;
    int currentTyp = 0; //1 chef, 2 mit

    @FXML
    private TextField tourName;
    @FXML
    private TextField tourDatum;
    @FXML
    private TextField tourInfo;
    @FXML
    private TextField maxTeil;
    @FXML
    private TextField hotelName;
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
        textArea.setText("Der Löschvorgang funktioniert nach dem Namen des Tours.\n Der Tourname kann deshalb nicht verändert werden und alle andere Eingaben beim Löschen werden vernachlässigt!");
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void currentAnlegen(Chef c){
        textArea.setText("Der Löschvorgang funktioniert nach dem Namen des Tours.\n Der Tourname kann deshalb nicht verändert werden und alle andere Eingaben beim Löschen werden vernachlässigt!");
        currentChef = c;
        currentTyp = 1;                
    }

    @FXML
    private void tourHinzuButton(ActionEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String name = this.tourName.getText();
        String info = this.tourInfo.getText();
        String hotelName = this.hotelName.getText();
        int maxTeil = Integer.parseInt(this.maxTeil.getText());
        //String reiseL = this.reiseL.getText();
        float preis = Float.parseFloat(this.preis.getText());
        String g = this.tourDatum.getText();
        Date tourDatum = null;
        try{
            tourDatum = dateFormat.parse(g);        
        }catch(ParseException e){
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }   
        
        Hotel h = SelectRecords.findHotel(hotelName);
        if(h == null){
            textArea.setText("Der Tour mit den Namen " + name + " kann nicht hinzugefügt werden.\nDa das Hotel " + hotelName + " nicht existiert!");
        }else{
            int insertErfolg = 3;

            if(currentTyp == 1){
                //insertErfolg = currentChef.setTour(name, tourDatum, info, maxTeil, hotelName, preis, reiseL);
                insertErfolg = currentChef.setTour(name, tourDatum, info, maxTeil, hotelName, preis);
            }else{
//                insertErfolg = currentMit.setTour(name, tourDatum, info, maxTeil, hotelName, preis, reiseL);            
                insertErfolg = currentMit.setTour(name, tourDatum, info, maxTeil, hotelName, preis);
            }
            switch (insertErfolg) {
                case 1:
                    textArea.setText("Der Tour mit den Namen " + name + " wird gespeichert.");
                    break;
                case 2:
                    textArea.setText("Der Tour mit den Namen " + name + " existiert schon.");
                    break;
                default:
                    textArea.setText("Der Tour mit den Namen " + name + " kann nicht hinzugefügt werden.");
                    break;
            }
        }
        
    }

    @FXML
    private void tourLoeschButton(ActionEvent event) {
        String name = this.tourName.getText();

        int loeschErfolg = 3;
        if(currentTyp == 1){
            loeschErfolg = currentChef.deleteTour(name);
        }else{
            loeschErfolg = currentMit.deleteTour(name);
        }
        switch (loeschErfolg) {
            case 1:
                textArea.setText("Der Tour mit den Namen " + name + " wird gelöscht.");
                break;
            case 2:
                textArea.setText("Der Tour mit den Namen " + name + " existiert nicht.");
                break;
            default:
                textArea.setText("Der Tour mit den Namen " + name + " kann nicht geloescht werden.");
                break;
        }
    }

    @FXML
    private void tourAktButton(ActionEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String name = this.tourName.getText();
        String info = this.tourInfo.getText();
        String hotelName = this.hotelName.getText();
        int maxTeil = Integer.parseInt(this.maxTeil.getText());
        //String reiseL = this.reiseL.getText();
        float preis = Float.parseFloat(this.preis.getText());
        String g = this.tourDatum.getText();
        Date tourDatum = null;
        try{
            tourDatum = dateFormat.parse(g);        
        }catch(ParseException e){
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }   

        int aktualErfolg = 3;
        Hotel h = SelectRecords.findHotel(hotelName);
        if(h == null){
            textArea.setText("Der Tour mit den Namen " + name + " kann nicht aktualisiert werden.\nDa das Hotel " + hotelName + " nicht existiert!");
        }else{
            if(currentTyp == 1){
                aktualErfolg = currentChef.updateTourInfos(name, tourDatum, maxTeil, info, hotelName, preis);
            }else{
                aktualErfolg = currentMit.updateTourInfos(name, tourDatum, maxTeil, info, hotelName, preis);
            }
            // 0 maxTeil reduziert, 1 erfolgreich aktualisiert, 2 fehler, 3 existiert nicht
            switch (aktualErfolg) {
                case 0:
                    textArea.setText("Die maximale Teilnehmerzahl des Tours kann nicht reduziert werden.");
                    break;
                case 1:
                    textArea.setText("Der Tour mit den Namen " + name + " wird aktualisiert.");
                    break;
                case 3:
                    textArea.setText("Der Tour mit den Namen " + name + " existiert nicht.");
                    break;
                default:
                    textArea.setText("Der Tour mit den Namen " + name + " kann nicht aktualisiert werden.");
                    break;
            }
            
        }
        

    }
    
    public void fromTourListe(Tour t){    
        this.tourName.setText(t.getTourName());
        textArea.setText("Aktualisieren Sie die gegebene Tour");
    }
    
}
