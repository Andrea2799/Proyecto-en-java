package interfazshop;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import basededatos.conexionmysql;
import basededatos.crudclientes;
import basededatos.crudempleados;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SpringLayout;

public class frmempleados extends JInternalFrame implements ActionListener, MouseListener {
	private JDesktopPane desktopPane;
	private JScrollPane scrollPane;
	private JTable table5;
	private JLabel lblNewLabel;
	private JTextField txtempleado;
	private JLabel lblNewLabel_1;
	private JTextField txtnombre;
	private JLabel lblNewLabel_2;
	private JTextField txttelefono;
	private JButton btnguardar;
	private JButton btnmostar;
	private JButton btnbuscar;
	private JButton btnactualizar;
	private JButton btneliminar;
	
	conexionmysql conexiones = new conexionmysql();
	crudempleados crudemplea = new crudempleados();
	public DefaultTableModel modeloDatostabla;
	public String [] registros;
	private JLabel lblNewLabel_3;
	private JTextField txtemail;
	private JLabel lblNewLabel_4;
	private JTextField txtventas;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmempleados frame = new frmempleados();
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
	public frmempleados() {
		setBackground(new Color(230, 230, 250));
		setFrameIcon(new ImageIcon(frmempleados.class.getResource("/imagenes/categoria.png")));
		setTitle("Categoria");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 563, 310);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(230, 230, 250));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		SpringLayout springLayout = new SpringLayout();
		desktopPane.setLayout(springLayout);
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 26, SpringLayout.NORTH, desktopPane);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 214, SpringLayout.WEST, desktopPane);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, desktopPane);
		desktopPane.add(scrollPane);
		
		table5 = new JTable();
		table5.addMouseListener(this);
		scrollPane.setViewportView(table5);
		
		lblNewLabel = new JLabel("#Empleado");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.NORTH, desktopPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, desktopPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -464, SpringLayout.EAST, desktopPane);
		desktopPane.add(lblNewLabel);
		
		txtempleado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtempleado, -2, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, txtempleado, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, txtempleado, -52, SpringLayout.WEST, scrollPane);
		desktopPane.add(txtempleado);
		txtempleado.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nombre");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 20, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 20, SpringLayout.WEST, desktopPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -481, SpringLayout.EAST, desktopPane);
		desktopPane.add(lblNewLabel_1);
		
		txtnombre = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtnombre, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, txtnombre, 23, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, txtnombre, -52, SpringLayout.WEST, scrollPane);
		desktopPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Telefono");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 22, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 20, SpringLayout.WEST, desktopPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -465, SpringLayout.EAST, desktopPane);
		desktopPane.add(lblNewLabel_2);
		
		txttelefono = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txttelefono, -3, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, txttelefono, 0, SpringLayout.WEST, txtempleado);
		springLayout.putConstraint(SpringLayout.EAST, txttelefono, -52, SpringLayout.WEST, scrollPane);
		desktopPane.add(txttelefono);
		txttelefono.setColumns(10);
		
		btnguardar = new JButton("Guardar");
		springLayout.putConstraint(SpringLayout.WEST, btnguardar, 25, SpringLayout.WEST, desktopPane);
		btnguardar.setBackground(new Color(192, 192, 192));
		btnguardar.addActionListener(this);
		desktopPane.add(btnguardar);
		
		btnmostar = new JButton("Mostrar");
		springLayout.putConstraint(SpringLayout.NORTH, btnguardar, 0, SpringLayout.NORTH, btnmostar);
		springLayout.putConstraint(SpringLayout.EAST, btnguardar, -21, SpringLayout.WEST, btnmostar);
		springLayout.putConstraint(SpringLayout.WEST, btnmostar, 127, SpringLayout.WEST, desktopPane);
		btnmostar.setBackground(new Color(192, 192, 192));
		btnmostar.addActionListener(this);
		desktopPane.add(btnmostar);
		
		btnbuscar = new JButton("Buscar");
		springLayout.putConstraint(SpringLayout.NORTH, btnbuscar, 218, SpringLayout.NORTH, desktopPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -32, SpringLayout.NORTH, btnbuscar);
		springLayout.putConstraint(SpringLayout.EAST, btnmostar, -20, SpringLayout.WEST, btnbuscar);
		springLayout.putConstraint(SpringLayout.WEST, btnbuscar, 233, SpringLayout.WEST, desktopPane);
		btnbuscar.setBackground(new Color(192, 192, 192));
		btnbuscar.addActionListener(this);
		desktopPane.add(btnbuscar);
		
		btnactualizar = new JButton("Actualizar");
		springLayout.putConstraint(SpringLayout.NORTH, btnactualizar, 32, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, btnactualizar, 342, SpringLayout.WEST, desktopPane);
		springLayout.putConstraint(SpringLayout.EAST, btnbuscar, -23, SpringLayout.WEST, btnactualizar);
		btnactualizar.setBackground(new Color(192, 192, 192));
		btnactualizar.addActionListener(this);
		desktopPane.add(btnactualizar);
		
		btneliminar = new JButton("Eliminar");
		springLayout.putConstraint(SpringLayout.NORTH, btneliminar, 32, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnactualizar, -19, SpringLayout.WEST, btneliminar);
		springLayout.putConstraint(SpringLayout.WEST, btneliminar, 456, SpringLayout.WEST, desktopPane);
		springLayout.putConstraint(SpringLayout.EAST, btneliminar, 0, SpringLayout.EAST, scrollPane);
		btneliminar.setBackground(new Color(192, 192, 192));
		btneliminar.addActionListener(this);
		desktopPane.add(btneliminar);
		
		lblNewLabel_3 = new JLabel("E-mail");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 22, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 30, SpringLayout.WEST, desktopPane);
		desktopPane.add(lblNewLabel_3);
		
		txtemail = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtemail, -3, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, txtemail, 31, SpringLayout.EAST, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, txtemail, -52, SpringLayout.WEST, scrollPane);
		desktopPane.add(txtemail);
		txtemail.setColumns(10);
		
		lblNewLabel_4 = new JLabel("# Ventas");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 25, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 20, SpringLayout.WEST, desktopPane);
		desktopPane.add(lblNewLabel_4);
		
		txtventas = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtventas, 25, SpringLayout.EAST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, txtventas, -52, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, btnmostar, 32, SpringLayout.SOUTH, txtventas);
		springLayout.putConstraint(SpringLayout.SOUTH, txtventas, 0, SpringLayout.SOUTH, scrollPane);
		desktopPane.add(txtventas);
		txtventas.setColumns(10);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btneliminar) {
			actionPerformedBtneliminar(e);
		}
		if (e.getSource() == btnactualizar) {
			actionPerformedBtnactualizar(e);
		}
		if (e.getSource() == btnbuscar) {
			actionPerformedBtnbuscar(e);
		}
		if (e.getSource() == btnmostar) {
			actionPerformedBtnmostar(e);
		}
		if (e.getSource() == btnguardar) {
			actionPerformedBtnguardar(e);
		}
	}
	protected void actionPerformedBtnguardar(ActionEvent e) {
		int emplea;
		String nombre,email;
		int tel, ventas;
		
		emplea= Integer.parseInt(txtempleado.getText());
		nombre= txtnombre.getText();
		tel= Integer.parseInt(txttelefono.getText());
		email=txtemail.getText();
		ventas=Integer.parseInt(txtventas.getText());
		
		System.out.println(emplea);
		System.out.println(nombre);
		System.out.println(tel);
		System.out.println(email);
		System.out.println(ventas);
		
		crudemplea.Insertaremplea(emplea, nombre, tel, email, ventas);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table5) {
			mouseClickedTable5(e);
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
	protected void mouseClickedTable5(MouseEvent e) {
		
		int filaseleccionada = table5.rowAtPoint(e.getPoint());
		
		txtempleado.setText(table5.getValueAt(filaseleccionada, 0).toString());
		txtnombre.setText(table5.getValueAt(filaseleccionada, 1).toString());
		txttelefono.setText(table5.getValueAt(filaseleccionada,2).toString());
		txtemail.setText(table5.getValueAt(filaseleccionada, 3).toString());
		txtventas.setText(table5.getValueAt(filaseleccionada, 4).toString());
		
	}
	protected void actionPerformedBtnmostar(ActionEvent e) {
		
		Connection cn2= null;
		String [] titulos2= {"#EMPLEADO","NOMBRE","TELEFONO","EMAIL","#VENTAS"};
		modeloDatostabla = new DefaultTableModel(null,titulos2);
		int cont = 0;
		ResultSet resp1= null;// almacena la respuesta de la consulta que se ejecuta
		Statement cons = null;
		String[] registros = new String[5];
		cn2 = conexionmysql.conectar();
		String consulta ="select * from empleados;";

	    try {
	    	 Statement st = cn2.createStatement();
		     ResultSet rs = st.executeQuery(consulta);

		        while (rs.next())
			{
				registros[0]= rs.getString(1); //motrar las columnas de la tabla
				registros[1]= rs.getString(2);
				registros[2]= rs.getString(3);
				registros[3]= rs.getString(4);
				registros[4]= rs.getString(5);
				
				modeloDatostabla.addRow(registros);
			
			}
				
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    table5.setModel(modeloDatostabla);
	
		
		
	}
	protected void actionPerformedBtnbuscar(ActionEvent e) {
		
		String emplea = txtempleado.getText();
		txtnombre.setText(crudemplea.buscarempleado(emplea).getValue0().toString());
		txttelefono.setText(crudemplea.buscarempleado(emplea).getValue1().toString());
		txtemail.setText(crudemplea.buscarempleado(emplea).getValue2().toString());
		txtventas.setText(crudemplea.buscarempleado(emplea).getValue3().toString());
		
	}
	protected void actionPerformedBtnactualizar(ActionEvent e) {
		int emplea;
		String nombre,email;
		int tel, ventas;
		
		emplea = Integer.parseInt(txtempleado.getText());
		nombre= txtnombre.getText();
		tel= Integer.parseInt(txttelefono.getText());
		email= txtemail.getText();
		ventas=Integer.parseInt(txtventas.getText());
		
		crudemplea.actualizarempleado(emplea, nombre, tel, email, ventas);
	}
	protected void actionPerformedBtneliminar(ActionEvent e) {
		
		String emplea= txtempleado.getText();
		crudemplea.Eliminarempleado(emplea);
	}
}
