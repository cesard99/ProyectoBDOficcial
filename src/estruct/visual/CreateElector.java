package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class CreateElector extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JSpinner textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox textField_8;

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
		lblNewLabel.setBounds(22, 42, 158, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 67, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaDeNaic = new JLabel("Fecha de Nacimiento");
		lblFechaDeNaic.setForeground(Color.WHITE);
		lblFechaDeNaic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeNaic.setBounds(22, 98, 158, 14);
		contentPane.add(lblFechaDeNaic);
		
		
		
        SpinnerDateModel model = new SpinnerDateModel();
		textField_1 = new JSpinner(model);
		//textField_1.setModel(new SpinnerDateModel(new Date(1706072400000L), null, new Date(1706072400000L), Calendar.DAY_OF_YEAR));
		textField_1.setEditor(new JSpinner.DateEditor(textField_1, "dd/MM/yyyy"));
		textField_1.setBounds(10, 123, 184, 20);
		contentPane.add(textField_1);
		
		
		
		/*
public class FechaNacimientoSpinner extends JFrame {
    public FechaNacimientoSpinner() {
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        
        // Obtener la fecha actual
        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();
        
        // Restar 17 años a la fecha actual
        calendar.add(Calendar.YEAR, -17);
        Date fechaLimite = calendar.getTime();
        
        // Configurar el mínimo y máximo de la fecha permitida
        model.setStart(fechaLimite);
        model.setEnd(fechaActual);
        
        // Configurar el formato de la fecha
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
        
        // Añadir el JSpinner al JFrame
        add(spinner);
        
        // Configurar la ventana
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FechaNacimientoSpinner();
    }
}
*/
		
		JLabel lblNumeroConsecutivo = new JLabel("N\u00FAmero Consecutivo:");
		lblNumeroConsecutivo.setForeground(Color.WHITE);
		lblNumeroConsecutivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroConsecutivo.setBounds(10, 170, 147, 14);
		contentPane.add(lblNumeroConsecutivo);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(153, 169, 44, 20);
		contentPane.add(spinner);
		
		final JLabel lblDireccionParticular = new JLabel("Direccion Particular");
		lblDireccionParticular.setForeground(Color.WHITE);
		lblDireccionParticular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccionParticular.setBounds(22, 221, 158, 14);
		contentPane.add(lblDireccionParticular);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 239, 184, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
			
		final JLabel lblIntegracionRevolucionaria = new JLabel("Integracion Revolucionaria");
		lblIntegracionRevolucionaria.setVisible(false);
		lblIntegracionRevolucionaria.setForeground(Color.WHITE);
		lblIntegracionRevolucionaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntegracionRevolucionaria.setBounds(430, 68, 184, 14);
		contentPane.add(lblIntegracionRevolucionaria);
		
		textField_3 = new JTextField();
		textField_3.setVisible(false);
		textField_3.setBounds(430, 97, 184, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		final JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setVisible(false);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(430, 124, 158, 14);
		contentPane.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setVisible(false);
		textField_4.setBounds(430, 149, 184, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		final JLabel lblOcupacion = new JLabel("Ocupacion ");
		lblOcupacion.setVisible(false);
		lblOcupacion.setForeground(Color.WHITE);
		lblOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOcupacion.setBounds(430, 180, 158, 14);
		contentPane.add(lblOcupacion);
		
		textField_5 = new JTextField();
		textField_5.setVisible(false);
		textField_5.setBounds(430, 205, 184, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		final JLabel lblProfesion = new JLabel("Profesion");
		lblProfesion.setVisible(false);
		lblProfesion.setForeground(Color.WHITE);
		lblProfesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProfesion.setBounds(430, 240, 158, 14);
		contentPane.add(lblProfesion);
		
		textField_6 = new JTextField();
		textField_6.setVisible(false);
		textField_6.setBounds(430, 265, 184, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		final JLabel lblDatosBiograficos = new JLabel("Datos Biograficos");
		lblDatosBiograficos.setVisible(false);
		lblDatosBiograficos.setForeground(Color.WHITE);
		lblDatosBiograficos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatosBiograficos.setBounds(430, 305, 158, 14);
		contentPane.add(lblDatosBiograficos);
		
		textField_7 = new JTextField();
		textField_7.setVisible(false);
		textField_7.setBounds(430, 328, 184, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblVoto = new JLabel("Voto:");
		lblVoto.setForeground(Color.WHITE);
		lblVoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVoto.setBounds(10, 271, 39, 14);
		contentPane.add(lblVoto);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Voto");
		chckbxNewCheckBox.setToolTipText("Si \r\nNo");
		chckbxNewCheckBox.setBounds(59, 266, 21, 23);
		contentPane.add(chckbxNewCheckBox);
		
		textField_8 = new JComboBox();
		textField_8.setModel(new DefaultComboBoxModel(new String[] {"", "fallecimiento", "Extranjero", "Fuera de Provincia", "Hospitalizados", "Trabajando", "Otras Causas"}));
		textField_8.setBounds(10, 328, 184, 20);
		contentPane.add(textField_8);
		
		JLabel lblCausasDeLa = new JLabel("Causas de no voto");
		lblCausasDeLa.setForeground(Color.WHITE);
		lblCausasDeLa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCausasDeLa.setBounds(10, 307, 158, 14);
		contentPane.add(lblCausasDeLa);
		
		final JComboBox comboBox = new JComboBox();
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
			crear();
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
		
	}
	public void crear(){
		String nameElector = textField.getText();
		//String
		
		
		
	}
}
