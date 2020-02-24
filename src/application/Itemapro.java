package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Itemapro {
	
	 private StringProperty Item;
	 private IntegerProperty Cantidad;
	 private StringProperty Itemaprobado;
	  
	 
	 Itemapro (String Item, Integer Cantidad, String Itemaprobado) {
	        this.Item = new SimpleStringProperty(Item);
	        this.Cantidad = new SimpleIntegerProperty(Cantidad);
	        this.Itemaprobado = new SimpleStringProperty(Itemaprobado);
	    }
	 
	    public String getItem() {
	        return Item.get();
	    }
	    public void setItem(StringProperty Item) {
	    	this.Item = new SimpleStringProperty();
	    }
	        
	    public Integer getCantidad() {
	        return Cantidad.get();
	    }
	    public void setCantidad(Integer Cantidad) {
	        this.Cantidad = new SimpleIntegerProperty();
	    }
	    
	    public String getItemaprobado() {
	        return Itemaprobado.get();
	    }
	    public void setItemaprobado (StringProperty Itemaprobado) {
	    	this.Itemaprobado = new SimpleStringProperty();
	    }
	        
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
