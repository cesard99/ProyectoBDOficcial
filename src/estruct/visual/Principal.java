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

import dto.Aux_DTO;
import dto.CDR_DTO;
import dto.Circunscripcion_DTO;
import dto.Colegios_DTO;
import dto.Elector_DTO;
import dto.Municipio_DTO;
import dto.Nominado_DTO;
import dto.Registrer_DTO;
import dto.Reporte1;
import dto.Votacion_DTO;
import estruct.services.Municipio_Services;
import estruct.services.Registrer_Services;
import estruct.services.Reportes_Services;
import estruct.services.ServicesLocator;
import estruct.util.CreateCdrTablemodel;
import estruct.util.CreateCirTablemodel;
import estruct.util.CreateColegioTablemodel;
import estruct.util.CreateElectTablemodel;
import estruct.util.CreateMunicipioTablemodel;
import estruct.util.CreateNominadoTablemodel;
import estruct.util.CreateUserTablemodel;
import estruct.util.FframeC;
import estruct.util.FframeCDR;
import estruct.util.createReporte1Tablemodel;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ListSelectionModel;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	private ArrayList<Aux_DTO>listaAux_DTOs;
	private ArrayList<Votacion_DTO>listvoVotacion_DTOs;
	private ArrayList<Elector_DTO>listadoElectores;
	private ArrayList<Nominado_DTO>listNominado_DTOs;
	private ArrayList<CDR_DTO>listCdr_DTOs;
	private ArrayList<Circunscripcion_DTO>listCircunscripcion_DTOs;
	private ArrayList<Colegios_DTO>listColegios_DTOs;
	private ArrayList<Municipio_DTO> listMunicipio;
	private ArrayList<Reporte1>Listreporte1s;
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBoxListado;
	private JComboBox comboBoxResumen;
	private int selectedRow = -1;
	private String nombrecdr;
	private String nombrecir;
	
	private JComboBox comboBoxAgre;

	
	public Principal() {
		setResizable(false);
		setTitle("Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/votacion.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 940, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 923, 22);
		contentPane.add(menuBar);
		
		JButton btnNewButton = new JButton("Parte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Parte ventanaParte = new Parte();
				ventanaParte.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 153, 153));
		menuBar.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Remover ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale locale = new Locale("es","ES");
				JOptionPane.setDefaultLocale(locale);

				int result = JOptionPane.showConfirmDialog(null,"�Seguro que desea eliminar la fila seleccionado?", "Eliminar ",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
					table.remove(selectedRow);
					
				};
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 153));
		menuBar.add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
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
		
		JButton btnCrearMunic = new JButton("Crear Municipio");
		btnCrearMunic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateMunicipio ventanCreateMunicipio =new CreateMunicipio();
				ventanCreateMunicipio.setVisible(true);
			}
		});
		btnCrearMunic.setBackground(new Color(0, 128, 128));
		menuBar.add(btnCrearMunic);
		
		JButton btnCrearCircrunscripcion = new JButton("Crear Circunpcion\r\n");
		btnCrearCircrunscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCircunscripcion ventanaCircunscripcion=new CreateCircunscripcion();
				ventanaCircunscripcion.setVisible(true);
			}
			
		});
		btnCrearCircrunscripcion.setBackground(new Color(0, 128, 128));
		menuBar.add(btnCrearCircrunscripcion);
		
		JButton btnNewButton_4 = new JButton("Crear Colegio");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateColegio ventanaColegio =new CreateColegio();
				ventanaColegio.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(0, 128, 128));
		menuBar.add(btnNewButton_4);
		
		JButton btnCrearCDR = new JButton("Crear CDR");
		btnCrearCDR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCDR ventanaCdr = new CreateCDR();
				ventanaCdr.setVisible(true);
			}
		});
		btnCrearCDR.setBackground(new Color(0, 128, 128));
		menuBar.add(btnCrearCDR);
		
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
		BtnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			crearListado();
			}
		});
		BtnListado.setBackground(new Color(0, 128, 128));
		BtnListado.setBounds(208, 42, 82, 23);
		panel.add(BtnListado);
		
		JLabel lblListado = new JLabel("Listado:");
		lblListado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListado.setBounds(10, 44, 45, 16);
		panel.add(lblListado);
		
		JLabel lblResumen = new JLabel("Resumen:");
		lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResumen.setBounds(10, 111, 58, 16);
		panel.add(lblResumen);
		
		JButton BtnResumen = new JButton("Generar");
		BtnResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		BtnResumen.setBackground(new Color(0, 128, 128));
		BtnResumen.setBounds(208, 109, 82, 23);
		panel.add(BtnResumen);
		//setVisible(false);

		comboBoxListado = new JComboBox();
		comboBoxListado = new JComboBox();
		comboBoxListado.setModel(new DefaultComboBoxModel(new String[] {"Municipio","Circunscripcion", "Colegio Electoral", "CDR", "Electores", "Nominados"}));

		comboBoxListado.setBounds(68, 42, 130, 22);
		panel.add(comboBoxListado);
		
		comboBoxResumen = new JComboBox();
		comboBoxResumen.setModel(new DefaultComboBoxModel(new String[] {"Municipio", "Proceso", "Delegados Electos"}));
		comboBoxResumen.setBounds(68, 109, 130, 22);
		panel.add(comboBoxResumen);
		
		comboBoxAgre = new JComboBox();
	
			
		comboBoxAgre.setModel(new DefaultComboBoxModel(new String[] {"Una Circunscripcion", "Un CDR", "Todas Las Circunscripciones"}));
		comboBoxAgre.setBounds(68, 76, 130, 22);
		comboBoxAgre.setVisible(true);
		panel.add(comboBoxAgre);
		
		
		
		JButton button = new JButton("Generar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String r=comboBoxAgre.getSelectedItem().toString();
				if(r.equalsIgnoreCase("Todas Las Circunscripciones")){
					crearreporte1(null,null);
				}else if(r.equalsIgnoreCase("Una Circunscripcion")){
					FframeC f = new FframeC();
					f.setVisible(true);
					dispose();
				}else if(r.equalsIgnoreCase("Un CDR")){
					FframeCDR f = new FframeCDR();
					f.setVisible(true);
					dispose();
					
				}
			}
		});
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(208, 76, 82, 23);
		panel.add(button);
		
		JLabel lblReporte = new JLabel("Reporte1:");
		lblReporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReporte.setBounds(10, 78, 57, 16);
		panel.add(lblReporte);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 21, 634, 436);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				btnNewButton_1.setEnabled(true);
			}
		});
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
	
/*--------------------------------------------------------------------------------------------------------------------------------------------------------
 --------------------------------------------------------------------Funciones para mostrar y controlar -------------------------------------------------- 
 ---------------------------------------------------------------------------------------------------------------------------------------------------------*/
		public void MostrarResumen() {
			
			String Resumen=comboBoxResumen.getSelectedItem().toString();
			CreateUserTablemodel model = new CreateUserTablemodel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table.setModel(model);
			if(Resumen.equals("Municipio")) {
				try{
					listMunicipio= new Municipio_Services().selectAllMun();
					for(Municipio_DTO m  :listMunicipio){
						
						String[] datos = {};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				
			}
				
			
			
		}
		
///////////////////////////////////////////////////////////////////////////////////////////////////
		public void crearListado(){
			String list=comboBoxListado.getSelectedItem().toString();
			DefaultTableModel model = null;/*new createReporte1Tablemodel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};*/
			//table.setModel(model);
			if(list.equals("Municipio")) {
				try{
					model = new CreateMunicipioTablemodel(){
						private static final long serialVersionUID = 1L;
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					table.setModel(model);
					listMunicipio= ServicesLocator.getMunicipio_Services().selectAllMun();
					for(Municipio_DTO m  :listMunicipio){
						
						String[] datos = {m.getName(),m.getCodigo()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(list.equals("Colegio Electoral")) {
				try{
					model = new CreateColegioTablemodel(){
						private static final long serialVersionUID = 1L;
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					table.setModel(model);
					listColegios_DTOs= ServicesLocator.getColegios_Services().selectAllCol();
					for(Colegios_DTO m  :listColegios_DTOs){
						
						String[] datos = {m.getName(),m.getCodigo(),m.getDireccion(),m.getCirunscrp()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(list.equals("CDR")) {
				try{
					model = new CreateCdrTablemodel(){
						private static final long serialVersionUID = 1L;
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					table.setModel(model);
					listCdr_DTOs= ServicesLocator.getCDR_Services().selectAllCDr();
					for(CDR_DTO m  :listCdr_DTOs){
						
						String[] datos = {m.getName(),m.getCodigo(),m.getPresidentName(),m.getCodigoCole()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(list.equals("Circunscripcion")) {
				try{
					model = new CreateCirTablemodel(){
						private static final long serialVersionUID = 1L;
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					table.setModel(model);
					listCircunscripcion_DTOs= ServicesLocator.getCircunscripcion_Services().selectAllCIR();
					for(Circunscripcion_DTO m  :listCircunscripcion_DTOs){
						
						String[] datos = {m.getNombre(),m.getCodigo(),m.getCodmunicipio()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(list.equals("Electores")) {
				try{
					model = new CreateElectTablemodel(){
						private static final long serialVersionUID = 1L;
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					table.setModel(model);
					listadoElectores= ServicesLocator.getElector_Services().selectAllElect();
					for(Elector_DTO m  :listadoElectores){
						buscarvoto(m);
						String[] datos = {m.getNombreApellido(),m.getNumConsc(),m.getCodCDR(),m.getDireccion(),m.getFechaNacimiento(),m.getVoto(),m.getCausa()};
						model.addRow(datos);
					}				
				
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(list.equals("Nominados")) {
				try{
					model = new CreateNominadoTablemodel(){
						private static final long serialVersionUID = 1L;
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					table.setModel(model);
					Boolean flag = false;
					listNominado_DTOs= ServicesLocator.getNominado_Services().selectAllNom();
					listadoElectores= ServicesLocator.getElector_Services().selectAllElect();
					for(Nominado_DTO m  :listNominado_DTOs){
						String voto = null;
						String causa = null;
						String nom = null;
						for (int i = 0; i < listadoElectores.size() && !flag; i++) {
							Elector_DTO e= listadoElectores.get(i);
							if((e.getNumConsc().equalsIgnoreCase(m.getNumConsc()) && e.getCodCDR().equalsIgnoreCase(m.getCodCDR()))){
							buscarvoto(e);
							 voto = e.getVoto();
							 causa = e.getCausa();
							 nom = e.getNombreApellido();
							flag=true;
							}
						}
						flag=false;
						//String telef= m.getNumeroTelef1();
						String[] datos = {nom,m.getNumConsc(),m.getCodCDR(),m.getOcupacion(),m.getProfesion(),Integer.toString(m.getNumeroTelef1()),m.getInteRev(),m.getCodCir(),voto,causa};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}
			
		}
		
/////////////////////////////////////////////////////////////////////////////////////////
		public void crearreporte1(String cir, String cdr){
			String repo=comboBoxAgre.getSelectedItem().toString();
			createReporte1Tablemodel model = new createReporte1Tablemodel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table.setModel(model);
			if(repo.equals("Todas Las Circunscripciones")) {
				try{
					Listreporte1s= ServicesLocator.getReportes_Services().selectreporte1AllCir();
					for(Reporte1 m  :Listreporte1s){
						
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(repo.equals("Una Circunscripcion")) {
				try{
					Listreporte1s= ServicesLocator.getReportes_Services().selectreporte1CirDada2(cir);
					for(Reporte1 m  :Listreporte1s){
						
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else if(repo.equals("Un CDR")) {
				try{
					Listreporte1s= ServicesLocator.getReportes_Services().selectreporte1CDRDada(cdr);
					for(Reporte1 m  :Listreporte1s){
						
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			
		}public void crearreporte1l(String cir, String cdr){
			
			createReporte1Tablemodel model = new createReporte1Tablemodel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table.setModel(model);
			if(cir ==null && cdr ==null) {
				try{
					Listreporte1s= ServicesLocator.getReportes_Services().selectreporte1AllCir();
					for(Reporte1 m  :Listreporte1s){
						
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(cir !=null && cdr==null) {
				try{
					Listreporte1s= ServicesLocator.getReportes_Services().selectreporte1CirDada2(cir);
					for(Reporte1 m  :Listreporte1s){
						
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else if(cir ==null && cdr!=null) {
				try{
					Listreporte1s= ServicesLocator.getReportes_Services().selectreporte1CDRDada(cdr);
					for(Reporte1 m  :Listreporte1s){
						
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle()};
						model.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		private Elector_DTO buscarvoto(Elector_DTO m) {
			try {
				listvoVotacion_DTOs = ServicesLocator.getvotVotacion_Services().selectAllVoto();
				for(Votacion_DTO e  :listvoVotacion_DTOs){
					if(e.getNumElect().equalsIgnoreCase(m.getNumConsc()) && e.getCodCDR().equalsIgnoreCase(m.getCodCDR())){
					m.setVoto(e.getVoto());
					m.setCausa(e.getCausa());
					}
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			return m;
		}
		
		
		
}
