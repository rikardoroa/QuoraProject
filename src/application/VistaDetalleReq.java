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
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaDetalleReq extends Application implements Initializable {

	@FXML StackPane Stackreqdetalle;
	@FXML JFXButton loaditemsreq;
	@FXML JFXTextField solreqdet;
	@FXML JFXTextField cargoreqdet;
	@FXML JFXTextField cnsreqdet;
	@FXML JFXTextField estadoreqdet;
	@FXML JFXTextField idreqdet; 
	@FXML JFXTextField eaprobacionreqdet;
	@FXML Label eaproreqdet;
	@FXML Label sreqdet;
	@FXML Label creqdet;
	@FXML Label rreqdet;
	@FXML Label ereqdet;
	@FXML Label  IDreqdet;
	@FXML TableView<Itemreq> tablereqdet;
	@FXML TableColumn<Itemreq, Integer> tvidreqdet;
	@FXML TableColumn<Itemreq, String> tvitemreqdet;
	@FXML TableColumn<Itemreq, Integer> tvcantidadreqdet;
	public String cnsreqdetalle;
	public int iddetallereq;
	Conexion conectar = new Conexion();
	
	public int getIddetallereq() {
		return iddetallereq;
	}

	public void setIddetallereq(int iddetallereq) {
		this.iddetallereq = iddetallereq;
	}
	  public String getCnsreqdetalle() {
		return cnsreqdetalle;
	}

	public void setCnsreqdetalle(String cnsreqdetalle) {
		this.cnsreqdetalle = cnsreqdetalle;
	}

	public void setestilostextfield() {
		solreqdet.setDisable(true);
		solreqdet.setStyle(" -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		cargoreqdet.setDisable(true);
		cargoreqdet.setStyle(" -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		cnsreqdet.setDisable(true);
		cnsreqdet.setStyle(" -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		estadoreqdet.setDisable(true);
		estadoreqdet.setStyle(" -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		idreqdet.setDisable(true);
		idreqdet.setStyle("-fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		eaprobacionreqdet.setDisable(true);
		eaprobacionreqdet.setStyle(" -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
	}
		
		
	
	public void muestradetalledata() {
		loaditemsreq.setOnAction(e->{
			String getmicnsreqdetalle=VistaDetalleReq.this.getCnsreqdetalle();
			int mifinaliddetalle=VistaDetalleReq.this.getIddetallereq();
			  ObservableList<Itemreq> reqdata= FXCollections.observableArrayList();
		   		String Query= "SELECT ITEMSREQ.ITEM AS ITEM, ITEMSREQ.CANTIDAD AS CANTIDAD ,ITEMSREQ.ID AS ID   \r\n" + 
		   				"		   				 	   				 FROM ITEMSREQ INNER JOIN REQUISICIONES  ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA   \r\n" + 
		   				"		   				 	   				 WHERE ITEMSREQ.CEDULA = REQUISICIONES.CEDULA AND REQUISICIONES.CARGO = ITEMSREQ.CARGO  \r\n" + 
		   				"		   				 	   				 AND  ITEMSREQ.IDREQ IS NULL  AND ITEMSREQ.CNSREQ IS NULL AND REQUISICIONES.CNSREQ='"+getmicnsreqdetalle+"'  \r\n" + 
		   				"		   				 	   				 AND REQUISICIONES.ID='"+mifinaliddetalle+"'  OR ITEMSREQ.IDREQ IS NOT NULL  AND ITEMSREQ.CNSREQ IS NOT NULL AND REQUISICIONES.CNSREQ='"+getmicnsreqdetalle+"'   \r\n" + 
		   				"		   				 	   				 AND REQUISICIONES.ID='"+mifinaliddetalle+"' \r\n" + 
		   				"		   				 	   				 GROUP BY ITEMSREQ.ITEM,ITEMSREQ.CANTIDAD,REQUISICIONES.CEDULA,ITEMSREQ.ID,  \r\n" + 
		   				"		   				 	   				 REQUISICIONES.CARGO,REQUISICIONES.SOLICITANTE , REQUISICIONES.FECHA_SOLICITUD, ITEMSREQ.FECHA_SOLICITUD   \r\n" + 
		   				"		   				 	   				 HAVING  CONVERT(varchar(16),REQUISICIONES.FECHA_SOLICITUD,20) = CONVERT(varchar(16),ITEMSREQ.FECHA_SOLICITUD,20) ORDER BY 3 ASC ";
		   		Connection Conexiontabla = null;
		       	try {
		       		Conexiontabla=conectar.miconexion(Conexiontabla);
		   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
		   	       	ResultSet rs = ps.executeQuery();
		   	        while(rs.next()) {
		   	        	reqdata.add(new Itemreq(
		   	        		    rs.getString("ITEM"),
		   	        		    rs.getInt("CANTIDAD"),
		   	        		    rs.getInt("ID")
		                   		 )
		                         );
		   	        	tablereqdet.setItems(reqdata);
		   			 }
		       	}catch(SQLException ee) {
		       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
		       	}
		});
	}
	
	
	
	public static void main(String[] args) {
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tvitemreqdet.setCellValueFactory(new PropertyValueFactory <Itemreq,String>("Item"));
		tvcantidadreqdet.setCellValueFactory(new PropertyValueFactory <Itemreq,Integer>("Cantidad"));
		tvidreqdet.setCellValueFactory(new PropertyValueFactory <Itemreq,Integer>("ID"));
		muestradetalledata();
		setestilostextfield();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		
	}

}
