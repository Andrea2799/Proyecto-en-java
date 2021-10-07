package interfazshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfazshop.frmventas;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;

public class frmprincipalshop extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JDesktopPane escritorio;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntproductos;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem nmtcategorias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmprincipalshop frame = new frmprincipalshop();
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
	public frmprincipalshop() {
		setTitle("Base de datos Caro's Shop");
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmprincipalshop.class.getResource("/imagenes/computador.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Porcesos Internos");
		mnNewMenu.setIcon(new ImageIcon(frmprincipalshop.class.getResource("/imagenes/inside1,2.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Ventas");
		mntmNewMenuItem.setIcon(new ImageIcon(frmprincipalshop.class.getResource("/imagenes/ventas.png")));
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		mntproductos = new JMenuItem("Productos");
		mntproductos.setIcon(new ImageIcon(frmprincipalshop.class.getResource("/imagenes/producto.png")));
		mntproductos.addActionListener(this);
		mnNewMenu.add(mntproductos);
		
		nmtcategorias = new JMenuItem("Empleados");
		nmtcategorias.setIcon(new ImageIcon(frmprincipalshop.class.getResource("/imagenes/categoria.png")));
		nmtcategorias.addActionListener(this);
		mnNewMenu.add(nmtcategorias);
		
		mnNewMenu_1 = new JMenu("Procesos Externos");
		mnNewMenu_1.setIcon(new ImageIcon(frmprincipalshop.class.getResource("/imagenes/exit.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.setIcon(new ImageIcon(frmprincipalshop.class.getResource("/imagenes/cliente.png")));
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Proveedor");
		mntmNewMenuItem_2.setIcon(new ImageIcon(frmprincipalshop.class.getResource("/imagenes/proveedor.png")));
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritorio = new JDesktopPane();
		escritorio.setBorder(new CompoundBorder());
		escritorio.setBackground(SystemColor.activeCaption);
		contentPane.add(escritorio, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nmtcategorias) {
			actionPerformedNmtcategorias(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntproductos) {
			actionPerformedMntproductos(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		frmventas frmventasver= new frmventas();
		escritorio.add(frmventasver);
		frmventasver.setVisible(true);
	}
	protected void actionPerformedMntproductos(ActionEvent e) {
		frmproductos frmproductosver= new frmproductos();
		escritorio.add(frmproductosver);
		frmproductosver.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		frmclientes frmclientesver= new frmclientes();
		escritorio.add(frmclientesver);
		frmclientesver.setVisible(true);
		
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		
		frmproveedor frmproveverr= new frmproveedor();
		escritorio.add(frmproveverr);
		frmproveverr.setVisible(true);
	}
	protected void actionPerformedNmtcategorias(ActionEvent e) {
		frmempleados frmcategoriaver= new frmempleados();
		escritorio.add(frmcategoriaver);
		frmcategoriaver.setVisible(true);
	
	}
}
	

