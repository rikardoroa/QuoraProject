package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TablaUpdate extends Application implements Initializable{

	@FXML JFXTextField testimadoi;
	@FXML JFXTextField fprogramadai;
	@FXML JFXTextField fejcutadai;
	@FXML JFXTextField hsolucioni;
	@FXML JFXTextField trespuestai;
	@FXML JFXTextField tejecutadai;
	@FXML JFXTextArea novedadesi;
	@FXML JFXTextField prioridadi;
	@FXML JFXTextField verificacioni;
	@FXML Label fprogram;
	@FXML Label ttestimado;
	@FXML Label ffejecutada;
	@FXML Label hsol;
	@FXML Label ttrespuesta;
	@FXML Label tareaejecutada;
	@FXML Label nnovedades;
	@FXML Label prioridad;
	@FXML Label vverificacion;
	@FXML Label detallesoporte;
	@FXML JFXButton updatetablein;
	@FXML StackPane stackpaneup;
	
	public static void main(String[] args) {

	}

	
	
	public void styleddata() {
		testimadoi.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		fprogramadai.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		fejcutadai.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		hsolucioni.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		trespuestai.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		tejecutadai.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		novedadesi.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
		prioridadi.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		verificacioni.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
	}
	
	
	
	
	public void disabledata() {
	    testimadoi.setDisable(true);
		fprogramadai.setDisable(true);
		fejcutadai.setDisable(true);
		hsolucioni.setDisable(true);
	    trespuestai.setDisable(true);
		tejecutadai.setDisable(true);
		prioridadi.setDisable(true);
		verificacioni.setDisable(true);
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		disabledata() ;
		styleddata();
	}

	@Override
	public void start(Stage arg0) throws Exception {

		
	}

}