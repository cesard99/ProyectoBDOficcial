package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateElector extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateElector frame = new CreateElector();
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
	public CreateElector() {
		setTitle("CreateUser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Y Apellidos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 42, 158, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 67, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaDeNaic = new JLabel("Fecha de Nacimiento");
		lblFechaDeNaic.setForeground(Color.WHITE);
		lblFechaDeNaic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeNaic.setBounds(22, 98, 158, 14);
		contentPane.add(lblFechaDeNaic);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 123, 184, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumeroConsecutivo = new JLabel("N\u00FAmero Consecutivo:");
		lblNumeroConsecutivo.setForeground(Color.WHITE);
		lblNumeroConsecutivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroConsecutivo.setBounds(10, 170, 147, 14);
		contentPane.add(lblNumeroConsecutivo);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner.setBounds(167, 169, 30, 20);
		contentPane.add(spinner);
		
		JLabel lblDireccionParticular = new JLabel("Direccion Particular");
		lblDireccionParticular.setForeground(Color.WHITE);
		lblDireccionParticular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccionParticular.setBounds(22, 221, 158, 14);
		contentPane.add(lblDireccionParticular);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 239, 184, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Elector", "Nominado"}));
		comboBox.setBounds(206, 11, 168, 22);
		contentPane.add(comboBox);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdad.setBounds(456, 42, 65, 14);
		contentPane.add(lblEdad);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(531, 41, 39, 20);
		contentPane.add(spinner_1);
		
		JLabel lblIntegracionRevolucionaria = new JLabel("Integracion Revolucionaria");
		lblIntegracionRevolucionaria.setForeground(Color.WHITE);
		lblIntegracionRevolucionaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntegracionRevolucionaria.setBounds(430, 68, 184, 14);
		contentPane.add(lblIntegracionRevolucionaria);
		
		textField_3 = new JTextField();
		textField_3.setBounds(430, 97, 184, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(430, 124, 158, 14);
		contentPane.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setBounds(430, 149, 184, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblOcupacion = new JLabel("Ocupacion ");
		lblOcupacion.setForeground(Color.WHITE);
		lblOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOcupacion.setBounds(430, 180, 158, 14);
		contentPane.add(lblOcupacion);
		
		textField_5 = new JTextField();
		textField_5.setBounds(430, 205, 184, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblProfesion = new JLabel("Profesion");
		lblProfesion.setForeground(Color.WHITE);
		lblProfesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProfesion.setBounds(430, 240, 158, 14);
		contentPane.add(lblProfesion);
		
		textField_6 = new JTextField();
		textField_6.setBounds(430, 265, 184, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDatosBiograficos = new JLabel("Datos Biograficos");
		lblDatosBiograficos.setForeground(Color.WHITE);
		lblDatosBiograficos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatosBiograficos.setBounds(430, 305, 158, 14);
		contentPane.add(lblDatosBiograficos);
		
		textField_7 = new JTextField();
		textField_7.setBounds(435, 328, 179, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblVoto = new JLabel("Voto:");
		lblVoto.setForeground(Color.WHITE);
		lblVoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVoto.setBounds(10, 271, 39, 14);
		contentPane.add(lblVoto);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Voto");
		chckbxNewCheckBox.setToolTipText("Si \r\nNo");
		chckbxNewCheckBox.setBounds(59, 266, 21, 23);
		contentPane.add(chckbxNewCheckBox);
		
		textField_8 = new JTextField();
		textField_8.setBounds(10, 328, 184, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblCausasDeLa = new JLabel("Causas De la votacion");
		lblCausasDeLa.setForeground(Color.WHITE);
		lblCausasDeLa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCausasDeLa.setBounds(10, 307, 158, 14);
		contentPane.add(lblCausasDeLa);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(91, 415, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
				btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(415, 415, 89, 23);
		contentPane.add(btnCancelar);
	}
}
