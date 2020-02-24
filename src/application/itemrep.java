package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class itemrep {
	 private StringProperty Itemrep;
	 private IntegerProperty Cantidadrep;
	 private StringProperty Itemrepaprobadorep;
	 private StringProperty Estadoitemrep;
	 private StringProperty cnsmiitemrep;
	  
	 


	itemrep (String Itemrep, Integer Cantidadrep, String Itemrepaprobadorep, String Estadoitemrep, String cnsmiitemrep) {
	        this.Itemrep = new SimpleStringProperty(Itemrep);
	        this.Cantidadrep = new SimpleIntegerProperty(Cantidadrep);
	        this.Itemrepaprobadorep =new SimpleStringProperty(Itemrepaprobadorep);
	        this.Estadoitemrep =new SimpleStringProperty(Estadoitemrep);
	        this.cnsmiitemrep = new SimpleStringProperty(cnsmiitemrep);
	    }
	 
	    public String getItemrep() {
	        return Itemrep.get();
	    }
	    public void setItemrep(StringProperty Itemrep) {
	    	this.Itemrep = new SimpleStringProperty();
	    }
	        
	    public Integer getCantidadrep() {
	        return Cantidadrep.get();
	    }
	    public void setCantidadrep(Integer Cantidadrep) {
	        this.Cantidadrep = new SimpleIntegerProperty();
	    }

		public String getItemrepaprobadorep() {
			return Itemrepaprobadorep.get();
		}

		public void setItemrepaprobadorep(StringProperty itemrepaprobadorep) {
			Itemrepaprobadorep = new SimpleStringProperty();
		}
		
		public String getEstadoitemrep() {
				return Estadoitemrep.get();
	    }

		public void setEstadoitemrep(StringProperty estadoitemrep) {
				Estadoitemrep = new SimpleStringProperty();
		}

		public String getCnsmiitemrep() {
			return cnsmiitemrep.get();
		}

		public void setCnsmiitemrep(StringProperty cnsmiitemrep) {
			this.cnsmiitemrep = new SimpleStringProperty();
		}

}
