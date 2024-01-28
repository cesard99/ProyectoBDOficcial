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

import dto.Circunscripcion_DTO;
import estruct.services.ServicesLocator;
import estruct.visual.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.sql.SQLException;
import java.util.ArrayList;

public class FframeC2 extends JFrame {

	private JPanel contentPane;
	private ArrayList<Circunscripcion_DTO>listCircunscripcion_DTOs;
	private JComboBox comboBox;
	private String nomCir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FframeC2 frame = new FframeC2();
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
	public FframeC2() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				Principal p = new Principal();
				p.setVisible(true);
				p.crearreporte12(nomCir, null,null);
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
				Principal p = new Principal();
				p.setVisible(true);
				dispose();
			}
		});
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(179, 95, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblCircunscripcion = new JLabel("Seleciona una Circunscripci\u00F3n");
		lblCircunscripcion.setForeground(Color.WHITE);
		lblCircunscripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCircunscripcion.setBounds(10, 11, 186, 19);
		contentPane.add(lblCircunscripcion);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(10, 36, 165, 20);
		contentPane.add(comboBox);
		
		llenarComboCir();
		
	}
	public void llenarComboCir(){
		try {
			listCircunscripcion_DTOs = ServicesLocator.getCircunscripcion_Services().selectAllCIR();
			for (int i = 0; i < listCircunscripcion_DTOs.size(); i++) {
				comboBox.addItem(listCircunscripcion_DTOs.get(i).getNombre());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getNomCir() {
		return nomCir;
	}

	public void setNomCir(String nomCir) {
		this.nomCir = nomCir;
	}

}
