package Java12D_3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;



public class FXMLController {
    //das Textfeld
    @FXML
    private TextArea editor;
    //für die Bühne
    private Stage meineStage;

    //Hier wurden nur 3 Methoden erstellt und
    //die Methoden Ausschneiden, Kopieren und Einfügen hinzugefügt.
    //und werden diese Methoden zu den erstellten MenüItems und Schaltflächen hinzugefügt.
    @FXML
    private void copyKlick() {
        editor.copy();
    }

    @FXML
    private void cutKlick() {
        editor.cut();
    }

    @FXML
    private void pasteKlick() {
        editor.paste();
    }

    //die Methode zum Beenden
    @FXML
    protected void beendenKlick() {
        Platform.exit();
    }

    //die Methode zum Anzeigen des Öffnendialogs
    @FXML
    protected void ladenKlick() {
        //eine neue Instanz der Klasse FileChooser erzeugen
        FileChooser oeffnenDialog = new FileChooser();
        //den Titel für den Dialog setzen
        oeffnenDialog.setTitle("Datei öffnen");
        oeffnenDialog.setInitialDirectory(new File(System.getProperty("user.home")));
        //den Filter setzen
        oeffnenDialog.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
        //den Öffnendialog anzeigen und das Ergebnis beschaffen
        File datei = oeffnenDialog.showOpenDialog(meineStage);
        //wurde eine Datei ausgewählt
        if (datei != null)
            //dann den Inhalt über eine eigene Methode lesen
            editor.setText(datenLesen(datei));
    }

    //die Methode zum Anlegen eines neuen Dokuments
    @FXML
    protected void neuKlick() {
        //den Dialog erzeugen und anzeigen
        Alert meinDialog = new Alert(AlertType.INFORMATION, "Die Daten werden gelöscht.");
        //den Text setzen
        meinDialog.setHeaderText("Bitte beachten");
        //den Dialog anzeigen
        meinDialog.showAndWait();
        //das Textfeld leeren
        editor.clear();
    }

    //die Methode zum Anzeigen des Speicherndialogs
    @FXML
    protected void speichernKlick() {
        //eine neue Instanz der Klasse FileChooser erzeugen
        FileChooser speichernDialog = new FileChooser();
        //den Titel für den Dialog setzen
        speichernDialog.setTitle("Datei speichern");
        //den Ordner setzen
        speichernDialog.setInitialDirectory(new File(System.getProperty("user.home")));
        //den Filter setzen
        speichernDialog.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
        //den Speicherndialog anzeigen und das Ergebnis beschaffen
        File datei = speichernDialog.showSaveDialog(meineStage);
        //wurde eine Datei ausgewählt
        if (datei != null)
            //dann den Inhalt über eine eigene Methode speichern
            datenSchreiben(datei);
    }


    //die Methode zum Laden
    //Sie erhält die Datei, die gelesen werden soll
    //und liefert eine Zeichenkette mit dem Inhalt zurück
    private String datenLesen(File dateiLesen) {
        //gelesen wird als int!!
        int zeichen = 0;
        StringBuilder text = new StringBuilder();
        //eine Instanz der Klasse FileReader mit der Datei erzeugen
        try (FileReader tempDatei = new FileReader(dateiLesen)) {
            //solange das Ende der Datei nicht erreicht ist, werden die Zeichen einzeln gelesen und
            //an einem StringBuilder angehängt
            zeichen = tempDatei.read();
            while (zeichen != -1) {
                //zeichen wird in den Typ char umgewandelt
                text.append((char) zeichen);
                zeichen = tempDatei.read();
            }
        } catch (IOException e) {
            //bei Problemen einen Dialog erzeugen
            Alert meinDialog = new Alert(AlertType.INFORMATION, "Beim Laden ist ein Problem aufgetreten");
            meinDialog.setHeaderText("Bitte beachten");
            meinDialog.showAndWait();
        }
        return (text.toString());
    }

    //die Methode zum Schreiben
    //Sie erhält die Datei, die geschrieben werden soll
    private void datenSchreiben(File dateiSchreiben) {
        //eine Instanz der Klasse FileWriter mit der Datei erzeugen
        try (FileWriter tempDatei = new FileWriter(dateiSchreiben)) {
            //der Inhalt des Textfeldes wird direkt in die Datei geschrieben
            tempDatei.write(editor.getText());
        } catch (IOException e) {
            //bei Problemen einen Dialog erzeugen
            //bei Problemen einen Dialog erzeugen
            Alert meinDialog = new Alert(AlertType.INFORMATION, "Beim Schreiben ist ein Problem aufgetreten");
            meinDialog.setHeaderText("Bitte beachten");
            meinDialog.showAndWait();
        }
    }


    //die Methode setzt die Bühne auf den übergebenen Wert
    public void setMeineStage(Stage meineStage) {
        this.meineStage = meineStage;
    }
}
