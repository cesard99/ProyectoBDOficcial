package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Municipio_DTO;
import estruct.services.Municipio_Services;
import estruct.services.ServicesLocator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateMunicipio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCodigo;
	private Municipio_Services municipio_Services=ServicesLocator.getMunicipio_Services();
	private Municipio_DTO municipio_DTO;
	private ArrayList<Municipio_DTO>listaMunicipio_DTOs;

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
		this.setLocationRelativeTo(null);
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(41, 58, 159, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(29, 89, 172, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(311, 58, 159, 14);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(287, 89, 172, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(!textFieldCodigo.getText().toString().isEmpty() && !textFieldNombre.getText().toString().isEmpty()) {
				if(!existeMunicipio()) {
					if(!MunicipioNombre()) {
					crear();
					}else {
						JOptionPane.showMessageDialog(null, "Ya se encuentra un Municipio con ese nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "El Municipio se encuentra en la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos correctamente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			}
		});
		btnCrear.setBackground(new Color(0, 128, 128));
		btnCrear.setBounds(74, 220, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(313, 220, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	/*-------------------------------------------------------FUNCIONALIDADES PARA VALIDAR Y CREAR----------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void crear() {
		String codigoString =textFieldCodigo.getText().toString();
		String nombreString=textFieldNombre.getText().toString();
		try {
			municipio_Services.insertMunicipio(codigoString, nombreString);
			JOptionPane.showMessageDialog(null, "Municipio insertado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean existeMunicipio() {
		boolean bandera =false;
		String municipioCode=textFieldCodigo.getText();
		
		try {
			listaMunicipio_DTOs=municipio_Services.selectAllMun();
			for (int i = 0; i < listaMunicipio_DTOs.size() && !bandera; i++) {
				if(listaMunicipio_DTOs.get(i).getCodigo().equals(municipioCode))
					bandera = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(municipio_DTO!=null) {
			bandera=true;
		}
	    
		
		return bandera;
	}
	
	public boolean MunicipioNombre() {
		boolean bandera=false;
		String nombreMunicpio=textFieldNombre.getText();
		try {
			listaMunicipio_DTOs=municipio_Services.selectAllMun();
			for (int i = 0; i < listaMunicipio_DTOs.size() && !bandera; i++) {
				if(listaMunicipio_DTOs.get(i).getName().equals(nombreMunicpio))
					bandera = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bandera;
	}
	
}
