package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import dto.Registrer_DTO;
import estruct.services.Registrer_Services;
import estruct.services.ServicesLocator;
import estruct.util.CreateUserTablemodel;
import estruct.util.validaciones;

public class CreateUser extends JFrame {
	private ArrayList<Registrer_DTO> listaUsuarios;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox textField_2;
	private JTable table;
	private DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
	private Registrer_Services registrer_Services = ServicesLocator.getRegistrer_Services();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
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
	public CreateUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(10, 11, 158, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 36, 184, 20);
		contentPane.add(textField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(10, 76, 158, 14);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 101, 184, 20);
		contentPane.add(textField_1);
		
		JButton button = new JButton("Crear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			crear();
			}
		});
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(10, 227, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*Principal p = new Principal();
			p.setVisible(true);*/
			dispose();
			}
		});
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(335, 227, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setForeground(Color.WHITE);
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRol.setBounds(10, 147, 158, 14);
		contentPane.add(lblRol);
		
		textField_2 = new JComboBox();
		textField_2.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario"}));
		textField_2.setEditable(true);
		textField_2.setBounds(10, 172, 134, 20);
		contentPane.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 11, 230, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		ponerUsuarios();
	}
	
	public void crear(){
		int valorDado = (int)Math.floor(Math.random()*100+5);
		String user =textField.getText();
		String pss =textField_1.getText();
		String rol =textField_2.getSelectedItem().toString();
		//Registrer_DTO u = new Registrer_DTO(user, pss, rol,valorDado);
	    try {
			ServicesLocator.getRegistrer_Services().insertUser(user, pss, rol, valorDado);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ponerUsuarios();
		}
		
	
	
	
	
	
	
	public void ponerUsuarios(){
		int pos = -1;
		CreateUserTablemodel model = new CreateUserTablemodel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
		
		try{
			listaUsuarios = new Registrer_Services().selectAllUsers();
			for(Registrer_DTO u : listaUsuarios){
				
				String[] datos = {u.getName(), u.getRol()};
				model.addRow(datos);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
