package application;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FestivosController extends Application implements Initializable{

	@FXML StackPane StackFestivos;
	@FXML TabPane tabestivos;
	@FXML public ListView<String> Listadedias;
	@FXML DatePicker dataentrydias;
	@FXML JFXButton agregar;
	@FXML JFXButton vdata;
	@FXML JFXButton deletealldata;
    String festivo;
    String auxdata;
    ObservableList<String> data = FXCollections.observableArrayList();
    ObservableList<String> auxdatax = FXCollections.observableArrayList();
    Conexion conectar = new Conexion();
    
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
	
	public void agregardatos() {
		vdata.setOnAction(e->{
			try {
			for(int x=0;x<Listadedias.getItems().size();x++) {
				 data=Listadedias.getItems();
			}
			for(int y=0; y<data.size();y++) {
				auxdata=data.get(y);
		  		 
	    	    		String Queryinsertitem="INSERT INTO FESTIVOS (FECHAFESTIVO)VALUES(?)";
	    	    		Connection ConexionData = null;
	    	    		ConexionData=conectar.miconexion(ConexionData);
	    	    		PreparedStatement creadatafecha = ConexionData.prepareStatement(Queryinsertitem);
	    	    		creadatafecha.setString(1, auxdata);
	    	    		creadatafecha.executeUpdate();
	    	    	 	
	    	    	
			}
			
			Mensaje data = new Mensaje();
	       	data.mensajedatosconbd(StackFestivos);
			 }catch(SQLException ex) {
	 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
	    	}
		});
	
	}
	
	public void visualizadatos() {
			try {
				
				String QuerySelectData="SELECT FECHAFESTIVO FROM FESTIVOS";
	    		Connection ConexionData = null;
	    		ConexionData=conectar.miconexion(ConexionData);
	    		PreparedStatement creadatafecha = ConexionData.prepareStatement(QuerySelectData);
	    		ResultSet rs = creadatafecha.executeQuery();
		   	        while(rs.next()) {
		   	        	auxdatax.add(rs.getString("FECHAFESTIVO"));
		   	        }
			}catch(SQLException ex) {
		       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
	   	}	
			 Listadedias.setItems(auxdatax);
			 for(int t=0;t<Listadedias.getItems().size();t++) {
				 if(Listadedias.getItems().get(t).equals(null)) {
					 Listadedias.setDisable(false);
				 }
				 if(!Listadedias.getItems().get(t).equals(null)) {
					 Listadedias.setDisable(true);
				 }
			 }

	}

	
	public void deletedata() {
		deletealldata.setOnAction(e->{
			
			Text cabecera = new Text();
			cabecera.setText("NOTIFICACION");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("NO PUEDE RECIBIR LOS ITEMS, AUN NO ES LA FECHA DE RECEPCION");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			/*contenido.setBody(mensaje);*/
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			contenido.setPrefWidth(314);
			contenido.setPrefHeight(130);
			contenido.getChildren().add(mensaje);
			mensaje.setLayoutY(700);
			
			JFXDialog dialogo = new JFXDialog(StackFestivos,contenido, JFXDialog.DialogTransition.CENTER);
			
			
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(ee->{
			dialogo.close();
			});
			contenido.setActions(cerrar);
			dialogo.show();
	    		
			
    		JFXButton Aceptar = new JFXButton("ACEPTAR");
    		Aceptar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
    		Aceptar.setOnAction(ee->{
    			try {
    	    		Connection ConexionData = null;
    	    		ConexionData=conectar.miconexion(ConexionData);
    	    		CallableStatement delall = ConexionData.prepareCall("{call DELETETABLE}");
    	    		delall.execute();
    	    		delall.close();
    			}catch(SQLException ex) {
   		       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
   	   	     }
    			dialogo.close();
    		});
	    	
    		contenido.setActions(Aceptar);
    		contenido.getChildren().addAll(Aceptar,cerrar);
    		StackPane.setAlignment(Aceptar, Pos.BOTTOM_CENTER);
    		StackPane.setAlignment(cerrar, Pos.BOTTOM_RIGHT);
	    	
	    	
	    		
	    		    		
	    		
	    		/*Mensaje data = new Mensaje();
		       	data.mensajedatosconbddos(StackFestivos);*/
				
		});
			
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		entrydatafechasfestivo();
		agregardatos();
		visualizadatos();
		 deletedata();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	



}
