package interfazshop;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import basededatos.conexionmysql;
import basededatos.crudventas;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;


public class frmventas extends JInternalFrame implements ActionListener, MouseListener {
	
	 
	  private JDesktopPane desktopPane;
	  private JScrollPane scrollPane;
	  private JTextField txtfactura;
	  private JTextField txtdescuento;
	  private JTextField txtfecha;
	  private JLabel lblNewLabel;
	  private JLabel lblNewLabel_1;
	  private JLabel lblNewLabel_2;
	  private JButton btnguardar;
	  private JButton btnmostrar;
	  private JButton btnbuscar;
	  private JButton btnactualizar;
	  private JButton btneliminar;
	  conexionmysql conexiones = new conexionmysql();
	  crudventas crudventas = new crudventas();
	  public DefaultTableModel modeloDatostabla;
	  public String [] registros;
	  private JTable table3;
	  private JLabel lblNewLabel_3;
	  private JTextField txtprecio;
	  private JLabel Vendedor;
	  private JTextField txtempleado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmventas frame = new frmventas();
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
	public frmventas() {
		setFrameIcon(new ImageIcon(frmventas.class.getResource("/imagenes/ventas.png")));
		setTitle("Registro de ventas");
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setForeground(new Color(0, 0, 0));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 527, 312);
		getContentPane().setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 434, 1);
		getContentPane().add(desktopPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(188, 28, 313, 182);
		getContentPane().add(scrollPane);
		
		table3 = new JTable();
		table3.addMouseListener(this);
		scrollPane.setViewportView(table3);
		
		txtfactura = new JTextField();
		txtfactura.setBounds(80, 26, 86, 20);
		getContentPane().add(txtfactura);
		txtfactura.setColumns(10);
		
		txtdescuento = new JTextField();
		txtdescuento.setBounds(80, 104, 86, 20);
		getContentPane().add(txtdescuento);
		txtdescuento.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(80, 193, 86, 20);
		getContentPane().add(txtfecha);
		txtfecha.setColumns(10);
		
		lblNewLabel = new JLabel("Factura");
		lblNewLabel.setBounds(24, 29, 46, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Descuento ");
		lblNewLabel_1.setBounds(10, 107, 60, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("fecha");
		lblNewLabel_2.setBounds(24, 196, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		btnguardar = new JButton("Guardar");
		btnguardar.setBackground(new Color(192, 192, 192));
		btnguardar.addActionListener(this);
		btnguardar.setBounds(10, 237, 86, 23);
		getContentPane().add(btnguardar);
		
		btnmostrar = new JButton("Mostrar");
		btnmostrar.setBackground(new Color(192, 192, 192));
		btnmostrar.addActionListener(this);
		btnmostrar.setBounds(106, 237, 86, 23);
		getContentPane().add(btnmostrar);
		
		btnbuscar = new JButton("Buscar");
		btnbuscar.setBackground(new Color(192, 192, 192));
		btnbuscar.addActionListener(this);
		btnbuscar.setBounds(202, 237, 86, 23);
		getContentPane().add(btnbuscar);
		
		btnactualizar = new JButton("Actualizar");
		btnactualizar.setBackground(new Color(192, 192, 192));
		btnactualizar.addActionListener(this);
		btnactualizar.setBounds(298, 237, 93, 23);
		getContentPane().add(btnactualizar);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.setBackground(new Color(192, 192, 192));
		btneliminar.addActionListener(this);
		btneliminar.setBounds(401, 237, 86, 23);
		getContentPane().add(btneliminar);
		
		lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(24, 68, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtprecio = new JTextField();
		txtprecio.setBounds(80, 65, 86, 20);
		getContentPane().add(txtprecio);
		txtprecio.setColumns(10);
		
		Vendedor = new JLabel("Vendedor");
		Vendedor.setBounds(24, 154, 46, 14);
		getContentPane().add(Vendedor);
		
		txtempleado = new JTextField();
		txtempleado.setBounds(80, 151, 86, 20);
		getContentPane().add(txtempleado);
		txtempleado.setColumns(10);

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
		if (e.getSource() == btnmostrar) {
			actionPerformedBtnmostrar(e);
		}
		if (e.getSource() == btnguardar) {
			actionPerformedBtnguardar(e);
		}
	}
	protected void actionPerformedBtnguardar(ActionEvent e) {
		String factu,fecha,emplea;
		int desc,precio;
		
		factu = txtfactura.getText();
		precio=Integer.parseInt(txtprecio.getText());
		desc= Integer.parseInt(txtdescuento.getText());
		emplea= txtempleado.getText();
		fecha= txtfecha.getText();
		
		System.out.println(factu);
		System.out.println(precio);
		System.out.println(desc);
		System.out.println(fecha );
		System.out.println(emplea);
	
		
		crudventas.Insertarventas(factu, precio, desc, emplea, fecha);
		
				
	}
	
	protected void actionPerformedBtnmostrar(ActionEvent e) {
		Connection cn= null;
		String [] titulos= {"FACTURA","PRECIO","DESCUENTO","EMPLEADO","FECHA"};
		modeloDatostabla = new DefaultTableModel(null,titulos);
		int cont = 0;
		ResultSet resp= null;// almacena la respuesta de la consulta que se ejecuta
		Statement cons = null;
		String[] registros = new String[5];
		cn = conexionmysql.conectar();
		String consulta =" select * from ventas;";
	
		try
		{
			 Statement st = cn.createStatement();
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
	    table3.setModel(modeloDatostabla);
	}
	protected void actionPerformedBtnbuscar(ActionEvent e) {
		
		String  fact = txtfactura.getText();
		txtprecio.setText(crudventas.buscarventas(fact).getValue0().toString());
		txtdescuento.setText(crudventas.buscarventas(fact).getValue1().toString());
		txtempleado.setText(crudventas.buscarventas(fact).getValue2().toString());
		txtfecha.setText(crudventas.buscarventas(fact).getValue3().toString());
		
		
		
	}
	protected void actionPerformedBtnactualizar(ActionEvent e) {
		String factu,fecha,emplea;
		int desc,precio;
		
		factu = txtfactura.getText();
		precio=Integer.parseInt(txtprecio.getText());
		desc= Integer.parseInt(txtdescuento.getText());
		emplea=txtempleado.getText();
		fecha= txtfecha.getText();
		
		
	crudventas.actualizardatos(factu, precio, desc, emplea, fecha);
	}
	protected void actionPerformedBtneliminar(ActionEvent e) {
		
		String cod= txtfactura.getText();
		crudventas.Eliminardatos(cod);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table3) {
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

		int filaseleccionada = table3.rowAtPoint(e.getPoint()); //maneja posiciones
		
		txtfactura.setText(table3.getValueAt(filaseleccionada, 0).toString());
		txtprecio.setText(table3.getValueAt(filaseleccionada, 1).toString());
		txtdescuento.setText(table3.getValueAt(filaseleccionada, 2).toString());
		txtempleado.setText(table3.getValueAt(filaseleccionada, 3).toString());
		txtfecha.setText(table3.getValueAt(filaseleccionada, 4).toString());
		
	}
	}
 