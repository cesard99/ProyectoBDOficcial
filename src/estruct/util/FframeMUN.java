package estruct.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;

import dto.CDR_DTO;
import dto.Circunscripcion_DTO;
import dto.Municipio_DTO;
import estruct.services.ServicesLocator;
import estruct.visual.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.sql.SQLException;
import java.util.ArrayList;

public class FframeMUN extends JFrame {

	private JPanel contentPane;
	private ArrayList<Municipio_DTO>listMunicipio_DTOs;
	private JComboBox comboBox;
	private String nomCir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FframeMUN frame = new FframeMUN(null,null);
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
	public FframeMUN(String rol,String name) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 284, 162);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setNomCir(comboBox.getSelectedItem().toString());
			try {
				//ServicesLocator.getAux_services().insertAux(nomCir);
				Principal p = new Principal(rol,name);
				p.setVisible(true);
				p.crearreporte12(null, null, nomCir);
				dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			}
		});
		btnAceptar.setBackground(new Color(0, 128, 128));
		btnAceptar.setBounds(10, 95, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal p = new Principal(rol,name);
				p.setVisible(true);
				dispose();
			}
		});
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(179, 95, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblCircunscripcion = new JLabel("Seleciona un Municipio");
		lblCircunscripcion.setForeground(Color.WHITE);
		lblCircunscripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCircunscripcion.setBounds(10, 11, 186, 19);
		contentPane.add(lblCircunscripcion);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(10, 36, 165, 20);
		contentPane.add(comboBox);
		
		llenarComboMun();
		
	}

	public String getNomCir() {
		return nomCir;
	}

	public void setNomCir(String nomCir) {
		this.nomCir = nomCir;
	}
	public void llenarComboMun(){
		try {
			listMunicipio_DTOs = ServicesLocator.getMunicipio_Services().selectAllMun();
			for (int i = 0; i < listMunicipio_DTOs.size(); i++) {
				comboBox.addItem(listMunicipio_DTOs.get(i).getName());
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
