package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * La clase CardPokemon se utiliza para la muestra de la vewntana que contiene
 * la carta del pokemon que seleccionamos. Incluye sus diferentes
 * caracteristicas y atributos.
 */
public class CardPokemon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblVida;
	private JLabel lblimg;
	private JLabel lblGeneracion;
	private JLabel lblListaAtaques;
	private JLabel lblDefensa;
	private JLabel lblAtaque;
	private JLabel lblTipoDePokemon;
	private JLabel lblNombre;
	private JLabel lblID;
	private JLabel lblVelocidad;
	private JLabel lblDefensaEspecial;

	/**
	 * Constructor por defecto de CardPokemon que crea y muestra las diferentes
	 * partes de la vista de la carta.
	 */
	public CardPokemon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 364);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CardPokemon.class.getResource("/co/edu/unbosque/view/img/Icono.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTituloListaAtaques = new JLabel("Lista De Ataques:");
		lblTituloListaAtaques.setBounds(20, 222, 202, 14);
		contentPane.add(lblTituloListaAtaques);

		JLabel lblGeneracion_1 = new JLabel("Generacion:");
		lblGeneracion_1.setBounds(232, 215, 78, 14);
		contentPane.add(lblGeneracion_1);

		JLabel lblTituloTipoDePokemon = new JLabel("Tipo De Pokemon:");
		lblTituloTipoDePokemon.setBounds(232, 190, 133, 14);
		contentPane.add(lblTituloTipoDePokemon);

		JLabel lblTituloDefensaEspecial = new JLabel("Defensa Especial:");
		lblTituloDefensaEspecial.setBounds(232, 164, 133, 14);
		contentPane.add(lblTituloDefensaEspecial);

		JLabel lblTituloVelocidad = new JLabel("Velocidad:");
		lblTituloVelocidad.setBounds(232, 139, 133, 14);
		contentPane.add(lblTituloVelocidad);

		JLabel lblTituloDefensa = new JLabel("Defensa:");
		lblTituloDefensa.setBounds(232, 113, 133, 14);
		contentPane.add(lblTituloDefensa);

		JLabel lblTituloAtaque = new JLabel("Ataque:");
		lblTituloAtaque.setBounds(232, 88, 133, 14);
		contentPane.add(lblTituloAtaque);

		JLabel lblTituloVida = new JLabel("Vida:");
		lblTituloVida.setBounds(232, 62, 133, 14);
		contentPane.add(lblTituloVida);

		JLabel lblTituloId = new JLabel("Id:");
		lblTituloId.setBounds(232, 37, 133, 14);
		contentPane.add(lblTituloId);

		JLabel lblTituloNombre = new JLabel("Nombre:");
		lblTituloNombre.setBounds(232, 11, 133, 14);
		contentPane.add(lblTituloNombre);

		lblVida = new JLabel("healt");
		lblVida.setBounds(375, 62, 192, 14);
		contentPane.add(lblVida);

		lblimg = new JLabel("");
		lblimg.setHorizontalTextPosition(SwingConstants.CENTER);
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblimg.setBounds(10, 11, 200, 200);
		contentPane.add(lblimg);

		lblGeneracion = new JLabel("generation");
		lblGeneracion.setBounds(375, 215, 97, 14);
		contentPane.add(lblGeneracion);

		lblListaAtaques = new JLabel("List Atack");
		lblListaAtaques.setVerticalAlignment(SwingConstants.TOP);
		lblListaAtaques.setHorizontalTextPosition(SwingConstants.LEFT);
		lblListaAtaques.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaAtaques.setBounds(18, 241, 465, 73);
		contentPane.add(lblListaAtaques);

		lblDefensa = new JLabel("defense");
		lblDefensa.setBounds(375, 113, 192, 14);
		contentPane.add(lblDefensa);

		lblAtaque = new JLabel("atack");
		lblAtaque.setBounds(375, 88, 192, 14);
		contentPane.add(lblAtaque);

		lblTipoDePokemon = new JLabel("type");
		lblTipoDePokemon.setBounds(375, 190, 163, 14);
		contentPane.add(lblTipoDePokemon);

		lblNombre = new JLabel("name");
		lblNombre.setBounds(375, 11, 192, 14);
		contentPane.add(lblNombre);

		lblID = new JLabel("id");
		lblID.setBounds(375, 37, 192, 14);
		contentPane.add(lblID);

		lblVelocidad = new JLabel("sprint");
		lblVelocidad.setBounds(375, 139, 192, 14);
		contentPane.add(lblVelocidad);

		lblDefensaEspecial = new JLabel("defense special");
		lblDefensaEspecial.setBounds(375, 164, 163, 14);
		contentPane.add(lblDefensaEspecial);

	}

	/**
	 * Metodo llenar card que se utiliza para mostrar completamente la carta del
	 * pokemon que se selecciono.
	 * 
	 * @param nombre       es el nombre del pokemon.
	 * 
	 * @param tipoPokemon  es el tipo de pokemon.
	 * 
	 * @param generacion   es la genercion del pokemon.
	 * 
	 * @param id           es el id del pokemon.
	 * 
	 * @param vida         es la vida del pokemon.
	 * 
	 * @param ataque       es el ataque del pokemon.
	 * 
	 * @param defensa      es la defensa del pokemon.
	 * 
	 * @param velocidad    es la velocidad del pokemon
	 * 
	 * @param listaAtaques es la lista de ataques del pokemon.
	 * 
	 * @param DefensaEsp   es la defensa especial del pokemon.
	 * 
	 * @param foto         es la foto del pokemon.
	 */
	public void llenarCard(String nombre, String tipoPokemon, int generacion, int id, int vida, int ataque, int defensa,
			int velocidad, String listaAtaques, String DefensaEsp, String foto) {

		lblNombre.setText(nombre);
		lblTipoDePokemon.setText(tipoPokemon);
		lblGeneracion.setText(String.valueOf(generacion));
		lblID.setText(String.valueOf(id));
		lblVida.setText(String.valueOf(vida));
		lblAtaque.setText(String.valueOf(ataque));
		lblDefensa.setText(String.valueOf(defensa));
		lblVelocidad.setText(String.valueOf(velocidad));
		lblListaAtaques.setText(listaAtaques);
		lblDefensaEspecial.setText(DefensaEsp);

		ImageIcon icono = new ImageIcon(foto);
		Image imagen = icono.getImage();
		int ancho = lblimg.getWidth();
		int alto = lblimg.getHeight();
		Image imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);

		// Establecer la imagen escalada en el JLabel
		lblimg.setIcon(new ImageIcon(imagenEscalada));

	}

}
