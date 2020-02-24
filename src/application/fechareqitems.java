package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class fechareqitems {

	 private StringProperty consec;
	 private StringProperty fechaentrega;
	 private StringProperty solicitante;
	  
	 fechareqitems (String consec, String fechaentrega, String solicitante) {
	        
	        this.consec= new SimpleStringProperty(consec);
	        this.fechaentrega=new SimpleStringProperty(fechaentrega);
	        this.solicitante=new SimpleStringProperty(solicitante);
	    }

	public String getConsec() {
		return consec.get();
	}

	public void setConsec(StringProperty consec) {
		this.consec = new SimpleStringProperty();
	}

	public String getFechaentrega() {
		return fechaentrega.get();
	}

	public void setFechaentrega(StringProperty fechaentrega) {
		this.fechaentrega = new SimpleStringProperty();
	}

	public String getSolicitante() {
		return solicitante.get();
	}

	public void setSolicitante(StringProperty solicitante) {
		this.solicitante = new SimpleStringProperty();
	}
	
	
}
