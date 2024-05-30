package volta.ts.it.pcto.bean;

import javafx.scene.control.Alert;

public class AlertClass {
    public void showErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ACCESSO NEGATO!");
        alert.setContentText("UserID o Password inseriti non corretti!");

        alert.showAndWait();
    }

    public void showConfermationAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ACCESSO EFFETTUATO!");
        alert.setContentText("Accesso consentito");

        alert.showAndWait();
    }
}
