package estruct.visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public Principal() {
		setTitle("Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/votacion.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 680, 22);
		contentPane.add(menuBar);
		
		JButton btnNewButton = new JButton("Parte");
		btnNewButton.setBackground(new Color(0, 153, 153));
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover ");
		btnNewButton_1.setBackground(new Color(0, 153, 153));
		menuBar.add(btnNewButton_1);
		
		JButton BtnCreateElector = new JButton("Crear Elector");
		BtnCreateElector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BtnCreateElector.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CreateElector c = new CreateElector();
				c.setVisible(true);
			
			}
		});
		BtnCreateElector.setBackground(new Color(0, 153, 153));
		menuBar.add(BtnCreateElector);
		
		JButton button = new JButton("Crear Usuario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateUser c = new CreateUser();
				c.setVisible(true);
			}
		});
		button.setBackground(new Color(0, 153, 153));
		menuBar.add(button);
		
		JButton BtnCerrarSeccion = new JButton("Cerrar Seccion ");
		menuBar.add(BtnCerrarSeccion);
		BtnCerrarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login l = new login();
				l.setVisible(true);
				dispose();
			}
		});
		BtnCerrarSeccion.setBackground(new Color(0, 153, 153));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 21, 290, 436);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabelTitulo = new JLabel("Reportes");
		lblNewLabelTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabelTitulo.setBounds(102, 14, 63, 17);
		panel.add(lblNewLabelTitulo);
		
		JButton BtnListado = new JButton("Generar");
		BtnListado.setBackground(new Color(0, 128, 128));
		BtnListado.setBounds(208, 42, 82, 23);
		panel.add(BtnListado);
		
		JLabel lblListado = new JLabel("Listado ->");
		lblListado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListado.setBounds(10, 41, 74, 23);
		panel.add(lblListado);
		
		JLabel lblResumen = new JLabel("Resumen ->");
		lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResumen.setBounds(0, 95, 74, 23);
		panel.add(lblResumen);
		
		JButton BtnResumen = new JButton("Generar");
		BtnResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BtnResumen.setBackground(new Color(0, 128, 128));
		BtnResumen.setBounds(208, 96, 82, 23);
		panel.add(BtnResumen);
		
		JComboBox comboBoxListado = new JComboBox();
		comboBoxListado.setModel(new DefaultComboBoxModel(new String[] {"Electores", "Nominados", "Municipio Mas Nominado", "Electores No Votaron", "Circunscripcion 2da Vuelta"}));
		comboBoxListado.setBounds(68, 42, 130, 22);
		panel.add(comboBoxListado);
		
		JComboBox comboBoxResumen = new JComboBox();
		comboBoxResumen.setModel(new DefaultComboBoxModel(new String[] {"Municipio", "Proceso", "Delegados Electos"}));
		comboBoxResumen.setBounds(68, 96, 130, 22);
		panel.add(comboBoxResumen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 21, 390, 436);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "CI", "Telefono", "Direccion", "Correo", "Votacion", "Cargo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(88);
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		table.getColumnModel().getColumn(5).setPreferredWidth(89);
		table.getColumnModel().getColumn(6).setPreferredWidth(89);
	}
}
