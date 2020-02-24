package application;

import java.time.LocalDateTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aprobacion {

	
	    private StringProperty  estadoreqdt;
	    private StringProperty solicitantereqdt;
		private StringProperty AreaReqdt;
		private StringProperty CargoReqdt;
		private StringProperty Centroop; 
		private ObjectProperty <LocalDateTime> FechasolicitudReqdt;
		private StringProperty ConsecutivoReqdt; 
		
		 
	
		public Aprobacion (String estadoreqdt,String solicitantereqdt, String AreaReqdt,  String CargoReqdt, String Centroop , LocalDateTime FechasolicitudReqdt ,String ConsecutivoReqdt  ) {
			 
			 this.estadoreqdt= new SimpleStringProperty (estadoreqdt);
			 this.solicitantereqdt= new SimpleStringProperty (solicitantereqdt);
			 this.AreaReqdt=new SimpleStringProperty (AreaReqdt);
			 this.CargoReqdt= new SimpleStringProperty(CargoReqdt);
			 this.Centroop=new SimpleStringProperty(Centroop);
			 this.FechasolicitudReqdt=  new SimpleObjectProperty<LocalDateTime> (FechasolicitudReqdt);
			 this.ConsecutivoReqdt= new SimpleStringProperty (ConsecutivoReqdt);

		}
		
	
		public String getEstadoreqdt() {
			return estadoreqdt.get();
		}


		public void setEstadoreqdt(StringProperty estadoreqdt) {
			this.estadoreqdt = new SimpleStringProperty();
		}


		public String getSolicitantereqdt() {
			return solicitantereqdt.get();
		}


		public void setSolicitantereqdt(StringProperty solicitantereqdt) {
			this.solicitantereqdt = new SimpleStringProperty();
		}


		public String getAreaReqdt() {
			return AreaReqdt.get();
		}
	    
		public void setareareqdt(StringProperty AreaReqdt) {
			this.AreaReqdt = new SimpleStringProperty();
			
		}
		
		public String getCargoReqdt() {
			return CargoReqdt.get();
		}
	   
		public void setCargoReqdt(StringProperty CargoReqdt) {
			this.CargoReqdt= new SimpleStringProperty();
		}
	
		public LocalDateTime getFechasolicitudReqdt() {
			return FechasolicitudReqdt.get();			
		}
		
		public void setFechasolicitudReqdt(LocalDateTime FechasolicitudReqdt) {
			this.FechasolicitudReqdt= new SimpleObjectProperty<>(FechasolicitudReqdt);
		}
		
		public ObjectProperty<LocalDateTime> FechasolicitudReqdtProperty(){
			return FechasolicitudReqdt;
			
		}
		
		public String getConsecutivoReqdt() {
			return ConsecutivoReqdt.get();
		}
	
		public void setConsecutivoReqdt(StringProperty ConsecutivoReqdt) {
			this.ConsecutivoReqdt= new SimpleStringProperty();
		}


		public String getCentroop() {
			return Centroop.get();
		}


		public void setCentroop(StringProperty centroop) {
			Centroop = new SimpleStringProperty();;
		}


	

}
