package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Itemapro {
	
	 /* private StringProperty Item;
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
	    }*/
	 

	  private final StringProperty item = new SimpleStringProperty(this, "item");
	  private final IntegerProperty cantidad = new SimpleIntegerProperty(this, "cantidad");
	  private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
	  private final StringProperty Itemaprobado = new SimpleStringProperty(this, "Itemaprobado");
	  
	  public final void setItem(String item) {
		  
		  this.item.set(item); 
	  
	  }
	  
	  public final String getItem() { 
		  
		  return item.get(); 
		  
	   }
	  
	  public final StringProperty itemProperty() { 
	  
		  return item; 
	  
	  }
	  
	
	  public final void setItemaprobado(String Itemaprobado) {
		  this.Itemaprobado.set(Itemaprobado);
	  }
	  
	  public final String getItemaprobado() {
		  return Itemaprobado.get();
	  }
	  
	  public final StringProperty ItemaprobadoProperty() {
		  return Itemaprobado;
	  }
	  
	  public final void setCantidad(int cantidad){ 
		  
		  this.cantidad.set(cantidad);
	  }
	  
	  public final int getCantidad() { 
	 
		  return cantidad.get(); 
	  
	  }
	  
	  public final IntegerProperty cantidadProperty() { 
	  
		  return cantidad; 
	  
	  }

	  public void setID(int id) {
		  
		this.id.set(id);
	  }
	
	  public final int getID() {
		  
		return id.get();
	  }
	
	   public final IntegerProperty IDProperty() {
		   
		return id;
		
	  }

	  Itemapro(String item, int cantidad, String Itemaprobado, int id) {
	    setItem(item);
	    setCantidad(cantidad);
	    setItemaprobado(Itemaprobado);
	    setID(id);
	  }
	        
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
