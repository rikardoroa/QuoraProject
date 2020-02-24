package application;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AprobacionReqController extends Application implements Initializable {
	
	
	  @FXML  private StackPane stackapro;
	  @FXML  private Label estadoreqrapro;
	  @FXML  private Label solicitantereqapro;
	  @FXML  private Label areareqapro;
	  @FXML  private Label cargoreqapro;
	  @FXML  private Label fechareqapro;
	  @FXML  private Label cantidadreqapro;
	  @FXML  private Label descripcionreqapro;
	  @FXML  private Label observacionesreqapro;
	  @FXML  private Label concecutivoreqapro;
	  @FXML  private Label firmareqapro;
	  @FXML  private Label faprolabel;
	  @FXML  public  ImageView getimagereqapro;
	  @FXML  public  ImageView firmadminreq;
	  @FXML  public JFXTextField estadoapro;
	  @FXML  public JFXTextField solapro;
	  @FXML  public JFXTextField areapro;
	  @FXML  public JFXTextField cargoapro;
	  @FXML  public JFXTextField fechasolapro;
	  @FXML  public JFXTextField cantidadapro;
	  @FXML  public JFXTextField descripcionapro;
	  @FXML  public JFXTextArea obserapro;
	  @FXML  public JFXTextField consecapro;
	  @FXML public   JFXTextField fapro;
	  @FXML  public  JFXButton firmareq;
	  @FXML  public  JFXButton cargatareqapro;
	  @FXML  public  JFXButton probar;
	  @FXML public TableView<Itemapro>itemsaprobados;
	  @FXML public TableColumn<Itemapro,String>miitemapro;  
	  @FXML public TableColumn<Itemapro,Integer>micantidadapro;  
	  @FXML public TableColumn<Itemapro,String>estadoitem; 
	  public String Concecutivo;
      public String consecutivofinal;
      public String miitem;
  	  public String micantidad;
      public String miconsecutivo;
      public Stage SetDatosItemsStage;
      public BufferedImage imagenbuffer;
      public Stage getaproreqstage;
      public String midataitem;
      public JFXComboBox<String> cargo;
      public JFXComboBox<String> area;
      public DatePicker fechainicio;
      public DatePicker fechafin;
      public DatePicker fechainiciof;
      public DatePicker fechafinf;
      public TableView <Aprobacion> mytablereq;
      public String combocargo;
      public String comboarea;
      public String fechai;
      public String fechaf;
      public ObservableList<Aprobacion> Datostablaproreqfechas;
      public ObservableList<Aprobacion> Datostablarequisicionesaprofechassinglemodel;
      public ObservableList<Aprobacion> Datostablarequisicionesaprofechasmisingle;
      public ObservableList<Aprobacion> Datostablarequisicionesaprof;
      public TableView<Itemapro> miitems;
      
	public TableView<Itemapro> getMiitems() {
		return miitems;
	}


	public void setMiitems(TableView<Itemapro> miitems) {
		this.miitems = miitems;
	}


	public TableView<Aprobacion> getMytablereq() {
		return mytablereq;
	}


	public void setMytablereq(TableView<Aprobacion> mytablereq) {
		this.mytablereq = mytablereq;
	}


	public JFXComboBox<String> getCargo() {
		return cargo;
	}


	public void setCargo(JFXComboBox<String> cargo) {
		this.cargo = cargo;
	}


	public JFXComboBox<String> getArea() {
		return area;
	}


	public void setArea(JFXComboBox<String> area) {
		this.area = area;
	}


	public DatePicker getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(DatePicker fechainicio) {
		this.fechainicio = fechainicio;
	}


	public DatePicker getFechafin() {
		return fechafin;
	}


	public void setFechafin(DatePicker fechafin) {
		this.fechafin = fechafin;
	}


	public Stage getGetaproreqstage() {
		return getaproreqstage;
	 }


      public void setGetaproreqstage(Stage getaproreqstage) {
		this.getaproreqstage = getaproreqstage;
	}


	public Stage getSetDatosItemsStage() {
		return SetDatosItemsStage;
	  }


	 public void setSetDatosItemsStage(Stage setDatosItemsStage) {
		SetDatosItemsStage = setDatosItemsStage;
	 }


	public String getMiconsecutivo() {
		return miconsecutivo;
	}


      public void setMiconsecutivo(String miconsecutivo) {
		this.miconsecutivo = miconsecutivo;
	}


	public String getMicantidad() {
		return micantidad;
	}


      public void setMicantidad(String micantidad) {
		this.micantidad = micantidad;
	}


      public String getMiitem() {
		return miitem;
	}


      public void setMiitem(String miitem) {
		this.miitem = miitem;
	}
	


	public String getConcecutivofinal() {
		return consecutivofinal;
	}


	public String setConcecutivofinal(String concecutivofinal) {
		return this.consecutivofinal = concecutivofinal;
	}


	public String getConcecutivo() {	
      return Concecutivo;
  	}


  	 public String setConcecutivo(String concecutivo) {
  		return Concecutivo = concecutivo;
  	}

	
 
  	 
	 public void setstyletextfield() {
		 estadoapro.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
		 solapro.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
		 areapro.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
		 cargoapro.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
		 fechasolapro.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
		 consecapro.setStyle (" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px;  -fx-text-fill: black;");
		 firmareq.setStyle(" -fx-background-color:#e66729; -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: white;");
	 }
	
	 public void generafirmarequisicion()throws IOException{
		 firmareq.setOnMouseClicked(e->{
		    cargo = AprobacionReqController.this.getCargo();
		    area= AprobacionReqController.this.getArea();
		    fechainiciof=AprobacionReqController.this.getFechainicio();
		    fechafinf=AprobacionReqController.this.getFechafin();
		    combocargo = cargo.getSelectionModel().getSelectedItem();
		    comboarea= area.getSelectionModel().getSelectedItem();
		    fechai= ((TextField)fechainiciof.getEditor()).getText();
		    fechaf=((TextField)fechafinf.getEditor()).getText();
			 for(Itemapro aprueba :itemsaprobados.getItems()) {
				midataitem= aprueba.getItemaprobado();
			 }
			 ObservableList<Itemapro> items = itemsaprobados.getItems();
			 if (items.isEmpty()) {
				Mensaje mensajedata = new Mensaje();
				mensajedata.mensaje(itemsaprobados, stackapro);
			 } 
			 else if(midataitem.equals("ITEM AUN SIN APROBACION")) {
				    Mensaje mensajedatat = new Mensaje();
					mensajedatat.marcadatos(stackapro);
			 }
			 else if (midataitem.equals("APROBADO")|| midataitem.contentEquals("NO APROBADO")){
			  try {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				imagenbuffer = SwingFXUtils.fromFXImage(firmadminreq.getImage(), null);
		        ImageIO.write(imagenbuffer, "jpg", outputStream );
	            outputStream.flush();
				byte[] Convierteimagenabytes = outputStream.toByteArray();
				outputStream.close();
				String data =consecapro.getText().toString();
				String SqlQuery="UPDATE ITEMSREQ SET FIRMA_APROBACION= ?  WHERE CNSREQ = ?";
				    Conexion Con = new Conexion();
	    	        Connection Conexion = null;
					Conexion=Con.miconexion(Conexion);
					PreparedStatement ps =Conexion.prepareStatement(SqlQuery);
					ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
					ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
			       	ps.setString(2, data);
			        ps.executeUpdate();
					Connection miconexionreq = null;
			    	try {
			    		miconexionreq=Con.miconexion(miconexionreq);
						CallableStatement apruebareqdetalle = miconexionreq.prepareCall("{call FIRMAREQUISICION(?)}");
						apruebareqdetalle.setString(1,data);
						apruebareqdetalle.execute();
						apruebareqdetalle.close();
				    	 
			    	}catch(SQLException ee) {
			    		ee.printStackTrace();
			    	}	
			        Text cabecera = new Text();
					cabecera.setText("DATOS ENVIADOS CON EXITO");
					cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
					Text mensaje= new Text();
					mensaje.setText("REQUISICION APROBADA");
					mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
					JFXDialogLayout contenido = new JFXDialogLayout();
				    contenido.setHeading((cabecera));
					contenido.setBody(mensaje);
					contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
					JFXDialog dialogo = new JFXDialog(stackapro,contenido, JFXDialog.DialogTransition.CENTER);
					JFXButton cerrar = new JFXButton("CERRAR");
					cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
					cerrar.setOnMouseClicked(e3->{
					dialogo.close();
					
					if(cargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&area.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainiciof.getEditor()).getText().isEmpty()&&!((TextField)fechafinf.getEditor()).getText().isEmpty())
					   {
				    		  try {
				    			    Connection Conexiontablarequi = null; 
				    	    		Datostablaproreqfechas= FXCollections.observableArrayList();
				    	    		String QueryFiltrof="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ?" ;
				    	    		Conexiontablarequi = Con.miconexion(Conexiontablarequi);
				    				PreparedStatement pss =Conexiontablarequi.prepareStatement(QueryFiltrof);
				    				pss.setString(1, fechai);
				    				pss.setString(2, fechaf);
				    		     	ResultSet rs = pss.executeQuery();
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
				    		        AprobacionReqController.this.getMytablereq().setItems(Datostablaproreqfechas);
				    				             }
			  	      }catch(SQLException mm) {
			  	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
			  		      }
				    	AprobacionReqController.this.getGetaproreqstage().close();
					     }
					
					  else if(cargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainiciof.getEditor()).getText().isEmpty()&&!((TextField)fechafinf.getEditor()).getText().isEmpty()) {
	     	    			 
	  	    	    		Datostablarequisicionesaprofechassinglemodel= FXCollections.observableArrayList();
	  	    	    		String QueryFiltroff="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO, CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND AREA = ?" ;
	  	    	    		try {
	  	    	    			Connection Conexiontablarequi = null; 
		  	    		        Conexiontablarequi =  Con.miconexion(Conexiontablarequi);
		  	    				PreparedStatement pss =Conexiontablarequi.prepareStatement(QueryFiltroff);
		  	    				pss.setString(1, fechai);
		  	    				pss.setString(2, fechaf);
		  	    				pss.setString(3, comboarea);
		  	    		     	ResultSet rs = pss.executeQuery();
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
		  	    		          AprobacionReqController.this.getMytablereq().setItems(Datostablarequisicionesaprofechassinglemodel);
		  	    				             }
		    	      }catch(SQLException mm) {   
		    	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
		    		   } 
	  	    	      	AprobacionReqController.this.getGetaproreqstage().close();
	    		     }
	      	 		   else if(area.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechainiciof.getEditor()).getText().isEmpty()&&!((TextField)fechafinf.getEditor()).getText().isEmpty()) {  
		    	    		 Datostablarequisicionesaprofechasmisingle= FXCollections.observableArrayList();
		    	    		String QueryFiltrof="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO = ? " ;
		    	    		try {
		    	    		Connection Conexiontablarequi = null; 
		    		    	Conexiontablarequi = Con.miconexion(Conexiontablarequi);
		    				PreparedStatement pss =Conexiontablarequi.prepareStatement(QueryFiltrof);
		    				pss.setString(1, fechai);
		    				pss.setString(2, fechaf);
		    				pss.setString(3, combocargo);
		    		     	ResultSet rs = pss.executeQuery();
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

			    		        AprobacionReqController.this.getMytablereq().setItems(Datostablarequisicionesaprofechasmisingle);
		    				             }
	  	      }catch(SQLException mm) {   
	  	    	  Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
	  		   } 
		    	    		AprobacionReqController.this.getGetaproreqstage().close();    		
	  		        }
					
	      	 		else if (cargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&area.getSelectionModel().getSelectedItem().equals("Sin Dato")&&((TextField)fechainiciof.getEditor()).getText().isEmpty()&&((TextField)fechafinf.getEditor()).getText().isEmpty()) {
	    	    	    try {
	    	    	    Connection Conexiontablarequi = null;
	    	    		Datostablarequisicionesaprof= FXCollections.observableArrayList();
	       	    		String QueryFiltro="SELECT CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONESDT.APROBACION=1 THEN 'REQUISICION APROBADA' ELSE 'AUN SIN APROBACION' END) ) AS ESTADO, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD, CNSREQ FROM REQUISICIONESDT" ;
	       	    		Conexiontablarequi =  Con.miconexion(Conexiontablarequi);
	       				PreparedStatement pss =Conexiontablarequi.prepareStatement(QueryFiltro);
	       		     	ResultSet rs = pss.executeQuery();
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
	       		         AprobacionReqController.this.getMytablereq().setItems(Datostablarequisicionesaprof);
	       				           }
	    	    	   }catch(SQLException mm) {
	    	    		   Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
	    	    		}
	    	    	    AprobacionReqController.this.getGetaproreqstage().close(); 
	    	    	   }
					});
					contenido.setActions(cerrar);
					dialogo.show();	 
				}catch(SQLException | IOException ee) {
		 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
				}
			 }
		 });
	   }

	    public void cargaitemsparaaprobacion() {
	    	cargatareqapro.setOnMouseClicked(e->{
	    		consecutivofinal=AprobacionReqController.this.getConcecutivofinal();
	    	try {
	    		Conexion Con = new Conexion();
	    		Connection Conexion=null;
	    		Conexion=Con.miconexion(Conexion);
   	       	    ObservableList<Itemapro> midatareqapro= FXCollections.observableArrayList();
   	       		String StringQueryGetData=" SELECT (CASE WHEN ITEMSREQ.ITEMAPROBADO IS NULL THEN 'ITEM AUN SIN APROBACION' WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'NO APROBADO' WHEN ITEMSREQ.ITEMAPROBADO=1  \r\n" + 
   	       				"   	       				 THEN 'APROBADO' END     ) AS ITEMAPROBADOREQ, ITEMSREQ.CANTIDAD, ITEMSREQ.ITEM  \r\n" + 
   	       				"   	       				 FROM ITEMSREQ \r\n" + 
   	       				"   	       				 INNER JOIN REQUISICIONESDT ON  REQUISICIONESDT.CNSREQ = ITEMSREQ.CNSREQ AND  \r\n" + 
   	       				"   	       				 CONVERT(varchar(16),REQUISICIONESDT.FECHA_SOLICITUD,20) =CONVERT( varchar(16), ITEMSREQ.FECHA_SOLICITUD,20 )  \r\n" + 
   	       				"   	       				 WHERE ITEMSREQ.CNSREQ='"+consecutivofinal+"'";
   	   			PreparedStatement ps =Conexion.prepareStatement(StringQueryGetData);
   	   	       	ResultSet rs = ps.executeQuery();
   	   	        while(rs.next()) {
   	   	           midatareqapro.add(new Itemapro(
   	   	        	      rs.getString("ITEM"),
   	        		      rs.getInt("CANTIDAD"),
   	        		      rs.getString("ITEMAPROBADOREQ")
                   		  )
   	                      );
   	   	     itemsaprobados.setItems(midatareqapro);
   	   		}
   	       	}catch(SQLException ee) {
   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
   	       	}
	    	});
	        }
	    
	    
	    public void detalleitem() {
	    	itemsaprobados.setOnMouseClicked(e->{
	    		
	    		FXMLLoader cargadatositems = new FXMLLoader(getClass().getResource("DatosItems.fxml"));
	    		try {
					cargadatositems.load();
				} catch (IOException e1) {
		 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e1);
				}
	    		Itemapro aprobacion=itemsaprobados.getSelectionModel().getSelectedItem();
	    		DatosItemsController datositems = cargadatositems.<DatosItemsController>getController();
	    		Integer cantidaddata=aprobacion.getCantidad();
	    		String cantidad = cantidaddata.toString();
	    		datositems.cantidad.setText(cantidad);
	    		String item = aprobacion.getItem();
	    		datositems.item.setText(item);
	    		String getitemmiitem=datositems.item.getText().toString();
	    		String getitemmicantidad=datositems.cantidad.getText().toString();
	    		AprobacionReqController.this.setMiitem(getitemmiitem);
	    		String gitem=AprobacionReqController.this.getMiitem();
	    		datositems.setGetmiitemfinal(gitem);
	    		AprobacionReqController.this.setMicantidad(getitemmicantidad);
	    		String gcantidad=AprobacionReqController.this.getMicantidad();
	    		datositems.setGetmicantidadfinal(gcantidad);
	    		String gconsecutivo=AprobacionReqController.this.consecapro.getText().toString();
	    	    AprobacionReqController.this.setMiconsecutivo(gconsecutivo);
	    	    String getconsecutivo = AprobacionReqController.this.getMiconsecutivo();
	    	    datositems.setGetmiconsecutivofinal(getconsecutivo);
	    	    AprobacionReqController.this.setMiitems(AprobacionReqController.this.itemsaprobados);
	    	    AprobacionReqController.this.getMiitems();
	    	    datositems.setMisitems(AprobacionReqController.this.getMiitems());
	    	    AprobacionReqController.this.setConcecutivofinal(consecutivofinal);
	    	    AprobacionReqController.this.getConcecutivofinal();
	    	    datositems.setConsecutivofinal(AprobacionReqController.this.getConcecutivofinal());
	   			Parent StackPane=cargadatositems.getRoot();
	   			StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	   			Stage itemsdetalle=new Stage();
	   			AprobacionReqController.this.setSetDatosItemsStage(itemsdetalle);
	   			Stage mifinalStage=AprobacionReqController.this.getSetDatosItemsStage();
	   			datositems.setGetDatosItemsStage(mifinalStage);
	   			itemsdetalle.setScene(new Scene(StackPane));
	   			itemsdetalle.setTitle("Items  Detalle");
	   			itemsdetalle.show();
	    	});
	    }
	    
	    
	public static void main(String[] args) {

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		miitemapro.setCellValueFactory(new PropertyValueFactory <Itemapro,String>("Item"));
		micantidadapro.setCellValueFactory(new PropertyValueFactory <Itemapro,Integer>("Cantidad"));
		estadoitem.setCellValueFactory(new PropertyValueFactory <Itemapro,String>("Itemaprobado"));
		cargaitemsparaaprobacion();
		detalleitem();
		setstyletextfield() ;
		 try {
			generafirmarequisicion();
		} catch (Exception e) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	@Override
	public void start(Stage arg0) throws Exception {
		
	}

}
