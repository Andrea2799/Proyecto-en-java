package basededatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import org.javatuples.Quartet;

public class crudproductos{
	
	conexionmysql Conexion = new conexionmysql();
	Connection cn = null;
	
public void Insertarproductos(String nro_producto, int stock, String nombre,int precio) {
		cn = Conexion.conectar();
		
		String consulta = "insert into productos (nro_producto, stock, nombre, precio)"  
		+ "values ("+nro_producto +","+ stock+",'"+ nombre+"',"+ precio+ ");";
		PreparedStatement pst;
try {
			
			pst = cn.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro guardado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
public void Eliminardatos(String cod) {
		
		String codi= cod ;
		
		cn= Conexion.conectar();
		String consulta= "delete from productos where nro_producto= " +cod+";";
		
		PreparedStatement pst;
		try {
			pst = cn.prepareStatement(consulta);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "regitro eliminado");
		
		
	}
public void actualizarproduc(String producto, int stock, String nombre, int precio ) {

    cn = Conexion.conectar();
		
		String consulta = "update  productos set  stock= "+stock+", nombre= '"+nombre+"',precio="
		+precio+" where nro_producto ='"+producto+"' ;";

		System.out.println(consulta);
		
		try {
			PreparedStatement pst;
			pst = cn.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro actualizado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

public  Quartet buscardatos (String produc) {
	

	String producto="",nombre="";
	int precio=0;
	int sw=0;
	int stock =0;
	ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
	Statement cons = null;
	
	cn = Conexion.conectar();
	String consulta =" select * from productos where nro_producto = '"+produc+"';";

    try {
		cons = cn.createStatement();
		resp= cons.executeQuery(consulta);
		while (resp.next())
		{
			 //motrar las columnas de la tabla
			
			nombre= resp.getString(3);
			precio= Integer.parseInt(resp.getString(4));
			stock = Integer.parseInt(resp.getString(2));
			sw=1;	
		}
			
	} 
    
    catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    if (sw==1) {
    	
    	JOptionPane.showMessageDialog(null,"registro encontrado");
    }
    
    if (sw ==0) {
    	
    	JOptionPane.showMessageDialog(null,"registro no encontrado");
    }
    
    Quartet <String,Integer,Integer,Integer> res = new Quartet <String,Integer,Integer,Integer> (nombre,precio,sw,stock);
	
	return res;
	
}


}
