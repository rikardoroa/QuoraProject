package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RecepcionReqController  extends Application implements Initializable{

	@FXML public StackPane stackreqrep;
	@FXML public Label detallerep;
	@FXML public Label cargorep;
	@FXML public Label nombrerep;
	@FXML public Label requisicionrep;
	@FXML public Label arearep;
	@FXML public Label fechaentregarep;
	@FXML public JFXTextField cargoreptx;
	@FXML public JFXTextField nombrereptx;
	@FXML public JFXTextField reqreptx;
	@FXML public JFXTextField areareptx;
	@FXML public JFXTextField fechaentregareptx;
	@FXML public TableView<itemrep> tablereqrep;
	@FXML public TableColumn<itemrep, String> itemrep;
	@FXML public TableColumn<itemrep, Integer> cantidadrep;
	@FXML public TableColumn <itemrep, String>estadorep;
	@FXML public TableColumn <itemrep, String>recibidorep;
	@FXML public TableColumn <itemrep, String>cnsitemrep;
	@FXML public JFXButton cargardatosrep;
	@FXML public JFXButton confirmareqrep;
	public String micnsreq;
	public String mifecha;
    public Stage Stagerep;
    private Stage recepciondereq;
    public String micnsreqf;
    public Stage Stageuno;
    public String data;
    public itemrep mitem;
    public String data2;
	public DatePicker fechainicio;
	public DatePicker fechafinal;
	public JFXComboBox<String> Area;
	public JFXComboBox<String> Cargo;
	public DatePicker fechainireqf;
	public DatePicker fechafinreqf;
	public JFXComboBox <String>   areareqfiltro;
	public JFXComboBox <String>   cargoreqfiltro;
	public DatePicker fin;
	public DatePicker inicio;
	public JFXComboBox<String> area;
	public JFXComboBox<String> cargo;
	public String miarea;
	public String micargo;
	public String ffin;
	public String iinicio;
	public TableView<requisicionesgen> mitable;
	public String getmifecha;
	Conexion conectar = new Conexion();
	
	public String getGetmifecha() {
		return getmifecha;
	}

	public void setGetmifecha(String getmifecha) {
		this.getmifecha = getmifecha;
	}

	public TableView<requisicionesgen> getMitable() {
		return mitable;
	}

	public void setMitable(TableView<requisicionesgen> mitable) {
		this.mitable = mitable;
	}

	public itemrep getMitem() {
		return mitem;
	}

    public void setMitem(itemrep mitem) {
		this.mitem = mitem;
	}

	public String getData() {
		return data;
	}

    public void setData(String data) {
		this.data = data;
	}

	public StackPane getStackreqrep() {
		return stackreqrep;
	}

	public void setStackreqrep(StackPane stackreqrep) {
		this.stackreqrep = stackreqrep;
	}
	
    public Stage getStageuno() {
		return Stageuno;
	}


    public void setStageuno(Stage stageuno) {
		Stageuno = stageuno;
	}


	public String getMicnsreqf() {
		return micnsreqf;
	}


    public void setMicnsreqf(String micnsreqf) {
		this.micnsreqf = micnsreqf;
	}


	public Stage getStagerep() {
		return Stagerep;
	}


    public void setStagerep(Stage stagerep) {
		Stagerep = stagerep;
	}


	public String getMifecha() {
		return mifecha;
	}


	public void setMifecha(String mifecha) {
		this.mifecha = mifecha;
	}


	public String getMicnsreq() {
		return micnsreq;
	}


	public void setMicnsreq(String micnsreq) {
		this.micnsreq = micnsreq;
	}


	public void styleddata() {
		cargoreptx.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		nombrereptx.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		reqreptx.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		areareptx.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		cargardatosrep.setStyle ("-fx-background-color:#5493F2; -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: white;");   
		fechaentregareptx.setStyle ("-fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");   	
	    }
	
	
	public  TableView<itemrep> loaddata() {
	    cargardatosrep.setOnAction(e->{
    	try {
    		Connection ConexionData=null;
    		ConexionData=conectar.miconexion(ConexionData);
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
	        		" WHERE ITEMSREQ.CNSREQ ='"+micnsreq+"'";
   			PreparedStatement ps =ConexionData.prepareStatement(StringQueryGetData);
   	       	ResultSet rs = ps.executeQuery();
   	        while(rs.next()) {
   	        midatareqapro.add(new itemrep(
   	        	      rs.getString("ITEM"),
        		      rs.getInt("CANTIDAD"),
        		      rs.getString("ITEMS"),
        		      rs.getString("RECIBIDO"),
        		      rs.getString("ITEM_CONSECUTIVO")
           		      )
                      );
	   	        tablereqrep.setItems(midatareqapro);
	   		}
	       	}catch(SQLException ee) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}
    	   for( itemrep items : tablereqrep.getItems()) {
	    	  if(items.getEstadoitemrep().equals("ITEM AUN NO RECIBIDO")) {
	    		  confirmareqrep.setDisable(true);
	    	  }
	    	  if(items.getEstadoitemrep().equals("RECIBIDO")||items.getEstadoitemrep().equals("NO RECIBIDO")) {
	    		  confirmareqrep.setDisable(false);  
	    	  }
    	   }
		});
		return tablereqrep;
	   }
	
	
	public void confirmardata() {
		confirmareqrep.setOnAction(e->{
			ObservableList<itemrep> items = tablereqrep.getItems();
			 if (items.isEmpty()) {
			   Mensaje mensajedata = new Mensaje();
			   mensajedata.mensaje(tablereqrep, stackreqrep);
			 } 
			 else {
			 micnsreq=RecepcionReqController.this.getMicnsreq();
		     fin=RecepcionReqController.this.getFechafinreqf();
	         inicio=RecepcionReqController.this.getFechainireqf();
	         area= RecepcionReqController.this.getAreareqfiltro();
	         cargo= RecepcionReqController.this.getCargoreqfiltro();
	         miarea= area.getSelectionModel().getSelectedItem();
	         micargo=cargo.getSelectionModel().getSelectedItem();
	         ffin=((TextField)fin.getEditor()).getText();
	         iinicio=((TextField)inicio.getEditor()).getText();
			 micnsreqf=reqreptx.getText().toString();
			 try {
			  Connection ConexionData=null;
			  ConexionData=conectar.miconexion(ConexionData);
		      String updatedata="UPDATE REQUISICIONES SET ESTADO_ITEMS=2  WHERE CNSREQ='"+micnsreqf+"'";
		      PreparedStatement ps =ConexionData.prepareStatement(updatedata);
		   	  ps.executeUpdate();
		      Text cabecera = new Text();
			  cabecera.setText("DATOS ACTUALIZADOS");
			  cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
		 	  Text mensaje= new Text();
			  mensaje.setText("REQUISICION RECIBIDA EXITOSAMENTE");
			  mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
			  JFXDialogLayout contenido = new JFXDialogLayout();
		      contenido.setHeading((cabecera));
			  contenido.setBody(mensaje);
			  contenido.setStyle(" -fx-background-color: #AAE3AE;");
			  JFXDialog dialogo = new JFXDialog(stackreqrep,contenido, JFXDialog.DialogTransition.CENTER);
			  JFXButton cerrar = new JFXButton("CERRAR");
			  cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family:'Oswald Regular'-Regular; -fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			  cerrar.setOnAction(e3->{
			  dialogo.close();
			   if (cargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&area.getSelectionModel().getSelectedItem().equals("Sin Dato")&&((TextField)inicio.getEditor()).getText().isEmpty()&&((TextField)fin.getEditor()).getText().isEmpty()) 
	  			{
	    			 ObservableList<requisicionesgen> itemsaprobadosC= FXCollections.observableArrayList();
	    	   	   	   	 String Queryyx= "SELECT  \r\n" + 
	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION , MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" +
	    	   	   	   		        "                              WHEN  MIDATA.[ESTADO DE ITEMS]=2 THEN 'REQUISICION RECIBIDA'\r\n" + 
	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
	    	   	   	   				"							   WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
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
	    	   	   	   			PreparedStatement psr =Conexiontablay.prepareStatement(Queryyx);
	    	   	   	   	       	ResultSet rs = psr.executeQuery();
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
	    	   	   	        RecepcionReqController.this.getMitable().setItems(itemsaprobadosC);
	    	 	    	   	   	   			 }
	    	   	   	       	}catch(SQLException eee) {
	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	    	   	   	       	} 
	    	   	   	 	   }
			
			   
			   else if(cargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)inicio.getEditor()).getText().isEmpty()&&!((TextField)fin.getEditor()).getText().isEmpty()) {
	    			ObservableList<requisicionesgen> itemsaprobadosA= FXCollections.observableArrayList();
	   	   	   		String QueryHH= "SELECT  \r\n" + 
	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION , MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? AND MIDATA.AREA = ?   	   				\r\n" + 
	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
	   	   	   		Connection Conexiontablaf = null;
	   	   	       	try {
	   	   	       		Conexiontablaf=conectar.miconexion(Conexiontablaf);
	   	   	   			PreparedStatement pst =Conexiontablaf.prepareStatement(QueryHH);
	   	   	         	pst.setString(1, iinicio);
	    				pst.setString(2, ffin);
	    				pst.setString(3, miarea);
	   	   	   	       	ResultSet rs = pst.executeQuery();
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
	   	   	   	    RecepcionReqController.this.getMitable().setItems(itemsaprobadosA);
	 	    	   	   	   			 }
	   	   	       	}catch(SQLException eee) {
	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	   	   	       	}
	    		  }
			   
			   
			   
			   else if(area.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)inicio.getEditor()).getText().isEmpty()&&!((TextField)fin.getEditor()).getText().isEmpty()) {  
   				ObservableList<requisicionesgen> itemsaprobadosB= FXCollections.observableArrayList();
   	   	   	   		String Queryy= "SELECT  \r\n" + 
   	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,  MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION , MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
   	   	   	   				"        WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? AND MIDATA.CARGO = ?  \r\n" + 
   	   	   	   				" 	  	ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
   	   	              	Connection Conexiontablaff = null;
   	   	   	   		try {
   	   	   	       		Conexiontablaff = conectar.miconexion(Conexiontablaff);
   	   	   	   			PreparedStatement psrt =Conexiontablaff.prepareStatement(Queryy);
   	   	   	         	psrt.setString(1, iinicio);
	    				psrt.setString(2, ffin);
	    			    psrt.setString(3, micargo);
   	   	   	   	       	ResultSet rs = psrt.executeQuery();
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
   	   	   	      RecepcionReqController.this.getMitable().setItems(itemsaprobadosB);
   	 	    	   	   	   			 }
   	   	   	       	}catch(SQLException eee) {
   	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
   	   	   	       	} 
   		          }
			   
			   else {
	    			 ObservableList<requisicionesgen> itemsaprobadosZ= FXCollections.observableArrayList();
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
    	   	   	   				"	   GROUP BY REQUISICIONES.CNSREQ,REQUISICIONES.SOLICITANTE,REQUISICIONES.CARGO,REQUISICIONES.CENTRO_OPERACION,REQUISICIONES.FECHA_SOLICITUD,\r\n" + 
    	   	   	   				"	   REQUISICIONESDT.FECHA_DE_FIRMA,ITEMSREQ.ITEMAPROBADO,REQUISICIONES.AREA,REQUISICIONES.FECHA_ENTREGA,REQUISICIONES.ESTADO_ITEMS\r\n" + 
    	   	   	   				"	   ) AS T\r\n" + 
    	   	   	   				"	    PIVOT\r\n" + 
    	   	   	   				"	   (\r\n" + 
    	   	   	   				"	   SUM (CANTIDAD)  \r\n" + 
    	   	   	   				"       FOR ESTADO IN  \r\n" + 
    	   	   	   				"       (  [ITEM APROBADO],[ITEM NO APROBADO] )  \r\n" + 
    	   	   	   				"       )  AS PIVOTTABLE)MIDATA\r\n" + 
    	   	   	   				"       WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? AND MIDATA.CARGO LIKE  ? AND MIDATA.AREA LIKE  ? \r\n" + 
    	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
    	   	   	   		Connection Conexiontabla = null;
    	   	   	       	try {
    	   	   	       		Conexiontabla=conectar.miconexion(Conexiontabla);
    	   	   	   			PreparedStatement pstz =Conexiontabla.prepareStatement(Query);
    	   	   	         	pstz.setString(1, iinicio);
 	    				    pstz.setString(2, ffin);
 	    			        pstz.setString(3, '%'+micargo+'%');
 	        		        pstz.setString(4, '%'+miarea+'%');
    	   	   	   	       	ResultSet rs = pstz.executeQuery();
    	   	   	   	        while(rs.next()) {
    	   	   	        	itemsaprobadosZ.add(new requisicionesgen(
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
    	   	   	      RecepcionReqController.this.getMitable().setItems(itemsaprobadosZ);
    	 	    	   	   	   			 }
    	   	   	       	}catch(SQLException ee) {
    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
    	   	   	       	} 
	    		  }
			   RecepcionReqController.this.getStageuno().close();
			  });
			  contenido.setActions(cerrar);
			  dialogo.show();
		}catch(SQLException nn) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn);	
		}
		}
		});
	}

	public void disabledata() {
		cargoreptx.setDisable(true);
		nombrereptx.setDisable(true);
		reqreptx.setDisable(true);
		fechaentregareptx.setDisable(true);
		areareptx.setDisable(true);
	   }
	
	
	public void muestradatosrecibidos() {
		tablereqrep.setOnMouseClicked(e->{
			String fecha=RecepcionReqController.this.getGetmifecha();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = LocalDate.parse(fecha, formatter);
	        String hoy = LocalDate.now().toString();
	        LocalDate newh=LocalDate.parse(hoy, formatter);
			try {
			itemrep miitem = tablereqrep.getSelectionModel().getSelectedItem();	
			if(miitem.getItemrepaprobadorep().equals("NO APROBADO")) {
				   Mensaje mensaje = new Mensaje();
				   mensaje.mensajeitem(stackreqrep);
			}
			else if(miitem.getEstadoitemrep().equals("RECIBIDO")) {
				   Mensaje mensaje = new Mensaje();
				   mensaje.mensajeitemR(stackreqrep);
			}
			else if(newh.compareTo(localDate) < 0) {
				  Mensaje mensaje = new Mensaje();
				  mensaje.mensajedatosfechas(stackreqrep,RecepcionReqController.this.getStageuno());
				  cargardatosrep.setDisable(true);
			      }
			else
			{
		 try {
	     String Cantidad = miitem.getCantidadrep().toString();
	     String miitemfinal= miitem.getItemrep();
	     String consecutivoitem= miitem.getCnsmiitemrep();
	     String getcnsreqdata=RecepcionReqController.this.getMicnsreq();
	     miitem.getItemrepaprobadorep();
		 FXMLLoader cargadatospararecibir = new FXMLLoader(getClass().getResource("DetalleRecepcionItems.fxml"));
		 try {
			 cargadatospararecibir.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    DetalleRecepcionItemsController thisitem = cargadatospararecibir.<DetalleRecepcionItemsController>getController();
		    thisitem.cantidadrepfinaltx.setText(Cantidad);
		    thisitem.itemrepfinaltx.setText(miitemfinal);
		    thisitem.setConsecutivoitem(consecutivoitem);
		    thisitem.setCnsreq(getcnsreqdata);
		    RecepcionReqController.this.setStackreqrep(stackreqrep);
		    thisitem.setStackreqrep( RecepcionReqController.this.getStackreqrep());
		    DetalleRecepcionItemsController controller = cargadatospararecibir.getController();
		    controller.setRecepcion(tablereqrep);
		    controller.setConfirmareqrep(confirmareqrep);
		    DetalleRecepcionItemsController controllerA = cargadatospararecibir.<DetalleRecepcionItemsController>getController();
		    //-------------------------------paso stage 1--------------------------//
		    controllerA.setGetStageuno( RecepcionReqController.this.getStageuno());
		   //-------------------------------paso stage 1--------------------------//
		    Parent StackPane =  cargadatospararecibir.getRoot();
		    Stage datosrecibidos=new Stage();
		    datosrecibidos.setScene(new Scene(StackPane));
		    //-----------------------------------------------------//
		    RecepcionReqController.this.setStagerep(datosrecibidos);
		    Stage rep = RecepcionReqController.this.getStagerep();
		    thisitem.setRep(rep);
		    //-----------------------------------------------------//
		    datosrecibidos.focusedProperty().addListener(new ChangeListener<Boolean>()
	 		{
	 		  @Override
	 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
	 		  {
	 		    if(newValue == true) {
	 		    RecepcionReqController.this.tablereqrep.setDisable(true);
	 		  }
	 		  }
	 		});
		    datosrecibidos.showingProperty().addListener(new ChangeListener<Boolean>()
		 		{
		 		  @Override
		 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
		 		  {
		 		    if(newValue == false) {
		 		    	RecepcionReqController.this.tablereqrep.setDisable(false);
		 		  }
		 		  }
		 		});
		    StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    datosrecibidos.setTitle("Recepcion de Items");
		    datosrecibidos.show();
			}catch(NullPointerException nn) {
				System.out.println("fila sin datos");
			}
			}
			}catch(NullPointerException nn) {
				System.out.println("fila sin datos");
			}
		});
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		itemrep.setCellValueFactory(new PropertyValueFactory <itemrep,String>("Itemrep"));
		cantidadrep.setCellValueFactory(new PropertyValueFactory <itemrep,Integer>("Cantidadrep"));
		estadorep.setCellValueFactory(new PropertyValueFactory <itemrep,String>("Itemrepaprobadorep"));
		recibidorep.setCellValueFactory(new PropertyValueFactory <itemrep,String>("Estadoitemrep"));
		cnsitemrep.setCellValueFactory(new PropertyValueFactory <itemrep,String>("cnsmiitemrep"));
	    loaddata();
	    styleddata();
	    disabledata();	
	    muestradatosrecibidos() ;
	    confirmardata();
	}
	

	@Override
	public void start(Stage arg0) throws Exception {
	}


	public Stage getRecepciondereq() {
		return recepciondereq;
	}


	public void setRecepciondereq(Stage recepciondereq) {
		this.recepciondereq = recepciondereq;
	}

	public DatePicker getFechainireqf() {
		return fechainireqf;
	}

	public void setFechainireqf(DatePicker fechainireqf) {
		this.fechainireqf = fechainireqf;
	}

	public DatePicker getFechafinreqf() {
		return fechafinreqf;
	}

	public void setFechafinreqf(DatePicker fechafinreqf) {
		this.fechafinreqf = fechafinreqf;
	}

	public JFXComboBox <String> getAreareqfiltro() {
		return areareqfiltro;
	}

	public void setAreareqfiltro(JFXComboBox <String> areareqfiltro) {
		this.areareqfiltro = areareqfiltro;
	}

	public JFXComboBox <String> getCargoreqfiltro() {
		return cargoreqfiltro;
	}

	public void setCargoreqfiltro(JFXComboBox <String> cargoreqfiltro) {
		this.cargoreqfiltro = cargoreqfiltro;
	}

}
