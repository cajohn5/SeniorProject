package gui_classes;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import excel_reader_classes.MasterExcelReading;
import product_classes.Holder;
import product_classes.Windows;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UW_Casement2_Frame_Backup extends JFrame implements ActionListener{
	//list of all components of the frame
		private JPanel contentPane;
		
		private JTextField widthText;
		private JTextField heightText;
		private double energyCost = 0;
		private double glassTypeCost = 0;
		private double glassStrengthCost = 0;
		private double spaceCost = 0;
		private double screenCost = 0;
		private double meshCost = 0;
		private double winColorCost = 0;
		private double winTintCost = 0;
		private double reinforcementCost = 0;
		private double mullCost = 0;
		private double lockColorCost = 0;
		private double tiltMiniblindsCost = 0;
		private double frameColorCost = 0;
		private double woodgrainCost = 0;
		private double foamCost = 0;
		private double wrapCost = 0;
		private double lamCost = 0;
		private double trimGroove1Cost = 0;
		private double trimGroove2Cost = 0;
		private double trimGroove3Cost = 0;
		private double wocdCost = 0;
		private double sash1Cost = 0;
		private double sash2Cost = 0;
		private double totalCost = 0;
		private Holder holder = new Holder();
		private Float ui = (float) 0;
		private int index;
		private Windows obj;
		private MasterExcelReading mer = new MasterExcelReading();
		{
		
		try
			{
				mer.returnUpdatedHolder(holder);
			}
		catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JLabel totalLabel = new JLabel("$0.00");
		
	//creates the frame
		public UW_Casement2_Frame_Backup(int index) {
			index = holder.getProductIndex(index);
			obj = ((Windows) holder.getUltraWeld().get(index));
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
			
			JLabel lblWindowTypeLabel = new JLabel(obj.getProductName());
			lblWindowTypeLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			panel_6.add(lblWindowTypeLabel);
			
			JPanel panel_1 = new JPanel();
			panel.add(panel_1);
			
			JLabel label_1 = new JLabel("Price");
			panel_1.add(label_1);
			
			panel_1.add(totalLabel);
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
			
			
			
			
		}
		private void calcTotalCost() {
			totalCost = energyCost +glassTypeCost +glassStrengthCost +spaceCost +screenCost +meshCost +winColorCost +winTintCost +reinforcementCost +mullCost +lockColorCost +tiltMiniblindsCost +frameColorCost +woodgrainCost +foamCost +wrapCost +lamCost +trimGroove1Cost +trimGroove2Cost +trimGroove3Cost +wocdCost +sash1Cost +sash2Cost ;
			totalLabel.setText("$"+String.format("%.2f", totalCost));
			}
		private void calcUI() {
			ui = Float.valueOf(widthText.getText())+Float.valueOf(heightText.getText());
			}
	//This is the panel of the home tab
		protected JComponent makeWindowPanel() {
			  JPanel panel = new JPanel();
		        //panel.setLayout(new AbsoluteLayout(0,0));
		        panel.setLayout(null);
		        
		        JPanel panel_6 = new JPanel();
		        panel_6.setBorder(new TitledBorder(null, "Grid Options Per Sash", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		        panel_6.setBounds(12, 51, 447, 108);
		        panel.add(panel_6);
		        panel_6.setLayout(null);
		        
		        JPanel panel_4 = new JPanel();
		        panel_4.setBounds(6, 16, 419, 85);
		        panel_6.add(panel_4);
		        panel_4.setLayout(null);
		        
		        JLabel lblGridOptionsSash = new JLabel("Sash 1");
		        lblGridOptionsSash.setBounds(0, 0, 100, 20);
		        panel_4.add(lblGridOptionsSash);
		        lblGridOptionsSash.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JComboBox comboBox_3 = new JComboBox();
		        comboBox_3.setBounds(100, 0, 120, 20);
		        panel_4.add(comboBox_3);
		        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"None", "Flat", "Flat Woodgrain", "Flat Antique Brass", "Satin Nickel", "Contoured", "Cont. Woodgrain", "Cont. Painted", "Contoured Woodgrain Painted", "Slimline Brass", "V-Groove"}));
		        
		        JComboBox comboBox_4 = new JComboBox();
		        comboBox_4.setBounds(230, 0, 120, 20);
		        panel_4.add(comboBox_4);
		        comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Colonial", "Prairie/Double Prairie", "Diamond", "Floral/Elongated Floral"}));
		        
		        JLabel lblGridOptionsSash_1 = new JLabel("Sash 2");
		        lblGridOptionsSash_1.setBounds(0, 35, 100, 20);
		        panel_4.add(lblGridOptionsSash_1);
		        lblGridOptionsSash_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JComboBox comboBox_5 = new JComboBox();
		        comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"None", "Flat", "Flat Woodgrain", "Flat Antique Brass", "Satin Nickel", "Contoured", "Cont. Woodgrain", "Cont. Painted", "Contoured Woodgrain Painted", "Slimline Brass", "V-Groove"}));
		        comboBox_5.setBounds(100, 35, 120, 20);
		        panel_4.add(comboBox_5);
		        
		        JComboBox comboBox_6 = new JComboBox();
		        comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Colonial", "Prairie/Double Prairie", "Diamond", "Floral/Elongated Floral"}));
		        comboBox_6.setBounds(230, 35, 120, 20);
		        panel_4.add(comboBox_6);
		        
		        JCheckBox chckbxNewCheckBox = new JCheckBox("Same for both Sash");
		        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		        chckbxNewCheckBox.setBounds(10, 62, 135, 23);
		        panel_4.add(chckbxNewCheckBox);
		        chckbxNewCheckBox.setSelected(true);
		        
		        JLabel label_8 = new JLabel("+$XX.XX");
		        label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        label_8.setBounds(360, 3, 52, 14);
		        panel_4.add(label_8);
		        
		        JLabel label_9 = new JLabel("+$XX.XX");
		        label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        label_9.setBounds(360, 38, 52, 14);
		        panel_4.add(label_9);
		        
		        JPanel panel_7 = new JPanel();
		        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		        panel_7.setBounds(471, 51, 480, 301);
		        panel.add(panel_7);
		        panel_7.setLayout(null);
		        
		        JPanel panel_2 = new JPanel();
		        panel_2.setBounds(6, 16, 462, 272);
		        panel_7.add(panel_2);
		        panel_2.setLayout(null);
		        
		        JCheckBox chckbxPolyfoamWrap = new JCheckBox(obj.getCustomExtrasList().get(5));
		        chckbxPolyfoamWrap.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxPolyfoamWrap.setBounds(6, 125, 390, 23);
		        panel_2.add(chckbxPolyfoamWrap);
		        
		        JCheckBox chckbxWindowOpeningControl = new JCheckBox(obj.getCustomExtrasList().get(4));
		        chckbxWindowOpeningControl.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxWindowOpeningControl.setBounds(6, 151, 390, 23);
		        panel_2.add(chckbxWindowOpeningControl);
		        
		        JLabel wocdLabel = new JLabel("+$XX.XX");
		        
		        wocdLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        wocdLabel.setBounds(402, 157, 58, 14);
		        panel_2.add(wocdLabel);
		        JCheckBox chckbxFoamFilledMain = new JCheckBox(obj.getCustomExtrasList().get(0));

		        chckbxFoamFilledMain.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxFoamFilledMain.setBounds(6, 7, 390, 23);
		        panel_2.add(chckbxFoamFilledMain);
		        
		        JCheckBox chckbxLaminated = new JCheckBox(obj.getCustomExtrasList().get(6));
		        chckbxLaminated.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxLaminated.setBounds(6, 99, 390, 23);
		        panel_2.add(chckbxLaminated);
		        
		        JLabel wrapLabel = new JLabel("+$XX.XX");
		        wrapLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        wrapLabel.setBounds(402, 131, 58, 14);
		        panel_2.add(wrapLabel);
		        
		        JLabel foamLabel = new JLabel("+$XX.XX");
		        foamLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        foamLabel.setBounds(402, 13, 58, 14);
		        panel_2.add(foamLabel);
		        
		        JLabel lamLabel = new JLabel("+$XX.XX");
		        lamLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        lamLabel.setBounds(402, 105, 58, 14);
		        panel_2.add(lamLabel);
		        
		        JLabel trimGroove1Label = new JLabel("+$XX.XX");
		        trimGroove1Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        trimGroove1Label.setBounds(402, 37, 58, 14);
		        panel_2.add(trimGroove1Label);
		        
		        JCheckBox chckbxTrimGroove = new JCheckBox(obj.getCustomExtrasList().get(1));

		        chckbxTrimGroove.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxTrimGroove.setBounds(6, 31, 390, 23);
		        panel_2.add(chckbxTrimGroove);
		        
		        JLabel trimGroove2Label = new JLabel("+$XX.XX");
		        trimGroove2Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        trimGroove2Label.setBounds(402, 62, 58, 14);
		        panel_2.add(trimGroove2Label);
		        
		        JCheckBox chckbxTrimGroove_1 = new JCheckBox(obj.getCustomExtrasList().get(2));

		        chckbxTrimGroove_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxTrimGroove_1.setBounds(6, 54, 390, 23);
		        panel_2.add(chckbxTrimGroove_1);
		        
		        JLabel trimGroove3Label = new JLabel("+$XX.XX");
		        trimGroove3Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        trimGroove3Label.setBounds(402, 87, 58, 14);
		        panel_2.add(trimGroove3Label);
		        
		        JCheckBox chckbxTrimGroove_2 = new JCheckBox(obj.getCustomExtrasList().get(3));
		        chckbxTrimGroove_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxTrimGroove_2.setBounds(6, 79, 390, 23);
		        panel_2.add(chckbxTrimGroove_2);
		        
		        JCheckBox checkBox_1 = new JCheckBox("7878 Trim Groove INSTALLED Interior & Exterior");
		        checkBox_1.setBounds(6, 170, 257, 23);
		        panel_7.add(checkBox_1);
		        
		        JLabel label_31 = new JLabel("+$XX.XX");
		        label_31.setBounds(269, 174, 46, 14);
		        panel_7.add(label_31);
		        
		        JPanel panel_3 = new JPanel();
		        panel_3.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		        panel_3.setBounds(12, 160, 447, 452);
		        panel.add(panel_3);
		        panel_3.setLayout(null);
		        
		        JPanel panel_5 = new JPanel();
		        panel_5.setBounds(5, 203, 437, 122);
		        panel_3.add(panel_5);
		        panel_5.setLayout(null);
		        
		        JComboBox exteriorPaintList = new JComboBox(new Vector(obj.getExteriorPaintList()));
		        exteriorPaintList.setBounds(184, 0, 170, 20);
		        panel_5.add(exteriorPaintList);
		        
		        JLabel exteriorPaintLabel = new JLabel(obj.getExteriorPaintLabel());
		        exteriorPaintLabel.setBounds(0, 0, 174, 20);
		        panel_5.add(exteriorPaintLabel);
		        exteriorPaintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JLabel exteriorPaintCostLabel = new JLabel("+$XX.XX");
		        exteriorPaintCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        exteriorPaintCostLabel.setBounds(372, 0, 53, 14);
		        panel_5.add(exteriorPaintCostLabel);
		        
		        JLabel glassTintCostLabel = new JLabel("+$XX.XX");
		        glassTintCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        glassTintCostLabel.setBounds(372, 31, 53, 14);
		        panel_5.add(glassTintCostLabel);
		        
		        JComboBox glassTintList = new JComboBox(new Vector(obj.getGlassTintList()));
		        glassTintList.setBounds(184, 31, 170, 20);
		        panel_5.add(glassTintList);
		        
		        JLabel glassTintLabel = new JLabel(obj.getGlassTintLabel());
		        glassTintLabel.setBounds(0, 31, 174, 20);
		        panel_5.add(glassTintLabel);
		        glassTintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JLabel reinforcementLabel = new JLabel(obj.getReinforcementLabel());
		        reinforcementLabel.setBounds(0, 60, 174, 20);
		        panel_5.add(reinforcementLabel);
		        reinforcementLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JComboBox reinforcementList = new JComboBox(new Vector(obj.getReinforcementList()));
		        reinforcementList.setBounds(184, 63, 170, 20);
		        panel_5.add(reinforcementList);	        
		        JLabel reinforcementCostLabel = new JLabel("+$XX.XX");
		        reinforcementCostLabel.setBounds(370, 61, 55, 14);
		        panel_5.add(reinforcementCostLabel);
		        reinforcementCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        
		        JLabel mullCostLabel = new JLabel("+$XX.XX");
		        mullCostLabel.setBounds(370, 100, 55, 14);
		        panel_5.add(mullCostLabel);
		        mullCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        
		        JLabel mullLabel = new JLabel(obj.getMullLabel());
		        mullLabel.setBounds(0, 95, 174, 20);
		        panel_5.add(mullLabel);
		        mullLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JComboBox mullOptionBox = new JComboBox();
		        mullOptionBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		        mullOptionBox.setBounds(311, 97, 43, 20);
		        panel_5.add(mullOptionBox);
		        
		        JComboBox mullList = new JComboBox(new Vector(obj.getMullList()));
		        mullList.setBounds(184, 97, 118, 20);
		        panel_5.add(mullList);
		        
		        JPanel panel_1 = new JPanel();
		        panel_1.setBounds(5, 18, 437, 186);
		        panel_3.add(panel_1);
		        panel_1.setLayout(null);
		        
		        JLabel energyOptionsLabel = new JLabel(obj.getEnergyOptionsLabel());
		        energyOptionsLabel.setBounds(0, 0, 174, 20);
		        panel_1.add(energyOptionsLabel);
		        energyOptionsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JComboBox energyOptionsList = new JComboBox(new Vector(obj.getEnergyOptionsList()));
		        energyOptionsList.setBounds(184, 0, 170, 20);
		        panel_1.add(energyOptionsList);
		        
		        JComboBox glassStrengthList = new JComboBox(new Vector(obj.getGlassStrengthList()));
		        glassStrengthList.setBounds(184, 66, 170, 20);
		        panel_1.add(glassStrengthList);
		        
		        JComboBox spacerList = new JComboBox(new Vector(obj.getSpacerList()));
		        spacerList.setBounds(184, 92, 170, 20);
		        panel_1.add(spacerList);
		        
		        JComboBox screenList = new JComboBox(new Vector(obj.getScreenList()));
		        screenList.setBounds(184, 124, 170, 20);
		        panel_1.add(screenList);
		        
		        JLabel screenLabel = new JLabel(obj.getScreenLabel());
		        screenLabel.setBounds(0, 124, 174, 20);
		        panel_1.add(screenLabel);
		        screenLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JLabel spacerLabel = new JLabel(obj.getSpacerLabel());
		        spacerLabel.setBounds(0, 92, 174, 20);
		        panel_1.add(spacerLabel);
		        spacerLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JLabel glassStrengthLabel = new JLabel(obj.getGlassStrengthLabel());
		        glassStrengthLabel.setBounds(0, 66, 174, 20);
		        panel_1.add(glassStrengthLabel);
		        glassStrengthLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        
		        JLabel screenCostLabel = new JLabel("+$XX.XX");
		        screenCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        screenCostLabel.setBounds(372, 130, 53, 14);
		        panel_1.add(screenCostLabel);
		        
		        JLabel spacerCostLabel = new JLabel("+$XX.XX");
		        spacerCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        spacerCostLabel.setBounds(372, 98, 53, 14);
		        panel_1.add(spacerCostLabel);
		        
		        JLabel glassStrengthCostLabel = new JLabel("+$XX.XX");
		        glassStrengthCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        glassStrengthCostLabel.setBounds(372, 72, 53, 14);
		        panel_1.add(glassStrengthCostLabel);
		        
		        JLabel energyOptionsCostLabel = new JLabel("+$XX.XX");
		        energyOptionsCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        energyOptionsCostLabel.setBounds(372, 6, 53, 14);
		        panel_1.add(energyOptionsCostLabel);
		        
		        JLabel screenMeshLabel = new JLabel(obj.getScreenMeshLabel());
		        screenMeshLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        screenMeshLabel.setBounds(0, 155, 174, 20);
		        panel_1.add(screenMeshLabel);
		        
		        JComboBox screenMeshList = new JComboBox(new Vector(obj.getScreenMeshList()));
		        screenMeshList.setBounds(184, 155, 170, 20);
		        panel_1.add(screenMeshList);
		        
		        JLabel screenMeshCostLabel = new JLabel("+$XX.XX");
		        screenMeshCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        screenMeshCostLabel.setBounds(372, 161, 53, 14);
		        panel_1.add(screenMeshCostLabel);
		        
		        JLabel glassCostLabel = new JLabel("+$XX.XX");
		        glassCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        glassCostLabel.setBounds(372, 37, 53, 14);
		        panel_1.add(glassCostLabel);
		        
		        JComboBox glassList = new JComboBox(new Vector(obj.getGlassList()));
		        glassList.setBounds(184, 31, 170, 20);
		        panel_1.add(glassList);
		        
		        JLabel glassLabel = new JLabel(obj.getGlassLabel());
		        glassLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        glassLabel.setBounds(0, 31, 174, 20);
		        panel_1.add(glassLabel);
		        
		        JPanel panel_8 = new JPanel();
		        panel_8.setBounds(5, 331, 437, 116);
		        panel_3.add(panel_8);
		        panel_8.setLayout(null);
		        
		        JLabel lockColorLabel = new JLabel(obj.getLockColorLabel());
		        lockColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        lockColorLabel.setBounds(0, 0, 174, 20);
		        panel_8.add(lockColorLabel);
		        
		        JLabel lockColorCostLabel = new JLabel("+$XX.XX");
		        lockColorCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        lockColorCostLabel.setBounds(372, 0, 53, 14);
		        panel_8.add(lockColorCostLabel);
		        
		        JLabel tiltMiniblindsCostLabel = new JLabel("+$XX.XX");
		        tiltMiniblindsCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        tiltMiniblindsCostLabel.setBounds(372, 31, 53, 14);
		        panel_8.add(tiltMiniblindsCostLabel);
		        
		        JLabel tiltMiniblindsLabel = new JLabel(obj.getMiniblindsLabel());
		        tiltMiniblindsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        tiltMiniblindsLabel.setBounds(0, 31, 174, 20);
		        panel_8.add(tiltMiniblindsLabel);
		        
		        JComboBox tiltMiniblindsList = new JComboBox(new Vector(obj.getMiniblindsList()));
		        tiltMiniblindsList.setBounds(184, 31, 170, 20);
		        panel_8.add(tiltMiniblindsList);
		        
		        JLabel frameColorLabel = new JLabel(obj.getFrameColorLabel());
		        frameColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        frameColorLabel.setBounds(0, 59, 174, 20);
		        panel_8.add(frameColorLabel);
		        
		        JComboBox frameColorList = new JComboBox(new Vector(obj.getFrameColorList()));
		        frameColorList.setBounds(184, 59, 170, 20);
		        panel_8.add(frameColorList);
		        
		        JLabel frameColorCostLabel = new JLabel("+$XX.XX");
		        frameColorCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		        frameColorCostLabel.setBounds(372, 59, 53, 14);
		        panel_8.add(frameColorCostLabel);
		        
		        JComboBox woodgrainList = new JComboBox(new Vector(obj.getWoodgrainsList()));
		        woodgrainList.setBounds(184, 86, 170, 20);
		        panel_8.add(woodgrainList);
		        
		        JLabel woodgrainLabel = new JLabel(obj.getWoodgrainsLabel());
		        woodgrainLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		        woodgrainLabel.setBounds(0, 86, 174, 20);
		        panel_8.add(woodgrainLabel);
		        
		        JCheckBox chckbxExtraLock = new JCheckBox("Extra Lock");
		        chckbxExtraLock.setFont(new Font("Dialog", Font.PLAIN, 14));
		        chckbxExtraLock.setBounds(269, 0, 97, 23);
		        panel_8.add(chckbxExtraLock);
		        
		        JComboBox lockColorList = new JComboBox(new Vector (obj.getLockColorList()));
		        lockColorList.setBounds(184, 2, 79, 20);
		        panel_8.add(lockColorList);
		        
		        JButton button = new JButton("Add");
		        button.setFont(new Font("Dialog", Font.BOLD, 14));
		        button.setBounds(868, 569, 83, 30);
		        panel.add(button);
		        
		        JPanel panel_4_1 = new JPanel();
		        panel_4_1.setBounds(12, 17, 107, 30);
		        panel.add(panel_4_1);
		        
		        JLabel label_17 = new JLabel("Windows Size");
		        panel_4_1.add(label_17);
		        label_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        
		        JPanel panel_2_1 = new JPanel();
		        panel_2_1.setBounds(131, 17, 162, 30);
		        panel.add(panel_2_1);
		        
		        JLabel label_2_1 = new JLabel("Width");
		        panel_2_1.add(label_2_1);
		        
		        widthText = new JTextField("0");
		        panel_2_1.add(widthText);
		        widthText.setColumns(10);
		        
		        JPanel panel_3_1 = new JPanel();
		        panel_3_1.setBounds(298, 17, 165, 30);
		        panel.add(panel_3_1);
		        
		        JLabel label_3_1 = new JLabel("Height");
		        panel_3_1.add(label_3_1);
		        
		        heightText = new JTextField("0");
		        panel_3_1.add(heightText);
		        heightText.setColumns(10);
		        
		        JLabel lblMinMax = new JLabel("Min: 15 Max: 54");
		        lblMinMax.setFont(new Font("Dialog", Font.PLAIN, 12));
		        lblMinMax.setBounds(175, 0, 93, 16);
		        panel.add(lblMinMax);
		        
		        JLabel lblMinMax_1 = new JLabel("Min: 22.5 Max: 84");
		        lblMinMax_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		        lblMinMax_1.setBounds(344, 0, 93, 16);
		        panel.add(lblMinMax_1);
		        button.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		
		        	}
		        });
		        energyOptionsList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		calcUI();
		        		energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
		                energyOptionsCostLabel.setText("+$"+String.format("%.2f", energyCost));
		    			calcTotalCost();
		        	}
		        });
		        glassList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		        		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
		        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
		    			calcTotalCost();
		        	}
		        });
		        spacerList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		calcUI();
		        		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
		                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
		    			calcTotalCost();
		        	}
		        });
		        glassStrengthList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		        		glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
		        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
		    			calcTotalCost();
		        	}
		        });
		        screenList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
					    calcUI();
		        		screenCost=obj.getScreenPrice(index);
		                screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
		    			calcTotalCost();
		        	}
		        });
		        screenMeshList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
					    calcUI();
		        		meshCost=obj.getScreenMeshPrice(index);
		        		screenMeshLabel.setText("+$"+String.format("%.2f", meshCost));
		    			calcTotalCost();
		        	}
		        });
				glassTintList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
		        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
		    			calcTotalCost();
		        	}
		        });
				frameColorList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
		                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
		    			calcTotalCost();
		        	}
		        });
				mullList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		calcUI();
		        		mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
		               mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
		    			calcTotalCost();
		        	}
		        });
				mullOptionBox.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		        		mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
		               mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
		    			calcTotalCost();
		        	}
		        });
			    reinforcementList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		        		reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
		                reinforcementLabel.setText("+$"+String.format("%.2f", reinforcementCost));
		            			calcTotalCost();
		        	}
		        });
		        lockColorList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		        		lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());
		                lockColorLabel.setText("+$"+String.format("%.2f", lockColorCost));
		            	calcTotalCost();
		        	}
		        });
		        chckbxExtraLock.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        	calcUI();
		        	lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());
		            lockColorLabel.setText("+$"+String.format("%.2f", lockColorCost));
		            calcTotalCost();
		        	}
		        });
		        tiltMiniblindsList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		        		tiltMiniblindsCost=obj.getMiniblindsPrice(index, ui);
		                tiltMiniblindsLabel.setText("+$"+String.format("%.2f", tiltMiniblindsCost));
		            	calcTotalCost();
		        	}
		        });
		        exteriorPaintList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		        		winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
		        		exteriorPaintCostLabel.setText("+$"+String.format("%.2f", winColorCost));
		    			calcTotalCost();
		        	}
		        });
		        woodgrainList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		calcUI();
		            	calcTotalCost();
		        	}
		        });
		        chckbxFoamFilledMain.addChangeListener(new ChangeListener() {
		        	public void stateChanged(ChangeEvent arg0) {
		        		if(chckbxFoamFilledMain.isSelected()){
		        			foamCost=obj.getCustomExtrasPrice(0, ui);
		                    foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
		        		}else{foamLabel.setText("+$0.00");foamCost=0;}
						calcTotalCost();
		        	}
		        });
		        chckbxPolyfoamWrap.addChangeListener(new ChangeListener() {
		        	public void stateChanged(ChangeEvent arg0) {
		        		if(chckbxPolyfoamWrap.isSelected()){
		        			wrapCost=obj.getCustomExtrasPrice(5, ui);
		                    wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
		        		}else{wrapLabel.setText("+$0.00");wrapCost=0;}
						calcTotalCost();
		        	}
		        });
		        chckbxLaminated.addChangeListener(new ChangeListener() {
		        	public void stateChanged(ChangeEvent arg0) {
		        		if(chckbxLaminated.isSelected()){
		        			lamCost=obj.getCustomExtrasPrice(6, ui);
		                    lamLabel.setText("+$"+String.format("%.2f", lamCost));       			
		        		}else{lamLabel.setText("+$0.00");lamCost=0;}
						calcTotalCost();
		        	}
		        });
		        chckbxTrimGroove.addChangeListener(new ChangeListener() {
		        	public void stateChanged(ChangeEvent e) {
		        		if(chckbxTrimGroove.isSelected()){
		        			trimGroove1Cost=obj.getCustomExtrasPrice(1, ui);
		                    trimGroove1Label.setText("+$"+String.format("%.2f", trimGroove1Cost));       			
		        		}else{trimGroove1Label.setText("+$0.00");trimGroove1Cost=0;}
						calcTotalCost();
		        	}
		        });
		        chckbxTrimGroove_1.addChangeListener(new ChangeListener() {
		        	public void stateChanged(ChangeEvent e) {
		        		if(chckbxTrimGroove.isSelected()){
		        			trimGroove2Cost=obj.getCustomExtrasPrice(2, ui);
		                    trimGroove2Label.setText("+$"+String.format("%.2f", trimGroove2Cost));       			
		        		}else{trimGroove2Label.setText("+$0.00");trimGroove2Cost=0;}
						calcTotalCost();
		        	}
		        });
		        chckbxTrimGroove_2.addChangeListener(new ChangeListener() {
		        	public void stateChanged(ChangeEvent e) {
		        		if(chckbxTrimGroove.isSelected()){
		        			trimGroove3Cost=obj.getCustomExtrasPrice(3, ui);
		                    trimGroove3Label.setText("+$"+String.format("%.2f", trimGroove3Cost));       			
		        		}else{trimGroove3Label.setText("+$0.00");trimGroove3Cost=0;}
						calcTotalCost();
		        	}
		        });
		        chckbxWindowOpeningControl.addChangeListener(new ChangeListener() {
		        	public void stateChanged(ChangeEvent arg0) {
		        		if(chckbxWindowOpeningControl.isSelected()){
		        			wocdCost=obj.getCustomExtrasPrice(4, ui);
		                    wocdLabel.setText("+$"+String.format("%.2f", wocdCost));       			
		        		}else{wocdLabel.setText("+$0.00");wocdCost=0;}
						calcTotalCost();
		        	}
		        });
		        return panel;
	        
	    }


		public void actionPerformed(ActionEvent e){
		}
	}
