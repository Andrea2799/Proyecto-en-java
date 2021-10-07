package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionmysql {
	
	public static  Connection conectar() { // funcion conectar sin parametros 
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection("Jdbc:mysql://localhost/ventastienda","root","19994710");
			
			System.out.println("conexion ok ");
		
		 } 
		catch (SQLException e) 
		  {
			System.out.println("Error en el conector ");
		
			e.printStackTrace();
          }
	
	
	return conexion;
	
}

}
