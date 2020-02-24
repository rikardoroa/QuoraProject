package application;

import java.io.File;
import java.io.FileNotFoundException;
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
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VerificacionDeFirmaController extends Application implements Initializable {

	@FXML private JFXTextField ccvi;
	@FXML private ImageView imagevi;
	@FXML private JFXButton visualizar;
	@FXML private StackPane stackver;
	@FXML private Image firma;
	@FXML private Label ccupdatefirma;
	@FXML private Label verfirma;
	Conexion conectar = new Conexion();
	
	public void muestraimagen() throws IOException {
		visualizar.setOnMouseClicked(ee->{
		if(ccvi.getText().isEmpty()) {
			try {
				Mensaje data = new Mensaje();
                data.datosvacios(stackver);
		}catch(NullPointerException nn) {
			nn.printStackTrace();
		}
		}  		
		else {
			try {
	   		String cc=ccvi.getText();
	   		Integer cedula = Integer.parseInt(cc);
	   		String Query= "SELECT FIRMA_DIGITAL AS FIRMA FROM USUARIOS WHERE CEDULA = '"+cedula+"'";
	   		Connection Conexiontabla = null;
	       		Conexiontabla=conectar.miconexion(Conexiontabla);
	   			PreparedStatement ps =Conexiontabla.prepareStatement(Query);
	   	       	ResultSet rs = ps.executeQuery();      
	   	    if(rs.next())
             {
	   	    	do {
                 InputStream is = rs.getBinaryStream("FIRMA");
                 OutputStream os = new FileOutputStream(new File("firma.jpg"));
                 byte[]content = new byte[1024];
                 int size = 0;
                 while((size=is.read(content))!= -1)
                 {
                 os.write(content,0,size);
                 }
                 os.close();
                 is.close();
                 firma = new Image("file:firma.jpg",311,114,true,true);
                 imagevi.setImage(firma);
             }while(rs.next()) ; 
             }
	   	    else {
                  Mensaje data = new Mensaje();
                  data.mensajedeerror(stackver);
	   	             }  
	   	        }catch(SQLException eee){
	       		eee.printStackTrace();
	   	        }catch(NullPointerException nn){
	   	        	nn.printStackTrace();
	        	}catch (FileNotFoundException e){
					e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
			}
          }
	    });
	  }
	

	
	public static void main(String[] args) {
	

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			muestraimagen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		
	}
}