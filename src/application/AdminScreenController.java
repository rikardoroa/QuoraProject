package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class AdminScreenController extends Application implements Initializable {
	
	@FXML private BorderPane bpane;
    @FXML private StackPane stpane;
    @FXML private VBox vboxr;
    @FXML private Pane imgview;
    @FXML private StackPane stimage;
    @FXML private StackPane stpanetop;
    @FXML private Text bienvenidostx;
    @FXML private Button btn1;
    @FXML public Label UserScreen;
    @FXML public Label sistemaslabel;
    @FXML public ImageView btnimg5;
    @FXML public ImageView btnimg1;
    @FXML public ImageView btnimg4;
    @FXML public ImageView btnimg3;
    @FXML public ImageView btnimg2; 
    @FXML public ImageView btnimg6;
    @FXML public ImageView btnimg7;
    @FXML private Label ticket;
    @FXML private Label incidentes;   
    @FXML private Label  gseguimiento;
    @FXML private Label  ind;   
    @FXML private Label  gcalidad;
    @FXML private Label  gcartera;
    @FXML private Label  requisiciones;
    @FXML private MenuBar menubar1;
    @FXML private Menu menu1;
    @FXML private Menu menu3;
    @FXML public MenuItem useritem;
    @FXML private MenuBar menubar2;
    @FXML private MenuBar menubar3;
    @FXML private Menu menu2;
    @FXML public MenuItem updateitemf; 
    @FXML public MenuItem bfirma;
    @FXML public MenuItem actfechareq;
    @FXML public MenuItem festivos;
    @FXML private HBox hboxmenu;
    public TextField mdata;
    public static String capdata;
    public static String capuser;
    public static String caparea;
    public static String capcargo;
    public static String capcc;
    public static String capcentroop;


	public String h;
	public String user;
	public String area;
    public String cargo;
    public String miccdata;
    public String Centroop;
    public static Image capturafirma;
    public TableView<Incidentes> thisdata;
   
    
    //funciones que capturan las variables para visualizar usuario, rol
    
	public static String getCapcentroop() {
		return capcentroop;
	}

	public static void setCapcentroop(String capcentroop) {
		AdminScreenController.capcentroop = capcentroop;
	}
    
	public static String getCapcc() {
		return capcc;
	}

	public static void setCapcc(String capcc) {
		AdminScreenController.capcc = capcc;
	}
	
    public static String getCapuser() {
		return capuser;
	}

	public static void setCapuser(String capuser) {
		AdminScreenController.capuser = capuser;
	}


	public static String getCapdata() {
		return capdata;
	}

	public static String setCapdata(String data) {
		return capdata = data;
	}

	public String capturalabel(String texto) {
    	UserScreen.setText(texto);
		return texto;
    }
    
    public String capturalaberuseradmin(String mitexto) {
 	   sistemaslabel.setText(mitexto);
 	   return mitexto;
    }
    
    public static String getCaparea() {
		return caparea;
	}

	public static void setCaparea(String caparea) {
		AdminScreenController.caparea = caparea;
	}

	public static String getCapcargo() {
		return capcargo;
	}

	public static void setCapcargo(String capcargo) {
		AdminScreenController.capcargo = capcargo;
	}
	
	
	public static Image getcapturafirma() {
		return capturafirma;
	
	}
	
	public static void setcapturafirma(Image gettempimage) {
		AdminScreenController.capturafirma = gettempimage;
	}
	

   //----------------------------------------------------
	
	
// funcion que carga el stage para crear el usuario
	public void creausuariostage() throws IOException {
    	    Stage creauserstage = new Stage();
		    FXMLLoader creauser=new FXMLLoader(getClass().getResource("CreacionUser.fxml"));
		    Parent StackPane =(Parent) creauser.load();
		    Scene scene = new Scene(StackPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			creauserstage.setScene(scene);
			creauserstage.setTitle("Creacion De Usuario");
			creauserstage.show();
        }
	
//-----------------------------------------------------
	
// funcion que carga el stage para actualizar la firma digital
	public void creaupdatefirmastage() throws IOException {
		Stage  updatefirma = new Stage();
		FXMLLoader updatefdigital=new FXMLLoader(getClass().getResource("Actualizacionfdigital.fxml"));
		Parent StackPane =(Parent) updatefdigital.load();
		Scene scene = new Scene(StackPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		updatefirma.setScene(scene);
		updatefirma.setTitle("Actualizacion de Firma Digital");
		updatefirma.show();
	}
	
//----------------------------------------------------------------------//	
	public void verificaciondefirma() throws IOException {
		Stage  buscarfirma = new Stage();
		FXMLLoader fdigital=new FXMLLoader(getClass().getResource("VerificacionDeFirma.fxml"));
		Parent StackPane =(Parent) fdigital.load();
		Scene scene = new Scene(StackPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		buscarfirma.setScene(scene);
		buscarfirma.setTitle("Verificacion de Firma Digital");
		buscarfirma.show();
	}
	
	
	public void updatefechaentregareq() {
		actfechareq.setOnAction(e->{
			try {
			Stage  updatefechareq = new Stage();
			FXMLLoader updatefecha=new FXMLLoader(getClass().getResource("ActualizacionFechaRepReq.fxml"));
			Parent StackPane =(Parent) updatefecha.load();
			ActualizacionFechaEntReqController Data = updatefecha.<ActualizacionFechaEntReqController>getController();
			Data.datossol.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			Scene scene = new Scene(StackPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			updatefechareq.setScene(scene);
			updatefechareq.setTitle("Actualizacion de la Fecha de Entrega de la Requisicion");
			updatefechareq.show();	
			} catch (IOException e1) {
	 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}
		});
		
	}
	
	
	public void FestivosStagefinal() throws IOException {
		Stage  FestivosStage = new Stage();
		FXMLLoader FestivosLoader=new FXMLLoader(getClass().getResource("Festivos.fxml"));
		Parent StackPane =(Parent) FestivosLoader.load();
		Scene scene = new Scene(StackPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		FestivosStage.setScene(scene);
		FestivosStage.setTitle("Configuracion De Festivos");
		FestivosStage.show();
	}
	
	
	public void verfirma() {
		bfirma.setOnAction(e->{
			try {
				verificaciondefirma() ;
			} catch (IOException e1) {
	 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}
		});
	}
	

	//----------------------------------------------------------
     public void cargaupdatef() {
     updateitemf.setOnAction(e->{
    	 try {
			creaupdatefirmastage() ;
		} catch (IOException e1) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
		}
     });
     }
	
	
// funcion que carga la escena al realizar click desde el item del menu que esta en el adminscreen//	
    
    public void cargaescenauser() {
    	useritem.setOnAction(e->{
    		try {
				creausuariostage() ;
			} catch (IOException e1) {
	 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}
    	});
    }
    
//----------------------------------------------------------------------------------------------//
    //funcion que carga el stage SistemasView de donde se realiza la admon de Rincidentes
	public void SistemasView() throws IOException {
		    Stage sistemasstage = new Stage();
		    FXMLLoader cargasistemasuser=new FXMLLoader(getClass().getResource("SistemasScreen.fxml"));
		    Parent StackPane =(Parent) cargasistemasuser.load();
		    SistemasController cargamiuser = cargasistemasuser.<SistemasController>getController();
		    String pasadato=UserScreen.getText().toString();
		    cargamiuser.sistemaslabel.setText(pasadato);
		    Scene scene = new Scene(StackPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			sistemasstage.setScene(scene);
			sistemasstage.setTitle("QuoraApp");
			Stage AdminScreen=(Stage)btnimg1.getScene().getWindow();
            AdminScreen.hide();
			sistemasstage.show();
			sistemasstage.setMaximized(true);
	      }

//-------------------------------------------------------------------------------------//
	public void UserView() throws IOException {
	    Stage userstage = new Stage();
	    FXMLLoader cargauser =new FXMLLoader(getClass().getResource("UsuarioScreen.fxml"));
	    Parent StackPane = (Parent)cargauser.load();
	    UserController cargatodouser = cargauser.<UserController>getController();
	    String pasadato=UserScreen.getText().toString();
	    cargatodouser.iduser.setText(pasadato);
	    h=AdminScreenController.getCapdata();
	    user=AdminScreenController.getCapuser();
	    cargatodouser.setMicapuser(user);
	    Scene scene = new Scene(StackPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		userstage.setScene(scene);
		userstage.setTitle("QuoraApp");
		Stage AdminScreen=(Stage)btnimg1.getScene().getWindow();
        AdminScreen.hide();
        userstage.show();
        userstage.setMaximized(true);
      }

	
	public void IndicadoresView() throws IOException {
		    Stage indicadoresStage = new Stage();
		    FXMLLoader cargaindicadores =new FXMLLoader(getClass().getResource("indicadores.fxml"));
		    Parent StackPane = (Parent)cargaindicadores.load();
		    IndicadoresController cargatodouser = cargaindicadores.<IndicadoresController>getController();
		    String pasadato=UserScreen.getText().toString();
		    cargatodouser.iduser.setText(pasadato);
		    h=AdminScreenController.getCapdata();
		    if(!(AdminScreenController.getCapdata().equals("ADMINISTRADORREV")|| !AdminScreenController.getCapdata().equals("ADMINISTRADORREQ"))){
		    	cargatodouser.mtabsoporte.setDisable(true);	
	    	}
	    else {
	    	cargatodouser.mtabsoporte.setDisable(false);
	         }
		    Scene scene = new Scene(StackPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			indicadoresStage.setScene(scene);
			indicadoresStage.setTitle("QuoraApp");
			Stage AdminScreen=(Stage)btnimg1.getScene().getWindow();
	        AdminScreen.hide();
	        indicadoresStage.show();
	        indicadoresStage.setMaximized(true);
	      }
	
	public void RequisisionesView() throws IOException {
	    Stage RequisionesView = new Stage();
	    FXMLLoader cargarequisiciones =new FXMLLoader(getClass().getResource("RequisicionesView.fxml"));
	    Parent StackPane = (Parent)cargarequisiciones.load();
	    RequisicionesController cargarequi = cargarequisiciones.<RequisicionesController>getController();
	    String pasadato=UserScreen.getText().toString();
	    cargarequi.iduser.setText(pasadato);
	    h=AdminScreenController.getCapdata();
	    user=AdminScreenController.getCapuser();
	    area=AdminScreenController.getCaparea();
	    cargo=AdminScreenController.getCapcargo();
	    miccdata=AdminScreenController.getCapcc();
	    Centroop=AdminScreenController.getCapcentroop();
	    cargarequi.solreq.setText(user);
	    cargarequi.areauser.setText(area);
	    cargarequi.cargouser.setText(cargo);
	    cargarequi.midreq.setText(miccdata);
	    cargarequi.centroop.setText(Centroop);
	    Scene scene = new Scene(StackPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		RequisionesView.setScene(scene);
		RequisionesView.setTitle("QuoraApp");
		Stage AdminScreen=(Stage)btnimg1.getScene().getWindow();
        AdminScreen.hide();
        RequisionesView.show();
        RequisionesView.setMaximized(true);
	   }
	

	public void Muestrasistemascreen() {
		btnimg1.setOnMouseClicked(e->{
				try {
					UserView();
				} catch (IOException e1) {
		 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
				}		       
		     });
		   }
	
	public void UsersScreen() {
		btnimg5.setOnMouseClicked(e->{
				try {
					SistemasView();
				} catch (IOException e1) {
					Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			    }		       
		  });
		}

	public void IndicadoresScreen() {
		btnimg3.setOnMouseClicked(e->{
			try {
				IndicadoresView();
			} catch (IOException e1) {
				Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}	       
	  });
	}
		
	
	public void RequisicionesScreen() {
		btnimg7.setOnMouseClicked(e->{
			 try {
				RequisisionesView() ;
			} catch (IOException e1) {
				Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}
		});
	}
	
	public void FestivosScreen() {
		festivos.setOnAction(e->{
			try {
				FestivosStagefinal();
			} catch (IOException e1) {
				Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}
		});
	}

	public static void main(String[] args) {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Muestrasistemascreen();	
		UsersScreen();
		FestivosScreen();
		cargaescenauser();
		IndicadoresScreen();
		RequisicionesScreen();
		cargaupdatef() ;
		updatefechaentregareq();
		 verfirma();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
}