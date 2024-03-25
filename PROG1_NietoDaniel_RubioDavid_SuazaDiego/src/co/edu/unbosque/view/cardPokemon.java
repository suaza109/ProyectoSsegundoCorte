package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class cardPokemon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblAtaque4;

	public cardPokemon() {
		setBackground(new Color(255, 255, 255));
		setSize(440, 325);
		setLayout(null);
		
		JLabel lblimg = new JLabel("imagen");
		lblimg.setHorizontalTextPosition(SwingConstants.CENTER);
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblimg.setBounds(10, 11, 200, 200);
		add(lblimg);
		
		JLabel lblTituloNombre = new JLabel("Nombre:");
		lblTituloNombre.setBounds(232, 11, 46, 14);
		add(lblTituloNombre);
		
		JLabel lblNombre = new JLabel("Pikachu");
		lblNombre.setBounds(277, 11, 192, 14);
		add(lblNombre);
		
		JLabel lblTituloId = new JLabel("Id:");
		lblTituloId.setBounds(232, 37, 24, 14);
		add(lblTituloId);
		
		JLabel lblID = new JLabel("0001");
		lblID.setBounds(253, 37, 192, 14);
		add(lblID);
		
		JLabel lblTituloVida = new JLabel("Vida:");
		lblTituloVida.setBounds(232, 62, 46, 14);
		add(lblTituloVida);
		
		JLabel lblTituloAtaque = new JLabel("Ataque:");
		lblTituloAtaque.setBounds(232, 88, 46, 14);
		add(lblTituloAtaque);
		
		JLabel lblID_1 = new JLabel("50");
		lblID_1.setBounds(277, 88, 192, 14);
		add(lblID_1);
		
		JLabel lblVida = new JLabel("150");
		lblVida.setBounds(277, 62, 192, 14);
		add(lblVida);
		
		JLabel lblTituloDefensa = new JLabel("Defensa:");
		lblTituloDefensa.setBounds(232, 113, 46, 14);
		add(lblTituloDefensa);
		
		JLabel lblTituloVelocidad = new JLabel("Velocidad:");
		lblTituloVelocidad.setBounds(232, 139, 58, 14);
		add(lblTituloVelocidad);
		
		JLabel lblVelocidad = new JLabel("25");
		lblVelocidad.setBounds(297, 139, 192, 14);
		add(lblVelocidad);
		
		JLabel lblDefensa = new JLabel("40");
		lblDefensa.setBounds(287, 113, 192, 14);
		add(lblDefensa);
		
		JLabel lblTituloDefensaEspecial = new JLabel("Defensa Especial:");
		lblTituloDefensaEspecial.setBounds(232, 164, 85, 14);
		add(lblTituloDefensaEspecial);
		
		JLabel lblTituloTipoDePokemon = new JLabel("Tipo De Pokemon:");
		lblTituloTipoDePokemon.setBounds(232, 190, 97, 14);
		add(lblTituloTipoDePokemon);
		
		JLabel lblLuchador = new JLabel("Luchador");
		lblLuchador.setBounds(327, 190, 163, 14);
		add(lblLuchador);
		
		JLabel lblDefensaEspecial = new JLabel("Barrera Magica");
		lblDefensaEspecial.setBounds(327, 164, 163, 14);
		add(lblDefensaEspecial);
		
		JLabel lblTituloListaAtaques = new JLabel("Lista De Ataques:");
		lblTituloListaAtaques.setBounds(20, 222, 97, 14);
		add(lblTituloListaAtaques);
		
		JLabel lblAtaque1 = new JLabel("Ataque 1 ");
		lblAtaque1.setVerticalAlignment(SwingConstants.TOP);
		lblAtaque1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAtaque1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtaque1.setBounds(18, 241, 192, 21);
		add(lblAtaque1);
		
		JLabel lblAtaque2 = new JLabel("Ataque 2");
		lblAtaque2.setVerticalAlignment(SwingConstants.TOP);
		lblAtaque2.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAtaque2.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtaque2.setBounds(232, 241, 192, 21);
		add(lblAtaque2);
		
		JLabel lblAtaque3 = new JLabel("Ataque 3");
		lblAtaque3.setVerticalAlignment(SwingConstants.TOP);
		lblAtaque3.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAtaque3.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtaque3.setBounds(20, 273, 192, 21);
		add(lblAtaque3);
		
		lblAtaque4 = new JLabel("Ataque 4");
		lblAtaque4.setVerticalAlignment(SwingConstants.TOP);
		lblAtaque4.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAtaque4.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtaque4.setBounds(232, 273, 192, 21);
		add(lblAtaque4);

	}
}
