package application;

import java.time.LocalDateTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Requisiciones {
	private StringProperty revisioncol;

    private StringProperty aprobacion;
    private IntegerProperty idreq;
	private StringProperty ConsecutivoReq;
	private StringProperty SolicitanteReq;
	private StringProperty AreaReq;
	private StringProperty CargoReq;
	private StringProperty CentroOp;
    private ObjectProperty <LocalDateTime> FechasolicitudReq;


    
	public Requisiciones ( String revisioncol, String aprobacion, Integer idreq,String ConsecutivoReq,  String SolicitanteReq, String AreaReq, String CargoReq , LocalDateTime FechasolicitudReq ,String CentroOp   ) {
		 
		 this.revisioncol =  new SimpleStringProperty(revisioncol);
		 this.aprobacion= new SimpleStringProperty (aprobacion);
		 this.idreq=  new SimpleIntegerProperty (idreq);
		 this.ConsecutivoReq=new SimpleStringProperty (ConsecutivoReq);
		 this.SolicitanteReq= new SimpleStringProperty(SolicitanteReq);
		 this.AreaReq= new SimpleStringProperty(AreaReq);
		 this.CargoReq= new SimpleStringProperty(CargoReq);
		 this.FechasolicitudReq=  new SimpleObjectProperty<LocalDateTime> (FechasolicitudReq);
		 this.CentroOp = new SimpleStringProperty(CentroOp);
		 
	}
	
	


	public void setRevisioncol( String revisioncol ) {
	    this.revisioncol.set(revisioncol);
	}

	public String getRevisioncol() {
	    return revisioncol.get();
	}
	
	public StringProperty RevisioncolProperty() {
	    return revisioncol;
	}
	
	
	
	public String getAprobacion() {
		return aprobacion.get();
	}

	public void setAprobacion(String aprobacion) {
		this.aprobacion = new SimpleStringProperty();
	}


	public String getConsecutivoReq() {
		return ConsecutivoReq.get();
	}
	
	public void setConsecutivoReq(String ConsecutivoReq) {
		this.ConsecutivoReq= new SimpleStringProperty();
	}
	
	
	public String getSolicitanteReq() {
		return SolicitanteReq.get();
	}
	
	public void setSolicitanteReq(String SolicitanteReq) {
		this.SolicitanteReq= new SimpleStringProperty();
	}
	
	public String getAreaReq() {
	  return AreaReq.get();
	}
	
	public void setAreaReq(String AreaReq) {
		this.AreaReq= new SimpleStringProperty();
	}
	
	public String getCargoReq() {
		return CargoReq.get();
	}
	
	public void setCargoReq() {
		this.CargoReq= new SimpleStringProperty();
	}
	
	public LocalDateTime getFechasolicitudReq() {
		 return FechasolicitudReq.get();
	}

	public void setFechasolicitudReq(LocalDateTime FechasolicitudReq) {
		this.FechasolicitudReq = new SimpleObjectProperty<> (FechasolicitudReq);
	}
	
	public ObjectProperty<LocalDateTime> FechasolicitudReqProperty() {
		 return FechasolicitudReq;
	}
	


	public Integer getIdreq() {
		return idreq.get();
	}


	public void setIdreq(Integer idreq) {
		this.idreq = new SimpleIntegerProperty();
	}




	public String getCentroOp() {
		return CentroOp.get();
	}




	public void setCentroOp(StringProperty centroOp) {
		CentroOp = new SimpleStringProperty();
	}


}