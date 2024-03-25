package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

public class InicioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTable tablaPokemones;
	private JTextField txtBusqueda;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtVida;
	private JTextField txtDefensa;
	private JTextField txtVelocidad;
	private JTextField txtTipoPokemon;
	private JTextField txtDefensaEspecial;
	private JTextField txtAtaque;
	private JTextField txtListaAtaque;
	
	public InicioView() {
		setFont(new Font("Adobe Devanagari", Font.PLAIN, 12));
		setTitle("Pokedex\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioView.class.getResource("/co/edu/unbosque/view/img/Icono.png")));
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 1185, 720);
		setLocation(60, 25);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(251, 82, 0));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblImagenPokemon = new JLabel("IMAGEN");
		lblImagenPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenPokemon.setForeground(Color.WHITE);
		lblImagenPokemon.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblImagenPokemon.setBackground(Color.LIGHT_GRAY);
		lblImagenPokemon.setBounds(483, 246, 150, 150);
		panelPrincipal.add(lblImagenPokemon);
		
		JLabel lblTituloFormatoAtaques = new JLabel("Ataque1, Ataque2, Ataque3, Ataque4");
		lblTituloFormatoAtaques.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloFormatoAtaques.setForeground(Color.WHITE);
		lblTituloFormatoAtaques.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloFormatoAtaques.setBackground(Color.LIGHT_GRAY);
		lblTituloFormatoAtaques.setBounds(20, 513, 293, 14);
		panelPrincipal.add(lblTituloFormatoAtaques);
		
		txtListaAtaque = new JTextField();
		txtListaAtaque.setBounds(20, 486, 436, 20);
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
		
		txtTipoPokemon = new JTextField();
		txtTipoPokemon.setColumns(10);
		txtTipoPokemon.setBounds(295, 430, 150, 20);
		panelPrincipal.add(txtTipoPokemon);
		
		txtDefensaEspecial = new JTextField();
		txtDefensaEspecial.setColumns(10);
		txtDefensaEspecial.setBounds(20, 430, 150, 20);
		panelPrincipal.add(txtDefensaEspecial);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(20, 262, 150, 20);
		panelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtAtaque = new JTextField();
		txtAtaque.setColumns(10);
		txtAtaque.setBounds(295, 325, 150, 20);
		panelPrincipal.add(txtAtaque);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(295, 269, 150, 20);
		panelPrincipal.add(txtId);
		
		txtVelocidad = new JTextField();
		txtVelocidad.setColumns(10);
		txtVelocidad.setBounds(295, 376, 150, 20);
		panelPrincipal.add(txtVelocidad);
		
		JLabel lblTituloTipoDePokemon = new JLabel("Tipo De Pokemon:");
		lblTituloTipoDePokemon.setBackground(new Color(192, 192, 192));
		lblTituloTipoDePokemon.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTituloTipoDePokemon.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloTipoDePokemon.setForeground(new Color(255, 255, 255));
		lblTituloTipoDePokemon.setBounds(295, 405, 161, 14);
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
		lblTituloId.setBounds(295, 244, 161, 14);
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
		lblTituloAtaque.setBounds(295, 300, 161, 14);
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
		lblTituloVelocidad.setBounds(295, 351, 161, 14);
		panelPrincipal.add(lblTituloVelocidad);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(20, 90, 293, 20);
		panelPrincipal.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		tablaPokemones = new JTable();
		tablaPokemones.setBackground(new Color(255, 255, 255));
		tablaPokemones.setToolTipText("");
		tablaPokemones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaPokemones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tablaPokemones.setBounds(20, 121, 563, 96);
		panelPrincipal.add(tablaPokemones);
		
		JLabel lbllistaPokemones = new JLabel("Lista De Pokemones:");
		lbllistaPokemones.setBackground(new Color(255, 255, 255));
		lbllistaPokemones.setVerticalTextPosition(SwingConstants.TOP);
		lbllistaPokemones.setHorizontalTextPosition(SwingConstants.CENTER);
		lbllistaPokemones.setHorizontalAlignment(SwingConstants.CENTER);
		lbllistaPokemones.setForeground(new Color(255, 255, 255));
		lbllistaPokemones.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbllistaPokemones.setBounds(10, 47, 340, 34);
		panelPrincipal.add(lbllistaPokemones);
		
		JLabel lblTutorial = new JLabel("Tutorial");
		lblTutorial.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTutorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTutorial.setForeground(new Color(255, 255, 255));
		lblTutorial.setFont(lblTutorial.getFont().deriveFont(lblTutorial.getFont().getStyle() | Font.BOLD | Font.ITALIC, lblTutorial.getFont().getSize() + 5f));
		lblTutorial.setBounds(871, 531, 198, 34);
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
		btnCrear.setBounds(83, 615, 245, 55);
		panelPrincipal.add(btnCrear);
		
		JButton btnEliminar = new JButton("Eliminar Pokemon");
		btnEliminar.setBounds(338, 615, 245, 55);
		panelPrincipal.add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar Pokemon");
		btnActualizar.setBounds(593, 615, 245, 55);
		panelPrincipal.add(btnActualizar);
		
		JButton btnSeleccionarPokemon = new JButton("SeleccionarPokemon");
		btnSeleccionarPokemon.setBounds(852, 615, 245, 55);
		panelPrincipal.add(btnSeleccionarPokemon);
		
		JLabel lblNombretipogeneracion = new JLabel("Nombre/Tipo/Generación");
		lblNombretipogeneracion.setVerticalTextPosition(SwingConstants.TOP);
		lblNombretipogeneracion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombretipogeneracion.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombretipogeneracion.setForeground(Color.WHITE);
		lblNombretipogeneracion.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNombretipogeneracion.setBounds(462, 81, 221, 34);
		panelPrincipal.add(lblNombretipogeneracion);
		
		JButton btnBuscarPokemon = new JButton("Buscar Pokemon");
		btnBuscarPokemon.setBounds(323, 83, 133, 34);
		panelPrincipal.add(btnBuscarPokemon);
		
		JButton btnSubirImagen = new JButton("Subir Imagen");
		btnSubirImagen.setBounds(493, 403, 135, 23);
		panelPrincipal.add(btnSubirImagen);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(InicioView.class.getResource("/co/edu/unbosque/view/img/scorbunny.jpg")));
		lblImg.setBounds(0, 0, 1176, 681);
		panelPrincipal.add(lblImg);
	}
}
