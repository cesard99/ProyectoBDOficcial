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
import dto.Reporte2;
import dto.Reporte3;
import dto.Reporte4;
import dto.Reporte5;
import dto.Reporte6;
import dto.Reporte7;
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
import estruct.util.CreateReporteMunMNomTablemodel;
import estruct.util.CreateReporteResuProcesoTablemodel;
import estruct.util.CreateReporteResumenMunTablemodel;
import estruct.util.CreateReportelistaNominaTablemodel;
import estruct.util.CreateReportelistaParteTablemodel;
import estruct.util.CreateUserTablemodel;
import estruct.util.FframeC;
import estruct.util.FframeC2;
import estruct.util.FframeCDR;
import estruct.util.FframeCDR2;
import estruct.util.FframeMUN;
import estruct.util.createReporte1Tablemodel;
import estruct.util.createReporte2Tablemodel;

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
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	private ArrayList<Aux_DTO>listaAux_DTOs;
	private JComboBox comboBoxResumen;
	private ArrayList<Votacion_DTO>listvoVotacion_DTOs;
	private ArrayList<Elector_DTO>listadoElectores;
	private ArrayList<Nominado_DTO>listNominado_DTOs;
	private ArrayList<CDR_DTO>listCdr_DTOs;
	private ArrayList<Circunscripcion_DTO>listCircunscripcion_DTOs;
	private ArrayList<Colegios_DTO>listColegios_DTOs;
	private ArrayList<Municipio_DTO> listMunicipio;
	private ArrayList<Reporte1>Listreporte1s;
	private ArrayList<Reporte2>listReporte2s;
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBoxListado;
	private JComboBox comboBoxVotacion;
	private int selectedRow = -1;
	private String nombrecdr;
	private String nombrecir;
	
	private JComboBox comboBoxAgre;

	
	public Principal() {
		setResizable(false);
		setTitle("Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/votacion.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1274, 22);
		contentPane.add(menuBar);
		
		JButton btnNewButton = new JButton("Parte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Parte ventanaParte = new Parte();
				ventanaParte.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
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
		btnNewButton_1.setBackground(new Color(0, 128, 128));
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
		BtnCreateElector.setBackground(new Color(0, 128, 128));
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
		panel.setBounds(0, 21, 290, 508);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabelTitulo = new JLabel("Reportes");
		lblNewLabelTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabelTitulo.setBounds(102, 14, 75, 17);
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
		
		JLabel lblResumen = new JLabel("Votacion:");
		lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResumen.setBounds(10, 111, 58, 16);
		panel.add(lblResumen);
		
		JButton BtnResumen = new JButton("Generar");
		BtnResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String r=comboBoxVotacion.getSelectedItem().toString();
				if(r.equalsIgnoreCase("Electores que no Votaron")){
					crearreporte12(null, null, null);
				}else if(r.equalsIgnoreCase("Por Municipio")){
					FframeMUN f = new FframeMUN();
					f.setVisible(true);
					dispose();
				}else if(r.equalsIgnoreCase("Por Circunscrpcion")){
					FframeC2 f = new FframeC2();
					f.setVisible(true);
					dispose();
					
				}else if(r.equalsIgnoreCase("Por CDR")){
					FframeCDR2 f = new FframeCDR2();
					f.setVisible(true);
					dispose();
				}	
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
		
		comboBoxVotacion = new JComboBox();
		comboBoxVotacion.setModel(new DefaultComboBoxModel(new String[] {"Electores que no Votaron", "Por Municipio", "Por Circunscrpcion", "Por CDR"}));
		comboBoxVotacion.setBounds(68, 109, 130, 22);
		panel.add(comboBoxVotacion);
		
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
		
		JLabel lblReporte = new JLabel("Reporte:");
		lblReporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReporte.setBounds(10, 78, 57, 16);
		panel.add(lblReporte);
		
		JLabel lblNewImageRep = new JLabel("");// esto es solo para visualizar
		lblNewImageRep.setIcon(new ImageIcon(Principal.class.getResource("/img/pngegg.png")));
		lblNewImageRep.setBackground(new Color(0, 255, 0));
		lblNewImageRep.setBounds(0, 221, 290, 276);
		panel.add(lblNewImageRep);
		
		JLabel lblX = new JLabel("Resumen:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblX.setBounds(10, 140, 58, 16);
		panel.add(lblX);
		
		comboBoxResumen = new JComboBox();
		comboBoxResumen.setModel(new DefaultComboBoxModel(new String[] {"municipio Mas Nominado", "Listado Nominados", "Listado Parte", "Resumen Municipio", "Resumen Proceso"}));
		comboBoxResumen.setBounds(68, 138, 130, 22);
		panel.add(comboBoxResumen);
		
		JButton button_1 = new JButton("Generar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String r=comboBoxResumen.getSelectedItem().toString();
				if(r.equalsIgnoreCase("municipio Mas Nominado")){
					crearreporte3();//ok
				}else if(r.equalsIgnoreCase("Listado Nominados")){
					crearreporte4();//ok
				}else if(r.equalsIgnoreCase("Listado Parte")){
					crearreporte5();//ok
				}else if(r.equalsIgnoreCase("Resumen Municipio")){
					crearreporte6();//ok
					
				}else if(r.equalsIgnoreCase("Resumen Proceso")){
					crearreporte7();
				}		
				
			}
		});
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(208, 138, 82, 23);
		panel.add(button_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));;
		scrollPane.setBounds(289, 21, 985, 508);
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
			
			String Resumen=comboBoxVotacion.getSelectedItem().toString();
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
		
/////////////////////////////////////////////////////////////////////////////////////////Reportes//////////////////////////////////////////////////////////////////////////////////////////
		
		
		
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
			
		}
		
		public void crearreporte1l(String cir, String cdr){
			
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
		
public void crearreporte12(String cir, String cdr, String mun){
			
			createReporte2Tablemodel modelo = new createReporte2Tablemodel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table.setModel(modelo);
			if(cir ==null && cdr ==null && mun==null) {
				try{
					listReporte2s= ServicesLocator.getReportes_Services().selectreporte2AllElectNoVoto();
					for(Reporte2 m  :listReporte2s){
						
						table.setModel(modelo);
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle(),m.getCausa()};
						modelo.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
			}else if(cir !=null && cdr==null && mun==null) {
				try{
					listReporte2s= ServicesLocator.getReportes_Services().selectreporte2AllElectNoVotoCir(cir);
					for(Reporte2 m  :listReporte2s){
						table.setModel(modelo);
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle(),m.getCausa()};
						modelo.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else if(cir ==null && cdr!=null && mun==null) {
				try{
					listReporte2s= ServicesLocator.getReportes_Services().selectreporte2AllElectNoVotoCDR(cdr);
					for(Reporte2 m  :listReporte2s){
						table.setModel(modelo);
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle(),m.getCausa()};
						modelo.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else if(cir ==null && cdr==null && mun!=null) {
				try{
					listReporte2s= ServicesLocator.getReportes_Services().selectreporte2AllElectNoVotoMun(mun);
					for(Reporte2 m  :listReporte2s){
						table.setModel(modelo);
						String[] datos = {m.getNomMun(),m.getNomCir(),m.getMonCol(),m.getNomCDR(),m.getNumElec(),m.getNomYapELE(),m.getDirEle(),m.getCausa()};
						modelo.addRow(datos);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
public void crearreporte3(){
	
	CreateReporteMunMNomTablemodel modelo = new CreateReporteMunMNomTablemodel(){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	table.setModel(modelo);
	
		try{
			ArrayList<Reporte3> lis= ServicesLocator.getReportes_Services().selectreporte3MunCantNom();
			for(Reporte3 m  :lis){
				
				
				String[] datos = {m.getNomMun(),Integer.toString(m.getCantNOM())};
				modelo.addRow(datos);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		
		}
	}
public void crearreporte4(){
	
	CreateReportelistaNominaTablemodel modelo = new CreateReportelistaNominaTablemodel(){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	table.setModel(modelo);
	
		try{
			ArrayList<Reporte4> lis= ServicesLocator.getReportes_Services().selectreporte4ListNom();
			for(Reporte4 m  :lis){
				
				
				String[] datos = {m.getNomMun(),m.getNomCir(),m.getNumVuelta(),m.getNomYapELE(),m.getEdad(),m.getIntegraRev(),m.getDirEle(),m.getTelefono(),m.getOcupacion(),m.getProfecion(),m.getBiblio()};
				modelo.addRow(datos);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		
		}
	}
public void crearreporte5(){
	
	CreateReportelistaParteTablemodel modelo = new CreateReportelistaParteTablemodel(){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	table.setModel(modelo);
	
		try{
			ArrayList<Reporte5> lis= ServicesLocator.getReportes_Services().selectreporte5ListPart();
			for(Reporte5 m  :lis){
				
				
				String[] datos = {m.getNomMun(),m.getNomCir(),m.getNomCol(),m.getNomCDR(),m.getNumVuelta(),m.getFecha_hora(),m.getNumparte(),m.getCantElectQVotan(),m.getCantElectAdd(),m.getCantElectEliminados(),m.getTotalListadoElectores(),m.getCantElectoresVotadParteAnte()};
				modelo.addRow(datos);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		
		}
	}
public void crearreporte6(){
	
	CreateReporteResumenMunTablemodel modelo = new CreateReporteResumenMunTablemodel(){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	table.setModel(modelo);
	
		try{
			ArrayList<Reporte6> lis= ServicesLocator.getReportes_Services().selectreporte6ResumeMun();
			for(Reporte6 m  :lis){
				
				
				String[] datos = {m.getNomMun(),m.getCantCir(),m.getCantCol(),m.getCantCDR(),m.getCantElect()};
				modelo.addRow(datos);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		
		}
	}


public void crearreporte7(){
	
	CreateReporteResuProcesoTablemodel modelo = new CreateReporteResuProcesoTablemodel(){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	table.setModel(modelo);
	
		try{
			ArrayList<Reporte7> lis= ServicesLocator.getReportes_Services().selectreporte7ResumemProceso();
			for(Reporte7 m  :lis){
				
				
				String[] datos = {m.getNomMun(),m.getNomCir(),m.getNomCol(),m.getNomCDR(),m.getNumVuelta(),m.getFecha_hora(),m.getTotalListadoElectores(),m.getCantElectQVotan(),m.getCantidadElectTotal(),m.getPorciento_Votado(),m.getCant_no_votan(),m.getCantElectEliminados(),m.getCantidad_no_votaron_extranjero(),m.getCantidad_no_votaron_fuera_provincia(),m.getCantidad_no_votaron_hospitalizados(),m.getCantidad_no_votaron_trabajando(),m.getCantidad_no_votaron_otras_causas(),m.getCantidad_no_votaron_desconocidas()};
				modelo.addRow(datos);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		
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
