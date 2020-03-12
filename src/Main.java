/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import org.w3c.dom.events.DocumentEvent;

/**
 *
 * @author Alfredo Quezada
 * @author Estefania Barrio
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private JFrame frame;
	private MapsController control;
	private JRadioButton rdbtnTreemap,rdbtnNewRadioButton,rdbtnLinkedhashmap;
	private JPanel Choose,Principal;
	private JButton NButton_1;
	private final JPanel panel_list;
	private final JScrollPane Cartas;
	private final JScrollPane Hechizo;
	private final JScrollPane Trampa;
	private final JScrollPane Monstruo;
        private final JScrollPane MonUsuario;
	private final JScrollPane HechiUsuario;
	private final JScrollPane carUsuario;
	private final JScrollPane TramUsuario;
        private final TextAutoCompleter auto;
        private TextAutoCompleter auto1;
	private JTextField Especifico;
	private final JLabel Tipo;
	private final JLabel TipoP;
	private final JPanel panel_3;
	private JTextField aggCartaUsuario;
	private final JLabel AggCar;
	private final JLabel c1;
	private final JLabel c2;
	private final JLabel c3;
	private final JLabel c4;
	private final JLabel c5;
	private final JLabel c6;
	private final JLabel c7;
	private final JLabel c8;
	private final JLabel lblNewLabel_1;
	private final JLabel lblGeneral;
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
    private Object cartasUsuario;

	/**
	 * Create the application.
	 */
	public Main() {
		control = new MapsController();
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 850);
                frame.setTitle("HASHMAPS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		Choose = new JPanel();
		Choose.setBackground(Color.GRAY);
                Choose.setBounds(100, 100, 1300, 850);
		frame.getContentPane().add(Choose, "name_20000000000");
		Choose.setLayout(null);
		
             
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(357, 216, 379, 253);
		Choose.add(panel);
		panel.setLayout(null);
		//se crea el panel de la seleccion 
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (!rdbtnNewRadioButton.isSelected() && !rdbtnTreemap.isSelected() && !rdbtnLinkedhashmap.isSelected()) {
					JOptionPane.showMessageDialog(null, "Tienes que seleccionar alguno, sino no sirve :( ");
				}else {
					if (rdbtnNewRadioButton.isSelected()) {
						control.setMap("HashMap");
					}else if (rdbtnTreemap.isSelected()) {
						control.setMap("TreeMap");
					}else if (rdbtnLinkedhashmap.isSelected()) {
						control.setMap("LinkedHashMap");
					}
					Principal.setVisible(true);
					Choose.setVisible(false);
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(136, 200, 97, 25);
		panel.add(btnNewButton);
		
		rdbtnNewRadioButton = new JRadioButton("HashMap");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
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
		rdbtnTreemap.setBackground(Color.WHITE);
		rdbtnTreemap.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		rdbtnTreemap.setBounds(106, 89, 127, 25);
		panel.add(rdbtnTreemap);
		
		rdbtnLinkedhashmap = new JRadioButton("LinkedHashMap");
		rdbtnLinkedhashmap.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnTreemap.setSelected(false);
				
			}
		});
		rdbtnLinkedhashmap.setBackground(Color.WHITE);
		rdbtnLinkedhashmap.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		rdbtnLinkedhashmap.setBounds(106, 130, 193, 25);
		panel.add(rdbtnLinkedhashmap);
		
		Principal = new JPanel();
		Principal.setBackground(Color.GRAY);
		frame.getContentPane().add(Principal, "name_20000000001");
		Principal.setLayout(null);
		
		NButton_1 = new JButton("Leer Archivo");
		NButton_1.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		NButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				control.fillMap();
	
				AutoCompleteFill();
				setCardTable();
				fillTypesTables();
				setCardTableUsuario();
				fillTypesTablesUser();
				UpdateSizes();
				
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "No se pudo leer el archivo txt");
				}
			}
		});
                //Comienza la creacion y deficiion de los paneles para que se 
                //puedan visualizar los datos de txt 
		NButton_1.setBounds(12, 13, 155, 39);
		Principal.add(NButton_1);
		
		panel_list = new JPanel();
		panel_list.setBackground(Color.WHITE);

		panel_list.setBounds(22, 75, 1235, 685);
		Principal.add(panel_list);
		panel_list.setLayout(null);
		
		Cartas = new JScrollPane();
		Cartas.setBounds(12, 169, 411, 219);
		panel_list.add(Cartas);
		
		carUsuario = new JScrollPane();
		carUsuario.setBounds(12, 453, 411, 219);
		panel_list.add(carUsuario);
		
		Monstruo = new JScrollPane();
		Monstruo.setBounds(449, 169, 247, 219);
		panel_list.add(Monstruo);
		
		Hechizo = new JScrollPane();
		Hechizo.setBounds(708, 169, 247, 219);
		panel_list.add(Hechizo);
		
		Trampa = new JScrollPane();
		Trampa.setBounds(967, 169, 247, 219);
		panel_list.add(Trampa);
		
		MonUsuario = new JScrollPane();
		MonUsuario.setBounds(449, 453, 247, 219);
		panel_list.add(MonUsuario);
		
		HechiUsuario = new JScrollPane();
		HechiUsuario.setBounds(708, 453, 247, 219);
		panel_list.add(HechiUsuario);
		
		TramUsuario = new JScrollPane();
		TramUsuario.setBounds(967, 453, 247, 219);
		panel_list.add(TramUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(12, 13, 419, 95);
		panel_list.add(panel_2);
		panel_2.setLayout(null);
		
		TipoP = new JLabel("");
		TipoP.setBounds(243, 45, 145, 32);
		panel_2.add(TipoP);
		TipoP.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		
		Especifico = new JTextField();
		Especifico.setBounds(12, 45, 199, 32);
		panel_2.add(Especifico);
		Especifico.setColumns(10);
		auto = new TextAutoCompleter(Especifico);
		
		JLabel lblNewLabel = new JLabel("Carta Escogida");
		lblNewLabel.setBounds(12, 0, 134, 32);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 18));
		
		Tipo = new JLabel("Tipo");
		Tipo.setBounds(243, 0, 52, 32);
		panel_2.add(Tipo);
		Tipo.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(498, 13, 351, 95);
		panel_list.add(panel_3);
		
		aggCartaUsuario = new JTextField();
		aggCartaUsuario.setColumns(10);
		aggCartaUsuario.setBounds(12, 45, 205, 32);
		panel_3.add(aggCartaUsuario);
                auto1 = new TextAutoCompleter(aggCartaUsuario);
		
		AggCar = new JLabel("Agregar Carta");
		AggCar.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		AggCar.setBounds(12, 0, 205, 32);
		panel_3.add(AggCar);
		
		JButton btnNewButton_2 = new JButton("Agregar");
		btnNewButton_2.addActionListener((ActionEvent arg0) -> {
                    if(!aggCartaUsuario.getText().isEmpty()) {
                        control.insertCard(aggCartaUsuario.getText());
                        aggCartaUsuario.setText(null);
                        setCardTable();
                        fillTypesTables();
                        setCardTableUsuario();
                        fillTypesTablesUser();
                        UpdateSizes();
                        
                    }
                });
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(236, 49, 97, 25);
		panel_3.add(btnNewButton_2);
		
		c1 = new JLabel("Existe:");
		c1.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c1.setBounds(162, 129, 165, 27);
		panel_list.add(c1);
		
		c2 = new JLabel("Existe:");
		c2.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c2.setBounds(508, 129, 144, 27);
		panel_list.add(c2);
		
		c3 = new JLabel("Existe:");
		c3.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c3.setBounds(766, 129, 165, 27);
		panel_list.add(c3);
		
		c4 = new JLabel("Existe:");
		c4.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c4.setBounds(1034, 129, 151, 27);
		panel_list.add(c4);
		
		c5 = new JLabel("Existen:");
		c5.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c5.setBounds(162, 413, 165, 27);
		panel_list.add(c5);
		
		c6 = new JLabel("Existe:");
		c6.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c6.setBounds(516, 413, 136, 27);
		panel_list.add(c6);
		
		c7 = new JLabel("Existe:");
		c7.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c7.setBounds(766, 413, 144, 27);
		panel_list.add(c7);
		
		c8 = new JLabel("Existe:");
		c8.setFont(new Font("True", Font.TRUETYPE_FONT, 18));
		c8.setBounds(1034, 413, 151, 27);
		panel_list.add(c8);
		
		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("True", Font.TRUETYPE_FONT, 14));
		lblNewLabel_1.setBounds(12, 413, 84, 27);
		panel_list.add(lblNewLabel_1);
		
		lblGeneral = new JLabel("En el Mazo:");
		lblGeneral.setFont(new Font("True", Font.TRUETYPE_FONT, 14));
		lblGeneral.setBounds(12, 135, 84, 27);
		panel_list.add(lblGeneral);
		Especifico.getDocument().addDocumentListener(new MyDocumentListener());
    }
	
	private void UpdateSizes() {
		c1.setText("Cantidad: " + control.getMapSize());
		c2.setText("Cantidad: " + control.getTypeSize("Monstruo"));
		c3.setText("Cantidad: " + control.getTypeSize("Hechizo"));
		c4.setText("Cantidad: " + control.getTypeSize("Trampa"));
		
		c5.setText("Cantidad: " + control.getMapSizeUser());
		c6.setText("Cantidad: " + control.getTypeSizeUser("Monstruo"));
		c7.setText("Cantidad: " + control.getTypeSizeUser("Hechizo"));
		c8.setText("Cantidad: " + control.getTypeSizeUser("Trampa"));
	}
	
	private void AutoCompleteFill() {
		Object[] data = control.getKeys();
		for (Object l : data) {
			auto.addItem(l);
		}
		
	}
	
	private void setCardTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(2);
		model.setColumnIdentifiers(new String[] {"Carta","Tipo"});
		model.setRowCount(control.getMapSize());
		Object[] list = control.getKeysMap();
		
		for (int i = 0;i< list.length;i++) {
			model.setValueAt(list[i], i, 0);
			model.setValueAt(control.getType((String)list[i]), i, 1);
		}
		Cartas.setViewportView(new JTable(model));
	}
	
	private void fillTypesTables() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(1);
		model.setRowCount(control.getTypeSize("Monstruo"));
		model.setColumnIdentifiers(new String[] {"Monstruos"});
		Object[] list1 = control.getListType("Monstruo");
		
		for (int i = 0;i< list1.length;i++) {
			model.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnCount(1);
		model1.setRowCount(control.getTypeSize("Hechizo"));
		model1.setColumnIdentifiers(new String[] {"Hechizos"});
		list1 =  control.getListType("Hechizo");
		
		for (int i = 0;i< list1.length;i++) {
			model1.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.setColumnCount(1);
		model2.setRowCount(control.getTypeSize("Trampa"));
		model2.setColumnIdentifiers(new String[] {"Trampas"});
		list1 =  control.getListType("Trampa");
		
		for (int i = 0;i< list1.length;i++) {
			model2.setValueAt(list1[i], i, 0);
		}
		
		Monstruo.setViewportView(new JTable(model));
		Hechizo.setViewportView(new JTable(model1));
		Trampa.setViewportView(new JTable(model2));
		
	}
	
	
	private void setCardTableUsuario() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(2);
		model.setColumnIdentifiers(new String[] {"Carta","Tipo"});
		model.setRowCount(control.getMapSizeUser());
		Object[] list =  (Object[]) control.getUserKeysOrderedByValue();
		
		for (int i = 0;i< list.length;i++) {
			model.setValueAt(list[i], i, 0);
			model.setValueAt(control.getType((String)list[i]), i, 1);
		}
		cartasUsuario.setViewportView(new JTable(model));
	}
	
	
	
	private void fillTypesTablesUser() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(1);
		model.setRowCount(control.getTypeSizeUser("Monstruo"));
		model.setColumnIdentifiers(new String[] {"Monstruos"});
		Object[] list1 = control.getListTypeUser("Monstruo");
		
		for (int i = 0;i< list1.length;i++) {
			model.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnCount(1);
		model1.setRowCount(control.getTypeSizeUser("Hechizo"));
		model1.setColumnIdentifiers(new String[] {"Hechizos"});
		list1 =  control.getListTypeUser("Hechizo");
		
		for (int i = 0;i< list1.length;i++) {
			model1.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.setColumnCount(1);
		model2.setRowCount(control.getTypeSizeUser("Trampa"));
		model2.setColumnIdentifiers(new String[] {"Trampas"});
		list1 =  control.getListTypeUser("Trampa");
		
		for (int i = 0;i< list1.length;i++) {
			model2.setValueAt(list1[i], i, 0);
		}
		
		MonUsuario.setViewportView(new JTable(model));
		HechiUsuario.setViewportView(new JTable(model1));
		TramUsuario.setViewportView(new JTable(model2));
	}
	
	
          //El listener daba error, entonces se creo una clase privada
	private class MyDocumentListener implements DocumentListener {
	 
	    public void insertUpdate(DocumentEvent e) {
	        String s = control.getType(Especifico.getText());
	        if (s != null) {
	        	Tipo.setText(s);
	        }else {
	        	Tipo.setText("");
	        }
	    }
	    public void removeUpdate(DocumentEvent e) {
	    	 String s = control.getType(Especifico.getText());
		        if (s != null) {
		        	Tipo.setText(s);
		        }else {
		        	Tipo.setText("");
		        }
	    }
	    public void changedUpdate(DocumentEvent e) {
	        //Plain text components do not fire these events
	    	 String s = control.getType(Especifico.getText());
		        if (s != null) {
		        	Tipo.setText(s);
		        }else {
		        	Tipo.setText("");
		        }
	    }

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
	}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

            }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

//LInks de referencia
//https://stackoverflow.com/questions/2427815/java-how-to-register-a-listener-that-listen-to-a-jframe-movement
//https://stackoverflow.com/questions/37200431/how-do-you-add-a-text-field-to-a-jpanel-that-is-drawn-onto-a-jframe
//https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
//https://stackoverflow.com/questions/14849176/implementing-auto-complete-in-java-am-i-doing-it-right
//https://stackabuse.com/example-adding-autocomplete-to-jtextfield/