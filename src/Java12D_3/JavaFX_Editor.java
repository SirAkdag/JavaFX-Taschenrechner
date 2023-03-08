package Java12D_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFX_Editor extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		//eine Instanz von FXMLLoader erzeugen
		FXMLLoader meinLoader = new FXMLLoader(getClass().getResource("sb_editor.fxml"));
		//die Datei laden
		Parent root = meinLoader.load();
		//den Controller beschaffen
		FXMLController meinController = meinLoader.getController();
		//und die Bühne übergeben
		meinController.setMeineStage(meineStage);
		//die Szene erzeugen
		//an den Konstruktor werden der oberste Knoten und die Größe übergeben
		Scene meineScene = new Scene(root, 400, 400);
		//den Titel über stage setzen
		meineStage.setTitle("JavaFX Editor");
		//die Szene setzen

		meineStage.setScene(meineScene);
		//im Vollbild darstellen
		meineStage.setMaximized(true);
		//und anzeigen
		meineStage.show();
	}
	
	public static void main(String[] args) {
		//der Start
		launch(args);
	}
}
