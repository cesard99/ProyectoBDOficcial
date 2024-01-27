package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateCDR extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldNombrePresidente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCDR frame = new CreateCDR();
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
	public CreateCDR() {
		setTitle("Crear CDR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona Colegio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(226, 37, 167, 21);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxColegio = new JComboBox();
		comboBoxColegio.setBounds(221, 70, 121, 22);
		contentPane.add(comboBoxColegio);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 113, 167, 21);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(10, 145, 167, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(362, 145, 167, 20);
		contentPane.add(textFieldNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(362, 118, 167, 21);
		contentPane.add(lblNombre);
		
		JLabel lblNombrePresidente = new JLabel("Nombre Presidente");
		lblNombrePresidente.setForeground(Color.WHITE);
		lblNombrePresidente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombrePresidente.setBounds(200, 187, 167, 21);
		contentPane.add(lblNombrePresidente);
		
		textFieldNombrePresidente = new JTextField();
		textFieldNombrePresidente.setColumns(10);
		textFieldNombrePresidente.setBounds(200, 208, 167, 20);
		contentPane.add(textFieldNombrePresidente);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(0, 128, 128));
		btnAceptar.setBounds(36, 298, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(440, 298, 89, 23);
		contentPane.add(btnCancelar);
	}

}
