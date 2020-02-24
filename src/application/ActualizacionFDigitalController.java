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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import com.jfoenix.controls.JFXButton;
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

public class ActualizacionFDigitalController extends Application implements Initializable {
	
	@FXML private JFXButton Buscausuario;
	@FXML public JFXTextField cedulacap;
	@FXML public JFXTextField nombrecap;
	@FXML public JFXTextField cargocap;
	@FXML private JFXButton cargaimagen;
	@FXML private ImageView updatefdigital;
	@FXML private  JFXButton actualizadatos;
	@FXML private StackPane staupdatefdigital;
	@FXML private Label cclabel;
	@FXML private Label nombrelabel;
	@FXML private Label cargolabel;
	public Image imageupdate;
	private FileInputStream cargaimagefile;
	private File file;
	public String cc;
	private int len;
	public int cedula;
	public String path;
	
	
    public void seleccionarusuario() {
    	Buscausuario.setOnMouseClicked(e->{
    		if(cedulacap.getText().isEmpty()) {
    		Mensaje mensaje = new Mensaje();
    		mensaje.mensajecc(staupdatefdigital);
    		}  		
    		else {
    			try {
    		   Conexion Con = new Conexion();
   	   		   cc=cedulacap.getText();
   	   		   cedula = Integer.parseInt(cc);
   	   		   String Query= "SELECT NOMBRE, CARGO FROM USUARIOS  WHERE CEDULA = '"+cedula+"'";
   	   		   Connection Conexiontabla = null;
   	   	       Conexiontabla=Con.miconexion(Conexiontabla);
   	   		   PreparedStatement ps =Conexiontabla.prepareStatement(Query);
   	   	       ResultSet rs = ps.executeQuery();
   	   	       if(rs.next()) {
   	   	        	do {
   	   	            String nombreadmin=rs.getString("NOMBRE");
   	   	        	nombrecap.setText(nombreadmin);
   	   	        	String cargo=rs.getString("CARGO");
   	   	        	cargocap.setText(cargo);
   	   		        }while(rs.next()) ;    
   	   	        }
   	   	        else {
   	   	      Mensaje mensaje = new Mensaje();
      		  mensaje.mensajedeerror(staupdatefdigital);
   	   	        }
   	       	}catch(SQLException ee) {
    	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
   	       	}
          }
        });
       }
	
    
    
    public void updateimagefile() {
    	cargaimagen.setOnAction(e->{
 		    FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            file = fileChooser.showOpenDialog(null);
            if(file==null) {
            	  Mensaje mensaje = new Mensaje();
         		  mensaje.Usercancelmessage(staupdatefdigital);
              }
            else {
            path = file.getAbsolutePath();
            BufferedImage buffer;
            try {
            	try {
 					buffer = ImageIO.read(file);
 					imageupdate= SwingFXUtils.toFXImage(buffer, null);
 				} catch (IOException ee) {
 		 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
 				}
                InputStream inputStream = new FileInputStream(path);
                imageupdate = new Image(inputStream);
                updatefdigital.setImage(imageupdate);
                cargaimagefile = new FileInputStream(file); 
                len =(int) file.length();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CreacionUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
 	      });
    	actualizadatos.setOnAction(e->{
    		if(cedulacap.getText().isEmpty()||nombrecap.getText().isEmpty()||cargocap.getText().isEmpty()) {
    			try {
    				  Mensaje mensaje = new Mensaje();
            		  mensaje.mensajerrorform(staupdatefdigital);
    		}catch(NullPointerException nn) {
    	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, nn);
    		}
    		}
    		if(updatefdigital.getImage() == null) {
    			try {
    				Mensaje mensaje = new Mensaje();
          		    mensaje.errormensajeimagen(staupdatefdigital);
    		}catch(NullPointerException mm) {
    	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, mm);
    		}
    		}
    		else {
    		Conexion Con = new Conexion();
	   		String nombre = nombrecap.getText();
	   		String Cargo = cargocap.getText();
	   		String QueryUpdate= "UPDATE USUARIOS SET FIRMA_DIGITAL= ? FROM USUARIOS   WHERE USUARIOS.CEDULA = ? AND NOMBRE=? AND CARGO=?";
	   		Connection Conexiontabla = null;
	       	try {
	       		Conexiontabla=Con.miconexion(Conexiontabla);
	       		PreparedStatement update =Conexiontabla.prepareStatement(QueryUpdate);
	       		update.setBinaryStream(1, cargaimagefile,len);
	       		update.setInt(2,cedula);
	       		update.setString(3, nombre);
	       		update.setString(4, Cargo);
	       		update.executeUpdate();
	       		Mensaje mensaje = new Mensaje();
      		    mensaje.conexionexitosa(staupdatefdigital);
	       	}catch(SQLException ee) {
	 	       	 Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ee);
	       	}
	       	cedulacap.clear();
    		nombrecap.clear();
    		cargocap.clear();
    		updatefdigital.setImage(null);
    		}
    	});
    }
    
    
    
	public static void main(String[] args) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		seleccionarusuario() ;
		updateimagefile();
	   }

	@Override
	public void start(Stage arg0) throws Exception {	
	}
}
