package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RIncidentesController extends Application implements Initializable {
	//----------variables---///
	@FXML public TableView<RespuestaIn>  tablarincidentes;
    @FXML public TableColumn<RespuestaIn, Integer>    idrin;
    @FXML public TableColumn<RespuestaIn, String>     concecutivorin;
    @FXML public TableColumn<RespuestaIn, LocalDate>  fechapro;
    @FXML public TableColumn<RespuestaIn, String>     testimado;
    @FXML public TableColumn<RespuestaIn, LocalDate>  fejecutada;
    @FXML public TableColumn<RespuestaIn, String > hsolucion;
    @FXML public TableColumn<RespuestaIn, String > trespuesta;
    @FXML public TableColumn<RespuestaIn, String > tejecutada;
    @FXML public TableColumn<RespuestaIn, String > novedades;
    @FXML public TableColumn<RespuestaIn, String > tprioridad;
    @FXML public TableColumn<RespuestaIn, String > tverificacion;
    @FXML public TableColumn<RespuestaIn, String > cnsinc;
    @FXML public TableColumn<RespuestaIn, String > cnsincid;
	@FXML private JFXButton visualizarinc;
	@FXML private JFXButton ctiempo;
	@FXML private JFXButton exportarE;
	@FXML private StackPane stacktable;
	@FXML private TextField predicado;
	@FXML private DatePicker rincidentedfini;
	@FXML private DatePicker rincidentesf;
	@FXML private JFXTextField concecutivoin;
	@FXML private JFXTextField novedadesin;
	@FXML private  JFXButton bavanzadain;
	@FXML public BorderPane borderstacktable;
	@FXML private Label finistacktable;
	@FXML private Label ffinstacktable;
	@FXML private Label novstacktable;
	@FXML private Label cstacktable;
	@FXML private Pane borderpane;
	@FXML private Label prioridad;
	@FXML private JFXComboBox<String> comboprioridad;
	@FXML private JFXButton resetdatos;
	Connection Conexiontablar = null;
	Conexion conectar = new Conexion();
	//----------variables---///
	
	//----------------------funcion para resetear campos----------//
	public void resetearcampos() {
	 resetdatos.setOnMouseClicked(e->{
		 comboprioridad.getSelectionModel().selectFirst();	
		 rincidentedfini.setValue(null);
		 rincidentesf.setValue(null);
		 concecutivoin.clear();
		 novedadesin.clear();
	 });	
	}
	
	
	//-----------------------fin funcion--------------------------//
	
	//-------------------funcion para llenar el combobox----------//
	public void llenacomboprioridad() {
	comboprioridad.setStyle(" -fx-font-family: 'Oswald Regular';-fx-font-weight: bold; -fx-font-size: 14px;");
	comboprioridad.getItems().addAll("SIN DATO", "ALTA", "MEDIA","BAJA");
	comboprioridad.getSelectionModel().selectFirst();	
	}
	//------------------------------------------------------------//
	
	//---------funcion que captura los datos--//
	public void seleccionderdatos() {
		//---declaro la lista de coleccion de datos para capturar los datos que se van a guardar en el tableview--//
		ObservableList<RespuestaIn> Datostablarincidentes= FXCollections.observableArrayList();
		//-----------------------------------------------------------------------------------------------------//
		//-----------------------query que llama a los datos desde la bd , se realiza un coalesce para describir los datos nulos como "sin calculo"---------------------------------------------------------------------------------------------------//
		String Query= "SELECT ID,CNSRINC,FECHA_PROGRAMADA,TIEMPO_ESTIMADO,FECHA_EJECUTADA, HORA_SOLUCION,COALESCE (TIEMPO_RESPUESTA,'SIN CALCULO') AS TIEMPO_RESPUESTA ,TAREA_EJECUTADA,NOVEDADES,PRIORIDAD,VERIFICACION,CNSINC,CNSID FROM RINCIDENTES";
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    	
		//---------------------------------------realizo la conexion y llamo los datos y los guardo en la lista de coleccion de datos---//
		try {
    		Conexiontablar=conectar.miconexion(Conexiontablar);
			PreparedStatement ps =Conexiontablar.prepareStatement(Query);
	       	ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	Datostablarincidentes.add(new RespuestaIn(
                		 rs.getInt("ID"),
                		 rs.getString("CNSRINC"),
                		 rs.getDate("FECHA_PROGRAMADA").toLocalDate(), 
                		 rs.getString("TIEMPO_ESTIMADO"),
                		 rs.getDate("FECHA_EJECUTADA").toLocalDate(),
                		 rs.getString("HORA_SOLUCION"),
                		 rs.getString("TIEMPO_RESPUESTA"),
                		 rs.getString("TAREA_EJECUTADA"),
                		 rs.getString("NOVEDADES"),
                		 rs.getString("PRIORIDAD"),
                		 rs.getString("VERIFICACION"),
                		 rs.getString("CNSINC"),
                		 rs.getString("CNSID")
                		 )
                         );
	        	 tablarincidentes.setItems(Datostablarincidentes);
	        	    TableFilter<RespuestaIn> tableFilter = new TableFilter<>(tablarincidentes);
	        	    tableFilter.filterColumn(idrin);
	        	    tableFilter.filterColumn(concecutivorin);
	        	    tableFilter.filterColumn(fechapro);
	        	    tableFilter.filterColumn(testimado);
	        	    tableFilter.filterColumn(fejecutada);
	        	    tableFilter.filterColumn(hsolucion);
	        	    tableFilter.filterColumn(trespuesta);
	        	    tableFilter.filterColumn(tejecutada);
	        	    tableFilter.filterColumn(novedades);
	        	    tableFilter.filterColumn(tprioridad);
	        	    tableFilter.filterColumn(novedades);
	        	    tableFilter.filterColumn(tverificacion);
	        	    tableFilter.filterColumn(cnsinc);
	        	    tableFilter.filterColumn(cnsincid);
	        	 //-------------------------------------------------------------------------------------------------//
			 } 
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	//------------------------funcion para realizar el filtro por fechas, novedades y concecutivo------///
	public void busquedaavanzada() {
    	bavanzadain.setOnMouseClicked(e->{
    	try {
    		ObservableList<RespuestaIn> Datostablarincidentesa= FXCollections.observableArrayList();
    		String nov=novedadesin.getText().toString();
    		String ffini=((TextField)rincidentedfini.getEditor()).getText();
    		String ffin=((TextField)rincidentesf.getEditor()).getText();
    		String co=concecutivoin.getText().toString();
    		String QueryX="SELECT ID,CNSRINC, FECHA_PROGRAMADA,TIEMPO_ESTIMADO,FECHA_EJECUTADA, HORA_SOLUCION,TIEMPO_RESPUESTA,TAREA_EJECUTADA, NOVEDADES, PRIORIDAD,VERIFICACION,CNSINC,CNSID  FROM RINCIDENTES WHERE FECHA_EJECUTADA>= ? AND FECHA_EJECUTADA<= ? AND NOVEDADES LIKE ? AND CNSRINC LIKE ?";
    		Conexiontablar=conectar.miconexion(Conexiontablar);
			PreparedStatement ps =Conexiontablar.prepareStatement(QueryX);
			ps.setString(1, ffini);
			ps.setString(2, ffin);
	        ps.setString(3,  "%" +nov+ "%");
	        ps.setString(4,  "%" +co+ "%");
	     	ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	Datostablarincidentesa.add(new RespuestaIn(
                		 rs.getInt("ID"),
                		 rs.getString("CNSRINC"),
                		 rs.getDate("FECHA_PROGRAMADA").toLocalDate(), 
                		 rs.getString("TIEMPO_ESTIMADO"),
                		 rs.getDate("FECHA_EJECUTADA").toLocalDate(),
                		 rs.getString("HORA_SOLUCION"),
                		 rs.getString("TIEMPO_RESPUESTA"),
                		 rs.getString("TAREA_EJECUTADA"),
                		 rs.getString("NOVEDADES"),
                		 rs.getString("PRIORIDAD"),
                		 rs.getString("VERIFICACION"),
                		 rs.getString("CNSINC"),
                		 rs.getString("CNSID")
                		 )
                         );
			 }
	    	tablarincidentes.setItems(Datostablarincidentesa);
	        Mensaje dataobject = new Mensaje();
 		    dataobject.mensaje(tablarincidentes, stacktable);
    	}
    	catch(SQLException ee) {
    		ee.printStackTrace();
    	}
    	});
	}
	 //----------------------------------------------------------------------------------------------------//
	
	//-------------------ejecucion de botones para llamar a las funciones---------//
	public void mostrardatostablarin() {
		visualizarinc.setOnMouseClicked(e->{
			seleccionderdatos();
		});
	}
	
	public void calculotiempoboton() {
		ctiempo.setOnMouseClicked(e->{
			calculotiemporespuesta();
		});
	}
	 //------------------------------------------------------------------------------//
	
public void muestravalorestablar() {
		tablarincidentes.setOnMouseClicked(e->{
		    FXMLLoader carga = new FXMLLoader();
		    carga.setLocation(getClass().getResource("Tablarupdate.fxml"));
			try {
				carga.load();
			} catch (IOException e1) {
				e1.printStackTrace();
				 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, e);
			}
			try {
			Parent StackPane=carga.getRoot();
			TablaUpdate update = carga.<TablaUpdate>getController();
			RespuestaIn items=tablarincidentes.getSelectionModel().getSelectedItem();
			LocalDate a=items.getFechaprogramada();
			update.fprogramadai.setText(a.toString());
			String k=items.getTiempoe();
			update.testimadoi.setText(k);
			LocalDate d=items.getFechaejecutada();
			update.fejcutadai.setText(d.toString());
			String f=items.getHoraSol();
			update.hsolucioni.setText(f);
			String t=items.getTiempor();
			update.trespuestai.setText(t);
			String ja=items.getTareaejecutada();
			update.tejecutadai.setText(ja);
			String h=items.getNovedades();
			update.novedadesi.setText(h);
			String i=items.getPrioridad();
			update.prioridadi.setText(i);
			String m=items.getVerificacion();
			update.verificacioni.setText(m);
			Stage tablarstage=new Stage();
			tablarstage.focusedProperty().addListener(new ChangeListener<Boolean>()
			{
			  @Override
			  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			  {
			    if(newValue == false) {
			    RIncidentesController.this.tablarincidentes.setDisable(true);
			  }
			  }
			});
			tablarstage.showingProperty().addListener(new ChangeListener<Boolean>()
			{
			  @Override
			  public void changed(ObservableValue<? extends Boolean> b, Boolean oldValue, Boolean newValue)
			  {
			    if(newValue == false) {
			    RIncidentesController.this.tablarincidentes.setDisable(false);
			   }
			  }
			});
			tablarstage.setScene(new Scene(StackPane));
			StackPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			tablarstage.setTitle("Detalle");
			tablarstage.show();
			}catch(NullPointerException nn) {
				System.out.println("fila sin datos"); 
			     }
		       });
		     }


	public void calculotiemporespuesta() {
		Connection calculotiempoprocedure = null;
    	try {
    		calculotiempoprocedure=conectar.miconexion(calculotiempoprocedure);
			CallableStatement vinculartiempo = calculotiempoprocedure.prepareCall("{call CALCULOTIEMPO}");
			vinculartiempo.execute();
			vinculartiempo.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public void ExportarExcel() {
		String Query="SELECT FECHA_SOLICITUD, SOLICITUD , PRIORIDAD ,SOLICITANTE, NOMBRE ,FECHA_PROGRAMADA,TIEMPO_ESTIMADO ,FECHA_EJECUTADA , HORA_SOLUCION ,TIEMPO_RESPUESTA ,TAREA_EJECUTADA ,NOVEDADES ,VERIFICACION  FROM INCIDENTES INNER JOIN RINCIDENTES ON INCIDENTES.ID = RINCIDENTES.CNSID AND INCIDENTES.CNSINC= RINCIDENTES.CNSINC AND INCIDENTES.CNSRINC = RINCIDENTES.CNSRINC AND INCIDENTES.CNSRID = RINCIDENTES.ID INNER JOIN AREA ON INCIDENTES.AREA = AREA.CNSAREA";
		Connection Conexion = null;
    	try {
    		  Conexion=conectar.miconexion(Conexion);
			  PreparedStatement ps =Conexion.prepareStatement(Query);
	       	  ResultSet rs = ps.executeQuery();
	     	  XSSFWorkbook milibroexcel = new XSSFWorkbook();
              XSSFSheet  mihoja = milibroexcel.createSheet("PLANILLA DE SISTEMAS");
              XSSFRow cabecera =  mihoja.createRow(0);
              cabecera.createCell(0).setCellValue("FECHA DE SOLICITUD");
              cabecera.createCell(1).setCellValue("SOLICITUD");
              cabecera.createCell(2).setCellValue("PRIORIDAD");
              cabecera.createCell(3).setCellValue("SOLICITANTE");
              cabecera.createCell(4).setCellValue("AREA");
              cabecera.createCell(5).setCellValue("FECHA PROGRAMADA");
              cabecera.createCell(6).setCellValue("TIEMPO ESTIMADO DE SOLUCION");
              cabecera.createCell(7).setCellValue("FECHA DE EJECUCION");
              cabecera.createCell(8).setCellValue("HORA DE SOLUCION");
              cabecera.createCell(9).setCellValue("TIEMPO DE RESPUESTA");
              cabecera.createCell(10).setCellValue("TAREA EJECUTADA");
              cabecera.createCell(11).setCellValue("NOVEDADES");
              cabecera.createCell(12).setCellValue("VERIFICACION DE COORDINADOR");
              mihoja.setColumnWidth(0, 7000);
              mihoja.setColumnWidth(1, 7000);
              mihoja.setColumnWidth(2, 7000);
              mihoja.setColumnWidth(3, 7000);
              mihoja.setColumnWidth(4, 7000);
              mihoja.setColumnWidth(5, 7000);
              mihoja.setColumnWidth(6, 7000);
              mihoja.autoSizeColumn(7);
              mihoja.autoSizeColumn(8);
              mihoja.setColumnWidth(9, 7000);
              mihoja.setColumnWidth(10, 7000);
              mihoja.setColumnWidth(11, 7000);
              mihoja.setColumnWidth(12, 7000);
              XSSFCellStyle style = milibroexcel.createCellStyle();
              style.setFillForegroundColor(IndexedColors.RED1.index);
              style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
              XSSFCellStyle micellstylealta = milibroexcel.createCellStyle();
              XSSFCellStyle micellstylemedia = milibroexcel.createCellStyle();
              XSSFCellStyle micellstylebaja = milibroexcel.createCellStyle();
              micellstylealta.setFillForegroundColor(new XSSFColor(new java.awt.Color(255,102,102), new DefaultIndexedColorMap()));
              micellstylealta.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              micellstylealta.setFillBackgroundColor(IndexedColors.YELLOW.index);
              Font celdafondouno = milibroexcel.createFont();
              celdafondouno.setColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
              micellstylealta.setFont(celdafondouno);
              micellstylealta.setBorderLeft(BorderStyle.THICK);             
              micellstylealta.setBorderRight(BorderStyle.THICK);            
              micellstylealta.setBorderTop(BorderStyle.THICK);              
              micellstylealta.setBorderBottom(BorderStyle.THICK);
              micellstylealta.setBorderColor(BorderSide.TOP, new XSSFColor(new java.awt.Color(255,255,0), new DefaultIndexedColorMap()));
              micellstylealta.setBorderColor(BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(255,255,0), new DefaultIndexedColorMap()));
              micellstylealta.setBorderColor(BorderSide.RIGHT, new XSSFColor(new java.awt.Color(255,255,0), new DefaultIndexedColorMap()));
              micellstylealta.setBorderColor(BorderSide.LEFT, new XSSFColor(new java.awt.Color(255,255,0), new DefaultIndexedColorMap()));
              micellstylemedia.setFillForegroundColor(new XSSFColor(new java.awt.Color(255,255,140), new DefaultIndexedColorMap()));
              micellstylemedia.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              micellstylemedia.setFillBackgroundColor(new XSSFColor(new java.awt.Color(255,79,79), new DefaultIndexedColorMap()));
              XSSFColor color_rellenomedia = getXSSFColor("FF4F4F");
              XSSFFont celdafondomedia = milibroexcel.createFont();
              celdafondomedia.setColor(color_rellenomedia);
              micellstylemedia.setFont(celdafondomedia);
              micellstylemedia.setBorderLeft(BorderStyle.THICK);             
              micellstylemedia.setBorderRight(BorderStyle.THICK);            
              micellstylemedia.setBorderTop(BorderStyle.THICK);              
              micellstylemedia.setBorderBottom(BorderStyle.THICK);
              micellstylemedia.setBorderColor(BorderSide.TOP, new XSSFColor(new java.awt.Color(255,79,79), new DefaultIndexedColorMap()));
              micellstylemedia.setBorderColor(BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(255,79,79), new DefaultIndexedColorMap()));
              micellstylemedia.setBorderColor(BorderSide.RIGHT, new XSSFColor(new java.awt.Color(255,79,79), new DefaultIndexedColorMap()));
              micellstylemedia.setBorderColor(BorderSide.LEFT, new XSSFColor(new java.awt.Color(255,79,79), new DefaultIndexedColorMap()));
              micellstylebaja.setFillForegroundColor(new XSSFColor(new java.awt.Color(138,255,138), new DefaultIndexedColorMap()));
              micellstylebaja.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              micellstylebaja.setFillBackgroundColor(new XSSFColor(new java.awt.Color(0,107,159), new DefaultIndexedColorMap()));
              XSSFColor color_rellenobaja = getXSSFColor("006B9F");
              XSSFFont celdafondobaja = milibroexcel.createFont();
              celdafondobaja.setColor(color_rellenobaja);
              micellstylebaja.setFont(celdafondobaja);
              micellstylebaja.setBorderLeft(BorderStyle.THICK);             
              micellstylebaja.setBorderRight(BorderStyle.THICK);            
              micellstylebaja.setBorderTop(BorderStyle.THICK);              
              micellstylebaja.setBorderBottom(BorderStyle.THICK);
              micellstylebaja.setBorderColor(BorderSide.TOP, new XSSFColor(new java.awt.Color(0,107,159), new DefaultIndexedColorMap()));
              micellstylebaja.setBorderColor(BorderSide.BOTTOM, new XSSFColor(new java.awt.Color(0,107,159), new DefaultIndexedColorMap()));
              micellstylebaja.setBorderColor(BorderSide.RIGHT, new XSSFColor(new java.awt.Color(0,107,159), new DefaultIndexedColorMap()));
              micellstylebaja.setBorderColor(BorderSide.LEFT, new XSSFColor(new java.awt.Color(0,107,159), new DefaultIndexedColorMap()));
              Font celdafondo= milibroexcel.createFont();
              celdafondo.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
              style.setFont(celdafondo);
              cabecera.getCell(0).setCellStyle(style);
              cabecera.getCell(1).setCellStyle(style);
              cabecera.getCell(2).setCellStyle(style);
              cabecera.getCell(3).setCellStyle(style);
              cabecera.getCell(4).setCellStyle(style);
              cabecera.getCell(5).setCellStyle(style);
              cabecera.getCell(6).setCellStyle(style);
              cabecera.getCell(7).setCellStyle(style);
              cabecera.getCell(8).setCellStyle(style);
              cabecera.getCell(9).setCellStyle(style);
              cabecera.getCell(10).setCellStyle(style);
              cabecera.getCell(11).setCellStyle(style);
              cabecera.getCell(12).setCellStyle(style);
              int siguientefilaenellibro=1;
              while ( rs.next() ) 
              {
            	  XSSFRow cabecerasiguientefila =  mihoja.createRow(siguientefilaenellibro);
            	  cabecerasiguientefila.createCell(0).setCellValue(rs.getDate("FECHA_SOLICITUD").toLocalDate().toString());
            	  cabecerasiguientefila.createCell(1).setCellValue(rs.getString("SOLICITUD"));
            	  cabecerasiguientefila.createCell(2).setCellValue(rs.getString("PRIORIDAD"));
            	  cabecerasiguientefila.createCell(3).setCellValue(rs.getString("SOLICITANTE"));
            	  cabecerasiguientefila.createCell(4).setCellValue(rs.getString("NOMBRE"));
            	  cabecerasiguientefila.createCell(5).setCellValue(rs.getString("FECHA_PROGRAMADA"));
            	  cabecerasiguientefila.createCell(6).setCellValue(rs.getString("TIEMPO_ESTIMADO"));
            	  cabecerasiguientefila.createCell(7).setCellValue(rs.getDate("FECHA_EJECUTADA").toString());
            	  cabecerasiguientefila.createCell(8).setCellValue(rs.getString("HORA_SOLUCION"));
            	  cabecerasiguientefila.createCell(9).setCellValue(rs.getString("TIEMPO_RESPUESTA"));
            	  cabecerasiguientefila.createCell(10).setCellValue(rs.getString("TAREA_EJECUTADA"));
            	  cabecerasiguientefila.createCell(11).setCellValue(rs.getString("NOVEDADES"));
            	  cabecerasiguientefila.createCell(12).setCellValue(rs.getString("VERIFICACION"));
            	  siguientefilaenellibro++;
              }
              XSSFRow fila;
              XSSFSheet spreadsheet = milibroexcel.getSheetAt(0);
              Iterator < Row > filaIterator = spreadsheet.iterator();
              while (filaIterator.hasNext())
              {
              fila = (XSSFRow) filaIterator.next();
              Iterator < Cell > cellIterator = fila.cellIterator();
              while ( cellIterator.hasNext())
              {
              Cell celda = cellIterator.next();
              if(celda.getStringCellValue().contains("ALTA")) {
            	 celda.setCellStyle(micellstylealta);
              }
              if(celda.getStringCellValue().contains("MEDIA")) {
             	 celda.setCellStyle(micellstylemedia);
               }
              if(celda.getStringCellValue().contains("BAJA")) {
              	 celda.setCellStyle(micellstylebaja);
              }
              }
              }
              FileChooser guardarexcel = new FileChooser();
              FileChooser.ExtensionFilter excelfiltro = new FileChooser.ExtensionFilter("Archivos De Excel (*.xlsx)", "*.xlsx");
              guardarexcel.getExtensionFilters().add(excelfiltro);
              File miarchivoexcel = guardarexcel.showSaveDialog(null);
              if (miarchivoexcel != null) {
                  try (FileOutputStream outputStream = new FileOutputStream(miarchivoexcel.getAbsolutePath())) {
                  	 milibroexcel.write(outputStream);
                  	 milibroexcel.close();
                  }
                  catch (IOException ex) {    
                  }
              }
    	}catch(SQLException e) {
    		e.printStackTrace();
		}
	}
	
	protected static XSSFColor getXSSFColor(String RGB) {
		int red = Integer.parseInt(RGB.substring(0,2), 16);
		int green = Integer.parseInt(RGB.substring(2,4), 16);
		int blue = Integer.parseInt(RGB.substring(4,6), 16);   
		return new XSSFColor(new byte[] { (byte) red, (byte) green, (byte) blue }, null);
	}

	public void guardarexcel() {
		exportarE.setOnMouseClicked(e->{
		ExportarExcel();
		}
		);
	}
	public static void main(String[] args) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idrin.setCellValueFactory(new PropertyValueFactory <RespuestaIn,Integer>("IdRincidente"));
		concecutivorin.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("ConcecutivoRin"));
		fechapro.setCellValueFactory(CellData -> CellData.getValue().fechaprogramadaProperty());
		testimado.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("tiempoe"));
		fejecutada.setCellValueFactory(CellData -> CellData.getValue().fechaejecutadaProperty());
		hsolucion.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("horaSol"));
		trespuesta.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("tiempor"));
		tejecutada.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("tareaejecutada"));
		novedades.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("novedades"));
		tprioridad.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("prioridad"));
		tverificacion.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("verificacion"));
		cnsinc.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("concecutivoincidente"));
		cnsincid.setCellValueFactory(new PropertyValueFactory <RespuestaIn,String>("concecutivoincidenteid"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		fechapro.setCellFactory(column -> {
	         return new TableCell<RespuestaIn, LocalDate>() {
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
		fejecutada.setCellFactory(column -> {
	         return new TableCell<RespuestaIn, LocalDate>() {
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
		tprioridad.setCellFactory(column -> {
	         return new TableCell<RespuestaIn, String>() {
	             @Override
	             protected void updateItem(String item, boolean empty) {
	                 super.updateItem(item, empty);
	                 if (item == null || empty) {
	                     setText(null);
	                     this.setTextFill(Color.WHITE);
	                     setStyle("-fx-background-color: none; ");
	                 } else {
	                	 if(item.contains("ALTA")) {
	                		 this.setTextFill(Color.YELLOW);
	                         setText(item);
	                         setStyle("-fx-background-color: rgb(255,102,102);-fx-border-color: rgb(255,255,0); -fx-border-width:3px; ");
	                	    }
	                      if(item.contains("MEDIA")) {
		                     this.setTextFill(Color.RED);
		                     setText(item);
		                     setStyle("-fx-background-color:rgb(255,255,140); -fx-border-color: rgb(255,79,79); -fx-border-width:3px; "); 
	                        }
	                      if(item.contains("BAJA")) {
		                    this.setTextFill(Color.BLUE);
		                    setText(item);
		                    setStyle("-fx-background-color: rgb(138,255,138); -fx-border-color:  rgb(0,107,159); -fx-border-width:3px; "); 
	                        }
	                      }
	                   }
	                 };
	              });
		mostrardatostablarin();
		calculotiempoboton() ;
		guardarexcel();
		muestravalorestablar();
		busquedaavanzada();
		llenacomboprioridad();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}
}