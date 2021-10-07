package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import org.javatuples.Quartet;

import java.util.*;


public class crudproveedor {
	
	conexionmysql Conexion = new conexionmysql();
	Connection cn3 = null;
	
public void Insertarproveedor(int nro_proveedor,String direc,int tel,String nombre) {
		
		cn3 = Conexion.conectar();
		
		String consulta = "insert into proveedor (nro_proveedor, direccion ,telefono, nombre)"  
		+ "values ("+nro_proveedor +",'"+ direc+"',"+ tel+",'"+ nombre+ "');";
		PreparedStatement pst;
try {
			
			pst = cn3.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro guardado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void Eliminardatos(String prove) {
	
	String codi= prove ;
	
	cn3= Conexion.conectar();
	String consulta= "delete from proveedor where nro_proveedor= "+prove+";";
	
	PreparedStatement pst;
	try {
		pst = cn3.prepareStatement(consulta);
		pst.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	JOptionPane.showMessageDialog(null, "regitro eliminado");
	
	
}

public void actualizarproduc(int prove,  String direc,int tel, String nombre ) {

    cn3 = Conexion.conectar();
		
		String consulta = "update proveedor set direccion= '"+direc+"',telefono="
		+tel+", nombre= '"+nombre+"' where nro_proveedor = "+prove+";";
		
		
		
		try {
			PreparedStatement pst;
			pst = cn3.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro actualizado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

public  Quartet buscardatos (String provee) {
	

	String direc="", nombre="" ;
	int prove=0;
	int tel=0;
	int sw=0;
	ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
	Statement cons = null;
	
	cn3 = Conexion.conectar();
	String consulta =" select * from proveedor where nro_proveedor = '"+provee+"';";

    try {
		cons = cn3.createStatement();
		resp= cons.executeQuery(consulta);
		while (resp.next())
		{
			 //motrar las columnas de la tabla
			
			direc=resp.getString(2);
			tel = Integer.parseInt(resp.getString(3));
			nombre= resp.getString(4);
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
    
    Quartet <String,Integer,String,Integer> res = new Quartet<String,Integer,String,Integer> (direc,tel,nombre,sw);
	
	return res;
	
}


	
}

