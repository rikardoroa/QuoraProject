package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.MonthDay;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class RequisicionesAprobacionDetalleController  extends Application implements Initializable {

	@FXML public Label consecutivolabel;
	@FXML public Label solicitantelabel;
	@FXML public Label arealabel;
	@FXML public Label cargolabel;
	@FXML public Label fechaprobacionlabel;
	@FXML public Label itemsaprobadoslabel;
	@FXML public Label itemsnoaprobadoslabel;
	@FXML public BorderPane borderpanereqmiapro;
	@FXML public JFXButton genreqfinalapro;
	@FXML public JFXTextField consecutivoreqapro;
	@FXML public JFXTextField solicitantereapro;
	@FXML public JFXTextField areareqaprofinal;
	@FXML public JFXTextField cargoreqaprofinal;
	@FXML public JFXTextField fecaprobacionreqapro;
	@FXML public JFXTextField itemsreqaprofinal;
	@FXML public JFXTextField itemsresnoaprofinal;
	@FXML public DatePicker fechareq;
	@FXML public  StackPane stackpanereqdoc;
	public JFXComboBox<String> thisfcargo;
	public JFXComboBox<String> thisfarea;
	public DatePicker fechaif;
	public DatePicker fechaff;
	public TableView <requisicionesgen> thistableviewf;
	public String cargo;
	public String area;
	public String fechai;
	public String fechaf;
    public String consecutivofinal;
    String finaldate1;
    public Stage thisStageA;
	Conexion conectar = new Conexion();
	String diax;
	String newdate;

    public String getNewdate() {
		return newdate;
	}



	public void setNewdate(String newdate) {
		this.newdate = newdate;
	}



	public JFXComboBox<String> getThisfcargo() {
		return thisfcargo;
	}



	public void setThisfcargo(JFXComboBox<String> thisfcargo) {
		this.thisfcargo = thisfcargo;
	}



	public JFXComboBox<String> getThisfarea() {
		return thisfarea;
	}



	public void setThisfarea(JFXComboBox<String> thisfarea) {
		this.thisfarea = thisfarea;
	}



	public DatePicker getFechaif() {
		return fechaif;
	}



	public void setFechaif(DatePicker fechaif) {
		this.fechaif = fechaif;
	}



	public DatePicker getFechaff() {
		return fechaff;
	}



	public void setFechaff(DatePicker fechaff) {
		this.fechaff = fechaff;
	}



	public TableView<requisicionesgen> getThistableviewf() {
		return thistableviewf;
	}



	public void setThistableviewf(TableView<requisicionesgen> thistableviewf) {
		this.thistableviewf = thistableviewf;
	}


	public Stage getThisStageA() {
		return thisStageA;
	}



	public void setThisStageA(Stage thisStageA) {
		this.thisStageA = thisStageA;
	}



	public void styledtextfield() {
    	consecutivoreqapro.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
    	consecutivoreqapro.setDisable(true);
    	solicitantereapro.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
    	solicitantereapro.setDisable(true);
    	areareqaprofinal.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
    	areareqaprofinal.setDisable(true);
    	cargoreqaprofinal.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
    	cargoreqaprofinal.setDisable(true);
    	fecaprobacionreqapro.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
    	fecaprobacionreqapro.setDisable(true);
    	itemsreqaprofinal.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
    	itemsreqaprofinal.setDisable(true);
    	itemsresnoaprofinal.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
    	itemsresnoaprofinal.setDisable(true);
    }
	
    
	
	
		 
	
	
	
	

	
	public  void generafecharequisicion() {
    	genreqfinalapro.setOnAction(e->{
    		
	            thisfcargo= RequisicionesAprobacionDetalleController.this.getThisfcargo();
	            thisfarea=RequisicionesAprobacionDetalleController.this.getThisfarea();
	            fechaif=RequisicionesAprobacionDetalleController.this.getFechaif();
	            fechaff=RequisicionesAprobacionDetalleController.this.getFechaff();
	            cargo=thisfcargo.getSelectionModel().getSelectedItem();
	            area=thisfarea.getSelectionModel().getSelectedItem();
	            fechai=((TextField)fechaif.getEditor()).getText();
    	        fechaf=((TextField)fechaff.getEditor()).getText();
    		    Stage Stage =RequisicionesAprobacionDetalleController.this.getThisStageA();
    		    consecutivofinal=consecutivoreqapro.getText().toString();
		   	    LocalDate mifecha=(LocalDate) fechareq.getValue();
	            String ndate=mifecha.toString();
		   		String QueryUpdate= "UPDATE REQUISICIONES SET FECHA_ENTREGA= ? , ESTADO_REQUISICION=1  , ESTADO_ITEMS =0 FROM REQUISICIONES   WHERE REQUISICIONES.CNSREQ = ?";
		   		Connection Conexiontabla = null;
		       	try {
		       		Conexiontabla=conectar.miconexion(Conexiontabla);
		       		PreparedStatement update =Conexiontabla.prepareStatement(QueryUpdate);
		       		update.setString(1, ndate);
		       		update.setString(2, consecutivofinal);
		       		update.executeUpdate();
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
		    		JFXDialog dialogo = new JFXDialog(stackpanereqdoc,contenido, JFXDialog.DialogTransition.CENTER);
		    		JFXButton cerrar = new JFXButton("CERRAR");
		    		cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
		    		cerrar.setOnAction(ee->{
		    		dialogo.close();
		    		 if(thisfcargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&thisfarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaif.getEditor()).getText().isEmpty()&&!((TextField)fechaff.getEditor()).getText().isEmpty())
     	    		   {
   	    	    	    ObservableList<requisicionesgen> itemsaprobados= FXCollections.observableArrayList();
   	    	    	     Connection Conexiontablarequi=null;
   	   	   	   		     String Query= "SELECT  \r\n" + 
   	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,  MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION,  MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
   	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
   	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
   	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
   	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" +
   	   	   	             	"                              WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
   	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
   	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
   	   	   	            	"							   WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" +
   	   	   	   				"END) AS ESTADO_ITEMS\r\n" + 
   	   	   	   				" FROM  (SELECT * FROM (SELECT \r\n" + 
   	   	   	   				"REQUISICIONES.CNSREQ AS 'CONSECUTIVO REQUISICION', \r\n" + 
   	   	   	   				"REQUISICIONES.SOLICITANTE AS 'SOLICITANTE',\r\n" + 
   	   	   	   				"REQUISICIONES.AREA AS 'AREA',\r\n" + 
   	   	   	   				"REQUISICIONES.CARGO AS 'CARGO',\r\n" + 
   	   	   	   	            "REQUISICIONES.CENTRO_OPERACION AS 'CENTRO_OPERACION',\r\n" + 
   	   	   	   				"REQUISICIONES.FECHA_ENTREGA AS 'FECHA DE ENTREGA' ,\r\n" + 
   	   	   	   				"REQUISICIONES.ESTADO_ITEMS AS 'ESTADO DE ITEMS',\r\n" + 
   	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20) AS 'FECHA DE SOLICITUD',\r\n" + 
   	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONESDT.FECHA_DE_FIRMA,20) AS 'FECHA DE APROBACION',\r\n" + 
   	   	   	   				"COUNT(ITEMSREQ.ITEM) AS CANTIDAD,\r\n" + 
   	   	   	   				"(CASE WHEN ITEMSREQ.ITEMAPROBADO=1 THEN  'ITEM APROBADO'\r\n" + 
   	   	   	   				"      WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'ITEM NO APROBADO' END) AS ESTADO\r\n" + 
   	   	   	   				"       FROM REQUISICIONES\r\n" + 
   	   	   	   				"	   INNER JOIN ITEMSREQ ON\r\n" + 
   	   	   	   				"	   ITEMSREQ.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
   	   	   	   				"	   INNER JOIN REQUISICIONESDT ON\r\n" + 
   	   	   	   				"	   REQUISICIONESDT.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
   	   	   	   				"	   WHERE REQUISICIONES.APROBACION=1 AND ITEMSREQ.ITEMAPROBADO = 1 AND  REQUISICIONES.APROBACION=1 OR ITEMSREQ.ITEMAPROBADO = 0\r\n" + 
   	   	   	   				"	   GROUP BY REQUISICIONES.CNSREQ,REQUISICIONES.SOLICITANTE,REQUISICIONES.CARGO, REQUISICIONES.CENTRO_OPERACION,REQUISICIONES.FECHA_SOLICITUD,\r\n" + 
   	   	   	   				"	   REQUISICIONESDT.FECHA_DE_FIRMA,ITEMSREQ.ITEMAPROBADO,REQUISICIONES.AREA,REQUISICIONES.FECHA_ENTREGA,REQUISICIONES.ESTADO_ITEMS\r\n" + 
   	   	   	   				"	   ) AS T\r\n" + 
   	   	   	   				"	    PIVOT\r\n" + 
   	   	   	   				"	   (\r\n" + 
   	   	   	   				"	   SUM (CANTIDAD)  \r\n" + 
   	   	   	   				"       FOR ESTADO IN  \r\n" + 
   	   	   	   				"       (  [ITEM APROBADO],[ITEM NO APROBADO] )  \r\n" + 
   	   	   	   				"       )  AS PIVOTTABLE)MIDATA\r\n" + 
   	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? \r\n" + 
   	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
   	   	   	       	
   	   	   	   		     try {
   	   	   	   		    	
   	   	   	            Conexiontablarequi = conectar.miconexion(Conexiontablarequi); 
   	   	   	   			PreparedStatement pss =Conexiontablarequi.prepareStatement(Query);
   	   	   	         	pss.setString(1, fechai);
	    				    pss.setString(2, fechaf);
   	   	   	   	       	ResultSet rs = pss.executeQuery();
   	   	   	   	        while(rs.next()) {
   	   	   	   	        itemsaprobados.add(new requisicionesgen(
   	   	   	   	 	     rs.getString("CONSECUTIVO REQUISICION"),
	   	        		         rs.getString("SOLICITANTE"),
	   	        		         rs.getString("AREA"),
	                   		     rs.getString("CARGO"),
	                   		     rs.getString("CENTRO_OPERACION"),
	                   		     rs.getString("FECHA_SOLICITUD"),
	                   	         rs.getString("FECHA_APROBACION"),
	                   		     rs.getInt("ITEMS APROBADOS"),
	                   		     rs.getInt("ITEMS NO APROBADOS"),
	                             rs.getString("FECHA_ENTREGA"),
	                             rs.getString("ESTADO_ITEMS")
   	   	   	                        ) );
   	   	   	   	        RequisicionesAprobacionDetalleController.this.getThistableviewf().setItems(itemsaprobados);
   	 	    	   	   	   			 }
   	   	   	       	}catch(SQLException eee) {
   	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
   	   	   	       	} 
   	   			 
		    		Stage.close();
     	    		   }
		    		 
		    		  else if(thisfcargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaif.getEditor()).getText().isEmpty()&&!((TextField)fechaff.getEditor()).getText().isEmpty()) {
	    	    			ObservableList<requisicionesgen> itemsaprobadosA= FXCollections.observableArrayList();
	    	   	   	   		String Query= "SELECT  \r\n" + 
	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION,   MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" + 
	    	   	   	   		        "                              WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
	    	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
	    	   	   	   	        	"							   WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" +
	    	   	   	   				"END) AS ESTADO_ITEMS\r\n" + 
	    	   	   	   				" FROM  (SELECT * FROM (SELECT \r\n" + 
	    	   	   	   				"REQUISICIONES.CNSREQ AS 'CONSECUTIVO REQUISICION', \r\n" + 
	    	   	   	   				"REQUISICIONES.SOLICITANTE AS 'SOLICITANTE',\r\n" + 
	    	   	   	   				"REQUISICIONES.AREA AS 'AREA',\r\n" + 
	    	   	   	   				"REQUISICIONES.CARGO AS 'CARGO',\r\n" + 
	    	   	   	   	         	"REQUISICIONES.CENTRO_OPERACION AS 'CENTRO_OPERACION',\r\n" + 
	    	   	   	   				"REQUISICIONES.FECHA_ENTREGA AS 'FECHA DE ENTREGA' ,\r\n" + 
	    	   	   	   				"REQUISICIONES.ESTADO_ITEMS AS 'ESTADO DE ITEMS',\r\n" + 
	    	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20) AS 'FECHA DE SOLICITUD',\r\n" + 
	    	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONESDT.FECHA_DE_FIRMA,20) AS 'FECHA DE APROBACION',\r\n" + 
	    	   	   	   				"COUNT(ITEMSREQ.ITEM) AS CANTIDAD,\r\n" + 
	    	   	   	   				"(CASE WHEN ITEMSREQ.ITEMAPROBADO=1 THEN  'ITEM APROBADO'\r\n" + 
	    	   	   	   				"      WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'ITEM NO APROBADO' END) AS ESTADO\r\n" + 
	    	   	   	   				"       FROM REQUISICIONES\r\n" + 
	    	   	   	   				"	   INNER JOIN ITEMSREQ ON\r\n" + 
	    	   	   	   				"	   ITEMSREQ.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
	    	   	   	   				"	   INNER JOIN REQUISICIONESDT ON\r\n" + 
	    	   	   	   				"	   REQUISICIONESDT.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
	    	   	   	   				"	   WHERE REQUISICIONES.APROBACION=1 AND ITEMSREQ.ITEMAPROBADO = 1 AND  REQUISICIONES.APROBACION=1 OR ITEMSREQ.ITEMAPROBADO = 0\r\n" + 
	    	   	   	   				"	   GROUP BY REQUISICIONES.CNSREQ,REQUISICIONES.SOLICITANTE,REQUISICIONES.CARGO,REQUISICIONES.CENTRO_OPERACION,REQUISICIONES.FECHA_SOLICITUD,\r\n" + 
	    	   	   	   				"	   REQUISICIONESDT.FECHA_DE_FIRMA,ITEMSREQ.ITEMAPROBADO,REQUISICIONES.AREA,REQUISICIONES.FECHA_ENTREGA,REQUISICIONES.ESTADO_ITEMS\r\n" + 
	    	   	   	   				"	   ) AS T\r\n" + 
	    	   	   	   				"	    PIVOT\r\n" + 
	    	   	   	   				"	   (\r\n" + 
	    	   	   	   				"	   SUM (CANTIDAD)  \r\n" + 
	    	   	   	   				"       FOR ESTADO IN  \r\n" + 
	    	   	   	   				"       (  [ITEM APROBADO],[ITEM NO APROBADO] )  \r\n" + 
	    	   	   	   				"       )  AS PIVOTTABLE)MIDATA\r\n" + 
	    	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? AND MIDATA.AREA = ?   	   				\r\n" + 
	    	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
	    	   	   	   		Connection Conexiontablaf = null;
	    	   	   	       	try {
	    	   	   	       		Conexiontablaf=conectar.miconexion(Conexiontablaf);
	    	   	   	   			PreparedStatement ps =Conexiontablaf.prepareStatement(Query);
	    	   	   	         	ps.setString(1, fechai);
	  	    				    ps.setString(2, fechaf);
	  	    					ps.setString(3, area);
	    	   	   	   	       	ResultSet rs = ps.executeQuery();
	    	   	   	   	        while(rs.next()) {
	    	   	   	   	        itemsaprobadosA.add(new requisicionesgen(
	    	   	   	   	         rs.getString("CONSECUTIVO REQUISICION"),
	   	        		         rs.getString("SOLICITANTE"),
	   	        		         rs.getString("AREA"),
	                   		     rs.getString("CARGO"),
	                   		     rs.getString("CENTRO_OPERACION"),
	                   		     rs.getString("FECHA_SOLICITUD"),
	                   	         rs.getString("FECHA_APROBACION"),
	                   		     rs.getInt("ITEMS APROBADOS"),
	                   		     rs.getInt("ITEMS NO APROBADOS"),
	                             rs.getString("FECHA_ENTREGA"),
	                             rs.getString("ESTADO_ITEMS")
	    	   	   	                   		 )
	    	   	   	                         );
	    	   	   	   	RequisicionesAprobacionDetalleController.this.getThistableviewf().setItems(itemsaprobadosA);
	    	 	    	   	   	   			 }
	    	   	   	       	}catch(SQLException eee) {
	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	    	   	   	       	}
	    	   	   	       	Stage.close();
	    	    		  }
		    		 
		    		  else if(thisfarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaif.getEditor()).getText().isEmpty()&&!((TextField)fechaff.getEditor()).getText().isEmpty()) {  
   	    				ObservableList<requisicionesgen> itemsaprobadosB= FXCollections.observableArrayList();
 	    	   	   	   		String Query= "SELECT  \r\n" + 
 	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,  MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION, MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
 	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
 	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
 	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
 	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" +
 	    	   	   	   		        "                              WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
 	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
 	    	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
 	    	   	   	   		        "							   WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" +
 	    	   	   	   				"END) AS ESTADO_ITEMS\r\n" + 
 	    	   	   	   				" FROM  (SELECT * FROM (SELECT \r\n" + 
 	    	   	   	   				"REQUISICIONES.CNSREQ AS 'CONSECUTIVO REQUISICION', \r\n" + 
 	    	   	   	   				"REQUISICIONES.SOLICITANTE AS 'SOLICITANTE',\r\n" + 
 	    	   	   	   				"REQUISICIONES.AREA AS 'AREA',\r\n" + 
 	    	   	   	   				"REQUISICIONES.CARGO AS 'CARGO',\r\n" +
 	    	   	   	   	            "REQUISICIONES.CENTRO_OPERACION AS 'CENTRO_OPERACION',\r\n" + 
 	    	   	   	   				"REQUISICIONES.FECHA_ENTREGA AS 'FECHA DE ENTREGA' ,\r\n" + 
 	    	   	   	   				"REQUISICIONES.ESTADO_ITEMS AS 'ESTADO DE ITEMS',\r\n" + 
 	    	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20) AS 'FECHA DE SOLICITUD',\r\n" + 
 	    	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONESDT.FECHA_DE_FIRMA,20) AS 'FECHA DE APROBACION',\r\n" + 
 	    	   	   	   				"COUNT(ITEMSREQ.ITEM) AS CANTIDAD,\r\n" + 
 	    	   	   	   				"(CASE WHEN ITEMSREQ.ITEMAPROBADO=1 THEN  'ITEM APROBADO'\r\n" + 
 	    	   	   	   				"      WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'ITEM NO APROBADO' END) AS ESTADO\r\n" + 
 	    	   	   	   				"       FROM REQUISICIONES\r\n" + 
 	    	   	   	   				"	   INNER JOIN ITEMSREQ ON\r\n" + 
 	    	   	   	   				"	   ITEMSREQ.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
 	    	   	   	   				"	   INNER JOIN REQUISICIONESDT ON\r\n" + 
 	    	   	   	   				"	   REQUISICIONESDT.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
 	    	   	   	   				"	   WHERE REQUISICIONES.APROBACION=1 AND ITEMSREQ.ITEMAPROBADO = 1 AND  REQUISICIONES.APROBACION=1 OR ITEMSREQ.ITEMAPROBADO = 0\r\n" + 
 	    	   	   	   				"	   GROUP BY REQUISICIONES.CNSREQ,REQUISICIONES.SOLICITANTE,REQUISICIONES.CARGO,REQUISICIONES.CENTRO_OPERACION,REQUISICIONES.FECHA_SOLICITUD,\r\n" + 
 	    	   	   	   				"	   REQUISICIONESDT.FECHA_DE_FIRMA,ITEMSREQ.ITEMAPROBADO,REQUISICIONES.AREA,REQUISICIONES.FECHA_ENTREGA,REQUISICIONES.ESTADO_ITEMS\r\n" + 
 	    	   	   	   				"	   ) AS T\r\n" + 
 	    	   	   	   				"	    PIVOT\r\n" + 
 	    	   	   	   				"	   (\r\n" + 
 	    	   	   	   				"	   SUM (CANTIDAD)  \r\n" + 
 	    	   	   	   				"       FOR ESTADO IN  \r\n" + 
 	    	   	   	   				"       (  [ITEM APROBADO],[ITEM NO APROBADO] )  \r\n" + 
 	    	   	   	   				"       )  AS PIVOTTABLE)MIDATA\r\n" + 
 	    	   	   	   				"        WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? AND MIDATA.CARGO = ?  \r\n" + 
 	    	   	   	   				" 	  	ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
 	    	   	        	 Connection Conexiontablaff=null;
 	    	   	   	       	try {
 	    	   	   	       		 Conexiontablaff = conectar.miconexion(Conexiontablaff);
 	    	   	   	   			PreparedStatement ps =Conexiontablaff.prepareStatement(Query);
 	    	   	   	         	ps.setString(1, fechai);
	  	    				    ps.setString(2, fechaf);
	  	    					ps.setString(3, cargo);
 	    	   	   	   	       	ResultSet rs = ps.executeQuery();
 	    	   	   	   	        while(rs.next()) {
 	    	   	   	        	itemsaprobadosB.add(new requisicionesgen(
 	    	   	   	             rs.getString("CONSECUTIVO REQUISICION"),
	   	        		         rs.getString("SOLICITANTE"),
	   	        		         rs.getString("AREA"),
	                   		     rs.getString("CARGO"),
	                   			 rs.getString("CENTRO_OPERACION"),
	                   		     rs.getString("FECHA_SOLICITUD"),
	                   	         rs.getString("FECHA_APROBACION"),
	                   		     rs.getInt("ITEMS APROBADOS"),
	                   		     rs.getInt("ITEMS NO APROBADOS"),
	                             rs.getString("FECHA_ENTREGA"),
	                             rs.getString("ESTADO_ITEMS")
 	    	   	   	                   		 )
 	    	   	   	                         );
 	    	   	   	  	RequisicionesAprobacionDetalleController.this.getThistableviewf().setItems(itemsaprobadosB);
 	    	 	    	   	   	   			 }
 	    	   	   	       	}catch(SQLException eee) {
 	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
 	    	   	   	       	} 
 	    	   	   	       	Stage.close();
   	    		          }
		    		  else if (thisfcargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&thisfarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&((TextField)fechaif.getEditor()).getText().isEmpty()&&((TextField)fechaff.getEditor()).getText().isEmpty()) 
		  			{
	    	    			 ObservableList<requisicionesgen> itemsaprobadosC= FXCollections.observableArrayList();
	  	    	   	   	   	 String Query= "SELECT  \r\n" + 
	  	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION,  MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
	  	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
	  	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
	  	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
	  	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" + 
	  	    	   	   	   		        "                              WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
	  	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS] =1 THEN 'REQUISICION TRAMITADA'\r\n" + 
	  	    	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
	  	    	   	   	   		        "							   WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" +
	  	    	   	   	   				"END) AS ESTADO_ITEMS\r\n" + 
	  	    	   	   	   				" FROM  (SELECT * FROM (SELECT \r\n" + 
	  	    	   	   	   				"REQUISICIONES.CNSREQ AS 'CONSECUTIVO REQUISICION', \r\n" + 
	  	    	   	   	   				"REQUISICIONES.SOLICITANTE AS 'SOLICITANTE',\r\n" + 
	  	    	   	   	   				"REQUISICIONES.AREA AS 'AREA',\r\n" + 
	  	    	   	   	   				"REQUISICIONES.CARGO AS 'CARGO',\r\n" + 
	  	    	   	   	   		        "REQUISICIONES.CENTRO_OPERACION AS 'CENTRO_OPERACION',\r\n" + 
	  	    	   	   	   				"REQUISICIONES.FECHA_ENTREGA AS 'FECHA DE ENTREGA' ,\r\n" + 
	  	    	   	   	   				"REQUISICIONES.ESTADO_ITEMS AS 'ESTADO DE ITEMS',\r\n" + 
	  	    	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20) AS 'FECHA DE SOLICITUD',\r\n" + 
	  	    	   	   	   				"CONVERT(VARCHAR(16),REQUISICIONESDT.FECHA_DE_FIRMA,20) AS 'FECHA DE APROBACION',\r\n" + 
	  	    	   	   	   				"COUNT(ITEMSREQ.ITEM) AS CANTIDAD,\r\n" + 
	  	    	   	   	   				"(CASE WHEN ITEMSREQ.ITEMAPROBADO=1 THEN  'ITEM APROBADO'\r\n" + 
	  	    	   	   	   				"      WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'ITEM NO APROBADO' END) AS ESTADO\r\n" + 
	  	    	   	   	   				"       FROM REQUISICIONES\r\n" + 
	  	    	   	   	   				"	   INNER JOIN ITEMSREQ ON\r\n" + 
	  	    	   	   	   				"	   ITEMSREQ.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
	  	    	   	   	   				"	   INNER JOIN REQUISICIONESDT ON\r\n" + 
	  	    	   	   	   				"	   REQUISICIONESDT.CNSREQ = REQUISICIONES.CNSREQ\r\n" + 
	  	    	   	   	   				"	   WHERE REQUISICIONES.APROBACION=1 AND ITEMSREQ.ITEMAPROBADO = 1 AND  REQUISICIONES.APROBACION=1 OR ITEMSREQ.ITEMAPROBADO = 0\r\n" + 
	  	    	   	   	   				"	   GROUP BY REQUISICIONES.CNSREQ,REQUISICIONES.SOLICITANTE,REQUISICIONES.CARGO,REQUISICIONES.CENTRO_OPERACION,REQUISICIONES.FECHA_SOLICITUD,\r\n" + 
	  	    	   	   	   				"	   REQUISICIONESDT.FECHA_DE_FIRMA,ITEMSREQ.ITEMAPROBADO,REQUISICIONES.AREA,REQUISICIONES.FECHA_ENTREGA,REQUISICIONES.ESTADO_ITEMS\r\n" + 
	  	    	   	   	   				"	   ) AS T\r\n" + 
	  	    	   	   	   				"	    PIVOT\r\n" + 
	  	    	   	   	   				"	   (\r\n" + 
	  	    	   	   	   				"	   SUM (CANTIDAD)  \r\n" + 
	  	    	   	   	   				"       FOR ESTADO IN  \r\n" + 
	  	    	   	   	   				"       (  [ITEM APROBADO],[ITEM NO APROBADO] )  \r\n" + 
	  	    	   	   	   				"       )  AS PIVOTTABLE)MIDATA\r\n" + 
	  	    	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
	  	    	   	   	   		Connection Conexiontablay = null;
	  	    	   	   	       	try {
	  	    	   	   	       		Conexiontablay=conectar.miconexion(Conexiontablay);
	  	    	   	   	   			PreparedStatement ps =Conexiontablay.prepareStatement(Query);
	  	    	   	   	   	       	ResultSet rs = ps.executeQuery();
	  	    	   	   	   	        while(rs.next()) {
	  	    	   	   	        	itemsaprobadosC.add(new requisicionesgen(
	  	    	   	   	        	 rs.getString("CONSECUTIVO REQUISICION"),
		   	        		         rs.getString("SOLICITANTE"),
		   	        		         rs.getString("AREA"),
		                   		     rs.getString("CARGO"),
		                   		     rs.getString("CENTRO_OPERACION"),
		                   		     rs.getString("FECHA_SOLICITUD"),
		                   	         rs.getString("FECHA_APROBACION"),
		                   		     rs.getInt("ITEMS APROBADOS"),
		                   		     rs.getInt("ITEMS NO APROBADOS"),
		                             rs.getString("FECHA_ENTREGA"),
		                             rs.getString("ESTADO_ITEMS")
	  	    	   	   	                   		 )
	  	    	   	   	                         );
	  	    	   	   	  	RequisicionesAprobacionDetalleController.this.getThistableviewf().setItems(itemsaprobadosC);
	  	    	 	    	   	   	   			 }
	  	    	   	   	       	}catch(SQLException eee) {
	  	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	  	    	   	   	       	} 
	  	    	   	   	       	Stage.close();
	    	    		  }
		    		});
		    		contenido.setActions(cerrar);
		    		dialogo.show();
		       	}catch(SQLException ee) {
		 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
		       	}     
    	    });
          }


	public static void main(String[] args) {
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    public void updateItem(java.time.LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        
                        if (item == null || empty) {
                        	 setTooltip(null);
                             setStyle(null);
   	                 }else {
                        if (MonthDay.from(item).equals(MonthDay.of(1, 6))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red;-fx-text-fill: white");
                       
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(3, 23))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        } 
                        if (MonthDay.from(item).equals(MonthDay.of(4, 9))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(4, 10))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(5, 1))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(5, 25))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 15))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 22))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 29))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(7, 7))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(7, 17))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(7, 20))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(10, 12))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(11, 2))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(11, 16))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(12, 25))) {
                            setTooltip(new Tooltip("festivo"));
                            setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        }
                    }
                   }
                };
            }
        };
        fechareq.setDayCellFactory(dayCellFactory);
		// TODO Auto-generated method stub
		styledtextfield();
		generafecharequisicion();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
