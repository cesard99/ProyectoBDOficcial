package estruct.visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPasswordField;

import dto.Registrer_DTO;

import estruct.services.Registrer_Services;
import estruct.services.ServicesLocator;
import estruct.util.Definicion;
import estruct.util.Encription;
import estruct.util.validaciones;
@SuppressWarnings("serial")
public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField textFieldUserPass;
	private JTextField textFieldUsserName;
	JLabel LblError = new JLabel("error");
	private Registrer_Services registrer_Services = ServicesLocator.getRegistrer_Services();
	private ArrayList<Registrer_DTO> listaUsuarios;
	private Registrer_DTO user;

	
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img/votacion.png")));
		setTitle("Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Verificy(); 
					
					
					
					
				
			}
		});
		btnNewButton.setBounds(247, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
				
			}
		});
		btnNewButton_1.setBounds(362, 209, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textFieldUserPass = new JPasswordField();
		textFieldUserPass.setBounds(247, 130, 202, 20);
		contentPane.add(textFieldUserPass);
		textFieldUserPass.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(247, 115, 180, 14);
		contentPane.add(lblNewLabel);
		
		textFieldUsserName = new JTextField();
		textFieldUsserName.setBounds(247, 84, 202, 20);
		contentPane.add(textFieldUsserName);
		textFieldUsserName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(247, 69, 202, 14);
		contentPane.add(lblNewLabel_1);
		LblError.setFont(new Font("Tahoma", Font.BOLD, 14));
		LblError.setForeground(Color.RED);
		
		
		LblError.setBounds(259, 161, 212, 23);
		contentPane.add(LblError);
		
		JLabel fondo = new JLabel("New label");
		fondo.setIcon(new ImageIcon(login.class.getResource("/img/peque.png")));
		fondo.setBounds(0, 0, 481, 373);
		contentPane.add(fondo);
		LblError.setVisible(false);
		
		try {
			listaUsuarios = ServicesLocator.getRegistrer_Services().selectAllUsers();
			if(listaUsuarios.size()==0)
				registrer_Services.insertUser("raul", "123","administrador", 1);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	public void Verificy() {
		boolean bandera=false;
		String nameUser=textFieldUsserName.getText();
		@SuppressWarnings("deprecation")
		String passUser=textFieldUserPass.getText();
		
		validaciones.usuario(null, nameUser, passUser);
		
		try{
			
			boolean esta = false;
			for(int i=0; i<listaUsuarios.size() && !esta; i++){
				Registrer_DTO u = listaUsuarios.get(i);
				if(u.getName().equals(nameUser)){
					String pass=Encription.decode(Definicion.SECRET_KEY_PASSWORD, u.getPss());
					if(pass.equals(passUser)){
						esta = true;
						user = u;
					}
					else{
						throw new IllegalArgumentException("La contraseña es incorrecta, rectifique");
					}
				}
			}
			if(esta){
				dispose();
				Progress p = new Progress(user.getRol(),user.getName());
				p.setVisible(true);
			}
			else
				throw new IllegalArgumentException("El usuario no existe en la base de datos");
		}
		catch(IllegalArgumentException e1){
			LblError.setVisible(true);
			textFieldUsserName.setText("");
			textFieldUserPass.setText("");
			}
		}
	}

