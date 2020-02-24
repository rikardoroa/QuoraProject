package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class IndicadoresController extends Application implements Initializable{

	  @FXML public Label iduser;
	  @FXML private StackPane stpaneeind;
	  @FXML private BorderPane bpaneeind;
	  @FXML private VBox vboxrrind;
	  @FXML private  Button iniciouserind;
	  @FXML private BorderPane bpaneeind2;
	  @FXML private Pane imgviewwind2; 
	  @FXML private StackPane stpanetopind2;
	  @FXML private StackPane stpanetind2;
	  @FXML private BorderPane   bodeerp12;
	  @FXML private TabPane mitabpaneind;
	  @FXML private Tab mtab1ind;
	  @FXML private AnchorPane tab1ind; 
	  @FXML private Label  SSolicitudind;
	  @FXML private ComboBox<String> solicitudindc;   
	  @FXML private JFXButton generarind;
	  @FXML public BarChart <String,Integer> indicadorsoporte;
	  @FXML private  CategoryAxis fechas;
	  @FXML private NumberAxis cantidades;
	  @FXML private  JFXButton limpiag;   
	  @FXML private  CategoryAxis datos;
	  @FXML private NumberAxis cantidaddatos;
	  @FXML private  CategoryAxis fechasoporte;
	  @FXML private NumberAxis cantidadesoporte;
	  @FXML private DatePicker dateffin;
	  @FXML private DatePicker datefini;
	  @FXML private Label fechaini;
	  @FXML private Label fechafin;
	  @FXML private Label fechainisoporte;
	  @FXML private Label fechafsoporte;
	  @FXML private Label Solicitudsoporte;
	  @FXML private JFXButton limpiarsoportegrafico;
	  @FXML private ComboBox<String> soporteindicador;
	  @FXML private JFXButton generarsoportegrafico;
	  @FXML private DatePicker fechainiciosoporte;
	  @FXML private DatePicker fechafinsoporte;
	  @FXML public BarChart <String,Integer> soporteusuarios;
	  @FXML private  CategoryAxis fechassoporte;
	  @FXML private NumberAxis cantidadessoporte;
	  @FXML public Tab mtabsoporte;
	  Conexion conectar = new Conexion();
	  
	  public void inicio() throws IOException {
		  
		    Stage administrador=new Stage();
		    FXMLLoader carga = new FXMLLoader(getClass().getResource("Admin.fxml"));
		    Parent StackPane =(Parent) carga.load();
		    AdminScreenController loadl = carga.<AdminScreenController>getController();
		    String pasadato=iduser.getText().toString();
		    loadl.UserScreen.setText(pasadato);
		   
			  if((AdminScreenController.getCapdata().equals("ADMINISTRADORREV")|| AdminScreenController.getCapdata().equals("ADMINISTRADORREQ"))){
		    		loadl.btnimg5.setDisable(false);
		    		//---loadl btnimg5 setStyle("-fx-opacity:0.65;");//-----
		    		loadl.useritem.setDisable(false);
		    	}
			  else  {
		    		loadl.btnimg5.setDisable(true);
		    		loadl.btnimg5.setStyle("-fx-opacity:0.65;");
		    		loadl.useritem.setDisable(true);
		       }
		    loadl.btnimg1.hoverProperty().addListener(new ChangeListener<Boolean>() {
	 			@Override
	 			public void changed(ObservableValue<? extends Boolean> observable, Boolean OldValue, Boolean NewValue) {
	 				if(NewValue == false) {
	 				 loadl.btnimg1.setFitWidth(250);
	 				}
	 				if(NewValue == true) {
	 				  loadl.btnimg1.setFitWidth(150);
	 				 }
	 			    }
	 		     });
	    loadl.btnimg2.hoverProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean OldValue, Boolean NewValue) {
				if(NewValue == false) {
				 loadl.btnimg2.setFitWidth(250);
				}
				if(NewValue == true) {
				  loadl.btnimg2.setFitWidth(150);
				 }
			   }
		    });
	  loadl.btnimg3.hoverProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean OldValue, Boolean NewValue) {
				if(NewValue == false) {
				 loadl.btnimg3.setFitWidth(250);
				}
				if(NewValue == true) {
				  loadl.btnimg3.setFitWidth(150);
				 }
			   }
		  });
	  loadl.btnimg4.hoverProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean OldValue, Boolean NewValue) {
				if(NewValue == false) {
				 loadl.btnimg4.setFitWidth(250);
				}
				if(NewValue == true) {
				  loadl.btnimg4.setFitWidth(150);
				 }
			   }
		  });
	  loadl.btnimg5.hoverProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean OldValue, Boolean NewValue) {
				if(NewValue == false) {
				 loadl.btnimg5.setFitWidth(250);
				}
				if(NewValue == true) {
				  loadl.btnimg5.setFitWidth(150);
				}
			} 
		  });
	  loadl.btnimg6.hoverProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean OldValue, Boolean NewValue) {
				if(NewValue == false) {
				 loadl.btnimg6.setFitWidth(250);
				}
				if(NewValue == true) {
				  loadl.btnimg6.setFitWidth(150);
				 }
			   }
		  });
	  loadl.btnimg7.hoverProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean OldValue, Boolean NewValue) {
				if(NewValue == false) {
				 loadl.btnimg7.setFitWidth(250);
				}
				if(NewValue == true) {
				  loadl.btnimg7.setFitWidth(150);
				 }
			}
		  });
		    Scene scene = new Scene(StackPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			administrador.setScene(scene);
			administrador.setTitle("AdminScreen");
			Stage indicadoresStage=(Stage)vboxrrind.getScene().getWindow();
			indicadoresStage.hide();
			administrador.show();
			administrador.setMaximized(true);
           }
	  
	  public void iniciohome() {
		  iniciouserind.setOnAction(e->{  
				try {
					inicio();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		}
	  
	  @SuppressWarnings("unchecked")
	public ObservableList<Series<String, Integer>> datos() {
			String fechainicial=((TextField)datefini.getEditor()).getText();
			String fechafinal=((TextField)dateffin.getEditor()).getText();
			String Query= "SELECT FECHA_EJECUTADA ,  COUNT(PRIORIDAD) AS CANTIDAD FROM RINCIDENTES WHERE PRIORIDAD='ALTA' AND FECHA_EJECUTADA>='"+fechainicial+"' AND FECHA_EJECUTADA<='"+fechafinal+"' GROUP BY FECHA_EJECUTADA ORDER BY FECHA_EJECUTADA ASC"; 
			String Query2= "SELECT FECHA_EJECUTADA ,  COUNT(PRIORIDAD) AS CANTIDAD FROM RINCIDENTES WHERE PRIORIDAD='MEDIA' AND FECHA_EJECUTADA>='"+fechainicial+"' AND FECHA_EJECUTADA<='"+fechafinal+"'  GROUP BY FECHA_EJECUTADA ORDER BY FECHA_EJECUTADA ASC"; 
			String Query3= "SELECT FECHA_EJECUTADA ,  COUNT(PRIORIDAD) AS CANTIDAD FROM RINCIDENTES WHERE PRIORIDAD='BAJA' AND FECHA_EJECUTADA>='"+fechainicial+"' AND FECHA_EJECUTADA<='"+fechafinal+"'  GROUP BY FECHA_EJECUTADA ORDER BY FECHA_EJECUTADA ASC"; 
			ObservableList<XYChart.Series<String, Integer>> data =FXCollections.observableArrayList();
			      Series<String, Integer> as = new Series<>();
			      Series<String, Integer> bs = new Series<>();
			      Series<String, Integer> gg = new Series<>();
			Connection Conexiontabla = null;
	    	try {
	    		Conexiontabla=conectar.miconexion(Conexiontabla);
				PreparedStatement ps =Conexiontabla.prepareStatement(Query);
		       	ResultSet rs = ps.executeQuery();
		       	while (rs.next()) {
		       		String y=rs.getString("FECHA_EJECUTADA");
		       		int a=rs.getInt("CANTIDAD");
		       		as.getData().add(new XYChart.Data<>(y,a) ); 
		       	}
		    	as.setName("Prioridad Alta");
	    	   }catch(SQLException e) {
	    		e.printStackTrace();
	    	   }
	    	 try {
	    			Conexiontabla=conectar.miconexion(Conexiontabla);
					PreparedStatement pd =Conexiontabla.prepareStatement(Query2);
			    	ResultSet rss = pd.executeQuery();
		     	while (rss.next()) {
		     		String y=rss.getString("FECHA_EJECUTADA");
		       		int a=rss.getInt("CANTIDAD");
		       		bs.getData().add(new XYChart.Data<>(y,a) );
		       	}
		       	bs.setName("Prioridad Media");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	 try {
	    			Conexiontabla=conectar.miconexion(Conexiontabla);
					PreparedStatement pd =Conexiontabla.prepareStatement(Query3);
			    	ResultSet rss = pd.executeQuery();
		     	while (rss.next()) {
		     		String y=rss.getString("FECHA_EJECUTADA");
		       		int a=rss.getInt("CANTIDAD");
		       		gg.getData().add(new XYChart.Data<>(y,a) );
		       	}
		       gg.setName("Prioridad Baja");
		       	fechas.setLabel("Fechas");
		    	cantidades.setLabel("Cantidades");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	 data.addAll(as,bs,gg);
			return data;
	       }

	  @SuppressWarnings("unchecked")
		public ObservableList<Series<String, Integer>> datossoporte() {
				String fechai=((TextField)fechainiciosoporte.getEditor()).getText();
				String fechaf=((TextField)fechafinsoporte.getEditor()).getText();
				ObservableList<XYChart.Series<String, Integer>> datad =FXCollections.observableArrayList();
				String QueryS="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='PROBLEMA CON IMPRESORA' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC"; 
				String QueryR="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='DAÑO DE EQUIPO' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryZ="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='EQUIPO LENTO' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryW="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='PROBLEMA CON WIFI' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryT="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='ERROR DE SOFTWARE' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryMP="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='MANTENIMIENTO PREVENTIVO' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryMC="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='MANTENIMIENTO CORRECTIVO' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryFT="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='FALLA EN TELEFONO' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryCE="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='CONFIGURACION DE EQUIPO' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				String QueryDP="SELECT COUNT(SOLICITUD) AS CONTEO, FECHA_TEMPORAL_S FROM INCIDENTES WHERE  SOLICITUD ='PROBLEMA CON DRIVER DE PC' AND FECHA_TEMPORAL_S >='"+fechai+"' AND FECHA_TEMPORAL_S <='"+fechaf+"' GROUP BY FECHA_TEMPORAL_S, SOLICITUD ORDER BY FECHA_TEMPORAL_S ASC";
				Series<String, Integer> pimpresora = new Series<>();
				Series<String, Integer> dequipo = new Series<>();
				Series<String, Integer> equipol = new Series<>();
				Series<String, Integer> pwifi = new Series<>();
				Series<String, Integer> esoft = new Series<>();
				Series<String, Integer> mpre = new Series<>();
				Series<String, Integer> mcor = new Series<>();
				Series<String, Integer> ft = new Series<>();
				Series<String, Integer> ce = new Series<>();
				Series<String, Integer> dp = new Series<>();
				 Connection Conexiontabla = null;
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryS);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		pimpresora.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				    	pimpresora.setName("Problema Con Impresora");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryR);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		dequipo.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				    	dequipo.setName("Daño De Equipo");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryZ);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		equipol.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	equipol.setName("Equipo Lento");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryW);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		pwifi.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	pwifi.setName("Problema Con Wifi");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryT);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		esoft.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	esoft.setName("Error De Software");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryMP);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		mpre.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	mpre.setName("Mantenimiento Preventivo");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryMC);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		mcor.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	mcor.setName("Mantenimiento Correctivo");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryFT);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		ft.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	ft.setName("Falla en el Telefono");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryCE);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		ce.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	ce.setName("Configuracion de Equipo");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	try {
			    		Conexiontabla=conectar.miconexion(Conexiontabla);
						PreparedStatement ps =Conexiontabla.prepareStatement(QueryDP);
				       	ResultSet rsz = ps.executeQuery();
				       	while (rsz.next()) {
				       		String y=rsz.getString("FECHA_TEMPORAL_S");
				       		int a=rsz.getInt("CONTEO");
				       		dp.getData().add(new XYChart.Data<>(y,a) ); 
				       	}
				       	dp.setName("Problema Con Driver");
			    	}catch(SQLException e) {
			    		e.printStackTrace();
			    	   }
			    	fechassoporte.setLabel("Fechas");
			    	cantidadessoporte.setLabel("Cantidades");
			    	 datad.addAll(pimpresora,dequipo,equipol,pwifi,esoft,mpre,mcor,ft,ce,dp);
					return datad;
             	  }
			
	 public BarChart<String, Integer>crearbarchart(){
        indicadorsoporte.setData(datos());
        indicadorsoporte.setTitle("Soportes realizados en el Mes");
        return indicadorsoporte;
      }
	  
	  public BarChart<String, Integer>crearbarchartsoporte() {
		  soporteusuarios.setData(datossoporte());
		  soporteusuarios.setTitle("Soportes realizados en el Mes");
	        return soporteusuarios;
	  }
	
	  public void llenacombox() {
		  solicitudindc.getItems().add("REPORTE DE INCIDENTES");
	  }

	  public void llenacomboxsoporte() {
		  soporteindicador.getItems().add("SOPORTES SOLICITADOS");
	  }

	  public void validacombo() {
		  generarind.setOnMouseClicked(e->{
		  if(solicitudindc.getSelectionModel().getSelectedItem().equals("REPORTE DE INCIDENTES")) {
			  crearbarchart(); 
		  }
		  });
	  }
	  
	  public void validacombosoporte() {
		  generarsoportegrafico.setOnMouseClicked(e->{
		  if(soporteindicador.getSelectionModel().getSelectedItem().equals("SOPORTES SOLICITADOS")) {
			  crearbarchartsoporte();
		  }
		  });
	  }
	  
	public void generaincidentes(){
		 generarind.setOnMouseClicked(e->{
		    	  if(solicitudindc.getSelectionModel().getSelectedIndex()==-1||((TextField)datefini.getEditor()).getText().isEmpty()||((TextField)dateffin.getEditor()).getText().isEmpty()) {
		    		  try {
		    	      Mensaje data = new Mensaje();
		    	      data.msjgraficos(stpaneeind);
	    	         }catch(NullPointerException nn) {
	    	        	 nn.printStackTrace();
	    	         }
		    	     }
		    	  else {
		    		  validacombo();
		    	    }
		            });  
	                }
	

	public void generaincidentesoporte(){
		generarsoportegrafico.setOnMouseClicked(e->{
		    	  if(soporteindicador.getSelectionModel().getSelectedIndex()==-1||((TextField)fechainiciosoporte.getEditor()).getText().isEmpty()||((TextField)fechafinsoporte.getEditor()).getText().isEmpty()) {
		    		  try {
		    			  Mensaje data = new Mensaje();
			    	      data.msjgraficos(stpaneeind);  
	    	         }catch(NullPointerException nn) {
	    	        	 nn.printStackTrace();
	    	         }
		    	     }
		    	  else {
		    		  validacombosoporte();
		    	    }
		            });  
	                }
	
	 public void limpiagrafico() {
		 limpiag.setOnMouseClicked(e->{
			 indicadorsoporte.getData().clear();
		 });
	 }
	 
	
	 public void limpiagraficosoporte() {
		 limpiarsoportegrafico.setOnMouseClicked(e->{
			 soporteusuarios.getData().clear();
		 });
	 }
	 
	public static void main(String[] args) {
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniciohome();
		generaincidentes();
		generaincidentesoporte();
		llenacombox();
		llenacomboxsoporte();
		limpiagrafico();
		limpiagraficosoporte();

	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}
}