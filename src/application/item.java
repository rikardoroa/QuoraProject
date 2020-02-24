package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class item {
	    private StringProperty Item;
	    private IntegerProperty Cantidad;
	  
	 
	    item(String Item, Integer Cantidad) {
	        this.Item = new SimpleStringProperty(Item);
	        this.Cantidad = new SimpleIntegerProperty(Cantidad);

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
	    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
