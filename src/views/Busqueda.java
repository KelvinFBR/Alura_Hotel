package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HuespedController;
import controller.ReservaController;
import module.Huespedes;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloH;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	private boolean tieneFilaElegidaHuespedes() {
		return tbHuespedes.getSelectedRowCount() > 0;
	}

	private boolean tieneFilaElegidaReservas() {
		return tbReservas.getSelectedRowCount() > 0;
	}

	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), tbReservas,
				null);
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");

		// cargarDatos
		ReservaController.cargarTablaReservas(modelo);

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), tbHuespedes,
				null);
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		modeloH.addColumn("Numero de Huesped");
		modeloH.addColumn("Nombre");
		modeloH.addColumn("Apellido");
		modeloH.addColumn("Fecha de Nacimiento");
		modeloH.addColumn("Nacionalidad");
		modeloH.addColumn("Telefono");
		modeloH.addColumn("Numero de Reserva");

		// cargarDatos
		HuespedController.cargarTablaHuespedes(modeloH);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (panel.getSelectedIndex() == 0) {
					ReservaController.cargarTablaReservas(modelo);
				}

				if (panel.getSelectedIndex() == 1) {
					HuespedController.cargarTablaHuespedes(modeloH);
				}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (txtBuscar.getText().length() > 0) {
					if (panel.getSelectedIndex() == 0) {

						for (int i = 0; i < tbReservas.getRowCount(); i++) {
							modelo.removeRow(i);
							i -= 1;
						}

						ReservaController.cargarTablaReservasBusqueda(modelo, txtBuscar.getText());
					}

					if (panel.getSelectedIndex() == 1) {

						for (int i = 0; i < tbHuespedes.getRowCount(); i++) {
							modeloH.removeRow(i);
							i -= 1;
						}

						HuespedController.cargarTablaHuespedesBusqueda(modeloH, txtBuscar.getText());
					}
				} else {
					ReservaController.cargarTablaReservas(modelo);
					HuespedController.cargarTablaHuespedes(modeloH);
				}

			}
		});

		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					if (panel.getSelectedIndex() == 0) {
						Optional.ofNullable(
								modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
								.ifPresentOrElse(fila -> {
									Integer id = Integer
											.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
									String FechaEntrada = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 1);
									String FechaSalida = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 2);
									Integer Valor = Integer
											.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
									String FormaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);

									System.out.println(id + FechaEntrada + FechaSalida + Valor + FormaPago);

									ReservaController resevaController = new ReservaController();
									var filasModificadas = resevaController.modificar(FechaEntrada, FechaSalida, Valor,
											FormaPago, id);
//
									JOptionPane.showMessageDialog(contentPane,
											String.format("%d item modificado con éxito!", filasModificadas));
								}, () -> JOptionPane.showMessageDialog(contentPane, "Por favor, elije un item"));

						// limpieza
						modelo.getDataVector().clear();
						modeloH.getDataVector().clear();

						// cargarDatos
						HuespedController.cargarTablaHuespedes(modeloH);
						ReservaController.cargarTablaReservas(modelo);

					}

					if (panel.getSelectedIndex() == 1) {
						Optional.ofNullable(
								modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
								.ifPresentOrElse(fila -> {
									Integer id = Integer
											.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
									String nombre = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 1);
									String apellido = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 2);
									String FechaNacimiento = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(),
											3);
									String nacionalidad = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 4);
									String telefono = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 5);
									Integer idReserva = Integer
											.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());

									System.out.println(nombre);

									HuespedController huespedController = new HuespedController();
									var filasModificadas = huespedController.modificar(nombre, apellido,
											FechaNacimiento, nacionalidad, telefono, idReserva, id);

									JOptionPane.showMessageDialog(contentPane,
											String.format("%d item modificado con éxito!", filasModificadas));
								}, () -> JOptionPane.showMessageDialog(contentPane, "Por favor, elije un item"));

						// limpieza
						modelo.getDataVector().clear();
						modeloH.getDataVector().clear();

						// cargarDatos
						HuespedController.cargarTablaHuespedes(modeloH);
						ReservaController.cargarTablaReservas(modelo);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Error al editar registro.");
				}
			}
		});
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
//					if  (!tieneFilaElegidaHuespedes() || !tieneFilaElegidaReservas()) {
//						JOptionPane.showMessageDialog(contentPane, "Por favor, elije un item");
//						return;
//					}

					System.out.println(tbHuespedes.getSelectedRow());
					System.out.println(tbReservas.getSelectedRow());

					if (panel.getSelectedIndex() == 0) {

						Optional.ofNullable(
								modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
								.ifPresentOrElse(fila -> {
									Integer id = Integer
											.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());

									ReservaController resevaController = new ReservaController();
									System.out.println(id);
									resevaController.eliminarHuespedesAnidados(id);
									var filasModificadas = resevaController.eliminar(id);

									modelo.removeRow(tbReservas.getSelectedRow());

									JOptionPane.showMessageDialog(contentPane,
											String.format("%d item eliminado con éxito!", filasModificadas));
								}, () -> JOptionPane.showMessageDialog(contentPane, "Por favor, elije un item"));

						// limpieza
						modelo.getDataVector().clear();
						modeloH.getDataVector().clear();

						// cargarDatos
						HuespedController.cargarTablaHuespedes(modeloH);
						ReservaController.cargarTablaReservas(modelo);
					}

					if (panel.getSelectedIndex() == 1) {
//						modeloH.removeRow(tbHuespedes.getSelectedRow());

						Optional.ofNullable(
								modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
								.ifPresentOrElse(fila -> {
									Integer id = Integer
											.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());

									Integer idReservas = Integer
											.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());

									HuespedController huespedController = new HuespedController();

									var filasModificadas = huespedController.eliminar(id);
									huespedController.eliminarReservasAnidados(idReservas);
//

									modeloH.removeRow(tbHuespedes.getSelectedRow());
//
									JOptionPane.showMessageDialog(contentPane,
											String.format("%d item eliminado con éxito!", filasModificadas));
								}, () -> JOptionPane.showMessageDialog(contentPane, "Por favor, elije un item"));

						// limpieza
						modelo.getDataVector().clear();
						modeloH.getDataVector().clear();

//						// cargarDatos
						HuespedController.cargarTablaHuespedes(modeloH);
						ReservaController.cargarTablaReservas(modelo);

					}

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Error al eliminar registro/asegurarse de selecionarlo.");

					// limpieza
					modelo.getDataVector().clear();
					modeloH.getDataVector().clear();

//					// cargarDatos
					HuespedController.cargarTablaHuespedes(modeloH);
					ReservaController.cargarTablaReservas(modelo);
				}
			}
		});
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
