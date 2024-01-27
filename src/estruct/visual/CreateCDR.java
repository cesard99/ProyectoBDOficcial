package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import dto.CDR_DTO;
import estruct.services.CDR_Services;
import estruct.services.Registrer_Services;
import estruct.services.ServicesLocator;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import dto.CDR_DTO;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateCDR extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldNombrePresidente;
	JComboBox comboBoxColegio = new JComboBox();
	private CDR_Services cdr_Services = ServicesLocator.getCDR_Services();
	private CDR_DTO cdr_DTO;

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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxColegio.getSelectedItem().toString().isEmpty()&& !textFieldCodigo.getText().isEmpty()&&
						!textFieldNombre.getText().isEmpty() && !textFieldNombrePresidente.getText().isEmpty()) {
					if(!CDREncontrado()) {
					crear();
					}else {
						JOptionPane.showMessageDialog(null, "El CDR se encuentra en la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos correctamente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAceptar.setBackground(new Color(0, 128, 128));
		btnAceptar.setBounds(36, 298, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(440, 298, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	public void crear() {
		String circunscripcion=comboBoxColegio.getSelectedItem().toString();
		String nombreCDR=textFieldNombre.getText();
		String codigoCDR=textFieldCodigo.getText();
		String nombrePresi=textFieldNombrePresidente.getText();
				try {
					cdr_Services.insertCDR(codigoCDR, nombreCDR, codigoCDR, circunscripcion);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	public boolean CDREncontrado() {
		boolean bandera =false;
		String codeCDR=textFieldCodigo.getText();
		int num=Integer.parseInt(codeCDR);
		try {
			cdr_DTO=cdr_Services.findCDR(num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cdr_DTO!=null) {
			bandera=true;
		}
	    
		
		return bandera;
		
	}
	
	
	

}
