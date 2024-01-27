package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateMunicipio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateMunicipio frame = new CreateMunicipio();
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
	public CreateMunicipio() {
		setTitle("Crear Municipio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(41, 58, 159, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(29, 89, 172, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(311, 58, 159, 14);
		contentPane.add(lblCodigo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(287, 89, 172, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBackground(new Color(0, 128, 128));
		btnCrear.setBounds(74, 220, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(313, 220, 89, 23);
		contentPane.add(btnCancelar);
	}
}
