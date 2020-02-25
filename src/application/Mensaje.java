package application;

import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Mensaje {


	public Object mensaje( @SuppressWarnings("rawtypes") TableView table, StackPane Stack) {
    	ObservableList<?> items = table.getItems();
    	if(items.isEmpty()) {
    	        Text cabecera = new Text();
			 	cabecera.setText("NOTIFICACION");
				cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
				Text mensaje= new Text();
				mensaje.setText("DATOS NO ENCONTRADOS");
				mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
				JFXDialogLayout contenido = new JFXDialogLayout();
			    contenido.setHeading((cabecera));
				contenido.setBody(mensaje);
				contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
				JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
				JFXButton cerrar = new JFXButton("CERRAR");
				cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
				cerrar.setOnAction(e3->{
				dialogo.close();
				});
				contenido.setActions(cerrar);
				dialogo.show(); 
    	}
		return items;
    }
	

	public Object mensajedata( @SuppressWarnings("rawtypes") TableView table, StackPane Stack) {
    	ObservableList<?> items = table.getItems();
    	if(items.isEmpty()) {
    	        Text cabecera = new Text();
			 	cabecera.setText("ERROR");
				cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
				Text mensaje= new Text();
				mensaje.setText("CAMPOS VACIOS");
				mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
				JFXDialogLayout contenido = new JFXDialogLayout();
			    contenido.setHeading((cabecera));
				contenido.setBody(mensaje);
				contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
				JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
				JFXButton cerrar = new JFXButton("CERRAR");
				cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
				cerrar.setOnAction(e3->{
				dialogo.close();
				});
				contenido.setActions(cerrar);
				dialogo.show(); 
    	}
		return items;
    }
	
	
	public Object mensajedatosconbd(  StackPane Stack) {
		Text cabecera = new Text();
		cabecera.setText("CONEXION EXITOSA");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS ENVIADOS CON EXITO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
    	}
	
	
	
	public Object mensajedatosconbddos(  StackPane Stack) {
		Text cabecera = new Text();
		cabecera.setText("DATOS ELIMINADOS");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("PROCESO EJECUTADO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
    	}
	
	public Object mensajedatosRQcerrada(  StackPane Stack) {
		Text cabecera = new Text();
		cabecera.setText("INFORMACION");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("REQUISICION CERRADA POR EL USUARIO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
    	}
	
	public Object mensajenotificacion(  StackPane Stack) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("NO PUEDE REVISAR REQUISICIONES DE OTRA AREA");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
    	}
	
	public Object mensajedatosfechas(  StackPane StackFechas, Stage mistage) {
		Text cabecera = new Text();
		cabecera.setText("NOTIFICACION");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("NO PUEDE RECIBIR LOS ITEMS, AUN NO ES LA FECHA DE RECEPCION");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(StackFechas,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e->{
		dialogo.close();
		mistage.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
    	}
	

	public Object mensajecierrastage(  StackPane Stack, Stage Stage) {
		Text cabecera = new Text();
		cabecera.setText("CONEXION EXITOSA");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS ENVIADOS CON EXITO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e->{
		dialogo.close();
		Stage.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
    	}

	
	
	
	public Object mensajeerror(  StackPane StackError) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:white;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS NO PUEDEN ESTAR VACIOS");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color: #EE6868;");
		JFXDialog dialogo = new JFXDialog(StackError,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrarError = new JFXButton("CERRAR");
		cerrarError.setStyle(" -fx-background-color: yellow;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrarError.setOnAction(e->{
		dialogo.close();
		});
		contenido.setActions(cerrarError);
		dialogo.show();
		return cerrarError;
    	}
		
	public Object warningmessage(  StackPane StackError) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:white;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DEBE ESCOGER EL TIPO DE INCIDENTE O EL AREA");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color: #EE6868;");
		JFXDialog dialogo = new JFXDialog(StackError,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrarErrorW = new JFXButton("CERRAR");
		cerrarErrorW.setStyle(" -fx-background-color: yellow;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrarErrorW.setOnAction(e->{
		dialogo.close();
		});
		contenido.setActions(cerrarErrorW);
		dialogo.show();
		return cerrarErrorW;
    	}
	
	
	public Object Usercancelmessage(  StackPane StackUserMessage) {
		    Text cabecera = new Text();
			cabecera.setText("ADVERTENCIA");
			cabecera.setStyle("-fx-fill:yellow;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("OPERACION CANCELADA POR EL USUARIO");
			mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setStyle(" -fx-background-color: linear-gradient( from 100.0% 200.0% to 200.0% 100.0%, rgb(255,102,102) 0.0, rgb(255,179,179) 100.0);");
			JFXDialog dialogo = new JFXDialog(StackUserMessage,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton Usercancelmessage = new JFXButton("CERRAR");
			Usercancelmessage.setStyle(" -fx-background-color: yellow;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			Usercancelmessage.setOnAction(e3->{
			dialogo.close();
			});
			contenido.setActions(Usercancelmessage);
			dialogo.show();
		return Usercancelmessage;
    	}
	
	
	public Object Mensajetextfield( StackPane Stackftmessage, TextField Text) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("EL CAMPO CANTIDAD DEBE SER FORMATO NUMERICO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stackftmessage,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrarft = new JFXButton("CERRAR");
		cerrarft.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrarft.setOnAction(e3->{
		Text.setStyle("-fx-background-color: rgb(218, 242, 220);-fx-border-color:#99cc99;-fx-font-weight: bold; -fx-font-family: 'Oswald Regular';-fx-font-size: 14px; -fx-text-fill:black;");			
		dialogo.close();
		});
		contenido.setActions(cerrarft);
		dialogo.show();
		return cerrarft;  
	}
	
	
	public Object Mensajefechas( StackPane Stackftfechas, DatePicker Date, DatePicker Date2) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("FECHAS VACIAS, POR FAVOR ESCOJA FECHAS PARA EL FILTRADO DE DATOS");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stackftfechas,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrarft = new JFXButton("CERRAR");
		cerrarft.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrarft.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrarft);
		dialogo.show();
		return cerrarft;  
	}
	
  public Object deshabilitacampo(StackPane Mistack, TextField A, TextField B) {
		    Text cabecera = new Text();
			cabecera.setText("ERROR");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("LIMITE DE CARACTERES SUPERADO, MINIMO 30 CARACTERES");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			JFXDialog dialogo = new JFXDialog(Mistack,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrarft = new JFXButton("CERRAR");
			cerrarft.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrarft.setOnAction(e3->{
			dialogo.close();
			A.clear();
			B.setDisable(false);
			A.setDisable(false);
			A.setStyle("-fx-background-color: rgb(218, 242, 220);-fx-border-color:#99cc99;-fx-font-weight: bold; -fx-font-family: 'Oswald Regular';-fx-font-size: 16px; -fx-text-fill:black;");
			});
			contenido.setActions(cerrarft);
			dialogo.show();
			return cerrarft; 
  }
	
  
  public Object mensajeitem( StackPane StackPaneitem) {
	    Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("ESTE ITEM NO SE PUEDE RECIBIR, YA QUE FUE NO APROBADO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(StackPaneitem,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar; 
  }
  
  public Object mensajeitemR ( StackPane StackPaneitemR) {
	    Text cabecera = new Text();
		cabecera.setText("INFORMACION");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("ESTE ITEM YA FUE CONFIRMADO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(StackPaneitemR,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar; 
}
  
  


  public Object mensajeitemdatauno(StackPane StackPaneitemR, Stage stage) {
	  Text cabecera = new Text();
	  cabecera.setText("DATOS ACTUALIZADOS");
	  cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
	  Text mensaje= new Text();
	  mensaje.setText("REQUISICION RECIBIDA EXITOSAMENTE");
	  mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
	  JFXDialogLayout contenido = new JFXDialogLayout();
	  contenido.setHeading((cabecera));
	  contenido.setBody(mensaje);
	  contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
	  JFXDialog dialogo = new JFXDialog(StackPaneitemR,contenido, JFXDialog.DialogTransition.CENTER);
	  JFXButton cerrar = new JFXButton("CERRAR");
	  cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
	  cerrar.setOnAction(e3->{
	  dialogo.close();
	  });
	  contenido.setActions(cerrar);
	  stage.close();
	  dialogo.show();
	  return cerrar;
  }
  
  
  public Object reqmsjrev (StackPane Stack) {
	        Text cabecera = new Text();
			cabecera.setText("DETALLE");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("REQUISICION EN ESTADO DE REVISION Y AUN SIN APROBACION");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(e3->{
			dialogo.close();
			});
			contenido.setActions(cerrar);
			dialogo.show();
			return cerrar; 
  }
  
  public Object reqmsjrevnoapro (StackPane Stack) {
      Text cabecera = new Text();
		cabecera.setText("DETALLE");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("REQUISICION RECHAZADA");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar; 
}
  
  public Object Reqaprobada(StackPane Stack) {
	        Text cabecera = new Text();
			cabecera.setText("DETALLE");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("REQUISICION REVISADA Y APROBADA");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(e3->{
			dialogo.close();
			});
			contenido.setActions(cerrar);
			dialogo.show();
			return cerrar; 	
  }
  
  public Object mensajecc(StackPane Stack) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("POR FAVOR VERIFIQUE TODOS LOS DATOS");
		mensaje.setStyle("-fx-fill:red;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle("-fx-background-color:rgb(243,197,86);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular'-Regular;-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }

  
  public Object mensajedeerror(StackPane Stack) {
	   Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS NO ENCONTRADOS");
		mensaje.setStyle("-fx-fill:red;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle("-fx-background-color:rgb(243,197,86);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular'-Regular;-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  public Object mensajerrorform(StackPane Stack) {
	    Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("POR FAVOR VERIFIQUE TODOS LOS DATOS DEL FORMULARIO");
		mensaje.setStyle("-fx-fill:red;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle("-fx-background-color:rgb(255,255,198);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular'-Regular;-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  public Object errormensajeimagen(StackPane Stack) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("POR FAVOR CARGUE LA IMAGEN");
		mensaje.setStyle("-fx-fill:red;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle("-fx-background-color:rgb(255,255,198);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular'-Regular;-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  
  public Object conexionexitosa(StackPane Stack) {
	  Text cabecera = new Text();
		cabecera.setText("CONEXION EXITOSA");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS ACTUALIZADOS CON EXITO");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color: #AAE3AE;");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family:'Oswald Regular'-Regular; -fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  public Object conexionexitosatable(StackPane Stack, TableView<fechareqitems> table) {
	  Text cabecera = new Text();
		cabecera.setText("CONEXION EXITOSA");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS ACTUALIZADOS CON EXITO");
		mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color: #AAE3AE;");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: black;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family:'Oswald Regular'-Regular; -fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		table.refresh();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  
  public Object marcadatos (StackPane Stackpane) {
	    Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("MARQUE LOS DATOS");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stackpane,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnMouseClicked(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;	
  }
  
  
  public Object confirmadata(StackPane Stack) {
	  Text cabecera = new Text();
	 	cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("OPCION NO VALIDA");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar; 
  }
  
  
  public Object msjgraficos(StackPane Stack) {
		Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS VACIOS, ESCOJA LAS FECHAS DE CONSULTA Y LA OPCION DEL GRAFICO");
		mensaje.setStyle("-fx-fill:red;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:rgb(243,197,86);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(ee->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  public Object datosinvalidos(StackPane Stack) {
	  Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("POR FAVOR INTENTE NUEVAMENTE USUARIO O CONTRASEÑA INVALIDOS");
		mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  
  public Object SQlmsj(StackPane Stack, SQLException e) {
	  Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("ERROR INESPERADO:"+e);
		mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar; 
  }
  
  
  public Object Reqmsj(StackPane Stack) {
	  Text cabecera = new Text();
		cabecera.setText("DATOS ENVIADOS");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("REQUISICION  CREADA CON EXITO");
		mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
  
  
  public Object reqapro (StackPane Stack) {
	  Text cabecera = new Text();
			cabecera.setText("DETALLE");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("REQUISICION APROBADA");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(e3->{
			dialogo.close();
			});
			contenido.setActions(cerrar);
			dialogo.show();
			return cerrar;
  }
  
  public Object Permisoadminuno(StackPane Stack) {
	  Text cabecera = new Text();
		 	cabecera.setText("DETALLE");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("NO TIENE PERMISOS PARA ACCEDER A ESTA VENTANA");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(e3->{
			dialogo.close();
			});
			contenido.setActions(cerrar);
			dialogo.show();
			return cerrar; 	
  }
  
  
  public Object msjpermisosreq(StackPane Stack) {
	         Text cabecera = new Text();
			cabecera.setText("ERROR");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("NO TIENE PERMISOS PARA RECIBIR ESTA REQUISICION");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(e3->{
			dialogo.close();
			});
			contenido.setActions(cerrar);
			dialogo.show();
			return cerrar; 
  }
  
  
  public Object recepcionreq(StackPane Stack) {
	    Text cabecera = new Text();
		cabecera.setText("INFORMACION");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("YA ESTA REQUISICION FUE RECIBIDA");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar; 
  }
  
  public Object validacion (StackPane Stack) {
	    Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("DATOS YA FUERON VALIDADOS");
		mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
  });
		return cerrar;
  }
  
  public Object datosvacios(StackPane Stack) {
	  Text cabecera = new Text();
		cabecera.setText("ERROR");
		cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		Text mensaje= new Text();
		mensaje.setText("CAMPOS VACIOS, DIGITE LA INFORMACIÓN");
		mensaje.setStyle("-fx-fill:red;-fx-font-weight:bold");
		JFXDialogLayout contenido = new JFXDialogLayout();
	    contenido.setHeading((cabecera));
		contenido.setBody(mensaje);
		contenido.setStyle("-fx-background-color:rgb(243,197,86);");
		JFXDialog dialogo = new JFXDialog(Stack,contenido, JFXDialog.DialogTransition.CENTER);
		JFXButton cerrar = new JFXButton("CERRAR");
		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		cerrar.setOnAction(e3->{
		dialogo.close();
		});
		contenido.setActions(cerrar);
		dialogo.show();
		return cerrar;
  }
	
}

