package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FestivosController extends Application implements Initializable{

	@FXML StackPane StackFestivos;
	@FXML TabPane tabestivos;
	@FXML public ListView<String> Listadedias;
	@FXML DatePicker dataentrydias;
	@FXML JFXButton agregar;
	@FXML JFXButton vdata;
    String festivo;
    String auxdata;
    ObservableList<String> data;
	public void entrydatafechasfestivo() {
		
		agregar.setOnAction(e->{
		festivo=dataentrydias.getValue().toString();
			Listadedias.getItems().add(festivo);
		});
		Listadedias.setOnMouseClicked(e->{
			String deleteitem = Listadedias.getSelectionModel().getSelectedItem();
			Listadedias.getItems().remove(deleteitem);
		
			
		});
		
	}
	
	public void visualizadatos() {
		vdata.setOnAction(e->{
			for(int x=0;x<Listadedias.getItems().size();x++) {
				 data=Listadedias.getItems();
			
			}
			for(int y=0; y<data.size();y++) {
				auxdata=data.get(y);
				System.out.println(auxdata);
			}
		
		});
	
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		entrydatafechasfestivo();
		visualizadatos();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	



}
