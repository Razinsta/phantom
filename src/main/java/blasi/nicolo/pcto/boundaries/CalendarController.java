package blasi.nicolo.pcto.boundaries;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class CalendarController {

    @FXML
    private WebView webView;

    @FXML
    public void initialize() {
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://calendar.google.com/calendar/u/0/appointments/schedules/AcZssZ0DZONCLDDt8_cyqDGZAoxUbLxw88o2tF6q_hP1iUZDTmobd994v_fi5BZiEVgIiuwEBNgu3Neq?gv=true");
    }
}