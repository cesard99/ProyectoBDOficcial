package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Circunscripcion_DTO;
import estruct.services.Circunscripcion_Services;
import estruct.services.ServicesLocator;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CreateCircunscripcion extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	JComboBox comboBoxMunicipio = new JComboBox();
	private Circunscripcion_Services circunscripcion_Services = ServicesLocator.getCircunscripcion_Services();
	private Circunscripcion_DTO circunscripcion_DTO;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCircunscripcion frame = new CreateCircunscripcion();
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
	public CreateCircunscripcion() {
		setTitle("Crear Circunscripcion");
		setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		comboBoxMunicipio.setBounds(190, 58, 152, 22);
		contentPane.add(comboBoxMunicipio);
		
		JLabel lblNewLabel = new JLabel("Selecciona Municipio");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(190, 33, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(20, 142, 152, 14);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(10, 161, 162, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(352, 142, 152, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(342, 161, 162, 20);
		contentPane.add(textFieldNombre);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxMunicipio.getSelectedItem().toString().isEmpty() && !textFieldCodigo.getText().toString().isEmpty() && textFieldNombre.getText().toString().isEmpty()){
					if(!existeCircunscripcion()) {
						crear();
					}else {
						JOptionPane.showMessageDialog(null, "La Circunscripción se encuentra en la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos correctamente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAceptar.setBackground(new Color(0, 128, 128));
		btnAceptar.setBounds(80, 248, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(340, 248, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblError = new JLabel("Complete todos Los campos Correctamente");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setForeground(Color.RED);
		lblError.setBounds(121, 206, 281, 14);
		contentPane.add(lblError);
		lblError.setVisible(false);
	}
	
	/*-------------------------------------------------------FUNCIONALIDADES PARA VALIDAR Y CREAR----------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void crear() {
		String municipio=comboBoxMunicipio.getSelectedItem().toString();
		String nombreCirc=textFieldNombre.getText().toString();
		String codigoCirc=textFieldCodigo.getText().toString();
		try {
			circunscripcion_Services.insertCircunscripcion(codigoCirc, nombreCirc, municipio);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public boolean existeCircunscripcion() {
		boolean bandera=false;
		int num=Integer.parseInt(textFieldCodigo.getText().toString());
		try {
			circunscripcion_DTO=circunscripcion_Services.findCir(num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bandera;
	}
}
