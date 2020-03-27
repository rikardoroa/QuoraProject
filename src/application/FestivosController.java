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
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FestivosController extends Application implements Initializable{

	@FXML StackPane StackFestivos;
	@FXML TabPane tabestivos;
	@FXML public ListView<String> Listadefechas;
	@FXML public ListView<String> Listadiasenero; 
	@FXML public ListView<String> Listadiasmarzo; 
	@FXML public ListView<String> Listadiasabril; 
	@FXML DatePicker dataentrydias;
	@FXML TextField dataenero;
	@FXML TextField datamarzo;
	@FXML TextField dataabril;
	@FXML JFXButton agregar;
	@FXML JFXButton agregardatoe; 
	@FXML JFXButton agregardatom; 
	@FXML JFXButton agregardatoab;
	@FXML JFXButton vdata;
	@FXML JFXButton vdatae;
	@FXML JFXButton vdatam; 
	@FXML JFXButton vdataab;
	@FXML JFXButton deletealldata;
	@FXML JFXButton deletealldatae;
	@FXML JFXButton deletealldatam; 
	@FXML JFXButton deletealldataab;
    String festivo;
    String diasenero;
    String diasmarzo;
    String diasabril;
    String auxdata;
    ObservableList<String> data = FXCollections.observableArrayList();
    ObservableList<String> enerod = FXCollections.observableArrayList();
    ObservableList<String> dataenerot = FXCollections.observableArrayList();
    ObservableList<String> marzo = FXCollections.observableArrayList();
    ObservableList<String> datamarzot = FXCollections.observableArrayList();
    ObservableList<String> abril = FXCollections.observableArrayList();
    ObservableList<String> databrilt = FXCollections.observableArrayList();
    ObservableList<String> auxdatax = FXCollections.observableArrayList();
    Conexion conectar = new Conexion();
    
	public void entrydatafechasfestivo() {
		agregar.setOnAction(e->{
			if(!Listadefechas.getItems().isEmpty()) {
				Mensaje errorb = new Mensaje();
				errorb.mensajeerrorb(StackFestivos);
			}
			else {
		festivo=dataentrydias.getValue().toString();
			Listadefechas.getItems().add(festivo);
			}
		});
		Listadefechas.setOnMouseClicked(e->{
			String deleteitem = Listadefechas.getSelectionModel().getSelectedItem();
			Listadefechas.getItems().remove(deleteitem);
		});
	}
	
	
	public void entrydatadiasenero() {
		agregardatoe.setOnAction(e->{
		diasenero=dataenero.getText().toString();
		Listadiasenero.getItems().add(diasenero);
			
		});
		Listadiasenero.setOnMouseClicked(e->{
			String deleteitem = Listadiasenero.getSelectionModel().getSelectedItem();
			Listadiasenero.getItems().remove(deleteitem);
		});
	}
	
	public void entrydatadiasmarzo() {
		agregardatom.setOnAction(e->{
		diasmarzo=datamarzo.getText().toString();
		Listadiasmarzo.getItems().add(diasmarzo);
		});
		Listadiasmarzo.setOnMouseClicked(e->{
			String deleteitem = Listadiasmarzo.getSelectionModel().getSelectedItem();
			Listadiasmarzo.getItems().remove(deleteitem);
		});
	}
	
	
	public void entrydatadiasabril() {
		agregardatoab.setOnAction(e->{
		diasabril=dataabril.getText().toString();
		Listadiasabril.getItems().add(diasabril);
		});
		Listadiasabril.setOnMouseClicked(e->{
			String deleteitem = Listadiasabril.getSelectionModel().getSelectedItem();
			Listadiasabril.getItems().remove(deleteitem);
		});
	}
	
	
	
	public void agregardatos() {
		vdata.setOnAction(e->{
			try {
			for(int x=0;x<Listadefechas.getItems().size();x++) {
				 data=Listadefechas.getItems();
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
	
	public void agregardatosenero() {
		vdatae.setOnAction(e->{
			try {
			for(int x=0;x<Listadiasenero.getItems().size();x++) {
				 enerod=Listadiasenero.getItems();
			}
			for(int y=0; y<enerod.size();y++) {
				auxdata=enerod.get(y);
	    	    		String Queryinsertitem="INSERT INTO ENERO (DIAENERO)VALUES(?)";
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
	
	public void agregardatosmarzo() {
		vdatam.setOnAction(e->{
			try {
			for(int x=0;x<Listadiasmarzo.getItems().size();x++) {
				 marzo=Listadiasmarzo.getItems();
			}
			for(int y=0; y<marzo.size();y++) {
				auxdata=marzo.get(y);
	    	    		String Queryinsertitem="INSERT INTO MARZO (DIAMARZO)VALUES(?)";
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
	
	
	public void agregardatosabril() {
		vdataab.setOnAction(e->{
			try {
			for(int x=0;x<Listadiasabril.getItems().size();x++) {
				 abril=Listadiasabril.getItems();
			}
			for(int y=0; y<abril.size();y++) {
				auxdata=abril.get(y);
	    	    		String Queryinsertitem="INSERT INTO ABRIL (DIAABRIL)VALUES(?)";
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
	
	
	public void visualizadatosenero() {
		try {
			String QuerySelectData="SELECT DIAENERO FROM ENERO";
    		Connection ConexionData = null;
    		ConexionData=conectar.miconexion(ConexionData);
    		PreparedStatement creadatafecha = ConexionData.prepareStatement(QuerySelectData);
    		ResultSet rs = creadatafecha.executeQuery();
	   	        while(rs.next()) {
	   	        	dataenerot.add(rs.getString("DIAENERO"));
	   	        }
		}catch(SQLException ex) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
   	}	
		 Listadiasenero.setItems(dataenerot);
		 for(int t=0;t<Listadiasenero.getItems().size();t++) {
			 if(Listadiasenero.getItems().get(t).equals(null)) {
				 Listadiasenero.setDisable(false);
				 vdatae.setDisable(false);
				 agregardatoe.setDisable(false);
			 }
			 if(!Listadiasenero.getItems().get(t).equals(null)) {
				 Listadiasenero.setDisable(true);
				 vdatae.setDisable(true);
				 agregardatoe.setDisable(true);
			 }
		 }
	}
	
	
	
	public void visualizadatosmarzo() {
		try {
			String QuerySelectData="SELECT DIAMARZO FROM MARZO";
    		Connection ConexionData = null;
    		ConexionData=conectar.miconexion(ConexionData);
    		PreparedStatement creadatafecha = ConexionData.prepareStatement(QuerySelectData);
    		ResultSet rs = creadatafecha.executeQuery();
	   	        while(rs.next()) {
	   	        	datamarzot.add(rs.getString("DIAMARZO"));
	   	        }
		}catch(SQLException ex) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
   	}	
		 Listadiasmarzo.setItems(datamarzot);
		 for(int t=0;t<Listadiasmarzo.getItems().size();t++) {
			 if(Listadiasmarzo.getItems().get(t).equals(null)) {
				 Listadiasmarzo.setDisable(false);
				 vdatam.setDisable(false);
				 agregardatom.setDisable(false);
			 }
			 if(!Listadiasmarzo.getItems().get(t).equals(null)) {
				 Listadiasmarzo.setDisable(true);
				 vdatam.setDisable(true);
				 agregardatom.setDisable(true);
			 }
		 }
	}
	
	
	public void visualizadatosabril() {
		try {
			String QuerySelectData="SELECT DIAABRIL FROM ABRIL";
    		Connection ConexionData = null;
    		ConexionData=conectar.miconexion(ConexionData);
    		PreparedStatement creadatafecha = ConexionData.prepareStatement(QuerySelectData);
    		ResultSet rs = creadatafecha.executeQuery();
	   	        while(rs.next()) {
	   	        	databrilt.add(rs.getString("DIAABRIL"));
	   	        }
		}catch(SQLException ex) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
   	}	
		 Listadiasabril.setItems(databrilt);
		 for(int t=0;t<Listadiasabril.getItems().size();t++) {
			 if(Listadiasabril.getItems().get(t).equals(null)) {
				 Listadiasabril.setDisable(false);
				 vdataab.setDisable(false);
				 agregardatoab.setDisable(false);
			 }
			 if(!Listadiasabril.getItems().get(t).equals(null)) {
				 Listadiasabril.setDisable(true);
				 vdataab.setDisable(true);
				 agregardatoab.setDisable(true);
			 }
		 }
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
			 Listadefechas.setItems(auxdatax);
			 for(int t=0;t<Listadefechas.getItems().size();t++) {
				 if(Listadefechas.getItems().get(t).equals(null)) {
					 Listadefechas.setDisable(false);
					 vdata.setDisable(false);
					 agregar.setDisable(false);
				 }
				 if(!Listadefechas.getItems().get(t).equals(null)) {
					 Listadefechas.setDisable(true);
					 vdata.setDisable(true);
					 agregar.setDisable(true);
				 }
			 }
			 
			 //-----------muestra los meses en un observablelist que aun no necesito--//
			/* for(int yy=0; yy<auxdatax.size();yy++) {
				 System.out.println(auxdatax.get(yy));
			 }*/

	}

	
	public void deletedata() {
		deletealldata.setOnAction(e->{
			Text cabecera = new Text();
			cabecera.setText("ADVERTENCIA");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("SE VAN A ELIMINAR TODOS LOS DATOS, ESTE PROCESO NO SE PUEDE DESHACER");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			contenido.setPrefWidth(314);
			contenido.setPrefHeight(180);
			contenido.getChildren().add(mensaje);
			mensaje.setLayoutY(700);
			JFXDialog dialogo = new JFXDialog(StackFestivos,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cancelar = new JFXButton("CANCELAR");
			cancelar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cancelar.setOnAction(ee->{
			dialogo.close();
			});
			contenido.setActions(cancelar);
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
    		contenido.getChildren().addAll(Aceptar,cancelar);
    		StackPane.setAlignment(Aceptar, Pos.BOTTOM_CENTER);
    		StackPane.setAlignment(cancelar, Pos.BOTTOM_RIGHT);	
		});
			
	}
	
	
	public void deletedataenero() {
		deletealldatae.setOnAction(e->{
			Text cabecera = new Text();
			cabecera.setText("ADVERTENCIA");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("SE VAN A ELIMINAR TODOS LOS DATOS, ESTE PROCESO NO SE PUEDE DESHACER");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			contenido.setPrefWidth(314);
			contenido.setPrefHeight(180);
			contenido.getChildren().add(mensaje);
			mensaje.setLayoutY(700);
			JFXDialog dialogo = new JFXDialog(StackFestivos,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cancelar = new JFXButton("CANCELAR");
			cancelar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cancelar.setOnAction(ee->{
			dialogo.close();
			});
			contenido.setActions(cancelar);
			dialogo.show();
    		JFXButton Aceptar = new JFXButton("ACEPTAR");
    		Aceptar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
    		Aceptar.setOnAction(ee->{
    			try {
    	    		Connection ConexionData = null;
    	    		ConexionData=conectar.miconexion(ConexionData);
    	    		CallableStatement delall = ConexionData.prepareCall("{call DELETETABLEENERO}");
    	    		delall.execute();
    	    		delall.close();
    			}catch(SQLException ex) {
   		       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
   	   	     }
    			dialogo.close();
    		});
    		contenido.setActions(Aceptar);
    		contenido.getChildren().addAll(Aceptar,cancelar);
    		StackPane.setAlignment(Aceptar, Pos.BOTTOM_CENTER);
    		StackPane.setAlignment(cancelar, Pos.BOTTOM_RIGHT);	
		});	
	}
	
	
	public void deletedatamarzo() {
		deletealldatam.setOnAction(e->{
			Text cabecera = new Text();
			cabecera.setText("ADVERTENCIA");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("SE VAN A ELIMINAR TODOS LOS DATOS, ESTE PROCESO NO SE PUEDE DESHACER");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			contenido.setPrefWidth(314);
			contenido.setPrefHeight(180);
			contenido.getChildren().add(mensaje);
			mensaje.setLayoutY(700);
			JFXDialog dialogo = new JFXDialog(StackFestivos,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cancelar = new JFXButton("CANCELAR");
			cancelar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cancelar.setOnAction(ee->{
			dialogo.close();
			});
			contenido.setActions(cancelar);
			dialogo.show();
    		JFXButton Aceptar = new JFXButton("ACEPTAR");
    		Aceptar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
    		Aceptar.setOnAction(ee->{
    			try {
    	    		Connection ConexionData = null;
    	    		ConexionData=conectar.miconexion(ConexionData);
    	    		CallableStatement delall = ConexionData.prepareCall("{call DELETETABLEMARZO}");
    	    		delall.execute();
    	    		delall.close();
    			}catch(SQLException ex) {
   		       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
   	   	     }
    			dialogo.close();
    		});
    		contenido.setActions(Aceptar);
    		contenido.getChildren().addAll(Aceptar,cancelar);
    		StackPane.setAlignment(Aceptar, Pos.BOTTOM_CENTER);
    		StackPane.setAlignment(cancelar, Pos.BOTTOM_RIGHT);	
		});	
	}
	
	public void deletedataabril() {
		deletealldataab.setOnAction(e->{
			Text cabecera = new Text();
			cabecera.setText("ADVERTENCIA");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("SE VAN A ELIMINAR TODOS LOS DATOS, ESTE PROCESO NO SE PUEDE DESHACER");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			contenido.setPrefWidth(314);
			contenido.setPrefHeight(180);
			contenido.getChildren().add(mensaje);
			mensaje.setLayoutY(700);
			JFXDialog dialogo = new JFXDialog(StackFestivos,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cancelar = new JFXButton("CANCELAR");
			cancelar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cancelar.setOnAction(ee->{
			dialogo.close();
			});
			contenido.setActions(cancelar);
			dialogo.show();
    		JFXButton Aceptar = new JFXButton("ACEPTAR");
    		Aceptar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
    		Aceptar.setOnAction(ee->{
    			try {
    	    		Connection ConexionData = null;
    	    		ConexionData=conectar.miconexion(ConexionData);
    	    		CallableStatement delall = ConexionData.prepareCall("{call DELETETABLEABRIL}");
    	    		delall.execute();
    	    		delall.close();
    			}catch(SQLException ex) {
   		       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
   	   	     }
    			dialogo.close();
    		});
    		contenido.setActions(Aceptar);
    		contenido.getChildren().addAll(Aceptar,cancelar);
    		StackPane.setAlignment(Aceptar, Pos.BOTTOM_CENTER);
    		StackPane.setAlignment(cancelar, Pos.BOTTOM_RIGHT);	
		});	
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		entrydatafechasfestivo();
		agregardatos();
		visualizadatos();
		 deletedata();
		 entrydatadiasenero();
		 agregardatosenero();
		 visualizadatosenero();
		 deletedataenero();
		 entrydatadiasmarzo();
		 agregardatosmarzo();
		 visualizadatosmarzo();
		 deletedatamarzo();
		 entrydatadiasabril();
		 agregardatosabril();
		 visualizadatosabril();
		 deletedataabril();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	



}
