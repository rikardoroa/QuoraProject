package application;


import java.time.LocalDateTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemsDetalle {

	private StringProperty solicitantereqsinapro;
    private StringProperty concecutivoreqsinapro;
    private StringProperty area;
	private StringProperty cargo;
	private StringProperty centroop;
	private ObjectProperty <LocalDateTime> fechasolreqsinapro;
	private IntegerProperty  cantidaditemsinapro;
	private StringProperty itemapro;
	
	
	public ItemsDetalle (String solicitantereqsinapro, String concecutivoreqsinapro, String area, String Cargo, String centroop,LocalDateTime  fechasolreqsinapro, Integer cantidaditemsinapro, String itemapro ) {
		this.solicitantereqsinapro=new SimpleStringProperty(solicitantereqsinapro);
		this.concecutivoreqsinapro = new SimpleStringProperty(concecutivoreqsinapro);
		this.area = new SimpleStringProperty(area);
		this.cargo = new SimpleStringProperty(Cargo);
		this.centroop = new SimpleStringProperty(centroop);
		this.fechasolreqsinapro = new SimpleObjectProperty<LocalDateTime>(fechasolreqsinapro);
		this.cantidaditemsinapro = new SimpleIntegerProperty(cantidaditemsinapro);
		this.itemapro = new SimpleStringProperty(itemapro);
		
		
	}


	public String getArea() {
		return area.get();
	}
	public void setArea(StringProperty area) {
		this.area = new SimpleStringProperty();
	}

	public String getCargo() {
		return cargo.get();
	}


	public void setCargo(StringProperty cargo) {
		this.cargo = new SimpleStringProperty();
	}


	public Integer getCantidaditemsinapro() {
		return cantidaditemsinapro.get();
	}


	public void setCantidaditemsinapro(Integer cantidaditemsinapro) {
		this.cantidaditemsinapro = new SimpleIntegerProperty();
	}


	public String getItemapro() {
		return itemapro.get();
	}


	public void setItemapro(StringProperty itemapro) {
		this.itemapro = new SimpleStringProperty();
	}


	public LocalDateTime getFechasolreqsinapro() {
		return fechasolreqsinapro.get();
	}


	public void setFechasolreqsinapro(LocalDateTime fechasolreqsinapro) {
		this.fechasolreqsinapro = new SimpleObjectProperty<>(fechasolreqsinapro);
	}

	
	public ObjectProperty<LocalDateTime> FechasolreqsinaproProperty(){
		return fechasolreqsinapro;
		
	}

	public String getConcecutivoreqsinapro() {
		return concecutivoreqsinapro.get();
	}


	public void setConcecutivoreqsinapro(StringProperty concecutivoreqsinapro) {
		this.concecutivoreqsinapro = new SimpleStringProperty();
	}


	public String getSolicitantereqsinapro() {
		return solicitantereqsinapro.get();
	}


	public void setSolicitantereqsinapro(StringProperty solicitantereqsinapro) {
		this.solicitantereqsinapro = new SimpleStringProperty();
	}


	public String getCentroop() {
		return centroop.get();
	}


	public void setCentroop(StringProperty centroop) {
		this.centroop = new SimpleStringProperty();
	}

	
	
}
