package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Itemreq {

	  /*private StringProperty Item;
		    private IntegerProperty Cantidad;
		  
		 
		  Itemreq(String Item, Integer Cantidad) {
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
		    */
		    

			  private final StringProperty item = new SimpleStringProperty(this, "item");
			  private final IntegerProperty cantidad = new SimpleIntegerProperty(this, "cantidad");
			  private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
			  
			  public final void setItem(String item) {
				  
				  this.item.set(item); 
			  
			  }
			  
			  public final String getItem() { 
				  
				  return item.get(); 
				  
			   }
			  
			  public final StringProperty itemProperty() { 
			  
				  return item; 
			  
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

			  public final void setID(int id) {
				  this.id.set(id);
			  }
			  
			  public final int getID() {
				  return id.get();
			  }
			  
			public final IntegerProperty idProperty() {
				return id;
			}

			  Itemreq(String item, int cantidad, int id) {
			    setItem(item);
			    setCantidad(cantidad);
			    setID(id);
			  }
		    
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
}
