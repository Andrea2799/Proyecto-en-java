package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

public class crudempleados {
	conexionmysql Conexion = new conexionmysql();
	Connection cn5 = null;
	
	public void Insertaremplea(int emple,String nombre, int tel, String email, int ventas) {
		cn5 = Conexion.conectar();
		
		String consulta = "insert into empleados (nro_empleado, nombre,telefono,email,nro_ventas)"  
		+ "values ("+emple +",'"+ nombre+ "',"+ tel+",'"+email+"',"+ventas+");";
		PreparedStatement pst;
try {
			
			pst = cn5.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro guardado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public void Eliminarempleado (String emplea) {
		
		String emple= emplea ;
		
		cn5= Conexion.conectar();
		String consulta= "delete from empleados where nro_empleado ='" +emple+"';";
		
		PreparedStatement pst;
		try {
			pst = cn5.prepareStatement(consulta);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "regitro eliminado");
		
		
	}
public void actualizarempleado(int emple,String nombre, int tel, String email, int ventas ) {
	
    cn5 = Conexion.conectar();
		
		String consulta = "update  empleados set nombre  ='"+nombre+"', telefono="+
		tel+",email='"+email+"',nro_ventas="+ventas+" where nro_empleado= " +emple+" ;";
		
		
		try {
			PreparedStatement pst;
			pst = cn5.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro actualizado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

public 	Quintet buscarempleado(String emplea) {
	
	int emple=0;
	String nombre="";
	int tel=0;
	String email="";
	int ventas=0;
	int sw=0;
	
	ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
	Statement cons = null;
	
	cn5 = Conexion.conectar();
	String consulta =" select * from empleados where nro_empleado = '"+emplea+"';";

    try {
		cons = cn5.createStatement();
		resp= cons.executeQuery(consulta);
		while (resp.next())
		{
			 //motrar las columnas de la tabla
			nombre =resp.getString(2);
		    tel= Integer.parseInt(resp.getString(3));
		    email =resp.getString(4);
		    ventas=Integer.parseInt(resp.getString(5));
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
    
    Quintet <String,Integer,String,Integer,Integer> res = new Quintet <String,Integer,String,Integer,Integer> (nombre,tel,email,ventas,sw);
	
	return res;
	
}


}
