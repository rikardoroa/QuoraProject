package application;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SistemasController extends Application implements Initializable {

	   @FXML private StackPane stpaner;
	   @FXML private Pane imgvieww;
	   @FXML private BorderPane bpaneadm;
	   @FXML private AnchorPane tab2;
	   @FXML private AnchorPane tab3;
	   @FXML private VBox vboxadm;
	   @FXML private Tab  mtab2;
	   @FXML private Button inicioadm;
	   @FXML private BorderPane bpaneeadm;
	   @FXML private JFXButton grespuesta; 
	   @FXML private StackPane stpanetopadm;
	   @FXML private StackPane stpanetadm;  
	   @FXML private BorderPane bodeerp1adm;
	   @FXML private TabPane mitabpaneadm;
	   @FXML private DatePicker dtdos;
	   @FXML private DatePicker dteuno;
	   @FXML private JFXComboBox <String> horas;
	   @FXML private TextField trespuesta;
	   @FXML private JFXComboBox <String>tiempo;
	   @FXML private JFXComboBox <String> tejecutada;
	   @FXML private TextArea novedades; 
	   @FXML private JFXComboBox <String> verificacion; 
	   @FXML private JFXComboBox <String>  prioridadrin;
	   @FXML private JFXButton verrincidentes;
	   @FXML private JFXButton resets;
	   @FXML private JFXComboBox <String>cnssinres;
	   @FXML public  Label sistemaslabel;
	   @FXML public  Label sprioridad;
	   @FXML private Label srinres;
	   @FXML private Label sfprogram;
	   @FXML private Label stsol;
	   @FXML private Label sfeceje;
	   @FXML private Label shorasol;
	   @FXML private Label stareje;
	   @FXML private Label snoveje;
	   @FXML private Label svercor;
	   @FXML private JFXButton det;
       public Stage DetallesIncidentesStage;
       Conexion conectar = new Conexion();
 
	public static void main(String[] args) {
	
	}

	public void cargadetalledeincidentes() {
		det.setOnAction(e->{
			Stage registrosiniciales=new Stage();
		    FXMLLoader cargaregistros = new FXMLLoader(getClass().getResource("TablaIncidentes.fxml"));
			try {
				 Parent StackPane;
				StackPane = (Parent)cargaregistros.load();
				 Scene scene = new Scene(StackPane);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				registrosiniciales.setScene(scene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    IncidentesController cargamiuser = cargaregistros.<IncidentesController>getController();
		    String pasadato=UserController.getGetdata();
		    cargamiuser.tablalabel.setText(pasadato);
			registrosiniciales.setTitle("Registro De Incidentes");
			registrosiniciales.show();
			registrosiniciales.setMaximized(true);
			registrosiniciales.focusedProperty().addListener(new ChangeListener<Boolean>()
			{
			  @Override
			  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			  {
			    if(newValue == false) {
			    det.setDisable(true);
			  }
			  }
			});
			
			registrosiniciales.showingProperty().addListener(new ChangeListener<Boolean>()
			{
			  @Override
			  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			  {
			    if(newValue == false) {
			    det.setDisable(false);
			   }
			  }
			});
		});
	}
	
	public void llenaestilo() {
		 tejecutada.getItems().addAll("SI","NO");
		 tejecutada.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		 verificacion.getItems().addAll("SI","NO");
		 verificacion.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		 prioridadrin.getItems().addAll("ALTA","MEDIA","BAJA");
		 prioridadrin.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		 cnssinres.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		 tiempo.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		 tiempo.getItems().addAll("5 MINUTOS","10 MINUTOS","15 MINUTOS","20 MINUTOS","30 MINUTOS","60 MINUTOS","80 MINUTOS","120 MINUTOS","180 MINUTOS","200 MIMUTOS");
		 horas.getItems().addAll("06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00");
		 horas.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
		 novedades.setStyle("-fx-font-family: 'Oswald Regular'; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-size: 14px;");
     	}
	
	
	public void seleccionainsinr() {
		ObservableList<String> combosinrin= FXCollections.observableArrayList();
		String Query= "SELECT CNSINC AS CNSINC FROM INCIDENTES WHERE COALESCE(CNSRINC,'NULO')='NULO'  AND ISNULL(CNSRID,0)=0 ";
		Connection Conexion = null;
    	try {
    		Conexion=conectar.miconexion(Conexion);
			PreparedStatement ps =Conexion.prepareStatement(Query);
	       	ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	combosinrin.add(rs.getString("CNSINC"));
			 }
	        cnssinres.setItems(combosinrin);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}

	public void llenarincidente() {
		if(((TextField)dteuno.getEditor()).getText().isEmpty()||((TextField)dtdos.getEditor()).getText().isEmpty()||tiempo.getSelectionModel().getSelectedItem().equals("")||horas.getSelectionModel().getSelectedItem().equals("")||tejecutada.getSelectionModel().getSelectedItem().equals("")||novedades.getText().isEmpty()|| prioridadrin.getSelectionModel().getSelectedItem().equals("") ||verificacion.getSelectionModel().getSelectedItem().equals("")) {
			try {
				Mensaje ErrorMensaje = new Mensaje();
				ErrorMensaje.mensajeerror(stpanetadm);
		}catch(NullPointerException m){	
		}
		}
		else {
			try {
				String fechauno=((TextField)dteuno.getEditor()).getText();
				String fechados=((TextField)dtdos.getEditor()).getText();
				String capturatiempo=tiempo.getSelectionModel().getSelectedItem();
				String horasejecutadas=horas.getSelectionModel().getSelectedItem();;
				String ctejecutada=tejecutada.getSelectionModel().getSelectedItem();
				String capturatexto=novedades.getText().trim();
				String cverificacion=verificacion.getSelectionModel().getSelectedItem();
				String cprioridad=prioridadrin.getSelectionModel().getSelectedItem();
				String capturacnssinres=cnssinres.getSelectionModel().getSelectedItem();
				String Queryinsertar= "INSERT INTO RINCIDENTES (FECHA_PROGRAMADA,TIEMPO_ESTIMADO,FECHA_EJECUTADA,HORA_SOLUCION,TAREA_EJECUTADA,NOVEDADES,PRIORIDAD,VERIFICACION,CNSINC)VALUES ('"+fechauno+"','"+capturatiempo+"','"+fechados+"','"+horasejecutadas+"','"+ctejecutada+"','"+capturatexto+"','"+cprioridad+"','"+cverificacion+"','"+capturacnssinres+"')";
				Connection Conexiondos = null;
				Conexiondos=conectar.miconexion(Conexiondos);
				Statement crea =Conexiondos.createStatement();
		        crea.executeUpdate(Queryinsertar);
		        Mensaje mensajedatosconbd = new Mensaje();
		        mensajedatosconbd.mensajedatosconbd(stpanetadm);
		}catch(NullPointerException m){
			m.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
	  }
		
	public void botoninsertarsolicitud() {
		grespuesta.setOnMouseClicked(e->{
			llenarincidente();
			tiempo.setValue("");
			horas.setValue("");
			tejecutada.setValue("");
			novedades.clear();
			verificacion.setValue("");
			dteuno.setValue(null);
			dtdos.setValue(null);
			prioridadrin.setValue("");
			cnssinres.setValue("");
			vincularrespuestas();
			calculofechatemporal();
		});
	}
	
	public void validacomboconsecutivo() {
		cnssinres.setOnMouseClicked(e->{
			seleccionainsinr();
		});
	}
	
	public void restriccionverificacion() {
		novedades.setOnKeyPressed(e->{
			if(novedades.getText().length()==100) {
				novedades.setDisable(true);
				grespuesta.setDisable(true);
			}
			else {
				novedades.setDisable(false);
				grespuesta.setDisable(false);
			}	
		});
	}
 	
	public void limpiahabilitas() {
		resets.setOnMouseClicked(e->{
			novedades.clear();
			novedades.setDisable(false);
			grespuesta.setDisable(false);
		});
		
	}
	
	public void avisocr() {
		novedades.setOnMouseClicked(e->{
			Tooltip info=new Tooltip("SOLO SE PERMITEN 100 CARACTERES");
			novedades.setTooltip(info);
			info.setStyle("-fx-background-color:yellow; -fx-font-weight:bold");
		});
	}
	
	public void inicioadmin() throws IOException {
		Stage administrador=new Stage();
	    FXMLLoader carga = new FXMLLoader(getClass().getResource("Admin.fxml"));
	    Parent StackPane =(Parent) carga.load();
	    AdminScreenController loadl = carga.<AdminScreenController>getController();
	    String pasadato=sistemaslabel.getText().toString();
	    loadl.UserScreen.setText(pasadato);
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
		Stage sistemasstage=(Stage)verrincidentes.getScene().getWindow();
		sistemasstage.hide();
		administrador.show();
		administrador.setMaximized(true);
	}
	
	public void abriradm() {
		inicioadm.setOnMouseClicked(e->{
			try {
				inicioadmin();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

     public void mostrarregistrosriin() throws IOException {
		Stage registrosdeincidentes=new Stage();
	    FXMLLoader cargaregistrosin = new FXMLLoader(getClass().getResource("TablaRincidentes.fxml"));
	    Parent StackPane = (Parent)cargaregistrosin.load();
	    Scene scene = new Scene(StackPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		registrosdeincidentes.setScene(scene);
		registrosdeincidentes.setTitle("Respuesta De Incidentes");
		registrosdeincidentes.initModality(Modality.WINDOW_MODAL);
		registrosdeincidentes.show();
        registrosdeincidentes.setMaximized(true);
		registrosdeincidentes.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		  @Override
		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
		  {
		    if(newValue == false) {
		    	verrincidentes.setDisable(true);
		  }
		  }
		});
		registrosdeincidentes.showingProperty().addListener(new ChangeListener<Boolean>()
		{
		  @Override
		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
		  {
		    if(newValue == false) {
		    verrincidentes.setDisable(false);
		  }
		  }
		});
     }

     
	public void mostrartablarincidentes() {
		verrincidentes.setOnMouseClicked(e->{
			try {
				mostrarregistrosriin();
			} catch (IOException e2) {
				 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e2);
			}
		});
	}
	
	
	public void vincularrespuestas() {
		Connection Conexionprocedure = null;
    	try {
    		Conexionprocedure=conectar.miconexion(Conexionprocedure);
			CallableStatement vincular = Conexionprocedure.prepareCall("{call VINCULAR}");
			vincular.execute();
	       	vincular.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}

	public void calculofechatemporal() {
		Connection calculofechaprocedure = null;
    	try {
    		calculofechaprocedure=conectar.miconexion(calculofechaprocedure);
			CallableStatement fechatemp = calculofechaprocedure.prepareCall("{call ACTUALIZAF}");
			fechatemp.execute();
			fechatemp.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		llenaestilo();
		validacomboconsecutivo();
		botoninsertarsolicitud();
		mostrartablarincidentes();
		abriradm();
		restriccionverificacion();
		limpiahabilitas();
		cargadetalledeincidentes();
		avisocr();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
			
	}

	
}