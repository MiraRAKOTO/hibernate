import java.awt.EventQueue;

import gestionSalle.dao.*;

import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import gestionSalle.dao.ProfDao;
import gestionSalle.model.Prof;
import gestionSalle.model.Salle;
import gestionSalle.model.Occuper;
import gestionSalle.view.TableActionCellEditor;
import gestionSalle.view.TableActionCellRender;
import gestionSalle.view.TableActionEvent;

import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.util.*;
public class homeGestionSalle extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldNomProf;
	private static JTextField textFieldPrenomProf;
	private static JTextField textFieldGradeProf;
	private JTable table;
	private JTextField txtRechercher;
	private static JTable table_1;
	private JTabbedPane tabbedPane;
	private JScrollPane tabProf;
	private static TableActionCellRender btnAction;
	private static JTextField textFieldCodeProf;
	private static JTextField textFieldCodeSalle;
	private static JTextField textFieldDesignation;
	private static JTextField textFieldRechercheSalle;
	private static JTable tableSalle;
	private JTextField textFieldNom;
	private JTextField textFielddesign;
	private JTable tableOccupe;
	private JTextField textFieldCodeOccupe;
	private static JComboBox comboBoxCodeProf;
	private static JComboBox comboBoxCodeSalle;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeGestionSalle frame = new homeGestionSalle();
					frame.setVisible(true);
						showAllProf();
						showAllSalle();
						initCombobox();
					  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homeGestionSalle() {
		
		
	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-3, 0, 965, 601);
		contentPane.add(tabbedPane);
		
		JPanel Pannemenu = new JPanel();
		tabbedPane.addTab("New tab", null, Pannemenu, null);
		Pannemenu.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 158, 254, 434);
		Pannemenu.add(panel_2);
		panel_2.setBackground(new Color(22, 4, 149));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue sur");
		lblNewLabel.setBounds(22, 135, 209, 42);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 32));
		
		JLabel lblNewLabel_1 = new JLabel("G-Salle de classe");
		lblNewLabel_1.setBounds(6, 229, 225, 38);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 30));
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
				
			}
		});
		panel_3.setBounds(274, 281, 176, 163);
		Pannemenu.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		
		JLabel btnProf = new JLabel("Proffesseur");
		btnProf.setBounds(26, 10, 116, 95);
		panel_3.add(btnProf);
		btnProf.setForeground(new Color(22, 4, 149));
		btnProf.setIcon(resize(new ImageIcon(this.getClass().getResource("/prof.png")),btnProf.getWidth(),btnProf.getHeight()));
		
		JLabel lblNewLabel_2 = new JLabel("Professeur");
		lblNewLabel_2.setBounds(10, 118, 165, 21);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(22, 4, 149));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 28));
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		panel_4.setBounds(475, 281, 191, 163);
		Pannemenu.add(panel_4);
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Salle");
		lblNewLabel_3.setBounds(62, 119, 85, 34);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(22, 4, 149));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 28));
		
		JLabel btnClasse = new JLabel("Classe");
		btnClasse.setBounds(37, 10, 117, 93);
		panel_4.add(btnClasse);
		btnClasse.setIcon(resize(new ImageIcon(this.getClass().getResource("/salle-de-classe.png")),btnClasse.getWidth(),btnClasse.getHeight()));
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		panel_5.setBounds(699, 281, 189, 163);
		Pannemenu.add(panel_5);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		
		JLabel btnReservation = new JLabel("New label");
		btnReservation.setBounds(23, 10, 124, 94);
		panel_5.add(btnReservation);
		btnReservation.setIcon(resize(new ImageIcon(this.getClass().getResource("/reservation-en-ligne.png")),btnReservation.getWidth(),btnReservation.getHeight()));
		
		JLabel lblNewLabel_4 = new JLabel("Réservation");
		lblNewLabel_4.setBounds(10, 114, 157, 21);
		panel_5.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(22, 4, 149));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 28));
		
		JPanel panel = new JPanel();
		panel.setBounds(174, 33, 786, 34);
		Pannemenu.add(panel);
		panel.setBackground(new Color(22, 4, 149));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(22, 4, 149));
		panel.add(panel_1);
		
		JLabel iconLabell = new JLabel("");
		iconLabell.setBounds(0, -11, 231, 186);
		Pannemenu.add(iconLabell);
		
		iconLabell.setIcon(resize(new ImageIcon(this.getClass().getResource("/icon.png")),iconLabell.getWidth(),iconLabell.getHeight()));
		
		JPanel panelProf = new JPanel();
		tabbedPane.addTab("New tab", null, panelProf, null);
		panelProf.setLayout(null);
		
		JLabel btnHomeProf = new JLabel("");
		btnHomeProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnHomeProf.setBounds(850, 10, 78, 72);
		btnHomeProf.setIcon(resize(new ImageIcon(this.getClass().getResource("/accueil.png")),btnHomeProf.getWidth(),btnHomeProf.getHeight()));
		panelProf.add(btnHomeProf);
		
		JLabel iconLabell_1 = new JLabel("");
		iconLabell_1.setBounds(10, -11, 215, 187);
		iconLabell_1.setIcon(resize(new ImageIcon(this.getClass().getResource("/icon.png")),iconLabell_1.getWidth(),iconLabell_1.getHeight()));
		
		panelProf.add(iconLabell_1);
		
		textFieldNomProf = new JTextField();
		textFieldNomProf.setBounds(620, 124, 308, 26);
		panelProf.add(textFieldNomProf);
		textFieldNomProf.setColumns(10);
		
		textFieldPrenomProf = new JTextField();
		textFieldPrenomProf.setBounds(620, 160, 308, 26);
		panelProf.add(textFieldPrenomProf);
		textFieldPrenomProf.setColumns(10);
		
		textFieldGradeProf = new JTextField();
		textFieldGradeProf.setBounds(620, 196, 308, 26);
		panelProf.add(textFieldGradeProf);
		textFieldGradeProf.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 572, 829, -303);
		panelProf.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnValide = new JButton("Valider");
		btnValide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(textFieldCodeProf.getText().isEmpty()) {
						ProfDao profdao= new ProfDao();
						Prof prof= new Prof();
						prof.setNomProf(textFieldNomProf.getText());
						prof.setPrenomProf(textFieldPrenomProf.getText());
						prof.setGrade(textFieldGradeProf.getText());
						profdao.saveProf(prof);
						
						JOptionPane.showMessageDialog(null, "Ajout avec succès");
						showAllProf();
						reset();	
					}else {
						
						String codeprof= textFieldCodeProf.getText();
						int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment modifier"+codeprof, "Modification", JOptionPane.YES_NO_OPTION);
						
						int id= Integer.parseInt(codeprof.substring(4));
		                ProfDao profdao= new ProfDao();
						Prof prof= profdao.getProfById(id);
						prof.setNomProf(textFieldNomProf.getText());
						prof.setPrenomProf(textFieldPrenomProf.getText());
						prof.setGrade(textFieldGradeProf.getText());
					
						if(request == JOptionPane.OK_OPTION) {
							profdao.updateProf(prof);
							JOptionPane.showMessageDialog(null, "Modification avec succès");
							showAllProf();
							reset();
							
						}
						else {
							showAllProf();
							reset();
						}
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnValide.setBounds(839, 232, 89, 26);
		btnValide.setForeground(new Color(255, 255, 255));
		btnValide.setFont(new Font("Arial", Font.BOLD, 12));
		btnValide.setBackground(new Color(64, 128, 128));
		btnValide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelProf.add(btnValide);
		
		JLabel lblNewLabel_5 = new JLabel("Code Prof:");
		lblNewLabel_5.setBounds(504, 90, 98, 18);
		panelProf.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_6 = new JLabel("Prénoms:");
		lblNewLabel_6.setBounds(531, 165, 89, 13);
		panelProf.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_7 = new JLabel("Grade:");
		lblNewLabel_7.setBounds(543, 196, 70, 26);
		panelProf.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 14));
		
		txtRechercher = new JTextField();
		txtRechercher.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtRechercher.getText().isEmpty()) {
					showAllProf();	
				}
				else {
					char c= e.getKeyChar();
					if(Character.isLetter(c)) {
						String key=txtRechercher.getText();
						showProf(key);
						
					}
					else {
						long key= Integer.parseInt(txtRechercher.getText());
						 showProfById(key);
						
					}
					
					
				}
			}
		});
		txtRechercher.setBounds(10, 210, 338, 34);
		txtRechercher.setFont(new Font("SimSun", Font.PLAIN, 10));
		panelProf.add(txtRechercher);
		txtRechercher.setColumns(10);
		
		tabProf = new JScrollPane();
		tabProf.setBounds(10, 268, 918, 294);
		panelProf.add(tabProf);
		
		table_1 = new JTable();
		tabProf.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Code Prof", "Nom", "Pr\u00E9noms", "Grade", "Action"
			}
		));
		table_1.setRowHeight(40);
		table_1.setSelectionBackground(new java.awt.Color(56, 138, 112));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(164, 34, 700, 34);
		panel_9.setBackground(new Color(22, 4, 149));
		panelProf.add(panel_9);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(22, 4, 149));
		panel_9.add(panel_1_1);
		
		textFieldCodeProf = new JTextField();
		textFieldCodeProf.setEditable(false);
		textFieldCodeProf.setBounds(620, 88, 89, 26);
		panelProf.add(textFieldCodeProf);
		textFieldCodeProf.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nom:");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(543, 124, 55, 18);
		panelProf.add(lblNewLabel_5_1);
		
		JPanel paneSalle = new JPanel();
		tabbedPane.addTab("New tab", null, paneSalle, null);
		paneSalle.setLayout(null);
		
		JLabel iconLabell_1_1 = new JLabel("");
		iconLabell_1_1.setBounds(0, -12, 215, 187);
		iconLabell_1_1.setIcon(resize(new ImageIcon(this.getClass().getResource("/icon.png")),iconLabell_1_1.getWidth(),iconLabell_1_1.getHeight()));
		
		paneSalle.add(iconLabell_1_1);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setBackground(new Color(22, 4, 149));
		panel_9_1.setBounds(166, 32, 701, 34);
		paneSalle.add(panel_9_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(22, 4, 149));
		panel_9_1.add(panel_1_1_1);
		
		JLabel btnHomeProf_1 = new JLabel("");
		btnHomeProf_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnHomeProf_1.setBounds(858, 10, 78, 72);
		 btnHomeProf_1.setIcon(resize(new ImageIcon(this.getClass().getResource("/accueil.png")), btnHomeProf_1.getWidth(), btnHomeProf_1.getHeight()));
		
		paneSalle.add(btnHomeProf_1);
		
		textFieldCodeSalle = new JTextField();
		textFieldCodeSalle.setEditable(false);
		textFieldCodeSalle.setBounds(629, 89, 96, 28);
		paneSalle.add(textFieldCodeSalle);
		textFieldCodeSalle.setColumns(10);
		
		textFieldDesignation = new JTextField();
		textFieldDesignation.setBounds(629, 127, 208, 30);
		paneSalle.add(textFieldDesignation);
		textFieldDesignation.setColumns(10);
		
		JButton btnValideSalle = new JButton("Valider");
		btnValideSalle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(textFieldCodeSalle.getText().isEmpty()) {
						SalleDao salledao= new SalleDao();
						Salle salle= new Salle();
						salle.setDesignationSalle(textFieldDesignation.getText());
						
						salledao.saveSalle(salle);
						
						JOptionPane.showMessageDialog(null, "Ajout avec succès");
						showAllSalle();
						resetsalle();	
					}else {
						
						String codesalle= textFieldCodeSalle.getText();
						int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment modifier"+codesalle, "Modification", JOptionPane.YES_NO_OPTION);
						
						int id= Integer.parseInt(codesalle.substring(5));
		                SalleDao salledao= new SalleDao();
						Salle salle= salledao.getSalleById(id);
						
						salle.setDesignationSalle(textFieldDesignation.getText());
					
						if(request == JOptionPane.OK_OPTION) {
							salledao.updateSalle(salle);
							JOptionPane.showMessageDialog(null, "Modification avec succès");
							showAllSalle();
							resetsalle();
							
						}
						else {
							showAllSalle();
							resetsalle();
						}
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnValideSalle.setBounds(759, 167, 78, 28);
		paneSalle.add(btnValideSalle);
		
		textFieldRechercheSalle = new JTextField();
		textFieldRechercheSalle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textFieldRechercheSalle.getText().isEmpty()) {
					showAllSalle();	
				}
				else {
					char c= e.getKeyChar();
					if(Character.isLetter(c)) {
						String key= textFieldRechercheSalle.getText();
						showSalle(key);
						
					}
					else {
						long key= Integer.parseInt(textFieldRechercheSalle.getText());
						 showSalleById(key);
						
					}
					
					
				}
			}
		});
		textFieldRechercheSalle.setBounds(43, 193, 224, 28);
		paneSalle.add(textFieldRechercheSalle);
		textFieldRechercheSalle.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 246, 926, 318);
		paneSalle.add(scrollPane_1);
		
		tableSalle = new JTable();
		scrollPane_1.setViewportView(tableSalle);
		tableSalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code Salle", "D\u00E9signation", "Action"
			}
		));
		tableSalle.setRowHeight(40);
		tableSalle.setSelectionBackground(new java.awt.Color(56, 138, 112));
		
		
		JLabel lblNewLabel_8 = new JLabel("Code Salle:");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_8.setBounds(537, 93, 96, 17);
		paneSalle.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Désignation: ");
		lblNewLabel_8_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(537, 132, 96, 17);
		paneSalle.add(lblNewLabel_8_1);
		
		
		JPanel panneReservation = new JPanel();
		tabbedPane.addTab("New tab", null, panneReservation, null);
		panneReservation.setLayout(null);
		
		JLabel iconLabell_1_1_1 = new JLabel("");
		iconLabell_1_1_1.setBounds(10, -20, 180, 156);
		iconLabell_1_1_1.setIcon(resize(new ImageIcon(this.getClass().getResource("/icon.png")),iconLabell_1_1_1.getWidth(),iconLabell_1_1_1.getHeight()));
		
		
		panneReservation.add(iconLabell_1_1_1);
		
		JPanel panel_9_1_1 = new JPanel();
		panel_9_1_1.setBackground(new Color(22, 4, 149));
		panel_9_1_1.setBounds(142, 17, 726, 27);
		panneReservation.add(panel_9_1_1);
		
		JLabel btnHomeProf_1_1 = new JLabel("");
		btnHomeProf_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
			
		});
		btnHomeProf_1_1.setBounds(859, 0, 78, 72);
		btnHomeProf_1_1.setIcon(resize(new ImageIcon(this.getClass().getResource("/accueil.png")), btnHomeProf_1_1.getWidth(), btnHomeProf_1_1.getHeight()));
			
		
		panneReservation.add(btnHomeProf_1_1);
		
		comboBoxCodeProf = new JComboBox();
		comboBoxCodeProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedCodeProf= (String) comboBoxCodeProf.getSelectedItem();
				long profcode= Integer.parseInt(selectedCodeProf.substring(4));
				ProfDao profdao= new ProfDao();
				Prof prof= profdao.getProfById(profcode);
				textFieldNom.setText(prof.getNomProf()+" "+prof.getPrenomProf());
			}
		});
		comboBoxCodeProf.setBounds(427, 96, 88, 27);
		panneReservation.add(comboBoxCodeProf);
		
		JLabel lblNewLabel_9 = new JLabel("Code Prof:");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9.setBounds(339, 102, 78, 13);
		panneReservation.add(lblNewLabel_9);
		
		comboBoxCodeSalle = new JComboBox();
		comboBoxCodeSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String salleSelected= (String) comboBoxCodeSalle.getSelectedItem();
				long sallecode= Integer.parseInt(salleSelected.substring(5));
				SalleDao salledao= new SalleDao();
				Salle salle = salledao.getSalleById(sallecode);
				textFielddesign.setText(salle.getDesignationSalle());
				
				
			}
		});
		comboBoxCodeSalle.setBounds(427, 133, 88, 27);
		panneReservation.add(comboBoxCodeSalle);
		
		JLabel lblNewLabel_9_1 = new JLabel("Nom complet:");
		lblNewLabel_9_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9_1.setBounds(525, 98, 113, 21);
		panneReservation.add(lblNewLabel_9_1);
		
		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBounds(628, 96, 192, 27);
		panneReservation.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Date: ");
		lblNewLabel_9_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9_1_1.setBounds(438, 178, 98, 21);
		panneReservation.add(lblNewLabel_9_1_1);
		
		textFielddesign = new JTextField();
		textFielddesign.setEditable(false);
		textFielddesign.setBounds(628, 133, 192, 27);
		panneReservation.add(textFielddesign);
		textFielddesign.setColumns(10);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Désignation: ");
		lblNewLabel_9_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9_1_1_1.setBounds(525, 135, 98, 21);
		panneReservation.add(lblNewLabel_9_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(497, 172, 201, 27);
		panneReservation.add(dateChooser);
		
		Date date = new Date();
		SpinnerDateModel sm = 
		new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		JSpinner spinnerDeb = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinnerDeb, "HH:mm:ss");
		spinnerDeb.setEditor(de);
		
		spinnerDeb.setBounds(497, 209, 90, 27);
		panneReservation.add(spinnerDeb);
		
		JLabel lblNewLabel_9_1_1_2 = new JLabel("De: ");
		lblNewLabel_9_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9_1_1_2.setBounds(452, 211, 35, 20);
		panneReservation.add(lblNewLabel_9_1_1_2);
		
		Date datefin = new Date();
		SpinnerDateModel smfin = 
		new SpinnerDateModel(datefin, null, null, Calendar.HOUR_OF_DAY);
		JSpinner spinnerFin = new JSpinner(smfin);
		JSpinner.DateEditor defin = new JSpinner.DateEditor(spinnerFin, "HH:mm:ss");
		spinnerFin.setEditor(defin);
		
		spinnerFin.setBounds(618, 209, 80, 27);
		panneReservation.add(spinnerFin);
		
		JLabel lblNewLabel_9_1_1_2_1 = new JLabel("A: ");
		lblNewLabel_9_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9_1_1_2_1.setBounds(597, 211, 26, 20);
		panneReservation.add(lblNewLabel_9_1_1_2_1);
		
		JDateChooser dateChooserSearch = new JDateChooser();
		dateChooserSearch.setBounds(10, 259, 226, 27);
		panneReservation.add(dateChooserSearch);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 296, 940, 268);
		panneReservation.add(scrollPane_2);
		
		tableOccupe = new JTable();
		scrollPane_2.setViewportView(tableOccupe);
		tableOccupe.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num\u00E9ro", "Code Prof", "Code Salle", "Date", "D\u00E9but heure", "Fin heure", "Action"
			}
		));
		
		JLabel lblNewLabel_9_2 = new JLabel("Code Salle");
		lblNewLabel_9_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9_2.setBounds(339, 139, 78, 13);
		panneReservation.add(lblNewLabel_9_2);
		
		JButton btnValideOccupe = new JButton("Valider");
		btnValideOccupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValideOccupe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					String selectedCodeProf= (String) comboBoxCodeProf.getSelectedItem();
					String selectedCodeSalle= (String) comboBoxCodeSalle.getSelectedItem();
					long profcode= Integer.parseInt(selectedCodeProf.substring(4));
					long sallecode= Integer.parseInt(selectedCodeSalle.substring(5));
					SimpleDateFormat sm= new SimpleDateFormat("dd/MM/yyyy");
					String strDate= sm.format(dateChooser.getDate());
					Date dateRes = sm.parse(strDate);
					
					Date timeDeb = (Date) spinnerDeb.getValue();
					Date timeFin = (Date) spinnerFin.getValue();
					OccuperDao occupedao= new OccuperDao();
					ProfDao profdao= new ProfDao();
					SalleDao salledao= new SalleDao();
					//OBJET 
					Prof prof= profdao.getProfById(profcode);
					Salle salle= salledao.getSalleById(sallecode);
					Occuper occupe= new Occuper();
					occupe.setProfOccupe(prof);
					occupe.setSalleOccupe(salle);
					occupe.setDate(dateRes);
					occupe.setTimedeb(timeDeb);
					occupe.setTimefin(timeFin);
					
					occupedao.saveOccupe(occupe);
						
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//DAO
				
				
				
			}
		});
		btnValideOccupe.setBounds(735, 240, 85, 34);
		panneReservation.add(btnValideOccupe);
		JLabel lblNewLabel_9_3 = new JLabel("Numero;");
		lblNewLabel_9_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_9_3.setBounds(452, 59, 70, 13);
		panneReservation.add(lblNewLabel_9_3);
		
		textFieldCodeOccupe = new JTextField();
		textFieldCodeOccupe.setEditable(false);
		textFieldCodeOccupe.setColumns(10);
		textFieldCodeOccupe.setBounds(525, 54, 113, 27);
		panneReservation.add(textFieldCodeOccupe);
	
	}
	
	public static ImageIcon resize(ImageIcon im, int w, int h) {
		BufferedImage bi= new BufferedImage(w,h, BufferedImage.TRANSLUCENT);
		Graphics2D gd= (Graphics2D)bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(), 0, 0, w, h, null);
		gd.dispose();
		return new ImageIcon(bi);
		
	}
	public static  void reset() {
		textFieldNomProf.setText("");
		textFieldPrenomProf.setText("");
		textFieldGradeProf.setText("");
		textFieldCodeProf.setText("");;
	}
	public static  void resetsalle() {
		textFieldCodeSalle.setText("");
		textFieldDesignation.setText("");
		
	}
	private static  void showAllProf() {
		 TableActionEvent event = new TableActionEvent() {
	            @Override
	            public void onEdit(int row) {
	            	
	                row= table_1.getSelectedRow();
	                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	                textFieldCodeProf.setText(model.getValueAt(row, 0).toString());
	                textFieldNomProf.setText(model.getValueAt(row, 1).toString());
	                textFieldPrenomProf.setText(model.getValueAt(row, 2).toString());
	                textFieldGradeProf.setText(model.getValueAt(row, 3).toString());
	                     
	            }

	            @Override
	            public void onDelete(int row) {
	                if (table_1.isEditing()) {
	                    table_1.getCellEditor().stopCellEditing();
	                }
	                ProfDao profdao= new ProfDao();
	                row= table_1.getSelectedRow();
	                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	                String codeprof= model.getValueAt(row, 0).toString();
	                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment suprimer"+codeprof, "Suppression", JOptionPane.YES_NO_OPTION);

					if(request == JOptionPane.OK_OPTION) {
						
						int id= Integer.parseInt(codeprof.substring(4));
						Prof prof= profdao.getProfById(id);
		                profdao.deletProf(prof.getCodeProf());
						JOptionPane.showMessageDialog(null, "Suppression avec succès");
						showAllProf();
						
					}
					else {
						showAllProf();
					}
	                
	                
	            }

	            @Override
	            public void onView(int row) {
	                System.out.println("View row : " + row);
	            }
	        };
		ProfDao profdao= new ProfDao();
		List<Prof> profs= profdao.getAllProfs();
		DefaultTableModel tModel= (DefaultTableModel)table_1.getModel();
		tModel.setRowCount(0);
		for(Prof prof: profs) {
			Object[] objt = new Object[] {
					"PROF"+prof.getCodeProf(), prof.getNomProf(),prof.getPrenomProf(),prof.getGrade(),
			};
			table_1.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
			table_1.getColumnModel().getColumn(4).setCellEditor((TableCellEditor) new TableActionCellEditor(event));
			tModel.addRow(objt);
			
		}}
	private static  void showProf(String keyWord) {
		 TableActionEvent event = new TableActionEvent() {
	            @Override
	            public void onEdit(int row) {
	            	
	                row= table_1.getSelectedRow();
	                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	                textFieldCodeProf.setText(model.getValueAt(row, 0).toString());
	                textFieldNomProf.setText(model.getValueAt(row, 1).toString());
	                textFieldPrenomProf.setText(model.getValueAt(row, 2).toString());
	                textFieldGradeProf.setText(model.getValueAt(row, 3).toString());
	                     
	            }

	            @Override
	            public void onDelete(int row) {
	                if (table_1.isEditing()) {
	                    table_1.getCellEditor().stopCellEditing();
	                }
	                ProfDao profdao= new ProfDao();
	                row= table_1.getSelectedRow();
	                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	                String codeprof= model.getValueAt(row, 0).toString();
	                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment suprimer"+codeprof, "Suppression", JOptionPane.YES_NO_OPTION);

					if(request == JOptionPane.OK_OPTION) {
						
						int id= Integer.parseInt(codeprof.substring(4));
						Prof prof= profdao.getProfById(id);
		                profdao.deletProf(prof.getCodeProf());
						JOptionPane.showMessageDialog(null, "Suppression avec succès");
						showAllProf();
						
					}
					else {
						showAllProf();
					}
	                
	                
	            }

	            @Override
	            public void onView(int row) {
	                System.out.println("View row : " + row);
	            }
	        };
		ProfDao profdao= new ProfDao();
		List<Prof> profs= profdao.findcontains(keyWord);
		DefaultTableModel tModel= (DefaultTableModel)table_1.getModel();
		tModel.setRowCount(0);
		for(Prof prof: profs) {
			Object[] objt = new Object[] {
					"PROF"+prof.getCodeProf(), prof.getNomProf(),prof.getPrenomProf(),prof.getGrade(),
			};
			table_1.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
			table_1.getColumnModel().getColumn(4).setCellEditor((TableCellEditor) new TableActionCellEditor(event));
			tModel.addRow(objt);
			
		}}
		
		
		private static  void showProfById(long keyWord) {
			 TableActionEvent event = new TableActionEvent() {
		            @Override
		            public void onEdit(int row) {
		            	
		                row= table_1.getSelectedRow();
		                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		                textFieldCodeProf.setText(model.getValueAt(row, 0).toString());
		                textFieldNomProf.setText(model.getValueAt(row, 1).toString());
		                textFieldPrenomProf.setText(model.getValueAt(row, 2).toString());
		                textFieldGradeProf.setText(model.getValueAt(row, 3).toString());
		                     
		            }

		            @Override
		            public void onDelete(int row) {
		                if (table_1.isEditing()) {
		                    table_1.getCellEditor().stopCellEditing();
		                }
		                ProfDao profdao= new ProfDao();
		                row= table_1.getSelectedRow();
		                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		                String codeprof= model.getValueAt(row, 0).toString();
		                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment suprimer"+codeprof, "Suppression", JOptionPane.YES_NO_OPTION);

						if(request == JOptionPane.OK_OPTION) {
							
							int id= Integer.parseInt(codeprof.substring(4));
							Prof prof= profdao.getProfById(id);
			                profdao.deletProf(prof.getCodeProf());
							JOptionPane.showMessageDialog(null, "Suppression avec succès");
							showAllProf();
							
						}
						else {
							showAllProf();
						}
		                
		                
		            }

		            @Override
		            public void onView(int row) {
		                System.out.println("View row : " + row);
		            }
		        };
			ProfDao profdao= new ProfDao();
			Prof prof= profdao.getProfById(keyWord);
			DefaultTableModel tModel= (DefaultTableModel)table_1.getModel();
			tModel.setRowCount(0);
				Object[] objt = new Object[] {
						"PROF"+prof.getCodeProf(), prof.getNomProf(),prof.getPrenomProf(),prof.getGrade(),
				};
				table_1.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
				table_1.getColumnModel().getColumn(4).setCellEditor((TableCellEditor) new TableActionCellEditor(event));
				tModel.addRow(objt);
				
	
	
	
}


		//CLASSE
		private static  void showAllSalle() {
			 TableActionEvent event = new TableActionEvent() {
		            @Override
		            public void onEdit(int row) {
		            	
		                row= tableSalle.getSelectedRow();
		                DefaultTableModel model = (DefaultTableModel) tableSalle.getModel();
		               
		            	textFieldCodeSalle.setText(model.getValueAt(row, 0).toString());
		            	textFieldDesignation.setText(model.getValueAt(row, 1).toString());
		                     
		            }

		            @Override
		            public void onDelete(int row) {
		                if (tableSalle.isEditing()) {
		                    tableSalle.getCellEditor().stopCellEditing();
		                }
		                SalleDao salledao= new SalleDao();
		   
		                row= tableSalle.getSelectedRow();
		                DefaultTableModel model = (DefaultTableModel) tableSalle.getModel();
		                String codesalle= model.getValueAt(row, 0).toString();
		                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment suprimer"+codesalle, "Suppression", JOptionPane.YES_NO_OPTION);

						if(request == JOptionPane.OK_OPTION) {
							
							int id= Integer.parseInt(codesalle.substring(5));
							Salle salle= salledao.getSalleById(id);
							salledao.deleteSalle(salle.getCodeSalle());
							JOptionPane.showMessageDialog(null, "Suppression avec succès");
							showAllSalle();
							
						}
						else {
							showAllSalle();
						}
		                
		                
		            }

		            @Override
		            public void onView(int row) {
		                System.out.println("View row : " + row);
		            }
		        };
		    SalleDao salledao= new SalleDao();
			
			List<Salle> salles= salledao.getAllSalles();
			DefaultTableModel tModel= (DefaultTableModel)tableSalle.getModel();
			tModel.setRowCount(0);
			for(Salle salle: salles) {
				Object[] objt = new Object[] {
						"SALLE"+salle.getCodeSalle(), salle.getDesignationSalle(),
				};
				tableSalle.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
				tableSalle.getColumnModel().getColumn(2).setCellEditor((TableCellEditor) new TableActionCellEditor(event));
				tModel.addRow(objt);
				
			}}

		private static  void showSalle(String keyWord) {
			 TableActionEvent event = new TableActionEvent() {
		            @Override
		            public void onEdit(int row) {
		            	
		            	row= tableSalle.getSelectedRow();
		                DefaultTableModel model = (DefaultTableModel) tableSalle.getModel();
		               
		            	textFieldCodeSalle.setText(model.getValueAt(row, 0).toString());
		            	textFieldDesignation.setText(model.getValueAt(row, 1).toString());
		                     
		            }

		            @Override
		            public void onDelete(int row) {
		            	 if (tableSalle.isEditing()) {
			                    tableSalle.getCellEditor().stopCellEditing();
			                }
			                SalleDao salledao= new SalleDao();
			   
			                row= tableSalle.getSelectedRow();
			                DefaultTableModel model = (DefaultTableModel) tableSalle.getModel();
			                String codesalle= model.getValueAt(row, 0).toString();
			                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment suprimer"+codesalle, "Suppression", JOptionPane.YES_NO_OPTION);

							if(request == JOptionPane.OK_OPTION) {
								
								int id= Integer.parseInt(codesalle.substring(5));
								Salle salle= salledao.getSalleById(id);
								salledao.deleteSalle(salle.getCodeSalle());
								JOptionPane.showMessageDialog(null, "Suppression avec succès");
								showAllSalle();
								
							}
							else {
								showAllSalle();
							}
			                
			             
		                
		            }

		            @Override
		            public void onView(int row) {
		                System.out.println("View row : " + row);
		            }
		        };
			SalleDao salledao= new SalleDao();
			List<Salle> salles= salledao.findcontainsByDes(keyWord);
			DefaultTableModel tModel= (DefaultTableModel)tableSalle.getModel();
			tModel.setRowCount(0);
			for(Salle salle: salles) {
				Object[] objt = new Object[] {
						"SALLE"+salle.getCodeSalle(),salle.getDesignationSalle(),
				};
				table_1.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
				table_1.getColumnModel().getColumn(2).setCellEditor((TableCellEditor) new TableActionCellEditor(event));
				tModel.addRow(objt);
				
			}}
			

		private static  void showSalleById(long keyWord) {
			 TableActionEvent event = new TableActionEvent() {
				 @Override
		            public void onEdit(int row) {
		            	
		            	row= tableSalle.getSelectedRow();
		                DefaultTableModel model = (DefaultTableModel) tableSalle.getModel();
		               
		            	textFieldCodeSalle.setText(model.getValueAt(row, 0).toString());
		            	textFieldDesignation.setText(model.getValueAt(row, 1).toString());
		                     
		            }

		            @Override
		            public void onDelete(int row) {
		            	 if (tableSalle.isEditing()) {
			                    tableSalle.getCellEditor().stopCellEditing();
			                }
			                SalleDao salledao= new SalleDao();
			   
			                row= tableSalle.getSelectedRow();
			                DefaultTableModel model = (DefaultTableModel) tableSalle.getModel();
			                String codesalle= model.getValueAt(row, 0).toString();
			                int request= JOptionPane.showConfirmDialog(null,"Voulez vous vraiment suprimer"+codesalle, "Suppression", JOptionPane.YES_NO_OPTION);

							if(request == JOptionPane.OK_OPTION) {
								
								int id= Integer.parseInt(codesalle.substring(5));
								Salle salle= salledao.getSalleById(id);
								salledao.deleteSalle(salle.getCodeSalle());
								JOptionPane.showMessageDialog(null, "Suppression avec succès");
								showAllSalle();
								
							}
							else {
								showAllSalle();
							}
			                
			             
		                
		            }

		            @Override
		            public void onView(int row) {
		                System.out.println("View row : " + row);
		            }
		        };
			SalleDao salledao= new SalleDao();
			Salle salle= salledao.getSalleById(keyWord);
			DefaultTableModel tModel= (DefaultTableModel)tableSalle.getModel();
			tModel.setRowCount(0);
				Object[] objt = new Object[] {
						"SALLE"+salle.getCodeSalle(),salle.getDesignationSalle(),
				};
				table_1.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
				table_1.getColumnModel().getColumn(2).setCellEditor((TableCellEditor) new TableActionCellEditor(event));
				tModel.addRow(objt);
				
	
	
	
}
		
		//RESERVATION
	private static void initCombobox() {
		ProfDao profdao= new ProfDao();
		
		List<Prof> profs= profdao.getAllProfs();
		for(Prof prof: profs) {
			String codeProf= "PROF"+prof.getCodeProf();
			 comboBoxCodeProf.addItem(codeProf);
			
		}
		SalleDao salledao= new SalleDao();
		List<Salle> salles= salledao.getAllSalles();
		for(Salle salle: salles) {
			String codeSalle= "SALLE"+salle.getCodeSalle();
			comboBoxCodeSalle.addItem(codeSalle);
			
		}
		
		
		
		
	}
}