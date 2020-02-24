package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RequisicionesController extends Application implements Initializable  {
	//-----------------------declaracion de variables----------//
	@FXML private StackPane stpanerequi;
	@FXML private StackPane stpanerequi2; 
	@FXML private StackPane stpanetrequi;
	@FXML private BorderPane bpanerequi; 
	@FXML private BorderPane bodeerrequi2;
	@FXML private VBox vboxreq;
	@FXML private Button inicioreq;
	@FXML private BorderPane bpanereq1;
	@FXML private Pane imgviewreq;
	@FXML public Label iduser; 
	@FXML public Label  solicitantereq; 
	@FXML public Label  cargoreq; 
	@FXML public Label  fechasol;  
	@FXML public Label  cantidadreq;  
	@FXML public Label  descripreq;
	@FXML public Label  observareq;  
	@FXML public Label  conteoreq;
	@FXML public Label fechainireqfllabel;
	@FXML public Label fechafinreqflabel;
	@FXML private TabPane tabpanerequi;  
	@FXML public TabPane tabpaneaproba;
	@FXML public Tab solicitudreq;
	@FXML public Tab aprobacionreq; 
	@FXML public Tab  revisionreq;
	@FXML private Tab mtabrequi;
	@FXML private AnchorPane anchorrequi;  
	@FXML private AnchorPane anchoreq;
	@FXML private JFXButton sendrequi;  
	@FXML private JFXButton resetreq;
	@FXML public TextField solreq; 
	@FXML public TextField areauser; 
	@FXML public TextField cargouser;
	@FXML public TextField  cantidaditem;
	@FXML public TextField descripcionitem;
	@FXML public TextField centroop;
	@FXML public TextArea observaciones;
	@FXML public TextField midreq;
	@FXML private JFXButton vregreq;
	@FXML private JFXButton vdetalles;
	@FXML private JFXButton vreqdt;
	@FXML private JFXButton agregaritem;
	@FXML private JFXButton resetreqapro;
	@FXML private JFXButton aplicareqapro;
	@FXML private JFXButton valida;
	@FXML private JFXButton resetreqfapro;
	@FXML private Label  fechainireq;
	@FXML private Label  fechafinreq;
	@FXML private Label  cargo;
	@FXML private Label areareq;
	@FXML private Label fechainireqapro;
	@FXML private Label fechafinreqapro;
	@FXML private Label cargoreqapro;
	@FXML private Label areareqapro; 
	@FXML private Label centrooplabel; 
	@FXML private Label idreq;
	@FXML private Label areareqflabel;
	@FXML private Label cargoreqflabel;
	@FXML public TableView<item>  titem;
	@FXML public TableColumn<item, Integer> cantidaditemm;  
	@FXML public TableColumn<item, String> itemm;
	@FXML public TableView<Requisiciones>  reqtable;
	@FXML public TableColumn<Requisiciones, String> revisionreqcol;  
	@FXML public TableColumn<Requisiciones, String> aprobacionreqcol;
	@FXML public TableColumn<Requisiciones, Integer > idreque;
    @FXML public TableColumn<Requisiciones, String > consecutivoReque;
    @FXML public TableColumn<Requisiciones, String > SolicitanteReque;
    @FXML public TableColumn<Requisiciones, String > AreaReque;
    @FXML public TableColumn<Requisiciones, String > CargoReque;
    @FXML public TableColumn<Requisiciones, String > coperacion;
    @FXML public TableColumn<Requisiciones, LocalDateTime> FechaSolReque; 
	@FXML public TableView<Aprobacion>  reqdt;
	@FXML public TableColumn<Aprobacion, String> restadorqdt;  
	@FXML public TableColumn<Aprobacion, String> rsolicitanterqdt;
    @FXML public TableColumn<Aprobacion, String > rarearqdt;
    @FXML public TableColumn<Aprobacion, String > rcargorqdt; 
    @FXML public TableColumn<Aprobacion, String > rcentrorqt;
    @FXML public TableColumn<Aprobacion, LocalDateTime> rfechasrqdt;
    @FXML public TableColumn<Aprobacion, String> rconcecutivorqdt;   
    @FXML private JFXComboBox <String> combocargo;  
    @FXML private JFXComboBox <String>   comboareaa; 
    @FXML private JFXComboBox <String>   aproreqcargo;  
    @FXML private JFXComboBox <String>   aproareareq;
    @FXML private JFXComboBox <String>   areareqfiltro;
    @FXML private JFXComboBox <String>   cargoreqfiltro;
    @FXML private JFXButton filtroreq;  
    @FXML private JFXButton  resetcampos; 
    @FXML private JFXButton cargadatosapro;
    @FXML private JFXButton aplicarfreqapro;
    @FXML private DatePicker fechainifil;  
    @FXML private DatePicker fechafinreqfil;
    @FXML private DatePicker aprofechaini;  
    @FXML private DatePicker aprofechafin;
    @FXML private DatePicker fechainireqf;
    @FXML private DatePicker fechafinreqf;
    @FXML public TableView<requisicionesgen>  genreq;
	@FXML public TableColumn<requisicionesgen, String> gencsnsreq;
    @FXML public TableColumn<requisicionesgen, String> gensolreq; 
    @FXML public TableColumn<requisicionesgen, String> genareareq; 
    @FXML public TableColumn<requisicionesgen, String> gencargoreq; 
    @FXML public TableColumn<requisicionesgen, String> gencentroperacionreq; 
    @FXML public TableColumn<requisicionesgen, String> genfecsolreq;  
    @FXML public TableColumn<requisicionesgen, String> genfecaproreq; 
    @FXML public TableColumn<requisicionesgen, Integer> genitemapro;    
    @FXML public TableColumn<requisicionesgen, Integer> genitemnoapro;
    @FXML public TableColumn<requisicionesgen, String> genitemfecestado;
    @FXML public TableColumn<requisicionesgen, String> genitemestado;
    @FXML public Tab mireqtab;
	public Image capturamifirma;
	public Image capturamifirmadmin;
	public ImageView getimagecaptura;
	public String cargofiltrol;
	public String areafiltro;
	public String fechaini;
	public String ffin;
	public String h;
	public String capmidreq;
	public String capmicnsreq;
	public String miitem;
	public String micantidaditem;
	public Integer midataini;
	public String miiteem;
	public String fechainiapro;
	public String fechafinapro;
	public String Cargoapro;
	public String areapro;
	public String mifechainiapro;
	public String mifechafinapro;
	public String miCargoapro;
	public String miareapro;
	public Image firma;
	public String concecap;
    public Image Mifirma;
    public String finalcon;
    public Stage aprobacionStage;
    public Stage returnthisStage;
	public InputStream mifirma;
    public  String thisdate1;
    public Stage RStage;
    public JFXComboBox<String> thiscargo;
	public JFXComboBox<String> thisarea;
    public DatePicker fechai;
    public DatePicker fechaf;
    public TableView <Aprobacion> thistableview;
    public JFXComboBox<String> thisfcargo;
	public JFXComboBox<String> thisfarea;
    public DatePicker fechaif;
    public DatePicker fechaff;
    public TableView <requisicionesgen> thistableviewf;
    public JFXComboBox<String> thisfcargof;
	public JFXComboBox<String> thisfareaf;
    public DatePicker fechaiff;
    public DatePicker fechafff;
    public TableView <requisicionesgen> thistableviewff;
	public String micnsreq;
	public int i;
	public String midatafound;
	public  requisicionesgen data;
    public String thisol;
    public String getcnsreqrep;
	public String mifecha;
	public Stage getrepfinalstage;
	public DatePicker fechainicio;
	public DatePicker fechafin;
	public JFXComboBox<String> Cargo;
	public JFXComboBox<String> Area;
	public TableView <requisicionesgen> thistableviewfff;
	public String setfecha;
	Conexion conectar = new Conexion();
   //----------------------------fin declaracion variables--------------//
	
	public String getSetfecha() {
		return setfecha;
	}

	public void setSetfecha(String setfecha) {
		this.setfecha = setfecha;
	}

	public TableView<requisicionesgen> getThistableviewfff() {
		return thistableviewfff;
	}

	 public void setThistableviewfff(TableView<requisicionesgen> thistableviewfff) {
		this.thistableviewfff = thistableviewfff;
	}

	//-------------------------funciones que capturan datos de otros controladores---------//
	public DatePicker getFechainicio() {
		return fechainicio;
	}

	public DatePicker getFechafin() {
		return fechafin;
	}

	public JFXComboBox<String> getCargo() {
		return Cargo;
	}
	public JFXComboBox<String> getArea() {
		return Area;
	}

	public void setFechainicio(DatePicker fechainicio) {
		this.fechainicio = fechainicio;
	}

	public void setFechafin(DatePicker fechafin) {
		this.fechafin = fechafin;
	}

	public void setCargo(JFXComboBox<String> cargo) {
		Cargo = cargo;
	}

	public void setArea(JFXComboBox<String> area) {
		Area = area;
	}


	public Stage getGetrepfinalstage() {
		return getrepfinalstage;
	}

	public void setGetrepfinalstage(Stage getrepfinalstage) {
		this.getrepfinalstage = getrepfinalstage;
	}

	public String getGetcnsreqrep() {
		return getcnsreqrep;
	}

	public void setGetcnsreqrep(String getcnsreqrep) {
		this.getcnsreqrep = getcnsreqrep;
	}

	public JFXComboBox<String> getThisfcargof() {
		return thisfcargof;
	}

	public void setThisfcargof(JFXComboBox<String> thisfcargof) {
		this.thisfcargof = thisfcargof;
	}

	public JFXComboBox<String> getThisfareaf() {
		return thisfareaf;
	}

	public void setThisfareaf(JFXComboBox<String> thisfareaf) {
		this.thisfareaf = thisfareaf;
	}

	public DatePicker getFechaiff() {
		return fechaiff;
	}

	public void setFechaiff(DatePicker fechaiff) {
		this.fechaiff = fechaiff;
	}

	public DatePicker getFechafff() {
		return fechafff;
	}

	public void setFechafff(DatePicker fechafff) {
		this.fechafff = fechafff;
	}
	
    public JFXComboBox<String> getThisfcargo() {
		return thisfcargo;
	}

	public void setThisfcargo(JFXComboBox<String> thisfcargo) {
		this.thisfcargo = thisfcargo;
	}

	public JFXComboBox<String> getThisfarea() {
		return thisfarea;
	}

	public void setThisfarea(JFXComboBox<String> thisfarea) {
		this.thisfarea = thisfarea;
	}

	public DatePicker getFechaif() {
		return fechaif;
	}

	public void setFechaif(DatePicker fechaif) {
		this.fechaif = fechaif;
	}

	public DatePicker getFechaff() {
		return fechaff;
	}

	public void setFechaff(DatePicker fechaff) {
		this.fechaff = fechaff;
	}

	public TableView<requisicionesgen> getThistableviewf() {
		return thistableviewf;
	}

	public void setThistableviewf(TableView<requisicionesgen> thistableviewf) {
		this.thistableviewf = thistableviewf;
	}

    
    public TableView<Aprobacion> getThistableview() {
		return thistableview;
	}

	public void setThistableview(TableView<Aprobacion> thistableview) {
		this.thistableview = thistableview;
	}

	public JFXComboBox<String> getThiscargo() {
		return thiscargo;
	}

	public void setThiscargo(JFXComboBox<String> thiscargo) {
		this.thiscargo = thiscargo;
	}

	public JFXComboBox<String> getThisarea() {
		return thisarea;
	}

	public void setThisarea(JFXComboBox<String> thisarea) {
		this.thisarea = thisarea;
	}

	public DatePicker getFechai() {
		return fechai;
	}

	public DatePicker setFechai(DatePicker fechai) {
		return this.fechai = fechai;
	}

	public DatePicker getFechaf() {
		return fechaf;
	}

	public DatePicker setFechaf(DatePicker fechaf) {
		return this.fechaf = fechaf;
	}

	
	public Stage getRStage() {
		return RStage;
	}

	public void setRStage(Stage rStage) {
		RStage = rStage;
	}

	public Stage getAprobacionStage() {
		return aprobacionStage;
	}

	public Stage setAprobacionStage(Stage aprobacionStage) {
		return this.aprobacionStage = aprobacionStage;
	}
	
	public Stage getReturnthisStage() {
		return returnthisStage;
	}

	public void setReturnthisStage(Stage returnthisStage) {
		this.returnthisStage = returnthisStage;
	}

	
	public String getFinalcon() {
		return finalcon;
	}

	public void setFinalcon(String finalcon) {
		this.finalcon = finalcon;
	}

	public Image getMifirma() {
		return Mifirma;
	}

	public void setMifirma(Image mifirma) {
		Mifirma = mifirma;
	}
	
	
	public String getConcecap() {
		return concecap;
	}

	public void setConcecap(String concecap) {
		this.concecap = concecap;
	}
	public String getCapmicnsreq() {
		return capmicnsreq;
	}

	public void setCapmicnsreq(String capmicnsreq) {
		this.capmicnsreq = capmicnsreq;
	}

	public String getCapmidreq() {
		return capmidreq;
	}

	public void setCapmidreq(String capmidreq) {
		this.capmidreq = capmidreq;
	}
	
	
	public String capturalabel(String texto) {
		solreq.setText(texto);
		return texto;
    }

	public TableView<Requisiciones> getReqtable() {
		return reqtable;
	}
	
	public void setReqtable(TableView<Requisiciones> reqtable) {
		this.reqtable = reqtable;
	}

	public DatePicker getFechainifil() {
		return fechainifil;
	}

	public void setFechainifil(DatePicker fechainifil) {
		this.fechainifil = fechainifil;
	}
	public DatePicker getFechafinreqfil() {
		return fechafinreqfil;
	}

	public void setFechafinreqfil(DatePicker fechafinreqfil) {
		this.fechafinreqfil = fechafinreqfil;
	}

	public JFXComboBox<String> getCombocargo() {
		return combocargo;
   }

   public void setCombocargo(JFXComboBox<String> combocargo) {
		this.combocargo = combocargo;
   }

   public JFXComboBox<String> getcomboareaa() {
		return comboareaa;
   }

  public void setcomboareaa(JFXComboBox<String> comboareaa) {
		this.comboareaa = comboareaa;
  }

  //-------------------------fin declaracion de funciones------------------------//
  public void showdetails() {
	  vdetalles.setOnMouseClicked(e->{
		    Stage detallesStage=new Stage();
		    FXMLLoader cargadetalles = new FXMLLoader(getClass().getResource("TablaItemsDetalle.fxml"));
			try {
				Parent StackPane = (Parent) cargadetalles.load();
				Scene scene = new Scene(StackPane);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				detallesStage.setScene(scene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			detallesStage.setTitle("Detalle De Items");
			detallesStage.show();
			detallesStage.setMaximized(true);
			detallesStage.focusedProperty().addListener(new ChangeListener<Boolean>()
			{
			  @Override
			  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			  {
			    if(newValue == false) {
			    	vdetalles.setDisable(true);
			  }
			  }
			});
			
			detallesStage.showingProperty().addListener(new ChangeListener<Boolean>()
			{
			  @Override
			  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			  {
			    if(newValue == false) {
			    	vdetalles.setDisable(false);
			   }
			  }
			});
	  });
  }
  //-------------------funcion que carga el boton de inicio (pantalla principal)---------//
	public void inicio() throws IOException {
		    Stage administrador=new Stage();
		    FXMLLoader carga = new FXMLLoader(getClass().getResource("Admin.fxml"));
		    Parent StackPane =(Parent) carga.load();
		    AdminScreenController loadl = carga.<AdminScreenController>getController();
		    String pasadato=iduser.getText().toString();
		    loadl.UserScreen.setText(pasadato);
		  //--------valido si el usuario que se loguea es administrador o no para levantar permisos
		    
			  if((AdminScreenController.getCapdata().equals("ADMINISTRADORREV"))|| (AdminScreenController.getCapdata().equals("ADMINISTRADORREQ"))){
		    		loadl.btnimg5.setDisable(false);
		    		loadl.useritem.setDisable(false);
		    	}
			  else  {
		    		loadl.btnimg5.setDisable(true);
		    		loadl.btnimg5.setStyle("-fx-opacity:0.65;");
		    		loadl.useritem.setDisable(true);
		       }
		 //-----------------------fin validacion---//
		   
		   //-----------------------------hover listener para los botones en la pantalla principal----//
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
	  //----------------------------fin del listener-----------------------//
		    Scene scene = new Scene(StackPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			administrador.setScene(scene);
			administrador.setTitle("AdminScreen");
			Stage RequisionesView=(Stage)vboxreq.getScene().getWindow();
			RequisionesView.hide();
			administrador.show();
			administrador.setMaximized(true);
          }
	//--------------------funcion para el css de los textfields----------------//
	public void setestilostextfield() {
		  solreq.setDisable(true);
		  solreq.setStyle("-fx-background-color:rgb(252,207,224); -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		  centroop.setDisable(true);
		  centroop.setStyle("-fx-background-color:rgb(252,207,224); -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		  areauser.setDisable(true);
		  areauser.setStyle("-fx-background-color:rgb(252,207,224); -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		  midreq.setDisable(true);
		  midreq.setStyle("-fx-background-color:rgb(252,207,224); -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		  cargouser.setDisable(true);
		  cargouser.setStyle("-fx-background-color:rgb(252,207,224); -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
	      cantidaditem.setStyle("-fx-background-color: rgb(218, 242, 220);-fx-border-color:#99cc99;-fx-font-weight: bold; -fx-font-family: 'Oswald Regular';-fx-font-size: 16px; -fx-text-fill:black;");
	      descripcionitem.setStyle("-fx-background-color: rgb(218, 242, 220);-fx-border-color:#99cc99;-fx-font-weight: bold; -fx-font-family: 'Oswald Regular';-fx-font-size: 16px; -fx-text-fill:black;");
	     }
	
        //----------------------fin funcion--------------------//
	
	
	public void llenacombo() {
	comboareaa.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
	combocargo.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
	aproreqcargo.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
	aproareareq.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
	cargoreqfiltro.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
	areareqfiltro.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;");
	comboareaa.getItems().addAll("Sin Dato","Sistemas", "Cartera", "Comercial", "Gerencia", "Farmacia", "Calidad", "Mantenimiento","Administrativa");
	combocargo.getItems().addAll("Sin Dato","Auxiliar De Sistemas","Coordinador De Sistemas","Auxiliar De Farmacia","Auxiliar De Compras","Auxiliar Administrativa");
	aproreqcargo.getItems().addAll("Sin Dato","Auxiliar De Sistemas","Coordinador De Sistemas","Auxiliar De Farmacia","Auxiliar De Compras","Auxiliar Administrativa");
	aproareareq.getItems().addAll("Sin Dato","Sistemas", "Cartera", "Comercial", "Gerencia", "Farmacia", "Calidad", "Mantenimiento","Administrativa");
	areareqfiltro.getItems().addAll("Sin Dato","Sistemas", "Cartera", "Comercial", "Gerencia", "Farmacia", "Calidad", "Mantenimiento","Administrativa");
	cargoreqfiltro.getItems().addAll("Sin Dato","Auxiliar De Sistemas","Coordinador De Sistemas","Auxiliar De Farmacia","Auxiliar De Compras","Auxiliar Administrativa");
	comboareaa.getSelectionModel().selectFirst();
	combocargo.getSelectionModel().selectFirst();
	aproreqcargo.getSelectionModel().selectFirst();
	aproareareq.getSelectionModel().selectFirst();
	areareqfiltro.getSelectionModel().selectFirst();
	cargoreqfiltro.getSelectionModel().selectFirst();
	}
	
	       public void insertarequisicion() {
	    	   ObservableList<item> items = titem.getItems();
	    	   if(items.isEmpty()) {
	    		   Mensaje mensajedata = new Mensaje();
				   mensajedata.mensajedata(titem, stpanerequi);
	    	   }
	    	     else {
	    		    String sol=solreq.getText().toString();
		    		String area=areauser.getText().toString();
		    		String cargo=cargouser.getText().toString();
		    		String miceduladata=midreq.getText().toString();
		    		String centro = centroop.getText().toString();
	    	    try {
	    	  	  for(item item :titem.getItems()) {
		    		  midataini=item.getCantidad();
		    		  miiteem= item.getItem();
		    		  try {
		    	    		String Queryinsertitem="INSERT INTO ITEMSREQ (CANTIDAD, ITEM,CARGO, CENTRO_OPERACION, CEDULA, FECHA_SOLICITUD)VALUES( ? , ? , ? , ? , ?, GETDATE() )";
		    	    		Connection ConexionData = null;
		    	    		ConexionData=conectar.miconexion(ConexionData);
		    	    		PreparedStatement creadatoitem = ConexionData.prepareStatement(Queryinsertitem);
		    	    		creadatoitem.setInt(1, midataini);
		    	    		creadatoitem.setString(2, miiteem);
		    	    		creadatoitem.setString(3, cargo);
		    	    		creadatoitem.setString(4, centro);
		    	    		creadatoitem.setString(5, miceduladata);
		    	    		creadatoitem.executeUpdate();
		    	    	}catch(SQLException ex) {
		    	 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
		    	    	}
		    	  }	
	    	
	    		String Queryreq="INSERT INTO REQUISICIONES (SOLICITANTE, CEDULA,AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD)VALUES('"+sol+"','"+miceduladata+"','"+area+"','"+cargo+"','"+centro+"',GETDATE())";
	    		Connection ConexionD = null;
	    		ConexionD=conectar.miconexion(ConexionD);
		       	Statement creareq =ConexionD.createStatement();
		       	creareq.executeUpdate(Queryreq);
		       	Mensaje data = new Mensaje();
		       	data.Reqmsj(stpanerequi);
	       }catch(SQLException nn) {
	    	   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn);
	       }
	       }
	       }
	       
	       public TableView<Requisiciones> selecciondedatosreq() {
	    	 
	    	    ObservableList<Requisiciones> datostablarequisiciones= FXCollections.observableArrayList();
	   	   		String Query= "SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'  END) ) AS REVISION,(CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO, CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES";
	   	   		Connection Conexiontabla = null;
	   	       	try {
	   	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	   	   	       	ResultSet rs = ps.executeQuery();
	   	   	        while(rs.next()) {
	   	   	        	datostablarequisiciones.add(new Requisiciones(
	   	   	        			 rs.getString("REVISION"),
	   	   	        		     rs.getString("APROBACION"),
	   	   	        		     rs.getInt("ID"),
	   	                   		 rs.getString("CNSREQ"),
	   	                   		 rs.getString("SOLICITANTE"),
	   	                   		 rs.getString("AREA"),
	   	                   		 rs.getString("CARGO"),
	   	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
	   	                   	     rs.getString("CENTRO_OPERACION")
	   	                   		 )
	   	                         );
	   	   	        reqtable.setItems(datostablarequisiciones);
	        	    TableFilter<Requisiciones> tableFilter = new TableFilter<>(reqtable);
	        	    tableFilter.filterColumn(revisionreqcol);  
	        	    tableFilter.filterColumn(idreque); 
	        	    tableFilter.filterColumn(aprobacionreqcol);
	        	    tableFilter.filterColumn(consecutivoReque);
	        	    tableFilter.filterColumn(SolicitanteReque);
	        	    tableFilter.filterColumn(AreaReque);
	        	    tableFilter.filterColumn(CargoReque);
	        	    tableFilter.filterColumn(FechaSolReque);
	        	    tableFilter.filterColumn(coperacion);
	   	   			 }
	   	       	}catch(SQLException ee) {
	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	   	       	}
	   	       
				return reqtable;
	    	   }  
	       
	       public TableView<requisicionesgen> selecciondeitemsaprobados() {
	    	    ObservableList<requisicionesgen> itemsaprobados= FXCollections.observableArrayList();
	   	   		String Query= "SELECT  \r\n" + 
	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION',MIDATA.SOLICITANTE AS 'SOLICITANTE', MIDATA.AREA AS 'AREA', MIDATA.CARGO AS 'CARGO', MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION , MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD , MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS ITEMS_APROBADOS, COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" + 
	   	   		     	"                              WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
	   	   		     	"							  WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" + 
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
	   	   				"	  ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
	   	   		Connection Conexiontabla = null;
	   	       	try {
	   	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	   	   	       	ResultSet rs = ps.executeQuery();
	   	   	        while(rs.next()) {
	   	   	         itemsaprobados.add(new requisicionesgen(
	   	   	        			 rs.getString("CONSECUTIVO REQUISICION"),
	   	   	        		     rs.getString("SOLICITANTE"),
	   	   	        		     rs.getString("AREA"),
	   	                   		 rs.getString("CARGO"),
	   	                      	 rs.getString("CENTRO_OPERACION"),
	   	                   		 rs.getString("FECHA_SOLICITUD"),
	   	                   	     rs.getString("FECHA_APROBACION"),
	   	                   		 rs.getInt("ITEMS_APROBADOS"),
	   	                   		 rs.getInt("ITEMS NO APROBADOS"),
	   	                         rs.getString("FECHA_ENTREGA"),
	   	                         rs.getString("ESTADO_ITEMS")
	   	                   		 )
	   	                         );
	   	   	        genreq.setItems(itemsaprobados);
	        	    TableFilter<requisicionesgen> tableFilter = new TableFilter<>(genreq);
	        	    tableFilter.filterColumn(gencsnsreq);  
	        	    tableFilter.filterColumn(gensolreq); 
	        	    tableFilter.filterColumn(genareareq);
	        	    tableFilter.filterColumn(gencargoreq);
	        	    tableFilter.filterColumn(genfecsolreq);
	        	    tableFilter.filterColumn(genfecaproreq);
	        	    tableFilter.filterColumn(genitemapro);
	        	    tableFilter.filterColumn(genitemnoapro);
	        	    tableFilter.filterColumn(genitemfecestado);
	        	    tableFilter.filterColumn(genitemestado);
	        	    tableFilter.filterColumn(gencentroperacionreq);
	        	    
	   	   			 }
	   	       	}catch(SQLException ee) {
	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	   	       	}
				return genreq;
	    	   }  
	      
	       
	       
	       public void insertadatositems() {
	    	agregaritem.setOnMouseClicked(e->{
	    		String caracteres=descripcionitem.getText().toString();
		   		  final String regex = "^[a-zA-Z[.][_][-][\\s]]+";
		   		  final String cadena = cantidaditem.getText().toString();
		   		  final Pattern expresion = Pattern.compile(regex, Pattern.MULTILINE);
		   		  final Matcher matcher = expresion.matcher(cadena);
		   		 if ((matcher.find())||cantidaditem.getText().trim().isEmpty()) {
		   			cantidaditem.setStyle("-fx-background-color:rgb(221, 91, 66);-fx-border-color:rgb(221, 91, 66);");
		   		    Mensaje estemensaje = new Mensaje();
		   		    estemensaje.Mensajetextfield(stpanerequi,cantidaditem);
				       descripcionitem.clear();
				       cantidaditem.clear();   
		   		       }
		   		 else {
	   	    miitem=descripcionitem.getText().toString();
	   	    micantidaditem=cantidaditem.getText().toString();
	   	    try {
	   	    int items = Integer.parseInt(micantidaditem);
	   		   	   item itemss = new item(miitem,items);
	   		       titem.getItems().addAll(itemss);
	   		       if( titem.getItems().size()==12) {
	   		    	  agregaritem.setDisable(true);
	   		       }
	   		    
				@SuppressWarnings("unused")
				int conteochar=0;
				for(int i=0; i<caracteres.length();i++){
					conteochar=caracteres.length();
					conteochar++;
				}
		   		 }catch(NumberFormatException nn) {
		   			 Mensaje error = new Mensaje();
		   			 error.Mensajetextfield(stpanerequi, cantidaditem);
		   			cantidaditem.setStyle("-fx-background-color:rgb(221, 91, 66);-fx-border-color:rgb(221, 91, 66);");
		   		 }
		   		   descripcionitem.clear();
			       cantidaditem.clear();   
		   		 }
	    	   }); 
	         }    
	       
	       
	     
	      public void eliminadatostabla() {
	    	  titem.setOnMouseClicked(e->{
	    		 titem.getItems().removeAll(titem.getSelectionModel().getSelectedItem());
	    		 if( titem.getItems().size()!=12) {
	   		    	  agregaritem.setDisable(false);
	   		       }
	    	  });
	      }
	      
	
	      public void restriccionconteo() {
	    	  descripcionitem.setOnKeyPressed(e->{
	    	  if(descripcionitem.getText().length()==30) {
	  				descripcionitem.setDisable(false);
	  				 cantidaditem.setDisable(false);
	  			}
	  			if (descripcionitem.getText().length()>30){
	  				descripcionitem.setDisable(true);
	  				cantidaditem.setDisable(true);
	  				descripcionitem.setStyle("-fx-background-color:rgb(221, 91, 66);-fx-border-color:rgb(221, 91, 66);");
	  				Mensaje errorm = new Mensaje();
	  				errorm.deshabilitacampo(stpanerequi, descripcionitem, cantidaditem);
	  			}	
	  		});
	  	}
	       public TableView<Aprobacion> selecciondedatosreqdt() {
	    	    ObservableList<Aprobacion> datostablarequisicionesdt= FXCollections.observableArrayList();
	   	   		String Query= "SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO, CENTRO_OPERACION, FECHA_SOLICITUD,  CNSREQ FROM REQUISICIONESDT";
	   	   		Connection Conexiontabla = null;
	   	       	try {
	   	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	   	   	       	ResultSet rs = ps.executeQuery();
	   	   	        while(rs.next()) {
	   	   	        	datostablarequisicionesdt.add(new Aprobacion(
	   	   	        		    rs.getString("ESTADO"),
	   	   	        		    rs.getString("SOLICITANTE"),
	   	   	       		        rs.getString("AREA"),
	                   		    rs.getString("CARGO"),
	                   		    rs.getString("CENTRO_OPERACION"),
	                   		    rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
   	                   	        rs.getString("CNSREQ")
	   	                   		 )
	   	                         );
	   	   	      reqdt.setItems(datostablarequisicionesdt);
	     	      TableFilter<Aprobacion> tableFilter = new TableFilter<>(reqdt);
		     	    tableFilter.filterColumn(restadorqdt);
		     	    tableFilter.filterColumn(rsolicitanterqdt);
		     	    tableFilter.filterColumn(rarearqdt);
		     	    tableFilter.filterColumn(rcargorqdt);
		     	    tableFilter.filterColumn(rfechasrqdt);
		     	    tableFilter.filterColumn(rconcecutivorqdt); 
		     	    tableFilter.filterColumn(rcentrorqt); 
	   	   			}
	   	       	}catch(SQLException ee) {
	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	   	       	}
				return reqdt;
	    	   }  

public TableView<Requisiciones> filtradodatos() {
	    	   filtroreq.setOnMouseClicked(e->{
	    		
	    		   //--------------------------captura variables------------------------------------------------------//
	    		        areafiltro=comboareaa.getSelectionModel().getSelectedItem();
	    			    fechaini=((TextField)fechainifil.getEditor()).getText();
	    	    		ffin=((TextField)fechafinreqfil.getEditor()).getText();
	    	    	    cargofiltrol=combocargo.getSelectionModel().getSelectedItem();
	    		   //------------------------------------bloque if---------------------------------------------------//
	    	    	     if(((TextField)fechainifil.getEditor()).getText().isEmpty()&&((TextField)fechafinreqfil.getEditor()).getText().isEmpty()) {
			   				Mensaje datat = new Mensaje();
			   				datat.Mensajefechas(stpanerequi, fechainifil, fechafinreqfil);
			   			   } 	    
	    	    	     else {   
	    	    	    try { 
	    		   if(combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&comboareaa.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainifil.getEditor()).getText().isEmpty()&&!((TextField)fechafinreqfil.getEditor()).getText().isEmpty())
	    		   {      Connection Conexiontablarequi=null;
	    	    		  try {
	    	    			    
		  	    	    		ObservableList<Requisiciones> Datostablarequisicionesfechas= FXCollections.observableArrayList();
		  	    	    		String QueryFiltrof="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'  END) ) AS REVISION, (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  AS APROBACION, ID, CNSREQ,SOLICITANTE,AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD  FROM REQUISICIONES  WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ?" ;
		  	    	    		Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
		  	    				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltrof);
		  	    				ps.setString(1, fechaini);
		  	    				ps.setString(2, ffin);
		  	    		     	ResultSet rs = ps.executeQuery();
		  	    		        while(rs.next()) {
		  	    		        	Datostablarequisicionesfechas.add(new Requisiciones(
		  	    		        			 rs.getString("REVISION"),
		  	    		        			 rs.getString("APROBACION"),
		  	    		        			 rs.getInt("ID"),
		  	    		        			 rs.getString("CNSREQ"),
		  		   	                   		 rs.getString("SOLICITANTE"),
		  		   	                   		 rs.getString("AREA"),
		  		   	                   		 rs.getString("CARGO"),
		  		   	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
		  		   	                         rs.getString("CENTRO_OPERACION")
		  	    	                		 )
		  	    	                         );
		  	    				             }
		  	    		      reqtable.setItems(Datostablarequisicionesfechas);
		    	      }catch(SQLException mm) {
		    	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
		    		}
	    		     }
	    	    	//-------------------------------------------------fin bloque if------------------------------//
	    		   
	    		   //---------------------------------------------primer bloque else if---------------------------------------------------------------------------------//
	    		   else if(combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainifil.getEditor()).getText().isEmpty()&&!((TextField)fechafinreqfil.getEditor()).getText().isEmpty()) {
	    			         Connection Conexiontablarequi=null;
	  	    	    		ObservableList<Requisiciones> Datostablarequisicionesfechassinglemodel= FXCollections.observableArrayList();
	  	    	    		String QueryFiltroff="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'  END) ) AS REVISION, (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  AS APROBACION, ID, CNSREQ,SOLICITANTE,AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD   FROM REQUISICIONES  WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND AREA= ?" ;
	  	    	    		try {
		  	    		    	Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
		  	    				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltroff);
		  	    				ps.setString(1, fechaini);
		  	    				ps.setString(2, ffin);
		  	    				ps.setString(3, areafiltro);
		  	    		     	ResultSet rs = ps.executeQuery();
		  	    		        while(rs.next()) {
		  	    		        	Datostablarequisicionesfechassinglemodel.add(new Requisiciones(
		  	    		        			 rs.getString("REVISION"),
		  	    		        			 rs.getString("APROBACION"),
		  	    		        			 rs.getInt("ID"),
		  	    		        			 rs.getString("CNSREQ"),
		  		   	                   		 rs.getString("SOLICITANTE"),
		  		   	                   		 rs.getString("AREA"),
		  		   	                   		 rs.getString("CARGO"),
		  		   	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
		  		   	                   	     rs.getString("CENTRO_OPERACION")
		  	    	                		 )
		  	    	                         );
		  	    				             }
		  	    		      reqtable.setItems(Datostablarequisicionesfechassinglemodel);
		    	      }catch(SQLException mm) {   
		    	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
		    		   } 
	    		   }
	    		   //-----------------------------------------------------fin primer bloque else if----------------------------------------------//  
	    	   
	    		   //-----------------------------------------------------------inicio segundo bloque else if-------------------------------------//
	    		   else if(comboareaa.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainifil.getEditor()).getText().isEmpty()&&!((TextField)fechafinreqfil.getEditor()).getText().isEmpty()) {  
 	    	    		ObservableList<Requisiciones> Datostablarequisicionesfechassingle= FXCollections.observableArrayList();
 	    	    		String QueryFiltrof="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'  END) ) AS REVISION, (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  AS APROBACION, ID, CNSREQ,SOLICITANTE,AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD  FROM REQUISICIONES  WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO= ?" ;
 	    	    		 Connection Conexiontablarequi=null;
 	    	    		try {
 	    		    	 Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
 	    				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltrof);
 	    				ps.setString(1, fechaini);
 	    				ps.setString(2, ffin);
 	    				ps.setString(3, cargofiltrol);
 	    		     	ResultSet rs = ps.executeQuery();
 	    		        while(rs.next()) {
 	    		        	Datostablarequisicionesfechassingle.add(new Requisiciones(
 	    		        			 rs.getString("REVISION"),
 	    		        			 rs.getString("APROBACION"),
 	    		        			 rs.getInt("ID"),
 	    		        			 rs.getString("CNSREQ"),
 		   	                   		 rs.getString("SOLICITANTE"),
 		   	                   		 rs.getString("AREA"),
 		   	                   		 rs.getString("CARGO"),
 		   	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
 		   	                         rs.getString("CENTRO_OPERACION")
 	    	                		 )
 	    	                         );
 	    				             }
 	    		      reqtable.setItems(Datostablarequisicionesfechassingle);
   	      }catch(SQLException mm) {   
   	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
   		   } 
 	    	    		
   		   }
	       //---------------------------------------------fin segundo bloque else if---------------------------------------------//		   
	    		   
	    		   //------------------------------------------------------inicio bloque else---------------------------------------------//
	    		else {
	    			Connection Conexiontablarequi=null;
	    	    try {
	    		ObservableList<Requisiciones> Datostablarequisicionesf= FXCollections.observableArrayList();
   	    		String QueryFiltro="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'  END) ) AS REVISION, (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  AS APROBACION, ID, CNSREQ,SOLICITANTE,AREA,CARGO, CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES WHERE CONVERT(DATE,FECHA_SOLICITUD,103) >= ?   AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO LIKE ? AND AREA LIKE ?" ;
   	    		Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
   				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltro);
   				ps.setString(1, fechaini);
   				ps.setString(2, ffin);
   		        ps.setString(3,  '%'+cargofiltrol+'%');
   		        ps.setString(4,  '%'+areafiltro+'%');
   		     	ResultSet rs = ps.executeQuery();
   		        while(rs.next()) {
   		        	Datostablarequisicionesf.add(new Requisiciones(
   		        			     rs.getString("REVISION"),
   		        			     rs.getString("APROBACION"),
   		        			     rs.getInt("ID"),
   		        			     rs.getString("CNSREQ"),
	   	                   		 rs.getString("SOLICITANTE"),
	   	                   		 rs.getString("AREA"),
	   	                   		 rs.getString("CARGO"),
	   	                   		 rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
	   	                   	     rs.getString("CENTRO_OPERACION")
   	                		 )
   	                         );
   				           }
   		        reqtable.setItems(Datostablarequisicionesf);
	    	   }catch(SQLException mm) {
	    		   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
	    		}
	    	   }
	    	   }catch(NullPointerException nn) {
	    		   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn);    	 
	    	   }
	    	   }
	    		 //--------fin  bloque  else--------------------------------------------------//
	    	   });
			return reqtable;
	       }//-------------fin funcion-------//
	       


                public TableView<Aprobacion> filtradodatosapro() {
                	aplicareqapro.setOnMouseClicked(e->{
                		//---------------------captura variables-----------------------//
                	     fechainiapro=((TextField)aprofechaini.getEditor()).getText();
                		 fechafinapro=((TextField)aprofechafin.getEditor()).getText();
                		 Cargoapro=aproreqcargo.getSelectionModel().getSelectedItem();
                		 areapro=aproareareq.getSelectionModel().getSelectedItem();
                		//-------------------------------------------------------------//
                		 
                		 //-----------------------------------------------------bloque if - validacion de datos vacios-------------------------------------------//
                		  if(((TextField)aprofechaini.getEditor()).getText().isEmpty()&&((TextField)aprofechafin.getEditor()).getText().isEmpty()) {
                			Mensaje datat = new Mensaje();
  			   				datat.Mensajefechas(stpanerequi, aprofechaini, aprofechafin);
  			   			   } 
                		  
                		  //----------------------------------------------------------------------------------------------------------------------//
                	
                		  //------------bloque else------------------------------------------------------------------------------------------------//
                		  else {   
      	    	    	    try {
      	    	    	    //------------------------------------------------primer bloque if------------------------------------------------------------//
      	    		   if(aproreqcargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&aproareareq.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)aprofechaini.getEditor()).getText().isEmpty()&&!((TextField)aprofechafin.getEditor()).getText().isEmpty())
      	    		   {
      	    			   Connection Conexiontablarequi=null; 
      	    			   try {
      		  	    	    		ObservableList<Aprobacion> Datostablaproreqfechas= FXCollections.observableArrayList();
      		  	    	    		String QueryFiltrof="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ?" ;
      		  	    	    		Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
      		  	    				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltrof);
      		  	    				ps.setString(1, fechainiapro);
      		  	    				ps.setString(2, fechafinapro);
      		  	    		     	ResultSet rs = ps.executeQuery();
      		  	    		        while(rs.next()) {
      		  	    		        Datostablaproreqfechas.add(new Aprobacion(
      		  	    		        		rs.getString("ESTADO"),
      			   	   	        		    rs.getString("SOLICITANTE"),
      			   	   	       		        rs.getString("AREA"),
      			                   		    rs.getString("CARGO"),
      			                   		    rs.getString("CENTRO_OPERACION"),
      			                   		    rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
      		   	                   	        rs.getString("CNSREQ")
      		  	    	                		 )
      		  	    	                         );
      		  	    				             }
      		  	    		      reqdt.setItems(Datostablaproreqfechas);
      		    	      }catch(SQLException mm) {
      		    	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
      		    		}
      	    		     }
      	    		   
      	    		   //---------------------------------------------fin bloque if ------------------------------------------------------------------------------------------------------------//
                	
      	    		   //------------------------------------------primer bloque if else--------------------------------------------------------------------------------------------------------//
      	    		  else if(aproreqcargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)aprofechaini.getEditor()).getText().isEmpty()&&!((TextField)aprofechafin.getEditor()).getText().isEmpty()) {
	  	    	    		ObservableList<Aprobacion> Datostablarequisicionesaprofechassinglemodel= FXCollections.observableArrayList();
	  	    	    	     Connection Conexiontablarequi=null; 
	  	    	    		String QueryFiltroff="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND AREA = ?" ;
	  	    	    		try {
		  	    		        Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
		  	    				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltroff);
		  	    				ps.setString(1, fechainiapro);
		  	    				ps.setString(2, fechafinapro);
		  	    				ps.setString(3, areapro);
		  	    		     	ResultSet rs = ps.executeQuery();
		  	    		        while(rs.next()) {
		  	    		        	Datostablarequisicionesaprofechassinglemodel.add(new Aprobacion(
		  	    		        			rs.getString("ESTADO"),
      			   	   	        		    rs.getString("SOLICITANTE"),
      			   	   	       		        rs.getString("AREA"),
      			                   		    rs.getString("CARGO"),
      			                   		    rs.getString("CENTRO_OPERACION"),
      			                   		    rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
      		   	                   	        rs.getString("CNSREQ")
		  	    	                		 )
		  	    	                         );
		  	    				             }
		  	    		      reqdt.setItems(Datostablarequisicionesaprofechassinglemodel);
		    	      }catch(SQLException mm) {   
		    	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
		    		   } 
	    		   }
      	    		   //-----------------------------------------fin primer bloque if else -----------------------------------------------------------------------------------------------------//
      	    		   
      	    		   //------------------------------------------inicio segundo bloque if else-------------------------------------------------------------------------------------------------//
      	    		   
      	 		   else if(aproareareq.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)aprofechaini.getEditor()).getText().isEmpty()&&!((TextField)aprofechafin.getEditor()).getText().isEmpty()) {  
	    	    		ObservableList<Aprobacion> Datostablarequisicionesaprofechasmisingle= FXCollections.observableArrayList();
	    	    		Connection Conexiontablarequi=null; 
	    	    		String QueryFiltrof="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO = ? " ;
	    	    		try {
	    	    		Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
	    				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltrof);
	    				ps.setString(1, fechainiapro);
	    				ps.setString(2, fechafinapro);
	    				ps.setString(3, Cargoapro);
	    		     	ResultSet rs = ps.executeQuery();
	    		        while(rs.next()) {
	    		        	Datostablarequisicionesaprofechasmisingle.add(new Aprobacion(
	    		        			    rs.getString("ESTADO"),
			   	   	        		    rs.getString("SOLICITANTE"),
			   	   	       		        rs.getString("AREA"),
			                   		    rs.getString("CARGO"),
			                   		     rs.getString("CENTRO_OPERACION"),
			                   		    rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
		   	                   	        rs.getString("CNSREQ")
	    	                		 )
	    	                         );
	    				             }
	    		      reqdt.setItems(Datostablarequisicionesaprofechasmisingle);
  	      }catch(SQLException mm) {   
  	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
  		   } 
	    	    		
  		   }
      	  //-----------------------------------------------------------------------fin segundo bloque if else ------------------------------------------------------------------------------------------------//
      	   
      	   //-------------------------------------------------------------------bloque else-------------------------------------------------------------------------------------------------------------------//
      	 		else {
    	    	    try {
    	    		ObservableList<Aprobacion> Datostablarequisicionesaprof= FXCollections.observableArrayList();
    	    		Connection Conexiontablarequi=null; 
       	    		String QueryFiltro="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO LIKE ? AND AREA LIKE ?" ;
       	    		Conexiontablarequi = conectar.miconexion(Conexiontablarequi);
       				PreparedStatement ps =Conexiontablarequi.prepareStatement(QueryFiltro);
       				ps.setString(1, fechainiapro);
       				ps.setString(2, fechafinapro);
       		        ps.setString(3, '%'+Cargoapro+'%');
       		        ps.setString(4, '%'+areapro+'%');
       		     	ResultSet rs = ps.executeQuery();
       		        while(rs.next()) {
       		        	Datostablarequisicionesaprof.add(new Aprobacion(
       		        			rs.getString("ESTADO"),
	   	   	        		    rs.getString("SOLICITANTE"),
	   	   	       		        rs.getString("AREA"),
	                   		    rs.getString("CARGO"),
	                   		    rs.getString("CENTRO_OPERACION"),
	                   		    rs.getTimestamp("FECHA_SOLICITUD").toLocalDateTime(),
   	                   	        rs.getString("CNSREQ")
       	                		 )
       	                         );
       				           }
       		        reqdt.setItems(Datostablarequisicionesaprof);
    	    	   }catch(SQLException mm) {
    	    		   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
    	    		}
    	    	   }	   
      	   //--------------------------------------------------------------------fin bloque else-------------------------------------------------------------------------------------------------------------//
      	    }catch(NullPointerException nn) {
           	   	   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn); 
      	     }
      	    }
            });
          return reqdt;
             }
             
                public TableView<requisicionesgen> filtrodedatosaprobados() {
                	aplicarfreqapro.setOnMouseClicked(e->{
                		//---------------------captura variables-----------------------//
               	     mifechainiapro=((TextField)fechainireqf.getEditor()).getText();
               		 mifechafinapro=((TextField)fechafinreqf.getEditor()).getText();
               		 miCargoapro=cargoreqfiltro.getSelectionModel().getSelectedItem();
               		 miareapro=areareqfiltro.getSelectionModel().getSelectedItem();
               		//-------------------------------------------------------------//
               		 if(((TextField)fechainireqf.getEditor()).getText().isEmpty()&&((TextField)fechafinreqf.getEditor()).getText().isEmpty()) {
               		 Mensaje fecha = new Mensaje();
               		 fecha.Mensajefechas(stpanerequi, fechainireqf,fechafinreqf);
               		 }
               	  //----------------------------------------------------------------------------------------------------------------------//
                 	
           		  //------------bloque else------------------------------------------------------------------------------------------------//
           		  else {   
 	    	    	    try {
 	    	    	    //------------------------------------------------primer bloque if------------------------------------------------------------//
 	    	    	       if(cargoreqfiltro.getSelectionModel().getSelectedItem().equals("Sin Dato")&&areareqfiltro.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainireqf.getEditor()).getText().isEmpty()&&!((TextField)fechafinreqf.getEditor()).getText().isEmpty())
 	      	    		   {
 	    	    	    	    ObservableList<requisicionesgen> itemsaprobados= FXCollections.observableArrayList();
 	    	   	   	   		    String Query= "SELECT  \r\n" + 
 	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION  ,MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
 	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
 	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
 	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
 	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" + 
 	    	   	   	   		        "                              WHEN  MIDATA.[ESTADO DE ITEMS]=2 THEN 'REQUISICION RECIBIDA'\r\n" + 
 	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
 	    	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
 	    	   	   	   		        "							  WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" + 
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
 	    	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? \r\n" + 
 	    	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
 	    	   	   	   		Connection Conexiontabla = null;
 	    	   	   	       	try {
 	    	   	   	       		Conexiontabla=conectar.miconexion(Conexiontabla);
 	    	   	   	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
 	    	   	   	         	ps.setString(1, mifechainiapro);
	  	    				    ps.setString(2, mifechafinapro);
 	    	   	   	   	       	ResultSet rs = ps.executeQuery();
 	    	   	   	   	        while(rs.next()) {
 	    	   	   	   	        itemsaprobados.add(new requisicionesgen(
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
 	    	   	   	                        ) );
 	    	   	   	   	        genreq.setItems(itemsaprobados);
 	    	 	    	   	   	   			 }
 	    	   	   	       	}catch(SQLException ee) {
 	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
 	    	   	   	       	} 
 	      	    		   }
 	    	    	    //---------------------------------fin bloque if----------------------------------------------------------------------//
 	    	    	       
 	    	    	       //----------------------inicio bloque else if-------------------------------------------------------------------------//
 	    	    		  else if(cargoreqfiltro.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainireqf.getEditor()).getText().isEmpty()&&!((TextField)fechafinreqf.getEditor()).getText().isEmpty()) {
 	    	    			ObservableList<requisicionesgen> itemsaprobadosA= FXCollections.observableArrayList();
  	    	   	   	   		String Query= "SELECT  \r\n" + 
  	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION, MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
  	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
  	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
  	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
  	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" +
  	    	   	   	   		        "                               WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
  	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
  	    	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
  	    	   	   	   		        "							  WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" +
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
  	    	   	   	   		Connection Conexiontabla = null;
  	    	   	   	       	try {
  	    	   	   	       		Conexiontabla=conectar.miconexion(Conexiontabla);
  	    	   	   	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
  	    	   	   	         	ps.setString(1, mifechainiapro);
 	  	    				    ps.setString(2, mifechafinapro);
 	  	    					ps.setString(3, miareapro);
  	    	   	   	   	       	ResultSet rs = ps.executeQuery();
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
  	    	   	   	   	        genreq.setItems(itemsaprobadosA);
  	    	 	    	   	   	   			 }
  	    	   	   	       	}catch(SQLException ee) {
  	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
  	    	   	   	       	} 
 	    	    		  }
 	    	    	       //---------------------------fin bloque else if------------------------------------------------------------------------//
 	    	    	       
 	    	    	       //----------------------------------------------inicio bloque else if--------------------------------------------------//
 	    	    		  else if(areareqfiltro.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainireqf.getEditor()).getText().isEmpty()&&!((TextField)fechafinreqf.getEditor()).getText().isEmpty()) {  
 	    	    				ObservableList<requisicionesgen> itemsaprobadosB= FXCollections.observableArrayList();
 	  	    	   	   	   		String Query= "SELECT  \r\n" + 
 	  	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION, MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
 	  	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
 	  	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
 	  	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
 	  	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" + 
 	  	    	   	   	   	            "                              WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
 	  	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS] =1 THEN 'REQUISICION TRAMITADA'\r\n" + 
 	  	    	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
 	  	    	   	   	   	            "							  WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" +
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
 	  	    	   	   	   		Connection Conexiontabla = null;
 	  	    	   	   	       	try {
 	  	    	   	   	       		Conexiontabla=conectar.miconexion(Conexiontabla);
 	  	    	   	   	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
 	  	    	   	   	         	ps.setString(1, mifechainiapro);
 	 	  	    				    ps.setString(2, mifechafinapro);
 	 	  	    					ps.setString(3, miCargoapro);
 	  	    	   	   	   	       	ResultSet rs = ps.executeQuery();
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
 	  	    	   	   	   	        genreq.setItems(itemsaprobadosB);
 	  	    	 	    	   	   	   			 }
 	  	    	   	   	       	}catch(SQLException ee) {
 	  	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
 	  	    	   	   	       	} 
 	    	    		  }
 	    	    	       
 	    	    	       //-----------------------------------------------fin bloque else if----------------------------------------------------//
 	    	    	       
 	    	    	       //-------------------------------------------------inicio bloque else--------------------------------------------------//
 	    	    		  else {
 	    	    			    ObservableList<requisicionesgen> itemsaprobadosB= FXCollections.observableArrayList();
	  	    	   	   	   		String Query= "SELECT  \r\n" + 
	  	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO,MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION, MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
	  	    	   	   	   				"(CASE WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')= 'SIN FECHA' THEN 'FECHA DE ENTREGA AUN NO ASIGNADA'\r\n" + 
	  	    	   	   	   				"WHEN COALESCE(MIDATA.[FECHA DE ENTREGA],'SIN FECHA')<> 'SIN FECHA'  THEN 'FECHA DE ENTREGA ASIGNADA'\r\n" + 
	  	    	   	   	   				"END) AS FECHA_ENTREGA , \r\n" + 
	  	    	   	   	   				"(CASE                        WHEN  MIDATA.[ESTADO DE ITEMS]  IS NULL  THEN  'REQUISICION POR ENTREGAR'\r\n" + 
	  	    	   	   	   		        "                              WHEN  MIDATA.[ESTADO DE ITEMS] =2 THEN 'REQUISICION RECIBIDA'\r\n" + 
	  	    	   	   	   				"                              WHEN  MIDATA.[ESTADO DE ITEMS]=1 THEN 'REQUISICION TRAMITADA'\r\n" + 
	  	    	   	   	   				"							  WHEN  MIDATA.[ESTADO DE ITEMS] =0 THEN 'REQUISICION EN PROCESO'\r\n" + 
	  	    	   	   	   	         	"							  WHEN  MIDATA.[ESTADO DE ITEMS] =3 THEN 'REQUISICION CERRADA'\r\n" +
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
	  	    	   	   	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	  	    	   	   	         	ps.setString(1, mifechainiapro);
	 	  	    				    ps.setString(2, mifechafinapro);
	 	  	    			        ps.setString(3, '%'+miCargoapro+'%');
	 	  	        		        ps.setString(4, '%'+miareapro+'%');
	  	    	   	   	   	       	ResultSet rs = ps.executeQuery();
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
	  	    	   	   	   	        genreq.setItems(itemsaprobadosB);
	  	    	 	    	   	   	   			 }
	  	    	   	   	       	}catch(SQLException ee) {
	  	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	  	    	   	   	       	} 
 	    	    		  }
 	    	    	       //--------------------------------------------------fin bloque else--------------------------------------------------------//
 	    	    	       
 	    	    	   }catch(NullPointerException nn) {
 	              	   	   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn); 
 	         	     }
           		  }
 	    	    });
                return genreq;   
                }
                

	 public void recorretabla() {
              reqtable.setRowFactory(tableView -> new TableRow<Requisiciones>() {
			    @Override
			    protected void updateItem(Requisiciones requisiciones, boolean empty) {
			        super.updateItem(requisiciones, empty);
			        if (empty) {
			            setStyle("");
			        } else if (requisiciones.getRevisioncol().equals("REVISADO")&&requisiciones.getAprobacion().equals("SIN APROBACION") ) {
			            setStyle("-fx-background-color: rgb(251,249,168); ");
			        } else if (requisiciones.getRevisioncol().equals("SIN REVISION")&& requisiciones.getAprobacion().equals("SIN APROBACION")) {
			            setStyle("-fx-background-color:#FACD96;");
			        } else if (requisiciones.getRevisioncol().equals("REVISADO")&& requisiciones.getAprobacion().equals("APROBADO")) {
			            setStyle("-fx-background-color:rgb(153,204,153);");
			        } else if (requisiciones.getRevisioncol().equals("REVISADO Y NO APROBADO")&&requisiciones.getAprobacion().equals("SIN APROBACION") ) {
			        	setStyle("-fx-background-color:#FFA496;");
			        	 
			        }
			    }
			});
	      }  
             
	 public void recorretablarqdt() {
		 reqdt.setRowFactory(tableView -> new TableRow<Aprobacion>() {
		    @Override
		    protected void updateItem(Aprobacion aprobacion, boolean empty) {
		        super.updateItem(aprobacion, empty);
		        if (empty) {
		            setStyle("");
		        } else if (aprobacion.getEstadoreqdt().equals("AUN SIN APROBACION") ) {
		            setStyle("-fx-background-color: rgb(255,164,164); ");
		        } else if (aprobacion.getEstadoreqdt().equals("REQUISICION APROBADA")) {
		            setStyle("-fx-background-color:rgb(153,204,153);");
		        } 
		    }
		});
     }  
	 

	 public void marcafila() {
		 genreq.setRowFactory(tableView -> new TableRow<requisicionesgen>() {
			 @Override
			 protected void updateItem(requisicionesgen requisiciones, boolean empty ) {
				 super.updateItem(requisiciones, empty);
				 if (empty) {
			        setStyle("");
				 }else if (requisiciones.getEstadofecha().equals("FECHA DE ENTREGA AUN NO ASIGNADA") && requisiciones.getEstadoitems().equals("REQUISICION POR ENTREGAR") ) {
			            setStyle("-fx-background-color: rgb(255,164,164); "); 
			      }
				 else if (requisiciones.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") && requisiciones.getEstadoitems().equals("REQUISICION EN PROCESO") ) {
			            setStyle("-fx-background-color:  rgb(251,249,168); ");
			      
			      }
				 else if (requisiciones.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") && requisiciones.getEstadoitems().equals("REQUISICION TRAMITADA") ) {
			            setStyle("-fx-background-color: rgb(153,204,153);");
			     }
				 else if (requisiciones.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") && requisiciones.getEstadoitems().equals("REQUISICION RECIBIDA") ) {
			            setStyle("-fx-background-color: #74B4ED; ");
			     }
				 
				 else if (requisiciones.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") && requisiciones.getEstadoitems().equals("REQUISICION CERRADA") ) {
			            setStyle("-fx-background-color: #AEFBC1; ");
			     }
				 
				 
			 }
		 }); 
	 }

	 public void resetcampos()   {
		 resetcampos.setOnMouseClicked(e->{
			 fechainifil.setValue(null);
			 fechafinreqfil.setValue(null);
			 comboareaa.getSelectionModel().selectFirst();
			 combocargo.getSelectionModel().selectFirst();
		   });
	    }
	 
	 public void resetreqaprodata() {
		 resetreqapro.setOnMouseClicked(e->{
			aprofechaini.setValue(null);
    		aprofechafin.setValue(null);
    		aproreqcargo.getSelectionModel().selectFirst();
    		aproareareq.getSelectionModel().selectFirst(); 
		 });
	 }
	 
	 
	 public void reseteadatos() {
		 resetreqfapro.setOnMouseClicked(e->{
			 fechainireqf.setValue(null);
			 fechafinreqf.setValue(null);
			 cargoreqfiltro.getSelectionModel().selectFirst();
			 areareqfiltro.getSelectionModel().selectFirst();  
		 });
	 }
	    
	public void sendreq() {
		sendrequi.setOnAction(e->{
			insertarequisicion();
			cantidaditem.clear();
			descripcionitem.clear();
			titem.getItems().clear();
			//------STORED PROCEDURE PARA INSERTAR DATOS DE LA TABLA REQ A LA TABLA RQITEMSTEMPORAL---/
			    Connection miconexionreq = null;
		    	try {
		    		miconexionreq=conectar.miconexion(miconexionreq);
					CallableStatement copiadata = miconexionreq.prepareCall("{call INSERTAFINALDATACOPY}");
					copiadata.execute();
					copiadata.close();
		    	}catch(SQLException ee) {
		    		System.out.println("error stored procedure");
		    	}
		    	//------FIN STORED PROCEDURE PARA INSERTAR DATOS DE LA TABLA REQ A LA TABLA RQITEMSTEMPORAL---//
		    });
	      }

	 public void cargainicio() {
		 inicioreq.setOnMouseClicked(e->{
			 try {
				inicio();
			} catch (IOException e1) {
	 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
			}
		 });
	 }
	 
		public void muestrarequisicionesaprobadas() throws IOException {
			reqdt.setOnMouseClicked(e->{
				try {
				Aprobacion itemsreqapro=reqdt.getSelectionModel().getSelectedItem();
				  h=AdminScreenController.getCapdata();
				  if(itemsreqapro.getEstadoreqdt().equals("REQUISICION APROBADA")) {
		   			    Mensaje data = new Mensaje();
		   			    data.reqapro(stpanerequi);
		   			   }
				  //-------------------permisos-------------------------------------------//
				  else if(!AdminScreenController.getCapdata().equals("ADMINISTRADORREQ")){
					    Mensaje data = new Mensaje();
		   			    data.Permisoadminuno(stpanerequi);	
	   			        }
				  //-------------------fin permisos-------------------------------------------//
				       else {
						    FXMLLoader cargaaprobacionreq = new FXMLLoader(getClass().getResource("AprobacionReq.fxml"));
						    cargaaprobacionreq.load();
				   			Parent StackPane=cargaaprobacionreq.getRoot();
				   			AprobacionReqController updateReqapro = cargaaprobacionreq.<AprobacionReqController>getController();
				   			String estado = itemsreqapro.getEstadoreqdt();
				   			updateReqapro.estadoapro.setText(estado);
				   			String solicitante = itemsreqapro.getSolicitantereqdt();
				   			updateReqapro.solapro.setText(solicitante);
				   			String Area = itemsreqapro.getAreaReqdt();
				   			updateReqapro.areapro.setText(Area);
				   			String Cargo = itemsreqapro.getCargoReqdt();
				   			updateReqapro.cargoapro.setText(Cargo);
				   			LocalDateTime fechasolicitudapro=itemsreqapro.getFechasolicitudReqdt();
				   			String fecha1=fechasolicitudapro.toString();  
				   			String fechareemplazo=fecha1.replace("T"," ");
				   			updateReqapro.fechasolapro.setText(fechareemplazo);
				   			String Consecutivo = itemsreqapro.getConsecutivoReqdt();
				   			updateReqapro.consecapro.setText(Consecutivo);
				   			updateReqapro.setConcecutivo(Consecutivo);
				   			String data=updateReqapro.getConcecutivo();
				   			RequisicionesController.this.setConcecap(data);
				   		    String miiconn= RequisicionesController.this.getConcecap();
				   		    updateReqapro.itemsaprobados.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				   		    String Miconsecutivofinal=updateReqapro.consecapro.getText().toString();
				   			RequisicionesController.this.setFinalcon(Miconsecutivofinal);
				   			String getmiconsecutivofinal=RequisicionesController.this.getFinalcon();
				   			updateReqapro.setConcecutivofinal(getmiconsecutivofinal);
				   			RequisicionesController.this.setcomboareaa(aproareareq);
				   			JFXComboBox <String> area = RequisicionesController.this.getcomboareaa();
				   			RequisicionesController.this.setCombocargo(aproreqcargo);
				   			JFXComboBox <String> cargo = RequisicionesController.this.getCombocargo();
				   			updateReqapro.setArea(area);
				   			updateReqapro.setCargo(cargo);
				   			RequisicionesController.this.setFechai(aprofechaini);
				   			RequisicionesController.this.getFechai();
				   			RequisicionesController.this.setFechaf(aprofechafin);
				   			RequisicionesController.this.getFechaf();
				   			updateReqapro.setFechainicio(RequisicionesController.this.setFechai(aprofechaini));
				   			updateReqapro.setFechafin(RequisicionesController.this.setFechaf(aprofechafin));
				   			RequisicionesController.this.setThistableview(RequisicionesController.this.reqdt);
				   			updateReqapro.setMytablereq(RequisicionesController.this.getThistableview());
				   			try {
				   		    Connection ConexionData=null;
				   			String SqlQuery="SELECT FIRMA_REVISION  FROM REQUISICIONESDT WHERE CNSREQ = '"+miiconn+"' ";
				     		ConexionData=conectar.miconexion(ConexionData);
				  			PreparedStatement ps =ConexionData.prepareStatement(SqlQuery);
				  	       	ResultSet rs = ps.executeQuery();
				  			while(rs.next()) {
				  			     mifirma=rs.getBinaryStream("FIRMA_REVISION");
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
				  		 } catch(NullPointerException | SQLException | IOException nn) {
				 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn);
				  		 }
				   		    Image tempimage=RequisicionesController.this.firma;
						    RequisicionesController.this.setMifirma(tempimage);
						    Image gettempimage=RequisicionesController.this.getMifirma();
			   		        updateReqapro.getimagereqapro.setImage(gettempimage);
			   		        capturamifirmadmin=AdminScreenController.getcapturafirma();
				   			updateReqapro.firmadminreq.setImage(capturamifirmadmin);
				   			Stage aprobacionrequisiciones=new Stage();
				   			aprobacionrequisiciones.setScene(new Scene(StackPane));
				   			RequisicionesController.this.setAprobacionStage(aprobacionrequisiciones);
				   			Stage mistage=RequisicionesController.this.getAprobacionStage();
				   			updateReqapro.setGetaproreqstage(mistage);
				   			aprobacionrequisiciones.focusedProperty().addListener(new ChangeListener<Boolean>()
					 		{
					 		  @Override
					 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
					 		  {
					 		    if(newValue == true) {
					 		    RequisicionesController.this.vreqdt.setDisable(true);
					 		    RequisicionesController.this.reqdt.setDisable(true);
					 		  }
					 		  }
					 		});
				   			aprobacionrequisiciones.showingProperty().addListener(new ChangeListener<Boolean>()
						 		{
						 		  @Override
						 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
						 		  {
						 		    if(newValue == false) {
						 		    RequisicionesController.this.vreqdt.setDisable(false);
						 		    RequisicionesController.this.reqdt.setDisable(false);
						 		  }
						 		  }
						 		});
				   			StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				   			aprobacionrequisiciones.setTitle("Aprobacion de Requisiciones");
				   			aprobacionrequisiciones.show();
				           }
					  }catch(NullPointerException | IOException  xx) {
						 System.out.println("fila sin datos"); 
					       }
			          });
		           }
		
		public void muestrarequisiciondetalle() throws IOException {
	    	   reqtable.setOnMouseClicked(e->{
	    	           try {
	    	           Requisiciones itemsreq=reqtable.getSelectionModel().getSelectedItem();
	    	      	    h=AdminScreenController.getCapdata();
	    	      	   if(itemsreq.getRevisioncol().equals("REVISADO Y NO APROBADO") && itemsreq.getAprobacion().equals("SIN APROBACION")) {
			   				
			   				Mensaje data = new Mensaje();
			   			    data.reqmsjrevnoapro(stpanerequi);
			   			    
			   			}
	    	      	    else  if(itemsreq.getRevisioncol().equals("REVISADO") && itemsreq.getAprobacion().equals("SIN APROBACION")) {
		   				
		   				Mensaje data = new Mensaje();
		   			    data.reqmsjrev(stpanerequi);
		   			    
		   			   }
		   			   else if(itemsreq.getRevisioncol().equals("REVISADO") && itemsreq.getAprobacion().equals("APROBADO")) {
		   				
		   				Mensaje data = new Mensaje();
		   			    data.Reqaprobada(stpanerequi);	
			   			 
		   			   }
		   			 /*LINEA AGREGADA*/  else if(!(AdminScreenController.getCapdata().equals("ADMINISTRADORREV"))&&!(AdminScreenController.getCapdata().equals("ADMINISTRADORREQ"))){
		   				
		   				Mensaje data = new Mensaje();
		   			    data.Permisoadminuno(stpanerequi);	
		   			    System.out.println("aa");
		   			   }
		   			  else
		   			    {
		   				/*LINEA AGREGADA*/  if(AdminScreenController.getCapdata().equals("ADMINISTRADORREV") && AdminScreenController.getCaparea().equals(itemsreq.getAreaReq() )|| (AdminScreenController.getCapdata().equals("ADMINISTRADORREQ")))
		   				{
			   			FXMLLoader cargarevisionreq = new FXMLLoader(getClass().getResource("RevisionRequisiciones.fxml"));
				   	    cargarevisionreq.load();
			   			Parent StackPane=cargarevisionreq.getRoot();
			   			RevisionReqController updateReq = cargarevisionreq.<RevisionReqController>getController();
			   			capturamifirma=AdminScreenController.getcapturafirma();
			   			updateReq.getimagecaptura.setImage(capturamifirma);
			   			Integer idreqcns=itemsreq.getIdreq();
			   			updateReq.reqid.setText(idreqcns.toString());
			   			String consecutivo=itemsreq.getConsecutivoReq();
			   			updateReq.reqcon.setText(consecutivo);
			   			String solicitante=itemsreq.getSolicitanteReq();
			   			updateReq.solreqfield.setText(solicitante);
			   			String area=itemsreq.getAreaReq();
			   			updateReq.areareqfield.setText(area);
			   			String cargo=itemsreq.getCargoReq();
			   			updateReq.cargoreqfield.setText(cargo);
			   			LocalDateTime fechasolicitud=itemsreq.getFechasolicitudReq();
			   			String fecha2=fechasolicitud.toString();  
			   			String fechareemplazo=fecha2.replace("T"," ");
			   			updateReq.fechasolreqfield.setText(fechareemplazo);
			   			String mireqid=updateReq.reqid.getText().toString();
			   			RequisicionesController.this.setCapmidreq(mireqid);
			   			String getmidreq=RequisicionesController.this.getCapmidreq();
			   			updateReq.setMireqid(getmidreq);
			   			String mireqid1=updateReq.reqid.getText().toString();
			   			String h=updateReq.setMiidreq1(mireqid1);
			   			String micnsreq1=updateReq.reqcon.getText().toString();
			   			String hh=updateReq.setMicnsreq1(micnsreq1);
			   			System.out.println(h+" "+hh);
			   			String micnsreqq=updateReq.reqcon.getText().toString();
			   			RequisicionesController.this.setCapmicnsreq(micnsreqq);
			   			String getmicnsreqq=RequisicionesController.this.getCapmicnsreq();
			   			updateReq.setMicnsreq(getmicnsreqq);
			   			Stage requisicionesdetalle=new Stage();
			   			requisicionesdetalle.setScene(new Scene(StackPane));
			   		    updateReq.setThisstage(requisicionesdetalle);
			   		    RequisicionesController.this.setReqtable(RequisicionesController.this.reqtable);
			   		    updateReq.setGetmodeltable(RequisicionesController.this.getReqtable());
			   		    RequisicionesController.this.setFechainifil(fechainifil);
			   		    DatePicker a=RequisicionesController.this.getFechainifil();
			   		    updateReq.setFechainicio(a);
			   		    RequisicionesController.this.setFechafinreqfil(fechafinreqfil);
			   		    DatePicker b=RequisicionesController.this.getFechafinreqfil();
			   		    updateReq.setFechafin(b);
			   		    RequisicionesController.this.setCombocargo(combocargo);
			   		    JFXComboBox<String> micombocargo = RequisicionesController.this.getCombocargo();
			   		    updateReq.setCargos(micombocargo);
			   		    RequisicionesController.this.setcomboareaa(comboareaa);
			   		    JFXComboBox<String> micomboarea = RequisicionesController.this.getcomboareaa();
			   		    updateReq.setAreac(micomboarea);
			   		    updateReq.itemsdetalle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			   		 requisicionesdetalle.focusedProperty().addListener(new ChangeListener<Boolean>()
			 		{
			 		  @Override
			 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			 		  {
			 		    if(newValue == true) {
			 		    RequisicionesController.this.vregreq.setDisable(true);
			 		    RequisicionesController.this.reqtable.setDisable(true);
			 		  }
			 		  }
			 		});
			   		 requisicionesdetalle.showingProperty().addListener(new ChangeListener<Boolean>()
				 		{
				 		  @Override
				 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
				 		  {
				 		    if(newValue == false) {
				 		    RequisicionesController.this.vregreq.setDisable(false);
				 		    RequisicionesController.this.reqtable.setDisable(false);
				 		  }
				 		  }
				 		});	
			   			StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			   			requisicionesdetalle.setTitle("Requisiciones Detalle");
			   			requisicionesdetalle.show();
				   		}
		   			else if(AdminScreenController.getCapdata().equals("ADMINISTRADORREV") && AdminScreenController.getCaparea().equals(itemsreq.getAreaReq() ) ||  AdminScreenController.getCaparea().equals("Comercial")     && ((itemsreq.getAreaReq().equals("Comercial")) || (itemsreq.getAreaReq().equals("Ventas")) || (itemsreq.getAreaReq().equals("Compras")) ||(itemsreq.getAreaReq().equals("Logistica")) ))
	   				{
		   			FXMLLoader cargarevisionreq = new FXMLLoader(getClass().getResource("RevisionRequisiciones.fxml"));
			   	    cargarevisionreq.load();
		   			Parent StackPane=cargarevisionreq.getRoot();
		   			RevisionReqController updateReq = cargarevisionreq.<RevisionReqController>getController();
		   			capturamifirma=AdminScreenController.getcapturafirma();
		   			updateReq.getimagecaptura.setImage(capturamifirma);
		   			Integer idreqcns=itemsreq.getIdreq();
		   			updateReq.reqid.setText(idreqcns.toString());
		   			String consecutivo=itemsreq.getConsecutivoReq();
		   			updateReq.reqcon.setText(consecutivo);
		   			String solicitante=itemsreq.getSolicitanteReq();
		   			updateReq.solreqfield.setText(solicitante);
		   			String area=itemsreq.getAreaReq();
		   			updateReq.areareqfield.setText(area);
		   			String cargo=itemsreq.getCargoReq();
		   			updateReq.cargoreqfield.setText(cargo);
		   			LocalDateTime fechasolicitud=itemsreq.getFechasolicitudReq();
		   			String fecha2=fechasolicitud.toString();  
		   			String fechareemplazo=fecha2.replace("T"," ");
		   			updateReq.fechasolreqfield.setText(fechareemplazo);
		   			String mireqid=updateReq.reqid.getText().toString();
		   			RequisicionesController.this.setCapmidreq(mireqid);
		   			String getmidreq=RequisicionesController.this.getCapmidreq();
		   			updateReq.setMireqid(getmidreq);
		   			String mireqid1=updateReq.reqid.getText().toString();
		   			String h=updateReq.setMiidreq1(mireqid1);
		   			String micnsreq1=updateReq.reqcon.getText().toString();
		   			String hh=updateReq.setMicnsreq1(micnsreq1);
		   			System.out.println(h+" "+hh);
		   			String micnsreqq=updateReq.reqcon.getText().toString();
		   			RequisicionesController.this.setCapmicnsreq(micnsreqq);
		   			String getmicnsreqq=RequisicionesController.this.getCapmicnsreq();
		   			updateReq.setMicnsreq(getmicnsreqq);
		   			Stage requisicionesdetalle=new Stage();
		   			requisicionesdetalle.setScene(new Scene(StackPane));
		   		    updateReq.setThisstage(requisicionesdetalle);
		   		    RequisicionesController.this.setReqtable(RequisicionesController.this.reqtable);
		   		    updateReq.setGetmodeltable(RequisicionesController.this.getReqtable());
		   		    RequisicionesController.this.setFechainifil(fechainifil);
		   		    DatePicker a=RequisicionesController.this.getFechainifil();
		   		    updateReq.setFechainicio(a);
		   		    RequisicionesController.this.setFechafinreqfil(fechafinreqfil);
		   		    DatePicker b=RequisicionesController.this.getFechafinreqfil();
		   		    updateReq.setFechafin(b);
		   		    RequisicionesController.this.setCombocargo(combocargo);
		   		    JFXComboBox<String> micombocargo = RequisicionesController.this.getCombocargo();
		   		    updateReq.setCargos(micombocargo);
		   		    RequisicionesController.this.setcomboareaa(comboareaa);
		   		    JFXComboBox<String> micomboarea = RequisicionesController.this.getcomboareaa();
		   		    updateReq.setAreac(micomboarea);
		   		    updateReq.itemsdetalle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		   		 requisicionesdetalle.focusedProperty().addListener(new ChangeListener<Boolean>()
		 		{
		 		  @Override
		 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
		 		  {
		 		    if(newValue == true) {
		 		    RequisicionesController.this.vregreq.setDisable(true);
		 		    RequisicionesController.this.reqtable.setDisable(true);
		 		  }
		 		  }
		 		});
		   		 requisicionesdetalle.showingProperty().addListener(new ChangeListener<Boolean>()
			 		{
			 		  @Override
			 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			 		  {
			 		    if(newValue == false) {
			 		    RequisicionesController.this.vregreq.setDisable(false);
			 		    RequisicionesController.this.reqtable.setDisable(false);
			 		  }
			 		  }
			 		});	
		   			StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		   			requisicionesdetalle.setTitle("Requisiciones Detalle");
		   			requisicionesdetalle.show();
			   		}
		   			else {
		   				Mensaje msj = new Mensaje();
		   				msj.mensajenotificacion(stpanerequi);
		   				System.out.println("error de area");
		   			    }
		   			    }
		   		     	}catch(NullPointerException | IOException xx) {
		   		     	 System.out.println("fila sin datos"); 
		   		     	}
	    	           });
	   		         }
		 

   public void muestradatosdemitabla() {
	   vregreq.setOnMouseClicked(e->{
		   selecciondedatosreq();  
	   });
   }
   
   public void muestradatosreqdt() {
	   vreqdt.setOnMouseClicked(e->{;
	   selecciondedatosreqdt();
	   });
   }
		 
   

	public void selectcell() throws IOException {
	   genreq.setOnMouseClicked(e->{
		    
	  		data = RequisicionesController.this.genreq.getSelectionModel().getSelectedItem();	
 		    thisol=	solreq.getText().toString();
 		    ObservableList<String> cnsreqitem= FXCollections.observableArrayList();
 		    String Queryd="SELECT CNSREQ FROM REQUISICIONES WHERE SOLICITANTE ='"+thisol+"'";
 			Connection ConexionDate = null;        
 			try {
 			    ConexionDate=conectar.miconexion(ConexionDate);
 			    PreparedStatement pst =ConexionDate.prepareStatement(Queryd);
 			    ResultSet rset = pst.executeQuery();
 			    while (rset.next()) {
 			     cnsreqitem.add(micnsreq= rset.getString("CNSREQ"));
 			  
 			      }
 			    for(int i=0;i<cnsreqitem.size();i++) {
 		         if(cnsreqitem.get(i).equals(data.getConsecutivogenreq())) {
 		        	  midatafound=cnsreqitem.get(i);
 		        	 
 		          }
 		         else if(!cnsreqitem.get(i).equals(data.getConsecutivogenreq())) {
 		        	midatafound=data.getConsecutivogenreq(); 
 		         }
 		          }
 			     }catch(SQLException  | NullPointerException ee) {
 		 		 System.out.println("fila sin datos");
 		 	     }
		   try {
		   requisicionesgen gena = genreq.getSelectionModel().getSelectedItem();
		   ObservableList<requisicionesgen> items = genreq.getItems();
		   if(items.isEmpty()){
			   try
			   {
				gena.getEstadofecha();   
			   }catch(NullPointerException nn) {
				   System.out.println("fila sin datos"); 
			   }  
			   }
		   else {
		   if(gena.getEstadofecha().equals("FECHA DE ENTREGA AUN NO ASIGNADA") && AdminScreenController.getCapdata().equals("ADMINISTRADOR")) {
		   try {
		    FXMLLoader cargareqfinal = new FXMLLoader(getClass().getResource("RequisicionesAprobacionDetalle.fxml"));
		    try
			   {
				   gena.getEstadofecha();   
			   }catch(NullPointerException nn) {
				   System.out.println("fila sin datos"); 
			   }  
		    try {
				cargareqfinal.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    Parent StackPane =  cargareqfinal.getRoot();
		    RequisicionesAprobacionDetalleController finalreq = cargareqfinal.<RequisicionesAprobacionDetalleController>getController();
            requisicionesgen gen = genreq.getSelectionModel().getSelectedItem();
		    String consecutivo1= gen.getConsecutivogenreq();
		    finalreq.consecutivoreqapro.setText(consecutivo1);
		    String sol1 = gen.getSolicitantegenreq();
		    finalreq.solicitantereapro.setText(sol1);
		    String area1 = gen.getAreagenreq();
		    finalreq.areareqaprofinal.setText(area1);
		    String Cargo1 = gen.getCargogenreq();
		    finalreq.cargoreqaprofinal.setText(Cargo1);
		    String fechaapro = gen.getFechaaprogenreq();
		    finalreq.fecaprobacionreqapro.setText(fechaapro);
		    Integer item1= gen.getItemapro();
		    finalreq.itemsreqaprofinal.setText(item1.toString());
		    Integer item2= gen.getItemnoapro();
		    finalreq.itemsresnoaprofinal.setText(item2.toString());
		    RequisicionesController.this.setFechai(fechainireqf);
		    RequisicionesController.this.getFechai();
		    finalreq.setFechaif(RequisicionesController.this.getFechai());
		    RequisicionesController.this.setFechaf(fechafinreqf);
		    RequisicionesController.this.getFechaf();
		    finalreq.setFechaff(RequisicionesController.this.getFechaf());
		    RequisicionesController.this.setThisfarea(areareqfiltro);
		    RequisicionesController.this.getThisfarea();
		    finalreq.setThisfarea(RequisicionesController.this.getThisfarea());
		    RequisicionesController.this.setThisfcargo(cargoreqfiltro);
		    RequisicionesController.this.getThisfcargo();
		    finalreq.setThisfcargo(RequisicionesController.this.getThisfcargo());
		    RequisicionesController.this.setThistableviewf(RequisicionesController.this.genreq);
		    RequisicionesController.this.getThistableviewf();
		    finalreq.setThistableviewf(RequisicionesController.this.getThistableviewf());
		    Stage detallesderequisicionesaprobadas=new Stage();
		    detallesderequisicionesaprobadas.setScene(new Scene(StackPane));
		    RequisicionesController.this.setReturnthisStage(detallesderequisicionesaprobadas);
		    Stage miStage=RequisicionesController.this.getReturnthisStage();
		    finalreq.setThisStageA(miStage);
		    StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			detallesderequisicionesaprobadas.setTitle("Generar Fecha De Entrega de Items");
			detallesderequisicionesaprobadas.show();
		   }catch(NullPointerException nn) {
			   System.out.println("fila sin datos"); 
		   }
		   }
		   if  (gena.getEstadofecha().equals("FECHA DE ENTREGA AUN NO ASIGNADA") && !(AdminScreenController.getCapdata().equals("ADMINISTRADOR"))) {
			   Mensaje msjd = new Mensaje();
			   msjd.Permisoadminuno(stpanerequi);
		   }
		   else if(gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") &&  gena.getEstadoitems().equals("REQUISICION EN PROCESO") && (AdminScreenController.getCapdata().equals("ADMINISTRADOR")) ) {
			   try {
				    FXMLLoader cargareqfinal2 = new FXMLLoader(getClass().getResource("DetalleFechaItemsAsignados.fxml"));
				    
				    try {
						cargareqfinal2.load();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				    Parent StackPane =  cargareqfinal2.getRoot();
				    DetalleFechaItemsController finaldata = cargareqfinal2.<DetalleFechaItemsController>getController();
				    requisicionesgen genc = genreq.getSelectionModel().getSelectedItem();
				    String consecutivo2= genc.getConsecutivogenreq();
				    finaldata.consecutivoreqaprofinal.setText(consecutivo2);
				    String thissol=genc.getSolicitantegenreq();
				    finaldata.solicitantereaprofinal.setText(thissol);
				    String thisarea=genc.getAreagenreq();
				    finaldata.areareqaprofinalitems.setText(thisarea);
				    String thiscargo=genc.getCargogenreq();
				    finaldata.cargoreqaprofinalitems.setText(thiscargo);
				    String thisfechaapro=genc.getFechaaprogenreq();
				    finaldata.fecaprobacionreqaprofinalitems.setText(thisfechaapro);
				    Integer thisitemsaprobados=genc.getItemapro();
				    finaldata.itemsreqaprofinalitems.setText(thisitemsaprobados.toString());
				    Integer thisitemnoaprobados = genc.getItemnoapro();
				    finaldata.itemsresnoaprofinalitems.setText(thisitemnoaprobados.toString());
				    RequisicionesController.this.setFechaiff(fechainireqf);
				    RequisicionesController.this.getFechaiff();
				    finaldata.setFechaiff(RequisicionesController.this.getFechaiff());
				    RequisicionesController.this.setFechafff(fechafinreqf);
				    RequisicionesController.this.getFechafff();
				    finaldata.setFechafff( RequisicionesController.this.getFechafff());
				    RequisicionesController.this.setThisfareaf(areareqfiltro);
				    RequisicionesController.this.getThisfareaf();
				    finaldata.setThisfareaf(RequisicionesController.this.getThisfareaf());
				    RequisicionesController.this.setThisfcargof(cargoreqfiltro);
				    RequisicionesController.this.getThisfcargof();
				    finaldata.setThisfcargof( RequisicionesController.this.getThisfcargof());
				    RequisicionesController.this.setThistableviewf(RequisicionesController.this.genreq);
				    RequisicionesController.this.getThistableviewf();
				    finaldata.setThistableviewff( RequisicionesController.this.getThistableviewf());
				    String QueryDate="SELECT FECHA_ENTREGA FROM REQUISICIONES WHERE CNSREQ ='"+consecutivo2+"'";
  					
  					try {
  						ConexionDate=conectar.miconexion(ConexionDate);
  						PreparedStatement pst =ConexionDate.prepareStatement(QueryDate);
  						ResultSet rset = pst.executeQuery();
  					     while (rset.next()) {
  						  thisdate1= rset.getString("FECHA_ENTREGA");
  					     }
  			    	}catch(SQLException ee) {
  			   		ee.printStackTrace();
  			   	    }
  					finaldata.fechaentregafinalitems.setText(thisdate1);
				    Stage detallesderequisicionesfinalaprobadas=new Stage();
				    detallesderequisicionesfinalaprobadas.setScene(new Scene(StackPane));
				    RequisicionesController.this.setRStage(detallesderequisicionesfinalaprobadas);
				    Stage Stagereiceiver=RequisicionesController.this.getRStage();
				    finaldata.setGetthisstage(Stagereiceiver);
				    StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				    detallesderequisicionesfinalaprobadas.setTitle("Generar Requisición");
				    detallesderequisicionesfinalaprobadas.show();
				   }catch(NullPointerException nn) {
					   System.out.println("fila sin datos"); 
				   }
				   }
		   
		   if(gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") &&  gena.getEstadoitems().equals("REQUISICION EN PROCESO") && !(AdminScreenController.getCapdata().equals("ADMINISTRADOR")) ) {
			   Mensaje msjd = new Mensaje();
			   msjd.Permisoadminuno(stpanerequi); 
			   
		   }
		  else if( (gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA")) && ( gena.getEstadoitems().equals("REQUISICION TRAMITADA") ) && (AdminScreenController.getCapdata().equals("USUARIO") ) ||  (gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA")) &&  (gena.getEstadoitems().equals("REQUISICION TRAMITADA")) && (AdminScreenController.getCapdata().equals("ADMINISTRADORREV") ) ) {
				if((midatafound.equals(data.getConsecutivogenreq()) && (thisol.equals(data.getSolicitantegenreq())))) {
					requisicionesgen mdata = genreq.getSelectionModel().getSelectedItem();
					String conrep=mdata.getConsecutivogenreq();
					String cargorep=mdata.getCargogenreq();
					String nombrerep=mdata.getSolicitantegenreq();
					String arearep=mdata.getAreagenreq();
					RequisicionesController.this.setGetcnsreqrep(conrep);
					RequisicionesController.this.getGetcnsreqrep();
					FXMLLoader recepcionrequisiciones = new FXMLLoader(getClass().getResource("RecepcionReq.fxml"));	    
			              try {
						    recepcionrequisiciones.load();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						    Parent StackPane =  recepcionrequisiciones.getRoot();
						    RecepcionReqController recepcion = recepcionrequisiciones.<RecepcionReqController>getController();
						    RequisicionesController.this.setFechainicio(fechainireqf);
						    recepcion.setFechainireqf(RequisicionesController.this.getFechainicio());
						    RequisicionesController.this.setFechafin(fechafinreqf);
						    recepcion.setFechafinreqf( RequisicionesController.this.getFechafin());
						    RequisicionesController.this.setArea(areareqfiltro);
						    recepcion.setAreareqfiltro(RequisicionesController.this.getArea());
						    RequisicionesController.this.setCargo(cargoreqfiltro);
						    recepcion.setCargoreqfiltro(RequisicionesController.this.getCargo());
						    RequisicionesController.this.setThistableviewfff(RequisicionesController.this.genreq);
						    recepcion.setMitable(RequisicionesController.this.getThistableviewfff());
						    Connection ConexionD=null;
						    try {
						    ConexionD=conectar.miconexion(ConexionD);
						    String getCnsQuery="SELECT FECHA_ENTREGA FROM REQUISICIONES WHERE REQUISICIONES.CNSREQ='"+RequisicionesController.this.getGetcnsreqrep()+"'";
						    PreparedStatement GetData =ConexionD.prepareStatement(getCnsQuery);
				   			ResultSet rsData = GetData.executeQuery();
				   			while(rsData.next()) {
				   	        	mifecha=rsData.getString("FECHA_ENTREGA");
				   	        }
					       	}catch(SQLException ee) {
					       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
					       	}
						    RequisicionesController.this.setSetfecha(mifecha);
						    recepcion.setGetmifecha(RequisicionesController.this.getSetfecha());
						    RequisicionesController.this.getSetfecha();
						    recepcion.reqreptx.setText(conrep);
						    recepcion.cargoreptx.setText(cargorep);
						    recepcion.nombrereptx.setText(nombrerep);
						    recepcion.areareptx.setText(arearep);
						    recepcion.setMicnsreq(RequisicionesController.this.getGetcnsreqrep());
						    recepcion.fechaentregareptx.setText(mifecha);
						    Stage recepciondereq=new Stage();
						    recepciondereq.setScene(new Scene(StackPane));
						    boolean data =recepciondereq.isMaximized();
						    if(recepciondereq.isMaximized()==data) {
						    	recepcion.itemrep.setPrefWidth(180);
						        recepcion.estadorep.setPrefWidth(200);
						        recepcion.recibidorep.setPrefWidth(270);
						    }
						    //----------------------------stage 1------------------------//
						    RequisicionesController.this.setGetrepfinalstage(recepciondereq);
						    Stage mistage=RequisicionesController.this.getGetrepfinalstage();
						    recepcion.setStageuno(mistage);//-----paso el stage al controlador----recepcionreqcontroller//
						    //----------------------------stage 1------------------------//
						    recepciondereq.focusedProperty().addListener(new ChangeListener<Boolean>()
					 		{
					 		  @Override
					 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
					 		  {
					 		    if(newValue == true) {
					 		    RequisicionesController.this.cargadatosapro.setDisable(true);
					 		    RequisicionesController.this.genreq.setDisable(true);
					 		  }
					 		  }
					 		});
						    recepciondereq.showingProperty().addListener(new ChangeListener<Boolean>()
						 		{
						 		  @Override
						 		  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
						 		  {
						 		    if(newValue == false) {
						 		    RequisicionesController.this.cargadatosapro.setDisable(false);
						 		    RequisicionesController.this.genreq.setDisable(false);
						 		  }
						 		  }
						 		});
						    StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						    recepciondereq.setTitle("Recibir Requisición");
						    recepciondereq.show();
		                }
				else if((midatafound.equals(data.getConsecutivogenreq()) && (!thisol.equals(data.getSolicitantegenreq()))) ) {
			        	
					    Mensaje Data  = new Mensaje();
			        	Data.msjpermisosreq(stpanerequi);
			        	
				       }
		             }
		   
		  else if( (gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA")) && ( gena.getEstadoitems().equals("REQUISICION TRAMITADA") ) && !(AdminScreenController.getCapdata().equals("USUARIO") ) ||  (gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA")) &&  (gena.getEstadoitems().equals("REQUISICION TRAMITADA")) && !(AdminScreenController.getCapdata().equals("ADMINISTRADORREV") ) ) {
			   Mensaje msjd = new Mensaje();
			   msjd.Permisoadminuno(stpanerequi); 
		   
		  }
		   
		  else if(gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") && gena.getEstadoitems().equals("REQUISICION RECIBIDA")) {
			  if((midatafound.equals(data.getConsecutivogenreq()) && (thisol.equals(data.getSolicitantegenreq()) ))) {      
			  try {
				    FXMLLoader cargareqfinal2 = new FXMLLoader(getClass().getResource("DetalleFechaItemsAsignados.fxml"));
				    
				    try {
						cargareqfinal2.load();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				    Parent StackPane =  cargareqfinal2.getRoot();
				    DetalleFechaItemsController finaldata = cargareqfinal2.<DetalleFechaItemsController>getController();
				    requisicionesgen genc = genreq.getSelectionModel().getSelectedItem();
				    String consecutivo2= genc.getConsecutivogenreq();
				    finaldata.consecutivoreqaprofinal.setText(consecutivo2);
				    String thissol=genc.getSolicitantegenreq();
				    finaldata.solicitantereaprofinal.setText(thissol);
				    String thisarea=genc.getAreagenreq();
				    finaldata.areareqaprofinalitems.setText(thisarea);
				    String thiscargo=genc.getCargogenreq();
				    finaldata.cargoreqaprofinalitems.setText(thiscargo);
				    String thisfechaapro=genc.getFechaaprogenreq();
				    finaldata.fecaprobacionreqaprofinalitems.setText(thisfechaapro);
				    Integer thisitemsaprobados=genc.getItemapro();
				    finaldata.itemsreqaprofinalitems.setText(thisitemsaprobados.toString());
				    Integer thisitemnoaprobados = genc.getItemnoapro();
				    finaldata.itemsresnoaprofinalitems.setText(thisitemnoaprobados.toString());
				    RequisicionesController.this.setFechaiff(fechainireqf);
				    RequisicionesController.this.getFechaiff();
				    finaldata.setFechaiff(RequisicionesController.this.getFechaiff());
				    RequisicionesController.this.setFechafff(fechafinreqf);
				    RequisicionesController.this.getFechafff();
				    finaldata.setFechafff( RequisicionesController.this.getFechafff());
				    RequisicionesController.this.setThisfareaf(areareqfiltro);
				    RequisicionesController.this.getThisfareaf();
				    finaldata.setThisfareaf(RequisicionesController.this.getThisfareaf());
				    RequisicionesController.this.setThisfcargof(cargoreqfiltro);
				    RequisicionesController.this.getThisfcargof();
				    finaldata.setThisfcargof( RequisicionesController.this.getThisfcargof());
				    RequisicionesController.this.setThistableviewf(RequisicionesController.this.genreq);
				    RequisicionesController.this.getThistableviewf();
				    finaldata.setThistableviewff( RequisicionesController.this.getThistableviewf());
				    String QueryDate="SELECT FECHA_ENTREGA FROM REQUISICIONES WHERE CNSREQ ='"+consecutivo2+"'";
					 Connection Date = null;
					try {
						Date=conectar.miconexion(Date);
						PreparedStatement pst =Date.prepareStatement(QueryDate);
						ResultSet rset = pst.executeQuery();
					     while (rset.next()) {
						  thisdate1= rset.getString("FECHA_ENTREGA");
					     }
			    	}catch(SQLException ee) {
			   		ee.printStackTrace();
			   	    }
					finaldata.fechaentregafinalitems.setText(thisdate1);
				    Stage detallesderequisicionesfinalaprobadas=new Stage();
				    detallesderequisicionesfinalaprobadas.setScene(new Scene(StackPane));
				    RequisicionesController.this.setRStage(detallesderequisicionesfinalaprobadas);
				    Stage Stagereiceiver=RequisicionesController.this.getRStage();
				    finaldata.setGetthisstage(Stagereiceiver);
				    StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				    detallesderequisicionesfinalaprobadas.setTitle("Generar Requisición");
				    detallesderequisicionesfinalaprobadas.show();
				   }catch(NullPointerException nn) {
					   System.out.println("fila sin datos"); 
				   }
		           }
				   else if((midatafound.equals(data.getConsecutivogenreq()) && (!thisol.equals(data.getSolicitantegenreq())))) {
				    Mensaje Data  = new Mensaje();
		        	Data.msjpermisosreq(stpanerequi);
			       }
		           }
		   
		  else if(gena.getEstadofecha().equals("FECHA DE ENTREGA ASIGNADA") && gena.getEstadoitems().equals("REQUISICION CERRADA")) {
		    Mensaje  msjd = new Mensaje();
		    msjd.mensajedatosRQcerrada(stpanerequi);
		    }
		   }         
		   }catch(NullPointerException nn) {
			   System.out.println("fila sin datos"); 
		   }
		   });
		   }
	public void mostrardatosaprobados() {
    	cargadatosapro.setOnAction(e->{
    		selecciondeitemsaprobados() ;
    	});
    }
	
	public static void main(String[] args) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)  {
		revisionreqcol.setCellValueFactory(new PropertyValueFactory <Requisiciones,String>("revisioncol"));
		aprobacionreqcol.setCellValueFactory(new PropertyValueFactory <Requisiciones,String>("aprobacion"));
		idreque.setCellValueFactory(new PropertyValueFactory <Requisiciones,Integer>("idreq"));
		consecutivoReque.setCellValueFactory(new PropertyValueFactory <Requisiciones,String>("ConsecutivoReq"));
		SolicitanteReque.setCellValueFactory(new PropertyValueFactory <Requisiciones,String>("SolicitanteReq"));
		AreaReque.setCellValueFactory(new PropertyValueFactory <Requisiciones,String>("AreaReq"));
		CargoReque.setCellValueFactory(new PropertyValueFactory <Requisiciones,String>("CargoReq"));
		FechaSolReque.setCellValueFactory(CellData -> CellData.getValue().FechasolicitudReqProperty());
		coperacion.setCellValueFactory(new PropertyValueFactory <Requisiciones,String>("CentroOp"));
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		FechaSolReque.setCellFactory(column -> new TableCell<Requisiciones, LocalDateTime>() {
			    @Override
			    protected void updateItem(LocalDateTime item, boolean empty) {
			        super.updateItem(item, empty);
			        if (empty)
			            setText(null);
			        else
			            setText(String.format(item.format(formatter)));
			          }
			        });
		restadorqdt.setCellValueFactory(new PropertyValueFactory <Aprobacion,String>("estadoreqdt"));
		rsolicitanterqdt.setCellValueFactory(new PropertyValueFactory <Aprobacion,String>("solicitantereqdt"));
		rarearqdt.setCellValueFactory(new PropertyValueFactory <Aprobacion,String>("AreaReqdt"));
		rcargorqdt.setCellValueFactory(new PropertyValueFactory <Aprobacion,String>("CargoReqdt"));
		rcentrorqt.setCellValueFactory(new PropertyValueFactory <Aprobacion,String>("Centroop"));
		rfechasrqdt.setCellValueFactory(CellData -> CellData.getValue().FechasolicitudReqdtProperty());
		rconcecutivorqdt.setCellValueFactory(new PropertyValueFactory <Aprobacion,String>("ConsecutivoReqdt"));
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		rfechasrqdt.setCellFactory(column -> new TableCell<Aprobacion, LocalDateTime>() {
			    @Override
			    protected void updateItem(LocalDateTime item, boolean empty) {
			        super.updateItem(item, empty);
			        if (empty)
			            setText(null);
			        else
			            setText(String.format(item.format(formatter2)));
			          }
			        });
		itemm.setCellValueFactory(new PropertyValueFactory <item,String>("Item"));
		cantidaditemm.setCellValueFactory(new PropertyValueFactory <item,Integer>("Cantidad"));
		gencsnsreq.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("consecutivogenreq"));
		gensolreq.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("solicitantegenreq"));
		genareareq.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("areagenreq"));
		gencargoreq.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("cargogenreq"));
		genfecsolreq.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("fechasolgenreq"));
		genfecaproreq.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("fechaaprogenreq"));
		genitemapro.setCellValueFactory(new PropertyValueFactory <requisicionesgen,Integer>("itemapro"));
		genitemnoapro.setCellValueFactory(new PropertyValueFactory <requisicionesgen,Integer>("itemnoapro"));
		genitemfecestado.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("estadofecha"));
		genitemestado.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("estadoitems"));
		gencentroperacionreq.setCellValueFactory(new PropertyValueFactory <requisicionesgen,String>("centropgenreq"));
		try {
			selectcell();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		marcafila();
		mostrardatosaprobados();
		 cargainicio() ;
		 setestilostextfield() ;
		 recorretablarqdt();
		 sendreq();
		 insertadatositems();
		 eliminadatostabla();
		 muestradatosdemitabla();
		 llenacombo();
		 filtradodatos();
		 filtrodedatosaprobados(); 
		 resetcampos();
		 muestradatosreqdt() ;
		 filtradodatosapro();
		 resetreqaprodata();
		 showdetails();
		 restriccionconteo();
		 reseteadatos();

		 try {
			muestrarequisiciondetalle();
			muestrarequisicionesaprobadas();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e);
		}
	recorretabla();
	    }
	@Override
	public void start(Stage arg0) throws Exception {
	}
}