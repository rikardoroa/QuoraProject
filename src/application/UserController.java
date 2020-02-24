package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

public class UserController  extends Application implements Initializable {
	   
	   @FXML private JFXComboBox<String> area;
	   @FXML private TextField carea;
	   @FXML private TextField solicitante;
	   @FXML private JFXComboBox <String>solicitud;  
	   @FXML private TextArea comentarios;
	   @FXML private JFXButton incsolicitud;
	   @FXML private StackPane stpanee;
	   @FXML private Tab  mtab1;
	   @FXML private JFXButton registrosuser;
	   @FXML private Button btnn1;
	   @FXML private Button btnn2;
	   @FXML private Button btnn3;
	   @FXML private Button btnn4;
	   @FXML private BorderPane bpanee;
	   @FXML private VBox vboxrr;
	   @FXML private Pane imgvieww;
	   @FXML private Pane stpanetop;
	   @FXML private StackPane stpanet;
	   @FXML private BorderPane bodeerp1;
	   @FXML private TabPane mitabpane;
	   @FXML private AnchorPane tab1;
	   @FXML private Button iniciouser;
	   @FXML private JFXButton reset;
	   @FXML public Label iduser;
	   @FXML private Label SSolicitud;
	   @FXML private Label SArea;
	   @FXML private Label SSolicitante;
	   @FXML private Label Scodarea;
	   @FXML private Label Scomentarios;
	   @FXML public Label conteo;
	   public String capturau;
       public String micapuser;
       public static Stage data;
       public static String getdata;
       Conexion conectar = new Conexion(); 
       
	   public static String getGetdata() {
		return getdata;
	}

	public static void setGetdata(String pasadato) {
		UserController.getdata = pasadato;
	}

	public Label getIduser() {
		return iduser;
	}

	public void setIduser(Label iduser) {
		this.iduser = iduser;
	}

	public static Stage getData() {
		return data;
	}

	public static void setData(Stage data) {
		UserController.data = data;
	}

	public String setMicapuser(String micapuser) {
		solicitante.setText(micapuser);
		return micapuser;
	}

	public String getCapturau() {
		return capturau;
	}

	public String setCapturau(String capturau) {
		return this.capturau = capturau;
	}

	public void deshabilitacampo() {
		solicitante.setDisable(true);
		carea.setDisable(true);
		solicitante.setStyle("-fx-background-color:rgb(252,207,224); -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:14; -fx-opacity: 1;");
		carea.setStyle("-fx-background-color:rgb(252,207,224); -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular';  -fx-font-size:14; -fx-opacity: 1;");

	}

	public void stylecomentarios() {
		comentarios.setStyle("-fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular';  -fx-font-size:16;");
	}
	
	public void inicio() throws IOException {
					    Stage administrador=new Stage();
					    FXMLLoader carga = new FXMLLoader(getClass().getResource("Admin.fxml"));
					    Parent StackPane =(Parent) carga.load();
					    AdminScreenController loadl = carga.<AdminScreenController>getController();
					    String pasadato=iduser.getText().toString();
					    loadl.UserScreen.setText(pasadato);
					    
						  if((AdminScreenController.getCapdata().equals("ADMINISTRADORREV"))|| (AdminScreenController.getCapdata().equals("ADMINISTRADORREQ"))){
					    		loadl.btnimg5.setDisable(false);
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
						Stage userstage=(Stage)comentarios.getScene().getWindow();
						userstage.hide();
						administrador.show();
						administrador.setMaximized(true);
		                }
	
	public void capturarea() {
    	ObservableList<String> combomes= FXCollections.observableArrayList();
		String Query= "SELECT NOMBRE FROM AREA";
		Connection Conexion = null;
    	try {
    		Conexion=conectar.miconexion(Conexion);
			PreparedStatement ps =Conexion.prepareStatement(Query);
	       	ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
			 combomes.add(rs.getString("NOMBRE"));
			 }
	        area.setItems(combomes);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public void insertarsolicitud()
	
	{
		if(solicitante.getText().toString().isEmpty()||solicitud.getSelectionModel().getSelectedItem().equals("")||comentarios.getText().isEmpty()||area.getSelectionModel().getSelectedItem().equals("")||carea.getText().isEmpty()) {
			try {
				Mensaje ErrorMensaje = new Mensaje();
				ErrorMensaje.mensajeerror(stpanee);
		}catch(NullPointerException m){
			m.printStackTrace();
		}
		}
		else if(solicitud.getSelectionModel().getSelectedItem().equals("SELECCIONE DATO")||area.getSelectionModel().getSelectedItem().equals("SELECCIONE DATO")) {
			Mensaje WarninMessage = new Mensaje();
			WarninMessage.warningmessage(stpanee);		
		}
			
		else {
			try {
				String Capturasolicitud=solicitud.getSelectionModel().getSelectedItem();
				String Capturasolititante=solicitante.getText().trim();
				String capturacomentario=comentarios.getText().trim();
				String codigoarea=carea.getText().trim();
				String Queryinserta= "INSERT INTO INCIDENTES (FECHA_SOLICITUD,SOLICITUD,SOLICITANTE, AREA, COMENTARIOS)VALUES (GETDATE(),'"+Capturasolicitud+"','"+Capturasolititante+"','"+codigoarea+"','"+capturacomentario+"')";
				Connection Conexion = null;
				Conexion=conectar.miconexion(Conexion);
				Statement crea =Conexion.createStatement();
		        crea.executeUpdate(Queryinserta); 
		        Mensaje mensajedatosconbd = new Mensaje();
		        mensajedatosconbd.mensajedatosconbd(stpanee);
				String caracteres=comentarios.getText().toString();
				int conteochar=0;
				for(int i=0; i<caracteres.length();i++){
					conteochar=caracteres.length();
					conteochar++;
				}
				conteo.setText("Cantidad de caracteres enviados Fueron:"+conteochar+" "+"Maximo 100 Caracteres");
		}catch(NullPointerException m){
			m.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
	}
	
	public void restriccion() {
		comentarios.setOnKeyPressed(e->{
			if(comentarios.getText().length()==100) {
			        comentarios.setDisable(true);
					incsolicitud.setDisable(true);
			}
			else {
				comentarios.setDisable(false);
				incsolicitud.setDisable(false);
			}	
		});
	}
	
	
	public void avisoc() {
		comentarios.setOnMouseClicked(e->{
			Tooltip info=new Tooltip("SOLO SE PERMITEN 100 CARACTERES");
			comentarios.setTooltip(info);
			info.setStyle("-fx-background-color:yellow; -fx-font-weight:bold");
		});
	}
	
	
	public void limpiahabilita() {
		reset.setOnMouseClicked(e->{
			comentarios.clear();
			incsolicitud.setDisable(false);
			comentarios.setDisable(false);
		});
	}
	
	public void validarea() {
		area.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;   ");
		area.setOnAction(e->{
	    	  if(area.getSelectionModel().getSelectedItem().toString().equals("ADMINISTRATIVO")) {
	    		  carea.setText("CNSAREA1");
	    	  }
	    	  if(area.getSelectionModel().getSelectedItem().toString().equals("GERENCIA")) {
	    		  carea.setText("CNSAREA2");
	    	  }
	    	  if(area.getSelectionModel().getSelectedItem().toString().equals("BODEGA")) {
	    		  carea.setText("CNSAREA3");
	    	  }
	    	  if(area.getSelectionModel().getSelectedItem().toString().equals("COMERCIAL")) {
	    		  carea.setText("CNSAREA4");
	    	  }
	    	  if(area.getSelectionModel().getSelectedItem().toString().equals("FARMACIA")) {
	    		  carea.setText("CNSAREA5");
	    	  }
	    	  });
			  }
	
	public void iniciouser() {
		iniciouser.setOnAction(e->{  
			try {
				inicio();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	public void llenacomboa() {
		area.getItems().add("SELECCIONE DATO");
		area.getSelectionModel().selectLast();
		solicitud.getItems().addAll("SELECCIONE DATO","DAÑO DE EQUIPO","EQUIPO LENTO","PROBLEMA CON IMPRESORA","ERROR DE SOFTWARE","MANTENIMIENTO PREVENTIVO","MANTENIMIENTO CORRECTIVO","PROBLEMA CON DRIVER DE PC","PROBLEMA CON WIFI","FALLA EN TELEFONO","CONFIGURACION DE EQUIPO");
	    solicitud.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;   ");
	    solicitud.getSelectionModel().selectFirst();
	}
	
	
	public void mostrarregistrosi() throws IOException {
		Stage registrosiniciales=new Stage();
	    FXMLLoader cargaregistros = new FXMLLoader(getClass().getResource("TablaIncidentes.fxml"));
	    Parent StackPane = (Parent)cargaregistros.load();
	    IncidentesController cargamiuser = cargaregistros.<IncidentesController>getController();
	    String pasadato=iduser.getText().toString();
	    UserController.setGetdata(pasadato);
	    cargamiuser.tablalabel.setText(pasadato);
	    Scene scene = new Scene(StackPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		registrosiniciales.setScene(scene);
		registrosiniciales.setTitle("Registro De Incidentes");
		registrosiniciales.show();
		registrosiniciales.setMaximized(true);
		registrosiniciales.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		  @Override
		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
		  {
		    if(newValue == false) {
		    registrosuser.setDisable(true);
		  }
		  }
		});
		
		registrosiniciales.showingProperty().addListener(new ChangeListener<Boolean>()
		{
		  @Override
		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
		  {
		    if(newValue == false) {
		    registrosuser.setDisable(false);
		   }
		  }
		});
	}
	
	public void mostrartablai() {
		registrosuser.setOnMouseClicked(e->{
			try {
				mostrarregistrosi();	
			} catch (IOException e1) {
				 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}
		});
	}
	
	public void botoninserta() {
		incsolicitud.setOnMouseClicked(e->{
		 insertarsolicitud();
		 solicitud.setValue("");
		 comentarios.clear();
		 carea.clear();
		 area.setValue("");	
		});
	}
	public static void main(String[] args) {
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		iniciouser() ;
		botoninserta();
		validarea();
		mostrartablai();
		capturarea();
		llenacomboa();
		restriccion();
		limpiahabilita();
		deshabilitacampo();
		avisoc();
		stylecomentarios();
	}

	@Override
	public void start(Stage arg0) throws Exception {
	
	}
}