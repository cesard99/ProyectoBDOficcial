package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Circunscripcion_DTO;
import dto.Colegios_DTO;
import estruct.services.Colegios_Services;
import estruct.services.ServicesLocator;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateColegio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private Colegios_Services colegios_Services =ServicesLocator.getColegios_Services();
	private Colegios_DTO colegios_DTO;
	JComboBox comboBoxCircunscripcion = new JComboBox();
	private ArrayList<Circunscripcion_DTO> listCircunscripcion;
	private ArrayList<Colegios_DTO>listColegios_DTOs;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateColegio frame = new CreateColegio();
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
	public CreateColegio() {
		setTitle("Crear Colegio");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 395);
		setResizable(false);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona Circunscripcion");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(188, 27, 181, 22);
		contentPane.add(lblNewLabel);
		
		
		comboBoxCircunscripcion.setBounds(188, 60, 169, 22);
		contentPane.add(comboBoxCircunscripcion);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 132, 145, 22);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(342, 132, 145, 22);
		contentPane.add(lblNombre);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(10, 165, 169, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(318, 163, 169, 22);
		contentPane.add(textFieldNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(212, 207, 145, 22);
		contentPane.add(lblDireccin);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(188, 240, 169, 20);
		contentPane.add(textFieldDireccion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxCircunscripcion.getSelectedItem().toString().isEmpty() && !textFieldCodigo.getText().toString().isEmpty() && 
						!textFieldDireccion.getText().toString().isEmpty() && !textFieldNombre.getText().toString().isEmpty()) {
					if(!existeColegio()) {
						if(!ColegioNombre()) {
						crear();
						}else {
							JOptionPane.showMessageDialog(null, "Ya se encuentra un Colegio Electoral con ese nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "El Colegio ELectoral se encuentra en la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos correctamente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnAceptar.setBackground(new Color(0, 139, 139));
		btnAceptar.setBounds(40, 296, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(405, 296, 89, 23);
		contentPane.add(btnCancelar);
		
		
		llenarComboCirc();
	}
	
	/*-------------------------------------------------------FUNCIONALIDADES PARA VALIDAR Y CREAR----------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void crear() {
		String Codigo=textFieldCodigo.getText().toString();
		String nombre=textFieldNombre.getText().toString();
		String Direcc=textFieldDireccion.getText().toString();
		String circunsc=comboBoxCircunscripcion.getSelectedItem().toString();
		try {
			colegios_Services.insertColegioElectoral(Codigo, nombre, Direcc, circunsc);
			JOptionPane.showMessageDialog(null, "Colegio insertado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean existeColegio() {
		boolean bandera =false;
		String CodigoCole=textFieldCodigo.getText().toString();
		
		try {
			listColegios_DTOs=ServicesLocator.getColegios_Services().selectAllCol();
			for (int i = 0; i < listColegios_DTOs.size() && !bandera; i++) {
				if(listColegios_DTOs.get(i).getCodigo().equals(CodigoCole))
					bandera = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return bandera;
	}
	
	public boolean ColegioNombre() {
		boolean bandera =false;
		String nombreColegio=textFieldNombre.getText().toString();
		try {
			listColegios_DTOs=ServicesLocator.getColegios_Services().selectAllCol();
			for (int i = 0; i < listColegios_DTOs.size() && !bandera; i++) {
				if(listColegios_DTOs.get(i).getName().equals(nombreColegio))
					bandera = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return bandera;
	}
	
	public void llenarComboCirc(){
		try {
			listCircunscripcion=ServicesLocator.getCircunscripcion_Services().selectAllCIR();
			for (int i = 0; i < listCircunscripcion.size(); i++) {
				comboBoxCircunscripcion.addItem(listCircunscripcion.get(i).getNombre());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

