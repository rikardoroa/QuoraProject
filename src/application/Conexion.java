package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	   public String Bd="jdbc:sqlserver://LAPTOP-8L00K632:1433;databaseName=QUORA";
	   public String Usuario="sa";
	   public String Pass="milkas87";
  		
  		
	public Connection miconexion( Connection Conexion) throws SQLException {
		    Conexion = DriverManager.getConnection(Bd, Usuario, Pass);
			return Conexion;
            }
          }