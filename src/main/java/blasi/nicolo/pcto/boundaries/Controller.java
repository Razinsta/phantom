package blasi.nicolo.pcto.boundaries;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.AlertClass;
import blasi.nicolo.pcto.bean.Azienda;
import blasi.nicolo.pcto.bean.Studente;
import blasi.nicolo.pcto.bean.TutorScolastico;
import blasi.nicolo.pcto.business.GestioneAzienda;
import blasi.nicolo.pcto.business.GestioneLogin;
import blasi.nicolo.pcto.business.GestioneLoginDocente;
import blasi.nicolo.pcto.business.GestioneStudente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    GestioneAzienda gesAzienda = new GestioneAzienda();
    GestioneStudente gestione_studente = new GestioneStudente();
	GestioneLogin gestione_login = new GestioneLogin();
	GestioneLoginDocente gestione_loginTutorScolastico = new GestioneLoginDocente();
    AlertClass alert = new AlertClass();//Messaggi di errore durante l'accesso. (PER MODIFICARE VEDI CLASSE ALERT)

    //--------------------------------

    private Stage stage;

    //LOGIN
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userID;

    //VISUALIZZAZIONE NOMI SU PAGINE PRINCIPALI
    @FXML
    private TextField teacherName;
    @FXML
    private TextField teacherName1;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentName1;
    @FXML
    private TextField studentId = new TextField("a");
    @FXML
    private TextField docenteId = new TextField("a");

    //VISUALE STUDENTE
    @FXML
    private TextField comuneNascitaField;
    @FXML
    private TextField currentYear;
    @FXML
    private TextField comuneResidenza;
    @FXML
    private TextField dataNascitaField;
    @FXML
    private TextField noteField;
    @FXML
    private Pane aziendePane;
    @FXML
    private Pane studentiPane;
    @FXML
    private Pane progettiFormativiPane;

    //PANEL DI LOGOUT
    @FXML
    private Pane logoutPane;

    //ANAGRAFICA STUDENTE
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField indirizzoField;
    @FXML
    private TextField dataField;
    @FXML
    private TextField comuneNascitaField1;
    @FXML
    private TextField residenzaField;

    //ANAGRAFICA AZIENDA
    @FXML
    private TextField ragioneField;
    @FXML
    private TextField ivaField;
    @FXML
    private TextField sedeField;
    @FXML
    private TextField topicField;
    @FXML
    private TextField noteField1;
    @FXML
    private TextField statoconvenzioneField;
    @FXML
    private TextField numeroconvenzioneField;

    //LISTE
    @FXML
    private ListView aziendeListView;
    @FXML
    private ListView studentiListView;
    @FXML
    private ListView progettiListView;

    //VISUALE DOCENTE
    @FXML
    private Group popGroup;
    @FXML
    private Group mainGroup;
    @FXML
    private Group aziendaGroup;
    @FXML
    private Group progettoGroup;
    @FXML
    private Group tutorGroup;

    @FXML
    private WebView calendarioView;
    @FXML
    private WebEngine webEngine;

    @FXML
    private Group documentiGroup;


    private Stage aziendaStage;

    //---------------------------------

    public Controller() {}

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //---------------------------------

    private String 	ragione = "", iva = "",sede = "",topic = "",note = "",statoconvenzione = "",nconvenzione = "";
	
    
    
    @FXML
	protected void onModifyAnagrafClick() {
		boolean isEditable;
		Color color = Color.rgb(235, 94, 40);

		isEditable = !this.nomeField.isEditable();

		this.nomeField.setEditable(isEditable);
		this.cognomeField.setEditable(isEditable);
		this.indirizzoField.setEditable(isEditable);
		this.dataField.setEditable(isEditable);
		this.comuneNascitaField1.setEditable(isEditable);
		this.residenzaField.setEditable(isEditable);

		if (isEditable) {
			this.nomeField.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			this.cognomeField.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			this.indirizzoField.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			this.dataField.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			this.comuneNascitaField1.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			this.residenzaField.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		} else {
			this.nomeField.setBorder(null);
			this.cognomeField.setBorder(null);
			this.indirizzoField.setBorder(null);
			this.dataField.setBorder(null);
			this.comuneNascitaField1.setBorder(null);
			this.residenzaField.setBorder(null);

		}
	}

	@FXML
	protected void onCofermaCLick(){
		//        alert.showWarningAlert("INVIO DEI DATI DELL'AZIENDA", "SICURO?");
		if(ragioneField.getText() != null && ivaField.getText() != null && sedeField.getText() != null && statoconvenzioneField.getText() != null) {
			ragione = ragioneField.getText();
			iva = ivaField.getText();
			sede = sedeField.getText();
			
			topic = topicField.getText();
			note = noteField1.getText();
			statoconvenzione = statoconvenzioneField.getText();
			nconvenzione = numeroconvenzioneField.getText();
			int id = addAzienda();
			System.out.println(id);
			//showAziende();
		}
		else
			System.out.println("Inserisci dati grazie!");
	}
	private int addAzienda() {
		 return gesAzienda.insert(ragione, iva, sede, topic, note, statoconvenzione, nconvenzione);
		
	}



    //----------------------------------

    @FXML
    protected void onPasswordResetClick(){
        alert.showWarningAlert("ATTENZIONE!", "Funzione non ancora implementata.");
    }

    public void initialize() throws IOException {
        if(passwordField != null) {
            passwordField.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case ENTER:
                        try {
                            handleLogin();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    default:
                        break;
                }
            });
        }
    }

    @FXML
    protected void onPrenotaCLick() throws IOException {
        loadPrenotaPage();
    }

    @FXML
    private void handleLogin() throws IOException{
    	loginControl(userID.getText(), passwordField.getText()); //Controllo dell'accesso
    }

    @FXML
    protected void onClickLogin() throws IOException { //gestione_studente function
        loginControl(userID.getText(), passwordField.getText());
    }

    private void loginControl(String username, String password) throws IOException{

    	int id = gestione_login.search(username, password);
    	int idDocente = gestione_loginTutorScolastico.search(username, password);

    	if (gestione_studente.getById(id) != null) {
        	System.out.println("Accesso effettuato studente!");
        	Studente studente = gestione_studente.getById(id);
            loadStudentePage(this,studente);
            setUserID(userID.getText());

    	}else if( gestione_loginTutorScolastico.getById(idDocente)!=null ) {
    		System.out.println("Accesso effettuato docente!");
        	TutorScolastico docente = gestione_loginTutorScolastico.getById(idDocente);
            loadDocentePage(this, docente);
            setUserID(userID.getText());
		    }else  {
				userID.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		        passwordField.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		        System.err.println("Accesso negato!");
		        alert.showErrorAlert(password, password);

		    }
        }

    //---------------------------------------------PARTE GESTIONE PAGINE DOCENTE

    @FXML
    protected void onAggiungiAziendaClick() throws IOException {
        loadAddAzienda();
    }


    @FXML
    protected void onModifyClick() throws IOException{
        boolean isEditable;

        isEditable = !this.dataNascitaField.isEditable();

        this.dataNascitaField.setEditable(isEditable);
        this.comuneNascitaField.setEditable(isEditable);

        if(!isEditable) {
        	System.out.println("--------" + studentId);
        	Studente studente = gestione_studente.getById(Integer.parseInt(studentId.getText()));
        	studente.setDataNascita(dataNascitaField.getText());
        	studente.setComuneNascita(comuneNascitaField.getText());
        	gestione_studente.update(studente);
        }
    }

    @FXML
    protected void onAziendaClick() throws IOException{
        if(studentiPane.isVisible() || progettiFormativiPane.isVisible() || popGroup.isVisible()){
            this.studentiPane.setVisible(false);
            this.aziendePane.setVisible(false);
            this.popGroup.setVisible(false);
            this.progettiFormativiPane.setVisible(false);
            //this.convenzioniPane.setVisible(false);
        }

        if(aziendePane.isVisible()) {
            this.aziendePane.setVisible(false);
            this.popGroup.setVisible(true);
        }else this.aziendePane.setVisible(true);

        showAziende();
    }

    @FXML
    protected void onStudentiClick() throws IOException{
        if(progettiFormativiPane.isVisible() || aziendePane.isVisible() || popGroup.isVisible()){
            this.studentiPane.setVisible(false);
            this.aziendePane.setVisible(false);
            this.popGroup.setVisible(false);
            this.progettiFormativiPane.setVisible(false);
            //this.convenzioniPane.setVisible(false);
        }

        if(studentiPane.isVisible()) {
            this.studentiPane.setVisible(false);
            this.popGroup.setVisible(true);
        }else this.studentiPane.setVisible(true);

        showStudenti();
    }

    @FXML
    protected void onProjectClick(){
        if(studentiPane.isVisible() || aziendePane.isVisible() || popGroup.isVisible()){
            this.studentiPane.setVisible(false);
            this.aziendePane.setVisible(false);
            this.popGroup.setVisible(false);
            //this.convenzioniPane.setVisible(false);

        }

        if(progettiFormativiPane.isVisible()) {
            this.progettiFormativiPane.setVisible(false);
            this.popGroup.setVisible(true);
        }else this.progettiFormativiPane.setVisible(true);

        showProgettiFormativi();
    }

    @FXML
    protected void onConvenzioniClick(){
        if(studentiPane.isVisible() || aziendePane.isVisible() || popGroup.isVisible() || progettiFormativiPane.isVisible()){
            this.studentiPane.setVisible(false);
            this.aziendePane.setVisible(false);
            this.popGroup.setVisible(false);
            //this.progettiFormativiPane.setVisible(false);
        }
    }

    @FXML
    protected void onLogoutClick(){
        stage.setFullScreen(false);

        if(!logoutPane.isVisible())
            this.logoutPane.setVisible(true);
    }

    //----------------------------------------PARTE COMUNE DOCENTE/STUDENTE

    @FXML
    protected void onNotImplementedClick(){
        alert.showWarningAlert("ATTENZIONE!", "Funzione non ancora implementata.");
    }

    @FXML
    protected void onDenyClick(){
        this.logoutPane.setVisible(false);
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        loginPage();
    }

    @FXML
    protected void onHelpClick() throws IOException {
        loadHelpPage();
    }

    @FXML
    protected void onAvatarClick() throws IOException {
        loadAnagrafPage();
    }

    //-------------------------------------------PARTE GESTIONE PAGINE STUDENTE

    @FXML
    protected void onAnagraficaClick(){
        if(aziendaGroup.isVisible() || progettoGroup.isVisible() || tutorGroup.isVisible() || documentiGroup.isVisible()){
            this.aziendaGroup.setVisible(false);
            this.progettoGroup.setVisible(false);
            this.tutorGroup.setVisible(false);
            this.documentiGroup.setVisible(false);
        }

        this.mainGroup.setVisible(true);
    }

    @FXML
    protected void onAziendaClickStudent(){
        if(mainGroup.isVisible() || progettoGroup.isVisible() || tutorGroup.isVisible() || documentiGroup.isVisible()) {
            this.mainGroup.setVisible(false);
            this.progettoGroup.setVisible(false);
            this.tutorGroup.setVisible(false);
            this.documentiGroup.setVisible(false);
        }

        if(aziendaGroup.isVisible()) {
            this.aziendaGroup.setVisible(false);
            this.mainGroup.setVisible(true);
        }else this.aziendaGroup.setVisible(true);
    }

    @FXML
    protected void onModifyNoteClick(){
        if(noteField.isEditable())
            noteField.setEditable(false);
        else noteField.setEditable(true);
    }

    @FXML
    protected void onProgettiClick(){
        if(mainGroup.isVisible() || aziendaGroup.isVisible() || tutorGroup.isVisible() || documentiGroup.isVisible()){
            this.mainGroup.setVisible(false);
            this.aziendaGroup.setVisible(false);
            this.tutorGroup.setVisible(false);
            this.documentiGroup.setVisible(false);
        }

        if(progettoGroup.isVisible())
            this.progettoGroup.setVisible(false);
        else this.progettoGroup.setVisible(true);
    }

    @FXML
    protected void onTutorClick(){
        if(mainGroup.isVisible() || aziendaGroup.isVisible() || progettoGroup.isVisible() || documentiGroup.isVisible()){
            this.mainGroup.setVisible(false);
            this.aziendaGroup.setVisible(false);
            this.progettoGroup.setVisible(false);
            this.documentiGroup.setVisible(false);
        }

        if(tutorGroup.isVisible())
            this.tutorGroup.setVisible(false);
        else this.tutorGroup.setVisible(true);
    }

    //----------------------------------------ALTRI METODI

    private void setUserID(String userID) {
        this.userID.setText(userID);
    }

    protected void setTeacherName(String name) {
        this.teacherName.setText(name);
        this.teacherName1.setText(name);
    }

    protected void setStudentName(String name) {
        this.studentName.setText(name);
        this.studentName1.setText(name);
    }

    private void setCurrentYear(){
        int annoCorrente = Year.now().getValue();

        this.currentYear.setText("PCTO " + (annoCorrente-1) + " / " + annoCorrente);
    }

    private void setAllData(){
        this.nomeField.setText(userID.getText());
        this.residenzaField.setText(comuneResidenza.getText());
        this.dataField.setText(dataNascitaField.getText());
        this.comuneNascitaField1.setText(comuneNascitaField.getText());
    }

    //-----------------------------------FXML LOADER

    protected void loginPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setResizable(false);
        /*stage.setMinHeight(500);
        stage.setMinWidth(600);*/
        stage.setTitle("PCTOrganizer - LOGIN");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    protected void loadStudentePage(Controller controller, Studente studente) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BodyStudente_V1_Open.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setStudentName("Ciao, " + studente.getNome()); // Setta il nome dello studente con l'userID
        controller.setStudentId("" + studente.getId());
        controller.setCurrentYear();

        stage.setResizable(false);
        stage.setMinHeight(630);
        stage.setMinWidth(1000);
        stage.setTitle("PCTOrganizer - DASHBOARD STUDENTE");
        stage.setScene(scene);
        stage.show();
    }

    protected void loadDocentePage(Controller controller,TutorScolastico docente) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BodyDocente_V3_Open.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setTeacherName("Ciao, " + docente.getDocente()); // Setta il nome del docente con l'userID
        controller.setStudentId("" + docente.getId());

        stage.setResizable(false);
        stage.setMinHeight(630);
        stage.setMinWidth(1000);
        stage.setTitle("PCTOrganizer - DASHBOARD DOCENTE");
        stage.setScene(scene);
        stage.show();
    }

    protected void loadHelpPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HelpPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage helpStage = new Stage();

        helpStage.setResizable(false);
        helpStage.setTitle("PCTOrganizer - HELP");
        helpStage.setScene(scene);
        helpStage.show();
    }

    protected void loadAddAzienda() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("informazioni_azienda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        aziendaStage = new Stage();

        aziendaStage.setResizable(false);
        aziendaStage.setTitle("PCTOrganizer - AGGIUNGI AZIENDA");
        aziendaStage.setScene(scene);
        aziendaStage.show();
    }

    @FXML
    protected void inzializeCalendar(){
        webEngine = calendarioView.getEngine();
        webEngine.load("https://calendar.google.com/calendar/u/0/appointments/schedules/AcZssZ0DZONCLDDt8_cyqDGZAoxUbLxw88o2tF6q_hP1iUZDTmobd994v_fi5BZiEVgIiuwEBNgu3Neq?gv=true");
        //calendarioView.setVisible(false);
    }

    protected void loadAnagrafPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("informazioni_studente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage anagrafStage = new Stage();

        anagrafStage.setResizable(false);
        anagrafStage.setTitle("PCTOrganizer - ANAGRAFICA");
        anagrafStage.setScene(scene);
        anagrafStage.show();
    }

    private void loadPrenotaPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CalendarPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage calendarStage = new Stage();
        calendarStage.setScene(scene);
        calendarStage.setTitle("Calendario");
        calendarStage.show();
    }

    //--------------CARICAMENTO DOCUMENTI

    @FXML
    protected void onDOCClick() {
        if (mainGroup.isVisible() || aziendaGroup.isVisible() || progettoGroup.isVisible()|| tutorGroup.isVisible()){
            this.mainGroup.setVisible(false);
            this.aziendaGroup.setVisible(false);
            this.progettoGroup.setVisible(false);
            this.tutorGroup.setVisible(false);
            this.documentiGroup.setVisible(true);
        }else{
            this.documentiGroup.setVisible(false);
            this.mainGroup.setVisible(true);
        }
    }

    public int getStudenteid() {
        return Integer.parseInt(studentId.getText());
    }

    protected void setStudentId(String id) {
        this.studentId.setText(id);
    }

    @FXML
    protected void onCvdownClick() {
        gestione_studente.prendiAllegato(getStudenteid(), "cv", pathDownload());
    }

    @FXML
    protected void onCvupClick() {
        gestione_studente.caricaAllegato(pathUpload(), getStudenteid(), 1);
    }

    @FXML
    protected void onCidownClick() {
        gestione_studente.prendiAllegato(getStudenteid(), "ci", pathDownload());
    }

    @FXML
    protected void onCiupClick() {
        gestione_studente.caricaAllegato(pathUpload(), getStudenteid(), 2);

    }

    @FXML
    protected void onTsdownClick() {
        gestione_studente.prendiAllegato(getStudenteid(), "ts", pathDownload());
    }

    @FXML
    protected void onTsupClick() {
        gestione_studente.caricaAllegato(pathUpload(), getStudenteid(), 3);

    }

    @FXML
    protected void onLmdownClick() {
        gestione_studente.prendiAllegato(8, "letteramotivazionale", pathDownload());
    }

    @FXML
    protected void onLmupClick() {
        gestione_studente.caricaAllegato(pathUpload(), 8, 4);

    }


    //----------------------------------------ALTRI METODI

    private String pathDownload() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("seleziona Directory");
        File selectedDirectory = directoryChooser.showDialog(stage);
        String directoryPath = null;

        if (selectedDirectory != null) {
            directoryPath = selectedDirectory.getAbsolutePath();
            System.out.println("Il percorso della directory selezionata è: " + directoryPath);
        } else {
            System.out.println("La selezione della directory è stata annullata.");
        }
        return directoryPath;
    }

    private String pathUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(filter);
        File selectedFile = fileChooser.showOpenDialog(stage);
        String filePath = null;

        if (selectedFile != null) {
            filePath = selectedFile.getAbsolutePath();
            System.out.println("Il percorso del file selezionato è: " + filePath);
        } else {
            System.out.println("La selezione del file è stata annullata.");
        }
        return filePath;
    }

    //----------------------------------gestione_studente DATABASE LOADER

    @FXML
	private void showAziende(){
		ArrayList<String> aziendeList = new ArrayList<>();
		GestioneAzienda gestioneAzienda = new GestioneAzienda();
		List<Azienda> list = gestioneAzienda.getAll();
		if (list != null)
			for (Azienda item : list)
				aziendeList.add(item.toString());

		ObservableList<String> observableList = FXCollections.observableArrayList(aziendeList);

		aziendeListView.setItems(observableList);

	} //gestione_studente database information (only for test use)

	@FXML
	private void showStudenti(){
		
		ArrayList<String> studenteList = new ArrayList<>();
		GestioneStudente gestioneStudente = new GestioneStudente();
		List<Studente> list = gestioneStudente.getAll();
		if (list != null)
			for (Studente item : list)
				studenteList.add(item.toString());

		ObservableList<String> observableList = FXCollections.observableArrayList(studenteList);

		studentiListView.setItems(observableList);
	}

    @FXML
    private void showProgettiFormativi(){
        ArrayList<String> progFormList = new ArrayList<>();

        progFormList.add("Mario Rossi, 10A, Apple Inc.: Sviluppo di app per dispositivi mobili");
        progFormList.add("Giulia Bianchi, 11B, Google (Alphabet Inc.): Analisi dati e machine learning");
        progFormList.add("Luca Verdi, 9C, Microsoft Corporation: Sviluppo di software aziendale");
        progFormList.add("Anna Neri, 12D, Tesla, Inc.: Ricerca e sviluppo di tecnologie per veicoli elettrici");
        progFormList.add("Federico Russo, 10A, Facebook, Inc. (Meta Platforms, Inc.): Analisi dei social media e marketing digitale");
        progFormList.add("Sara Gialli, 11B, Samsung Electronics Co., Ltd.: Progettazione di dispositivi elettronici");
        progFormList.add("Matteo Marroni, 9C, Toyota Motor Corporation: Sviluppo di nuove tecnologie per automobili");
        progFormList.add("Martina Blu, 12D, Amazon.com Inc.: Ottimizzazione della logistica e gestione magazzino");
        progFormList.add("Alessio Verde, 10A, Johnson & Johnson: Ricerca e sviluppo di nuovi prodotti farmaceutici");
        progFormList.add("Chiara Rosa, 11B, Procter & Gamble Company: Marketing e analisi di mercato per beni di consumo");
        progFormList.add("Marco Giallo, 9C, Alibaba Group Holding Limited: Analisi dei dati e sviluppo di soluzioni e-commerce");
        progFormList.add("Eleonora Viola, 12D, JPMorgan Chase & Co.: Analisi finanziaria e gestione del rischio");
        progFormList.add("Giovanni Celeste, 10A, Walmart Inc.: Ottimizzazione della catena di approvvigionamento e gestione del magazzino");
        progFormList.add("Valentina Giallo, 11B, Berkshire Hathaway Inc.: Analisi dei mercati finanziari e gestione degli investimenti");
        progFormList.add("Davide Magenta, 9C, Exxon Mobil Corporation: Ricerca e sviluppo di nuove tecnologie per l'estrazione di petrolio e gas");
        progFormList.add("Alice Marrone, 12D, Procter & Gamble Company: Marketing e analisi di mercato per beni di consumo");

        ObservableList<String> observableList = FXCollections.observableArrayList(progFormList);

        progettiListView.setItems(observableList);
    }
}