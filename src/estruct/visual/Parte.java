package estruct.visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;



import dto.CDR_DTO;
import dto.Circunscripcion_DTO;
import dto.Colegios_DTO;
import dto.Municipio_DTO;
import estruct.services.ServicesLocator;
import java.awt.Toolkit;

public class Parte extends JFrame {
	private ArrayList<Municipio_DTO> listmunicipio_DTOs;
	private ArrayList<Circunscripcion_DTO>listcircunscripcion_DTOs;
	private ArrayList<Colegios_DTO>listcolegios_DTOs;
	private ArrayList<CDR_DTO>listcdr_DTOs;
	private JPanel contentPane;
	private JComboBox comboMun;
	private JComboBox comboCir;
	private JComboBox comboCDR;
	private JComboBox comboCole;
	private JTextField textFieldfecha;
	JSpinner spinnerElectoresVotacionDeDia = new JSpinner();
	JSpinner spinnerElectoresParteAnt = new JSpinner();
	JSpinner spinnerElectoresDeleted = new JSpinner();
	JSpinner spinnerElectoresAdd = new JSpinner();
	JSpinner spinnerElectoresInicio = new JSpinner();
	JSpinner spinnerParte = new JSpinner();
	JSpinner spinnerVuelta = new JSpinner();

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Parte.class.getResource("/img/votacion.png")));
		setResizable(false);
		setTitle("Parte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 529);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboMun = new JComboBox();
		comboMun.setBounds(10, 46, 154, 20);
		contentPane.add(comboMun);
		
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
		
		comboCir = new JComboBox();
		comboCir.setBounds(10, 102, 154, 20);
		contentPane.add(comboCir);
		
		JLabel lblCdr = new JLabel("CDR");
		lblCdr.setForeground(Color.WHITE);
		lblCdr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCdr.setBounds(10, 136, 166, 14);
		contentPane.add(lblCdr);
		
		comboCDR = new JComboBox();
		comboCDR.setBounds(10, 161, 154, 20);
		contentPane.add(comboCDR);
		
		JLabel lblColegioElectoral = new JLabel("Colegio Electoral");
		lblColegioElectoral.setForeground(Color.WHITE);
		lblColegioElectoral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColegioElectoral.setBounds(10, 204, 166, 14);
		contentPane.add(lblColegioElectoral);
		
		comboCole = new JComboBox();
		comboCole.setBounds(10, 229, 154, 20);
		contentPane.add(comboCole);
		
		JLabel lblNumeroDeVuelta = new JLabel("Numero De Vuelta:");
		lblNumeroDeVuelta.setForeground(Color.WHITE);
		lblNumeroDeVuelta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDeVuelta.setBounds(10, 272, 125, 14);
		contentPane.add(lblNumeroDeVuelta);
		
		spinnerVuelta.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerVuelta.setBounds(134, 271, 42, 20);
		contentPane.add(spinnerVuelta);
		
		JLabel lblNmeroDeParte = new JLabel("N\u00FAmero De Parte:");
		lblNmeroDeParte.setForeground(Color.WHITE);
		lblNmeroDeParte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmeroDeParte.setBounds(10, 310, 125, 14);
		contentPane.add(lblNmeroDeParte);
		
		spinnerParte.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerParte.setBounds(134, 309, 42, 20);
		contentPane.add(spinnerParte);
		
		JLabel lblCantidadElectoresInicio = new JLabel("Cantidad Electores Inicio:");
		lblCantidadElectoresInicio.setForeground(Color.WHITE);
		lblCantidadElectoresInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresInicio.setBounds(276, 46, 166, 14);
		contentPane.add(lblCantidadElectoresInicio);
		
		spinnerElectoresInicio.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerElectoresInicio.setBounds(452, 46, 42, 20);
		contentPane.add(spinnerElectoresInicio);
		
		JLabel lblCantidadElectoresAgregados = new JLabel("Cantidad Electores Agregados:");
		lblCantidadElectoresAgregados.setForeground(Color.WHITE);
		lblCantidadElectoresAgregados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresAgregados.setBounds(235, 89, 207, 14);
		contentPane.add(lblCantidadElectoresAgregados);
		
		spinnerElectoresAdd.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerElectoresAdd.setBounds(452, 89, 42, 20);
		contentPane.add(spinnerElectoresAdd);
		
		JLabel lblCantidadElectoresEliminados = new JLabel("Cantidad Electores Eliminados:");
		lblCantidadElectoresEliminados.setForeground(Color.WHITE);
		lblCantidadElectoresEliminados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresEliminados.setBounds(235, 129, 207, 14);
		contentPane.add(lblCantidadElectoresEliminados);
		
		spinnerElectoresDeleted.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerElectoresDeleted.setBounds(452, 129, 42, 20);
		contentPane.add(spinnerElectoresDeleted);
		
		JLabel lblCantidadElectoresParte = new JLabel("Cantidad Electores Parte Anterior:");
		lblCantidadElectoresParte.setForeground(Color.WHITE);
		lblCantidadElectoresParte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadElectoresParte.setBounds(216, 183, 226, 14);
		contentPane.add(lblCantidadElectoresParte);
		
		spinnerElectoresParteAnt.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerElectoresParteAnt.setBounds(452, 183, 42, 20);
		contentPane.add(spinnerElectoresParteAnt);
		
		JLabel lblElectoresQueVotaron = new JLabel("Electores que Votaron por el dia:");
		lblElectoresQueVotaron.setForeground(Color.WHITE);
		lblElectoresQueVotaron.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblElectoresQueVotaron.setBounds(216, 226, 226, 14);
		contentPane.add(lblElectoresQueVotaron);
		
		
		spinnerElectoresVotacionDeDia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerElectoresVotacionDeDia.setBounds(452, 226, 42, 20);
		contentPane.add(spinnerElectoresVotacionDeDia);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarcamposllenos()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fecha = LocalDate.parse(textFieldfecha.getText(), formatter);
			     crear(fecha);
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos correctamente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(10, 456, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(407, 456, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(226, 259, 226, 14);
		contentPane.add(lblFecha);
		
		textFieldfecha = new JTextField();
		textFieldfecha.setBounds(284, 284, 185, 20);
		contentPane.add(textFieldfecha);
		textFieldfecha.setColumns(10);
		
		llenarComboMun();
		llenarComboCir();
		llenarComboCdr();
		llenarComboCOL();
	}
	public void crear(LocalDate fecha){
		String codigoMunString =listmunicipio_DTOs.get(comboMun.getSelectedIndex()).getCodigo();
		String codigoCircString=listcircunscripcion_DTOs.get(comboCir.getSelectedIndex()).getCodigo();
		String codigoCDrString=listcdr_DTOs.get(comboCDR.getSelectedIndex()).getCodigo();
		String codigoCOleString=listcolegios_DTOs.get(comboCole.getSelectedIndex()).getCodigo();
		int vuelta=(Integer)spinnerVuelta.getValue();
		int parte=(Integer)spinnerParte.getValue();
		int ElectoresInicio=(Integer)spinnerElectoresInicio.getValue();
		int ElectoresADd=(Integer)spinnerElectoresAdd.getValue();
		int ElectoresDeleted=(Integer)spinnerElectoresDeleted.getValue();
		int ElectoresParteAnterior=(Integer)spinnerElectoresParteAnt.getValue();
		int ElectoresVotaronDia=(Integer)spinnerElectoresVotacionDeDia.getValue();
		
	}
	
	
	public boolean verificarcamposllenos() {
		boolean bandera=false;
		 if(!comboCDR.getSelectedItem().toString().isEmpty() && !comboCir.getSelectedItem().toString().isEmpty() && !comboCole.getSelectedItem().toString().isEmpty() && 
				 !comboMun.getSelectedItem().toString().isEmpty()) {
			 bandera=true;
		 }
		
		return bandera;
	}
	public void llenarComboMun(){
		try {
			listmunicipio_DTOs = ServicesLocator.getMunicipio_Services().selectAllMun();
			for (int i = 0; i < listmunicipio_DTOs.size(); i++) {
				comboMun.addItem(listmunicipio_DTOs.get(i).getName());
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
				comboCir.addItem(listcircunscripcion_DTOs.get(i).getNombre());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void llenarComboCdr(){
		try {
			listcdr_DTOs = ServicesLocator.getCDR_Services().selectAllCDr();
			for (int i = 0; i < listcdr_DTOs.size(); i++) {
				comboCDR.addItem(listcdr_DTOs.get(i).getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void llenarComboCOL(){
		try {
			listcolegios_DTOs = ServicesLocator.getColegios_Services().selectAllCol();
			for (int i = 0; i < listcolegios_DTOs.size(); i++) {
				comboCole.addItem(listcolegios_DTOs.get(i).getName());
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
