package interfazshop;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.table.DefaultTableModel;

import basededatos.conexionmysql;
import basededatos.crudproductos;
import basededatos.crudproveedor;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class frmproveedor extends JInternalFrame implements MouseListener, ActionListener {
	private JDesktopPane desktopPane;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField txtproveedor;
	private JLabel Direccion;
	private JTextField txtdireccion;
	private JLabel lblNewLabel_1;
	private JTextField txttelefono;
	private JLabel lblNewLabel_2;
	private JTextField txtnombre;
	private JButton btnguardar;
	private JButton btnmostrar;
	private JButton btnactualizar;
	private JButton btnbuscar;
	private JButton btneliminar;
	conexionmysql conexiones = new conexionmysql();
	crudproveedor crudproveedor = new crudproveedor();
	public DefaultTableModel modeloDatostabla;
	public String [] registros1;
	private JTable table4;
	
	
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmproveedor frame = new frmproveedor();
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
	public frmproveedor() {
		setFrameIcon(new ImageIcon(frmproveedor.class.getResource("/imagenes/proveedor.png")));
		setTitle("Registro Porveedores");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 521, 308);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(230, 230, 250));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 27, 301, 171);
		desktopPane.add(scrollPane);
		
		table4 = new JTable();
		table4.addMouseListener(this);
		scrollPane.setViewportView(table4);
		
		lblNewLabel = new JLabel("#Proveedor");
		lblNewLabel.setBounds(10, 38, 72, 14);
		desktopPane.add(lblNewLabel);
		
		txtproveedor = new JTextField();
		txtproveedor.setBounds(92, 35, 86, 20);
		desktopPane.add(txtproveedor);
		txtproveedor.setColumns(10);
		
		Direccion = new JLabel("Direccion");
		Direccion.setBounds(21, 81, 46, 14);
		desktopPane.add(Direccion);
		
		txtdireccion = new JTextField();
		txtdireccion.setBounds(92, 78, 86, 20);
		desktopPane.add(txtdireccion);
		txtdireccion.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(21, 126, 46, 14);
		desktopPane.add(lblNewLabel_1);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(92, 123, 86, 20);
		desktopPane.add(txttelefono);
		txttelefono.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(21, 173, 46, 14);
		desktopPane.add(lblNewLabel_2);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(92, 170, 86, 20);
		desktopPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(this);
		btnguardar.setBounds(5, 225, 86, 23);
		desktopPane.add(btnguardar);
		
		btnmostrar = new JButton("Mostrar");
		btnmostrar.addActionListener(this);
		btnmostrar.setBounds(105, 225, 90, 23);
		desktopPane.add(btnmostrar);
		
		btnactualizar = new JButton("Actualizar");
		btnactualizar.addActionListener(this);
		btnactualizar.setBounds(307, 225, 92, 23);
		desktopPane.add(btnactualizar);
		
		btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(this);
		btnbuscar.setBounds(205, 225, 92, 23);
		desktopPane.add(btnbuscar);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(this);
		btneliminar.setBounds(409, 225, 86, 23);
		desktopPane.add(btneliminar);

	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table4) {
			mouseClickedTable4(e);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btneliminar) {
			actionPerformedBtneliminar(e);
		}
		if (e.getSource() == btnbuscar) {
			actionPerformedBtnbuscar(e);
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
		int prove,tel;
		String nombre,direc;
		
		prove = Integer.parseInt(txtproveedor.getText());
		tel= Integer.parseInt(txttelefono.getText());
		nombre= txtnombre.getText();
		direc= txtdireccion.getText();
		
		System.out.println(prove);
		System.out.println(tel);
		System.out.println(nombre);
		System.out.println(direc);
	
		crudproveedor.Insertarproveedor(prove, direc, tel, nombre);
	}
	protected void actionPerformedBtnmostrar(ActionEvent e) {
		
		Connection cn3= null;
		String [] titulos3= {"#PROVE","DIREC","TEL","NOMBRE"};
		modeloDatostabla = new DefaultTableModel(null,titulos3);
		int cont = 0;
		ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
		Statement cons = null;
		String[] registros1 = new String[4];
		cn3 = conexionmysql.conectar();
		String consulta ="select * from proveedor;";
	
	    try {
	    	 Statement st = cn3.createStatement();
		     ResultSet rs = st.executeQuery(consulta);
			
			while (rs.next())
			{
				registros1[0]= rs.getString(1); //motrar las columnas de la tabla
				registros1[1]= rs.getString(2);
				registros1[2]= rs.getString(3);
				registros1[3]= rs.getString(4);
				
				modeloDatostabla.addRow(registros1);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    table4.setModel(modeloDatostabla);
	
	   
	}
	protected void mouseClickedTable4(MouseEvent e) {
int filaseleccionada = table4.rowAtPoint(e.getPoint()); //maneja posiciones
		
		txtproveedor.setText(table4.getValueAt(filaseleccionada, 0).toString());
		txtdireccion.setText(table4.getValueAt(filaseleccionada, 1).toString());
		txttelefono.setText(table4.getValueAt(filaseleccionada, 2).toString());
		txtnombre.setText(table4.getValueAt(filaseleccionada, 3).toString());
		
		
	}
	protected void actionPerformedBtnactualizar(ActionEvent e) {
		int prove,tel;
		String nombre,direc;
		
		prove= Integer.parseInt(txtproveedor.getText());
		tel= Integer.parseInt(txttelefono.getText());
		nombre=txtnombre.getText();
		direc=txtdireccion.getText();
		
	crudproveedor.actualizarproduc(prove, direc, tel, nombre);
	}
	protected void actionPerformedBtnbuscar(ActionEvent e) {
		
		String  provee = txtproveedor.getText();
		txtdireccion.setText(crudproveedor.buscardatos(provee).getValue0().toString());
		txttelefono.setText(crudproveedor.buscardatos(provee).getValue1().toString());
		txtnombre.setText(crudproveedor.buscardatos(provee).getValue2().toString());
		
		
	}
	protected void actionPerformedBtneliminar(ActionEvent e) {
		

		String prove= txtproveedor.getText();
		crudproveedor.Eliminardatos(prove);
	}
}
