package application;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RespuestaIn {
	private IntegerProperty IdRincidente;
	private StringProperty ConcecutivoRin;
	private ObjectProperty <LocalDate> fechaprogramada;
	private StringProperty tiempoe;
	private ObjectProperty <LocalDate> fechaejecutada;
	private StringProperty horaSol;
	private StringProperty tiempor;
	private StringProperty tareaejecutada;
	private StringProperty novedades;
	private StringProperty prioridad;
	private StringProperty verificacion;
	private StringProperty concecutivoincidente;
	private StringProperty concecutivoincidenteid;
	


	public RespuestaIn (Integer IdRincidente,  String ConcecutivoRin, LocalDate fechaprogramada, String tiempoe , LocalDate fechaejecutada , String horaSol ,String tiempor ,String tareaejecutada ,String novedades ,String prioridad ,String verificacion,String concecutivoincidente,String concecutivoincidenteid ) {
		
		 this.IdRincidente=new SimpleIntegerProperty (IdRincidente);
		 this.ConcecutivoRin= new SimpleStringProperty(ConcecutivoRin);
		 this.fechaprogramada=  new SimpleObjectProperty<LocalDate> (fechaprogramada);
		 this.tiempoe=  new SimpleStringProperty (tiempoe);
		 this.fechaejecutada=  new SimpleObjectProperty<LocalDate> (fechaejecutada);;
	     this.horaSol= new SimpleStringProperty (horaSol);
	     this.tiempor= new SimpleStringProperty (tiempor);
	     this.tareaejecutada= new SimpleStringProperty (tareaejecutada);
	     this.novedades= new SimpleStringProperty (novedades);
	     this.prioridad= new SimpleStringProperty (prioridad);
	     this.verificacion= new SimpleStringProperty (verificacion);
	     this.concecutivoincidente= new SimpleStringProperty (concecutivoincidente);
	     this.concecutivoincidenteid= new SimpleStringProperty (concecutivoincidenteid);
	    
	}
	
	
	
	public Integer getIdRincidente() {
		return IdRincidente.get();
	}

	public void setIdRincidente(Integer idRincidente) {
		this.IdRincidente = new SimpleIntegerProperty ();
	}


	public String getConcecutivoRin() {
		return ConcecutivoRin.get();
	}

	public void setConcecutivoRin(StringProperty concecutivoRin) {
		this.ConcecutivoRin = new SimpleStringProperty();
	}


	public LocalDate getFechaprogramada() {
		return fechaprogramada.get();
	}


	public void setFechaprogramada(LocalDate fechaprogramada) {
		this.fechaprogramada = new SimpleObjectProperty<> (fechaprogramada);
	}

	public ObjectProperty<LocalDate> fechaprogramadaProperty() {
		return fechaprogramada;
	}


	public String getTiempoe() {
		return tiempoe.get();
	}


	public void setTiempoe(StringProperty tiempoe) {
		this.tiempoe = new SimpleStringProperty();
	}


	public LocalDate getFechaejecutada() {
		return fechaejecutada.get();
	}


	public void setFechaejecutada(LocalDate fechaejecutada) {
		this.fechaejecutada = new SimpleObjectProperty<> (fechaejecutada);
	}

	public ObjectProperty<LocalDate> fechaejecutadaProperty() {
		return fechaejecutada;
	}


	public String getHoraSol() {
		return horaSol.get();
	}


	public void setHoraSol(StringProperty horaSol) {
		this.horaSol = new SimpleStringProperty();
	}


	public String getTiempor() {
		return tiempor.get();
	}


	public void setTiempor(StringProperty tiempor) {
		this.tiempor = new SimpleStringProperty();
	}


	public String getTareaejecutada() {
		return tareaejecutada.get();
	}


	public void setTareaejecutada(StringProperty tareaejecutada) {
		this.tareaejecutada = new SimpleStringProperty();
	}



	public String getNovedades() {
		return novedades.get();
	}



	public String getConcecutivoincidente() {
		return concecutivoincidente.get();
	}



	public void setConcecutivoincidente(StringProperty concecutivoincidente) {
		this.concecutivoincidente = new SimpleStringProperty();
	}



	public String getConcecutivoincidenteid() {
		return concecutivoincidenteid.get();
	}



	public void setConcecutivoincidenteid(StringProperty concecutivoincidenteid) {
		this.concecutivoincidenteid = new SimpleStringProperty();
	}



	public String getPrioridad() {
		return prioridad.get();
	}



	public void setPrioridad(StringProperty prioridad) {
		this.prioridad = new SimpleStringProperty();
	}



	public String getVerificacion() {
		return verificacion.get();
	}


	public void setVerificacion(StringProperty verificacion) {
		this.verificacion = new SimpleStringProperty();
	}

}