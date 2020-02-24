package application;

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

public class IncidentesController extends Application implements Initializable {
//--------------------------variables---------------------------//

    @FXML public TableView<Incidentes>  tablaincidentes;
	@FXML public TableColumn<Incidentes, Integer>  idin;
    @FXML public TableColumn<Incidentes, String>  concecutivoin;
    @FXML public TableColumn<Incidentes, LocalDate>  fechasin;
    @FXML public TableColumn<Incidentes, String>  solicitudin;
    @FXML public TableColumn<Incidentes, String>  solicitantein;
    @FXML public TableColumn<Incidentes, String> areain;
    @FXML public TableColumn<Incidentes, String > comentariosin;
    @FXML public TableColumn<Incidentes, String > concecutivor;
	@FXML private JFXButton busquedar; 
	@FXML private JFXButton visualizarin;
	@FXML public Label tablalabel;
	@FXML private TextField predicado;
	@FXML public BorderPane bordertincidentes;
	@FXML private StackPane stackpanetabein;
	@FXML private Label finiinc;  
	@FXML private Label ffininc;
	@FXML private Label novedadesinc;
	@FXML private Label areaf;
	@FXML public DatePicker finidinc;
	@FXML public DatePicker ffindinc;
	@FXML private JFXButton bavanzadainc; 
	@FXML private JFXButton resetin;
	@FXML public JFXComboBox<String> comboinc;
	@FXML public JFXComboBox<String> comboarea;
	Conexion conectar = new Conexion();
	public String a;
	public String b;
	public String c;
	public String d;
	public ObservableList <Object> data =  FXCollections.observableArrayList();


public ObservableList<Object> getData() {
		return data;
	}

	public void setData(ObservableList<Object> data) {
		this.data = data;
	}

	//---------------------funcion que captura el string del usuario y lo setea al label---------//	
	  public String capturalabelparatabla(String texto) {
		  tablalabel.setText(texto);
		  return texto;
	    }
	  
//-------------------------------------------------------------------------------------------//
	
	  
//-----------------------------------------funcion que selecciona todos los datos de la tabla incidentes de la bd------------//	  
	public TableView<Incidentes> selecciondedatos() {
		visualizarin.setOnMouseClicked(e->{
		ObservableList<Incidentes> datostablaincidentes= FXCollections.observableArrayList();//----observable list para almacenar los datos
		String Query= "SELECT ID,CNSINC,FECHA_SOLICITUD, SOLICITUD,SOLICITANTE,(CASE WHEN INCIDENTES.AREA='CNSAREA1' THEN 'ADMINISTRATIVA'  WHEN INCIDENTES.AREA='CNSAREA2' THEN 'GERENCIA' WHEN INCIDENTES.AREA='CNSAREA3' THEN 'BODEGA' WHEN INCIDENTES.AREA='CNSAREA4' THEN 'COMERCIAL'  WHEN INCIDENTES.AREA='CNSAREA5' THEN 'FARMACIA' END) AS AREA, COMENTARIOS, COALESCE( CNSRINC,'SIN RESPUESTA') AS CNSRINC FROM INCIDENTES";
		Connection Conexiontabla = null;
    	try {
    		Conexiontabla=conectar.miconexion(Conexiontabla);
			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	       	ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	datostablaincidentes.add(new Incidentes(
                		 rs.getInt("ID"),
                		 rs.getString("CNSINC"),
                		 rs.getDate("FECHA_SOLICITUD").toLocalDate(), 
                		 rs.getString("SOLICITUD"), 
                		 rs.getString("SOLICITANTE"),
                		 rs.getString("AREA"),
                		 rs.getString("COMENTARIOS"),
                		 rs.getString("CNSRINC")
                		 )
                         );
	        	    tablaincidentes.setItems(datostablaincidentes);//----capturo los datos de la bd y los guardo en el observable list
	        	    TableFilter<Incidentes> tableFilter = new TableFilter<>(tablaincidentes);
	        	    tableFilter.filterColumn(idin);
	        	    tableFilter.filterColumn(concecutivoin);
	        	    tableFilter.filterColumn(fechasin);
	        	    tableFilter.filterColumn(solicitudin);
	        	    tableFilter.filterColumn(solicitantein);
	        	    tableFilter.filterColumn(areain);
	        	    tableFilter.filterColumn(comentariosin);
	        	    tableFilter.filterColumn(concecutivor);
			         }
    	}catch(SQLException ee) {
    		ee.printStackTrace();
    	}
		});
		return tablaincidentes;
		
	}
	//-------------------------------------------------------------------------//
	
	
	//--------------------------------funcion para añadir estilos al combobox--------------//
	public JFXComboBox<String> llenacombos() {
		comboinc.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		comboinc.getItems().addAll("SIN DATO","DAÑO DE EQUIPO","EQUIPO LENTO","PROBLEMA CON IMPRESORA","ERROR DE SOFTWARE","MANTENIMIENTO PREVENTIVO","MANTENIMIENTO CORRECTIVO","PROBLEMA CON DRIVER DE PC","PROBLEMA CON WIFI","FALLA EN TELEFONO","CONFIGURACION DE EQUIPO");
		comboinc.getSelectionModel().selectFirst();
		comboarea.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		comboarea.getItems().addAll("SIN DATO","ADMINISTRATIVA","GERENCIA","BODEGA","COMERCIAL","FARMACIA");
		comboarea.getSelectionModel().selectFirst();
		return comboarea; //retorna el combobox, igual retorna los dos internamente
	    }

	public void busquedavanzadadeincidentes() {
		bavanzadainc.setOnMouseClicked(e->{//-------------inicio evento mouse--------------//
			//------------------declaro variables y las capturo en las variables publicas-----//
			a=((TextField)finidinc.getEditor()).getText();
    	    b=((TextField)ffindinc.getEditor()).getText();
    		c=comboinc.getSelectionModel().getSelectedItem();
    	    d=comboarea.getSelectionModel().getSelectedItem();
    	    //---------------------------------------------------------------------------------//
    	//----------------------------------inicio bloque if primario----------------------------------------------------------------------//
    	if(((TextField)finidinc.getEditor()).getText().isEmpty()||((TextField)ffindinc.getEditor()).getText().isEmpty()) {
    		     //-----------------------mando un mensaje de error si las fechas estan vacias-------//
    		    Mensaje mjs = new Mensaje();
    		    mjs.Mensajefechas(stackpanetabein, finidinc, ffindinc);
			   } 
    	//-------------------------------------------------------------fin de bloque if primario-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    	  
    	//----------------------------------------------------------------inicio bloque else primario-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    	else {
    		   try {
    			   //-------------------------------------------------inicio bloque if----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    		     if(comboinc.getSelectionModel().getSelectedItem().equals("SIN DATO")&&comboarea.getSelectionModel().getSelectedItem().equals("SIN DATO")&&!((TextField)finidinc.getEditor()).getText().isEmpty()&&!((TextField)ffindinc.getEditor()).getText().isEmpty()) 
    		        {//-------------------------------------------hago la primera validacion, valido que los combos ni las fechas estan vacias y filtro con un query---------------------------------//
    		          	try {
    		        		ObservableList<Incidentes> datostablaincidentesuno= FXCollections.observableArrayList();
    		        		String Querya= "SELECT ID,CNSINC,FECHA_SOLICITUD, SOLICITUD,SOLICITANTE,(CASE WHEN INCIDENTES.AREA='CNSAREA1' THEN 'ADMINISTRATIVA'  WHEN INCIDENTES.AREA='CNSAREA2' THEN 'GERENCIA' WHEN INCIDENTES.AREA='CNSAREA3' THEN 'BODEGA' WHEN INCIDENTES.AREA='CNSAREA4' THEN 'COMERCIAL'  WHEN INCIDENTES.AREA='CNSAREA5' THEN 'FARMACIA' END) AS AREA, COMENTARIOS, CNSRINC FROM INCIDENTES WHERE CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103) <= ?";
    		        		Connection Conexiontabla = null;
    		        		Conexiontabla=conectar.miconexion(Conexiontabla);
    		    			PreparedStatement ps =Conexiontabla.prepareStatement(Querya);
    		    			ps.setString(1, a);
    		    			ps.setString(2, b);
    		    	       	ResultSet rs = ps.executeQuery();
    		    	        while(rs.next()) {
    		    	        	datostablaincidentesuno.add(new Incidentes(
    		                    		 rs.getInt("ID"),
    		                    		 rs.getString("CNSINC"),
    		                    		 rs.getDate("FECHA_SOLICITUD").toLocalDate(), 
    		                    		 rs.getString("SOLICITUD"), 
    		                    		 rs.getString("SOLICITANTE"),
    		                    		 rs.getString("AREA"),
    		                    		 rs.getString("COMENTARIOS"),
    		                    		 rs.getString("CNSRINC")
    		                    		 )
    		                             ); 
    		    			 }
    		    	         tablaincidentes.setItems(datostablaincidentesuno);
    		    	         Mensaje dataobject = new Mensaje();
  	  	    		         dataobject.mensaje(tablaincidentes, stackpanetabein);
    		        	}catch(SQLException | NullPointerException er) {
    		        		er.printStackTrace();
    		        	}	
    		        } 
    		   //-------------------------------------------------fin bloque if------------------------------//
	    		   
    		     
	    		   //---------------------------------------------primer bloque else if---------------------------------------------------------------------------------//
    		     else if(comboinc.getSelectionModel().getSelectedItem().equals("SIN DATO")&&!((TextField)finidinc.getEditor()).getText().isEmpty()&&!((TextField)ffindinc.getEditor()).getText().isEmpty()) 
    		     {//-------------------valido que el combo de los incidentes y las fechas  no esten vacias y filtro ---------------------------------------------------------------------//
    		    	 ObservableList<Incidentes> datostablaincidentesdos= FXCollections.observableArrayList();
		        		String Queryb= "SELECT ID,CNSINC,FECHA_SOLICITUD, SOLICITUD,SOLICITANTE,(CASE WHEN INCIDENTES.AREA='CNSAREA1' THEN 'ADMINISTRATIVA'  WHEN INCIDENTES.AREA='CNSAREA2' THEN 'GERENCIA' WHEN INCIDENTES.AREA='CNSAREA3' THEN 'BODEGA' WHEN INCIDENTES.AREA='CNSAREA4' THEN 'COMERCIAL'  WHEN INCIDENTES.AREA='CNSAREA5' THEN 'FARMACIA' END) AS AREA, COMENTARIOS, CNSRINC FROM INCIDENTES WHERE CONVERT(DATE,FECHA_SOLICITUD,103)>= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)<= ? AND (CASE WHEN INCIDENTES.AREA='CNSAREA1' THEN 'ADMINISTRATIVA'  WHEN INCIDENTES.AREA='CNSAREA2' THEN 'GERENCIA' WHEN INCIDENTES.AREA='CNSAREA3' THEN 'BODEGA' WHEN INCIDENTES.AREA='CNSAREA4' THEN 'COMERCIAL'  WHEN INCIDENTES.AREA='CNSAREA5' THEN 'FARMACIA' END) = ?";
    		    	 	try {
    		        		Connection Conexiontabla = null;
    		        		Conexiontabla=conectar.miconexion(Conexiontabla);
    		    			PreparedStatement ps =Conexiontabla.prepareStatement(Queryb);
    		    			ps.setString(1, a);
    		    			ps.setString(2, b);
    		    			ps.setString(3, d);
    		    	       	ResultSet rs = ps.executeQuery();
    		    	        while(rs.next()) {
    		    	        	datostablaincidentesdos.add(new Incidentes(
    		                    		 rs.getInt("ID"),
    		                    		 rs.getString("CNSINC"),
    		                    		 rs.getDate("FECHA_SOLICITUD").toLocalDate(), 
    		                    		 rs.getString("SOLICITUD"), 
    		                    		 rs.getString("SOLICITANTE"),
    		                    		 rs.getString("AREA"),
    		                    		 rs.getString("COMENTARIOS"),
    		                    		 rs.getString("CNSRINC")
    		                    		 )
    		                             ); 
    		    			 }
    		    	        tablaincidentes.setItems(datostablaincidentesdos);
    		    	        Mensaje dataobject = new Mensaje();
   	  	    		        dataobject.mensaje(tablaincidentes, stackpanetabein);
    		        	}catch(SQLException  er) {
    		        		  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, er);
    		        	}
    		           }
    		     //-----------------------------------------------fin del primer bloque if else----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    		     
    		     //----------------------------------------------------segundo bloque if else----------------------------------------------------------------------------------------------------------------------------------------------//
    		     else if(comboarea.getSelectionModel().getSelectedItem().equals("SIN DATO")&&!((TextField)finidinc.getEditor()).getText().isEmpty()&&!((TextField)ffindinc.getEditor()).getText().isEmpty()) 
    		     {//valido que el combobox del area y las fechas no esten vacias y realizo el filtro---//
    		    	    ObservableList<Incidentes> datostablaincidentestres= FXCollections.observableArrayList();//------declaro un observable list-------//
		        		String Queryb= "SELECT ID,CNSINC,FECHA_SOLICITUD, SOLICITUD,SOLICITANTE,(CASE WHEN INCIDENTES.AREA='CNSAREA1' THEN 'ADMINISTRATIVA'  WHEN INCIDENTES.AREA='CNSAREA2' THEN 'GERENCIA' WHEN INCIDENTES.AREA='CNSAREA3' THEN 'BODEGA' WHEN INCIDENTES.AREA='CNSAREA4' THEN 'COMERCIAL'  WHEN INCIDENTES.AREA='CNSAREA5' THEN 'FARMACIA' END) AS AREA, COMENTARIOS, CNSRINC FROM INCIDENTES WHERE CONVERT(DATE,FECHA_SOLICITUD,103)>= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)<= ? AND SOLICITUD = ?";
 		    	 	try {
 		        		Connection Conexiontabla = null;
 		        		Conexiontabla=conectar.miconexion(Conexiontabla);
 		    			PreparedStatement ps =Conexiontabla.prepareStatement(Queryb);
 		    			ps.setString(1, a);
 		    			ps.setString(2, b);
 		    			ps.setString(3, c);
 		    	       	ResultSet rs = ps.executeQuery();
 		    	        while(rs.next()) {
 		    	        	datostablaincidentestres.add(new Incidentes(
 		                    		 rs.getInt("ID"),
 		                    		 rs.getString("CNSINC"),
 		                    		 rs.getDate("FECHA_SOLICITUD").toLocalDate(), 
 		                    		 rs.getString("SOLICITUD"), 
 		                    		 rs.getString("SOLICITANTE"),
 		                    		 rs.getString("AREA"),
 		                    		 rs.getString("COMENTARIOS"),
 		                    		 rs.getString("CNSRINC")
 		                    		 )
 		                             ); 
 		    			 }
 		    	        tablaincidentes.setItems(datostablaincidentestres);//---------guardo los datos en el observable list------------//
 		    	        Mensaje dataobject = new Mensaje();
	  	    		    dataobject.mensaje(tablaincidentes, stackpanetabein);
 		    	 	}catch(SQLException  er) {
 		        		  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, er);
 		        	} 
    		    	 
    		     }
    		     //-------------------------------------------------------------------------------------fin segundo bloque if else------------//
    		     
    		     //----------------------------------------------------------------------------inicio bloque else-------------------------------------//
    		     else  {
    		    	 //sino se cumple todo lo anterior entonces, filtro los datos siempre y cuando nada este vacio----------------------------------------------//
    		    	 try {
    		    			ObservableList<Incidentes> datostablaincidentescuatro= FXCollections.observableArrayList();
     		        		String Queryd= "SELECT ID,CNSINC,FECHA_SOLICITUD, SOLICITUD,SOLICITANTE,(CASE WHEN INCIDENTES.AREA='CNSAREA1' THEN 'ADMINISTRATIVA'  WHEN INCIDENTES.AREA='CNSAREA2' THEN 'GERENCIA' WHEN INCIDENTES.AREA='CNSAREA3' THEN 'BODEGA' WHEN INCIDENTES.AREA='CNSAREA4' THEN 'COMERCIAL'  WHEN INCIDENTES.AREA='CNSAREA5' THEN 'FARMACIA' END) AS AREA, COMENTARIOS, CNSRINC FROM INCIDENTES WHERE CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103) <= ? AND SOLICITUD LIKE ? AND (CASE WHEN INCIDENTES.AREA='CNSAREA1' THEN 'ADMINISTRATIVA'  WHEN INCIDENTES.AREA='CNSAREA2' THEN 'GERENCIA' WHEN INCIDENTES.AREA='CNSAREA3' THEN 'BODEGA' WHEN INCIDENTES.AREA='CNSAREA4' THEN 'COMERCIAL'  WHEN INCIDENTES.AREA='CNSAREA5' THEN 'FARMACIA' END) LIKE ?";
     		        		Connection Conexiontabla = null;
     		        		Conexiontabla=conectar.miconexion(Conexiontabla);
     		    			PreparedStatement ps =Conexiontabla.prepareStatement(Queryd);
     		    			ps.setString(1, a);
     		    			ps.setString(2, b);
     		    			ps.setString(3, '%'+c+'%');
     		    			ps.setString(4, '%'+d+'%');
     		    	       	ResultSet rs = ps.executeQuery();
     		    	        while(rs.next()) {
     		    	        	datostablaincidentescuatro.add(new Incidentes(
     		                    		 rs.getInt("ID"),
     		                    		 rs.getString("CNSINC"),
     		                    		 rs.getDate("FECHA_SOLICITUD").toLocalDate(), 
     		                    		 rs.getString("SOLICITUD"), 
     		                    		 rs.getString("SOLICITANTE"),
     		                    		 rs.getString("AREA"),
     		                    		 rs.getString("COMENTARIOS"),
     		                    		 rs.getString("CNSRINC")
     		                    		 )
     		                             ); 
     		    			 }
     		    	        tablaincidentes.setItems(datostablaincidentescuatro);
     		    	        Mensaje dataobject = new Mensaje();
   	  	    		        dataobject.mensaje(tablaincidentes, stackpanetabein);
    		    	 }catch(SQLException nn) {
    		    		   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn);    	 
    		    	   }
    		     }
    		     //--------------------------------------fin bloque else------------------------------------------------------------------------------------------------------------------------------------------//
    	}catch(NullPointerException nn) {
    		nn.printStackTrace();
    	}
        }//-------------------------------------------------------------fin bloque else primario----------------------------------------------------------------//
		});//--------------fin evento mouse----------------//
		
	}//---------------fin funcion----------------------------//

	
	//----------------------------------------funcion que limpia datos de los combos y Datepickers---------------//
	public void limpiacampos() {
		resetin.setOnMouseClicked(e->{
			comboinc.getSelectionModel().selectFirst();	
			comboarea.getSelectionModel().selectFirst();
			finidinc.setValue(null);
			ffindinc.setValue(null);
		});
	  }
	//----------------------------------------------------------fin funcion------------------------------------//


	public static void main(String[] args) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idin.setCellValueFactory(new PropertyValueFactory <Incidentes,Integer>("IdIncidente"));
		concecutivoin.setCellValueFactory(new PropertyValueFactory <Incidentes,String>("ConcecutivoIncidente"));
		fechasin.setCellValueFactory(CellData -> CellData.getValue().fechasolicitudProperty());
		solicitudin.setCellValueFactory(new PropertyValueFactory <Incidentes,String>("Solicitudin"));
		solicitantein.setCellValueFactory(new PropertyValueFactory <Incidentes,String>("Solicitante"));
		areain.setCellValueFactory(new PropertyValueFactory <Incidentes,String>("area"));
		comentariosin.setCellValueFactory(new PropertyValueFactory <Incidentes,String>("comentarios"));
		concecutivor.setCellValueFactory(new PropertyValueFactory <Incidentes,String>("ConcecutivoRincidente"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
          fechasin.setCellFactory(column -> {
	         return new TableCell<Incidentes, LocalDate>() {
	             @Override
	             protected void updateItem(LocalDate item, boolean empty) {
	                 super.updateItem(item, empty);
	                 if (item == null || empty) {
	                     setText(null);
	                 } else {
	                     setText(formatter.format(item));
	                 }
	             }
	         };
	     });
        selecciondedatos();
		llenacombos();
		busquedavanzadadeincidentes();
		limpiacampos();
	
	}
	@Override
	public void start(Stage arg0) throws Exception {
	}
}