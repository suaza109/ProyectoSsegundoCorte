package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.PokemonDTO;
import co.edu.unbosque.model.persistence.PokemonDAO;
import co.edu.unbosque.util.exception.NameNotValidException;
import co.edu.unbosque.util.exception.NoValidLetterException;
import co.edu.unbosque.util.exception.NoValidNegativeNumber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;

/**
 * La clase InicioView se encarga de mostrar la ventana principal del
 * aplicativo. Contien los recuadros y paneles de todas las caracteristicas de
 * los pokemones.
 */
public class InicioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField txtBusqueda;
	private JTextField txtNombre;
	private JTextField txtId; 
	private JTextField txtVida;
	private JTextField txtDefensa;
	private JTextField txtVelocidad;
	private JTextField txtDefensaEspecial;
	private JTextField txtAtaque;
	private JTextField txtListaAtaque;
	private JTable table;
	private PokemonDAO pokemonDAO;
	private CardPokemon cp;
	private DefaultTableModel model;
	private JList listaGeneracion;
	private JList listaTipoDePokemon;
	private Controller con;
	private String UrlFoto;
	private JLabel lblImg;
	private JLabel lblImagenPokemon;
	private String nuevaUrl;
	private String urlCompleto;
	private TableRowSorter TRSfiltro;
	private JTextField txtUrl;
	private JTextField txtBusquedaID;
	private JTextField txtBusquedaTipo;
	private JTextField txtBusquedaGeneracion;

	/**
	 * El constructor de la clase InicioView se encarga de inicializar y mostrar
	 * toda la vista de la ventana principal del aplicativo.
	 */
	public InicioView() {
		setFont(new Font("Adobe Devanagari", Font.PLAIN, 12));
		setTitle("Pokedex\r\n");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InicioView.class.getResource("/co/edu/unbosque/view/img/Icono.png")));
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 1185, 720);
		setLocation(60, 25);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(251, 82, 0));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		pokemonDAO = new PokemonDAO();
		con = new Controller();
		cp = new CardPokemon();

		listaGeneracion = new JList();
		listaGeneracion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listaGeneracion.setModel(new AbstractListModel() {
			String[] values = new String[] { "1", "2", "3", "9" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaGeneracion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaGeneracion.setBounds(274, 407, 56, 68);
		panelPrincipal.add(listaGeneracion);

		JLabel lblTituloGeneracion = new JLabel("Generación:");
		lblTituloGeneracion.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloGeneracion.setForeground(Color.WHITE);
		lblTituloGeneracion.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloGeneracion.setBackground(Color.LIGHT_GRAY);
		lblTituloGeneracion.setBounds(180, 407, 161, 14);
		panelPrincipal.add(lblTituloGeneracion);

		JLabel lblTituloFormatoAtaques = new JLabel("Ataque1_Ataque2_Ataque3_Ataque4");
		lblTituloFormatoAtaques.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloFormatoAtaques.setForeground(Color.black);
		lblTituloFormatoAtaques.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloFormatoAtaques.setBackground(Color.black);
		lblTituloFormatoAtaques.setBounds(20, 513, 320, 15);
		panelPrincipal.add(lblTituloFormatoAtaques);

		txtListaAtaque = new JTextField();
		txtListaAtaque.setBounds(20, 486, 613, 20);
		panelPrincipal.add(txtListaAtaque);
		txtListaAtaque.setColumns(10);

		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		txtDefensa.setBounds(20, 376, 150, 20);
		panelPrincipal.add(txtDefensa);

		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setBounds(20, 320, 150, 20);
		panelPrincipal.add(txtVida);

		txtDefensaEspecial = new JTextField();
		txtDefensaEspecial.setColumns(10);
		txtDefensaEspecial.setBounds(20, 430, 150, 20);
		txtDefensaEspecial.setText("Bloqueo");
		panelPrincipal.add(txtDefensaEspecial);

		txtNombre = new JTextField();
		txtNombre.setBounds(20, 262, 150, 20);
		panelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);

		txtAtaque = new JTextField();
		txtAtaque.setColumns(10);
		txtAtaque.setBounds(180, 320, 150, 20);
		panelPrincipal.add(txtAtaque);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(180, 262, 150, 20);
		panelPrincipal.add(txtId);

		txtVelocidad = new JTextField();
		txtVelocidad.setColumns(10);
		txtVelocidad.setBounds(180, 376, 150, 20);
		panelPrincipal.add(txtVelocidad);

		JLabel lblTituloTipoDePokemon = new JLabel("Tipo De Pokemon:");
		lblTituloTipoDePokemon.setBackground(new Color(192, 192, 192));
		lblTituloTipoDePokemon.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloTipoDePokemon.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloTipoDePokemon.setForeground(new Color(255, 255, 255));
		lblTituloTipoDePokemon.setBounds(338, 246, 161, 14);
		panelPrincipal.add(lblTituloTipoDePokemon);

		JLabel lblTituloListaAtaques = new JLabel("Lista De Ataques:");
		lblTituloListaAtaques.setBackground(new Color(192, 192, 192));
		lblTituloListaAtaques.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloListaAtaques.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloListaAtaques.setForeground(new Color(255, 255, 255));
		lblTituloListaAtaques.setBounds(20, 461, 150, 14);
		panelPrincipal.add(lblTituloListaAtaques);

		JLabel lblTituloId = new JLabel("Id:");
		lblTituloId.setBackground(new Color(192, 192, 192));
		lblTituloId.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloId.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloId.setForeground(new Color(255, 255, 255));
		lblTituloId.setBounds(180, 246, 161, 14);
		panelPrincipal.add(lblTituloId);

		JLabel lblTituloDefensa = new JLabel("Defensa:");
		lblTituloDefensa.setBackground(new Color(192, 192, 192));
		lblTituloDefensa.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloDefensa.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloDefensa.setForeground(new Color(255, 255, 255));
		lblTituloDefensa.setBounds(20, 351, 161, 14);
		panelPrincipal.add(lblTituloDefensa);

		JLabel lblTituloNombre = new JLabel("Nombre:");
		lblTituloNombre.setBackground(new Color(192, 192, 192));
		lblTituloNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloNombre.setForeground(new Color(255, 255, 255));
		lblTituloNombre.setBounds(20, 244, 161, 14);
		panelPrincipal.add(lblTituloNombre);

		JLabel lblTituloAtaque = new JLabel("Ataque:");
		lblTituloAtaque.setBackground(new Color(192, 192, 192));
		lblTituloAtaque.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloAtaque.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloAtaque.setForeground(new Color(255, 255, 255));
		lblTituloAtaque.setBounds(180, 293, 161, 14);
		panelPrincipal.add(lblTituloAtaque);

		JLabel lblTituloDefensaEspecial = new JLabel("Defensa Especial:");
		lblTituloDefensaEspecial.setBackground(new Color(192, 192, 192));
		lblTituloDefensaEspecial.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloDefensaEspecial.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloDefensaEspecial.setForeground(new Color(255, 255, 255));
		lblTituloDefensaEspecial.setBounds(20, 405, 161, 14);
		panelPrincipal.add(lblTituloDefensaEspecial);

		JLabel lblTituloVida = new JLabel("Vida:");
		lblTituloVida.setBackground(new Color(192, 192, 192));
		lblTituloVida.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloVida.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloVida.setForeground(new Color(255, 255, 255));
		lblTituloVida.setBounds(20, 293, 161, 14);
		panelPrincipal.add(lblTituloVida);

		JLabel lblTituloVelocidad = new JLabel("Velocidad:");
		lblTituloVelocidad.setBackground(new Color(192, 192, 192));
		lblTituloVelocidad.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloVelocidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloVelocidad.setForeground(new Color(255, 255, 255));
		lblTituloVelocidad.setBounds(180, 351, 161, 14);
		panelPrincipal.add(lblTituloVelocidad);


		JLabel lbllistaPokemones = new JLabel("Lista De Pokemones");
		lbllistaPokemones.setBackground(new Color(255, 255, 255));
		lbllistaPokemones.setVerticalTextPosition(SwingConstants.TOP);
		lbllistaPokemones.setHorizontalTextPosition(SwingConstants.CENTER);
		lbllistaPokemones.setHorizontalAlignment(SwingConstants.CENTER);
		lbllistaPokemones.setForeground(new Color(255, 255, 255));
		lbllistaPokemones.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbllistaPokemones.setBounds(285, 81, 340, 34);
		panelPrincipal.add(lbllistaPokemones);

		JLabel lblTutorial = new JLabel("Tutorial");
		lblTutorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String videoUrl = "src/co/edu/unbosque/view/img/tutorialPokedex.mp4";
		        try {
		            // Verificamos si el escritorio es compatible para abrir archivos
		            if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                // Verificar si el archivo de video existe
		                File videoFile = new File(videoUrl);
		                if (videoFile.exists()) {
		                    // Abrir el archivo de video con el reproductor predeterminado del sistema
		                    desktop.open(videoFile);
		                } else {
		                    System.out.println("El archivo de video no existe.");
		                }
		            } else {
		                System.out.println("El escritorio no es compatible.");
		            }
		        } catch (IOException i) {
		            System.out.println("Error al abrir el archivo de video: ");
		        }
			}
		});
		lblTutorial.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTutorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTutorial.setForeground(new Color(255, 255, 255));
		lblTutorial.setFont(lblTutorial.getFont().deriveFont(lblTutorial.getFont().getStyle() | Font.BOLD | Font.ITALIC,
				lblTutorial.getFont().getSize() + 5f));
		lblTutorial.setBounds(838, 528, 198, 34);
		panelPrincipal.add(lblTutorial);

		JLabel lblTitulo = new JLabel("Bienvenido a la Pokedex");
		lblTitulo.setVerticalTextPosition(SwingConstants.TOP);
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setBounds(414, 11, 340, 34);
		panelPrincipal.add(lblTitulo);

		JButton btnCrear = new JButton("Crear Pokemon");
		btnCrear.addActionListener(new ActionListener() {
			/**
			 * Este metodo actualiza y limpia los campos de la tabla.
			 * 
			 * @param e nombre del objeto para controlar este evento.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, con.crearPokemon(agarrarDatos()));
				actualizarTabla();
				limpiarcampos();
			}
		});
		btnCrear.setBounds(83, 615, 245, 55);
		panelPrincipal.add(btnCrear);

		JButton btnEliminar = new JButton("Eliminar Pokemon");
		btnEliminar.addActionListener(new ActionListener() {

			/**
			 * Este metodo elimina una fila y limpia los campos de la tabla.
			 * 
			 * @param e nombre del objeto para controlar este evento.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, con.eliminarPokemon(table.getSelectedRow()));
				eliminarFila();
				limpiarcampos();
			}
		});
		btnEliminar.setBounds(338, 615, 245, 55);
		panelPrincipal.add(btnEliminar);

		JButton btnActualizar = new JButton("Actualizar Pokemon");
		btnActualizar.addActionListener(new ActionListener() {

			/**
			 * Este metodo recarga y limpia los campos de la tabla.
			 * 
			 * @param e nombre del objeto para controlar este evento.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, con.actualizarPokemon(table.getSelectedRow(), agarrarDatos()));
				recargar();
				limpiarcampos();
			}
		});
		btnActualizar.setBounds(593, 615, 245, 55);
		panelPrincipal.add(btnActualizar);

		JButton btnSeleccionarPokemon = new JButton("SeleccionarPokemon");
		btnSeleccionarPokemon.addActionListener(new ActionListener() {

			/**
			 * Este metodo selecciona un pokemon y llena su tarjeta.
			 * 
			 * @param e nombre del objeto para controlar este evento.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setVisible(true);
				cp.setLocation(735, 100);
				seleccionarPokemon();
				llenarCard();
			}
		});
		btnSeleccionarPokemon.setBounds(852, 615, 245, 55);
		panelPrincipal.add(btnSeleccionarPokemon);

		lblImagenPokemon = new JLabel();
		lblImagenPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenPokemon.setForeground(Color.WHITE);
		lblImagenPokemon.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblImagenPokemon.setBackground(Color.LIGHT_GRAY);
		lblImagenPokemon.setBounds(483, 246, 150, 150);

		// Obtener la imagen y ajustar su tamaño
		ImageIcon icono = new ImageIcon(InicioView.class.getResource("/co/edu/unbosque/view/img/Icono.png"));
		Image imagen = icono.getImage();
		Image imagenEscalada = imagen.getScaledInstance(lblImagenPokemon.getWidth(), lblImagenPokemon.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

		// Establecer el icono escalado en el JLabel
		lblImagenPokemon.setIcon(iconoEscalado);
		panelPrincipal.add(lblImagenPokemon);

		JButton btnSubirImagen = new JButton("Subir Imagen");
		btnSubirImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImagenPokemon.setText("");
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					// Ruta relativa dentro del proyecto
					String rutaDestino = "src/co/edu/unbosque/view/img/";
					Path destino = Paths.get(rutaDestino);
					try {
						// Obtener la ruta absoluta del directorio actual
						Path rutaBase = Paths.get("").toAbsolutePath();
						// Combinar la ruta base con la ruta de destino
						Path destinoCompleto = rutaBase.resolve(destino).resolve(selectedFile.getName());
						// Copiar el archivo seleccionado a la ruta destino
						Files.copy(selectedFile.toPath(), destinoCompleto, StandardCopyOption.REPLACE_EXISTING);
						// Escalar imagen para que se adapte al tamaño del JLabel
						ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
						Image image = imageIcon.getImage();
						Image newImage = image.getScaledInstance(lblImagenPokemon.getWidth(),
								lblImagenPokemon.getHeight(), Image.SCALE_DEFAULT);
						lblImagenPokemon.setIcon(new ImageIcon(newImage));
						UrlFoto = String.valueOf(rutaDestino);
						urlCompleto = UrlFoto += selectedFile.getName();
						txtUrl.setText(urlCompleto);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnSubirImagen.setBounds(493, 403, 135, 23);
		panelPrincipal.add(btnSubirImagen);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 121, 663, 112);
		panelPrincipal.add(scrollPane);

		table = new JTable();

		model = new DefaultTableModel();
		table.setModel(model);

		model.addColumn("Nombre");
		model.addColumn("Tipo");
		model.addColumn("Generación");
		model.addColumn("Id");
		model.addColumn("Vida");
		model.addColumn("Ataque");
		model.addColumn("Defensa");
		model.addColumn("Velocidad");
		model.addColumn("Ataques Especiales");
		model.addColumn("Defensa Especial");
		model.addColumn("Imagen");
		llenarTabla();
		scrollPane.setViewportView(table);

		JScrollPane scrollPaneListaTipoDePokemon = new JScrollPane();
		scrollPaneListaTipoDePokemon.setBounds(340, 262, 117, 175);
		panelPrincipal.add(scrollPaneListaTipoDePokemon);

		listaTipoDePokemon = new JList();
		scrollPaneListaTipoDePokemon.setViewportView(listaTipoDePokemon);
		listaTipoDePokemon.setModel(new AbstractListModel() {
			String[] values = new String[] { "Acero", "Agua", "Bicho", "Dragón", "Eléctrico", "Fantasma", "Fuego",
					"Hada", "Hielo", "Lucha", "Normal", "Planta", "Psíquico", "Roca", "Siniestro", "Tierra",
					"Volador","Veneno" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaTipoDePokemon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTipoDePokemon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtUrl = new JTextField();
		txtUrl.setEnabled(false);
		txtUrl.setEditable(false);
		txtUrl.setColumns(10);
		txtUrl.setBounds(483, 430, 161, 20);
		panelPrincipal.add(txtUrl);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 31, 245, 84);
		panelPrincipal.add(tabbedPane);
		
		JPanel panelNombre = new JPanel();
		tabbedPane.addTab("Nombre", null, panelNombre, null);
				panelNombre.setLayout(null);
				
				txtBusqueda = new JTextField();
				txtBusqueda.setBounds(10, 5, 206, 20);
				panelNombre.add(txtBusqueda);
				txtBusqueda.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(final KeyEvent e) {
						String cadena = txtBusqueda.getText();
						txtBusqueda.setText(cadena);
						filtroPorNombre();
					}
				});
				
		JPanel panelID = new JPanel();
		tabbedPane.addTab("ID", null, panelID, null);
		panelID.setLayout(null);
		
		txtBusquedaID = new JTextField();
		txtBusquedaID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(final KeyEvent e) {
				String cadena = txtBusquedaID.getText();
				txtBusqueda.setText(cadena);
				filtroPorID();
			}
		});
		
		txtBusquedaID.setBounds(10, 5, 220, 20);
		panelID.add(txtBusquedaID);
		
		JPanel panelTipoPokemon = new JPanel();
		tabbedPane.addTab("Tipo De Pokemon", null, panelTipoPokemon, null);
		panelTipoPokemon.setLayout(null);
		
		txtBusquedaTipo = new JTextField();
		txtBusquedaTipo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(final KeyEvent e) {
				String cadena = txtBusquedaTipo.getText();
				txtBusqueda.setText(cadena);
				filtroPorTipo();
			}
		});
		txtBusquedaTipo.setBounds(10, 5, 220, 20);
		panelTipoPokemon.add(txtBusquedaTipo);
		
		JPanel panelGeneracion = new JPanel();
		tabbedPane.addTab("Generación", null, panelGeneracion, null);
		panelGeneracion.setLayout(null);
		
		txtBusquedaGeneracion = new JTextField();
		txtBusquedaGeneracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(final KeyEvent e) {
				String cadena = txtBusquedaGeneracion.getText();
				txtBusqueda.setText(cadena);
				filtroPorGeneracion();
			}
		});
		txtBusquedaGeneracion.setBounds(10, 5, 220, 20);
		panelGeneracion.add(txtBusquedaGeneracion);
		
		TRSfiltro = new TableRowSorter(table.getModel());
		table.setRowSorter(TRSfiltro);
		
		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(InicioView.class.getResource("/co/edu/unbosque/view/img/scorbunny.jpg")));
		lblImg.setBounds(0, 0, 1176, 681);
		panelPrincipal.add(lblImg);
	}

	/**
	 * Este metodo sirve para almacenar correctamente por filas, los datos de los
	 * pokemones mediante una tabla.
	 */
	public void llenarTabla() {
		ArrayList<PokemonDTO> listaPokemones = pokemonDAO.getLista();
		for (PokemonDTO pokemonDTO : listaPokemones) {
			Object[] fila = new Object[11];
			fila[0] = pokemonDTO.getNombre();
			fila[1] = pokemonDTO.getTipoPokemon();
			fila[2] = pokemonDTO.getGeneracion();
			fila[3] = pokemonDTO.getId();
			fila[4] = pokemonDTO.getVida();
			fila[5] = pokemonDTO.getAtaque();
			fila[6] = pokemonDTO.getDefensa();
			fila[7] = pokemonDTO.getVelocidad();
			fila[8] = pokemonDTO.getListaAtaque();
			fila[9] = pokemonDTO.getDefensaEspecial();
			fila[10] = pokemonDTO.getFotoGif();
			model.addRow(fila);
		}
	}

	/**
	 * Si el usuario introduce un Numero Negativo salta Excepcion.
	 */
	public void checkNegativeNumber(String check) throws NoValidNegativeNumber {
		int checkInt = Integer.parseInt(check);
		if (checkInt < 0) {
			throw new NoValidNegativeNumber();
		}
	}

	/**
	 * Si el usuario introduce una letra salta Exepcion.
	 */
	public void checkNoValidLetter(String check) throws NoValidLetterException {
		Pattern p = Pattern.compile("[a-zA-z]");
		Matcher m = p.matcher(check);
		if (m.find()) {
			throw new NoValidLetterException();
		}
	}

	// Si el usuario introduce un numero salta Execpion
	public void checkNoValidNumber(String check) throws NameNotValidException {
		Pattern p = Pattern.compile("[^a-zA-z]");
		Matcher m = p.matcher(check);
		if (m.find()) {
			throw new NameNotValidException();
		}
	}

	/**
	 * Metodo PokemonDTO que sirve para agarrar los datos de los pokemones y luego
	 * los llena en la tabla.
	 */
	public PokemonDTO agarrarDatos() {
		String nombre = "";
		String tipoPokemon = "";
		int generacion = 0;
		int id = 0;
		int vida = 0;
		int ataque = 0;
		int defensa = 0;
		int velocidad = 0;
		String listaAtaque = "";
		String defensaEsp = "";
		String urlFinal = "";

		try {
			nombre = txtNombre.getText();
			checkNoValidNumber(nombre);

			tipoPokemon = listaTipoDePokemon.getSelectedValue().toString();
			String generacionStr = listaGeneracion.getSelectedValue().toString();
			checkNoValidLetter(generacionStr);
			checkNegativeNumber(generacionStr);
			String idStr = txtId.getText();
			checkNoValidLetter(idStr);
			checkNegativeNumber(idStr);
			String vidaStr = txtVida.getText();
			checkNoValidLetter(vidaStr);
			checkNegativeNumber(vidaStr);
			String ataqueStr = txtAtaque.getText();
			checkNoValidLetter(ataqueStr);
			checkNegativeNumber(ataqueStr);
			String defensaStr = txtDefensa.getText();
			checkNoValidLetter(defensaStr);
			checkNegativeNumber(defensaStr);
			String velocidadStr = txtVelocidad.getText();
			checkNoValidLetter(velocidadStr);
			checkNegativeNumber(velocidadStr);

			generacion = Integer.parseInt(generacionStr);
			id = Integer.parseInt(idStr);
			vida = Integer.parseInt(vidaStr);
			ataque = Integer.parseInt(ataqueStr);
			defensa = Integer.parseInt(defensaStr);
			velocidad = Integer.parseInt(velocidadStr);

			listaAtaque = txtListaAtaque.getText();
			checkNoValidNumber(listaAtaque);
			defensaEsp = txtDefensaEspecial.getText();
			checkNoValidNumber(defensaEsp);
			//txtUrl.setText(urlCompleto);
			urlFinal = txtUrl.getText();
			
		} catch (NameNotValidException e) {
			JOptionPane.showMessageDialog(null, "No se aceptan numeros en este campo");
		} catch (NoValidNegativeNumber e) {
			JOptionPane.showMessageDialog(null, "No se aceptan numeros negativos en este campo");
		} catch (NoValidLetterException e) {
			JOptionPane.showMessageDialog(null, "No se aceptan Letras en este campo");
		}

		return new PokemonDTO(nombre, tipoPokemon, id, vida, ataque, defensa, listaAtaque, defensaEsp, velocidad,
				urlFinal, generacion);
	}

	/**
	 * Este metodo actualiza los datos de la tabla de los pokemones.
	 */
	public void actualizarTabla() {
		Object[] fila = new Object[11];
		fila[0] = agarrarDatos().getNombre();
		fila[1] = agarrarDatos().getTipoPokemon();
		fila[2] = agarrarDatos().getGeneracion();
		fila[3] = agarrarDatos().getId();
		fila[4] = agarrarDatos().getVida();
		fila[5] = agarrarDatos().getAtaque();
		fila[6] = agarrarDatos().getDefensa();
		fila[7] = agarrarDatos().getVelocidad();
		fila[8] = agarrarDatos().getListaAtaque();
		fila[9] = agarrarDatos().getDefensaEspecial();
		fila[10] = agarrarDatos().getFotoGif();
		model.addRow(fila);
	}

	public void limpiarcampos() {
		txtNombre.setText("");
		txtId.setText("");
		txtVida.setText("");
		txtAtaque.setText("");
		txtDefensa.setText("");
		txtVelocidad.setText("");
		txtListaAtaque.setText("");
		txtDefensaEspecial.setText("");
		txtUrl.setText("");
		
		ImageIcon icono = new ImageIcon(InicioView.class.getResource("/co/edu/unbosque/view/img/Icono.png"));
		Image imagen = icono.getImage();
		Image imagenEscalada = imagen.getScaledInstance(lblImagenPokemon.getWidth(), lblImagenPokemon.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		lblImagenPokemon.setIcon(iconoEscalado);
	}

	/**
	 * Este metodo elimina una fila de la tabla.
	 */
	public void eliminarFila() {
		model.removeRow(table.getSelectedRow());
	}

	/**
	 * Cumple la funcion de seleccionar un pokemon de la tabla.
	 */
	public void seleccionarPokemon() {
		int filaSelecionada = table.getSelectedRow();
		if (filaSelecionada != -1) {
			txtNombre.setText((String) table.getValueAt(filaSelecionada, 0));
			txtId.setText(Integer.toString((int) table.getValueAt(filaSelecionada, 3)));
			txtVida.setText(Integer.toString((int) table.getValueAt(filaSelecionada, 4)));
			txtAtaque.setText(Integer.toString((int) table.getValueAt(filaSelecionada, 5)));
			txtDefensa.setText(Integer.toString((int) table.getValueAt(filaSelecionada, 6)));
			txtVelocidad.setText(Integer.toString((int) table.getValueAt(filaSelecionada, 7)));
			txtListaAtaque.setText((String) table.getValueAt(filaSelecionada, 8));
			txtDefensaEspecial.setText((String) table.getValueAt(filaSelecionada, 9));
			txtUrl.setText((String) table.getValueAt(filaSelecionada, 10));
			
			int op = (int) table.getValueAt(filaSelecionada, 2);
			switch (op) {
			case 1: {
				listaGeneracion.setSelectedIndex(0);
				break;
			}case 2:{
				listaGeneracion.setSelectedIndex(1);
				break;
			}case 3:{
				listaGeneracion.setSelectedIndex(2);
				break;
			}case 9:{
				listaGeneracion.setSelectedIndex(3);
				break;
			}
			default:
				JOptionPane.showMessageDialog(null, "El Pokemon no tiene categoria");
			}	
			
			mostarEnListaTipoPokemon();
		
			String url = txtUrl.getText();
			nuevaUrl = url.replace("\\", "/");
			ImageIcon icono = new ImageIcon(nuevaUrl);
			Image imagen = icono.getImage();
			int ancho = lblImagenPokemon.getWidth();
			int alto = lblImagenPokemon.getHeight();
			Image imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
			lblImagenPokemon.setIcon(new ImageIcon(imagenEscalada));

		} else {
			JOptionPane.showMessageDialog(null, "Debes selecionar una pokemon en la tabla");
		}
	}

	/**
	 * Este metodo sirve para llenar la tarjeta de cada pokemon con sus respectivos
	 * atributos y caracteristicas.
	 */
	public void llenarCard() {
		// Llenar la Card
		String nombre = "";
		String tipoPokemon = "";
		int generacion = 0;
		int id = 0;
		int vida = 0;
		int ataque = 0;
		int defensa = 0;
		int velocidad = 0;
		String listaAtaque = "";
		String defensaEsp = "";
		String urlFinal = "";

		nombre = txtNombre.getText();
		int filaSelecionada = table.getSelectedRow();
		if (filaSelecionada != -1) {
			tipoPokemon = (String) table.getValueAt(filaSelecionada, 1);
			generacion = (int) table.getValueAt(filaSelecionada, 2);
		}
		String idStr = txtId.getText();
		String vidaStr = txtVida.getText();
		String ataqueStr = txtAtaque.getText();
		String defensaStr = txtDefensa.getText();
		String velocidadStr = txtVelocidad.getText();

		id = Integer.parseInt(idStr);
		vida = Integer.parseInt(vidaStr);
		ataque = Integer.parseInt(ataqueStr);
		defensa = Integer.parseInt(defensaStr);
		velocidad = Integer.parseInt(velocidadStr);
		listaAtaque = txtListaAtaque.getText();
		defensaEsp = txtDefensaEspecial.getText();
		urlFinal = txtUrl.getText();

		cp.llenarCard(nombre, tipoPokemon, generacion, id, vida, ataque, defensa, velocidad, listaAtaque, defensaEsp,
				urlFinal);
	}

	/**
	 * Este metodo sirve para mostrar la actualizacion de cada fila y columna.
	 */

	public void recargar() {
		int filaSelecionada = table.getSelectedRow();
		if (filaSelecionada != -1) {
			model.setValueAt(txtNombre.getText(), filaSelecionada, 0);
			model.setValueAt(listaTipoDePokemon.getSelectedValue(), filaSelecionada, 1);
			model.setValueAt(Integer.parseInt((String) listaGeneracion.getSelectedValue()), filaSelecionada, 2);
			model.setValueAt(Integer.parseInt(txtId.getText()), filaSelecionada, 3);
			model.setValueAt(Integer.parseInt(txtVida.getText()), filaSelecionada, 4);
			model.setValueAt(Integer.parseInt(txtAtaque.getText()), filaSelecionada, 5);
			model.setValueAt(Integer.parseInt(txtDefensa.getText()), filaSelecionada, 6);
			model.setValueAt(Integer.parseInt(txtVelocidad.getText()), filaSelecionada, 7);
			model.setValueAt(txtListaAtaque.getText(), filaSelecionada, 8);
			model.setValueAt(txtDefensaEspecial.getText(), filaSelecionada, 9);
			model.setValueAt(txtUrl.getText(), filaSelecionada, 10);

		} else {
			JOptionPane.showMessageDialog(null, "Debes selecionar una pokemon en la tabla");
		}
	}
	public void filtroPorNombre(){
		int columnaNombre = 0;
		TRSfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(), columnaNombre));
		
	}
	public void filtroPorTipo(){
		int columnaNombre = 1;
		TRSfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(), columnaNombre));
		
	}
	public void filtroPorGeneracion(){
		int columnaNombre = 2;
		TRSfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(), columnaNombre));
		
	}
	public void filtroPorID(){
		int columnaNombre = 3;
		TRSfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(), columnaNombre));
		
	}
	public void mostarEnListaTipoPokemon() {
		int filaSelecionada = table.getSelectedRow();
		if (filaSelecionada != -1) {
			String tipoPokemon = (String) table.getValueAt(filaSelecionada, 1);
			
			switch (tipoPokemon) {
			case "Acero": {
				listaTipoDePokemon.setSelectedIndex(0);
				break;
			}case "Agua": {
				listaTipoDePokemon.setSelectedIndex(1);
				break;
			}case "Bicho": {
				listaTipoDePokemon.setSelectedIndex(2);
				break;
			}case "Dragón": {
				listaTipoDePokemon.setSelectedIndex(3);
				break;
			}case "Eléctrico": {
				listaTipoDePokemon.setSelectedIndex(4);
				break;
			}case "Fantasma": {
				listaTipoDePokemon.setSelectedIndex(5);
				break;
			}case "Fuego": {
				listaTipoDePokemon.setSelectedIndex(6);
				break;
			}case "Hada": {
				listaTipoDePokemon.setSelectedIndex(7);
				break;
			}case "Hielo": {
				listaTipoDePokemon.setSelectedIndex(8);
				break;
			}case "Lucha": {
				listaTipoDePokemon.setSelectedIndex(9);
				break;
			}case "Normal": {
				listaTipoDePokemon.setSelectedIndex(10);
				break;
			}case "Planta": {
				listaTipoDePokemon.setSelectedIndex(11);
				break;
			}case "Psíquico": {
				listaTipoDePokemon.setSelectedIndex(12);
				break;
			}case "Roca": {
				listaTipoDePokemon.setSelectedIndex(13);
				break;
			}case "Siniestro": {
				listaTipoDePokemon.setSelectedIndex(14);
				break;
			}case "Tierra": {
				listaTipoDePokemon.setSelectedIndex(15);
				break;
			}case "Volador": {
				listaTipoDePokemon.setSelectedIndex(16);
				break;
			}case "Veneno": {
				listaTipoDePokemon.setSelectedIndex(17);
				break;
			}default:
				JOptionPane.showMessageDialog(null, "El pokemon no tiene tipo");
			}
			
			
			
		}
		
	}
}
