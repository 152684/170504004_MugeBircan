/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.inf202.*;
import databaseFunctions.DeleteRecords;
import databaseFunctions.SelectRecords;
import databaseFunctions.UpdateRecords;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbirc
 */
public class FromTourListController implements Initializable {
    
    Chef currentChef;
    Mitarbeiter currentMit;
    int currentTyp = 0; //1 chef, 2 mit
    Tour t;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField kundenID;
    @FXML
    private TextArea textArea2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void currentAnlegen(Mitarbeiter m){
        currentMit = m;
        currentTyp = 2;        
    }
    
    public void currentAnlegen(Chef c){
        currentChef = c;
        currentTyp = 1;                
    }

    public void fromTourList(String tourName){
        t = SelectRecords.findTour(tourName);
        Hotel h = SelectRecords.findHotel(t.getHotelName());
        float total = t.getPreis()+h.getPreis();
        textArea.setText("Sie haben " + tourName + " gewählt.\nTour Preis: " + t.getPreis() + "\nHotel preis: " + h.getPreis() + "\nTotal preis: " + total);
    }

    @FXML
    private void tourAktButton(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TourHinzuLoesch.fxml"));
            Parent root = loader.load();
            //The following both lines are the only addition we need to pass the arguments
            TourHinzuLoeschController controller2 = loader.getController();
            if(currentTyp == 1){
                controller2.currentAnlegen(currentChef);                
            }else{
                controller2.currentAnlegen(currentMit);                                
            }
            controller2.fromTourListe(t);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
                
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void kundeAnButton(ActionEvent event){
        ArrayList<Kunde> kunden = new ArrayList();
        long kundeId = Long.parseLong(kundenID.getText());
        boolean kundeEx = false;
        try {
            SelectRecords.allKundenInArray(kunden);
            Iterator<Kunde> iter = kunden.iterator();
            Kunde k;

            int anmeldeSituation;
            while(iter.hasNext()){
                k = iter.next();
                if(k.getBurgerID() == kundeId){
                    anmeldeSituation = UpdateRecords.kundeZurTourAnmelden(t.getTourName(), k.getBurgerID());
                    switch (anmeldeSituation) {
                        case 0:
                            textArea2.setText("Der Kunde " + k.getName() + " ist schon zu dieser Tour angemeldet.");
                            break;
                        case 1:
                            textArea2.setText("Der Kunde " + k.getName() + " ist zur Tour angemeldet.");                         
                            break;
                        case 3:
                            textArea2.setText("Es gibt keine freiePlätze bei diser Tour.");
                            break;
                        default:
                            textArea2.setText("Der Kunde " + k.getName() + " kann zur Tour nicht angemeldet werden.");
                            break;                            
                    }
                    kundeEx = true;
                    break;
                }
            }
            if(!kundeEx){
                textArea2.setText("Der Kunde mit der IDNummer: " + kundeId + " existiert nicht. Reigstieren Sie die Kunde.");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeHinzufuegen.fxml"));
                Parent root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
                KundeHinzufuegenController controller2 = loader.getController();
                if(currentTyp == 1){
                    controller2.currentAnlegen(currentChef);                    
                }else if(currentTyp == 2){
                    controller2.currentAnlegen(currentMit);                                        
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
               
                
            }
            
        }catch(UngueltigeIDException ex){
            Logger.getLogger(FromTourListController.class.getName()).log(Level.SEVERE, null, ex);            
        }catch (IOException e) {
            e.printStackTrace();
        }

        
    }

    @FXML
    private void kundeAbButton(ActionEvent event) {

        long kundenId = Long.parseLong(kundenID.getText());
        int abmeldeSituation = DeleteRecords.deleteKundeVonTour(t.getTourName(), kundenId);
        switch (abmeldeSituation) {
            case 0:
                textArea2.setText("Der Kunde (burgerID: " + kundenId + ") ist zu dieser Tour nicht angemeldet!");
                break;
            case 1:
                textArea2.setText("Der Kunde (burgerID: " + kundenId + ") ist vom Tour abgemeldet!");
                break;
            case 2:
                textArea2.setText("Der Kunde (burgerID: " + kundenId + ") ist vom Tour nicht abgemeldet werden!");
                break;
            default:
                textArea2.setText("ID Nummer muss 11 Stellig sein");

        }       
    }
    
}
