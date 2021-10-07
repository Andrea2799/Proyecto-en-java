package interfazshop;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import basededatos.conexionmysql;
import basededatos.crudclientes;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;



public class frmclientes extends JInternalFrame implements ActionListener, MouseListener {
	private JDesktopPane desktopPane;
	private JLabel lblNewLabel;
	private JTextField txtidentificacion;
	private JLabel lblNewLabel_1;
	private JTextField txttelefono;
	private JLabel lblNewLabel_2;
	private JTextField txtnombre;
	private JLabel lblNewLabel_3;
	private JTextField txtdireccion;
	private JScrollPane scrollPane;
	private JButton btnguardar;
	private JButton btnmostrar;
	private JButton btnBuscar;
	private JButton btnactualizar;
	private JButton btneliminar;
	
	conexionmysql conexiones = new conexionmysql();
	crudclientes crudclient = new crudclientes();
	public DefaultTableModel modeloDatostabla;
	public String [] registros;
	private JTable table1;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmclientes frame = new frmclientes();
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
	public frmclientes() {
		setFrameIcon(new ImageIcon(frmclientes.class.getResource("/imagenes/cliente.png")));
		setTitle("Registro de Clientes");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 540, 296);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(230, 230, 250));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		lblNewLabel = new JLabel("Identificacion");
		lblNewLabel.setBounds(10, 27, 78, 14);
		desktopPane.add(lblNewLabel);
		
		txtidentificacion = new JTextField();
		txtidentificacion.setBounds(85, 24, 86, 20);
		desktopPane.add(txtidentificacion);
		txtidentificacion.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(29, 77, 46, 14);
		desktopPane.add(lblNewLabel_1);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(85, 74, 86, 20);
		desktopPane.add(txttelefono);
		txttelefono.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(21, 123, 46, 14);
		desktopPane.add(lblNewLabel_2);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(85, 120, 86, 20);
		desktopPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(21, 170, 46, 14);
		desktopPane.add(lblNewLabel_3);
		
		txtdireccion = new JTextField();
		txtdireccion.setBounds(85, 167, 86, 20);
		desktopPane.add(txtdireccion);
		txtdireccion.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 24, 314, 163);
		desktopPane.add(scrollPane);
		
		table1 = new JTable();
		table1.addMouseListener(this);
		scrollPane.setViewportView(table1);
		
		btnguardar = new JButton("Guardar");
		btnguardar.setBackground(new Color(192, 192, 192));
		btnguardar.addActionListener(this);
		btnguardar.setBounds(10, 220, 86, 20);
		desktopPane.add(btnguardar);
		
		btnmostrar = new JButton("Mostrar");
		btnmostrar.setBackground(new Color(192, 192, 192));
		btnmostrar.addActionListener(this);
		btnmostrar.setBounds(109, 220, 96, 20);
		desktopPane.add(btnmostrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(192, 192, 192));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(215, 220, 93, 20);
		desktopPane.add(btnBuscar);
		
		btnactualizar = new JButton("Actualizar");
		btnactualizar.setBackground(new Color(192, 192, 192));
		btnactualizar.addActionListener(this);
		btnactualizar.setBounds(318, 220, 93, 20);
		desktopPane.add(btnactualizar);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.setBackground(new Color(192, 192, 192));
		btneliminar.addActionListener(this);
		btneliminar.setBounds(421, 220, 93, 20);
		desktopPane.add(btneliminar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
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
		int ide,tel;
		String nombre,direc;
		
		ide = Integer.parseInt(txtidentificacion.getText());
		tel= Integer.parseInt(txttelefono.getText());
		nombre= txtnombre.getText();
		direc= txtdireccion.getText();
		
		

		System.out.println(ide);
		System.out.println(nombre);
		System.out.println(tel);
		System.out.println(direc);
	
		crudclient.Insertarclientes(ide, tel, tel, nombre);
	}
	protected void actionPerformedBtnmostrar(ActionEvent e) {
		
		Connection cn2= null;
		String [] titulos2= {"IDENTIFICACION","TELEFONO","NOMBRE","DIRECCION"};
		modeloDatostabla = new DefaultTableModel(null,titulos2);
		int cont = 0;
		ResultSet resp1= null;// almacena la respuesta de la consulta que se ejecuta
		Statement cons = null;
		String[] registros = new String[4];
		cn2 = conexionmysql.conectar();
		String consulta ="select * from clientes;";

	    
	    	try {
				 Statement st = cn2.createStatement();
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
	    table1.setModel(modeloDatostabla);
	}
	protected void actionPerformedBtnactualizar(ActionEvent e) {
		
		int ide,tel;
		String nombre,direc;
		
		ide = Integer.parseInt(txtidentificacion.getText());
		tel= Integer.parseInt(txttelefono.getText());
		nombre= txtnombre.getText();
		direc= txtdireccion.getText();
		
		crudclient.actualizarclientes(ide, tel, nombre, direc);
	}
	protected void actionPerformedBtneliminar(ActionEvent e) {
		
		String ide= txtidentificacion.getText();
		crudclient.Eliminardatos(ide);;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table1) {
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
int filaseleccionada = table1.rowAtPoint(e.getPoint()); //maneja posiciones
		
		txtidentificacion.setText(table1.getValueAt(filaseleccionada, 0).toString());
		txttelefono.setText(table1.getValueAt(filaseleccionada, 1).toString());
		txtnombre.setText(table1.getValueAt(filaseleccionada, 2).toString());
		txtdireccion.setText(table1.getValueAt(filaseleccionada, 3).toString());
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {

		String ide = txtidentificacion.getText();
		txttelefono.setText(crudclient.buscardatos(ide).getValue0().toString());
		txtnombre.setText(crudclient.buscardatos(ide).getValue1().toString());
		txtdireccion.setText(crudclient.buscardatos(ide).getValue2().toString());
		
	}
	}

