package application;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Incidentes {

	private IntegerProperty IdIncidente;
	private StringProperty ConcecutivoIncidente;
	private ObjectProperty <LocalDate> fechasolicitud;
	private SimpleStringProperty Solicitudin;
	private StringProperty Solicitante;
	private StringProperty area;
	private StringProperty comentarios;
	private StringProperty ConcecutivoRincidente;

	public Incidentes (Integer IdIncidente,  String ConcecutivoIncidente, LocalDate fechasolicitud,String Solicitudin,String Solicitante, String area, String comentarios,String ConcecutivoRincidente ) 
	{
		 this.IdIncidente=new SimpleIntegerProperty (IdIncidente);
		 this.ConcecutivoIncidente= new SimpleStringProperty(ConcecutivoIncidente);
		 this.fechasolicitud=  new SimpleObjectProperty<LocalDate> (fechasolicitud);
		 this.Solicitudin=  new SimpleStringProperty (Solicitudin);
		 this.Solicitante=  new SimpleStringProperty (Solicitante);
	     this.area= new SimpleStringProperty ( area);
	     this.comentarios= new SimpleStringProperty ( comentarios);
	     this.ConcecutivoRincidente= new SimpleStringProperty ( ConcecutivoRincidente);
	    
	}


	public Integer getIdIncidente() {
		return IdIncidente.get();
	}


	public void setIdIncidente(Integer idIncidente) {
		this.IdIncidente = new SimpleIntegerProperty ();
	}


	public String getConcecutivoIncidente() {
		return ConcecutivoIncidente.get();
	}


	public void setConcecutivoIncidente(StringProperty concecutivoIncidente) {
		ConcecutivoIncidente = new SimpleStringProperty();
	}

	public LocalDate getfechasolicitud() {
		return fechasolicitud.get();
	}


	public void setFechaprogramada(LocalDate fechasolicitud) {
		this.fechasolicitud = new SimpleObjectProperty<> (fechasolicitud);
	}

	public ObjectProperty<LocalDate> fechasolicitudProperty() {
		return fechasolicitud;
	}
	

	public String getSolicitudin() {
		return Solicitudin.get();
	}


	public void setSolicitudin(StringProperty solicitudin) {
		Solicitudin = new SimpleStringProperty();
	}


	public String getSolicitante() {
		return Solicitante.get();
	}

	public void setSolicitante(StringProperty solicitante) {
		Solicitante = new SimpleStringProperty();
	}

	public String getArea() {
		return area.get();
	}


	public void setArea(StringProperty area) {
		this.area = new SimpleStringProperty();
	}


	public String getComentarios() {
		return comentarios.get();
	}


	public void setComentarios(StringProperty comentarios) {
		this.comentarios = new SimpleStringProperty();
	}


	public String getConcecutivoRincidente() {
		return ConcecutivoRincidente.get();
	}


	public void setConcecutivoRincidente(StringProperty concecutivoRincidente) {
		ConcecutivoRincidente = new SimpleStringProperty();
	}


}
