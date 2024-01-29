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
import dto.Colegios_DTO;
import estruct.services.CDR_Services;
import estruct.services.Registrer_Services;
import estruct.services.ServicesLocator;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CDR_DTO;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CreateCDR extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldNombrePresidente;
	JComboBox comboBoxColegio = new JComboBox();
	private ArrayList<Colegios_DTO>listColegios_DTOs;
	private ArrayList<CDR_DTO>listCdr_DTOs;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateCDR.class.getResource("/img/votacion.png")));
		setTitle("Crear CDR");
		setResizable(false);
		this.setLocationRelativeTo(null);
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
//ojo aqui estan las validaciones cuando vayas a copiar 
				if(!comboBoxColegio.getSelectedItem().toString().isEmpty()&& !textFieldCodigo.getText().isEmpty()&&
						!textFieldNombre.getText().isEmpty() && !textFieldNombrePresidente.getText().isEmpty()) {
					if(!NoMas3CDR()){//cuando copies las validaciones a las otras clases tienes que eliminar esta, esta es solo para cdr
						if(!CDREncontrado()) {
							if(!CDRnombre()){
							crear();
							dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Ya se encuentra un CDR con ese nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "El CDR se encuentra en la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "No se puede insertar un nuevo CDR: el colegio"+comboBoxColegio.getSelectedItem()+" no puede tener mas de 3 colegio", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}//cuando copies las validaciones a las otras clases tienes que eliminar esta, esta es solo para cdr
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
		
		
		llenarComboCol();
	}
	
	public void crear() {
		String colegio=listColegios_DTOs.get(comboBoxColegio.getSelectedIndex()).getCodigo();
		String nombreCDR=textFieldNombre.getText();
		String codigoCDR=textFieldCodigo.getText();
		String nombrePresi=textFieldNombrePresidente.getText();
				
		
				try {
					ServicesLocator.getCDR_Services().insertCDR(codigoCDR, nombreCDR, nombrePresi, colegio);
					JOptionPane.showMessageDialog(null, "CDR insertado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
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
		//int num=Integer.parseInt(codeCDR);
		try {
			listCdr_DTOs= ServicesLocator.getCDR_Services().selectAllCDr();
			for (int i = 0; i < listCdr_DTOs.size() && !bandera; i++) {
				if(listCdr_DTOs.get(i).getCodigo().equals(codeCDR))
					bandera = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return bandera;
	}
	
	
	public boolean CDRnombre() {
		boolean bandera =false;
		String nombreCDR=textFieldNombre.getText();
		//int num=Integer.parseInt(codeCDR);
		try {
			listCdr_DTOs= ServicesLocator.getCDR_Services().selectAllCDr();
			for (int i = 0; i < listCdr_DTOs.size() && !bandera; i++) {
				if(listCdr_DTOs.get(i).getName().equals(nombreCDR))
					bandera = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return bandera;
		
	}
	public boolean NoMas3CDR() {
		String colegio=listColegios_DTOs.get(comboBoxColegio.getSelectedIndex()).getCodigo();
		boolean bandera =false;
		int cantCDR = 0;
		String codeCDR=textFieldCodigo.getText();
		//int num=Integer.parseInt(codeCDR);
		try {
			listCdr_DTOs= ServicesLocator.getCDR_Services().selectAllCDr();
			for (int i = 0; i < listCdr_DTOs.size() && !bandera; i++) {
				if(listCdr_DTOs.get(i).getCodigoCole().equals(colegio))
					cantCDR++;
					
			}if(cantCDR==3)
				bandera = true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return bandera;
		
	}
	public void llenarComboCol(){
		try {
			listColegios_DTOs = ServicesLocator.getColegios_Services().selectAllCol();
			for (int i = 0; i < listColegios_DTOs.size(); i++) {
				comboBoxColegio.addItem(listColegios_DTOs.get(i).getName());
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
