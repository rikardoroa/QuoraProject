package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class DetalleFechaItemsController extends Application implements Initializable {

	@FXML StackPane stackpanefinalitems;
	@FXML public JFXTextField consecutivoreqaprofinal;
	@FXML public JFXTextField solicitantereaprofinal;
	@FXML public JFXTextField areareqaprofinalitems;
	@FXML public JFXTextField cargoreqaprofinalitems;
	@FXML public JFXTextField fecaprobacionreqaprofinalitems;
	@FXML public JFXTextField itemsreqaprofinalitems;
	@FXML public JFXTextField itemsresnoaprofinalitems;
	@FXML public JFXTextField fechaentregafinalitems;
	@FXML public JFXButton generareqfinal;
	@FXML public Label consecutivolabel;
	@FXML public Label solicitantelabel;
	@FXML public Label arealabel;
	@FXML public Label cargolabel;
	@FXML public Label fechaprobacionlabel;
	@FXML public Label itemsaprobadoslabel;
	@FXML public Label itemsnoaprobadoslabel;
	@FXML private BorderPane borderpanereqmiaprofinalapro;
	public XWPFParagraph parrafo;
    public XWPFParagraph parrafoen;
    public XWPFParagraph parrafo2;
    public XWPFParagraph parrafo3;
    public XWPFParagraph parrafo4;
    public XWPFParagraph parrafo5;
    public XWPFParagraph parrafo6;
    public XWPFParagraph parrafo7;
    public XWPFParagraph parrafo8;
    public XWPFParagraph parrafo9;
    public XWPFParagraph parrafo10;
    public XWPFParagraph parrafo11;
    public XWPFParagraph parrafo12;
    public XWPFParagraph parrafo13;
    public XWPFParagraph parrafo14;
    public XWPFParagraph parrafo15;
    public XWPFParagraph parrafo16;
    public XWPFParagraph parrafo17;
    public XWPFParagraph parrafo18;
    public XWPFParagraph parrafo19;
    public XWPFParagraph parrafo20;
    public XWPFParagraph parrafo21;
    public XWPFParagraph parrafo22;
    public XWPFParagraph parrafo23;
    public XWPFParagraph parrafo24;
    public XWPFParagraph parrafo25;
    public XWPFParagraph parrafo26;
    public XWPFParagraph parrafo27;
    public XWPFParagraph parrafo28;
    public XWPFParagraph parrafo29;
    public XWPFParagraph parrafo30;
    public XWPFParagraph parrafo31;
    public XWPFParagraph parrafo32;
    public XWPFParagraph parrafo33;
    public XWPFParagraph parrafo34;
    public XWPFParagraph parrafo35;
    public XWPFParagraph parrafo36;
    public XWPFParagraph parrafo37;
    public XWPFTableRow tablafiladatos;
    public String consecutivofinal;
    int fila;
    public InputStream mifirmarevision;
    public InputStream mifirmat;
    public InputStream mifirmaaprobacion;
    public String date1;
	public Image firmar;
	public Image firmat;
	public Image firmapro;
    int micantidaddefilas;
    public String rutaimagen;
    public String miarea;
    public String mifecha;
    public String micargo;
    public String solicitante;
    public String thisfecha;
    public Stage getthisstage;
    public Stage finalstage;
    public JFXComboBox<String> thisfcargof;
	public JFXComboBox<String> thisfareaf;
    public DatePicker fechaiff;
    public DatePicker fechafff;
    public TableView <requisicionesgen> thistableviewff;
    public String micargof;
    public String miareaf;
    public String mifechaiff;
    public String mifechafff;
    public String cnsreq;
    public int estadoitems;
  public ObservableList<requisicionesgen> items;
	public TableView<requisicionesgen> getThistableviewff() {
		return thistableviewff;
	}

	public void setThistableviewff(TableView<requisicionesgen> thistableviewff) {
		this.thistableviewff = thistableviewff;
	}

	public Stage getGetthisstage() {
		return getthisstage;
	}

	public void setGetthisstage(Stage getthisstage) {
		this.getthisstage = getthisstage;
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


	public void styledtextfield() {
		consecutivoreqaprofinal.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		consecutivoreqaprofinal.setDisable(true);
		solicitantereaprofinal.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		solicitantereaprofinal.setDisable(true);
		areareqaprofinalitems.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		areareqaprofinalitems.setDisable(true);
		cargoreqaprofinalitems.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		cargoreqaprofinalitems.setDisable(true);
		fecaprobacionreqaprofinalitems.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		fecaprobacionreqaprofinalitems.setDisable(true);
		itemsreqaprofinalitems.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		itemsreqaprofinalitems.setDisable(true);
		itemsresnoaprofinalitems.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		itemsresnoaprofinalitems.setDisable(true);
		fechaentregafinalitems.setStyle("-fx-background-color:#9CBFF0; -fx-text-fill:black; -fx-font-weight: bold; -fx-font-family: 'Oswald Regular'; -fx-font-size:16; -fx-opacity: 1;");
		fechaentregafinalitems.setDisable(true);
        }
	
	public void generarequisicionfinal() {
		generareqfinal.setOnAction(e->{
		
		
			
			
			consecutivofinal=consecutivoreqaprofinal.getText().toString();
			thisfecha=fechaentregafinalitems.getText().toString();
			 finalstage=DetalleFechaItemsController.this.getGetthisstage();
			 thisfcargof=DetalleFechaItemsController.this.getThisfcargof();
			 thisfareaf=DetalleFechaItemsController.this.getThisfareaf();
			 fechaiff=DetalleFechaItemsController.this.getFechaiff();
			 fechafff=DetalleFechaItemsController.this.getFechafff();
			 micargof=thisfcargof.getSelectionModel().getSelectedItem();
			 miareaf=thisfareaf.getSelectionModel().getSelectedItem();
			 mifechaiff=((TextField)fechaiff.getEditor()).getText();
			 mifechafff=((TextField)fechafff.getEditor()).getText();
			 
			 
	
   		 try {
   			 rutaimagen = "C:\\Logo\\login3.png";
   			 XWPFDocument requisicionesaprobadas= new XWPFDocument();
   			 XWPFParagraph parraencabezado = requisicionesaprobadas.createParagraph();
   			 XWPFHeaderFooterPolicy headerFooterPolicy = requisicionesaprobadas.createHeaderFooterPolicy();
   			 XWPFHeader cabecera = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
   			 parraencabezado = cabecera.getParagraphArray(0);
   			 int calculotipografia = 1440;
   			 if (parraencabezado == null) {
   				 parraencabezado = cabecera.createParagraph();
   				 XWPFTable tablaparrafoencabezado = cabecera.createTable(3,4);
   				 tablaparrafoencabezado.setWidth((int) (6.5 * calculotipografia));
   				 setTableAlign(tablaparrafoencabezado, ParagraphAlignment.CENTER);
   				 XWPFTableRow tablafilauno = tablaparrafoencabezado.getRow(0);
   				 XWPFTableRow tablafilados = tablaparrafoencabezado.getRow(1);
   				 XWPFTableRow tablafilatres = tablaparrafoencabezado.getRow(2);
   				 tablafilauno.setHeight((int) (calculotipografia*0.3));
   				 tablafilados.setHeight((int) (calculotipografia*0.3));
   				 tablafilatres.setHeight((int) (calculotipografia*0.3));
   				 
   				//-----------------ancho fila uno de la tabla-----------------// 
   				 XWPFTableCell cell = tablafilauno.getCell(0);
   				 if (cell == null )
   				     {
   					 cell = tablafilauno.createCell();
   					 }
   				 CTTblWidth ancho = cell.getCTTc().addNewTcPr().addNewTcW();
   				 ancho.setW(BigInteger.valueOf(4 * calculotipografia));//-------se coloca 4 por que aqui va la imagen----//
   				 ancho.setType(STTblWidth.DXA);
   				 
   				 //---------------------fin del ancho de la fila uno---------------//
   				 
   				 //------------------recorro fila uno y aplico ancho de celdas de la fila uno----//
   				 for(int i=1; i<4; i++) {
   					 XWPFTableCell cellfilai = tablafilauno.getCell(i);
   					 if (cellfilai == null) {
   						 cellfilai = tablafilauno.createCell(); 
   					 }
   					 CTTblWidth anchoi = cellfilai.getCTTc().addNewTcPr().addNewTcW();
   					 anchoi.setW(BigInteger.valueOf((long) (2.5 * calculotipografia)));
   					 anchoi.setType(STTblWidth.DXA);
   				     }
   				 //---------------------fin del ancho de la fila uno--------------------------//
   				 
   				 //------------------recorro fila dos y aplico ancho de celdas de la fila dos----//
   				 for (int x=1; x<4; x++) {
   					 XWPFTableCell cellfilax = tablafilados.getCell(x); 
   					 XWPFTableCell cellfilaxx = tablafilatres.getCell(x); 
   					 if (cellfilax == null && cellfilaxx == null) {
   						 cellfilax = tablafilados.createCell(); 
   						 cellfilaxx = tablafilatres.createCell(); 
   					 }
   					 CTTblWidth anchox = cellfilax.getCTTc().addNewTcPr().addNewTcW();
   					 anchox.setW(BigInteger.valueOf((long) (1.5 * calculotipografia)));
   					 anchox.setType(STTblWidth.DXA); 
   					 
   					 CTTblWidth anchoxx = cellfilaxx.getCTTc().addNewTcPr().addNewTcW();
   					 anchoxx.setW(BigInteger.valueOf((long) (1.5 * calculotipografia)));
   					 anchoxx.setType(STTblWidth.DXA); 
   				     }
   				//---------------------fin del ancho de la fila dos--------------------------//
   				 
   			//----------------------creacion de parrafos dentro de las filas de la tabla del encabezado----//
   				 tablafilauno.getCell(0).removeParagraph(0);
   				 parrafo = tablafilauno.getCell(0).addParagraph();
   				 XWPFRun run2=parrafo.createRun();
   				 parrafo.setAlignment(ParagraphAlignment.CENTER);
   				 run2.addPicture( new FileInputStream("/C:/Logo/login3.png"), XWPFDocument.PICTURE_TYPE_PNG, rutaimagen, Units.toEMU(167), Units.toEMU(64));

   				 tablafilauno.getCell(1).removeParagraph(0);
   			     parrafo2 = tablafilauno.getCell(1).addParagraph();
   			     XWPFRun run3=parrafo2.createRun();
   			     parrafo2.setAlignment(ParagraphAlignment.CENTER);
   			     run3.setFontFamily("Verdana");
   			     run3.setText("REQUISICIÓN");
   			     run3.setFontSize(11);
   			     run3.setBold(true);
   			    
   			     tablafilados.getCell(1).removeParagraph(0);
   			     parrafo3 = tablafilados.getCell(1).addParagraph();
   			     XWPFRun run4=parrafo3.createRun();
   			     parrafo3.setAlignment(ParagraphAlignment.CENTER);
   			     run4.setFontFamily("Verdana");
   			     run4.setText("Código");
   			     run4.setFontSize(9);
   			     run4.setBold(true);
   			     
   			     tablafilados.getCell(2).removeParagraph(0);
   			     parrafo4 = tablafilados.getCell(2).addParagraph();
   			     XWPFRun run5=parrafo4.createRun();
   			     parrafo4.setAlignment(ParagraphAlignment.CENTER);
   			     run5.setFontFamily("Verdana");
   			     run5.setText("Versión");
   			     run5.setFontSize(9);
   			     run5.setBold(true);
   			     
   			     tablafilados.getCell(3).removeParagraph(0);
   			     parrafo5 = tablafilados.getCell(3).addParagraph();
   			     XWPFRun run6=parrafo5.createRun();
   			     parrafo5.setAlignment(ParagraphAlignment.CENTER);
   			     run6.setFontFamily("Verdana");
   			     run6.setText("Fecha de Emisión");
   			     run6.setFontSize(9);
   			     run6.setBold(true);
   			     
   			     tablafilatres.getCell(1).removeParagraph(0);
   			     parrafo6 = tablafilatres.getCell(1).addParagraph();
   			     XWPFRun run7=parrafo6.createRun();
   			     parrafo6.setAlignment(ParagraphAlignment.CENTER);
   			     run7.setFontFamily("Verdana");
   			     run7.setText("FO-400-34");
   			     run7.setFontSize(9);
   			     run7.setBold(true);
   			     
   			     tablafilatres.getCell(2).removeParagraph(0);
   			     parrafo7 = tablafilatres.getCell(2).addParagraph();
   			     XWPFRun run8=parrafo7.createRun();
   			     parrafo7.setAlignment(ParagraphAlignment.CENTER);
   			     run8.setFontFamily("Verdana");
   			     run8.setText("4");
   			     run8.setFontSize(9);
   			     run8.setBold(true);
   			     
   			     tablafilatres.getCell(3).removeParagraph(0);
   			     parrafo8 = tablafilatres.getCell(3).addParagraph();
   			     XWPFRun run9=parrafo8.createRun();
   			     parrafo8.setAlignment(ParagraphAlignment.CENTER);
   			     run9.setFontFamily("Verdana");
   			     run9.setText("12/05/2015");
   			     run9.setFontSize(9);
   			     run9.setBold(true);
   		
   			     combinarceldasverticalmente(tablaparrafoencabezado, 0, 0, 2);
   			     mergeCellsHorizontal(tablaparrafoencabezado,0,1,3);
   			    
   			   //----------------------fin de creacion de parrafos---------------------------//	 
   			     }
   			 
   			//-----------------------termina creacion de encabezado------------------// 
   			 
   			 //--------------------------creacion de la tabla que contiene informacion del solicitante  y cargo------//
   			     XWPFTable tablasolicitantecargo= requisicionesaprobadas.createTable(2,3);//2f,3c
   			     //------------------creacion filas------------------------------------//
   			     XWPFTableRow tablafilaunos = tablasolicitantecargo.getRow(0);//creacion filas
   				 XWPFTableRow tablafiladoss = tablasolicitantecargo.getRow(1);
   		         //------------------fin creacion filas------------------------------------//
   				 
   				 //------------------------alto filas----------------------------//
   				 tablafilaunos.setHeight((int) (calculotipografia*0.19));//fila uno
   				 tablafiladoss.setHeight((int) (calculotipografia*0.19));//fila dos
   				 //------------------------alto filas----------------------------//
   				 
   				 //--------------------------ancho tabla --------------------//
   				 tablasolicitantecargo.setWidth((int) (6.5 * calculotipografia));
   				 setTableAlign(tablasolicitantecargo, ParagraphAlignment.CENTER);
   				//--------------------------ancho tabla --------------------//
   				
   				 //--------------recorro celdas para determinar tamaño------------//
   				/* for (int y=0; y<3; y++) {
   					 XWPFTableCell cellfilay = tablafilaunos.getCell(y); 
   					 if (cellfilay == null) {
   					 cellfilay= tablafilaunos.createCell(); 
   					 }
   				 CTTblWidth anchoy = cellfilay.getCTTc().addNewTcPr().addNewTcW();
   				 anchoy.setW(BigInteger.valueOf((long) (3.2 * calculotipografia)));
   				 anchoy.setType(STTblWidth.DXA);
   				 tablafilaunos.getCell(y).getCTTc().addNewTcPr().addNewShd().setFill("999999");
   				 }*/
   				 
   				 
 			     for( fila = 0; fila<1 ; fila++) {
 			    	tablafilaunos = tablasolicitantecargo.getRow(fila);
 			    	tablafilaunos.setHeight((int) (calculotipografia*0.1));
 	   			     XWPFTableCell celldatos = tablafilaunos.getCell(1);
 	   			     CTTblWidth anchodatos = celldatos.getCTTc().addNewTcPr().addNewTcW();
 	   			     anchodatos.setW(BigInteger.valueOf((long) (2 * calculotipografia)));
 	   			     anchodatos.setType(STTblWidth.DXA);
 	   			     XWPFTableCell celldatos0 = tablafilaunos.getCell(0);
 	   			     CTTblWidth anchodatos0 = celldatos0.getCTTc().addNewTcPr().addNewTcW();
 	   			     anchodatos0.setW(BigInteger.valueOf((long) (0.7 * calculotipografia)));
 	   			     anchodatos0.setType(STTblWidth.DXA);
 	   			     XWPFTableCell celldatos2 = tablafilaunos.getCell(2);
 	   			     CTTblWidth anchodatos2 = celldatos2.getCTTc().addNewTcPr().addNewTcW();
 	   			     anchodatos2.setW(BigInteger.valueOf((long) (1.2 * calculotipografia)));
 	   			     anchodatos2.setType(STTblWidth.DXA);
 	   			   for(int filax = 0; filax<1 ; filax++) {
 	   			    	 int cellt;
 	   			    	 for( cellt = 0 ; cellt<3; cellt++) {
 	   			    	tablasolicitantecargo.getRow(filax).getCell(cellt).setColor("999999");
 	   			         } 
 	   			         }
 	   			         }
   				 //--------------------------------------------------------------------------//
   					 XWPFTableCell cellfilauno = tablafiladoss.getCell(0); 
   					 XWPFTableCell cellfilados = tablafiladoss.getCell(1); 
   					 XWPFTableCell cellfilatres = tablafiladoss.getCell(2);  

   					    Conexion miconexiondata = new Conexion();
   		          		String Query= "SELECT SOLICITANTE, CNSREQ, CARGO, AREA,CONVERT(VARCHAR(16),FECHA_SOLICITUD,20) AS FECHA_SOLICITUD FROM REQUISICIONES WHERE CNSREQ='"+consecutivofinal+"'";
   		          		Connection Conexiontablareq = null;
   		              	try {
   		              		Conexiontablareq=miconexiondata.miconexion(Conexiontablareq);
   		          			PreparedStatement ps =Conexiontablareq.prepareStatement(Query);
   		          	       	ResultSet rs = ps.executeQuery();
   		          	        while(rs.next()) {
   		          	        	solicitante=rs.getString("SOLICITANTE");
   		          	        	micargo=rs.getString("CARGO"); 
   		          	        	miarea=rs.getString("AREA");
   		          	        	mifecha=rs.getString("FECHA_SOLICITUD");
   		          	        	cnsreq=rs.getString("CNSREQ");
   		          			         }
   		              	}catch(SQLException ee) {
   		              		ee.printStackTrace();
   		              	}
   				//--------------------------------creacion de los parrafos------------------//
   				 tablafilaunos.getCell(0).removeParagraph(0);
   				 parrafo9 = tablafilaunos.getCell(0).addParagraph();
   			     XWPFRun run10=parrafo9.createRun();
   			     parrafo9.setAlignment(ParagraphAlignment.CENTER);
   			     run10.setFontFamily("Verdana");
   			     run10.setText("Solicitante");
   			     run10.setFontSize(9);
   			     run10.setBold(true);
   			     
   			     tablafilaunos.getCell(1).removeParagraph(0);
			     parrafo10 = tablafilaunos.getCell(1).addParagraph();
			     XWPFRun run11=parrafo10.createRun();
			     parrafo10.setAlignment(ParagraphAlignment.CENTER);
			     run11.setFontFamily("Verdana");
			     run11.setText("Cargo");
			     run11.setFontSize(9);
			     run11.setBold(true);
			     
			     tablafilaunos.getCell(2).removeParagraph(0);
			     parrafo31 = tablafilaunos.getCell(2).addParagraph();
			     XWPFRun run45=parrafo31.createRun();
			     parrafo31.setAlignment(ParagraphAlignment.CENTER);
			     run45.setFontFamily("Verdana");
			     run45.setText("Consecutivo");
			     run45.setFontSize(9);
			     run45.setBold(true);
			     
			     
   			     cellfilauno.removeParagraph(0);
   				 parrafo23 = cellfilauno.addParagraph();
   			     XWPFRun run77=parrafo23.createRun();
   			     parrafo23.setAlignment(ParagraphAlignment.CENTER);
   			     run77.setFontFamily("Verdana");
   			     run77.setText(solicitante);
   			     run77.setFontSize(9);
   			     run77.setBold(true);
                //----------------------------------fin creacion parrafos---------------------------//
   			     
   			     //----------asigno a las celdas de cada fila el texto dentro del parrafo----------------//
   			     cellfilados.removeParagraph(0);
   				 parrafo24 = cellfilados.addParagraph();
   			     XWPFRun run78=parrafo24.createRun();
   			     parrafo24.setAlignment(ParagraphAlignment.CENTER);
   			     run78.setFontFamily("Verdana");
   			     run78.setText(micargo);
   			     run78.setFontSize(9);
   			     run78.setBold(true);
   			     
   			     cellfilatres.removeParagraph(0);
				 parrafo32 = cellfilatres.addParagraph();
			     XWPFRun run79=parrafo32.createRun();
			     parrafo32.setAlignment(ParagraphAlignment.CENTER);
			     run79.setFontFamily("Verdana");
			     run79.setText(cnsreq);
			     run79.setFontSize(9);
			     run79.setBold(true);
   		        //----------------------------------------------------------------------------------------//
   			 

   			     //-----------------------------fin parrafos----------------------------------//
   			    
   				 //-------------fin -creacion de la tabla que contiene informacion del solicitante  y cargo---------//
   			     //--------------------------creacion de la tabla que contiene el area y la fecha-----//
   			     tablasolicitantecargo = requisicionesaprobadas.getTableArray(0);
   			     org.apache.xmlbeans.XmlCursor cursor = tablasolicitantecargo.getCTTbl().newCursor();
   			     cursor.toEndToken();
   			     while(cursor.toNextToken() != org.apache.xmlbeans.XmlCursor.TokenType.START);
   			     XWPFParagraph parrafo = requisicionesaprobadas.insertNewParagraph(cursor);
   			     @SuppressWarnings("unused")
   				 XWPFRun run = parrafo.createRun(); 

   			     XWPFTable tablarea= requisicionesaprobadas.createTable(1,4);
   			     XWPFTableRow tablafilaarea = tablarea.getRow(0);
   			     tablafilaarea.setHeight((int) (calculotipografia*0.19));
   			     tablarea.setWidth((int) (6.5 * calculotipografia));
   			     @SuppressWarnings("unused")
   				XWPFTableCell cellareab = tablafilaarea.getCell(1);
   			     setTableAlign(tablarea, ParagraphAlignment.CENTER);

   				 for (int j=0; j<3; j++) {
   					 XWPFTableCell cellfilaj = tablafilaarea.getCell(j); 
   					 if (cellfilaj == null) {
   						 cellfilaj= tablafilaarea.createCell(); 
   					 }
   					 
   					if(tablafilaarea.getCell(1)==null ||tablafilaarea.getCell(1)!=null) {
   					tablafilaarea.getCell(1).getCTTc().addNewTcPr().addNewShd().setFill("FFFFFF");
   					 }
   					 
   				 CTTblWidth anchoj = cellfilaj.getCTTc().addNewTcPr().addNewTcW();
   				 anchoj.setW(BigInteger.valueOf((long) (1.5 * calculotipografia)));
   				 anchoj.setType(STTblWidth.DXA);
   				 tablafilaarea.getCell(j).getCTTc().addNewTcPr().addNewShd().setFill("999999");
   				 }
   			     //--------------------------------creacion de los parrafos------------------//
   				
   				 tablafilaarea.getCell(0).removeParagraph(0);
   				 parrafo11 = tablafilaarea.getCell(0).addParagraph();
   			     XWPFRun run12=parrafo11.createRun();
   			     parrafo11.setAlignment(ParagraphAlignment.CENTER);
   			     run12.setFontFamily("Verdana");
   			     run12.setText("Área");
   			     run12.setFontSize(9);
   			     run12.setBold(true);
   			    
   			     tablafilaarea.getCell(1).removeParagraph(0);
   				 parrafo21 = tablafilaarea.getCell(1).addParagraph();
   			     XWPFRun run21=parrafo21.createRun();
   			     parrafo21.setAlignment(ParagraphAlignment.CENTER);
   			     run21.setFontFamily("Verdana");
   			     run21.setText(miarea);
   			     run21.setFontSize(9);
   			     run21.setBold(true);
   			     
   			     
   			     tablafilaarea.getCell(2).removeParagraph(0);
   			     parrafo12 = tablafilaarea.getCell(2).addParagraph();
   			     XWPFRun run13=parrafo12.createRun();
   			     parrafo12.setAlignment(ParagraphAlignment.CENTER);
   			     run13.setFontFamily("Verdana");
   			     run13.setText("Fecha De Solicitud");
   			     run13.setFontSize(9);

   			     run13.setBold(true);
   			     
   			     
   			     tablafilaarea.getCell(3).removeParagraph(0);
   			     parrafo22 = tablafilaarea.getCell(3).addParagraph();
   			     XWPFRun run33=parrafo22.createRun();
   			     parrafo22.setAlignment(ParagraphAlignment.CENTER);
   			     run33.setFontFamily("Verdana");
   			     run33.setText(mifecha);
   			     run33.setFontSize(9);
   			     run33.setBold(true);
   			     
   			     //-----------------------------fin parrafos----------------------------------//
   			    //-----------------------fin creacion de la tabla que contiene el area y la fecha-----//
   			     XWPFTable tabladatos= requisicionesaprobadas.createTable(19,5); 
   			     XmlCursor cursora =  tabladatos.getCTTbl().newCursor(); 
   			     XWPFParagraph newParagraph = requisicionesaprobadas.insertNewParagraph(cursora); 
   			     @SuppressWarnings("unused")
   				 XWPFRun runa = newParagraph.createRun();

   			     for( fila = 0; fila<19 ; fila++) {
   			     tablafiladatos = tabladatos.getRow(fila);
   			     tablafiladatos.setHeight((int) (calculotipografia*0.1));
   			     XWPFTableCell celldatos = tablafiladatos.getCell(1);
   			     CTTblWidth anchodatos = celldatos.getCTTc().addNewTcPr().addNewTcW();
   			     anchodatos.setW(BigInteger.valueOf((long) (2 * calculotipografia)));
   			     anchodatos.setType(STTblWidth.DXA);
   			     XWPFTableCell celldatos0 = tablafiladatos.getCell(0);
   			     CTTblWidth anchodatos0 = celldatos0.getCTTc().addNewTcPr().addNewTcW();
   			     anchodatos0.setW(BigInteger.valueOf((long) (0.7 * calculotipografia)));
   			     anchodatos0.setType(STTblWidth.DXA);
   			     XWPFTableCell celldatos2 = tablafiladatos.getCell(2);
   			     CTTblWidth anchodatos2 = celldatos2.getCTTc().addNewTcPr().addNewTcW();
   			     anchodatos2.setW(BigInteger.valueOf((long) (1.2 * calculotipografia)));
   			     anchodatos2.setType(STTblWidth.DXA);
   			     XWPFTableCell celldatos3 = tablafiladatos.getCell(3);
   			     CTTblWidth anchodatos3 = celldatos3.getCTTc().addNewTcPr().addNewTcW();
   			     anchodatos3.setW(BigInteger.valueOf((long) (0.9 * calculotipografia)));
   			     anchodatos3.setType(STTblWidth.DXA);
   			     XWPFTableCell celldatos4 = tablafiladatos.getCell(4);
   			     CTTblWidth anchodatos4 = celldatos4.getCTTc().addNewTcPr().addNewTcW();
   			     anchodatos4.setW(BigInteger.valueOf((long) (1.6 * calculotipografia)));
   			     anchodatos4.setType(STTblWidth.DXA);
   			     for(int filax = 0; filax<1 ; filax++) {
   			    	 int cellt;
   			    	 for( cellt = 0 ; cellt<5; cellt++) {
   			    	 tabladatos.getRow(filax).getCell(cellt).setColor("999999");
   			         } 
   			         }
   			         }
   			    		String QueryD= "SELECT ITEMSREQ.CANTIDAD AS CANTIDAD, ITEMSREQ.ITEM AS ITEM,   (CASE WHEN ITEMSREQ.ITEMAPROBADO IS NULL THEN 'ITEM AUN SIN APROBACION' WHEN ITEMSREQ.ITEMAPROBADO=0 THEN 'NO APROBADO' WHEN ITEMSREQ.ITEMAPROBADO=1 THEN 'APROBADO' END ) AS ITEMAPROBADOREQ  FROM ITEMSREQ  INNER JOIN REQUISICIONESDT ON  REQUISICIONESDT.CNSREQ = ITEMSREQ.CNSREQ WHERE ITEMSREQ.CNSREQ='"+consecutivofinal+"'";
   			    		String QueryR="SELECT (CASE WHEN ESTADO_ITEMS IS NOT NULL THEN ESTADO_ITEMS ELSE -1  END) AS ESTADO_ITEMS FROM REQUISICIONES WHERE CNSREQ='"+consecutivofinal+"'";
   			    		String QueryH="SELECT FIRMA_REVISION FROM REQUISICIONESDT WHERE CNSREQ = '"+consecutivofinal+"'";
   			    		String Queryz="SELECT FIRMA_APROBACION FROM REQUISICIONESDT WHERE CNSREQ = '"+consecutivofinal+"'";
   		          		String QueryF="SELECT count(ITEMSREQ.id) as itemreqid FROM ITEMSREQ  INNER JOIN REQUISICIONESDT ON  REQUISICIONESDT.CNSREQ = ITEMSREQ.CNSREQ WHERE ITEMSREQ.CNSREQ='"+consecutivofinal+"'";
   			    		String QueryFirmaDigital="SELECT FIRMA_DIGITAL FROM USUARIOS INNER JOIN REQUISICIONES ON USUARIOS.CARGO = REQUISICIONES.CARGO WHERE REQUISICIONES.CNSREQ='"+consecutivofinal+"'";

   		          		Conexion conectardata = new Conexion();
   		             try {
    		            	Connection Conexiontablaitemsz = null;
 		          		  Conexion conectardatatz = new Conexion();
 		          		Conexiontablaitemsz=conectardatatz.miconexion(Conexiontablaitemsz);
 		          			PreparedStatement pss =Conexiontablaitemsz.prepareStatement(QueryR);
 		          			ResultSet rss = pss.executeQuery();
 		          		 while (rss.next()) {
 		          			 estadoitems= rss.getInt("ESTADO_ITEMS");
 		          			 System.out.println(estadoitems);
 		          		 }
 		              	}catch(SQLException ee) {
 		              		ee.printStackTrace();
 		              	} 
   		             
   		             
   		          		try {
   		          		  Connection Conexiontablaitems = null;
   		          		  Conexion conectardatat = new Conexion();
   		              		Conexiontablaitems=conectardatat.miconexion(Conexiontablaitems);
   		          			PreparedStatement psset =Conexiontablaitems.prepareStatement(QueryH);
   		          			ResultSet rsset = psset.executeQuery();
   		          		 while (rsset.next()) {
   		          			 mifirmarevision= rsset.getBinaryStream("FIRMA_REVISION");
   		          			 OutputStream osd = new FileOutputStream(new File("firma.jpg"));
   		                    byte[]contenidod = new byte[1024];
   		                    int tamm = 0;
   		                   while((tamm=mifirmarevision.read(contenidod))!= -1)
   		                   {
   		                   osd.write(contenidod,0,tamm);
   		                   }
   		                   osd.close();
   		                   mifirmarevision.close();
   		                   firmar = new Image("file:firma.jpg",110,40,true,true); 
   		          		 }
   		              	}catch(SQLException ee) {
   		              		ee.printStackTrace();
   		              	}
   		         		try {
   		         		Connection Conexiontablaitemst = null;
 		          		  Conexion conectardatat = new Conexion();
 		          		 Conexiontablaitemst=conectardatat.miconexion(Conexiontablaitemst);
   		          			PreparedStatement pssett =Conexiontablaitemst.prepareStatement(Queryz);
   		          			ResultSet rssett = pssett.executeQuery();
   		          		 while (rssett.next()) {
   		          			 mifirmaaprobacion= rssett.getBinaryStream("FIRMA_APROBACION");
   		                   
   		             	   OutputStream ost = new FileOutputStream(new File("firmapro.jpg"));
   		                    byte[]contenidoost = new byte[1024];
   		                    int tam1 = 0;
   		                   while((tam1=mifirmaaprobacion.read(contenidoost))!= -1)
   		                   {
   		                   ost.write(contenidoost,0,tam1);
   		                   }
   		                   ost.close();
   		                   mifirmaaprobacion.close();
   		                   firmapro = new Image("file:firmaapro.jpg",110,40,true,true); 
   		          		 }
   		              	}catch(SQLException ee) {
   		              		ee.printStackTrace();
   		              	}
      		             try {
    	                 	Connection datos1 = null;
    	          	       Conexion conectardata1 = new Conexion();
    	          	        datos1=conectardata1.miconexion(datos1);
              			PreparedStatement psset =datos1.prepareStatement(QueryFirmaDigital);
              			ResultSet rsset = psset.executeQuery();
              		 while (rsset.next()) {
              			 mifirmat= rsset.getBinaryStream("FIRMA_DIGITAL");
              			 OutputStream osd = new FileOutputStream(new File("firmag.jpg"));
                         byte[]contenidod = new byte[1024];
                         int tamm = 0;
                        while((tamm=mifirmat.read(contenidod))!= -1)
                        {
                        osd.write(contenidod,0,tamm);
                        }
                        osd.close();
                        mifirmat.close();
                       firmat = new Image("file:firmag.jpg",110,40,true,true); 
              		 }
                  	}catch(SQLException ee) {
                  		ee.printStackTrace();	
                  	}	
   		              	try {
   		              	Connection Conexiontablaitemsy = null;
		          		  Conexion conectardataty = new Conexion();
		          		Conexiontablaitemsy=conectardataty.miconexion(Conexiontablaitemsy);
   		          			PreparedStatement pss =Conexiontablaitemsy.prepareStatement(QueryF);
   		          			ResultSet rss = pss.executeQuery();
   		          		 while (rss.next()) {
   		          			 micantidaddefilas= rss.getInt("itemreqid");
   		          		 }
   		              	}catch(SQLException ee) {
   		              		ee.printStackTrace();
   		              	}
					//--------------------------fin bloque else--------------------------------//	
   		               for( fila = 1; fila<micantidaddefilas+1 ; fila++) {
   		          		 try {
   		          		Connection Conexiontablaitemszy = null;
		          		  Conexion conectardatatzy = new Conexion();
		          		Conexiontablaitemszy=conectardatatzy.miconexion(Conexiontablaitemszy);
   		          			PreparedStatement ps =Conexiontablaitemszy.prepareStatement(QueryD);
   		          	       	ResultSet rs = ps.executeQuery();
   		          	   if(estadoitems==0) {
   		          	        while (rs.next()) {
   		          	         tablafiladatos = tabladatos.getRow(fila);
   		          	         tablafiladatos.getCell(0).removeParagraph(0);
   		          	         parrafo27= tabladatos.getRow(fila).getCell(0).addParagraph();
   		          	         XWPFRun run70=parrafo27.createRun();
   		          	         parrafo27.setAlignment(ParagraphAlignment.CENTER);
   		          	         run70.setFontFamily("Verdana");
   		 			         run70.setText(rs.getString("CANTIDAD")) ;
   		 			         run70.setFontSize(9);
   		 			         run70.setBold(true);
   		 			         tablafiladatos.getCell(1).removeParagraph(0);
   		          	         parrafo28= tabladatos.getRow(fila).getCell(1).addParagraph();
   		          	         XWPFRun run71=parrafo28.createRun();
   		          	         parrafo28.setAlignment(ParagraphAlignment.CENTER);
   		          	         run71.setFontFamily("Verdana");
   		 			         run71.setText(rs.getString("ITEM"));
   		 			         run71.setFontSize(9);
   		 			         run71.setBold(true);
   		 			         tablafiladatos.getCell(2).removeParagraph(0);
   		          	         parrafo29= tabladatos.getRow(fila).getCell(2).addParagraph();
   		          	         XWPFRun run72=parrafo29.createRun();
   		          	         parrafo29.setAlignment(ParagraphAlignment.CENTER);
   		          	         run72.setFontFamily("Verdana");
   		 			         run72.setText(rs.getString("ITEMAPROBADOREQ"));
   		 			         run72.setFontSize(9);
   		 			         run72.setBold(true);
   		 			         tablafiladatos.getCell(3).removeParagraph(0);
  		          	         parrafo30= tabladatos.getRow(fila).getCell(3).addParagraph();
  		          	         XWPFRun run88=parrafo30.createRun();
  		          	         parrafo30.setAlignment(ParagraphAlignment.CENTER);
  		          	         run88.setFontFamily("Verdana");
  		 			         run88.setText(thisfecha);
  		 			         run88.setFontSize(9);
  		 			         run88.setBold(true);
  		 			         if(rs.getString("ITEMAPROBADOREQ").equals("NO APROBADO")) {
  		 			         tablafiladatos.getCell(4).removeParagraph(0);
 		          	         parrafo34= tabladatos.getRow(fila).getCell(4).addParagraph();
 		          	         XWPFRun run89=parrafo34.createRun();
 		          	         parrafo34.setAlignment(ParagraphAlignment.CENTER);
 		          	         run89.setFontFamily("Verdana");
 		          	         run89.setText("ITEM NO APROBADO");
 		                     run89.setFontSize(9);
 		                     run89.setBold(true);
   		          	        }
  		 			         else if(rs.getString("ITEMAPROBADOREQ").equals("APROBADO")) {
   		 			         tablafiladatos.getCell(4).removeParagraph(0);
  		          	         parrafo34= tabladatos.getRow(fila).getCell(4).addParagraph();
  		          	         XWPFRun run89=parrafo34.createRun();
  		          	         parrafo34.setAlignment(ParagraphAlignment.CENTER);
  		          	         run89.setFontFamily("Verdana");
  		          	         run89.setText("NO RECIBIDO");
  		                     run89.setFontSize(9);
  		                     run89.setBold(true);
    		          	    }
  		 			        fila++;
   		          	        }
   		          	      }   
   		              	}catch(SQLException ee) {
   		              		ee.printStackTrace();
   		              	}
   		               }

   		            //--------------LNA------------------------------//   
   		            for( fila = 1; fila<micantidaddefilas+1 ; fila++) {
  		          		 try {
  		          		Connection Conexiontablaitemszy = null;
		          		  Conexion conectardatatzy = new Conexion();
		          		Conexiontablaitemszy=conectardatatzy.miconexion(Conexiontablaitemszy);
  		          			PreparedStatement ps =Conexiontablaitemszy.prepareStatement(QueryD);
  		          	       	ResultSet rs = ps.executeQuery();
  		          	   if(estadoitems==1||estadoitems==-1) {
  		          	        while (rs.next()) {
  		          	         tablafiladatos = tabladatos.getRow(fila);
  		          	         tablafiladatos.getCell(0).removeParagraph(0);
  		          	         parrafo27= tabladatos.getRow(fila).getCell(0).addParagraph();
  		          	         XWPFRun run70=parrafo27.createRun();
  		          	         parrafo27.setAlignment(ParagraphAlignment.CENTER);
  		          	         run70.setFontFamily("Verdana");
  		 			         run70.setText(rs.getString("CANTIDAD")) ;
  		 			         run70.setFontSize(9);
  		 			         run70.setBold(true);
  		 			         tablafiladatos.getCell(1).removeParagraph(0);
  		          	         parrafo28= tabladatos.getRow(fila).getCell(1).addParagraph();
  		          	         XWPFRun run71=parrafo28.createRun();
  		          	         parrafo28.setAlignment(ParagraphAlignment.CENTER);
  		          	         run71.setFontFamily("Verdana");
  		 			         run71.setText(rs.getString("ITEM"));
  		 			         run71.setFontSize(9);
  		 			         run71.setBold(true);
  		 			         tablafiladatos.getCell(2).removeParagraph(0);
  		          	         parrafo29= tabladatos.getRow(fila).getCell(2).addParagraph();
  		          	         XWPFRun run72=parrafo29.createRun();
  		          	         parrafo29.setAlignment(ParagraphAlignment.CENTER);
  		          	         run72.setFontFamily("Verdana");
  		 			         run72.setText(rs.getString("ITEMAPROBADOREQ"));
  		 			         run72.setFontSize(9);
  		 			         run72.setBold(true);
  		 			         tablafiladatos.getCell(3).removeParagraph(0);
 		          	         parrafo30= tabladatos.getRow(fila).getCell(3).addParagraph();
 		          	         XWPFRun run88=parrafo30.createRun();
 		          	         parrafo30.setAlignment(ParagraphAlignment.CENTER);
 		          	         run88.setFontFamily("Verdana");
 		 			         run88.setText(thisfecha);
 		 			         run88.setFontSize(9);
 		 			         run88.setBold(true);
 		 			         if(rs.getString("ITEMAPROBADOREQ").equals("NO APROBADO")) {
 		 			         tablafiladatos.getCell(4).removeParagraph(0);
		          	         parrafo34= tabladatos.getRow(fila).getCell(4).addParagraph();
		          	         XWPFRun run89=parrafo34.createRun();
		          	         parrafo34.setAlignment(ParagraphAlignment.CENTER);
		          	         run89.setFontFamily("Verdana");
		          	         run89.setText("ITEM NO APROBADO");
		                     run89.setFontSize(9);
		                     run89.setBold(true);
  		          	        }
 		 			         else if(rs.getString("ITEMAPROBADOREQ").equals("APROBADO")) {
  		 			         tablafiladatos.getCell(4).removeParagraph(0);
 		          	         parrafo34= tabladatos.getRow(fila).getCell(4).addParagraph();
 		          	         XWPFRun run89=parrafo34.createRun();
 		          	         parrafo34.setAlignment(ParagraphAlignment.CENTER);
 		          	         run89.setFontFamily("Verdana");
 		          	         run89.setText("NO RECIBIDO");
 		                     run89.setFontSize(9);
 		                     run89.setBold(true);
   		          	    }
 		 			        fila++;
  		          	        }
  		          	      }   
  		              	}catch(SQLException ee) {
  		              		ee.printStackTrace();
  		              	}
  		               }
   		               
   		               //------------------LNA-------------------//
   		               
   		               
   		            	 for( fila = 1; fila<micantidaddefilas+1 ; fila++) {
   	   		          		 try {
   	   		          	   if (estadoitems==2||estadoitems==3) {
   	   		          		Connection Conexiontablaitemszyx = null;
  		          		      Conexion conectardatatzyx = new Conexion();
  		          		  Conexiontablaitemszyx=conectardatatzyx.miconexion(Conexiontablaitemszyx);
   	   		          			PreparedStatement ps =Conexiontablaitemszyx.prepareStatement(QueryD);
   	   		          	       	ResultSet rs = ps.executeQuery();
   	   		          	        while (rs.next()) {
   	   		          	         tablafiladatos = tabladatos.getRow(fila);
   	   		          	         tablafiladatos.getCell(0).removeParagraph(0);
   	   		          	         parrafo27= tabladatos.getRow(fila).getCell(0).addParagraph();
   	   		          	         XWPFRun run70=parrafo27.createRun();
   	   		          	         parrafo27.setAlignment(ParagraphAlignment.CENTER);
   	   		          	         run70.setFontFamily("Verdana");
   	   		 			         run70.setText(rs.getString("CANTIDAD")) ;
   	   		 			         run70.setFontSize(9);
   	   		 			         run70.setBold(true);
   	   		 			         tablafiladatos.getCell(1).removeParagraph(0);
   	   		          	         parrafo28= tabladatos.getRow(fila).getCell(1).addParagraph();
   	   		          	         XWPFRun run71=parrafo28.createRun();
   	   		          	         parrafo28.setAlignment(ParagraphAlignment.CENTER);
   	   		          	         run71.setFontFamily("Verdana");
   	   		 			         run71.setText(rs.getString("ITEM"));
   	   		 			         run71.setFontSize(9);
   	   		 			         run71.setBold(true);
   	   		 			         tablafiladatos.getCell(2).removeParagraph(0);
   	   		          	         parrafo29= tabladatos.getRow(fila).getCell(2).addParagraph();
   	   		          	         XWPFRun run72=parrafo29.createRun();
   	   		          	         parrafo29.setAlignment(ParagraphAlignment.CENTER);
   	   		          	         run72.setFontFamily("Verdana");
   	   		 			         run72.setText(rs.getString("ITEMAPROBADOREQ"));
   	   		 			         run72.setFontSize(9);
   	   		 			         run72.setBold(true);
   	   		 			         tablafiladatos.getCell(3).removeParagraph(0);
   	  		          	         parrafo30= tabladatos.getRow(fila).getCell(3).addParagraph();
   	  		          	         XWPFRun run88=parrafo30.createRun();
   	  		          	         parrafo30.setAlignment(ParagraphAlignment.CENTER);
   	  		          	         run88.setFontFamily("Verdana");
   	  		 			         run88.setText(thisfecha);
   	  		 			         run88.setFontSize(9);
   	  		 			         run88.setBold(true);
   	  		 			        if(rs.getString("ITEMAPROBADOREQ").equals("NO APROBADO")) {
    		 			         tablafiladatos.getCell(4).removeParagraph(0);
   		          	             parrafo34= tabladatos.getRow(fila).getCell(4).addParagraph();
   		          	             XWPFRun run89=parrafo34.createRun();
   		          	             parrafo34.setAlignment(ParagraphAlignment.CENTER);
   		          	             run89.setFontFamily("Verdana");
   		          	             run89.setText("ITEM NO APROBADO");
   		                         run89.setFontSize(9);
   		                         run89.setBold(true);
     		          	        }
    		 			         else if(rs.getString("ITEMAPROBADOREQ").equals("APROBADO")) {
     		 			         tablafiladatos.getCell(4).removeParagraph(0);
    		          	         parrafo34= tabladatos.getRow(fila).getCell(4).addParagraph();
    		          	         XWPFRun run89=parrafo34.createRun();
    		          	         parrafo34.setAlignment(ParagraphAlignment.CENTER);
    		          	         run89.setFontFamily("Verdana");
    		          	         run89.setText("RECIBIDO");
    		                     run89.setFontSize(9);
    		                     run89.setBold(true);
      		          	         }
   	 		                     fila++;
   	   		          	        }
   	   		          	        }  
   	   		              	}catch(SQLException ee) {
   	   		              		ee.printStackTrace();
   	   		              	}
   	   		             	
   	   		               }
   	   		              
   		            	 if(estadoitems==2||estadoitems==3) {
   	   		              tabladatos.getRow(17).getCell(3).removeParagraph(0);
     		    	      parrafo37 = tabladatos.getRow(17).getCell(3).addParagraph();
     	   				  XWPFRun run227=parrafo37.createRun();
     	   				  parrafo37.setAlignment(ParagraphAlignment.CENTER);
     	   				  run227.addPicture( new FileInputStream(new File("firmag.jpg")), XWPFDocument.PICTURE_TYPE_PNG, null, Units.toEMU(110), Units.toEMU(40));  
   	   		              }
   	   		             

   			     tabladatos.setWidth((int) (6.6 * calculotipografia));
   			     setTableAlign(tabladatos, ParagraphAlignment.CENTER);
   			     
   			     tabladatos.getRow(0).getCell(0).removeParagraph(0);
   			     parrafo13 = tabladatos.getRow(0).getCell(0).addParagraph();
   			     XWPFRun run14=parrafo13.createRun();
   			     parrafo13.setAlignment(ParagraphAlignment.CENTER);
   			     run14.setFontFamily("Verdana");
   			     run14.setText("Cantidad");
   			     run14.setFontSize(9);
   			     run14.setBold(true);
   			     
   			     tabladatos.getRow(0).getCell(1).removeParagraph(0);
   			     parrafo14 = tabladatos.getRow(0).getCell(1).addParagraph();
   			     XWPFRun run15=parrafo14.createRun();
   			     parrafo14.setAlignment(ParagraphAlignment.CENTER);
   			     run15.setFontFamily("Verdana");
   			     run15.setText("Descripción");
   			     run15.setFontSize(9);
   			     run15.setBold(true);
   			     
   			     tabladatos.getRow(0).getCell(2).removeParagraph(0);
   			     parrafo15 = tabladatos.getRow(0).getCell(2).addParagraph();
   			     XWPFRun run16=parrafo15.createRun();
   			     parrafo15.setAlignment(ParagraphAlignment.CENTER);
   			     run16.setFontFamily("Verdana");
   			     run16.setText("Ítem Aprobado");
   			     run16.setFontSize(9);
   			     run16.setBold(true);
   			     
   			     tabladatos.getRow(0).getCell(3).removeParagraph(0);
   			     parrafo16 = tabladatos.getRow(0).getCell(3).addParagraph();
   			     XWPFRun run17=parrafo16.createRun();
   			     parrafo16.setAlignment(ParagraphAlignment.CENTER);
   			     run17.setFontFamily("Verdana");
   			     run17.setText("*Fecha de entrega");
   			     run17.setFontSize(9);
   			     run17.setBold(true);
   			     
   			     tabladatos.getRow(0).getCell(4).removeParagraph(0);
   			     parrafo17 = tabladatos.getRow(0).getCell(4).addParagraph();
   			     XWPFRun run18=parrafo17.createRun();
   			     parrafo17.setAlignment(ParagraphAlignment.CENTER);
   			     run18.setFontFamily("Verdana");
   			     run18.setText("*Firma de quien recibe");
   			     run18.setFontSize(9);
   			     run18.setBold(true);
   			     
   			     tabladatos.getRow(13).getCell(0).removeParagraph(0);
   			     parrafo18 = tabladatos.getRow(13).getCell(0).addParagraph();
   			     XWPFRun run19=parrafo18.createRun();
   			     parrafo18.setAlignment(ParagraphAlignment.LEFT);
   			     run19.setFontFamily("Verdana");
   			     run19.setText("Observaciones");
   			     run19.setFontSize(9);
   			     run19.setBold(true);
   			     tabladatos.getRow(13).getCell(0).setColor("999999");
   			     
   			     tabladatos.getRow(16).getCell(0).removeParagraph(0);
   			     parrafo19 = tabladatos.getRow(16).getCell(0).addParagraph();
   			     XWPFRun run20=parrafo19.createRun();
   			     parrafo19.setAlignment(ParagraphAlignment.CENTER);
   			     run20.setFontFamily("Verdana");
   			     run20.setText("Firma Jefe de Área (VoBo)");
   			     run20.setFontSize(9);
   			     run20.setBold(true);
   			     tabladatos.getRow(16).getCell(0).setColor("999999");
   			     
   			     tabladatos.getRow(16).getCell(2).removeParagraph(0);
   			     parrafo20= tabladatos.getRow(16).getCell(2).addParagraph();
   			     XWPFRun run22=parrafo20.createRun();
   			     parrafo20.setAlignment(ParagraphAlignment.CENTER);
   			     run22.setFontFamily("Verdana");
   			     run22.setText("Firma Directora Administrativa y Financiera");
   			     run22.setFontSize(9);
   			     run22.setBold(true);
   			     tabladatos.getRow(16).getCell(2).setColor("999999");
   			     
   			     tabladatos.getRow(16).getCell(3).removeParagraph(0);
			     parrafo33= tabladatos.getRow(16).getCell(3).addParagraph();
			     XWPFRun run401=parrafo33.createRun();
			     parrafo33.setAlignment(ParagraphAlignment.CENTER);
			     run401.setFontFamily("Verdana");
			     run401.setText("Firma Funcionario Que Recibe");
			     run401.setFontSize(9);
			     run401.setBold(true);
			     tabladatos.getRow(16).getCell(3).setColor("999999");
   			     
   			     
   			     tabladatos.getRow(17).getCell(0).removeParagraph(0);
   			     parrafo24 = tabladatos.getRow(17).getCell(0).addParagraph();
   				 XWPFRun run50=parrafo24.createRun();
   				 parrafo24.setAlignment(ParagraphAlignment.CENTER);
   				 run50.addPicture( new FileInputStream(new File("firma.jpg")), XWPFDocument.PICTURE_TYPE_PNG, null, Units.toEMU(110), Units.toEMU(40));

   				 tabladatos.getRow(17).getCell(2).removeParagraph(0);
   			     parrafo25 = tabladatos.getRow(17).getCell(2).addParagraph();
   				 XWPFRun run51=parrafo25.createRun();
   				 parrafo25.setAlignment(ParagraphAlignment.CENTER);
   				 run51.addPicture( new FileInputStream(new File("firmapro.jpg")), XWPFDocument.PICTURE_TYPE_PNG, null, Units.toEMU(110), Units.toEMU(40));

   				 
   			   if(estadoitems==0||estadoitems==1) {
   				 tabladatos.getRow(17).getCell(3).removeParagraph(0);
   			     parrafo35 = tabladatos.getRow(17).getCell(3).addParagraph();
   				 XWPFRun run105=parrafo35.createRun();
   				 parrafo35.setAlignment(ParagraphAlignment.CENTER);
   				 run105.setFontFamily("Verdana");
   				 run105.setText("NO FIRMADO");
   				 run105.setFontSize(9);
   				 run105.setBold(true);
			     }

   			     mergeCellsHorizontal(tabladatos,13,0,4);
   			     combinarceldasverticalmente(tabladatos, 0, 14, 15);
   			     combinarceldasverticalmente(tabladatos, 1, 14, 15);
   			     combinarceldasverticalmente(tabladatos, 2, 14, 15);
   			     combinarceldasverticalmente(tabladatos, 3, 14, 15);
   			     combinarceldasverticalmente(tabladatos, 4, 14, 15);
   			     mergeCellsHorizontal(tabladatos,14,0,4);
   			     mergeCellsHorizontal(tabladatos,14,0,4);
   			     mergeCellsHorizontal(tabladatos,15,0,4);
   			     mergeCellsHorizontal(tabladatos,16,0,1);
   			     mergeCellsHorizontal(tabladatos,16,3,4);
   			     combinarceldasverticalmente(tabladatos, 1, 17, 18);
   			     combinarceldasverticalmente(tabladatos, 2, 17, 18);
   			     combinarceldasverticalmente(tabladatos, 3, 17, 18);
   			     mergeCellsHorizontal(tabladatos,17,0,1);
   			     mergeCellsHorizontal(tabladatos,18,0,1);
   			     mergeCellsHorizontal(tabladatos,18,3,4);
   			     mergeCellsHorizontal(tabladatos,17,3,4);
   			     combinarceldasverticalmente(tabladatos, 4, 17, 18);
   			     combinarceldasverticalmente(tabladatos, 0, 17, 18);
   			     
   			     
   			     
  			   if(/*estadoitems==2||estadoitems==0||*/estadoitems==1||estadoitems==3||estadoitems==-1) {
  	  			   FileChooser guardareqaprobadas = new FileChooser();
  	              FileChooser.ExtensionFilter wordlfiltro = new FileChooser.ExtensionFilter("Archivos De Word (*.docx)", "*.doc");
  	              guardareqaprobadas.getExtensionFilters().add(wordlfiltro);
  	              File midocword = guardareqaprobadas.showSaveDialog(null);
  	              boolean booleano = midocword != null;
  	              if (booleano== true) {
  	          	  	    Text cabecera2 = new Text();
  	        			cabecera2.setText("REQUISICION GENERADA Y GUARDADA");
  	        			cabecera2.setStyle("-fx-fill:yellow;-fx-font-weight:bold");
  	        			Text mensaje= new Text();
  	        			mensaje.setText("WORD GENERADO CON EXITO");
  	        			mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
  	        			JFXDialogLayout contenido = new JFXDialogLayout();
  	        		    contenido.setHeading((cabecera2));
  	        			contenido.setBody(mensaje);
  	        			contenido.setStyle(" -fx-background-color: linear-gradient( from 100.0% 200.0% to 200.0% 100.0%, rgb(255,102,102) 0.0, rgb(255,179,179) 100.0);");
  	        			JFXDialog dialogo = new JFXDialog(stackpanefinalitems,contenido, JFXDialog.DialogTransition.CENTER);
  	        			JFXButton cerrar = new JFXButton("CERRAR");
  	        			cerrar.setStyle(" -fx-background-color: yellow;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular'-Regular;-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
  	        			cerrar.setOnAction(e3->{
  	        			dialogo.close();
  	        			try {
  	        			 items = thistableviewff.getItems();
  	      	    	  
  	        			}catch(NullPointerException nn) {
  	        				
  	              	    		 finalstage.close();  
  	      	    	   }
  	        			});
  	        			contenido.setActions(cerrar);
  	        			dialogo.show();
  	               }
  	              if (booleano== false) {
  	            	  	Mensaje cancelmsj = new Mensaje();
  	            	  	cancelmsj.Usercancelmessage(stackpanefinalitems);
  	                   }
  	              if (midocword != null) {
  	                  try (FileOutputStream outputStream = new FileOutputStream(midocword.getAbsolutePath())) {
  	                 	 requisicionesaprobadas.write(outputStream);
  	                 	 requisicionesaprobadas.close();
  	                  }
  	                  catch (IOException e1) {    
  	                  }
  	               } 
  	  			  }
  	   			  
   			     
   			 
  			
   			  if (estadoitems==0) {
   		      FileChooser guardareqaprobadas = new FileChooser();
              FileChooser.ExtensionFilter wordlfiltro = new FileChooser.ExtensionFilter("Archivos De Word (*.docx)", "*.doc");
              guardareqaprobadas.getExtensionFilters().add(wordlfiltro);
              File midocword = guardareqaprobadas.showSaveDialog(null);
              boolean booleano = midocword != null;
              if (booleano== true) {
          	  	    Text cabecera2 = new Text();
        			cabecera2.setText("REQUISICION GENERADA Y GUARDADA");
        			cabecera2.setStyle("-fx-fill:yellow;-fx-font-weight:bold");
        			Text mensaje= new Text();
        			mensaje.setText("WORD GENERADO CON EXITO");
        			mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
        			JFXDialogLayout contenido = new JFXDialogLayout();
        		    contenido.setHeading((cabecera2));
        			contenido.setBody(mensaje);
        			contenido.setStyle(" -fx-background-color: linear-gradient( from 100.0% 200.0% to 200.0% 100.0%, rgb(255,102,102) 0.0, rgb(255,179,179) 100.0);");
        			JFXDialog dialogo = new JFXDialog(stackpanefinalitems,contenido, JFXDialog.DialogTransition.CENTER);
        			JFXButton cerrar = new JFXButton("CERRAR");
        			cerrar.setStyle(" -fx-background-color: yellow;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular'-Regular;-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
        			cerrar.setOnAction(e3->{
        			dialogo.close();
        			Connection ConexionData =null;
 				    String QueryData="UPDATE REQUISICIONES SET ESTADO_ITEMS =1  WHERE CNSREQ='"+consecutivofinal+"'";
 				    
 				    try {
   					    ConexionData = conectardata.miconexion(ConexionData);
   						PreparedStatement pst =ConexionData.prepareStatement(QueryData);
   						pst.executeUpdate();
   			    	}catch(SQLException ee) {
   			   		ee.printStackTrace();
   			   	    }
   				 if(thisfcargof.getSelectionModel().getSelectedItem().equals("Sin Dato")&&thisfareaf.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaiff.getEditor()).getText().isEmpty()&&!((TextField)fechafff.getEditor()).getText().isEmpty())
	    		   {
	    	    	        ObservableList<requisicionesgen> itemsaprobados= FXCollections.observableArrayList();
	    	    	        Connection Conexiontablarequi =null;
	   	   	   		        String QueryA= "SELECT  \r\n" + 
	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION ,MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? \r\n" + 
	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
	   	   	       	try {
	   	   	             Conexiontablarequi = conectardata.miconexion(Conexiontablarequi); 
	   	   	   			 PreparedStatement pss =Conexiontablarequi.prepareStatement(QueryA);
	   	   	         	 pss.setString(1, mifechaiff);
  				         pss.setString(2, mifechafff);
	   	   	   	       	 ResultSet rs = pss.executeQuery();
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
	   	   	   	       DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobados);
	 	    	   	   	   			 }
	   	   	       	}catch(SQLException eee) {
	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	   	   	       	} 
	    		   }
   				else if(thisfcargof.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaiff.getEditor()).getText().isEmpty()&&!((TextField)fechafff.getEditor()).getText().isEmpty()) {
	    			ObservableList<requisicionesgen> itemsaprobadosA= FXCollections.observableArrayList();
	   	   	   		String QueryHH= "SELECT  \r\n" + 
	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION ,MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? AND MIDATA.AREA = ?   	   				\r\n" + 
	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
	   	   	   		Connection Conexiontablaf = null;
	   	   	       	try {
	   	   	       		Conexiontablaf=conectardata.miconexion(Conexiontablaf);
	   	   	   			PreparedStatement ps =Conexiontablaf.prepareStatement(QueryHH);
	   	   	         	ps.setString(1, mifechaiff);
	    				    ps.setString(2, mifechafff);
	    					ps.setString(3, miareaf);
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
	   	   	   	 DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobadosA);
	 	    	   	   	   			 }
	   	   	       	}catch(SQLException eee) {
	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	   	   	       	}
	    		  }
   				else if(thisfareaf.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaiff.getEditor()).getText().isEmpty()&&!((TextField)fechafff.getEditor()).getText().isEmpty()) {  
   					        Connection Conexiontablaff = null;	
   					        ObservableList<requisicionesgen> itemsaprobadosB= FXCollections.observableArrayList();
	    	   	   	   		String Queryy= "SELECT  \r\n" + 
	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION,MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
	    	   	   	       	try {
	    	   	   	       		Conexiontablaff = conectardata.miconexion(Conexiontablaff);
	    	   	   	   			PreparedStatement ps =Conexiontablaff.prepareStatement(Queryy);
	    	   	   	         	ps.setString(1, mifechaiff);
  	    				        ps.setString(2, mifechafff);
  	    					    ps.setString(3, micargof);
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
	    	   	   	      DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobadosB);
	    	 	    	   	   	   			 }
	    	   	   	       	}catch(SQLException eee) {
	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	    	   	   	       	} 
	    		          }
   			 else if (thisfcargof.getSelectionModel().getSelectedItem().equals("Sin Dato")&&thisfareaf.getSelectionModel().getSelectedItem().equals("Sin Dato")&&((TextField)fechaiff.getEditor()).getText().isEmpty()&&((TextField)fechafff.getEditor()).getText().isEmpty()) 
	  			{
 	    			 ObservableList<requisicionesgen> itemsaprobadosC= FXCollections.observableArrayList();
	    	   	   	   	 String Queryyx= "SELECT  \r\n" + 
	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION, MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
	    	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
	    	   	   	   		Connection Conexiontablay = null;
	    	   	   	       	try {
	    	   	   	       		Conexiontablay=conectardata.miconexion(Conexiontablay);;
	    	   	   	   			PreparedStatement ps =Conexiontablay.prepareStatement(Queryyx);
	    	   	   	   	       	ResultSet rs = ps.executeQuery();
	    	   	   	   	        while(rs.next()) {
	    	   	   	        	itemsaprobadosC.add(new requisicionesgen(
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
	    	   	   	        	
	    	   	 
	    	   	   	       try { 	
	    	   	   	      DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobadosC);
	    	   	  	   	}catch(NullPointerException nn) {
  	        				
             	    		 finalstage.close();  
     	    	           }
	    	 	    	   	   	   			 }
	    	   	   	       	}catch(SQLException eee) {
	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
	    	   	   	       	} 
	    	   	   	 	   }
   			  finalstage.close();
        			});
        			contenido.setActions(cerrar);
        			dialogo.show();
               }
              if (booleano== false) {
            	  	Mensaje cancelmsj = new Mensaje();
            	  	cancelmsj.Usercancelmessage(stackpanefinalitems);
                   }
              if (midocword != null) {
                  try (FileOutputStream outputStream = new FileOutputStream(midocword.getAbsolutePath())) {
                 	 requisicionesaprobadas.write(outputStream);
                 	 requisicionesaprobadas.close();
                  }
                  catch (IOException e1) {    
                  }
               }
   			  }
   		
   			

  
   			  
   			   if(estadoitems==2) {
   			   FileChooser guardareqaprobadas = new FileChooser();
               FileChooser.ExtensionFilter wordlfiltro = new FileChooser.ExtensionFilter("Archivos De Word (*.docx)", "*.doc");
               guardareqaprobadas.getExtensionFilters().add(wordlfiltro);
               File midocword = guardareqaprobadas.showSaveDialog(null);
               boolean booleano = midocword != null;
               if (booleano== true) {
           	  	    Text cabecera2 = new Text();
         			cabecera2.setText("REQUISICION GENERADA Y GUARDADA");
         			cabecera2.setStyle("-fx-fill:yellow;-fx-font-weight:bold");
         			Text mensaje= new Text();
         			mensaje.setText("WORD GENERADO CON EXITO");
         			mensaje.setStyle("-fx-fill:white;-fx-font-weight:bold");
         			JFXDialogLayout contenido = new JFXDialogLayout();
         		    contenido.setHeading((cabecera2));
         			contenido.setBody(mensaje);
         			contenido.setStyle(" -fx-background-color: linear-gradient( from 100.0% 200.0% to 200.0% 100.0%, rgb(255,102,102) 0.0, rgb(255,179,179) 100.0);");
         			JFXDialog dialogo = new JFXDialog(stackpanefinalitems,contenido, JFXDialog.DialogTransition.CENTER);
         			JFXButton cerrar = new JFXButton("CERRAR");
         			cerrar.setStyle(" -fx-background-color: yellow;-fx-border-color:  linear-gradient(to bottom, red 14%, red 91%); -fx-border-radius:  15%; -fx-text-fill: red;  -fx-font-family: 'Oswald Regular'-Regular;-fx-font-weight: bold; -fx-border-width: 5px;-fx-background:none;-fx-border-insets: -5.8;");
         			cerrar.setOnAction(e3->{
         			dialogo.close();
         			Connection ConexionData =null;
  				    String QueryData="UPDATE REQUISICIONES SET ESTADO_ITEMS =3  WHERE CNSREQ='"+consecutivofinal+"'";
  				    
  				    try {
    					    ConexionData = conectardata.miconexion(ConexionData);
    						PreparedStatement pst =ConexionData.prepareStatement(QueryData);
    						pst.executeUpdate();
    			    	}catch(SQLException ee) {
    			   		ee.printStackTrace();
    			   	    }
    				 if(thisfcargof.getSelectionModel().getSelectedItem().equals("Sin Dato")&&thisfareaf.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaiff.getEditor()).getText().isEmpty()&&!((TextField)fechafff.getEditor()).getText().isEmpty())
 	    		   {
 	    	    	        ObservableList<requisicionesgen> itemsaprobados= FXCollections.observableArrayList();
 	    	    	        Connection Conexiontablarequi =null;
 	   	   	   		        String QueryA= "SELECT  \r\n" + 
 	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION ,MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
 	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? \r\n" + 
 	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
 	   	   	       	try {
 	   	   	             Conexiontablarequi = conectardata.miconexion(Conexiontablarequi); 
 	   	   	   			 PreparedStatement pss =Conexiontablarequi.prepareStatement(QueryA);
 	   	   	         	 pss.setString(1, mifechaiff);
   				         pss.setString(2, mifechafff);
 	   	   	   	       	 ResultSet rs = pss.executeQuery();
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
 	   	   	   	       DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobados);
 	 	    	   	   	   			 }
 	   	   	       	}catch(SQLException eee) {
 	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
 	   	   	       	} 
 	    		   }
    				else if(thisfcargof.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaiff.getEditor()).getText().isEmpty()&&!((TextField)fechafff.getEditor()).getText().isEmpty()) {
 	    			ObservableList<requisicionesgen> itemsaprobadosA= FXCollections.observableArrayList();
 	   	   	   		String QueryHH= "SELECT  \r\n" + 
 	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION  , MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
 	   	   	   				"	   WHERE CAST(MIDATA.[FECHA DE APROBACION] AS DATE)>= ? AND CAST(MIDATA.[FECHA DE APROBACION] AS DATE)<=? AND MIDATA.AREA = ?   	   				\r\n" + 
 	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
 	   	   	   		Connection Conexiontablaf = null;
 	   	   	       	try {
 	   	   	       		Conexiontablaf=conectardata.miconexion(Conexiontablaf);
 	   	   	   			PreparedStatement ps =Conexiontablaf.prepareStatement(QueryHH);
 	   	   	         	ps.setString(1, mifechaiff);
 	    				    ps.setString(2, mifechafff);
 	    					ps.setString(3, miareaf);
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
 	   	   	   	 DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobadosA);
 	 	    	   	   	   			 }
 	   	   	       	}catch(SQLException eee) {
 	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
 	   	   	       	}
 	    		  }
    				else if(thisfareaf.getSelectionModel().getSelectedItem().equals("Sin Dato")&&!((TextField)fechaiff.getEditor()).getText().isEmpty()&&!((TextField)fechafff.getEditor()).getText().isEmpty()) {  
    					        Connection Conexiontablaff = null;	
    					        ObservableList<requisicionesgen> itemsaprobadosB= FXCollections.observableArrayList();
 	    	   	   	   		String Queryy= "SELECT  \r\n" + 
 	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION, MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
 	    	   	   	       	try {
 	    	   	   	       		Conexiontablaff = conectardata.miconexion(Conexiontablaff);
 	    	   	   	   			PreparedStatement ps =Conexiontablaff.prepareStatement(Queryy);
 	    	   	   	         	ps.setString(1, mifechaiff);
   	    				        ps.setString(2, mifechafff);
   	    					    ps.setString(3, micargof);
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
 	    	   	   	      DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobadosB);
 	    	 	    	   	   	   			 }
 	    	   	   	       	}catch(SQLException eee) {
 	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
 	    	   	   	       	} 
 	    		          }
    			 else if (thisfcargof.getSelectionModel().getSelectedItem().equals("Sin Dato")&&thisfareaf.getSelectionModel().getSelectedItem().equals("Sin Dato")&&((TextField)fechaiff.getEditor()).getText().isEmpty()&&((TextField)fechafff.getEditor()).getText().isEmpty()) 
 	  			{
  	    			 ObservableList<requisicionesgen> itemsaprobadosC= FXCollections.observableArrayList();
 	    	   	   	   	 String Queryyx= "SELECT  \r\n" + 
 	    	   	   	   				"MIDATA.[CONSECUTIVO REQUISICION] AS 'CONSECUTIVO REQUISICION' ,MIDATA.SOLICITANTE AS SOLICITANTE, MIDATA.AREA AS AREA, MIDATA.CARGO AS CARGO, MIDATA.CENTRO_OPERACION AS CENTRO_OPERACION,MIDATA.[FECHA DE SOLICITUD] AS FECHA_SOLICITUD, MIDATA.[FECHA DE APROBACION] AS FECHA_APROBACION, MIDATA.[ITEM APROBADO] AS 'ITEMS APROBADOS', COALESCE(MIDATA.[ITEM NO APROBADO],0) AS 'ITEMS NO APROBADOS', \r\n" + 
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
 	    	   	   	   				"	   ORDER BY CONVERT(VARCHAR(16),MIDATA.[FECHA DE SOLICITUD],20) ASC";
 	    	   	   	   		Connection Conexiontablay = null;
 	    	   	   	       	try {
 	    	   	   	       		Conexiontablay=conectardata.miconexion(Conexiontablay);;
 	    	   	   	   			PreparedStatement ps =Conexiontablay.prepareStatement(Queryyx);
 	    	   	   	   	       	ResultSet rs = ps.executeQuery();
 	    	   	   	   	        while(rs.next()) {
 	    	   	   	        	itemsaprobadosC.add(new requisicionesgen(
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
 	    	   	   	     try { 	
 		    	   	   	      DetalleFechaItemsController.this.getThistableviewff().setItems(itemsaprobadosC);
 		    	   	  	   	}catch(NullPointerException nn) {
 	  	        				
 	             	    		 finalstage.close();  
 	     	    	           }
 	    	 	    	   	   	   			 }
 	    	   	   	       	}catch(SQLException eee) {
 	    	   	   	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, eee);
 	    	   	   	       	} 
 	    	   	   	 	   }
    			  finalstage.close();
         			});
         			contenido.setActions(cerrar);
         			dialogo.show();
                }
               if (booleano== false) {
             	  	Mensaje cancelmsj = new Mensaje();
             	  	cancelmsj.Usercancelmessage(stackpanefinalitems);
                    }
               if (midocword != null) {
                   try (FileOutputStream outputStream = new FileOutputStream(midocword.getAbsolutePath())) {
                  	 requisicionesaprobadas.write(outputStream);
                  	 requisicionesaprobadas.close();
                   }
                   catch (IOException e1) {    
                   }
                } 
   			  }
  			   
  			   
   		   }catch(Exception e1) { 
   		 }
		});
	}

	public static void combinarceldasverticalmente(XWPFTable tabla, int col, int finicial, int ffinal) {
        for (int rowIndex = finicial; rowIndex <= ffinal; rowIndex++) {
            XWPFTableCell cell = tabla.getRow(rowIndex).getCell(col);
            if ( rowIndex == finicial ) {
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
        }
    
    public void mergeCellsHorizontal(XWPFTable table, int row, int startCol,int endCol) {
    	  for (int cellIndex = startCol; cellIndex <= endCol; cellIndex++) {
    	    XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
    	    if (cellIndex == startCol) {
    	      cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
    	    } else {
    	      cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
    	    }
    	  }
    	}
    
    public void setTableAlign(XWPFTable table,ParagraphAlignment align) {
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTJc jc = (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc());
        STJc.Enum en = STJc.Enum.forInt(align.getValue());
        jc.setVal(en);
    }

	public static void main(String[] args) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		styledtextfield();
		generarequisicionfinal();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}
}
