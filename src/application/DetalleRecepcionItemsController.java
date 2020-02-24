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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetalleRecepcionItemsController extends Application implements Initializable{
	@FXML public StackPane stackrepfinaldata;
	@FXML public Label itemrepfinal;
	@FXML public Label cantidadrepfinal;
	@FXML public Label estadorepfinal;
	@FXML public JFXTextField itemrepfinaltx;
	@FXML public JFXTextField cantidadrepfinaltx;
	@FXML public JFXComboBox<String> estadorepfinaltx;
	@FXML public JFXButton actualizarepfdata;
	public String consecutivoitem;
	public String cnsreq;
	public Stage rep;
	private TableView<itemrep> loaddata;
	private JFXButton confirmareqrep;
	public StackPane stackreqrep;
	Conexion Conecta = new Conexion();
	Connection ConexionData=null;
	public Stage getStageuno;
	public String getstring;

	public StackPane getStackreqrep() {
		return stackreqrep;
	}

	public void setStackreqrep(StackPane stackreqrep) {
		this.stackreqrep = stackreqrep;
	}
	public String getGetstring() {
		return getstring;
	}

	public void setGetstring(String getstring) {
		this.getstring = getstring;
	}

	public Stage getGetStageuno() {
		return getStageuno;
	}

	public void setGetStageuno (Stage getStageuno) {
		this.getStageuno = getStageuno;
	}

	public TableView<itemrep> getRecepcion() {
		return loaddata;
	}
	
	public void setRecepcion(TableView<itemrep> tablereqrep) {
		this.loaddata = tablereqrep;
	}


	public Stage getRep() {
		return rep;
	}

	public void setRep(Stage rep) {
		this.rep = rep;
	}

	public String getConsecutivoitem() {
		return consecutivoitem;
	}

	public void setConsecutivoitem(String consecutivoitem) {
		this.consecutivoitem = consecutivoitem;
	}

	public String getCnsreq() {
		return cnsreq;
	}

	public void setCnsreq(String cnsreq) {
		this.cnsreq = cnsreq;
	}
	
	public void styleddata() {
		itemrepfinaltx.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		cantidadrepfinaltx.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		actualizarepfdata.setStyle(" -fx-background-color:#F97D2D;-fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: white;");
		estadorepfinaltx.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
		estadorepfinaltx.getItems().addAll("ESCOJA UNA OPCION","RECIBIDO","NO RECIBIDO");
		estadorepfinaltx.getSelectionModel().selectFirst();
	}
	
	public void disabledata() {
		itemrepfinaltx.setDisable(true);
		cantidadrepfinaltx.setDisable(true);
	    }
	

	public void actualizadata() throws SQLException {

		actualizarepfdata.setOnAction(e->{
			String datac = estadorepfinaltx.getSelectionModel().getSelectedItem().toString();
			 if(datac.equals("ESCOJA UNA OPCION")) {
			       Mensaje msj = new Mensaje();
			       msj.confirmadata(stackrepfinaldata);
			 }
			else {
			try {
			
			String cnsitem=DetalleRecepcionItemsController.this.getConsecutivoitem();
			String cnsreq=DetalleRecepcionItemsController.this.getCnsreq();
			String item =itemrepfinaltx.getText().toString();
			int data=0;
			if(estadorepfinaltx.getSelectionModel().getSelectedItem().equals("NO RECIBIDO")) {
				data=0;
			}
			if(estadorepfinaltx.getSelectionModel().getSelectedItem().equals("RECIBIDO")) {
				data=1;
			}
	    	  ConexionData=Conecta.miconexion(ConexionData);
		      String updatedata="UPDATE ITEMSREQ SET RECIBIDO='"+data+"'  WHERE CNSITEMREQ LIKE ? AND CNSREQ LIKE ? AND ITEM LIKE ? ";
		      PreparedStatement ps =ConexionData.prepareStatement(updatedata);
		   	  ps.setString(1, '%'+cnsitem+'%');
		   	  ps.setString(2, '%'+cnsreq+'%' );
		   	  ps.setString(3, '%'+item+'%');
		   	  ps.executeUpdate();
		   	if(estadorepfinaltx.getSelectionModel().getSelectedItem().equals("RECIBIDO")) {
		   	  Text cabecera = new Text();
			  cabecera.setText("DATO CONFIRMADO");
			  cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			  Text mensaje= new Text();
			  mensaje.setText("ITEM RECIBIDO");
			  mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			  JFXDialogLayout contenido = new JFXDialogLayout();
			  contenido.setHeading((cabecera));
			  contenido.setBody(mensaje);
			  contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			  JFXDialog dialogo = new JFXDialog(stackrepfinaldata,contenido, JFXDialog.DialogTransition.CENTER);
			  JFXButton cerrar = new JFXButton("CERRAR");
			  cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			  cerrar.setOnAction(e3->{
			  dialogo.close();
			  try {
			       	ObservableList<itemrep> midatareqapro= FXCollections.observableArrayList();
			        String StringQueryGetData="SELECT \r\n" + 
			        		"       ITEMSREQ.CNSITEMREQ AS 'ITEM_CONSECUTIVO',\r\n" + 
			        		"       ITEMSREQ.ITEM AS ITEM,\r\n" + 
			        		"       ITEMSREQ.CANTIDAD AS CANTIDAD,\r\n" + 
			        		"	   (CASE  WHEN ITEMSREQ.ITEMAPROBADO=1 THEN 'APROBADO'\r\n" + 
			        		"	          WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'NO APROBADO'\r\n" + 
			        		"		END) AS ITEMS,\r\n" + 
			        		"		(CASE \r\n" + 
			        		"			  WHEN ITEMSREQ.ITEMAPROBADO = 0 \r\n" + 
			        		"			  THEN CASE WHEN ITEMSREQ.RECIBIDO IS NULL  THEN 'ITEM NO APROBADO PARA ENTREGA' END\r\n" + 
			        		"			  WHEN ITEMSREQ.ITEMAPROBADO = 1 \r\n" + 
			        		"			  THEN CASE WHEN ITEMSREQ.RECIBIDO IS NULL THEN 'ITEM AUN NO RECIBIDO' \r\n" + 
			        		"			            WHEN ITEMSREQ.RECIBIDO=1 THEN 'RECIBIDO' \r\n" + 
			        		"					    WHEN ITEMSREQ.RECIBIDO=0 THEN 'NO RECIBIDO' \r\n" + 
			        		"					   END\r\n" + 
			        		"			  END)\r\n" + 
			        		"			  AS RECIBIDO\r\n" + 
			        		" FROM ITEMSREQ\r\n" + 
			        		" INNER JOIN REQUISICIONES ON\r\n" + 
			        		" ITEMSREQ.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
			        		" WHERE ITEMSREQ.CNSREQ ='"+cnsreq+"'";
		   			PreparedStatement pss =ConexionData.prepareStatement(StringQueryGetData);
		   	       	ResultSet rs = pss.executeQuery();
		   	        while(rs.next()) {
		   	        midatareqapro.add(new itemrep(
		   	        	      rs.getString("ITEM"),
		        		      rs.getInt("CANTIDAD"),
		        		      rs.getString("ITEMS"),
		        		      rs.getString("RECIBIDO"),
		        		      rs.getString("ITEM_CONSECUTIVO")
		           		      )
		                      );
		   	     DetalleRecepcionItemsController.this.getRecepcion().setItems(midatareqapro);
			   		}
			       	}catch(SQLException ee) {
			       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
			       	}
			 for( itemrep items : DetalleRecepcionItemsController.this.getRecepcion().getItems()) {
		    	  if(items.getEstadoitemrep().equals("ITEM AUN NO RECIBIDO")) {
		    		  confirmareqrep.setDisable(true);
		    		  
		    	  }
		    	  else if(items.getEstadoitemrep().equals("RECIBIDO") ||items.getEstadoitemrep().equals("NO RECIBIDO") ) {
		    		  confirmareqrep.setDisable(false);
		    		  confirmareqrep.setStyle ("-fx-background-color:#FF5403; -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: white;");
		    	  }
		     }
			  DetalleRecepcionItemsController.this.getRep().close();
			  });
			  contenido.setActions(cerrar);
			  dialogo.show(); 
		   	}
		   	else if(estadorepfinaltx.getSelectionModel().getSelectedItem().equals("NO RECIBIDO")) {
		   	 Text cabecera = new Text();
			  cabecera.setText("DATO CONFIRMADO");
			  cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
			  Text mensaje= new Text();
			  mensaje.setText("ITEM NO RECIBIDO");
			  mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			  JFXDialogLayout contenido = new JFXDialogLayout();
			  contenido.setHeading((cabecera));
			  contenido.setBody(mensaje);
			  contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
			  JFXDialog dialogo = new JFXDialog(stackrepfinaldata,contenido, JFXDialog.DialogTransition.CENTER);
			  JFXButton cerrar = new JFXButton("CERRAR");
			  cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			  cerrar.setOnAction(e3->{
			  dialogo.close();
			  try {
			       	ObservableList<itemrep> midatareqapro= FXCollections.observableArrayList();
			        String StringQueryGetData="SELECT \r\n" + 
			        		"       ITEMSREQ.CNSITEMREQ AS 'ITEM_CONSECUTIVO',\r\n" + 
			        		"       ITEMSREQ.ITEM AS ITEM,\r\n" + 
			        		"       ITEMSREQ.CANTIDAD AS CANTIDAD,\r\n" + 
			        		"	   (CASE  WHEN ITEMSREQ.ITEMAPROBADO=1 THEN 'APROBADO'\r\n" + 
			        		"	          WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'NO APROBADO'\r\n" + 
			        		"		END) AS ITEMS,\r\n" + 
			        		"		(CASE \r\n" + 
			        		"			  WHEN ITEMSREQ.ITEMAPROBADO = 0 \r\n" + 
			        		"			  THEN CASE WHEN ITEMSREQ.RECIBIDO IS NULL  THEN 'ITEM NO APROBADO PARA ENTREGA' END\r\n" + 
			        		"			  WHEN ITEMSREQ.ITEMAPROBADO = 1 \r\n" + 
			        		"			  THEN CASE WHEN ITEMSREQ.RECIBIDO IS NULL THEN 'ITEM AUN NO RECIBIDO' \r\n" + 
			        		"			            WHEN ITEMSREQ.RECIBIDO=1 THEN 'RECIBIDO' \r\n" + 
			        		"					    WHEN ITEMSREQ.RECIBIDO=0 THEN 'NO RECIBIDO' \r\n" + 
			        		"					   END\r\n" + 
			        		"			  END)\r\n" + 
			        		"			  AS RECIBIDO\r\n" + 
			        		" FROM ITEMSREQ\r\n" + 
			        		" INNER JOIN REQUISICIONES ON\r\n" + 
			        		" ITEMSREQ.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
			        		" WHERE ITEMSREQ.CNSREQ ='"+cnsreq+"'";
		   			PreparedStatement pss =ConexionData.prepareStatement(StringQueryGetData);
		   	       	ResultSet rs = pss.executeQuery();
		   	        while(rs.next()) {
		   	        midatareqapro.add(new itemrep(
		   	        	      rs.getString("ITEM"),
		        		      rs.getInt("CANTIDAD"),
		        		      rs.getString("ITEMS"),
		        		      rs.getString("RECIBIDO"),
		        		      rs.getString("ITEM_CONSECUTIVO")
		           		      )
		                      );
		   	     DetalleRecepcionItemsController.this.getRecepcion().setItems(midatareqapro);
			   		}
			       	}catch(SQLException ee) {
			       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
			       	}
			  for( itemrep items : DetalleRecepcionItemsController.this.getRecepcion().getItems()) {
		    	  if(items.getEstadoitemrep().equals("ITEM AUN NO RECIBIDO")) {
		    		  confirmareqrep.setDisable(true);
		    	  }
		    	  else if(items.getEstadoitemrep().equals("RECIBIDO") ||items.getEstadoitemrep().equals("NO RECIBIDO") ) {
		    		  confirmareqrep.setDisable(false);
		    		  confirmareqrep.setStyle ("-fx-background-color:#FF5403; -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: white;");   
		    	  }
		     }
			  DetalleRecepcionItemsController.this.getRep().close();
			  });
			  contenido.setActions(cerrar);
			  dialogo.show(); 
		   	}
				
			}catch(SQLException | NullPointerException o) {
				
			}
			}
			});
	     }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    styleddata();
	    disabledata();
	    try {
			actualizadata();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public JFXButton getConfirmareqrep() {
		return confirmareqrep;
	}

	public void setConfirmareqrep(JFXButton confirmareqrep) {
		this.confirmareqrep = confirmareqrep;
	}



}
