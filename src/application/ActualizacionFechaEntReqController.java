package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ActualizacionFechaEntReqController extends Application implements Initializable{
	
	@FXML private StackPane stackinforeq;
	@FXML private JFXTextField cnsreqtxf;
	@FXML private JFXTextField cnsreqpredicado;
	@FXML private DatePicker fechaentregadf;
	@FXML private DatePicker fechabusini;
	@FXML private DatePicker fechabusfin;
	@FXML private JFXButton actualizar;
	@FXML private JFXButton cargardata;
	@FXML private JFXButton resetfecreq;
	@FXML private JFXButton filtrarrqrep;
	@FXML public  TableView<fechareqitems> datossol;
	@FXML private TableColumn<fechareqitems, String> consecutivo;
	@FXML private TableColumn<fechareqitems, String> fechaentrega;
	@FXML private TableColumn<fechareqitems, String> solicitante;
	@FXML private Label conseclabel;
	@FXML private Label fechaentlabel;
	@FXML private Label fechainilabel;
	@FXML private Label fechafinlabel;
	@FXML private Label reqlabel;
	Conexion conectar = new Conexion();
	public ObservableList<fechareqitems> datostablarequisiciones ;
	 
	String consec;
	String fecha;
	String sol;
	
	public String getConsec() {
		return consec;
	}


	public String getFecha() {
		return fecha;
	}


	public String getSol() {
		return sol;
	}


	public void setConsec(String consec) {
		this.consec = consec;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public void setSol(String sol) {
		this.sol = sol;
	}

	
	public TableView<fechareqitems> selecciondata(){
		cargardata.setOnMouseClicked(e->{
			datostablarequisiciones =FXCollections.observableArrayList();
	   		String Query= "SELECT CNSREQ,FECHA_ENTREGA,SOLICITANTE FROM REQUISICIONES WHERE ESTADO_ITEMS=1";
	   		Connection Conexiontabla = null;
	       	try {
	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	   	       	ResultSet rs = ps.executeQuery();
	   	        while(rs.next()) {
	   	        	datostablarequisiciones.add(new fechareqitems(
	   	        			 rs.getString("CNSREQ"),
	   	        		     rs.getString("FECHA_ENTREGA"),
	                   		 rs.getString("SOLICITANTE")
	                   		 )
	                         );
	   	    datossol.setItems(datostablarequisiciones);
    	    TableFilter<fechareqitems> tableFilter = new TableFilter<>(datossol);
    	    tableFilter.filterColumn(consecutivo);  
    	    tableFilter.filterColumn(fechaentrega); 
    	    tableFilter.filterColumn(solicitante);
    	 	 }
	       	}catch(SQLException ee) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}	
		});
		
		return datossol;
	}
	
	
	public void  styleddata() {
		cnsreqtxf.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;-fx-opacity: 1;");
		cnsreqpredicado.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
	    cnsreqtxf.setDisable(true);
	}
	
	public void seleccionadata() {
		datossol.setOnMouseClicked(e->{
			fechareqitems item = datossol.getSelectionModel().getSelectedItem();
			String data=item.getConsec();
			cnsreqtxf.setText(data);
		});	
	}
	
	

	
	public void filtrardata () {
		filtrarrqrep.setOnMouseClicked(e->{
			String Fechaini=((TextField)fechabusini.getEditor()).getText();
			String FechaFin=((TextField)fechabusfin.getEditor()).getText();
			ObservableList<fechareqitems> datostablaactfecha= FXCollections.observableArrayList();
	   		String Query= "SELECT CNSREQ,FECHA_ENTREGA,SOLICITANTE FROM REQUISICIONES \r\n" + 
	   				"WHERE ESTADO_ITEMS=1 \r\n" + 
	   				"AND CONVERT(DATE, CONVERT(VARCHAR(40),FECHA_ENTREGA,103),23) >='"+Fechaini+"'\r\n" + 
	   				"AND  CONVERT (DATE, CONVERT (VARCHAR(40),FECHA_ENTREGA,101),23) <='"+FechaFin+"'\r\n" + 
	   				"ORDER BY 2 ASC\r\n" + 
	   				"";
  	   		Connection Conexiontabla = null;
	       	try {
	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   			PreparedStatement pst =Conexiontabla.prepareStatement(Query);
	   	       	ResultSet rs = pst.executeQuery();
	   	        while(rs.next()) {
	   	        	datostablaactfecha.add(new fechareqitems(
	   	        			 rs.getString("CNSREQ"),
	   	        		     rs.getString("FECHA_ENTREGA"),
	                   		 rs.getString("SOLICITANTE")
	                   		 )
	                         );
	   	    datossol.setItems(datostablaactfecha);
    	 	}
	       	}catch(SQLException ee) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}	
		});
	}
	
	 public void updatefecha() {
		    actualizar.setOnMouseClicked(e->{
			try {
			String cnsreq=cnsreqtxf.getText().toString();
			LocalDate fecha = fechaentregadf.getValue();
			String mifecha=fecha.toString();
			Connection ConexionData=null;	
		    ConexionData=conectar.miconexion(ConexionData);
	        String updatedata="UPDATE REQUISICIONES SET FECHA_ENTREGA='"+mifecha+"'  WHERE CNSREQ='"+cnsreq+"'";
	        PreparedStatement ps =ConexionData.prepareStatement(updatedata);
	   	    ps.executeUpdate();
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
			JFXDialog dialogo = new JFXDialog(stackinforeq,contenido, JFXDialog.DialogTransition.CENTER);
			JFXButton cerrar = new JFXButton("CERRAR");
			cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family:'Oswald Regular'-Regular; -fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
			cerrar.setOnAction(e3->{
			dialogo.close();
			ObservableList<fechareqitems> datostablaactfecha= FXCollections.observableArrayList();
			ObservableList<fechareqitems> datostablaactfechaitems= FXCollections.observableArrayList();
			if(((TextField)fechabusfin.getEditor()).getText().isEmpty()&&((TextField)fechabusfin.getEditor()).getText().isEmpty()) {
	   		String Query= "SELECT CNSREQ,FECHA_ENTREGA,SOLICITANTE FROM REQUISICIONES WHERE ESTADO_ITEMS=1";
	   		Connection Conexiontabla = null;
	       	try {
	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   			PreparedStatement pst =Conexiontabla.prepareStatement(Query);
	   	       	ResultSet rs = pst.executeQuery();
	   	        while(rs.next()) {
	   	        	datostablaactfecha.add(new fechareqitems(
	   	        			 rs.getString("CNSREQ"),
	   	        		     rs.getString("FECHA_ENTREGA"),
	                   		 rs.getString("SOLICITANTE")
	                   		 )
	                         );
	   	    datossol.setItems(datostablaactfecha);
    	 	}
	       	}catch(SQLException ee) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}
			}	
			else if(!((TextField)fechabusfin.getEditor()).getText().isEmpty()&&!((TextField)fechabusfin.getEditor()).getText().isEmpty()) {
				String Fechaini=((TextField)fechabusini.getEditor()).getText();
				String FechaFin=((TextField)fechabusfin.getEditor()).getText();
				
		   		String Query= "SELECT CNSREQ,FECHA_ENTREGA,SOLICITANTE FROM REQUISICIONES \r\n" + 
		   				"WHERE ESTADO_ITEMS=1 \r\n" + 
		   				"AND CONVERT(DATE, CONVERT(VARCHAR(40),FECHA_ENTREGA,103),23) >='"+Fechaini+"'\r\n" + 
		   				"AND  CONVERT (DATE, CONVERT (VARCHAR(40),FECHA_ENTREGA,101),23) <='"+FechaFin+"'\r\n" + 
		   				"ORDER BY 2 ASC\r\n" + 
		   				"";
	  	   		Connection Conexiontabla = null;
		       	try {
		       		Conexiontabla=conectar.miconexion(Conexiontabla);
		   			PreparedStatement pst =Conexiontabla.prepareStatement(Query);
		   	       	ResultSet rs = pst.executeQuery();
		   	        while(rs.next()) {
		   	        	datostablaactfechaitems.add(new fechareqitems(
		   	        			 rs.getString("CNSREQ"),
		   	        		     rs.getString("FECHA_ENTREGA"),
		                   		 rs.getString("SOLICITANTE")
		                   		 )
		                         );
		   	    datossol.setItems(datostablaactfechaitems);
	    	 	}
		       	}catch(SQLException ee) {
		       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
		       	}		
			}
			});
			 fechaentregadf.setValue(null);
			 cnsreqpredicado.clear();
			 cnsreqtxf.clear();
			contenido.setActions(cerrar);
			dialogo.show();
		  }catch(NullPointerException | SQLException ee) {
			  Mensaje error = new Mensaje();
			error.mensajeerror(stackinforeq);
		  }
		});
		
	}
	 
	 public void filtro() {
		 cnsreqpredicado.setOnKeyPressed(e->{
			FilteredList<fechareqitems> filteredData = new FilteredList<>(datostablarequisiciones, p -> true);
			cnsreqpredicado.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(cnsreqpredicado -> {
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }
	                
	                String lowerCaseFilter = newValue.toLowerCase();
	                if (cnsreqpredicado.getConsec().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; 
	                } 
	                return false; 
	            });
	        });
	        SortedList<fechareqitems> sortedData = new SortedList<>(filteredData);
	        sortedData.comparatorProperty().bind(datossol.comparatorProperty());
	        datossol.setItems(sortedData);
		 });
	 }
	 
	 
	 public void resetdata() {
	 resetfecreq.setOnAction(e->{
		 fechaentregadf.setValue(null);
		 cnsreqtxf.clear();
		 cnsreqpredicado.clear();
		 fechabusini.setValue(null);
		 fechabusfin.setValue(null);
	 });
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		consecutivo.setCellValueFactory(new PropertyValueFactory <fechareqitems,String>("consec"));
		fechaentrega.setCellValueFactory(new PropertyValueFactory <fechareqitems,String>("fechaentrega"));
		solicitante.setCellValueFactory(new PropertyValueFactory <fechareqitems,String>("solicitante"));
		selecciondata();
		styleddata() ;
		seleccionadata();
		updatefecha() ;
		resetdata() ;
		filtrardata();
		filtro();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
