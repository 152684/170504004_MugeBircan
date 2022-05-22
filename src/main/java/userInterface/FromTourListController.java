/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package userInterface;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.inf202.*;
import databaseFunctions.SelectRecords;
import databaseFunctions.UpdateRecords;
import java.io.IOException;
import java.lang.reflect.Type;
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
        textArea.setText("Sie haben " + tourName + " gewählt.");
        t = SelectRecords.findTour(tourName);
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
    private void kundeAnButton(ActionEvent event) throws UngueltigeIDException{
        long id = Long.parseLong(this.kundenID.getText());
        Kunde kunde = SelectRecords.findKunde(id);
         
        if(kunde == null){
            textArea2.setText("Die Kunde muss zuertst registriert werden!");
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeHinzufuegen.fxml"));
                Parent root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
                KundeHinzufuegenController controller2 = loader.getController();
                if(currentTyp == 1){
                    controller2.currentAnlegen(currentChef);                
                }else{
                    controller2.currentAnlegen(currentMit);                                
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            UpdateRecords.updateTourKunden(t.getName(), kunde.getName());
            textArea2.setText("Der Kunde " + kunde.getName() + " ist zur Tour angemeldet.");
        }
        
    }

    @FXML
    private void kundeAbButton(ActionEvent event) throws UngueltigeIDException {
        long id = Long.parseLong(this.kundenID.getText());
        Kunde kunde = SelectRecords.findKunde(id);
         
        if(kunde == null){
            textArea2.setText("Die Kunde existiert nicht!");
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeHinzufuegen.fxml"));
                Parent root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
                KundeHinzufuegenController controller2 = loader.getController();
                if(currentTyp == 1){
                    controller2.currentAnlegen(currentChef);                
                }else{
                    controller2.currentAnlegen(currentMit);                                
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            String s = SelectRecords.selectTourKunden(t.getName()); // direkte arraylist übergabe
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            ArrayList<String> in = gson.fromJson(s, type);  
            Iterator<String> iter = in.iterator();
            while(iter.hasNext()){
                if(iter.next().equals(kunde.getName())){
                    //DeleteRecords.
                }else{
                    textArea2.setText("Die Kunde is beim Tour nicht angemeldet!");
                }
            }
            
            UpdateRecords.updateTourKunden(t.getName(), kunde.getName());
            textArea2.setText("Der Kunde " + kunde.getName() + " ist zur Tour angemeldet.");
        }
    }
    
}
