package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TablaItemsDetalleController  extends Application implements Initializable {
	
	@FXML public StackPane stackpaneitems;
    @FXML public TableView<ItemsDetalle>  tablaitemsinapro;
    @FXML public TableColumn<ItemsDetalle, String> solitem;
    @FXML public TableColumn<ItemsDetalle, String> consecutivoitem; 
    @FXML public TableColumn<ItemsDetalle, String> areaitem; 
    @FXML public TableColumn<ItemsDetalle, String> cargoitem; 
    @FXML public TableColumn<ItemsDetalle, String> centroitem;  
    @FXML public TableColumn<ItemsDetalle, LocalDateTime> fechasolitem;  
    @FXML public TableColumn<ItemsDetalle, Integer> cantidaditem; 
    @FXML public TableColumn<ItemsDetalle, String> descitem;    
    @FXML public BorderPane borderdata;
    @FXML public JFXButton cargardatos;
    @FXML public JFXButton aplicarfiltro;
    @FXML public JFXButton resetitemsfields;
    @FXML public Label itemfechainicio;
    @FXML public Label itemfechafin;
    @FXML public Label cargoitemdetalle; 
    @FXML public Label areaitemdetalle;
    @FXML public JFXComboBox<String> combocargoitemdet;  
    @FXML public JFXComboBox<String> areacomboitemdet; 
    @FXML public DatePicker fechainiitem;
    @FXML public DatePicker fechafinitem;
	public String areacomboitem;
	public String cargocomboitem;
	public String fechainifinalitem;
	public String fechafinfinalitem;
	Conexion conectar = new Conexion();
    
    
    public void StyledCombos(){
    	combocargoitemdet.getItems().addAll("Sin Dato","Auxiliar De Sistemas","Coordinador De Sistemas","Auxiliar De Farmacia","Auxiliar De Compras","Auxiliar Administrativa");
    	combocargoitemdet.getSelectionModel().selectFirst();
    	areacomboitemdet.getItems().addAll("Sin Dato","Sistemas", "Cartera", "Comercial", "Gerencia", "Farmacia", "Calidad", "Mantenimiento","Administrativa");
    	areacomboitemdet.getSelectionModel().selectFirst();
    	areacomboitemdet.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
    	combocargoitemdet.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
    }
    
    public TableView<ItemsDetalle> selecciondetalleitems() {
    	cargardatos.setOnAction(e->{
	    ObservableList<ItemsDetalle> datostablaitemsdetalle= FXCollections.observableArrayList();
	   		String Query= "SELECT  SOLICITANTE , \r\n" + 
	   				" CONSECUTIVO , \r\n" + 
	   				" AREA, \r\n" + 
	   				" CARGO, \r\n" + 
	   				" CENTRO_OPERACION, \r\n" + 
	   				" FECHA_SOLICITUD , \r\n" + 
	   				" CANTIDAD, ITEM FROM RQITEMSTEMPORAL";
	   		Connection Conexiontabla = null;
	       	try {
	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	   	       	ResultSet rs = ps.executeQuery();
	   	        while(rs.next()) {
	   	        	datostablaitemsdetalle.add(new ItemsDetalle(
	   	        			 rs.getString("SOLICITANTE"),
	   	        		     rs.getString("CONSECUTIVO"),
	   	        		     rs.getString("AREA"),
	                   		 rs.getString("CARGO"),
	                   		 rs.getString("CENTRO_OPERACION"),
	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
	                   		 rs.getInt("CANTIDAD"),
	                   		 rs.getString("ITEM")
	                   		 )
	                         );
	   	    tablaitemsinapro.setItems(datostablaitemsdetalle);
    	    TableFilter<ItemsDetalle> tableFilter = new TableFilter<>(tablaitemsinapro);
    	    tableFilter.filterColumn(solitem);  
    	    tableFilter.filterColumn(consecutivoitem); 
    	    tableFilter.filterColumn(areaitem);
    	    tableFilter.filterColumn(cargoitem);
    	    tableFilter.filterColumn(fechasolitem);
    	    tableFilter.filterColumn(cantidaditem);
    	    tableFilter.filterColumn(descitem);
    	    tableFilter.filterColumn(centroitem);
	   			 }
	       	}catch(SQLException ee) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}
    	});
		return tablaitemsinapro;
	   }  
    
    
    public TableView<ItemsDetalle> filtradodedatositems() {
    	aplicarfiltro.setOnMouseClicked(e->{
    		//-----------------captura de variables--------------//
    		areacomboitem=areacomboitemdet.getSelectionModel().getSelectedItem();
    		fechainifinalitem=((TextField)fechainiitem.getEditor()).getText();
    		fechafinfinalitem=((TextField)fechafinitem.getEditor()).getText();
    		cargocomboitem=combocargoitemdet.getSelectionModel().getSelectedItem();
    		//--------------------------------------------------------------//
    		
    		 if(((TextField)fechainiitem.getEditor()).getText().isEmpty()&&((TextField)fechafinitem.getEditor()).getText().isEmpty()) {
	   				Mensaje data = new Mensaje();
	   				data.Mensajefechas(stackpaneitems, fechainiitem, fechainiitem);
	   			   } 
    		 //-------------------------------------------------------bloque else ------------------------------------------------------------------------------------------------------------------------------------------------//
    		   else {   
   	    	    try { 
   	    	 //------------------------------------------------------------bloque if--------------------------------------------------------------------------------------------------------------------------------------------------------------------//
   		   if(combocargoitemdet.getSelectionModel().getSelectedItem().equals("Sin Dato")&&areacomboitemdet.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainiitem.getEditor()).getText().isEmpty()&&!((TextField)fechafinitem.getEditor()).getText().isEmpty())
   		   {
   	    		  try {     Connection Conexiontablarequi =null;
	  	    	    		ObservableList<ItemsDetalle> Datostablaitemsfechas= FXCollections.observableArrayList();
	  	    	    		String QueryFiltrof="SELECT SOLICITANTE, CONSECUTIVO, AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD, CANTIDAD, ITEM FROM RQITEMSTEMPORAL\r\n" + 
	  	    	    				"WHERE CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)>= ? \r\n" + 
	  	    	    				"AND CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)<=?  \r\n" + 
	  	    	    				"ORDER BY 5 ASC" ;
	  	    	    		Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
	  	    				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltrof);
	  	    				ps.setString(1, fechainifinalitem);
	  	    				ps.setString(2, fechafinfinalitem);
	  	    		     	ResultSet rs = ps.executeQuery();
	  	    		        while(rs.next()) {
	  	    		        	Datostablaitemsfechas.add(new ItemsDetalle(
	  	    		        		rs.getString("SOLICITANTE"),
	  	  	   	        		     rs.getString("CONSECUTIVO"),
	  	  	   	        		     rs.getString("AREA"),
	  	  	                   		 rs.getString("CARGO"),
	  	  	                   	     rs.getString("CENTRO_OPERACION"), 
	  	  	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
	  	  	                   		 rs.getInt("CANTIDAD"),
	  	  	                   		 rs.getString("ITEM")
	  	    	                		 )
	  	    	                         );
	  	    				             }
	  	    		      tablaitemsinapro.setItems(Datostablaitemsfechas);
	  	    		      Mensaje dataobject = new Mensaje();
	  	    		      dataobject.mensaje(tablaitemsinapro, stackpaneitems);
	    	      }catch(SQLException mm) {
	    	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
	    		}
   		     }
    		 //-------------------------------------------------------------------------fin bloque if----------------------------------------------------------------------------------//
   		   
   		  //---------------------------------------------------------------------bloque if else-------------------------------------------------------------------------------------// 
   		else if(combocargoitemdet.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainiitem.getEditor()).getText().isEmpty()&&!((TextField)fechafinitem.getEditor()).getText().isEmpty()) {
   			   Connection Conexiontablarequi =null;
	    		ObservableList<ItemsDetalle> Datostablafechaitemsinglemodel= FXCollections.observableArrayList();
	    		String QueryFiltroff="SELECT SOLICITANTE, CONSECUTIVO, AREA,CARGO, CENTRO_OPERACION , FECHA_SOLICITUD, CANTIDAD, ITEM FROM RQITEMSTEMPORAL\r\n" + 
	    				"WHERE CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)>=? \r\n" + 
	    				"AND CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)<=? \r\n" + 
	    				"AND AREA=? \r\n" + 
	    				"ORDER BY 5 ASC";
	    		try {
  		    	Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
  				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltroff);
  				ps.setString(1, fechainifinalitem);
  				ps.setString(2, fechafinfinalitem);
  				ps.setString(3, areacomboitem);
  		     	ResultSet rs = ps.executeQuery();
  		        while(rs.next()) {
  		        	Datostablafechaitemsinglemodel.add(new ItemsDetalle(
  		        			     rs.getString("SOLICITANTE"),
	  	   	        		     rs.getString("CONSECUTIVO"),
	  	   	        		     rs.getString("AREA"),
	  	                   		 rs.getString("CARGO"),
	  	                   	     rs.getString("CENTRO_OPERACION"),
	  	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
	  	                   		 rs.getInt("CANTIDAD"),
	  	                   		 rs.getString("ITEM")
  	                		 )
  	                         );
  				             }
  		      tablaitemsinapro.setItems(Datostablafechaitemsinglemodel);
  		      Mensaje dataobject = new Mensaje();
		      dataobject.mensaje(tablaitemsinapro, stackpaneitems);
      }catch(SQLException mm) {   
    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
	   } 
   }
   	//------------------------------------------------------------fin bloque if else-----------------------------------------------------------------------------------------------------------------------//	   
   	   else if(areacomboitemdet.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainiitem.getEditor()).getText().isEmpty()&&!((TextField)fechafinitem.getEditor()).getText().isEmpty()) {  
   		    Connection Conexiontablarequi =null;
   		    ObservableList<ItemsDetalle> Datostablaitemsfechassingle= FXCollections.observableArrayList();
    		String QueryFiltrof="SELECT SOLICITANTE, CONSECUTIVO, AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD, CANTIDAD, ITEM FROM RQITEMSTEMPORAL\r\n" + 
    				"WHERE CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)>=? \r\n" + 
    				"AND CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)<=? \r\n" + 
    				"AND CARGO=? \r\n" + 
    				"ORDER BY 5 ASC" ;
    		try {
	    	Conexiontablarequi =conectar.miconexion(Conexiontablarequi);
			PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltrof);
			ps.setString(1, fechainifinalitem);
			ps.setString(2, fechafinfinalitem);
			ps.setString(3, cargocomboitem);
	     	ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	Datostablaitemsfechassingle.add(new ItemsDetalle(
	        			    rs.getString("SOLICITANTE"),
	   	        		     rs.getString("CONSECUTIVO"),
	   	        		     rs.getString("AREA"),
	                   		 rs.getString("CARGO"),
	                   		 rs.getString("CENTRO_OPERACION"),
	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
	                   		 rs.getInt("CANTIDAD"),
	                   		 rs.getString("ITEM")
                		 )
                         );
			             }
	        tablaitemsinapro.setItems(Datostablaitemsfechassingle);
	        Mensaje dataobject = new Mensaje();
		    dataobject.mensaje(tablaitemsinapro, stackpaneitems);
             }catch(SQLException mm) {   
	       Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
          }  		
          }
   		  //--------------------------------------------fin bloque if else--------------------------------------------------------------------------// 
   		   
   	else {
	    try {
	    Connection Conexiontablarequi =null;
		ObservableList<ItemsDetalle> Datostablarequisicionesf= FXCollections.observableArrayList();
   		String QueryFiltro="SELECT SOLICITANTE, CONSECUTIVO, AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD, CANTIDAD, ITEM FROM RQITEMSTEMPORAL\r\n" + 
   				"WHERE CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)>=? \r\n" + 
   				"AND CONVERT(DATE,RQITEMSTEMPORAL.FECHA_SOLICITUD,103)<=? \r\n" + 
   				"AND CARGO LIKE ?  AND AREA LIKE ? \r\n" + 
   				"ORDER BY 5 ASC";
   		    Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
			PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltro);
			ps.setString(1, fechainifinalitem);
			ps.setString(2, fechafinfinalitem);
	        ps.setString(3, '%'+cargocomboitem+'%');
	        ps.setString(4, '%'+areacomboitem+'%');
	     	ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	Datostablarequisicionesf.add(new ItemsDetalle(
	        			 rs.getString("SOLICITANTE"),
   	        		     rs.getString("CONSECUTIVO"),
   	        		     rs.getString("AREA"),
                   		 rs.getString("CARGO"),
                   		 rs.getString("CENTRO_OPERACION"),
                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
                   		 rs.getInt("CANTIDAD"),
                   		 rs.getString("ITEM")
               		     )
                        );
			           }
	   	        tablaitemsinapro.setItems(Datostablarequisicionesf);
	   	        Mensaje dataobject = new Mensaje();
 		        dataobject.mensaje(tablaitemsinapro, stackpaneitems);
	   }catch(SQLException mm) {
		   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
		}
	   } 
   	     }catch(NullPointerException nn) {
 	     Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn);    	 
 	    	   }
    		   }
             	});
		return tablaitemsinapro;
    }
    
    
    public void resetcampositems() {
    	resetitemsfields.setOnMouseClicked(e->{
    	         fechainiitem.setValue(null);
    	         fechafinitem.setValue(null);
    			 areacomboitemdet.getSelectionModel().selectFirst();
    			 combocargoitemdet.getSelectionModel().selectFirst();
    		   });
    	    
    }

	public static void main(String[] args) {


	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		solitem.setCellValueFactory(new PropertyValueFactory <ItemsDetalle,String>("solicitantereqsinapro"));
		consecutivoitem.setCellValueFactory(new PropertyValueFactory <ItemsDetalle,String>("concecutivoreqsinapro"));
		areaitem.setCellValueFactory(new PropertyValueFactory <ItemsDetalle,String>("area"));
		cargoitem.setCellValueFactory(new PropertyValueFactory <ItemsDetalle,String>("cargo"));
		centroitem.setCellValueFactory(new PropertyValueFactory <ItemsDetalle,String>("centroop"));
		fechasolitem.setCellValueFactory(CellData -> CellData.getValue().FechasolreqsinaproProperty());
		cantidaditem.setCellValueFactory(new PropertyValueFactory <ItemsDetalle,Integer>("cantidaditemsinapro"));
		descitem.setCellValueFactory(new PropertyValueFactory <ItemsDetalle,String>("itemapro"));
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		fechasolitem.setCellFactory(column -> new TableCell<ItemsDetalle, LocalDateTime>() {
			    @Override
			    protected void updateItem(LocalDateTime item, boolean empty) {
			        super.updateItem(item, empty);
			        if (empty)
			            setText(null);
			        else
			            setText(String.format(item.format(formatter2)));
			          }
			        });
		selecciondetalleitems();
		StyledCombos();
		filtradodedatositems();
		resetcampositems();
	   }

	@Override
	public void start(Stage primaryStage) throws Exception {
	
	}

}
