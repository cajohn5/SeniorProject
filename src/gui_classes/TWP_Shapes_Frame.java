package gui_classes;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;


import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class TWP_Shapes_Frame extends JFrame implements ActionListener{
	//list of all components of the frame
		private JPanel contentPane;
		
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		
	//creates the frame
		public TWP_Shapes_Frame() {
	//sets up the frame
			setTitle("Window");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 800, 600);
			setMinimumSize(new Dimension(1000,700));
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			contentPane.add(makeWindowPanel());
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			JPanel panel_6 = new JPanel();
			panel.add(panel_6);
			
			JLabel lblWindowTypeLabel = new JLabel("ThermalWeld Plus Shapes Series 8400");
			lblWindowTypeLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			panel_6.add(lblWindowTypeLabel);
			
			JPanel panel_1 = new JPanel();
			panel.add(panel_1);
			
			JLabel label_1 = new JLabel("Price");
			panel_1.add(label_1);
			
			JLabel lblxxxxxx = new JLabel("$XXXX.XX");
			panel_1.add(lblxxxxxx);
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
			
			
			
			
		}
		
	//This is the panel of the home tab
		protected JComponent makeWindowPanel() {
	        JPanel panel = new JPanel();
	        //panel.setLayout(new AbsoluteLayout(0,0));
	        panel.setLayout(null);
	        
	        JPanel panel_6 = new JPanel();
	        panel_6.setBorder(new TitledBorder(null, "Window Shape", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_6.setBounds(267, 52, 447, 57);
	        panel.add(panel_6);
	        panel_6.setLayout(null);
	        
	        JPanel panel_4 = new JPanel();
	        panel_4.setBounds(6, 16, 419, 30);
	        panel_6.add(panel_4);
	        panel_4.setLayout(null);
	        
	        JComboBox comboBox_4 = new JComboBox();
	        comboBox_4.setBounds(106, 11, 218, 20);
	        panel_4.add(comboBox_4);
	        comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Half Round", "Extended Leg Half Round", "Quarter Round", "Extended Leg Quarter Round", "Circle", "Octagon", "Hexagon", "Eyebrow", "Extended Leg Eyebrow", "Half Eyebrow", "Extended Leg Half Eyebrow", "Pentagon", "Pentagon - Left & Right", "Trapezoid", "Triangle"}));
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_3.setBounds(267, 120, 447, 452);
	        panel.add(panel_3);
	        panel_3.setLayout(null);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(5, 18, 437, 258);
	        panel_3.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JComboBox comboBox_8 = new JComboBox();
	        comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"Double Strength", "Tempered"}));
	        comboBox_8.setBounds(184, 79, 170, 20);
	        panel_1.add(comboBox_8);
	        
	        JComboBox comboBox_9 = new JComboBox();
	        comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Colonial V-Groove", "Colonial Woodgrain", "Contoured Woodgrain", "Contoured Painted"}));
	        comboBox_9.setBounds(184, 105, 170, 20);
	        panel_1.add(comboBox_9);
	        
	        JComboBox comboBox_10 = new JComboBox();
	        comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"Tan Only", "Brown Only", "Woodgrain Interior on White", "Woodgrain Interior on Tan", "Woodgrain Interior on Brown"}));
	        comboBox_10.setBounds(184, 137, 170, 20);
	        panel_1.add(comboBox_10);
	        
	        JLabel lblVinylColor = new JLabel("Vinyl Color");
	        lblVinylColor.setBounds(0, 137, 100, 20);
	        panel_1.add(lblVinylColor);
	        lblVinylColor.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JLabel lblGrid = new JLabel("Grid");
	        lblGrid.setBounds(0, 105, 100, 20);
	        panel_1.add(lblGrid);
	        lblGrid.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JLabel label_6 = new JLabel("Glass Strength");
	        label_6.setBounds(0, 79, 100, 20);
	        panel_1.add(label_6);
	        label_6.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JLabel label_11 = new JLabel("+$XX.XX");
	        label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
	        label_11.setBounds(372, 143, 53, 14);
	        panel_1.add(label_11);
	        
	        JLabel label_12 = new JLabel("+$XX.XX");
	        label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
	        label_12.setBounds(372, 111, 53, 14);
	        panel_1.add(label_12);
	        
	        JLabel label_13 = new JLabel("+$XX.XX");
	        label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
	        label_13.setBounds(372, 85, 53, 14);
	        panel_1.add(label_13);
	        
	        JLabel label_19 = new JLabel("+$XX.XX");
	        label_19.setFont(new Font("Tahoma", Font.BOLD, 11));
	        label_19.setBounds(372, 50, 53, 14);
	        panel_1.add(label_19);
	        
	        JComboBox comboBox_13 = new JComboBox();
	        comboBox_13.setModel(new DefaultComboBoxModel(new String[] {"Clear Glass", "Obscure", "Glue Chip", "Rain Glass"}));
	        comboBox_13.setBounds(184, 44, 170, 20);
	        panel_1.add(comboBox_13);
	        
	        JLabel label_21 = new JLabel("Glass");
	        label_21.setFont(new Font("Dialog", Font.PLAIN, 14));
	        label_21.setBounds(0, 44, 100, 20);
	        panel_1.add(label_21);
	        
	        JLabel label_2 = new JLabel("Window Color");
	        label_2.setBounds(0, 168, 97, 20);
	        panel_1.add(label_2);
	        label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JLabel lblWindowTint = new JLabel("Window Tint");
	        lblWindowTint.setBounds(0, 199, 97, 20);
	        panel_1.add(lblWindowTint);
	        lblWindowTint.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(184, 199, 170, 20);
	        panel_1.add(comboBox);
	        comboBox.setModel(new DefaultComboBoxModel(new String[] {"No Tint", "Bronze Tint", "Grey Tint"}));
	        
	        JComboBox comboBox_2 = new JComboBox();
	        comboBox_2.setBounds(184, 168, 170, 20);
	        panel_1.add(comboBox_2);
	        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"No Paint", "White", "Tan", "Black", "Brick Red", "Beige", "Bronze", "Brown", "Clay", "Gary", "Green", "Architectural Bronze"}));
	        
	        JLabel label_10 = new JLabel("+$XX.XX");
	        label_10.setBounds(372, 168, 53, 14);
	        panel_1.add(label_10);
	        label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
	        
	        JLabel label_18 = new JLabel("+$XX.XX");
	        label_18.setBounds(372, 199, 53, 14);
	        panel_1.add(label_18);
	        label_18.setFont(new Font("Tahoma", Font.BOLD, 11));
	        
	        JLabel label = new JLabel("Energy Options");
	        label.setFont(new Font("Dialog", Font.PLAIN, 14));
	        label.setBounds(0, 12, 100, 20);
	        panel_1.add(label);
	        
	        JComboBox comboBox_1 = new JComboBox();
	        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"energySMART\u00AESupreme 2", "energrySMART\u00AEXL 2", "energySMART\u00AEUltimate 2", "energySMART\u00AEUltimate 2 Plus (Kryton gas)", "Muntins"}));
	        comboBox_1.setBounds(184, 12, 170, 20);
	        panel_1.add(comboBox_1);
	        
	        JLabel label_1 = new JLabel("+$XX.XX");
	        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
	        label_1.setBounds(372, 18, 53, 14);
	        panel_1.add(label_1);
	        
	        JButton button = new JButton("Add");
	        button.setFont(new Font("Dialog", Font.BOLD, 14));
	        button.setBounds(868, 569, 83, 30);
	        panel.add(button);
	        
	        JPanel panel_4_1 = new JPanel();
	        panel_4_1.setBounds(10, 17, 107, 30);
	        panel.add(panel_4_1);
	        
	        JLabel label_17 = new JLabel("Windows Size");
	        panel_4_1.add(label_17);
	        label_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        
	        JPanel panel_2_1 = new JPanel();
	        panel_2_1.setBounds(129, 17, 162, 30);
	        panel.add(panel_2_1);
	        
	        JLabel label_2_1 = new JLabel("Width");
	        panel_2_1.add(label_2_1);
	        
	        textField = new JTextField("0");
	        panel_2_1.add(textField);
	        textField.setColumns(10);
	        
	        JPanel panel_3_1 = new JPanel();
	        panel_3_1.setBounds(296, 17, 165, 30);
	        panel.add(panel_3_1);
	        
	        JLabel label_3_1 = new JLabel("Height");
	        panel_3_1.add(label_3_1);
	        
	        textField_1 = new JTextField("0");
	        panel_3_1.add(textField_1);
	        textField_1.setColumns(10);
	        
	        JLabel lblMinDynamicMax = new JLabel("Min: Dynamic Max: Dynamic");
	        lblMinDynamicMax.setFont(new Font("Dialog", Font.PLAIN, 12));
	        lblMinDynamicMax.setBounds(173, 0, 93, 16);
	        panel.add(lblMinDynamicMax);
	        
	        JLabel lblMinDynamicMax_1 = new JLabel("Min: Dynamic Max: Dynamic");
	        lblMinDynamicMax_1.setFont(new Font("Dialog", Font.PLAIN, 12));
	        lblMinDynamicMax_1.setBounds(342, 0, 93, 16);
	        panel.add(lblMinDynamicMax_1);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBounds(471, 17, 162, 30);
	        panel.add(panel_2);
	        
	        JLabel lblBase = new JLabel("Base");
	        panel_2.add(lblBase);
	        
	        textField_2 = new JTextField("0");
	        textField_2.setColumns(10);
	        panel_2.add(textField_2);
	        
	        JLabel label_4 = new JLabel("Min: Dynamic Max: Dynamic");
	        label_4.setFont(new Font("Dialog", Font.PLAIN, 12));
	        label_4.setBounds(515, 0, 93, 16);
	        panel.add(label_4);
	        
	        JPanel panel_5 = new JPanel();
	        panel_5.setBounds(638, 17, 165, 30);
	        panel.add(panel_5);
	        
	        JLabel lblDiameter = new JLabel("Diameter");
	        panel_5.add(lblDiameter);
	        
	        textField_3 = new JTextField("0");
	        textField_3.setColumns(10);
	        panel_5.add(textField_3);
	        
	        JLabel label_7 = new JLabel("Min: Dynamic Max: Dynamic");
	        label_7.setFont(new Font("Dialog", Font.PLAIN, 12));
	        label_7.setBounds(684, 0, 93, 16);
	        panel.add(label_7);
	        
	        JPanel panel_7 = new JPanel();
	        panel_7.setBounds(813, 17, 151, 30);
	        panel.add(panel_7);
	        
	        JLabel lblLeg = new JLabel("Leg");
	        panel_7.add(lblLeg);
	        
	        textField_4 = new JTextField("0");
	        textField_4.setColumns(10);
	        panel_7.add(textField_4);
	        
	        JLabel label_9 = new JLabel("Min: Dynamic Max: Dynamic");
	        label_9.setFont(new Font("Dialog", Font.PLAIN, 12));
	        label_9.setBounds(859, 0, 93, 16);
	        panel.add(label_9);
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        return panel;
	        
	    }


		public void actionPerformed(ActionEvent e){
		}
	}
