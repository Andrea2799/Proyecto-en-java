package interfazshop;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import basededatos.conexionmysql;
import basededatos.crudproductos;


import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class frmproductos extends JInternalFrame implements ActionListener, MouseListener {
	crudproductos crudproducto = new crudproductos();
	  conexionmysql conexion = new conexionmysql();
	private JDesktopPane escritorio;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtproducto;
	private JTextField txtstock;
	private JTextField txtnombre;
	private JTextField txtprecio;
	private JButton btnguardar;
	private JButton btnmostrar;
	private JButton btnbuscar;
	private JButton btnactualizar;
	private JButton btneliminar;
	 conexionmysql conexiones = new conexionmysql();
	  crudproductos crudproductos = new crudproductos();
	  public DefaultTableModel modeloDatostabla;
	 
	  public String [] registros;
	  private JScrollPane scrollPane;
	  private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmproductos frame = new frmproductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmproductos() {
		setFrameIcon(new ImageIcon(frmproductos.class.getResource("/imagenes/producto.png")));
		setTitle("Registro de Productos");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 524, 314);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(230, 230, 250));
		getContentPane().add(escritorio, BorderLayout.CENTER);
		escritorio.setLayout(null);
		
		lblNewLabel = new JLabel("nro_producto");
		lblNewLabel.setBounds(10, 29, 77, 19);
		escritorio.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Stock");
		lblNewLabel_1.setBounds(20, 71, 67, 23);
		escritorio.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(20, 119, 46, 14);
		escritorio.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("precio");
		lblNewLabel_3.setBounds(20, 168, 46, 14);
		escritorio.add(lblNewLabel_3);
		
		txtproducto = new JTextField();
		txtproducto.setBounds(100, 28, 86, 20);
		escritorio.add(txtproducto);
		txtproducto.setColumns(10);
		
		txtstock = new JTextField();
		txtstock.setBounds(100, 72, 86, 20);
		escritorio.add(txtstock);
		txtstock.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(100, 116, 86, 20);
		escritorio.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setBounds(100, 162, 86, 20);
		escritorio.add(txtprecio);
		txtprecio.setColumns(10);
		
		btnguardar = new JButton("Guardar");
		btnguardar.setBackground(new Color(192, 192, 192));
		btnguardar.addActionListener(this);
		btnguardar.setBounds(10, 225, 89, 23);
		escritorio.add(btnguardar);
		
		btnmostrar = new JButton("Mostrar");
		btnmostrar.setBackground(new Color(192, 192, 192));
		btnmostrar.addActionListener(this);
		btnmostrar.setBounds(109, 225, 86, 23);
		escritorio.add(btnmostrar);
		
		btnbuscar = new JButton("Buscar");
		btnbuscar.setBackground(new Color(192, 192, 192));
		btnbuscar.addActionListener(this);
		btnbuscar.setBounds(205, 225, 86, 23);
		escritorio.add(btnbuscar);
		
		btnactualizar = new JButton("Actualizar");
		btnactualizar.setBackground(new Color(192, 192, 192));
		btnactualizar.addActionListener(this);
		btnactualizar.setBounds(301, 225, 86, 23);
		escritorio.add(btnactualizar);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.setBackground(new Color(192, 192, 192));
		btneliminar.addActionListener(this);
		btneliminar.setBounds(397, 225, 86, 23);
		escritorio.add(btneliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 22, 300, 166);
		escritorio.add(scrollPane);
		
		table2 = new JTable();
		table2.addMouseListener(this);
		scrollPane.setViewportView(table2);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnbuscar) {
			actionPerformedBtnbuscar(e);
		}
		if (e.getSource() == btneliminar) {
			actionPerformedBtneliminar(e);
		}
		if (e.getSource() == btnactualizar) {
			actionPerformedBtnactualizar(e);
		}
		if (e.getSource() == btnmostrar) {
			actionPerformedBtnmostrar(e);
		}
		if (e.getSource() == btnguardar) {
			actionPerformedBtnguardar(e);
			
		}
	}
	protected void actionPerformedBtnguardar(ActionEvent e) {
		
		String nro_producto, nombre;
		int precio,stock;
		
		nro_producto= txtproducto.getText();
		stock= Integer.parseInt(txtstock.getText());
		nombre=txtnombre.getText();
		precio= Integer.parseInt(txtprecio.getText());
		
		
		

		System.out.println(nro_producto);
		System.out.println(stock);
		System.out.println(nombre );
		System.out.println(precio);
	
		
		crudproductos.Insertarproductos(nro_producto, stock, nombre, precio);
		
	}
	protected void actionPerformedBtnmostrar(ActionEvent e) {
	
	Connection cn1= null;
	String [] titulos= {"#PRODUCTO","STOCK","NOMBRE","PRECIO"};
	modeloDatostabla = new DefaultTableModel(null,titulos);
	int cont = 0;
	ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
	Statement cons = null;
	String[] registros = new String[4];
	cn1 = conexionmysql.conectar();
	String consulta =" select * from productos;";

    try {
    	 Statement st = cn1.createStatement();
	     ResultSet rs = st.executeQuery(consulta);

	        while (rs.next())
		{
			registros[0]= rs.getString(1); //motrar las columnas de la tabla
			registros[1]= rs.getString(2);
			registros[2]= rs.getString(3);
			registros[3]= rs.getString(4);
			
			modeloDatostabla.addRow(registros);
		
		}
			
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    table2.setModel(modeloDatostabla);
}
	protected void actionPerformedBtnactualizar(ActionEvent e) {
		String producto, nombre;
		int precio,stock;
		
		producto= txtproducto.getText();
		stock= Integer.parseInt(txtstock.getText());
		nombre=txtnombre.getText();
		precio= Integer.parseInt(txtprecio.getText());
		
		
		
	crudproductos.actualizarproduc(producto, stock, nombre, precio);
	}
	protected void actionPerformedBtneliminar(ActionEvent e) {

		String cod= txtproducto.getText();
		crudproductos.Eliminardatos(cod);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table2) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTable(MouseEvent e) {
		
		int filaseleccionada = table2.rowAtPoint(e.getPoint()); //maneja posiciones
		
		txtproducto.setText(table2.getValueAt(filaseleccionada, 0).toString());
		txtstock.setText(table2.getValueAt(filaseleccionada, 1).toString());
		txtnombre.setText(table2.getValueAt(filaseleccionada, 2).toString());
		txtprecio.setText(table2.getValueAt(filaseleccionada, 3).toString());
		
	}
	protected void actionPerformedBtnbuscar(ActionEvent e) {
		
		String  produc = txtproducto.getText();
		txtstock.setText(crudproducto.buscardatos(produc).getValue0().toString());
		txtnombre.setText(crudproducto.buscardatos(produc).getValue1().toString());
		txtprecio.setText(crudproducto.buscardatos(produc).getValue2().toString());
		
	}
	}
	

