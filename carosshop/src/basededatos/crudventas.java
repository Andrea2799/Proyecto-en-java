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

public class crudventas {
	
	conexionmysql Conexion = new conexionmysql();
	Connection cn = null;
	
	
	public void Insertarventas(String factu,int precio, int desc,String emplea, String fecha) {
		cn = Conexion.conectar();
		
		String consulta = "insert into ventas (nro_fact, precio, descuento, vendedor, fecha)"  
		+ "values ("+factu +","+precio+","+desc+",'"+emplea+"','"+fecha+"');";
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
		
		String fact= cod ;
		
		cn= Conexion.conectar();
		String consulta= "delete from ventas where nro_fact='" +fact+"';";
		
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
public void actualizardatos(String factu,int precio, int desc,String emplea, String fecha ) {
	
    cn = Conexion.conectar();
		
		String consulta = "update  ventas set nro_fact  =" +factu+",precio= "+precio+", descuento="+
		desc+",vendedor '"+emplea+"',fecha= '"+fecha+"' where nro_fact= '" +factu +"' ;";
		
		
		try {
			PreparedStatement pst;
			pst = cn.prepareStatement(consulta);
			pst.execute();
			JOptionPane.showMessageDialog(null,"registro actualizado");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

public Quintet buscarventas (String fact) {
	

	String factu="";
	int precio=0;
	int desc=0;
	String vendedor="";
	String fecha="";
	int sw=0;
	
	ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
	Statement cons = null;
	
	cn = Conexion.conectar();
	String consulta =" select * from ventas where nro_fact = '"+fact+"';";

    try {
		cons = cn.createStatement();
		resp= cons.executeQuery(consulta);
		while (resp.next())
		{
			 //motrar las columnas de la tabla
			desc = Integer.parseInt(resp.getString(2));
			precio=Integer.parseInt(resp.getString(3));
			vendedor= resp.getString(4);
		    fecha= resp.getString(5);
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
    
    Quintet <Integer,Integer,String,String,Integer> res = new Quintet <Integer,Integer,String,String,Integer>(desc,precio,vendedor,fecha,sw);
	
	return res;
	
}
}
