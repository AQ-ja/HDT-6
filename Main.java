import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Main {

	private JFrame frame;
	private Controller control;
	private JRadioButton rdbtnTreemap,rdbtnNewRadioButton,rdbtnLinkedhashmap;
	private JPanel ElegirMap,Principal;
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private JScrollPane spCartas;
	private JScrollPane spHechizo;
	private JScrollPane spTrampa;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7,spMonstruo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		control = new Controller();
		frame = new JFrame();
		frame.setBounds(100, 100, 1287, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		ElegirMap = new JPanel();
		ElegirMap.setBackground(Color.WHITE);
		frame.getContentPane().add(ElegirMap, "name_436410592120900");
		ElegirMap.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(357, 216, 379, 253);
		ElegirMap.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Elegir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!rdbtnNewRadioButton.isSelected() && !rdbtnTreemap.isSelected() && !rdbtnLinkedhashmap.isSelected()) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguno");
				}else {
					if (rdbtnNewRadioButton.isSelected()) {
						control.setMap("HashMap");
					}else if (rdbtnTreemap.isSelected()) {
						control.setMap("TreeMap");
					}else if (rdbtnLinkedhashmap.isSelected()) {
						control.setMap("LinkedHashMap");
					}
					Principal.setVisible(true);
					ElegirMap.setVisible(false);
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(136, 200, 97, 25);
		panel.add(btnNewButton);
		
		rdbtnNewRadioButton = new JRadioButton("HashMap");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				rdbtnTreemap.setSelected(false);
				rdbtnLinkedhashmap.setSelected(false);
			}
		});
		rdbtnNewRadioButton.setBounds(106, 46, 127, 25);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnTreemap = new JRadioButton("TreeMap");
		rdbtnTreemap.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnLinkedhashmap.setSelected(false);
				
			}
		});
		rdbtnTreemap.setBackground(Color.LIGHT_GRAY);
		rdbtnTreemap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnTreemap.setBounds(106, 89, 127, 25);
		panel.add(rdbtnTreemap);
		
		rdbtnLinkedhashmap = new JRadioButton("LinkedHashMap");
		rdbtnLinkedhashmap.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnTreemap.setSelected(false);
				
			}
		});
		rdbtnLinkedhashmap.setBackground(Color.LIGHT_GRAY);
		rdbtnLinkedhashmap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnLinkedhashmap.setBounds(106, 130, 193, 25);
		panel.add(rdbtnLinkedhashmap);
		
		Principal = new JPanel();
		Principal.setBackground(Color.WHITE);
		frame.getContentPane().add(Principal, "name_436413107575200");
		Principal.setLayout(null);
		
		btnNewButton_1 = new JButton("Leer Archivo");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//try {
				control.fillMap();
				
				setCardTable();
				fillTypesTables();
				//}catch(Exception ex) {
				//	JOptionPane.showMessageDialog(null, "No se pudo leer el archivo txt");
				//}
			}
		});
		btnNewButton_1.setBounds(12, 13, 155, 39);
		Principal.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		panel_1.setBounds(22, 75, 1235, 685);
		Principal.add(panel_1);
		panel_1.setLayout(null);
		
		spCartas = new JScrollPane();
		spCartas.setBounds(12, 169, 411, 219);
		panel_1.add(spCartas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 453, 411, 219);
		panel_1.add(scrollPane_1);
		
		spMonstruo = new JScrollPane();
		spMonstruo.setBounds(449, 169, 247, 219);
		panel_1.add(spMonstruo);
		
		spHechizo = new JScrollPane();
		spHechizo.setBounds(708, 169, 247, 219);
		panel_1.add(spHechizo);
		
		spTrampa = new JScrollPane();
		spTrampa.setBounds(967, 169, 247, 219);
		panel_1.add(spTrampa);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(449, 453, 247, 219);
		panel_1.add(scrollPane_5);
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(708, 453, 247, 219);
		panel_1.add(scrollPane_6);
		
		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(967, 453, 247, 219);
		panel_1.add(scrollPane_7);
	}
	
	private void setCardTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(2);
		model.setColumnIdentifiers(new String[] {"Carta","Tipo"});
		model.setRowCount(control.getMapSize());
		Object[] list = control.getKeysMap();
		Arrays.sort(list);
		for (int i = 0;i< list.length;i++) {
			model.setValueAt(list[i], i, 0);
			model.setValueAt(control.getType((String)list[i]), i, 1);
		}
		spCartas.setViewportView(new JTable(model));
	}
	
	private void fillTypesTables() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(1);
		model.setRowCount(control.getTypeSize("Monstruo"));
		model.setColumnIdentifiers(new String[] {"Monstruos"});
		Object[] list1 = control.getListType("Monstruo");
		Arrays.sort(list1);
		for (int i = 0;i< list1.length;i++) {
			model.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnCount(1);
		model1.setRowCount(control.getTypeSize("Hechizo"));
		model1.setColumnIdentifiers(new String[] {"Hechizos"});
		list1 =  control.getListType("Hechizo");
		Arrays.sort(list1);
		for (int i = 0;i< list1.length;i++) {
			model1.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.setColumnCount(1);
		model2.setRowCount(control.getTypeSize("Trampa"));
		model2.setColumnIdentifiers(new String[] {"Trampas"});
		list1 =  control.getListType("Trampa");
		Arrays.sort(list1);
		for (int i = 0;i< list1.length;i++) {
			model2.setValueAt(list1[i], i, 0);
		}
		
		spMonstruo.setViewportView(new JTable(model));
		spHechizo.setViewportView(new JTable(model1));
		spTrampa.setViewportView(new JTable(model2));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
