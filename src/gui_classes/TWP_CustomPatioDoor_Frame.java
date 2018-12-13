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

public class TWP_CustomPatioDoor_Frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textField_1;
	
//creates the frame
	public TWP_CustomPatioDoor_Frame() {
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
		
		JLabel lblWindowTypeLabel = new JLabel("ThermalWeld Plus Vinyl Custom Patio Door Series 7480");
		lblWindowTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
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
        
        JLabel lblMinMax = new JLabel("Min: 36 Max: 96");
        lblMinMax.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblMinMax.setBounds(315, 38, 93, 16);
        panel.add(lblMinMax);
        
        JPanel panel_9 = new JPanel();
        panel_9.setBounds(155, 54, 107, 30);
        panel.add(panel_9);
        
        JLabel lblDoorSize = new JLabel("Door Size");
        lblDoorSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_9.add(lblDoorSize);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(439, 54, 165, 30);
        panel.add(panel_3);
        
        JLabel label_20 = new JLabel("Height");
        panel_3.add(label_20);
        
        textField = new JTextField("0");
        textField.setColumns(10);
        panel_3.add(textField);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBounds(272, 54, 162, 30);
        panel.add(panel_8);
        
        JLabel label_23 = new JLabel("Width");
        panel_8.add(label_23);
        
        textField_1 = new JTextField("0");
        textField_1.setColumns(10);
        panel_8.add(textField_1);
        
        JLabel lblMinMax_1 = new JLabel("Min: 30 Max: 84");
        lblMinMax_1.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblMinMax_1.setBounds(485, 38, 93, 16);
        panel.add(lblMinMax_1);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Grid Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(490, 130, 467, 116);
        panel.add(panel_6);
        panel_6.setLayout(null);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(6, 16, 449, 89);
        panel_6.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblGridOptionsSash = new JLabel("Sash 1");
        lblGridOptionsSash.setBounds(0, 0, 100, 20);
        panel_4.add(lblGridOptionsSash);
        lblGridOptionsSash.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setBounds(100, 0, 120, 20);
        panel_4.add(comboBox_3);
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"None", "Flat", "Flat Woodgrain", "Flat Antique Brass", "Contoured", "Cont. Woodgrain", "Cont. Painted", "Contoured Woodgrain Painted", "Slimline Brass", "V-Groove"}));
        
        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setBounds(230, 0, 120, 20);
        panel_4.add(comboBox_4);
        comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Colonial", "Prairie/Double Prairie", "Diamond", "Floral/Elongated Floral", "Arch"}));
        
        JLabel lblGridOptionsSash_1 = new JLabel("Sash 2");
        lblGridOptionsSash_1.setBounds(0, 35, 100, 20);
        panel_4.add(lblGridOptionsSash_1);
        lblGridOptionsSash_1.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox comboBox_5 = new JComboBox();
        comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"None", "Flat", "Flat Woodgrain", "Flat Antique Brass", "Contoured", "Cont. Woodgrain", "Cont. Painted", "Contoured Woodgrain Painted", "Slimline Brass", "V-Groove"}));
        comboBox_5.setBounds(100, 35, 120, 20);
        panel_4.add(comboBox_5);
        
        JComboBox comboBox_6 = new JComboBox();
        comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Colonial", "Prairie/Double Prairie", "Diamond", "Floral/Elongated Floral", "Arch"}));
        comboBox_6.setBounds(230, 35, 120, 20);
        panel_4.add(comboBox_6);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Same for both Sash");
        chckbxNewCheckBox.setBounds(10, 62, 150, 23);
        panel_4.add(chckbxNewCheckBox);
        chckbxNewCheckBox.setSelected(true);
        
        JLabel label_8 = new JLabel("+$XX.XX");
        label_8.setBounds(360, 3, 53, 14);
        panel_4.add(label_8);
        
        JLabel label_9 = new JLabel("+$XX.XX");
        label_9.setBounds(360, 38, 53, 14);
        panel_4.add(label_9);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(484, 257, 480, 301);
        panel.add(panel_7);
        panel_7.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 16, 377, 119);
        panel_7.add(panel_2);
        panel_2.setLayout(null);
        
        JCheckBox chckbxPolyfoamWrap = new JCheckBox("Two-Point Multi Point Locking System");
        chckbxPolyfoamWrap.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxPolyfoamWrap.setBounds(-2, 33, 261, 23);
        panel_2.add(chckbxPolyfoamWrap);
        
        JCheckBox chckbxFoamFilledMain = new JCheckBox("Foam Filled Main Frame & Sash");
        chckbxFoamFilledMain.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxFoamFilledMain.setBounds(-2, 7, 227, 23);
        panel_2.add(chckbxFoamFilledMain);
        
        JLabel lblxxxx = new JLabel("+$XX.XX");
        lblxxxx.setBounds(265, 39, 55, 14);
        panel_2.add(lblxxxx);
        
        JLabel label = new JLabel("+$XX.XX");
        label.setBounds(231, 13, 55, 14);
        panel_2.add(label);
        
        JCheckBox chckbxThreepointMultiPoint = new JCheckBox("Three-Point Multi Point Locking System");
        chckbxThreepointMultiPoint.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxThreepointMultiPoint.setBounds(-2, 59, 273, 23);
        panel_2.add(chckbxThreepointMultiPoint);
        
        JLabel label_1 = new JLabel("+$XX.XX");
        label_1.setBounds(275, 65, 55, 14);
        panel_2.add(label_1);
        
        JCheckBox chckbxLaminatedGlassFilm = new JCheckBox("Laminated Glass(0.30 film thickness)");
        chckbxLaminatedGlassFilm.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxLaminatedGlassFilm.setBounds(-2, 85, 261, 23);
        panel_2.add(chckbxLaminatedGlassFilm);
        
        JLabel label_6 = new JLabel("+$XX.XX");
        label_6.setBounds(265, 91, 55, 14);
        panel_2.add(label_6);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(13, 129, 467, 470);
        panel.add(panel_5);
        panel_5.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(6, 16, 449, 423);
        panel_5.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel label_3 = new JLabel("Energy Options");
        label_3.setBounds(0, 0, 100, 20);
        panel_1.add(label_3);
        label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox comboBox_7 = new JComboBox();
        comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"energySMART\u00AESupreme 2", "energySMART\u00AESupreme 2 Triple", "energySMART\u00AEXL 2", "energySMART\u00AEUltimate 2", "energySMART\u00AEUltimate 2 Plus"}));
        comboBox_7.setBounds(199, 0, 170, 20);
        panel_1.add(comboBox_7);
        
        JComboBox comboBox_8 = new JComboBox();
        comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"Standard Screen", "Upgrade Screen Series 1350", "Upgrade Screen Series 1580"}));
        comboBox_8.setBounds(199, 64, 170, 20);
        panel_1.add(comboBox_8);
        
        JComboBox comboBox_9 = new JComboBox();
        comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Aluminum", "Intercept Stainless"}));
        comboBox_9.setBounds(199, 129, 170, 20);
        panel_1.add(comboBox_9);
        
        JLabel label_5 = new JLabel("Spacer");
        label_5.setBounds(0, 129, 100, 20);
        panel_1.add(label_5);
        label_5.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel lblScreen = new JLabel("Screen");
        lblScreen.setBounds(0, 64, 100, 20);
        panel_1.add(lblScreen);
        lblScreen.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel label_12 = new JLabel("+$XX.XX");
        label_12.setBounds(387, 129, 50, 14);
        panel_1.add(label_12);
        
        JLabel label_13 = new JLabel("+$XX.XX");
        label_13.setBounds(387, 64, 50, 14);
        panel_1.add(label_13);
        
        JLabel label_14 = new JLabel("+$XX.XX");
        label_14.setBounds(387, 0, 50, 14);
        panel_1.add(label_14);
        
        JComboBox comboBox_13 = new JComboBox();
        comboBox_13.setModel(new DefaultComboBoxModel(new String[] {"Clear Glass", "Obscure", "Glue Chip", "Rain Glass"}));
        comboBox_13.setBounds(199, 31, 170, 20);
        panel_1.add(comboBox_13);
        
        JLabel label_19 = new JLabel("+$XX.XX");
        label_19.setBounds(387, 31, 50, 14);
        panel_1.add(label_19);
        
        JLabel lblGlass = new JLabel("Glass");
        lblGlass.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblGlass.setBounds(0, 31, 100, 20);
        panel_1.add(lblGlass);
        
        JLabel label_4 = new JLabel("+$XX.XX");
        label_4.setBounds(387, 160, 50, 14);
        panel_1.add(label_4);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"No Tint", "Bronze Tint", "Grey Tint"}));
        comboBox_1.setBounds(199, 160, 170, 20);
        panel_1.add(comboBox_1);
        
        JLabel label_10 = new JLabel("Window Tint");
        label_10.setFont(new Font("Dialog", Font.PLAIN, 14));
        label_10.setBounds(0, 160, 89, 20);
        panel_1.add(label_10);
        
        JLabel lblHardwareColor = new JLabel("Handle Color");
        lblHardwareColor.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblHardwareColor.setBounds(0, 222, 100, 20);
        panel_1.add(lblHardwareColor);
        
        JComboBox comboBox_10 = new JComboBox();
        comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"White", "Tan", "CopperTone", "Polished Brass", "Antique Brass", "Satin Nickel", "Aged Bronze"}));
        comboBox_10.setBounds(199, 222, 170, 20);
        panel_1.add(comboBox_10);
        
        JLabel label_15 = new JLabel("+$XX.XX");
        label_15.setBounds(387, 222, 50, 14);
        panel_1.add(label_15);
        
        JLabel lblMull = new JLabel("Screen Mesh Upgrade");
        lblMull.setBounds(0, 98, 149, 20);
        panel_1.add(lblMull);
        lblMull.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel label_16 = new JLabel("+$XX.XX");
        label_16.setBounds(387, 95, 50, 14);
        panel_1.add(label_16);
        
        JComboBox comboBox_11 = new JComboBox();
        comboBox_11.setBounds(199, 95, 170, 20);
        panel_1.add(comboBox_11);
        comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Normal Screen Mesh", "Aluminum Screen Mesh", "BetterVue Screen Mesh", "Pet Screen Mesh"}));
        
        JLabel lblFrame = new JLabel("Exterior Paint");
        lblFrame.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblFrame.setBounds(0, 191, 100, 20);
        panel_1.add(lblFrame);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"No Paint", "White", "Tan", "Black", "Brick Red", "Beige", "Bronze", "Brown", "Clay", "Gray", "Green", "Architectural Bronze"}));
        comboBox.setBounds(199, 191, 170, 20);
        panel_1.add(comboBox);
        
        JLabel label_2 = new JLabel("+$XX.XX");
        label_2.setBounds(387, 191, 50, 14);
        panel_1.add(label_2);
        
        JLabel lblWoodgrain = new JLabel("Woodgrain");
        lblWoodgrain.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblWoodgrain.setBounds(0, 253, 100, 20);
        panel_1.add(lblWoodgrain);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Medium Oak", "Dark Oak", "Vintage Pecan", "Cherry"}));
        comboBox_2.setBounds(199, 253, 170, 20);
        panel_1.add(comboBox_2);
        
        JLabel label_11 = new JLabel("+$XX.XX");
        label_11.setBounds(387, 253, 50, 14);
        panel_1.add(label_11);
        
        JLabel lblFrameColor = new JLabel("Frame Color");
        lblFrameColor.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblFrameColor.setBounds(0, 284, 100, 20);
        panel_1.add(lblFrameColor);
        
        JComboBox comboBox_12 = new JComboBox();
        comboBox_12.setModel(new DefaultComboBoxModel(new String[] {"White(W)", "Woodgrain(W)", "Tan(T)", "Woodgrain(T)"}));
        comboBox_12.setBounds(199, 284, 170, 20);
        panel_1.add(comboBox_12);
        
        JLabel label_17 = new JLabel("+$XX.XX");
        label_17.setBounds(387, 284, 50, 14);
        panel_1.add(label_17);
        
        JButton button = new JButton("Add");
        button.setFont(new Font("Dialog", Font.BOLD, 14));
        button.setBounds(868, 569, 83, 30);
        panel.add(button);
        
        JPanel panel_12 = new JPanel();
        panel_12.setBounds(614, 54, 93, 30);
        panel.add(panel_12);
        
        JLabel lblPanels = new JLabel("Panels");
        panel_12.add(lblPanels);
        
        JComboBox comboBox_14 = new JComboBox();
        comboBox_14.setModel(new DefaultComboBoxModel(new String[] {"2", "3"}));
        panel_12.add(comboBox_14);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        return panel;
        
    }


	public void actionPerformed(ActionEvent e){
	}
}
