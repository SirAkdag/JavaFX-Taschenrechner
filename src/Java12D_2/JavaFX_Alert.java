package Java12D_2;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


public class JavaFX_Alert extends Application {
    @Override
    public void start(Stage meineStage) {
        //Hier wird ein Warnungsfenster der Klasse Alert erstellt.
        Alert meinDialog = new Alert(Alert.AlertType.CONFIRMATION, "Wollen Sie die Dateien wirklich löschen ?", ButtonType.YES, ButtonType.NO);
        meinDialog.setHeaderText("Bitte entscheiden Sie");
        meinDialog.setTitle("Frage");
        meinDialog.showAndWait();
        //getResult-Methode wurde für das angegebene Ja- oder Nein-Ergebnis verwendet.
        System.out.println(meinDialog.getResult());
    }

    public static void main(String[] args) {
        launch(args);
    }
}