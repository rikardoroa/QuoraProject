package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DatosItemsController extends Application implements Initializable {
 
	@FXML JFXTextField item;
	@FXML JFXTextField cantidad;
	@FXML JFXComboBox<String> estado;
	@FXML JFXButton Actualizadatos;
	@FXML StackPane stackitems;
	@FXML BorderPane borderitem;
	@FXML Label itemlabel;
	@FXML Label cantidadlabel;
	@FXML Label estadolabel;
	public String getmiitemfinal;
	public String getmicantidadfinal;
	public String getmiconsecutivofinal;
	public Stage GetDatosItemsStage;
	public TableView<Itemapro> misitems;
	public String consecutivofinall;
	
	public String getConsecutivofinal() {
		return consecutivofinall;
	}

	public void setConsecutivofinal(String consecutivofinall) {
		this.consecutivofinall = consecutivofinall;
	}

	public TableView<Itemapro> getMisitems() {
		return misitems;
	}

	public void setMisitems(TableView<Itemapro> misitems) {
		this.misitems = misitems;
	}

	public Stage getGetDatosItemsStage() {
		return GetDatosItemsStage;
	}

	public void setGetDatosItemsStage(Stage getDatosItemsStage) {
		GetDatosItemsStage = getDatosItemsStage;
	}

	public String getGetmiconsecutivofinal() {
		return getmiconsecutivofinal;
	}

	public void setGetmiconsecutivofinal(String getmiconsecutivofinal) {
		this.getmiconsecutivofinal = getmiconsecutivofinal;
	}

	public String getGetmiitemfinal() {
		return getmiitemfinal;
	}

	public void setGetmiitemfinal(String getmiitemfinal) {
		this.getmiitemfinal = getmiitemfinal;
	}

	
	
	public String getGetmicantidadfinal() {
		return getmicantidadfinal;
	}

	public void setGetmicantidadfinal(String getmicantidadfinal) {
		this.getmicantidadfinal = getmicantidadfinal;
	}

	public void llenacomboitems() {
		estado.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
		estado.getItems().addAll("Sin Dato","APROBADO","NO APROBADO");
		estado.getSelectionModel().selectFirst();
	}
	
	public void actualizadatositems() {
		Actualizadatos.setOnMouseClicked(e->{
		try {
			int data = 0;
			if(estado.getSelectionModel().getSelectedItem().equals("APROBADO")) {
				data=1;
			}
			else if(estado.getSelectionModel().getSelectedItem().equals("NO APROBADO")) {
				data=0;
			}
			Conexion Conectardata = new Conexion();
			Connection Conexiondata = null;
			String cantidadfinal=DatosItemsController.this.getGetmicantidadfinal();
			String itemfinal=DatosItemsController.this.getGetmiitemfinal();
			String consecutivofinal=DatosItemsController.this.getGetmiconsecutivofinal();
			estado.getSelectionModel().getSelectedItem();
			Integer cantidad = Integer.parseInt(cantidadfinal);
			Conexiondata=Conectardata.miconexion(Conexiondata);
	        String StringQueryGetData="UPDATE ITEMSREQ SET ITEMAPROBADO='"+data+"' WHERE ITEM LIKE ? AND CNSREQ= ? AND CANTIDAD= ?";
	   		PreparedStatement ps =Conexiondata.prepareStatement(StringQueryGetData);
	   		ps.setString(1, '%'+itemfinal+'%');
	   		ps.setString(2, consecutivofinal );
	   		ps.setInt(3, cantidad);
	   	    ps.executeUpdate();
	   	    Text cabecera = new Text();
			cabecera.setText("DATOS ENVIADOS");
			cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			Text mensaje= new Text();
			mensaje.setText("ITEM ACTUALIZADO CON EXITO");
			mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			JFXDialogLayout contenido = new JFXDialogLayout();
		    contenido.setHeading((cabecera));
			contenido.setBody(mensaje);
			contenido.setPrefSize(280, 100);
			contenido.setStyle(" -fx-background-color:#AAE3AE;");
			JFXDialog dialogo = new JFXDialog(stackitems,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(e3->{
			dialogo.close();
			consecutivofinall=DatosItemsController.this.getConsecutivofinal();
	    	try {
	    		Conexion Conectardatat = new Conexion();
				Connection Conexiondatat = null;
   	       	    ObservableList<Itemapro> midatareqapro= FXCollections.observableArrayList();
   	       		String StringQueryGetDataa=" SELECT (CASE WHEN ITEMSREQ.ITEMAPROBADO IS NULL THEN 'ITEM AUN SIN APROBACION' WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'NO APROBADO' WHEN ITEMSREQ.ITEMAPROBADO=1  \r\n" + 
   	       				"   	       				 THEN 'APROBADO' END     ) AS ITEMAPROBADOREQ, ITEMSREQ.CANTIDAD, ITEMSREQ.ITEM  \r\n" + 
   	       				"   	       				 FROM ITEMSREQ \r\n" + 
   	       				"   	       				 INNER JOIN REQUISICIONESDT ON  REQUISICIONESDT.CNSREQ = ITEMSREQ.CNSREQ AND  \r\n" + 
   	       				"   	       				 CONVERT(varchar(16),REQUISICIONESDT.FECHA_SOLICITUD,20) =CONVERT( varchar(16), ITEMSREQ.FECHA_SOLICITUD,20 )  \r\n" + 
   	       				"   	       				 WHERE ITEMSREQ.CNSREQ='"+consecutivofinall+"'";
   	       	    Conexiondatat = Conectardatat.miconexion(Conexiondatat);
   	   			PreparedStatement pss =Conexiondatat.prepareStatement(StringQueryGetDataa);
   	   	       	ResultSet rs = pss.executeQuery();
   	   	        while(rs.next()) {
   	   	           midatareqapro.add(new Itemapro(
   	   	        	      rs.getString("ITEM"),
   	        		      rs.getInt("CANTIDAD"),
   	        		      rs.getString("ITEMAPROBADOREQ")
                   		  )
   	                      );
   	   	     DatosItemsController.this.getMisitems().setItems(midatareqapro);
   	   		}
   	       	}catch(SQLException ee) {
   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
   	       	}
			DatosItemsController.this.getGetDatosItemsStage().close();
			});
			contenido.setActions(cerrar);
			dialogo.show();    
	       	}catch(SQLException ee) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		llenacomboitems();
		actualizadatositems();
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
