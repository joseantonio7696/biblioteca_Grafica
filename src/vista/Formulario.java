package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import modelo.Libro;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel panel, panel_1;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnDeshacer;
	private JPanel panel_2;
	private JLabel lblIdLibros;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblEditorial;
	private JLabel lblFecha;
	private JTextField textFieldISBN;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldEditorial;
	private JTextField textFieldFecha;
	private JCheckBox chcPrestado;
	private JLabel lblFechaAyuda;
	private JPanel panel_3;
	private JButton btnInicio;
	private JButton btnRetroceder;
	private JButton btnAvanzar;
	private JButton btnFinal;
	private JLabel lblConsulta;
	private JTextField textFieldFiltrado;
	private JComboBox comboBoxConsulta;
	private JButton btnFiltrar;
	private JPanel panel_4;
	private JTable tableLibros;
	private JScrollPane scrollPane;
	DefaultTableModel dtm;
	private JTextField textFieldPrecio;
	private JLabel lblPrecio;
	private int punteroNavegacion = 0;

	public Formulario(List<Libro> listadoLibros) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1406, 668);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		definirVentana(listadoLibros);
		definirEventos(listadoLibros);
		setVisible(true);
	}

	private void definirVentana(List<Libro> listadoLibros) {

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Mantenimiento Libros",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 11, 260, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon("imagenes\\add.png"));
		btnNuevo.setBounds(10, 21, 40, 40);
		panel_1.add(btnNuevo);

		btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon("imagenes\\edit.png"));
		btnEditar.setBounds(60, 21, 40, 40);
		panel_1.add(btnEditar);

		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon("imagenes\\delete.png"));
		btnEliminar.setBounds(110, 21, 40, 40);
		panel_1.add(btnEliminar);

		btnGuardar = new JButton("");
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon("imagenes\\save.png"));
		btnGuardar.setBounds(160, 21, 40, 40);
		panel_1.add(btnGuardar);

		btnDeshacer = new JButton("");
		btnDeshacer.setEnabled(false);
		btnDeshacer.setIcon(new ImageIcon("imagenes\\undo.png"));
		btnDeshacer.setBounds(210, 21, 40, 40);
		panel_1.add(btnDeshacer);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Libros", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(10, 108, 341, 278);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lblIdLibros = new JLabel("ISBN");
		lblIdLibros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdLibros.setBounds(10, 29, 64, 25);
		panel_2.add(lblIdLibros);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(10, 65, 64, 25);
		panel_2.add(lblTitulo);

		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAutor.setBounds(10, 101, 64, 25);
		panel_2.add(lblAutor);

		lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEditorial.setBounds(10, 137, 64, 25);
		panel_2.add(lblEditorial);

		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(10, 173, 64, 25);
		panel_2.add(lblFecha);

		lblFechaAyuda = new JLabel("aaaa-MM-dd");
		lblFechaAyuda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaAyuda.setBounds(249, 173, 83, 25);
		panel_2.add(lblFechaAyuda);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(10, 209, 64, 18);
		panel_2.add(lblPrecio);

		// NOS CREAMOS UN ARRAY UNIDIMENSIONAL PARA METER LOS PRIMEROS VALORES DEL ARRAY
		// LIST AL CARGAR EL FORMULARIO
		String libros[] = listadoLibros.get(punteroNavegacion).toString().split(",");

		textFieldISBN = new JTextField(libros[0]);
		textFieldISBN.setEditable(false);
		textFieldISBN.setBounds(84, 32, 248, 20);
		panel_2.add(textFieldISBN);
		textFieldISBN.setColumns(10);

		textFieldTitulo = new JTextField(libros[1]);
		textFieldTitulo.setEditable(false);
		textFieldTitulo.setBounds(84, 68, 248, 20);
		panel_2.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		textFieldAutor = new JTextField(libros[2]);
		textFieldAutor.setEditable(false);
		textFieldAutor.setBounds(84, 104, 248, 20);
		panel_2.add(textFieldAutor);
		textFieldAutor.setColumns(10);

		textFieldEditorial = new JTextField(libros[3]);
		textFieldEditorial.setEditable(false);
		textFieldEditorial.setBounds(84, 140, 248, 20);
		panel_2.add(textFieldEditorial);
		textFieldEditorial.setColumns(10);

		textFieldFecha = new JTextField(libros[4]);
		textFieldFecha.setEditable(false);
		textFieldFecha.setBounds(84, 176, 155, 20);
		panel_2.add(textFieldFecha);
		textFieldFecha.setColumns(10);

		textFieldPrecio = new JTextField(libros[5]);
		textFieldPrecio.setEditable(false);
		textFieldPrecio.setBounds(84, 207, 155, 20);
		panel_2.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		// PARA EL CHECKBOX TENDREMOS QUE COMPROBAR SI EL ATRIBUTO BOOLEANO ESTA TRUE O
		// FALSE Y SEGUIDAMENTE LE MANDAMOS LA VARIABLE ACTIVADO SEGUN EL VALOR DE EL
		// VALOR DE DICHO ARRAYLIST
		boolean activado = false;
		if (libros[6].equals("true")) {
			activado = true;
		}

		chcPrestado = new JCheckBox("Prestado");
		chcPrestado.setEnabled(false);
		chcPrestado.setSelected(activado);
		chcPrestado.setFont(new Font("Tahoma", Font.BOLD, 12));
		chcPrestado.setBounds(6, 248, 97, 23);
		panel_2.add(chcPrestado);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Navegador", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLUE));
		panel_3.setBounds(10, 397, 211, 70);
		panel.add(panel_3);
		panel_3.setLayout(null);

		btnInicio = new JButton("");
		btnInicio.setEnabled(false);
		btnInicio.setIcon(new ImageIcon("imagenes\\backward.png"));
		btnInicio.setBounds(10, 19, 40, 40);
		panel_3.add(btnInicio);

		btnRetroceder = new JButton("");
		btnRetroceder.setEnabled(false);
		btnRetroceder.setIcon(new ImageIcon("imagenes\\beginning.png"));
		btnRetroceder.setBounds(60, 19, 40, 40);
		panel_3.add(btnRetroceder);

		btnAvanzar = new JButton("");
		btnAvanzar.setIcon(new ImageIcon("imagenes\\end.png"));
		btnAvanzar.setBounds(110, 19, 40, 40);
		panel_3.add(btnAvanzar);

		btnFinal = new JButton("");
		btnFinal.setIcon(new ImageIcon("imagenes\\forward.png"));
		btnFinal.setBounds(160, 19, 40, 40);
		panel_3.add(btnFinal);

		lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConsulta.setBounds(470, 11, 68, 25);
		panel.add(lblConsulta);

		comboBoxConsulta = new JComboBox();
		comboBoxConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxConsulta.setModel(new DefaultComboBoxModel(new String[] { "Titulo", "Autor" }));
		comboBoxConsulta.setBounds(470, 47, 68, 25);
		panel.add(comboBoxConsulta);

		textFieldFiltrado = new JTextField();
		textFieldFiltrado.setBounds(548, 47, 170, 25);
		panel.add(textFieldFiltrado);
		textFieldFiltrado.setColumns(10);

		btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFiltrar.setBounds(728, 48, 89, 23);
		panel.add(btnFiltrar);

		panel_4 = new JPanel();
		panel_4.setBounds(361, 108, 953, 512);
		panel.add(panel_4);
		panel_4.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 953, 512);
		panel_4.add(scrollPane);

		dtm = new DefaultTableModel(); // IMPORTANTE INSTANCIAR EL DTM
		tableLibros = new JTable(dtm); // IMPORTANTE ENVIARLE A LA TABLA LOS DATOS DEL DTM
		scrollPane.setViewportView(tableLibros);
		cargarGrid(listadoLibros);

	}

	private void definirEventos(List<Libro> listadoLibros) {

		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				punteroNavegacion = 0;
				
				String libros[] = listadoLibros.get(punteroNavegacion).toString().split(",");
				
				textFieldISBN.setEditable(false);
				textFieldISBN.setText(libros[0]);
				textFieldTitulo.setEditable(false);
				textFieldTitulo.setText(libros[1]);
				textFieldAutor.setEditable(false);
				textFieldAutor.setText(libros[2]);
				textFieldEditorial.setEditable(false);
				textFieldEditorial.setText(libros[3]);
				textFieldFecha.setEditable(false);
				textFieldFecha.setText(libros[4]);
				textFieldPrecio.setEditable(false);
				textFieldPrecio.setText(libros[5]);
				chcPrestado.setEnabled(false);
				chcPrestado.setSelected(Boolean.parseBoolean(libros[6]));
				
				btnInicio.setEnabled(false);
				btnRetroceder.setEnabled(false);
				btnAvanzar.setEnabled(true);
				btnFinal.setEnabled(true);

			}
		});

		btnRetroceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				punteroNavegacion--;
				
				String libros[] = listadoLibros.get(punteroNavegacion).toString().split(",");

				textFieldISBN.setEditable(false);
				textFieldISBN.setText(libros[0]);
				textFieldTitulo.setEditable(false);
				textFieldTitulo.setText(libros[1]);
				textFieldAutor.setEditable(false);
				textFieldAutor.setText(libros[2]);
				textFieldEditorial.setEditable(false);
				textFieldEditorial.setText(libros[3]);
				textFieldFecha.setEditable(false);
				textFieldFecha.setText(libros[4]);
				textFieldPrecio.setEditable(false);
				textFieldPrecio.setText(libros[5]);
				chcPrestado.setEnabled(false);
				chcPrestado.setSelected(Boolean.parseBoolean(libros[6]));

				if (punteroNavegacion == 0) {
					btnInicio.setEnabled(false);
					btnRetroceder.setEnabled(false);
					btnAvanzar.setEnabled(true);
					btnFinal.setEnabled(true);
				} else if (punteroNavegacion > 0 && (punteroNavegacion <= listadoLibros.size()-2)) {

					btnInicio.setEnabled(true);
					btnRetroceder.setEnabled(true);
					btnAvanzar.setEnabled(true);
					btnFinal.setEnabled(true);
				} else if(punteroNavegacion==(listadoLibros.size()-1)) {
					btnInicio.setEnabled(true);
					btnRetroceder.setEnabled(true);
					btnAvanzar.setEnabled(false);
					btnFinal.setEnabled(false);
				}
			}
		});
		
		btnAvanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				punteroNavegacion++;

				String libros[] = listadoLibros.get(punteroNavegacion).toString().split(",");

				textFieldISBN.setEditable(false);
				textFieldISBN.setText(libros[0]);
				textFieldTitulo.setEditable(false);
				textFieldTitulo.setText(libros[1]);
				textFieldAutor.setEditable(false);
				textFieldAutor.setText(libros[2]);
				textFieldEditorial.setEditable(false);
				textFieldEditorial.setText(libros[3]);
				textFieldFecha.setEditable(false);
				textFieldFecha.setText(libros[4]);
				textFieldPrecio.setEditable(false);
				textFieldPrecio.setText(libros[5]);
				chcPrestado.setEnabled(false);
				chcPrestado.setSelected(Boolean.parseBoolean(libros[6]));

				if (punteroNavegacion == 0) {
					btnInicio.setEnabled(false);
					btnRetroceder.setEnabled(false);
					btnAvanzar.setEnabled(true);
					btnFinal.setEnabled(true);
				} else if (punteroNavegacion > 0 && (punteroNavegacion <= listadoLibros.size()-2)) {

					btnInicio.setEnabled(true);
					btnRetroceder.setEnabled(true);
					btnAvanzar.setEnabled(true);
					btnFinal.setEnabled(true);
				} else if(punteroNavegacion==(listadoLibros.size()-1)) {
					btnInicio.setEnabled(true);
					btnRetroceder.setEnabled(true);
					btnAvanzar.setEnabled(false);
					btnFinal.setEnabled(false);
				}
				
			}
		});
		
		btnFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				punteroNavegacion = listadoLibros.size()-1;

				String libros[] = listadoLibros.get(punteroNavegacion).toString().split(",");

				textFieldISBN.setEditable(false);
				textFieldISBN.setText(libros[0]);
				textFieldTitulo.setEditable(false);
				textFieldTitulo.setText(libros[1]);
				textFieldAutor.setEditable(false);
				textFieldAutor.setText(libros[2]);
				textFieldEditorial.setEditable(false);
				textFieldEditorial.setText(libros[3]);
				textFieldFecha.setEditable(false);
				textFieldFecha.setText(libros[4]);
				textFieldPrecio.setEditable(false);
				textFieldPrecio.setText(libros[5]);
				chcPrestado.setEnabled(false);
				chcPrestado.setSelected(Boolean.parseBoolean(libros[6]));
				
				btnInicio.setEnabled(true);
				btnRetroceder.setEnabled(true);
				btnAvanzar.setEnabled(false);
				btnFinal.setEnabled(false);
				
			}
		});
		

	}

	private void cargarGrid(List<Libro> listadoLibros) {
		String[] titulos = { "ISBN", "TITULO", "AUTOR", "EDITORIAL", "FECHA PRESTAMO", "PRECIO", "PRESTADO" };
		dtm.setRowCount(0); // Antes de llenar la tabla la vaciamos
		dtm.setColumnCount(0);
		dtm.setColumnIdentifiers(titulos); // pone los titulos en el panel

		for (int x = 0; x < listadoLibros.size(); x++) {

			String libro[] = listadoLibros.get(x).toString().split(",");

			dtm.addRow(libro);

		}

	}
}
