package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class requisicionesgen {
	
	private StringProperty consecutivogenreq;
    private StringProperty solicitantegenreq;
	private StringProperty areagenreq;
	private StringProperty cargogenreq;
	private StringProperty centropgenreq;
	private StringProperty  fechasolgenreq;
	private StringProperty fechaaprogenreq;
	private IntegerProperty itemapro;
	private IntegerProperty itemnoapro;
	private StringProperty  estadofecha;
	private StringProperty estadoitems;

	
	public requisicionesgen (String consecutivogenreq,String solicitantegenreq, String areagenreq,  String cargogenreq, String centropgenreq , String fechasolgenreq,String fechaaprogenreq  ,Integer itemapro, Integer itemnoapro ,String estadofecha, String estadoitems) {
		 
		 this.consecutivogenreq = new SimpleStringProperty (consecutivogenreq);
		 this.solicitantegenreq = new SimpleStringProperty (solicitantegenreq);
		 this.areagenreq =   new SimpleStringProperty (areagenreq);
		 this.cargogenreq = new SimpleStringProperty(cargogenreq);
		 this.centropgenreq= new SimpleStringProperty(centropgenreq);
		 this.fechasolgenreq =new SimpleStringProperty (fechasolgenreq);
		 this.fechaaprogenreq = new SimpleStringProperty (fechaaprogenreq);
		 this.itemapro=new SimpleIntegerProperty (itemapro);
		 this.itemnoapro=new SimpleIntegerProperty(itemnoapro);
		 this.estadofecha=new SimpleStringProperty(estadofecha);
		 this.estadoitems=new SimpleStringProperty(estadoitems);
		

	}

	public String getConsecutivogenreq() {
		return consecutivogenreq.get();
	}

	public void setConsecutivogenreq(StringProperty consecutivogenreq) {
		this.consecutivogenreq = new SimpleStringProperty();
	}
	

	public String getSolicitantegenreq() {
		return solicitantegenreq.get();
	}

	public void setSolicitantegenreq(StringProperty solicitantegenreq) {
		this.solicitantegenreq =  new SimpleStringProperty();
	}

	public String getAreagenreq() {
		return areagenreq.get();
	}

	public void setAreagenreq(StringProperty areagenreq) {
		this.areagenreq = new SimpleStringProperty();
	}

	public String getCargogenreq() {
		return cargogenreq.get();
	}

	public void setCargogenreq(StringProperty cargogenreq) {
		this.cargogenreq = new SimpleStringProperty();
	}




	public String getFechasolgenreq() {
		return fechasolgenreq.get();
		
	}
	
	public void setFechasolgenreq(StringProperty fechasolgenreq) {
		this.fechasolgenreq = new SimpleStringProperty();
	}
	
	public String getFechaaprogenreq() {
		return fechaaprogenreq.get();
	}

	public void setFechaaprogenreq(StringProperty fechaaprogenreq) {
		this.fechaaprogenreq = new SimpleStringProperty();
	}

	public Integer getItemapro() {
		return itemapro.get();
	}

	public void setItemapro(Integer itemapro) {
		this.itemapro = new SimpleIntegerProperty();
	}

	public Integer getItemnoapro() {
		return itemnoapro.get();
	}

	public void setItemnoapro(Integer itemnoapro) {
		this.itemnoapro = new SimpleIntegerProperty();
	}

	public String getEstadoitems() {
		return estadoitems.get();
	}

	public void setEstadoitems(StringProperty estadoitems) {
		this.estadoitems = new SimpleStringProperty();
	}

	public String getEstadofecha() {
		return estadofecha.get();
	}

	public void setEstadofecha(StringProperty estadofecha) {
		this.estadofecha = new SimpleStringProperty();
	}

	public String getCentropgenreq() {
		return centropgenreq.get();
	}

	public void setCentropgenreq(StringProperty centropgenreq) {
		this.centropgenreq =  new SimpleStringProperty();
	}


	
	
	

}
