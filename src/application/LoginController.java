package application;
	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class LoginController extends Application implements Initializable {

	@FXML private Label usuario;
    @FXML private Label contrasena;
    @FXML private StackPane Login;
    @FXML private Button fboton;
    @FXML private StackPane SstackPane;
    @FXML private StackPane stpane;
    @FXML private StackPane Stpane;
    @FXML public TextField fusuario;
    @FXML private PasswordField fcontrasena;
    @FXML private BorderPane Borderlogin;
    public String roladmin="";
    public String miadmin="";
    public String areauser="";
    public String cargo="";
    public String centrooperacion="";
  

	public InputStream mifirma;
	public Image firma;
	public String micc="";
	Conexion conectar = new Conexion();

	public String getCentrooperacion() {
			return centrooperacion;
	}


	public void setCentrooperacion(String centrooperacion) {
			this.centrooperacion = centrooperacion;
	}
	
    public String getMicc() {
		return micc;
	}


    public void setMicc(String micc) {
		this.micc = micc;
	}


	public TextField getFusuario() {
			return fusuario;
	}


   public TextField setFusuario(TextField fusuario) {
			return this.fusuario = fusuario;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getAreauser() {
		return areauser;
	}


	public void setAreauser(String areauser) {
		this.areauser = areauser;
	}


	public String getMiadmin() {
		return miadmin;
	}


	public void setMiadmin(String miadmin) {
		this.miadmin = miadmin;
	}


	public String getRoladmin() {
	return roladmin;
    }
    

    public void setRoladmin(String roladmin) {
	this.roladmin = roladmin;
    }
   
    public Image getfirma() {
 		return firma;
 	}


 	public void setfirma(Image firma) {
 		this.firma = firma;
 	}

 	
 	public void setstylestexfield() {
 		fusuario.setStyle("-fx-text-fill:black; -fx-font-weight: bold;  -fx-font-family: 'Oswald Regular'; -fx-font-size:16;");
 		fcontrasena.setStyle("-fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular';-fx-font-size:16;");
 		
 	}
 	
 	
public void start( Stage primaryStage)throws Exception {
		    Stage loginu=new Stage();
	        FXMLLoader cargauser= new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
	        Font.loadFont(getClass().getResourceAsStream("/fondos/Oswald.ttf"),12);
		    Parent StackPane =(Parent) cargauser.load();
		    Scene scene = new Scene(StackPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			loginu.setScene(scene);
			loginu.setTitle("Login");
			loginu.show();
	        }
	

    public void eventoteclado() {
    	fcontrasena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent eventoteclado) {
                if (eventoteclado.getCode() == KeyCode.ENTER) {
                	try {
						conexion();
					} catch (IOException e) {
					} 
                }
            }
        });
    }

    
    public void  conexion () throws IOException {
		String miuserr=fusuario.getText().toString();
	    String mipass=fcontrasena.getText().toString();
	    TextField ffuser=LoginController.this.getFusuario();
	    String miusercc=ffuser.getText().toString();
		String comparauser="";
		String comparapass="";
		String SqlQuery="SELECT  USUARIOS.NOMBREUSUARIO  AS NOMBREUSUARIO, USUARIOS.CEDULA AS CEDULA,   CONVERT (VARCHAR(50), (DecryptByPassPhrase('*xc/6789o—---+y',PASS))) as PASS, USUARIOS.NOMBRE AS NOMBRE_ADMIN , USUARIOS.ROL AS ROL_ADMIN, USUARIOS.AREA AS AREA_USER , USUARIOS.CARGO AS CARGO, CENTRO_OPERACION, FIRMA_DIGITAL FROM USUARIOS  where USUARIOS.NOMBREUSUARIO='"+miuserr+"'  AND CONVERT (VARCHAR(50), (DecryptByPassPhrase('*xc/6789o—---+y',PASS)))='"+mipass+"'  OR   USUARIOS.CEDULA='"+miusercc+"'  AND CONVERT (VARCHAR(50), (DecryptByPassPhrase('*xc/6789o—---+y',PASS)))='"+mipass+"'";
		Connection ConexionData = null;
		try {
			ConexionData=conectar.miconexion(ConexionData);
			PreparedStatement ps =ConexionData.prepareStatement(SqlQuery);
	       	ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
			     comparauser=rs.getString("NOMBREUSUARIO");
			     micc=rs.getString("CEDULA");
			     comparapass=rs.getString("PASS");
			     miadmin=rs.getString("NOMBRE_ADMIN");
			     roladmin=rs.getString("ROL_ADMIN"); 
			     areauser=rs.getString("AREA_USER");
			     cargo=rs.getString("CARGO");
			     centrooperacion=rs.getString("CENTRO_OPERACION");
			     mifirma=rs.getBinaryStream("FIRMA_DIGITAL");
			     OutputStream os = new FileOutputStream(new File("firma.jpg"));
                 byte[]contenido = new byte[1024];
                 int tam = 0;
                 while((tam=mifirma.read(contenido))!= -1)
                 {
                 os.write(contenido,0,tam);
                 }
                 os.close();
                 mifirma.close();
                 firma = new Image("file:firma.jpg",311,114,true,true);
			  }
			 if(fusuario.getText().toString().equals("")&&fcontrasena.getText().toString().equals("")) {
				    Mensaje datat = new Mensaje();
				    datat.mensajeerror(Stpane);
			      }
			 else {
			 if((comparauser.equals(fusuario.getText().toString())&&comparapass.equals(fcontrasena.getText().toString().trim()))|| (miusercc.equals(micc)&& comparapass.equals(fcontrasena.getText().toString().trim()))) {
				 try {
					    Stage administrador=new Stage();
					    FXMLLoader carga = new FXMLLoader(getClass().getResource("Admin.fxml"));
					    Parent StackPane = (Parent)carga.load();
					    Scene scene = new Scene(StackPane);
					    AdminScreenController loadl = carga.<AdminScreenController>getController();
					    loadl.UserScreen.setText("Bienvenido"+"  "+miadmin);
					    
					    String h=LoginController.this.roladmin;
						LoginController.this.setRoladmin(h);
						String r=LoginController.this.getRoladmin();
						AdminScreenController.setCapdata(r);
						
						String A=LoginController.this.miadmin;
						LoginController.this.setMiadmin(A);
						String AA=LoginController.this.getMiadmin();
						AdminScreenController.setCapuser(AA);
						
						String B=LoginController.this.areauser;
						LoginController.this.setAreauser(B);
						String BB=LoginController.this.getAreauser();
						AdminScreenController.setCaparea(BB);
						
						String X=LoginController.this.cargo;
						LoginController.this.setCargo(X);
						String XX=LoginController.this.getCargo();
						AdminScreenController.setCapcargo(XX);
						
						String JX=LoginController.this.centrooperacion;
						LoginController.this.setCentrooperacion(JX);
						String JXX= LoginController.this.getCentrooperacion();
						AdminScreenController.setCapcentroop(JXX);
						
						String XY=LoginController.this.micc;
						LoginController.this.setMicc(XY);
						String XYY=LoginController.this.getMicc();
						AdminScreenController.setCapcc(XYY);
						
						
						Image tempimage=LoginController.this.firma;
						LoginController.this.setfirma(tempimage);
						Image gettempimage=LoginController.this.getfirma();
						AdminScreenController.setcapturafirma(gettempimage);
						  
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
						  
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						administrador.setScene(scene);
						administrador.setTitle("AdminScreen");
						Stage login=(Stage)fusuario.getScene().getWindow();
	                    login.hide();
						administrador.show();
						administrador.setMaximized(true);
				 }catch(Exception e) {
					 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e);
				 }
			 }
			 if(!comparauser.equals(fusuario.getText().toString())||!comparapass.equals(fcontrasena.getText().toString().trim())||!miusercc.equals(micc)) {
				    Mensaje datat = new Mensaje();
				    datat.datosinvalidos(Stpane);  
			 }
			 }
		}catch(SQLException e){
			  Mensaje datat = new Mensaje();
		      datat.SQlmsj(Stpane, e);
		      }
	         }


	public void conecta() {
	fboton.setOnMouseClicked(e->{
			try {
				conexion();
			} catch (IOException e1) {
				e1.printStackTrace();
			}      
	  });
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		eventoteclado();
		 setstylestexfield();
	}
}