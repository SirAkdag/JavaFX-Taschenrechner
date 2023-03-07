package Java12D_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFX_TaschenRechner extends Application {
    @Override
    public void start(Stage meineStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sb_taschenrechner.fxml"));
    Scene meineScene = new Scene(root);
    meineStage.setTitle("JavaFX_Taschenrechner");
    meineStage.setScene(meineScene);
    meineStage.setResizable(false);
    meineStage.show();



    }

    public static void main(String[] args) {
    launch(args);
    }
}