package blasi.nicolo.pcto.bean;

import javafx.scene.control.Alert;

public class AlertClass {
    public void showErrorAlert(String title, String body){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(body);

        alert.showAndWait();
    }

    public void showConfermationAlert(String title, String body){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(body);

        alert.showAndWait();
    }

    public void showWarningAlert(String title, String body){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(body);

        alert.showAndWait();
    }
}
