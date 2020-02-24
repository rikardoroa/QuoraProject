package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CreacionUserController  extends Application implements Initializable {

	
	@FXML private StackPane stpanecuser;
	@FXML private JFXButton creauser;
	@FXML private JFXTextField nombreuser;
	@FXML private JFXTextField nuser;
	@FXML private JFXTextField capcedula;
	@FXML private JFXComboBox <String> areauser;
	@FXML private JFXPasswordField passuser;
	@FXML private JFXComboBox <String> roluser;
	@FXML private JFXComboBox <String> coperacioncombo;
    @FXML private JFXComboBox <String>cargouser; 
	@FXML private ImageView fdigital;
    @FXML public JFXButton cargafirma;
    @FXML private Label nnuser; 
    @FXML private Label uuser;
    @FXML private Label ccuser;
    @FXML private Label contrasenauser;
    @FXML private Label roluserc;
    @FXML private Label cargocuser;
    @FXML private Label areacuser;
    @FXML private Label firmacuser;
    @FXML private Label coperacionlabel;
    private Image image;
    private FileInputStream fin;
    private File file;
	private int len;
    public String path;
 
    
    //lleno combobox
	public void llenacombouser() {
	areauser.getItems().addAll("Sistemas", "Contabilidad", "Comercial", "Gerencia", "Farmacia", "Ventas","Compras","Administrativa","Archivo","Logistica","Calidad","Talento Humano", "Comunicaciones", "Tesoreria");
	roluser.getItems().addAll("ADMINISTRADOR","USUARIO","ADMINISTRADORREQ","ADMINISTRADORREV");
	coperacioncombo.getItems().addAll("Oficina Principal","Farmacia 16 - Pueblo Nuevo","Farmacia 17 - Valencia", "Farmacia 18 - Lorica","Farmacia 24 - MontelÌbano", "Farmacia  26 MonterÌa - Camilo Torres","Farmacia  26 MonterÌa - Canta Claro","Farmacia  26 MonterÌa - La Gloria","Farmacia 26 MonterÌa - La Granja","Farmacia 26 MonterÌa - Moganbo","Farmacia  26 MonterÌa - RÌo de Janeiro","Farmacia  26 MonterÌa - San Anterito","Farmacia  26 MonterÌa - Villacielo","Farmacia - 28 Planeta Rica","Farmacia 30 - San Antero");
	cargouser.getItems().addAll("Analista de servicios farmacÈuticos","Auxiliar de servicio farmacÈutico","Auxiliar de sistemas","Asistente comercial","Asistente de gerencia","Auxiliar Administrativo","Auxiliar de Archivo","Auxiliar de Contabilidad","Auxiliar de Compras","Auxiliar de Ventas","Auxiliar de servicios generales","Auxiliar logÌstico","Conductor","Coordinador de Calidad y SST","Coordinador contable","Coordinador administrativo","Coordinador de Gestion Humana","Coordinador de Comunicaciones","Coordinador de sistemas","Director ·rea administrativa y financiera","Director ·rea comercial","Director ·rea de servicios farmacÈuticos","Director tÈcnico y administrador de servicio","Director tÈcnico","Director centro de distribuciÛn","Gerente","Mensajero","QuÌmico farmacÈutico programas especiales","Recepcionista","Representante de ventas","Tesorero");
	}
	//------------------------------------------------------------
	

    
    //funcion para crear el usuario aqui se llama la variable fin para almacenar la imagen en la bd
    public void creacionuser() {
    	cargafirma.setOnAction(e->{
    		FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            file = fileChooser.showOpenDialog(null);
            if(file==null) {
              	Mensaje usercancelmensaje = new Mensaje();
              	usercancelmensaje.Usercancelmessage(stpanecuser);
            }
            else {
            	  path = file.getAbsolutePath();
                  BufferedImage buffer;
            try {
            	try {
    				buffer = ImageIO.read(file);
    				image= SwingFXUtils.toFXImage(buffer, null);
    			} catch (IOException gg) {
    				gg.printStackTrace();
    			}
                InputStream inputStream = new FileInputStream(path);
                image = new Image(inputStream);
                fdigital.setImage(image);
            	fin = new FileInputStream(file); 
            	len= (int) file.length();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CreacionUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }          
    	});
    	 creauser.setOnAction(e->{
		if(nombreuser.getText().isEmpty()||roluser.getSelectionModel().getSelectedItem().equals("")||nuser.getText().isEmpty()||areauser.getSelectionModel().getSelectedItem().equals("")||passuser.getText().isEmpty()) {
			try {
				Mensaje ErrorMensaje = new Mensaje();
				ErrorMensaje.mensajeerror(stpanecuser);
		   }catch(NullPointerException n) {
			  n.printStackTrace();
		   }
		   }
		else {
    	try {
    		Conexion Conecta = new Conexion();
    		String User=nombreuser.getText().toString();
    		String rol= roluser.getSelectionModel().getSelectedItem();
    		String nnuser=nuser.getText().toString(); 
    		String area=areauser.getSelectionModel().getSelectedItem();
    		String Cargo=cargouser.getSelectionModel().getSelectedItem();
    		String mypass=passuser.getText().toString();
    		String Cop=coperacioncombo.getSelectionModel().getSelectedItem();
    		String CC= capcedula.getText().toString();
    		Integer cedula= Integer.parseInt(CC);
    		String Queryinsertadatauser="INSERT INTO USUARIOS (NOMBREUSUARIO,FECHA_REGISTRO,NOMBRE,CEDULA,CARGO,CENTRO_OPERACION, AREA,ROL, PASS, FIRMA_DIGITAL)VALUES( ? ,GETDATE(), ? , ? , ? , ?, ? , ? ,  ENCRYPTBYPASSPHRASE('*xc/6789o—---+y', '"+mypass+"' ), ? )";
    		Connection ConexionData = null;
    		ConexionData=Conecta.miconexion(ConexionData);
    		PreparedStatement creadatosuser = ConexionData.prepareStatement(Queryinsertadatauser);
	        creadatosuser.setString(1, nnuser);
	        creadatosuser.setString(2, User);
	        creadatosuser.setInt(3, cedula);
	        creadatosuser.setString(4, Cargo);
	        creadatosuser.setString(5, Cop);
	        creadatosuser.setString(6, area);
	        creadatosuser.setString(7, rol);
	        creadatosuser.setBinaryStream(8, fin, len);
	        creadatosuser.executeUpdate();
	        Mensaje mensajedatosconbd = new Mensaje();
	        mensajedatosconbd.mensajedatosconbd(stpanecuser);
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    	}	
		}
		   nombreuser.clear();
		   nuser.clear();
		   passuser.clear();
		   areauser.setValue("");
		   roluser.setValue(""); 
		   cargouser.setValue("");
		   capcedula.clear();
		   coperacioncombo.setValue("");
		   fdigital.setImage(null);
    	 });
	}
	//------------------------------------------------------------------------------------------------------------------

   
	public static void main(String[] args) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		llenacombouser();
		creacionuser(); 
	}

	@Override
	public void start(Stage arg0) throws Exception {
	
	}

}
