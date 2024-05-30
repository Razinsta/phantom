package blasi.nicolo.pcto.boundaries;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Controller startController = new Controller();
        startController.setStage(stage);
        stage.setTitle("PCTOrganizer");
        startController.loginPage();
        //aaasaaaaaa
    }
}