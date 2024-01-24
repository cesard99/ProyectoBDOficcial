package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class Parte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parte frame = new Parte();
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
	public Parte() {
		setTitle("Parte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 46, 154, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Municipio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 27, 166, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCircunscripcin = new JLabel("Circunscripci\u00F3n");
		lblCircunscripcin.setForeground(Color.WHITE);
		lblCircunscripcin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCircunscripcin.setBounds(10, 79, 166, 14);
		contentPane.add(lblCircunscripcin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 102, 154, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCdr = new JLabel("CDR");
		lblCdr.setForeground(Color.WHITE);
		lblCdr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCdr.setBounds(10, 136, 166, 14);
		contentPane.add(lblCdr);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 161, 154, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblColegioElectoral = new JLabel("Colegio Electoral");
		lblColegioElectoral.setForeground(Color.WHITE);
		lblColegioElectoral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColegioElectoral.setBounds(10, 204, 166, 14);
		contentPane.add(lblColegioElectoral);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 229, 154, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNumeroDeVuelta = new JLabel("Numero De Vuelta:");
		lblNumeroDeVuelta.setForeground(Color.WHITE);
		lblNumeroDeVuelta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDeVuelta.setBounds(10, 272, 125, 14);
		contentPane.add(lblNumeroDeVuelta);
		
		JSpinner spinnerVuelta = new JSpinner();
		spinnerVuelta.setBounds(134, 271, 42, 20);
		contentPane.add(spinnerVuelta);
		
		JLabel lblNmeroDeParte = new JLabel("N\u00FAmero De Parte:");
		lblNmeroDeParte.setForeground(Color.WHITE);
		lblNmeroDeParte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmeroDeParte.setBounds(10, 310, 125, 14);
		contentPane.add(lblNmeroDeParte);
		
		JSpinner spinnerParte = new JSpinner();
		spinnerParte.setBounds(134, 309, 42, 20);
		contentPane.add(spinnerParte);
		
		JLabel lblCantidadElectoresInicio = new JLabel("Cantidad Electores Inicio:");
		lblCantidadElectoresInicio.setForeground(Color.WHITE);
		lblCantidadElectoresInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresInicio.setBounds(353, 79, 166, 14);
		contentPane.add(lblCantidadElectoresInicio);
		
		JSpinner spinnerElectoresInicio = new JSpinner();
		spinnerElectoresInicio.setBounds(529, 78, 42, 20);
		contentPane.add(spinnerElectoresInicio);
		
		JLabel lblCantidadElectoresAgregados = new JLabel("Cantidad Electores Agregados:");
		lblCantidadElectoresAgregados.setForeground(Color.WHITE);
		lblCantidadElectoresAgregados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresAgregados.setBounds(348, 122, 207, 14);
		contentPane.add(lblCantidadElectoresAgregados);
		
		JSpinner spinnerElectoresAdd = new JSpinner();
		spinnerElectoresAdd.setBounds(554, 121, 42, 20);
		contentPane.add(spinnerElectoresAdd);
		
		JLabel lblCantidadElectoresEliminados = new JLabel("Cantidad Electores Eliminados:");
		lblCantidadElectoresEliminados.setForeground(Color.WHITE);
		lblCantidadElectoresEliminados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresEliminados.setBounds(353, 162, 207, 14);
		contentPane.add(lblCantidadElectoresEliminados);
		
		JSpinner spinnerElectoresDeleted = new JSpinner();
		spinnerElectoresDeleted.setBounds(570, 161, 42, 20);
		contentPane.add(spinnerElectoresDeleted);
		
		JLabel lblCantidadElectoresParte = new JLabel("Cantidad Electores Parte Anterior:");
		lblCantidadElectoresParte.setForeground(Color.WHITE);
		lblCantidadElectoresParte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresParte.setBounds(337, 216, 226, 14);
		contentPane.add(lblCantidadElectoresParte);
		
		JSpinner spinnerElectoresParteAnt = new JSpinner();
		spinnerElectoresParteAnt.setBounds(570, 215, 42, 20);
		contentPane.add(spinnerElectoresParteAnt);
		
		JLabel lblElectoresQueVotaron = new JLabel("Electores que Votaron por el dia:");
		lblElectoresQueVotaron.setForeground(Color.WHITE);
		lblElectoresQueVotaron.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblElectoresQueVotaron.setBounds(329, 259, 226, 14);
		contentPane.add(lblElectoresQueVotaron);
		
		JSpinner spinnerElectoresVotacionDeDia = new JSpinner();
		spinnerElectoresVotacionDeDia.setBounds(554, 258, 42, 20);
		contentPane.add(spinnerElectoresVotacionDeDia);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBounds(108, 391, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(405, 391, 89, 23);
		contentPane.add(btnCancelar);
	}

}
