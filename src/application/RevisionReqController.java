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
import javafx.fxml.Initializable;
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

public class RevisionReqController extends Application implements Initializable{
	@FXML public JFXTextField reqcon ; 
	@FXML public JFXTextField solreqfield;  
	@FXML public JFXTextField areareqfield; 
	@FXML public JFXTextField cargoreqfield;  
	@FXML public JFXTextField fechasolreqfield;  
	@FXML public JFXTextField cantidadreqfield;  
	@FXML public JFXTextField descripcionreqfield; 
	@FXML public JFXTextField reqid;  
	@FXML public JFXTextArea observacionesreqfield;
	@FXML public StackPane stackrevreq;
	@FXML public JFXButton genrevreq;
	@FXML public JFXButton cargardatos;
	@FXML public JFXButton noaprobarrev;
	@FXML private  Label sollabel;
	@FXML private  Label obslabel;
	@FXML private  Label arlabel;
	@FXML private  Label Consecutivolabel;
	@FXML public Label  idlabel;
	@FXML private  Label crlabel;
	@FXML private  Label fslabel;
	@FXML private  Label cantidadlabel;
	@FXML private  Label desclabel;
	@FXML private  Label vobo;
	@FXML public TableView<Itemreq>itemsdetalle;
	@FXML public TableColumn<Itemreq,String>items;  
	@FXML public TableColumn<Itemreq,Integer>cantidad;
	public Stage thisstage;
	public ImageView getimagecaptura;
	public Connection Conexion = null;
	public BufferedImage imagenbuffer;
    public TableView<Requisiciones>  getmodeltable;
    public TableView<Requisiciones>  Getallmodeltable;
    public TableView<Requisiciones>  Getallmydatatable;
    public TableView<Requisiciones>  GetallmydatatableSingle;
	public DatePicker fechainicio;
    public JFXComboBox<String> cargos;
    public JFXComboBox<String> areac;
    public DatePicker fechaini;
    public String fini;
    public DatePicker fechafin;
    public String fechaf;
    public JFXComboBox<String> combocargo ;
    public String micombocargo;
    public JFXComboBox<String> comboarea;
    public String micomboarea;
    public String mireqid;
    public String micnsreq;
    public String micnsreq1;
    public String miidreq1;
    Conexion conectar = new Conexion();
    
    public String getMiidreq1() {
		return miidreq1;
	}

	public String setMiidreq1(String miidreq1) {
		return this.miidreq1 = miidreq1;
	}

	public String getMicnsreq1() {
		return micnsreq1;
	}

	public String setMicnsreq1(String micnsreq1) {
	 return this.micnsreq1 = micnsreq1;
	}

	public String getMicnsreq() {
		return micnsreq;
	}

	public void setMicnsreq(String micnsreq) {
		this.micnsreq = micnsreq;
	}

	public String getMireqid() {
		return mireqid;
	}

	public void setMireqid(String mireqid) {
		this.mireqid = mireqid;
	}

	public JFXComboBox<String> getCargos() {
		return cargos;
	}

	public void setCargos(JFXComboBox<String> cargos) {
		this.cargos = cargos;
	}

	public JFXComboBox<String> getAreac() {
		return areac;
	}

	public void setAreac(JFXComboBox<String> areac) {
		this.areac = areac;
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
 
    
	public TableView<Requisiciones> getGetmodeltable() {
	return getmodeltable;
    }

   public void setGetmodeltable(TableView<Requisiciones> getmodeltable) {
	this.getmodeltable = getmodeltable;
   }
   
	public Stage getThisstage() {
		return thisstage;
	}

	public Stage setThisstage(Stage thisstage) {
		return this.thisstage = thisstage;
	}
	
	
	 public void llenadatostablareq() {
		 cargardatos.setOnMouseClicked(e->{
		 String miid=RevisionReqController.this.getMiidreq1();
	     String cnsreq=RevisionReqController.this.getMicnsreq1();
 	     ObservableList<Itemreq> reqdata= FXCollections.observableArrayList();
	   		String Query= " SELECT ITEMSREQ.ITEM AS ITEM, ITEMSREQ.CANTIDAD AS CANTIDAD  \r\n" + 
	   				"	   				 FROM ITEMSREQ INNER JOIN REQUISICIONES  ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA  \r\n" + 
	   				"	   				 WHERE ITEMSREQ.CEDULA = REQUISICIONES.CEDULA AND REQUISICIONES.CARGO = ITEMSREQ.CARGO \r\n" + 
	   				"	   				 AND  ITEMSREQ.IDREQ IS NULL  AND ITEMSREQ.CNSREQ IS NULL AND REQUISICIONES.CNSREQ='"+cnsreq+"' \r\n" + 
	   				"	   				 AND REQUISICIONES.ID='"+miid+"' \r\n" + 
	   				"	   				 GROUP BY ITEMSREQ.ITEM,ITEMSREQ.CANTIDAD,REQUISICIONES.CEDULA, \r\n" + 
	   				"	   				 REQUISICIONES.CARGO,REQUISICIONES.SOLICITANTE , REQUISICIONES.FECHA_SOLICITUD, ITEMSREQ.FECHA_SOLICITUD  \r\n" + 
	   				"	   				 HAVING  CONVERT(varchar(16),REQUISICIONES.FECHA_SOLICITUD,20) = CONVERT(varchar(16),ITEMSREQ.FECHA_SOLICITUD,20)";
	   		Connection Conexiontabla = null;
	       	try {
	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	   	       	ResultSet rs = ps.executeQuery();
	   	        while(rs.next()) {
	   	        	reqdata.add(new Itemreq(
	   	        		    rs.getString("ITEM"),
	   	        		    rs.getInt("CANTIDAD")
	                   		 )
	                         );
	   	        	itemsdetalle.setItems(reqdata);
	   			 }
	       	}catch(SQLException ee) {
	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}
		 });
 	   }  
	
	 
	 

	public void generarrevision() throws IOException {
		genrevreq.setOnMouseClicked(e->{
			//-----------------------------------captura de variables------------------------------------------------//
			fechaini=RevisionReqController.this.getFechainicio();
			fini=((TextField)fechaini.getEditor()).getText();
			fechafin=RevisionReqController.this.getFechafin();
			fechaf=((TextField)fechafin.getEditor()).getText();
			combocargo = RevisionReqController.this.getCargos();
			micombocargo=combocargo.getSelectionModel().getSelectedItem();
			comboarea = RevisionReqController.this.getAreac();
			micomboarea=comboarea.getSelectionModel().getSelectedItem();
			//---------------------------------------fin captura-------------------------------------------------//
			//---------------------------------------------------inicio bloque if------------------------------//
			if(combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&((TextField)fechaini.getEditor()).getText().isEmpty()&&((TextField)fechafin.getEditor()).getText().isEmpty()) 
			{
				try {
					ObservableList<Requisiciones> datostabla= FXCollections.observableArrayList();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
			        ImageIO.write(imagenbuffer, "jpg", outputStream );
		            outputStream.flush();
					byte[] Convierteimagenabytes = outputStream.toByteArray();
					outputStream.close();
					String data =reqcon.getText().toString();
					String SqlQuery="UPDATE REQUISICIONES SET REVISION=1, FIRMA_REVISION= ? WHERE CNSREQ = ?";
					String Query=" SELECT \r\n" + 
							"CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  \r\n" + 
							"WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'     \r\n" + 
							"END) ) AS REVISION, \r\n" + 
							"(CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)   \r\n" + 
							"AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO, CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES ";
					Connection ConexionD = null;
					try {
						ConexionD=conectar.miconexion(ConexionD);
						PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
						ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
						ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
				       	ps.setString(2, data);
				        ps.executeUpdate();
				        PreparedStatement pss =ConexionD.prepareStatement(Query);
				        ResultSet rs = pss.executeQuery();
		   	   	        while(rs.next()) {
		   	   	        	datostabla.add(new Requisiciones(
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
				        Text cabecera = new Text();
						cabecera.setText("DATOS ENVIADOS CON EXITO");
						cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
						Text mensaje= new Text();
						mensaje.setText("REQUISICION EN ESTADO DE REVISION");
						mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
						JFXDialogLayout contenido = new JFXDialogLayout();
					    contenido.setHeading((cabecera));
						contenido.setBody(mensaje);
						contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
						JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
						JFXButton cerrar = new JFXButton("CERRAR");
						cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
						cerrar.setOnMouseClicked(e3->{
						dialogo.close();
						genrevreq.setDisable(true);
						RevisionReqController.this.getGetmodeltable().getItems().clear();
			   	        RevisionReqController.this.getGetmodeltable().setItems(datostabla);
						RevisionReqController.this.getThisstage().close();
						String data1=RevisionReqController.this.getMicnsreq();
						String data2=RevisionReqController.this.getMireqid();
						Integer midata=Integer.parseInt(data2);
						Connection redireccionreq = null;
				    	try {
				    		redireccionreq=conectar.miconexion(redireccionreq);
							CallableStatement reqdetalle = redireccionreq.prepareCall("{call INSERTAREQ(?,?)}");
							reqdetalle.setString(1,data1);
							reqdetalle.setInt(2,midata);
							reqdetalle.execute();
							reqdetalle.close();
				    	}catch(SQLException ee) {
				    		ee.printStackTrace();
				    	}	
						});
						contenido.setActions(cerrar);
						dialogo.show();	
				}catch(SQLException ee) {
					ee.printStackTrace();
				}
					reqid.clear();
					reqcon.clear();	
					solreqfield.clear();
					areareqfield.clear();
					cargoreqfield.clear();
					fechasolreqfield.clear();
					cantidadreqfield.clear();
					descripcionreqfield.clear();
					descripcionreqfield.clear();
					observacionesreqfield.clear();
					getimagecaptura.setImage(null);
				}catch(NullPointerException | IOException m) {
					if(imagenbuffer ==null) {
					
				    Mensaje data = new Mensaje();
					data.validacion(stackrevreq);
					
					}
				}
	        }
			//--------------------------------------------------------------------fin bloque if  ok--------------------------------------------------------------------//
			//------------------------------------------------------segundo bloque else if-------------------------------------------------------------------------------------------------------------------------------------------------------//
			// 2----------------------------------------------------------valida que todos los filtros esten y devuelve la misma tabla----------------------------------------------------/
			else if(!combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty()) 
				{
				try {
					ObservableList<Requisiciones> datostablaAll= FXCollections.observableArrayList();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
			        ImageIO.write(imagenbuffer, "jpg", outputStream );
		            outputStream.flush();
					byte[] Convierteimagenabytes = outputStream.toByteArray();
					outputStream.close();
					String data =reqcon.getText().toString();
					String SqlQuery="UPDATE REQUISICIONES SET REVISION=1, FIRMA_REVISION= ? WHERE CNSREQ = ?";
					String Query= "SELECT \r\n" + 
							"CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  \r\n" + 
							"WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'     \r\n" + 
							"END) ) AS REVISION, \r\n" + 
							"(CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)   \r\n" + 
							"AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES \r\n" + 
							"WHERE CONVERT(DATE,FECHA_SOLICITUD,103) >= ?   AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO = ? AND AREA = ?";
					Connection ConexionD = null;
					try {
						ConexionD=conectar.miconexion(ConexionD);
						PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
						ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
						ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
				       	ps.setString(2, data);
				        ps.executeUpdate();
				        PreparedStatement pss =ConexionD.prepareStatement(Query);
						pss.setString(1, fini);
						pss.setString(2, fechaf);
				        pss.setString(3,micombocargo);
				        pss.setString(4,micomboarea);
				        ResultSet rs = pss.executeQuery();
		   	   	        while(rs.next()) {
		   	   	        	datostablaAll.add(new Requisiciones(
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
				        Text cabecera = new Text();
						cabecera.setText("DATOS ENVIADOS CON EXITO");
						cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
						Text mensaje= new Text();
						mensaje.setText("REQUISICION EN ESTADO DE REVISION");
						mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
						JFXDialogLayout contenido = new JFXDialogLayout();
					    contenido.setHeading((cabecera));
						contenido.setBody(mensaje);
						contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
						JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
						JFXButton cerrar = new JFXButton("CERRAR");
						cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
						cerrar.setOnMouseClicked(e3->{
						dialogo.close();
						genrevreq.setDisable(true);
						RevisionReqController.this.getGetmodeltable().getItems().clear();
			   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAll);
						RevisionReqController.this.getThisstage().close();
						String data1=RevisionReqController.this.getMicnsreq();
						String data2=RevisionReqController.this.getMireqid();
						Integer midata=Integer.parseInt(data2);
						Connection redireccionreq = null;
				    	try {
				    		redireccionreq=conectar.miconexion(redireccionreq);
							CallableStatement reqdetalle = redireccionreq.prepareCall("{call INSERTAREQ(?,?)}");
							reqdetalle.setString(1,data1);
							reqdetalle.setInt(2,midata);
							reqdetalle.execute();
							reqdetalle.close();
				    	}catch(SQLException ee) {
				    		ee.printStackTrace();
				    	}	
						});
						contenido.setActions(cerrar);
						dialogo.show();	
				
				}catch(SQLException ee) {
					ee.printStackTrace();
				}
					reqid.clear();
					reqcon.clear();	
					solreqfield.clear();
					areareqfield.clear();
					cargoreqfield.clear();
					fechasolreqfield.clear();
					cantidadreqfield.clear();
					descripcionreqfield.clear();
					descripcionreqfield.clear();
					observacionesreqfield.clear();
					getimagecaptura.setImage(null);
				}catch(NullPointerException | IOException m) {
					if(imagenbuffer ==null) {
						    
						    Mensaje data = new Mensaje();
							data.validacion(stackrevreq);
			
					}
				}
				}
			   //3----------------------------------------------------------------fin segundo bloque else if--------------------------------------------------------------------------------------------//
				else if(combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty())
				{
						try {
							ObservableList<Requisiciones> datostablaAllmydata= FXCollections.observableArrayList();
							ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
					        ImageIO.write(imagenbuffer, "jpg", outputStream );
				            outputStream.flush();
							byte[] Convierteimagenabytes = outputStream.toByteArray();
							outputStream.close();
							String data =reqcon.getText().toString();
							String SqlQuery="UPDATE REQUISICIONES SET REVISION=1, FIRMA_REVISION= ? WHERE CNSREQ = ?";
							String Query= "SELECT \r\n" + 
									"CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO' \r\n" + 
									"WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'    \r\n" + 
									"END) ) AS REVISION, \r\n" + 
									"(CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  \r\n" + 
									"AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES \r\n" + 
									"WHERE CONVERT(DATE,FECHA_SOLICITUD,103) >= ' +fini+ '  AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ' +fechaf+ '  ";
							Connection ConexionD = null;
							try {
								ConexionD=conectar.miconexion(ConexionD);
								PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
								ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
								ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
						       	ps.setString(2, data);
						        ps.executeUpdate();
						        PreparedStatement pss =ConexionD.prepareStatement(Query);
						        ResultSet rs = pss.executeQuery();
				   	   	        while(rs.next()) {
				   	   	        datostablaAllmydata.add(new Requisiciones(
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
						        Text cabecera = new Text();
								cabecera.setText("DATOS ENVIADOS CON EXITO");
								cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
								Text mensaje= new Text();
								mensaje.setText("REQUISICION EN ESTADO DE REVISION");
								mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
								JFXDialogLayout contenido = new JFXDialogLayout();
							    contenido.setHeading((cabecera));
								contenido.setBody(mensaje);
								contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
								JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
								JFXButton cerrar = new JFXButton("CERRAR");
								cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
								cerrar.setOnMouseClicked(e3->{
								dialogo.close();
								genrevreq.setDisable(true);
								RevisionReqController.this.getGetmodeltable().getItems().clear();
					   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAllmydata);
								RevisionReqController.this.getThisstage().close();
								String data1=RevisionReqController.this.getMicnsreq();
								String data2=RevisionReqController.this.getMireqid();
								Integer midata=Integer.parseInt(data2);
								Connection redireccionreq = null;
						    	try {
						    		redireccionreq=conectar.miconexion(redireccionreq);
									CallableStatement reqdetalle = redireccionreq.prepareCall("{call INSERTAREQ(?,?)}");
									reqdetalle.setString(1,data1);
									reqdetalle.setInt(2,midata);
									reqdetalle.execute();
									reqdetalle.close();
						    	}catch(SQLException ee) {
						    		ee.printStackTrace();
						    	}	
								});
								contenido.setActions(cerrar);
								dialogo.show();	
							
						}catch(SQLException ee) {
							ee.printStackTrace();
						}
							reqid.clear();
							reqcon.clear();	
							solreqfield.clear();
							areareqfield.clear();
							cargoreqfield.clear();
							fechasolreqfield.clear();
							cantidadreqfield.clear();
							descripcionreqfield.clear();
							descripcionreqfield.clear();
							observacionesreqfield.clear();
							getimagecaptura.setImage(null);
						}catch(NullPointerException | IOException m) {
							if(imagenbuffer ==null) {
							
								    Mensaje data = new Mensaje();
									data.validacion(stackrevreq);
							}
						}
					}
			//4
				else if(!combocargo.getSelectionModel().getSelectedItem().isEmpty()&&comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty()) {
					try {
						ObservableList<Requisiciones> datostablaAllmydataSingle= FXCollections.observableArrayList();
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
				        ImageIO.write(imagenbuffer, "jpg", outputStream );
			            outputStream.flush();
						byte[] Convierteimagenabytes = outputStream.toByteArray();
						outputStream.close();
						String data =reqcon.getText().toString();
						String SqlQuery="UPDATE REQUISICIONES SET REVISION=1, FIRMA_REVISION= ? WHERE CNSREQ = ?";
						String Query= "SELECT \r\n" + 
								"CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  \r\n" + 
								"WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'     \r\n" + 
								"END) ) AS REVISION, \r\n" + 
								"(CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)   \r\n" + 
								"AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES \r\n" + 
								"WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO= ? " ;
	  	    	        Connection ConexionD = null;
						try {
							ConexionD=conectar.miconexion(ConexionD);
							PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
							ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
							ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
					       	ps.setString(2, data);
					        ps.executeUpdate();
					        PreparedStatement pss =ConexionD.prepareStatement(Query);
							pss.setString(1, fini);
							pss.setString(2, fechaf);
							pss.setString(3,micombocargo);
					        ResultSet rs = pss.executeQuery();
			   	   	        while(rs.next()) {
			   	   	        datostablaAllmydataSingle.add(new Requisiciones(
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
					        Text cabecera = new Text();
							cabecera.setText("DATOS ENVIADOS CON EXITO");
							cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
							Text mensaje= new Text();
							mensaje.setText("REQUISICION EN ESTADO DE REVISION");
							mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
							JFXDialogLayout contenido = new JFXDialogLayout();
						    contenido.setHeading((cabecera));
							contenido.setBody(mensaje);
							contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
							JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
							JFXButton cerrar = new JFXButton("CERRAR");
							cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
							cerrar.setOnMouseClicked(e3->{
							dialogo.close();
							genrevreq.setDisable(true);
							RevisionReqController.this.getGetmodeltable().getItems().clear();
				   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAllmydataSingle);
							RevisionReqController.this.getThisstage().close();
							String data1=RevisionReqController.this.getMicnsreq();
							String data2=RevisionReqController.this.getMireqid();
							Integer midata=Integer.parseInt(data2);
							Connection redireccionreq = null;
					    	try {
					    		redireccionreq=conectar.miconexion(redireccionreq);
								CallableStatement reqdetalle = redireccionreq.prepareCall("{call INSERTAREQ(?,?)}");
								reqdetalle.setString(1,data1);
								reqdetalle.setInt(2,midata);
								reqdetalle.execute();
								reqdetalle.close();
					    	}catch(SQLException ee) {
					    		ee.printStackTrace();
					    	}	
							});
							contenido.setActions(cerrar);
							dialogo.show();	
						
					}catch(SQLException ee) {
						ee.printStackTrace();
					}
						reqid.clear();
						reqcon.clear();	
						solreqfield.clear();
						areareqfield.clear();
						cargoreqfield.clear();
						fechasolreqfield.clear();
						cantidadreqfield.clear();
						descripcionreqfield.clear();
						descripcionreqfield.clear();
						observacionesreqfield.clear();
						getimagecaptura.setImage(null);
					}catch(NullPointerException | IOException m) {
						if(imagenbuffer ==null) {
							Mensaje data = new Mensaje();
							data.validacion(stackrevreq);
						
						}
					}
				}
			   //5
				else if(!comboarea.getSelectionModel().getSelectedItem().isEmpty()&&combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty()) {
					try {
						ObservableList<Requisiciones> datostablaAllmydataSingledata= FXCollections.observableArrayList();
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
				        ImageIO.write(imagenbuffer, "jpg", outputStream );
			            outputStream.flush();
						byte[] Convierteimagenabytes = outputStream.toByteArray();
						outputStream.close();
						String data =reqcon.getText().toString();
						String SqlQuery="UPDATE REQUISICIONES SET REVISION=1, FIRMA_REVISION= ? WHERE CNSREQ = ?";
						String Query= " SELECT \r\n" + 
								"CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO'  \r\n" + 
								"WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'     \r\n" + 
								"END) ) AS REVISION, \r\n" + 
								"(CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)   \r\n" + 
								"AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES \r\n" + 
								"WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND AREA= ?  \r\n" + 
								"" ;
	  	    	        Connection ConexionD = null;
						try {
							ConexionD=conectar.miconexion(ConexionD);
							PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
							ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
							ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
					       	ps.setString(2, data);
					        ps.executeUpdate();
					        PreparedStatement pss =ConexionD.prepareStatement(Query);
							pss.setString(1, fini);
							pss.setString(2, fechaf);
							pss.setString(3,micomboarea);
					        ResultSet rs = pss.executeQuery();
			   	   	        while(rs.next()) {
			   	   	      datostablaAllmydataSingledata.add(new Requisiciones(
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
					        Text cabecera = new Text();
							cabecera.setText("DATOS ENVIADOS CON EXITO");
							cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
							Text mensaje= new Text();
							mensaje.setText("REQUISICION EN ESTADO DE REVISION");
							mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
							JFXDialogLayout contenido = new JFXDialogLayout();
						    contenido.setHeading((cabecera));
							contenido.setBody(mensaje);
							contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
							JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
							JFXButton cerrar = new JFXButton("CERRAR");
							cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
							cerrar.setOnMouseClicked(e3->{
							dialogo.close();
							genrevreq.setDisable(true);
							RevisionReqController.this.getGetmodeltable().getItems().clear();
				   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAllmydataSingledata);
							RevisionReqController.this.getThisstage().close();
							String data1=RevisionReqController.this.getMicnsreq();
							String data2=RevisionReqController.this.getMireqid();
							Integer midata=Integer.parseInt(data2);
							Connection redireccionreq = null;
					    	try {
					    		redireccionreq=conectar.miconexion(redireccionreq);
								CallableStatement reqdetalle = redireccionreq.prepareCall("{call INSERTAREQ(?,?)}");
								reqdetalle.setString(1,data1);
								reqdetalle.setInt(2,midata);
								reqdetalle.execute();
								reqdetalle.close();
					    	}catch(SQLException ee) {
					    		ee.printStackTrace();
					    	}	
							});
							contenido.setActions(cerrar);
							dialogo.show();	
					}catch(SQLException ee) {
						ee.printStackTrace();
					}
						reqid.clear();
						reqcon.clear();	
						solreqfield.clear();
						areareqfield.clear();
						cargoreqfield.clear();
						fechasolreqfield.clear();
						cantidadreqfield.clear();
						descripcionreqfield.clear();
						descripcionreqfield.clear();
						observacionesreqfield.clear();
						getimagecaptura.setImage(null);
					}catch(NullPointerException | IOException m) {
						if(imagenbuffer ==null) {
							Mensaje data = new Mensaje();
							data.validacion(stackrevreq);
						}
					}
				}

			});
	       }
	
	
	public void noaprobarrevisionreq() {
		noaprobarrev.setOnAction(e->{
			//-----------------------------------captura de variables------------------------------------------------//
			fechaini=RevisionReqController.this.getFechainicio();
			fini=((TextField)fechaini.getEditor()).getText();
			fechafin=RevisionReqController.this.getFechafin();
			fechaf=((TextField)fechafin.getEditor()).getText();
			combocargo = RevisionReqController.this.getCargos();
			micombocargo=combocargo.getSelectionModel().getSelectedItem();
			comboarea = RevisionReqController.this.getAreac();
			micomboarea=comboarea.getSelectionModel().getSelectedItem();
			//---------------------------------------fin captura-------------------------------------------------//
			//---------------------------------------------------inicio bloque if------------------------------//
			if(combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&((TextField)fechaini.getEditor()).getText().isEmpty()&&((TextField)fechafin.getEditor()).getText().isEmpty()) 
			{
				try {
					ObservableList<Requisiciones> datostabla= FXCollections.observableArrayList();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
			        ImageIO.write(imagenbuffer, "jpg", outputStream );
		            outputStream.flush();
					byte[] Convierteimagenabytes = outputStream.toByteArray();
					outputStream.close();
					String data =reqcon.getText().toString();
					String SqlQuery="UPDATE REQUISICIONES SET REVISION=2, FIRMA_REVISION= ? WHERE CNSREQ = ?";
					String Query="SELECT\r\n" + 
							" CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO' \r\n" + 
							"                            WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'    \r\n" + 
							" END) ) AS REVISION,\r\n" + 
							" (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  \r\n" + 
							" AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO, CENTRO_OPERACION, FROM REQUISICIONES";
					Connection ConexionD = null;
					try {
						ConexionD=conectar.miconexion(ConexionD);
						PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
						ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
						ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
				       	ps.setString(2, data);
				        ps.executeUpdate();
				        PreparedStatement pss =ConexionD.prepareStatement(Query);
				        ResultSet rs = pss.executeQuery();
		   	   	        while(rs.next()) {
		   	   	        	datostabla.add(new Requisiciones(
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
				        Text cabecera = new Text();
						cabecera.setText("REQUISICION RECHAZA");
						cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
						Text mensaje= new Text();
						mensaje.setText("REQUISICION NO APROBADA");
						mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
						JFXDialogLayout contenido = new JFXDialogLayout();
					    contenido.setHeading((cabecera));
						contenido.setBody(mensaje);
						contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
						JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
						JFXButton cerrar = new JFXButton("CERRAR");
						cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
						cerrar.setOnMouseClicked(e3->{
						dialogo.close();
						genrevreq.setDisable(true);
						RevisionReqController.this.getGetmodeltable().getItems().clear();
			   	        RevisionReqController.this.getGetmodeltable().setItems(datostabla);
						RevisionReqController.this.getThisstage().close();
						});
						contenido.setActions(cerrar);
						dialogo.show();	
				}catch(SQLException ee) {
					ee.printStackTrace();
				}
					reqid.clear();
					reqcon.clear();	
					solreqfield.clear();
					areareqfield.clear();
					cargoreqfield.clear();
					fechasolreqfield.clear();
					cantidadreqfield.clear();
					descripcionreqfield.clear();
					descripcionreqfield.clear();
					observacionesreqfield.clear();
					getimagecaptura.setImage(null);
				}catch(NullPointerException | IOException m) {
					if(imagenbuffer ==null) {
					
				    Mensaje data = new Mensaje();
					data.validacion(stackrevreq);
					
					}
				}
	        }
			//--------------------------------------------------------------------fin bloque if  ok--------------------------------------------------------------------//
			//------------------------------------------------------segundo bloque else if-------------------------------------------------------------------------------------------------------------------------------------------------------//
			// 2----------------------------------------------------------valida que todos los filtros esten y devuelve la misma tabla----------------------------------------------------/
			else if(!combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty()) 
				{
				try {
					ObservableList<Requisiciones> datostablaAll= FXCollections.observableArrayList();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
			        ImageIO.write(imagenbuffer, "jpg", outputStream );
		            outputStream.flush();
					byte[] Convierteimagenabytes = outputStream.toByteArray();
					outputStream.close();
					String data =reqcon.getText().toString();
					String SqlQuery="UPDATE REQUISICIONES SET REVISION=2, FIRMA_REVISION= ? WHERE CNSREQ = ?";
					String Query= "SELECT\r\n" + 
							" CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO' \r\n" + 
							"                            WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'    \r\n" + 
							" END) ) AS REVISION,\r\n" + 
							" (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  \r\n" + 
							" AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES\r\n" + 
							" WHERE CONVERT(DATE,FECHA_SOLICITUD,103) >= ?   AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO = ? AND AREA = ?";
					Connection ConexionD = null;
					try {
						ConexionD=conectar.miconexion(ConexionD);
						PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
						ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
						ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
				       	ps.setString(2, data);
				        ps.executeUpdate();
				        PreparedStatement pss =ConexionD.prepareStatement(Query);
						pss.setString(1, fini);
						pss.setString(2, fechaf);
				        pss.setString(3,micombocargo);
				        pss.setString(4,micomboarea);
				        ResultSet rs = pss.executeQuery();
		   	   	        while(rs.next()) {
		   	   	        	datostablaAll.add(new Requisiciones(
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
				        Text cabecera = new Text();
						cabecera.setText("REQUISICION RECHAZADA");
						cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
						Text mensaje= new Text();
						mensaje.setText("REQUISICION NO APROBADA");
						mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
						JFXDialogLayout contenido = new JFXDialogLayout();
					    contenido.setHeading((cabecera));
						contenido.setBody(mensaje);
						contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
						JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
						JFXButton cerrar = new JFXButton("CERRAR");
						cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
						cerrar.setOnMouseClicked(e3->{
						dialogo.close();
						genrevreq.setDisable(true);
						RevisionReqController.this.getGetmodeltable().getItems().clear();
			   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAll);
						RevisionReqController.this.getThisstage().close();
						});
						contenido.setActions(cerrar);
						dialogo.show();	
					}catch(SQLException ee) {
					ee.printStackTrace();
				}
					reqid.clear();
					reqcon.clear();	
					solreqfield.clear();
					areareqfield.clear();
					cargoreqfield.clear();
					fechasolreqfield.clear();
					cantidadreqfield.clear();
					descripcionreqfield.clear();
					descripcionreqfield.clear();
					observacionesreqfield.clear();
					getimagecaptura.setImage(null);
				}catch(NullPointerException | IOException m) {
					if(imagenbuffer ==null) {
						    
						    Mensaje data = new Mensaje();
							data.validacion(stackrevreq);
			
					}
				}
				}
			   //3----------------------------------------------------------------fin segundo bloque else if--------------------------------------------------------------------------------------------//
				else if(combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty())
				{
						try {
							ObservableList<Requisiciones> datostablaAllmydata= FXCollections.observableArrayList();
							ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
					        ImageIO.write(imagenbuffer, "jpg", outputStream );
				            outputStream.flush();
							byte[] Convierteimagenabytes = outputStream.toByteArray();
							outputStream.close();
							String data =reqcon.getText().toString();
							String SqlQuery="UPDATE REQUISICIONES SET REVISION=2, FIRMA_REVISION= ? WHERE CNSREQ = ?";
							String Query= "SELECT\r\n" + 
									" CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO' \r\n" + 
									"                            WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'    \r\n" + 
									" END) ) AS REVISION,\r\n" + 
									" (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  \r\n" + 
									" AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES\r\n" + 
									"WHERE CONVERT(DATE,FECHA_SOLICITUD,103) >= '"+fini+"'  AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= '"+fechaf+"' ";
							Connection ConexionD = null;
							try {
								ConexionD=conectar.miconexion(ConexionD);
								PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
								ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
								ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
						       	ps.setString(2, data);
						        ps.executeUpdate();
						        PreparedStatement pss =ConexionD.prepareStatement(Query);
						        ResultSet rs = pss.executeQuery();
				   	   	        while(rs.next()) {
				   	   	        datostablaAllmydata.add(new Requisiciones(
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
						        Text cabecera = new Text();
								cabecera.setText("REQUISICION RECHAZADA");
								cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
								Text mensaje= new Text();
								mensaje.setText("REQUISICION NO APROBADA");
								mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
								JFXDialogLayout contenido = new JFXDialogLayout();
							    contenido.setHeading((cabecera));
								contenido.setBody(mensaje);
								contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
								JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
								JFXButton cerrar = new JFXButton("CERRAR");
								cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
								cerrar.setOnMouseClicked(e3->{
								dialogo.close();
								genrevreq.setDisable(true);
								RevisionReqController.this.getGetmodeltable().getItems().clear();
					   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAllmydata);
								RevisionReqController.this.getThisstage().close();
								});
								contenido.setActions(cerrar);
								dialogo.show();	
							
						}catch(SQLException ee) {
							ee.printStackTrace();
						}
							reqid.clear();
							reqcon.clear();	
							solreqfield.clear();
							areareqfield.clear();
							cargoreqfield.clear();
							fechasolreqfield.clear();
							cantidadreqfield.clear();
							descripcionreqfield.clear();
							descripcionreqfield.clear();
							observacionesreqfield.clear();
							getimagecaptura.setImage(null);
						}catch(NullPointerException | IOException m) {
							if(imagenbuffer ==null) {
							
								    Mensaje data = new Mensaje();
									data.validacion(stackrevreq);
							}
						}
					}
			//4
				else if(!combocargo.getSelectionModel().getSelectedItem().isEmpty()&&comboarea.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty()) {
					try {
						ObservableList<Requisiciones> datostablaAllmydataSingle= FXCollections.observableArrayList();
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
				        ImageIO.write(imagenbuffer, "jpg", outputStream );
			            outputStream.flush();
						byte[] Convierteimagenabytes = outputStream.toByteArray();
						outputStream.close();
						String data =reqcon.getText().toString();
						String SqlQuery="UPDATE REQUISICIONES SET REVISION=2, FIRMA_REVISION= ? WHERE CNSREQ = ?";
						String Query= "SELECT\r\n" + 
								" CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO' \r\n" + 
								"                            WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'    \r\n" + 
								" END) ) AS REVISION,\r\n" + 
								" (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  \r\n" + 
								" AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO,CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES\r\n" + 
								"WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND CARGO= ?" ;
	  	    	        Connection ConexionD = null;
						try {
							ConexionD=conectar.miconexion(ConexionD);
							PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
							ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
							ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
					       	ps.setString(2, data);
					        ps.executeUpdate();
					        PreparedStatement pss =ConexionD.prepareStatement(Query);
							pss.setString(1, fini);
							pss.setString(2, fechaf);
							pss.setString(3,micombocargo);
					        ResultSet rs = pss.executeQuery();
			   	   	        while(rs.next()) {
			   	   	        datostablaAllmydataSingle.add(new Requisiciones(
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
					        Text cabecera = new Text();
							cabecera.setText("REQUISICION RECHAZADA");
							cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
							Text mensaje= new Text();
							mensaje.setText("REQUISICION NO APROBADA");
							mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
							JFXDialogLayout contenido = new JFXDialogLayout();
						    contenido.setHeading((cabecera));
							contenido.setBody(mensaje);
							contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
							JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
							JFXButton cerrar = new JFXButton("CERRAR");
							cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
							cerrar.setOnMouseClicked(e3->{
							dialogo.close();
							genrevreq.setDisable(true);
							RevisionReqController.this.getGetmodeltable().getItems().clear();
				   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAllmydataSingle);
							RevisionReqController.this.getThisstage().close();
							});
							contenido.setActions(cerrar);
							dialogo.show();	
						
					}catch(SQLException ee) {
						ee.printStackTrace();
					}
						reqid.clear();
						reqcon.clear();	
						solreqfield.clear();
						areareqfield.clear();
						cargoreqfield.clear();
						fechasolreqfield.clear();
						cantidadreqfield.clear();
						descripcionreqfield.clear();
						descripcionreqfield.clear();
						observacionesreqfield.clear();
						getimagecaptura.setImage(null);
					}catch(NullPointerException | IOException m) {
						if(imagenbuffer ==null) {
							Mensaje data = new Mensaje();
							data.validacion(stackrevreq);
						
						}
					}
				}
			   //5
				else if(!comboarea.getSelectionModel().getSelectedItem().isEmpty()&&combocargo.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaini.getEditor()).getText().isEmpty()&&!((TextField)fechafin.getEditor()).getText().isEmpty()) {
					try {
						ObservableList<Requisiciones> datostablaAllmydataSingledata= FXCollections.observableArrayList();
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						imagenbuffer = SwingFXUtils.fromFXImage(getimagecaptura.getImage(), null);
				        ImageIO.write(imagenbuffer, "jpg", outputStream );
			            outputStream.flush();
						byte[] Convierteimagenabytes = outputStream.toByteArray();
						outputStream.close();
						String data =reqcon.getText().toString();
						String SqlQuery="UPDATE REQUISICIONES SET REVISION=2, FIRMA_REVISION= ? WHERE CNSREQ = ?";
						String Query= "SELECT\r\n" + 
								" CONVERT (VARCHAR(30),(CASE WHEN REQUISICIONES.REVISION=1 THEN 'REVISADO' \r\n" + 
								"                            WHEN REQUISICIONES.REVISION=2 THEN 'REVISADO Y NO APROBADO' ELSE 'SIN REVISION'    \r\n" + 
								" END) ) AS REVISION,\r\n" + 
								" (CASE WHEN COALESCE (REQUISICIONES.APROBACION,'0')='' THEN 'SIN APROBACION' ELSE 'APROBADO' END)  \r\n" + 
								" AS APROBACION, ID, CNSREQ, SOLICITANTE, AREA, CARGO, CENTRO_OPERACION, FECHA_SOLICITUD FROM REQUISICIONES\r\n" + 
								"WHERE  CONVERT(DATE,FECHA_SOLICITUD,103) >= ? AND  CONVERT(DATE,FECHA_SOLICITUD,103)  <= ? AND AREA= ? \r\n" + 
								"" ;
	  	    	        Connection ConexionD = null;
						try {
							ConexionD=conectar.miconexion(ConexionD);
							PreparedStatement ps =ConexionD.prepareStatement(SqlQuery);
							ByteArrayInputStream inputimagen = new ByteArrayInputStream(Convierteimagenabytes);
							ps.setBinaryStream(1, inputimagen, Convierteimagenabytes.length);
					       	ps.setString(2, data);
					        ps.executeUpdate();
					        PreparedStatement pss =ConexionD.prepareStatement(Query);
							pss.setString(1, fini);
							pss.setString(2, fechaf);
							pss.setString(3,micomboarea);
					        ResultSet rs = pss.executeQuery();
			   	   	        while(rs.next()) {
			   	   	      datostablaAllmydataSingledata.add(new Requisiciones(
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
					        Text cabecera = new Text();
							cabecera.setText("DATOS ENVIADOS CON EXITO");
							cabecera.setStyle("-fx-fill:red;-fx-font-weight:bold");
							Text mensaje= new Text();
							mensaje.setText("REQUISICION EN ESTADO DE REVISION");
							mensaje.setStyle("-fx-fill:black;-fx-font-weight:bold");
							JFXDialogLayout contenido = new JFXDialogLayout();
						    contenido.setHeading((cabecera));
							contenido.setBody(mensaje);
							contenido.setStyle(" -fx-background-color:  linear-gradient( from 0.0% 0.0% to 100.0% 100.0%, rgb(153,204,153) 0.0, rgb(153,204,153) 100.0);");
							JFXDialog dialogo = new JFXDialog(stackrevreq,contenido, JFXDialog.DialogTransition.CENTER);
							JFXButton cerrar = new JFXButton("CERRAR");
							cerrar.setStyle(" -fx-background-color: white;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
							cerrar.setOnMouseClicked(e3->{
							dialogo.close();
							genrevreq.setDisable(true);
							RevisionReqController.this.getGetmodeltable().getItems().clear();
				   	        RevisionReqController.this.getGetmodeltable().setItems(datostablaAllmydataSingledata);
							RevisionReqController.this.getThisstage().close();
							});
							contenido.setActions(cerrar);
							dialogo.show();	
					}catch(SQLException ee) {
						ee.printStackTrace();
					}
						reqid.clear();
						reqcon.clear();	
						solreqfield.clear();
						areareqfield.clear();
						cargoreqfield.clear();
						fechasolreqfield.clear();
						cantidadreqfield.clear();
						descripcionreqfield.clear();
						descripcionreqfield.clear();
						observacionesreqfield.clear();
						getimagecaptura.setImage(null);
					}catch(NullPointerException | IOException m) {
						if(imagenbuffer ==null) {
							Mensaje data = new Mensaje();
							data.validacion(stackrevreq);
						}
					}
				}

			});
		
	       }
	
	public static void main(String[] args) {
	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		items.setCellValueFactory(new PropertyValueFactory <Itemreq,String>("Item"));
		cantidad.setCellValueFactory(new PropertyValueFactory <Itemreq,Integer>("Cantidad"));
		llenadatostablareq();
		noaprobarrevisionreq();
		
		try {
			generarrevision();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
	}
}