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
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 290, 436);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Cesar Escalona\\Videos\\ProyectoBD\\src\\img\\bandera.png"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 341, 22);
		contentPane.add(menuBar);
		
		JButton btnNewButton = new JButton("Parte");
		btnNewButton.setBackground(Color.CYAN);
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover ");
		btnNewButton_1.setBackground(Color.CYAN);
		menuBar.add(btnNewButton_1);
		
		JButton BtnCreateUser = new JButton("Crear Usuario");
		BtnCreateUser.setBackground(Color.CYAN);
		menuBar.add(BtnCreateUser);
		
		JButton BtnCerrarSeccion = new JButton("Cerrar Seccion ");
		BtnCerrarSeccion.setBackground(Color.CYAN);
		menuBar.add(BtnCerrarSeccion);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(663, 0, 17, 457);
		contentPane.add(scrollBar);
		
		table = new JTable();
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
		table.setBounds(291, 21, 389, 436);
		contentPane.add(table);
	}
}
