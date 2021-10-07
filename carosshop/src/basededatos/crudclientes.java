package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import org.javatuples.Quartet;
import org.javatuples.Quintet;

import java.util.*;

public class crudclientes {
	conexionmysql Conexion = new conexionmysql();
	Connection cn2 = null;
	
	public void Insertarclientes(int ide, int tel, int direc, String nombre) {
		
		cn2 = Conexion.conectar();
		
		String consulta = "insert into clientes (identificacion, telefono, nombre, direccion)"  
		+ "values ("+ide +","+ tel+",'"+ nombre+"','"+ direc+ "');";
		PreparedStatement pst;
try {
			
			pst = cn2.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro guardado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public void Eliminardatos(String ide) {
		
		String codi= ide ;
		
		cn2= Conexion.conectar();
		String consulta= "delete from clientes where identificacion= "+ide+";";
		
		PreparedStatement pst;
		try {
			pst = cn2.prepareStatement(consulta);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "regitro eliminado");
		
		
	}

public void actualizarclientes(int ide, int tel, String nombre, String direc ) {

    cn2 = Conexion.conectar();
		
		String consulta = "update clientes set  telefono="+tel+",nombre= '"+nombre+"',direccion="
		+direc+" where identificacion ='"+ide+"' ;";

		
		
		try {
			PreparedStatement pst;
			pst = cn2.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro actualizado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
public  Quartet buscardatos (String ide) {
	
	
	int identifi=0;
	int tel=0;
	String nombre="",direc="";
	int sw=0;
	ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
	Statement cons = null;
	
	cn2 = Conexion.conectar();
	String consulta =" select * from clientes where identificacion = '"+ide+"';";

    try {
		cons = cn2.createStatement();
		resp= cons.executeQuery(consulta);
		while (resp.next())
		{
			 //motrar las columnas de la tabla
			tel = Integer.parseInt(resp.getString(2));
			nombre= resp.getString(3);
			direc= resp.getString(4);
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
    
    Quartet <Integer,String,String,Integer> res = new Quartet<Integer,String,String,Integer> (tel,nombre,direc,sw);
	
	return res;
	
}

}

