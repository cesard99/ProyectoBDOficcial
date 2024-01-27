package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpinnerDateModel;



import dto.CDR_DTO;
import dto.Circunscripcion_DTO;
import estruct.services.ServicesLocator;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class CreateElector extends JFrame {
	private int cantelectorAdd;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField txtfieldFecha;
	private JTextField textFieldDireccion;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox textFieldCausas;
	private JCheckBox chckbxNewCheckBox;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private ArrayList<CDR_DTO>listcdr_DTOs;
	private ArrayList<Circunscripcion_DTO>listcircunscripcion_DTOs;
	private JSpinner spinner;
	private JComboBox comboBox_2;
	private JLabel lblCircunscripcin;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Y Apellidos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 42, 158, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 67, 184, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaDeNaic = new JLabel("Fecha de Nacimiento");
		lblFechaDeNaic.setForeground(Color.WHITE);
		lblFechaDeNaic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeNaic.setBounds(22, 98, 158, 14);
		contentPane.add(lblFechaDeNaic);
		
		
		
        SpinnerDateModel model = new SpinnerDateModel();
		txtfieldFecha = new JTextField();
		txtfieldFecha.setText("dd/mm/yyyy");
		txtfieldFecha.setBounds(10, 123, 184, 20);
		contentPane.add(txtfieldFecha);
		
		
		JLabel lblNumeroConsecutivo = new JLabel("N\u00FAmero elector:");
		lblNumeroConsecutivo.setForeground(Color.WHITE);
		lblNumeroConsecutivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroConsecutivo.setBounds(10, 170, 147, 14);
		contentPane.add(lblNumeroConsecutivo);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(134, 169, 44, 20);
		contentPane.add(spinner);
		
		final JLabel lblDireccionParticular = new JLabel("Direccion Particular");
		lblDireccionParticular.setForeground(Color.WHITE);
		lblDireccionParticular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccionParticular.setBounds(22, 221, 158, 14);
		contentPane.add(lblDireccionParticular);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(10, 239, 184, 20);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		
			
		final JLabel lblIntegracionRevolucionaria = new JLabel("Integracion Revolucionaria");
		lblIntegracionRevolucionaria.setVisible(false);
		lblIntegracionRevolucionaria.setForeground(Color.WHITE);
		lblIntegracionRevolucionaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntegracionRevolucionaria.setBounds(430, 42, 184, 14);
		contentPane.add(lblIntegracionRevolucionaria);
		
		textField_3 = new JTextField();
		textField_3.setVisible(false);
		textField_3.setBounds(430, 71, 184, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		final JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setVisible(false);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(430, 98, 158, 14);
		contentPane.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setVisible(false);
		textField_4.setBounds(430, 123, 184, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		final JLabel lblOcupacion = new JLabel("Ocupacion ");
		lblOcupacion.setVisible(false);
		lblOcupacion.setForeground(Color.WHITE);
		lblOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOcupacion.setBounds(430, 154, 158, 14);
		contentPane.add(lblOcupacion);
		
		textField_5 = new JTextField();
		textField_5.setVisible(false);
		textField_5.setBounds(430, 179, 184, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		final JLabel lblProfesion = new JLabel("Profesion");
		lblProfesion.setVisible(false);
		lblProfesion.setForeground(Color.WHITE);
		lblProfesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProfesion.setBounds(430, 214, 158, 14);
		contentPane.add(lblProfesion);
		
		textField_6 = new JTextField();
		textField_6.setVisible(false);
		textField_6.setBounds(430, 239, 184, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		final JLabel lblDatosBiograficos = new JLabel("Datos Biograficos");
		lblDatosBiograficos.setVisible(false);
		lblDatosBiograficos.setForeground(Color.WHITE);
		lblDatosBiograficos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatosBiograficos.setBounds(430, 279, 158, 14);
		contentPane.add(lblDatosBiograficos);
		
		textField_7 = new JTextField();
		textField_7.setVisible(false);
		textField_7.setBounds(430, 302, 184, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblVoto = new JLabel("Voto:");
		lblVoto.setForeground(Color.WHITE);
		lblVoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVoto.setBounds(10, 271, 39, 14);
		contentPane.add(lblVoto);
		
		chckbxNewCheckBox = new JCheckBox("Voto");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxNewCheckBox.isSelected()) {
					textFieldCausas.setEnabled(true);
				}else {
					textFieldCausas.setEnabled(false);
				}
				
			}
		});
		chckbxNewCheckBox.setToolTipText("Si \r\nNo");
		chckbxNewCheckBox.setBounds(59, 266, 21, 23);
		contentPane.add(chckbxNewCheckBox);
		
		textFieldCausas = new JComboBox();
		textFieldCausas.setModel(new DefaultComboBoxModel(new String[] {"", "fallecimiento", "Extranjero", "Fuera de Provincia", "Hospitalizados", "Trabajando", "Otras Causas"}));
		textFieldCausas.setBounds(10, 328, 184, 20);
		contentPane.add(textFieldCausas);
		
		
		JLabel lblCausasDeLa = new JLabel("Causas de no voto");
		lblCausasDeLa.setForeground(Color.WHITE);
		lblCausasDeLa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCausasDeLa.setBounds(10, 307, 158, 14);
		contentPane.add(lblCausasDeLa);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("Elector")){
					lblDatosBiograficos.setVisible(false);
					lblOcupacion.setVisible(false);
					lblIntegracionRevolucionaria.setVisible(false);
					lblProfesion.setVisible(false);
					lblTelefono.setVisible(false);
					textField_3.setVisible(false);
					textField_4.setVisible(false);
					textField_5.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					comboBox_2.setVisible(false);
					lblCircunscripcin.setVisible(false);
					
				}else{
					lblDatosBiograficos.setVisible(true);
					lblOcupacion.setVisible(true);
					lblIntegracionRevolucionaria.setVisible(true);
					lblProfesion.setVisible(true);
					lblTelefono.setVisible(true);
					textField_3.setVisible(true);
					textField_4.setVisible(true);
					textField_5.setVisible(true);
					textField_6.setVisible(true);
					textField_7.setVisible(true);
					comboBox_2.setVisible(true);
					lblCircunscripcin.setVisible(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Elector", "Nominado"}));
		comboBox.setBounds(206, 11, 168, 22);
		contentPane.add(comboBox);
		if(comboBox.getSelectedItem().equals("nominado")){
			
		}
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validateFields()) {
		            crear();
		            dispose();
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos correctamente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
			
			}
		});
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
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(204, 67, 184, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblCdr = new JLabel("CDR");
		lblCdr.setForeground(Color.WHITE);
		lblCdr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCdr.setBounds(216, 42, 158, 14);
		contentPane.add(lblCdr);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(430, 358, 184, 20);
		contentPane.add(comboBox_2);
		comboBox_2.setVisible(false);
		
		lblCircunscripcin = new JLabel("Circunscripci\u00F3n");
		lblCircunscripcin.setForeground(Color.WHITE);
		lblCircunscripcin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCircunscripcin.setBounds(430, 333, 158, 14);
		contentPane.add(lblCircunscripcin);
		lblCircunscripcin.setVisible(false);
		
		llenarComboCdr();
		llenarComboCir();
		
	}
	public void crear(){
		String nameElector = textFieldNombre.getText();
		//String date=  textField_1.getText();
		
		
		String dirr= textFieldDireccion.getText();
		Boolean voto = chckbxNewCheckBox.isSelected();
		String causa = textFieldCausas.getSelectedItem().toString();
		String tipo = comboBox.getSelectedItem().toString();
		String aux = comboBox_1.getSelectedItem().toString();
		String aux1 = comboBox_2.getSelectedItem().toString();
		String codigoCDR = null;
		String codigoCIR = null;
		String numElect = spinner.getValue().toString();
		
		
		for (int i = 0; i < listcdr_DTOs.size(); i++) {
			if(aux.equalsIgnoreCase(listcdr_DTOs.get(i).getName())){
				codigoCDR =listcdr_DTOs.get(i).getCodigo();
				break;
		}}		
		for (int i = 0; i < listcircunscripcion_DTOs.size(); i++) {
			if(aux1.equalsIgnoreCase(listcircunscripcion_DTOs.get(i).getNombre())){
				codigoCIR =listcircunscripcion_DTOs.get(i).getCodigo();
				break;
		}}		
		if (tipo.equals("Elector")) {
			try {
				ServicesLocator.getElector_Services().insertElector(codigoCDR, numElect, nameElector, dirr, null);
				cantelectorAdd++;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "¡Ha ocurrido un error, llave duplicada!", "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}else if(tipo.equals("Nominado")){
			try {
				String inteRev = textField_3.getText();
				int telef = Integer.parseInt(textField_4.getText());
				String ocupa = textField_5.getText();
				String profesion = textField_6.getText();
				String biblio = textField_7.getText();
				
				ServicesLocator.getElector_Services().insertElector(codigoCDR, numElect, nameElector, dirr, null);
				ServicesLocator.getNominado_Services().insertnominado(codigoCDR, numElect, ocupa, profesion, telef, inteRev, biblio, codigoCIR);
				cantelectorAdd++;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "¡Ha ocurrido un error, llave duplicada!", "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
		}
		
		
	}
	public void llenarComboCdr(){
		try {
			listcdr_DTOs = ServicesLocator.getCDR_Services().selectAllCDr();
			for (int i = 0; i < listcdr_DTOs.size(); i++) {
				comboBox_1.addItem(listcdr_DTOs.get(i).getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void llenarComboCir(){
		try {
			listcircunscripcion_DTOs = ServicesLocator.getCircunscripcion_Services().selectAllCIR();
			for (int i = 0; i < listcircunscripcion_DTOs.size(); i++) {
				comboBox_2.addItem(listcircunscripcion_DTOs.get(i).getNombre());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean validateFields() {
		boolean bandera =false;
		 if (comboBox.getSelectedItem().toString().equals("Elector")) {
			 if(!textFieldNombre.getText().isEmpty() && 
					  esFechaValida(txtfieldFecha.getText().toString()) &&
					  spinner.getValue()!=null && 
					  !textFieldDireccion.getText().isEmpty() && 
					  verificarCheckBox()){
				 bandera=true;
			 }
			 
		 }else 
			 if(!textFieldNombre.getText().isEmpty() && 
					 !txtfieldFecha.getText().isEmpty() &&
					 spinner.getValue()!=null && 
					 !textFieldDireccion.getText().isEmpty() && 
					 verificarCheckBox()&& !textField_3.getText().isEmpty() && !textField_4.getText().isEmpty() && !textField_5.getText().isEmpty() &&
					 !textField_6.getText().isEmpty() && !textField_7.getText().isEmpty() && !comboBox_2.getSelectedItem().toString().isEmpty()) {

				 bandera =true;
			 }
		 else {
			bandera=false;
		}

	    return bandera;
	    
	}
	
	
	
	

	public boolean verificarCheckBox() {
		boolean bandera = true;
		if(chckbxNewCheckBox.isSelected())
			bandera=true;
		else 
			if(!chckbxNewCheckBox.isSelected()) {
				if(!textFieldCausas.getSelectedItem().toString().isEmpty()) {
					bandera =true;
			
			}
		}else {
			bandera=false;
		}
		
		return bandera;
	}
	
	public boolean esFechaValida(String fecha) {
		if (fecha.trim().isEmpty()) {
	        return false;
	    }

	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
	    try {
	        LocalDate.parse(fecha, formato);
	        return true;
	    } catch (DateTimeParseException e) {
	        return false;
	    }
	}
	
}
