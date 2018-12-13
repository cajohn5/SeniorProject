package gui_classes;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import excel_reader_classes.MasterExcelReading;
import product_classes.Holder;
import product_classes.Windows;
import java.util.Vector;
import javax.swing.SwingConstants;

public class TWP_DoubleHung_Frame extends JFrame implements ActionListener{
	//list of all components of the frame
	private JPanel contentPane;
	
	private JFormattedTextField widthText;
	private JFormattedTextField heightText;
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
	private double orielCost = 0;
	private double wocdCost = 0;
	private double wrapCost = 0;
	private double lamCost = 0;
	private double sash1Cost = 0;
	private double sash2Cost = 0;
	private double totalCost = 0;
	private Float ui = (float) 0;

	private Windows obj;
	
	private float height;
	private float width;
	
	private String status;
	private String good = "good ui";
	
	JLabel totalLabel = new JLabel();
	
	//creates the frame
	public TWP_DoubleHung_Frame(int index, Holder holder) {
		index = holder.getProductIndex(index);
		obj = ((Windows) holder.getThermalWeldPlus().get(index));
		//sets up the frame
		setTitle(obj.getProductName());
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
		totalCost = energyCost +glassTypeCost +glassStrengthCost +spaceCost 
				+screenCost +meshCost +winColorCost +winTintCost +reinforcementCost 
				+mullCost +lockColorCost +tiltMiniblindsCost +frameColorCost 
				+woodgrainCost +foamCost +orielCost +wocdCost +wrapCost +lamCost 
				+sash1Cost +sash2Cost ;
		totalLabel.setText("$"+String.format("%.2f", totalCost));
	}
	
	private void calcUI() {
		if (heightText.getText().equals("") || heightText.getText().contains("-")) height = 0;
		else height = Float.valueOf(heightText.getText());
		if (widthText.getText().equals("") || widthText.getText().contains("-")) width = 0;
		else width = Float.valueOf(widthText.getText());
		ui = width + height;
	}
	
	//This is the panel of the home tab
	protected JComponent makeWindowPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Grid Options Per Sash", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(12, 62, 435, 108);
        panel.add(panel_6);
        panel_6.setLayout(null);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(6, 16, 417, 85);
        panel_6.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblGridOptionsSash = new JLabel("Sash 1");
        lblGridOptionsSash.setBounds(0, 0, 100, 20);
        panel_4.add(lblGridOptionsSash);
        lblGridOptionsSash.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox grid1 = new JComboBox(new Vector(obj.getGridOptionsList()));
        grid1.setSelectedIndex(0);
        grid1.setBounds(100, 0, 120, 20);
        panel_4.add(grid1);
        
        JComboBox grid2 = new JComboBox(new Vector(obj.getGridList2(grid1.getSelectedIndex())));
        grid2.setEnabled(false);
        grid2.setSelectedIndex(0);
        grid2.setBounds(230, 0, 120, 20);
        panel_4.add(grid2);
        
        JLabel lblGridOptionsSash_1 = new JLabel("Sash 2");
        lblGridOptionsSash_1.setBounds(0, 35, 100, 20);
        panel_4.add(lblGridOptionsSash_1);
        lblGridOptionsSash_1.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox grid3 = new JComboBox(new Vector(obj.getGridOptionsList()));
        grid3.setEnabled(false);
        grid3.setSelectedIndex(0);
        grid3.setBounds(100, 35, 120, 20);
        panel_4.add(grid3);
        
        JComboBox grid4 = new JComboBox(new Vector(obj.getGridList2(grid3.getSelectedIndex())));
        grid4.setEnabled(false);
        grid4.setSelectedIndex(0);
        grid4.setBounds(230, 35, 120, 20);
        panel_4.add(grid4);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Same for both Sash");
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        chckbxNewCheckBox.setBounds(10, 62, 140, 23);
        panel_4.add(chckbxNewCheckBox);
        chckbxNewCheckBox.setSelected(true);
        
        JLabel sash1CostLabel = new JLabel();
        sash1CostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        sash1CostLabel.setBounds(360, 3, 60, 14);
        panel_4.add(sash1CostLabel);
        
        JLabel sash2CostLabel = new JLabel();
        sash2CostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        sash2CostLabel.setBounds(360, 38, 60, 14);
        panel_4.add(sash2CostLabel);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(459, 62, 480, 301);
        panel.add(panel_7);
        panel_7.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 16, 464, 150);
        panel_7.add(panel_2);
        panel_2.setLayout(null);
        
        //custom extras
        JCheckBox chckbxFoamFilledMain = new JCheckBox(obj.getCustomExtrasList().get(0));
        chckbxFoamFilledMain.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxFoamFilledMain.setBounds(-2, 7, 393, 23);
        panel_2.add(chckbxFoamFilledMain);
        
        JCheckBox chckbxOriels = new JCheckBox(obj.getCustomExtrasList().get(1));
        chckbxOriels.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxOriels.setBounds(-2, 33, 393, 23);
        panel_2.add(chckbxOriels);
        
        JCheckBox chckbxWindowOpeningControl = new JCheckBox(obj.getCustomExtrasList().get(2));
        chckbxWindowOpeningControl.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxWindowOpeningControl.setBounds(-2, 59, 393, 23);
        panel_2.add(chckbxWindowOpeningControl);
        
        JCheckBox chckbxPolyfoamWrap = new JCheckBox(obj.getCustomExtrasList().get(3));
        chckbxPolyfoamWrap.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxPolyfoamWrap.setBounds(-2, 85, 393, 23);
        panel_2.add(chckbxPolyfoamWrap);
      
        JCheckBox chckbxLaminated = new JCheckBox(obj.getCustomExtrasList().get(4));
        chckbxLaminated.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxLaminated.setBounds(-2, 108, 393, 23);
        panel_2.add(chckbxLaminated);
                
        
        JLabel foamLabel = new JLabel();
        foamLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        foamLabel.setBounds(397, 13, 57, 14);
        panel_2.add(foamLabel);
        
        JLabel orielsLabel = new JLabel();
        orielsLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        orielsLabel.setBounds(397, 39, 53, 14);
        panel_2.add(orielsLabel);
        
        JLabel wocdLabel = new JLabel();
        wocdLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        wocdLabel.setBounds(397, 65, 57, 14);
        panel_2.add(wocdLabel);
        
        JLabel wrapLabel = new JLabel();
        wrapLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        wrapLabel.setBounds(397, 91, 53, 14);
        panel_2.add(wrapLabel);
        
        JLabel lamLabel = new JLabel();
        lamLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lamLabel.setBounds(397, 114, 57, 14);
        panel_2.add(lamLabel);
        
      
        
        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_9.setBounds(12, 168, 435, 444);
        panel.add(panel_9);
        panel_9.setLayout(null);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(5, 204, 418, 52);
        panel_9.add(panel_5);
        panel_5.setLayout(null);
        
        JComboBox exteriorPaintList = new JComboBox(new Vector(obj.getExteriorPaintList()));
        exteriorPaintList.setSelectedIndex(0);
        exteriorPaintList.setBounds(162, 0, 170, 20);
        panel_5.add(exteriorPaintList);
        
        JLabel exteriorPaintLabel = new JLabel(obj.getExteriorPaintLabel());
        exteriorPaintLabel.setBounds(0, 0, 152, 20);
        panel_5.add(exteriorPaintLabel);
        exteriorPaintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel exteriorPaintCostLabel = new JLabel();
        exteriorPaintCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        exteriorPaintCostLabel.setBounds(350, 6, 56, 14);
        panel_5.add(exteriorPaintCostLabel);
        
        JLabel glassTintCostLabel = new JLabel();
        glassTintCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        glassTintCostLabel.setBounds(350, 37, 56, 14);
        panel_5.add(glassTintCostLabel);
        
        JComboBox glassTintList = new JComboBox(new Vector(obj.getGlassTintList()));
        glassTintList.setSelectedIndex(0);
        glassTintList.setBounds(162, 31, 170, 20);
        panel_5.add(glassTintList);
        
        JLabel glassTintLabel = new JLabel(obj.getGlassTintLabel());
        glassTintLabel.setBounds(0, 31, 152, 20);
        panel_5.add(glassTintLabel);
        glassTintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(5, 18, 418, 186);
        panel_9.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel energyOptionsLabel = new JLabel(obj.getEnergyOptionsLabel());
        energyOptionsLabel.setBounds(0, 0, 157, 20);
        panel_1.add(energyOptionsLabel);
        energyOptionsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox energyOptionsList = new JComboBox(new Vector(obj.getEnergyOptionsList()));
        energyOptionsList.setSelectedIndex(0);
        energyOptionsList.setBounds(162, 0, 170, 20);
        panel_1.add(energyOptionsList);
        
        JComboBox glassStrengthList = new JComboBox(new Vector(obj.getGlassStrengthList()));
        glassStrengthList.setSelectedIndex(0);
        glassStrengthList.setBounds(162, 66, 170, 20);
        panel_1.add(glassStrengthList);
        
        JComboBox spacerList = new JComboBox(new Vector(obj.getSpacerList()));
        spacerList.setSelectedIndex(0);
        spacerList.setBounds(162, 92, 170, 20);
        panel_1.add(spacerList);
        
        JComboBox screenList = new JComboBox(new Vector(obj.getScreenList()));
        screenList.setSelectedIndex(0);
        screenList.setBounds(162, 124, 170, 20);
        panel_1.add(screenList);
        
        JLabel screenLabel = new JLabel(obj.getScreenLabel());
        screenLabel.setBounds(0, 124, 157, 20);
        panel_1.add(screenLabel);
        screenLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel spacerLabel = new JLabel(obj.getSpacerLabel());
        spacerLabel.setBounds(0, 92, 157, 20);
        panel_1.add(spacerLabel);
        spacerLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel glassStrengthLabel = new JLabel(obj.getGlassStrengthLabel());
        glassStrengthLabel.setBounds(0, 66, 157, 20);
        panel_1.add(glassStrengthLabel);
        glassStrengthLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel screenCostLabel = new JLabel();
        screenCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        screenCostLabel.setBounds(350, 124, 56, 14);
        panel_1.add(screenCostLabel);
        
        JLabel spacerCostLabel = new JLabel();
        spacerCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        spacerCostLabel.setBounds(350, 92, 56, 14);
        panel_1.add(spacerCostLabel);
        
        JLabel glassStrengthCostLabel = new JLabel();
        glassStrengthCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        glassStrengthCostLabel.setBounds(350, 66, 56, 14);
        panel_1.add(glassStrengthCostLabel);
        
        JLabel energyOptionsCostLabel = new JLabel();
        energyOptionsCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        energyOptionsCostLabel.setBounds(350, 0, 56, 14);
        panel_1.add(energyOptionsCostLabel);
        
        JLabel screenMeshLabel = new JLabel(obj.getScreenMeshLabel());
        screenMeshLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        screenMeshLabel.setBounds(0, 155, 157, 20);
        panel_1.add(screenMeshLabel);
        
        JComboBox screenMeshList = new JComboBox(new Vector(obj.getScreenMeshList()));
        screenMeshList.setSelectedIndex(0);
        screenMeshList.setBounds(162, 155, 170, 20);
        panel_1.add(screenMeshList);
        
        JLabel screenMeshCostLabel = new JLabel();
        screenMeshCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        screenMeshCostLabel.setBounds(350, 155, 56, 14);
        panel_1.add(screenMeshCostLabel);
        
        JLabel glassCostLabel = new JLabel();
        glassCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        glassCostLabel.setBounds(350, 31, 56, 14);
        panel_1.add(glassCostLabel);
        
        JComboBox glassList = new JComboBox(new Vector(obj.getGlassList()));
        glassList.setSelectedIndex(0);
        glassList.setBounds(162, 31, 170, 20);
        panel_1.add(glassList);
        
        JLabel glassLabel = new JLabel(obj.getGlassLabel());
        glassLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        glassLabel.setBounds(0, 31, 157, 20);
        panel_1.add(glassLabel);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(5, 256, 418, 62);
        panel_9.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel mullLabel = new JLabel(obj.getMullLabel());
        mullLabel.setBounds(0, 36, 152, 20);
        panel_3.add(mullLabel);
        mullLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel reinforcementLabel = new JLabel(obj.getReinforcementLabel());
        reinforcementLabel.setBounds(0, 8, 152, 20);
        panel_3.add(reinforcementLabel);
        reinforcementLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JComboBox reinforcementList = new JComboBox(new Vector(obj.getReinforcementList()));
        reinforcementList.setSelectedIndex(0);
        reinforcementList.setBounds(162, 8, 170, 20);
        panel_3.add(reinforcementList);
        
        JLabel reinforcementCostLabel = new JLabel();
        reinforcementCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        reinforcementCostLabel.setBounds(350, 8, 56, 14);
        panel_3.add(reinforcementCostLabel);
        
        JLabel mullCostLabel = new JLabel();
        mullCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        mullCostLabel.setBounds(350, 37, 56, 14);
        panel_3.add(mullCostLabel);
        
        JComboBox mullList = new JComboBox(new Vector(obj.getMullList()));
        mullList.setSelectedIndex(0);
        mullList.setBounds(162, 36, 118, 20);
        panel_3.add(mullList);
        
        JComboBox mullOptionBox = new JComboBox();
        mullOptionBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
        mullOptionBox.setSelectedIndex(0);
        mullOptionBox.setBounds(287, 36, 43, 20);
        panel_3.add(mullOptionBox);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBounds(5, 323, 418, 116);
        panel_9.add(panel_8);
        panel_8.setLayout(null);
        
        JComboBox lockColorList = new JComboBox(new Vector(obj.getLockColorList()));
        lockColorList.setSelectedIndex(0);
        lockColorList.setBounds(162, 0, 79, 20);
        panel_8.add(lockColorList);
        
        JLabel lockColorLabel = new JLabel(obj.getLockColorLabel());
        lockColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        lockColorLabel.setBounds(0, 0, 118, 20);
        panel_8.add(lockColorLabel);
        
        JLabel lockColorCostLabel = new JLabel();
        lockColorCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lockColorCostLabel.setBounds(350, 0, 53, 14);
        panel_8.add(lockColorCostLabel);
        
        JLabel tiltMiniblindsCostLabel = new JLabel();
        tiltMiniblindsCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        tiltMiniblindsCostLabel.setBounds(350, 31, 53, 14);
        panel_8.add(tiltMiniblindsCostLabel);
        
        JLabel tiltMiniblindsLabel = new JLabel(obj.getMiniblindsLabel());
        tiltMiniblindsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        tiltMiniblindsLabel.setBounds(0, 31, 152, 20);
        panel_8.add(tiltMiniblindsLabel);
        
        JComboBox tiltMiniblindsList = new JComboBox(new Vector(obj.getMiniblindsList()));
        tiltMiniblindsList.setSelectedIndex(0);
        tiltMiniblindsList.setBounds(162, 31, 170, 20);
        panel_8.add(tiltMiniblindsList);
        
        JLabel frameColorLabel = new JLabel(obj.getFrameColorLabel());
        frameColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        frameColorLabel.setBounds(0, 62, 152, 20);
        panel_8.add(frameColorLabel);
        
        JComboBox frameColorList = new JComboBox(new Vector(obj.getFrameColorList()));
        frameColorList.setSelectedIndex(0);
        frameColorList.setBounds(162, 62, 170, 20);
        panel_8.add(frameColorList);
        
        JLabel frameColorCostLabel = new JLabel();
        frameColorCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        frameColorCostLabel.setBounds(350, 62, 53, 14);
        panel_8.add(frameColorCostLabel);
        
        JLabel woodgrainLabel = new JLabel(obj.getWoodgrainsLabel());
        woodgrainLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        woodgrainLabel.setBounds(0, 89, 152, 20);
        panel_8.add(woodgrainLabel);
        
        JComboBox woodgrainList = new JComboBox(new Vector(obj.getWoodgrainsList()));
        woodgrainList.setSelectedIndex(0);
        woodgrainList.setBounds(162, 89, 170, 20);
        panel_8.add(woodgrainList);
        
        JCheckBox chckbxExtraLock = new JCheckBox("Extra Lock");
        chckbxExtraLock.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxExtraLock.setBounds(247, -2, 97, 23);
        panel_8.add(chckbxExtraLock);
        
        
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBounds(12, 20, 107, 30);
        panel.add(panel_4_1);
        
        JLabel label_26 = new JLabel("Windows Size");
        panel_4_1.add(label_26);
        label_26.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBounds(131, 20, 162, 30);
        panel.add(panel_2_1);
        
        JLabel label_2_1 = new JLabel("Width");
        panel_2_1.add(label_2_1);
        
        //regex for width height input
        NumberFormat num = NumberFormat.getNumberInstance();
        
        widthText = new JFormattedTextField(num);
        widthText.setValue(new Float(obj.getSize().getWidth().get(0)));
        panel_2_1.add(widthText);
        widthText.setColumns(10);
        
        JPanel panel_3_1 = new JPanel();
        panel_3_1.setBounds(298, 20, 165, 30);
        panel.add(panel_3_1);
        
        JLabel label_3_1 = new JLabel("Height");
        panel_3_1.add(label_3_1);
        
        heightText = new JFormattedTextField(num);
        heightText.setValue(new Float(obj.getSize().getHeight().get(0)));
        panel_3_1.add(heightText);
        heightText.setColumns(10);
        
        //width label
        JLabel label_28 = new JLabel(obj.getWidthLabel());
        label_28.setHorizontalAlignment(SwingConstants.CENTER);
        label_28.setFont(new Font("Dialog", Font.PLAIN, 12));
        label_28.setBounds(131, 3, 162, 16);
        panel.add(label_28);
        
        //height label
        JLabel label_29 = new JLabel(obj.getHeightLabel());
        label_29.setHorizontalAlignment(SwingConstants.CENTER);
        label_29.setFont(new Font("Dialog", Font.PLAIN, 12));
        label_29.setBounds(298, 3, 165, 16);
        panel.add(label_29);
        
        //close button
        JButton button = new JButton("Close");
        button.setFont(new Font("Dialog", Font.BOLD, 14));
        button.setBounds(868, 569, 83, 30);
        panel.add(button);
        
        JLabel UILabel = new JLabel("<dynamic>");
        UILabel.setBounds(468, 20, 471, 30);
        panel.add(UILabel);
        
        
        //close button
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });        


        //actions
        frameColorList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (status.toLowerCase().equals(good)){
	        		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	                frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        energyOptionsList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (status.toLowerCase().equals(good)){
        			energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
        			energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        glassStrengthList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	        		glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        glassList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	        		glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        screenList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (status.toLowerCase().equals(good)){
	        		screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
	                screenCostLabel.setText("$"+String.format("%.2f", screenCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        screenMeshList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	                meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
	        		screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        spacerList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (status.toLowerCase().equals(good)){
	        		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	                spacerCostLabel.setText("$"+String.format("%.2f", spaceCost));
	    			calcTotalCost();
        		}
        	}
        });
        
		
		mullList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (status.toLowerCase().equals(good)){
	        		mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	        		mullCostLabel.setText("$"+String.format("%.2f", mullCost));
	    			calcTotalCost();
        		}
        	}
        });
		mullOptionBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	                mullCostLabel.setText("$"+String.format("%.2f", mullCost));
	    			calcTotalCost();
        		}
        	}
        });
		
        tiltMiniblindsList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
	        		tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
	            	calcTotalCost();
        		}
        	}
        });
        
        woodgrainList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//no price change
        	}
        });
        
        glassTintList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	        		glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        reinforcementList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	                reinforcementCostLabel.setText("$"+String.format("%.2f", reinforcementCost));
	            	calcTotalCost();
        		}
        	}
        });
        
        exteriorPaintList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
	        		exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));
	    			calcTotalCost();
        		}
        	}
        });
        
        lockColorList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){	        		
	        		lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());	                
	        		lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
	            	calcTotalCost();
        		}       		
        	}
        });
        
        chckbxExtraLock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (status.toLowerCase().equals(good)){
	        		lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());
	        		lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
	                calcTotalCost();
        		}        	
        	}
        });
        
        
        //custom extra actions
        chckbxFoamFilledMain.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(chckbxFoamFilledMain.isSelected() && status.toLowerCase().equals(good)){
        			foamCost=obj.getCustomExtrasPrice(0, ui);
                    foamLabel.setText("$"+String.format("%.2f", foamCost));       			
        		}else{foamLabel.setText("$0.00");foamCost=0;}
				calcTotalCost();
        	}
        });

        chckbxOriels.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(chckbxOriels.isSelected()){
        			orielCost=obj.getCustomExtrasPrice(1, ui);
                    orielsLabel.setText("$"+String.format("%.2f", orielCost));       			
        		}else{orielsLabel.setText("$0.00");orielCost=0;}
				calcTotalCost();
        	}
        });
        
        chckbxWindowOpeningControl.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(chckbxWindowOpeningControl.isSelected()){
        			wocdCost=obj.getCustomExtrasPrice(2, ui);
                    wocdLabel.setText("$"+String.format("%.2f", wocdCost));       			
        		}else{wocdLabel.setText("$0.00");wocdCost=0;}
				calcTotalCost();
        	}
        });

        chckbxPolyfoamWrap.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent arg0) {
        		if(chckbxPolyfoamWrap.isSelected() && status.toLowerCase().equals(good)){
        			wrapCost=obj.getCustomExtrasPrice(3, ui);
                    wrapLabel.setText("$"+String.format("%.2f", wrapCost));       			
        		}else{wrapLabel.setText("$0.00");wrapCost=0;}
				calcTotalCost();
        	}
        });
        chckbxLaminated.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent arg0) {
        		if(chckbxLaminated.isSelected() && status.toLowerCase().equals(good)){
        			lamCost=obj.getCustomExtrasPrice(4, ui);
                    lamLabel.setText("$"+String.format("%.2f", lamCost));       			
        		}else{lamLabel.setText("$0.00");lamCost=0;}
				calcTotalCost();
        	}
        });
        
        
        
       
        
        //grids actions
        grid1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//update next box
        		if (grid1.getSelectedIndex() != 0) grid2.setEnabled(true);
        		else grid2.setEnabled(false);
        		grid2.setModel(new DefaultComboBoxModel(new Vector(obj.getGridList2(grid1.getSelectedIndex()))));
        		//update cost
        		if (status.toLowerCase().equals(good)){		        		
	        		sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	        		sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    			calcTotalCost();
        		}
    			//update the next 2 boxes if same sash is checked
    			if (chckbxNewCheckBox.isSelected()) {
    				grid3.setSelectedIndex(grid1.getSelectedIndex());
    				grid4.setModel(new DefaultComboBoxModel(new Vector(obj.getGridList2(grid3.getSelectedIndex()))));            		
    				grid4.setSelectedIndex(grid2.getSelectedIndex());
    			}
        	}
        });
        grid2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//update cost
        		if (status.toLowerCase().equals(good)){
	        		sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	        		sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    			calcTotalCost();
        		}
    			//update the next 2 boxes if same sash is checked
    			if (chckbxNewCheckBox.isSelected()) {
    				grid3.setSelectedIndex(grid1.getSelectedIndex());
    				grid4.setModel(new DefaultComboBoxModel(new Vector(obj.getGridList2(grid3.getSelectedIndex()))));            		
    				grid4.setSelectedIndex(grid2.getSelectedIndex());
    			}
        	}
        });
        grid3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//update next box
        		if (grid3.getSelectedIndex() != 0 && !chckbxNewCheckBox.isSelected()) grid4.setEnabled(true);
        		else grid4.setEnabled(false);
        		grid4.setModel(new DefaultComboBoxModel(new Vector(obj.getGridList2(grid3.getSelectedIndex()))));
        		//update cost
        		if (status.toLowerCase().equals(good)){
	        		sash2Cost=obj.getGridOptionsPrice(grid3.getSelectedIndex(), grid4.getSelectedIndex(), ui);
	        		sash2CostLabel.setText("$"+String.format("%.2f", sash2Cost));
	    			calcTotalCost();
        		}
        	}
        });
        grid4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//update cost
        		if (status.toLowerCase().equals(good)){
	        		sash2Cost=obj.getGridOptionsPrice(grid3.getSelectedIndex(), grid4.getSelectedIndex(), ui);
	        		sash2CostLabel.setText("$"+String.format("%.2f", sash2Cost));
	    			calcTotalCost();
        		}
        	}
        });
        chckbxNewCheckBox.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent arg0) {
    			if (chckbxNewCheckBox.isSelected()) {
    				grid3.setSelectedIndex(grid1.getSelectedIndex());
    				grid4.setSelectedIndex(grid2.getSelectedIndex());
    				grid3.setEnabled(false);
    				grid4.setEnabled(false);
    			} else {
    				grid3.setEnabled(true);
    				if (grid3.getSelectedIndex() != 0) grid4.setEnabled(true);
	        		else grid4.setEnabled(false);	    				
    			}
        	}
        });
        
        
        
        widthText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
            	calcUI();	
            	status = obj.checkSize(width, height, 
    	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
    	        		!String.valueOf(tiltMiniblindsList.getSelectedItem()).toLowerCase().contains("none"));
    	        UILabel.setText(status);
    	        if (UILabel.getText().toLowerCase().equals(good)){
    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
    	        	
    			    sash2Cost=obj.getGridOptionsPrice(grid3.getSelectedIndex(), grid4.getSelectedIndex(), ui);					
    			    sash2CostLabel.setText("$"+String.format("%.2f", sash2Cost));
    			    
    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
    			    
    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
    			    
    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
    			    
    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
    			    
    			    screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
	                screenCostLabel.setText("$"+String.format("%.2f", screenCost));
    			    
    			    meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
	        		screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
    			    
    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
    			    
    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
    			    
    			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
    			    reinforcementCostLabel.setText("$"+String.format("%.2f", reinforcementCost));
    			    
    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
    				
    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
    				
    				lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());	                
    				lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
    				
    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
    				
    				if (chckbxFoamFilledMain.isSelected()) {
    					foamCost=obj.getCustomExtrasPrice(0, ui);
    					foamLabel.setText("$"+String.format("%.2f", foamCost));
    				} else foamLabel.setText("$0.00");
    				if (chckbxOriels.isSelected()) {
    					orielCost=obj.getCustomExtrasPrice(1, ui);
    					orielsLabel.setText("$"+String.format("%.2f", orielCost));
    				} else orielsLabel.setText("$0.00");
    				if (chckbxWindowOpeningControl.isSelected()) {
    					wocdCost=obj.getCustomExtrasPrice(2, ui);
    					wocdLabel.setText("$"+String.format("%.2f", wocdCost));
    				} else wocdLabel.setText("$0.00");
    				if (chckbxPolyfoamWrap.isSelected()) {
    					wrapCost=obj.getCustomExtrasPrice(3, ui);
    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
    				} else wrapLabel.setText("$0.00");
    				if (chckbxLaminated.isSelected()) {
    					lamCost=obj.getCustomExtrasPrice(4, ui);
    					lamLabel.setText("$"+String.format("%.2f", lamCost));
    				} else lamLabel.setText("$0.00");
	                calcTotalCost();
    	        } else {
    	        	sash1CostLabel.setText("$0.00");					
    			    sash2CostLabel.setText("$0.00");
    			    frameColorCostLabel.setText("$0.00");
    			    energyOptionsCostLabel.setText("$0.00");
    			    glassStrengthCostLabel.setText("$0.00");
    			    glassCostLabel.setText("$0.00");
    			    screenCostLabel.setText("$0.00");
    			    screenMeshCostLabel.setText("$0.00");
    			    spacerCostLabel.setText("$0.00"); 
    			    mullCostLabel.setText("$0.00");
    			    lockColorCostLabel.setText("$0.00");
    			    reinforcementCostLabel.setText("$0.00");
    			    glassTintCostLabel.setText("$0.00");
    				exteriorPaintCostLabel.setText("$0.00");	
    				tiltMiniblindsCostLabel.setText("$0.00");

    				foamLabel.setText("$0.00");
    				orielsLabel.setText("$0.00");
    				wocdLabel.setText("$0.00");
    				wrapLabel.setText("$0.00");				
    				lamLabel.setText("$0.00");	    				
    				totalLabel.setText("$0.00");
    	        }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
            	calcUI();	
            	status = obj.checkSize(width, height, 
    	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
    	        		!String.valueOf(tiltMiniblindsList.getSelectedItem()).toLowerCase().contains("none"));
    	        UILabel.setText(status);
    	        if (UILabel.getText().toLowerCase().equals(good)){
    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
    	        	
    			    sash2Cost=obj.getGridOptionsPrice(grid3.getSelectedIndex(), grid4.getSelectedIndex(), ui);					
    			    sash2CostLabel.setText("$"+String.format("%.2f", sash2Cost));
    			    
    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
    			    
    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
    			    
    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
    			    
    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
    			    
    			    screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
	                screenCostLabel.setText("$"+String.format("%.2f", screenCost));
    			    
    			    meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
    			    screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
    			    
    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
    			    
    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
    			    
    			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
    			    reinforcementCostLabel.setText("$"+String.format("%.2f", reinforcementCost));
    			    
    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
    				
    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
    				
    				lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());	                
    				lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
    				
    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
    				
    				if (chckbxFoamFilledMain.isSelected()) {
    					foamCost=obj.getCustomExtrasPrice(0, ui);
    					foamLabel.setText("$"+String.format("%.2f", foamCost));
    				} else foamLabel.setText("$0.00");
    				if (chckbxOriels.isSelected()) {
    					orielCost=obj.getCustomExtrasPrice(1, ui);
    					orielsLabel.setText("$"+String.format("%.2f", orielCost));
    				} else orielsLabel.setText("$0.00");
    				if (chckbxWindowOpeningControl.isSelected()) {
    					wocdCost=obj.getCustomExtrasPrice(2, ui);
    					wocdLabel.setText("$"+String.format("%.2f", wocdCost));
    				} else wocdLabel.setText("$0.00");
    				if (chckbxPolyfoamWrap.isSelected()) {
    					wrapCost=obj.getCustomExtrasPrice(3, ui);
    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
    				} else wrapLabel.setText("$0.00");
    				if (chckbxLaminated.isSelected()) {
    					lamCost=obj.getCustomExtrasPrice(4, ui);
    					lamLabel.setText("$"+String.format("%.2f", lamCost));
    				} else lamLabel.setText("$0.00");
	                calcTotalCost();
    	        } else {
    	        	sash1CostLabel.setText("$0.00");					
    			    sash2CostLabel.setText("$0.00");
    			    frameColorCostLabel.setText("$0.00");
    			    energyOptionsCostLabel.setText("$0.00");
    			    glassStrengthCostLabel.setText("$0.00");
    			    glassCostLabel.setText("$0.00");
    			    screenCostLabel.setText("$0.00");
    			    screenMeshCostLabel.setText("$0.00");
    			    spacerCostLabel.setText("$0.00"); 
    			    mullCostLabel.setText("$0.00");
    			    lockColorCostLabel.setText("$0.00");
    			    reinforcementCostLabel.setText("$0.00");
    			    glassTintCostLabel.setText("$0.00");
    				exteriorPaintCostLabel.setText("$0.00");	
    				tiltMiniblindsCostLabel.setText("$0.00");

    				foamLabel.setText("$0.00");
    				orielsLabel.setText("$0.00");
    				wocdLabel.setText("$0.00");
    				wrapLabel.setText("$0.00");				
    				lamLabel.setText("$0.00");	    				
    				totalLabel.setText("$0.00");
    	        }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {	            	
            }
        });
        heightText.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
            	calcUI();	
            	status = obj.checkSize(width, height, 
    	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
    	        		!String.valueOf(tiltMiniblindsList.getSelectedItem()).toLowerCase().contains("none"));
    	        UILabel.setText(status);
    	        if (UILabel.getText().toLowerCase().equals(good)){
    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
    	        	
    			    sash2Cost=obj.getGridOptionsPrice(grid3.getSelectedIndex(), grid4.getSelectedIndex(), ui);					
    			    sash2CostLabel.setText("$"+String.format("%.2f", sash2Cost));
    			    
    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
    			    
    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
    			    
    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
    			    
    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
    			    
    			    screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
	                screenCostLabel.setText("$"+String.format("%.2f", screenCost));
    			    
    			    meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
    			    screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
    			    
    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
    			    
    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
    			    
    			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
    			    reinforcementCostLabel.setText("$"+String.format("%.2f", reinforcementCost));
    			    
    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
    				
    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
    				
    				lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());	                
    				lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
    				
    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
    				
    				if (chckbxFoamFilledMain.isSelected()) {
    					foamCost=obj.getCustomExtrasPrice(0, ui);
    					foamLabel.setText("$"+String.format("%.2f", foamCost));
    				} else foamLabel.setText("$0.00");
    				if (chckbxOriels.isSelected()) {
    					orielCost=obj.getCustomExtrasPrice(1, ui);
    					orielsLabel.setText("$"+String.format("%.2f", orielCost));
    				} else orielsLabel.setText("$0.00");
    				if (chckbxWindowOpeningControl.isSelected()) {
    					wocdCost=obj.getCustomExtrasPrice(2, ui);
    					wocdLabel.setText("$"+String.format("%.2f", wocdCost));
    				} else wocdLabel.setText("$0.00");
    				if (chckbxPolyfoamWrap.isSelected()) {
    					wrapCost=obj.getCustomExtrasPrice(3, ui);
    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
    				} else wrapLabel.setText("$0.00");
    				if (chckbxLaminated.isSelected()) {
    					lamCost=obj.getCustomExtrasPrice(4, ui);
    					lamLabel.setText("$"+String.format("%.2f", lamCost));
    				} else lamLabel.setText("$0.00");
	                calcTotalCost();
    	        } else {
    	        	sash1CostLabel.setText("$0.00");					
    			    sash2CostLabel.setText("$0.00");
    			    frameColorCostLabel.setText("$0.00");
    			    energyOptionsCostLabel.setText("$0.00");
    			    glassStrengthCostLabel.setText("$0.00");
    			    glassCostLabel.setText("$0.00");
    			    screenCostLabel.setText("$0.00");
    			    screenMeshCostLabel.setText("$0.00");
    			    spacerCostLabel.setText("$0.00"); 
    			    mullCostLabel.setText("$0.00");
    			    lockColorCostLabel.setText("$0.00");
    			    reinforcementCostLabel.setText("$0.00");
    			    glassTintCostLabel.setText("$0.00");
    				exteriorPaintCostLabel.setText("$0.00");	
    				tiltMiniblindsCostLabel.setText("$0.00");

    				foamLabel.setText("$0.00");
    				orielsLabel.setText("$0.00");
    				wocdLabel.setText("$0.00");
    				wrapLabel.setText("$0.00");				
    				lamLabel.setText("$0.00");	    				
    				totalLabel.setText("$0.00");
    	        }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
            	calcUI();	
            	status = obj.checkSize(width, height, 
    	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
    	        		!String.valueOf(tiltMiniblindsList.getSelectedItem()).toLowerCase().contains("none"));
    	        UILabel.setText(status);
    	        if (UILabel.getText().toLowerCase().equals(good)){
    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
    	        	
    			    sash2Cost=obj.getGridOptionsPrice(grid3.getSelectedIndex(), grid4.getSelectedIndex(), ui);					
    			    sash2CostLabel.setText("$"+String.format("%.2f", sash2Cost));
    			    
    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
    			    
    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
    			    
    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
    			    
    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
    			    
    			    screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
	                screenCostLabel.setText("$"+String.format("%.2f", screenCost));
    			    
    			    meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
    			    screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
    			    
    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
    			    
    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
    			    
    			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
    			    reinforcementCostLabel.setText("$"+String.format("%.2f", reinforcementCost));
    			    
    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
    				
    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
    				
    				lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());	                
    				lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
    				
    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
    				
    				if (chckbxFoamFilledMain.isSelected()) {
    					foamCost=obj.getCustomExtrasPrice(0, ui);
    					foamLabel.setText("$"+String.format("%.2f", foamCost));
    				} else foamLabel.setText("$0.00");
    				if (chckbxOriels.isSelected()) {
    					orielCost=obj.getCustomExtrasPrice(1, ui);
    					orielsLabel.setText("$"+String.format("%.2f", orielCost));
    				} else orielsLabel.setText("$0.00");
    				if (chckbxWindowOpeningControl.isSelected()) {
    					wocdCost=obj.getCustomExtrasPrice(2, ui);
    					wocdLabel.setText("$"+String.format("%.2f", wocdCost));
    				} else wocdLabel.setText("$0.00");
    				if (chckbxPolyfoamWrap.isSelected()) {
    					wrapCost=obj.getCustomExtrasPrice(3, ui);
    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
    				} else wrapLabel.setText("$0.00");
    				if (chckbxLaminated.isSelected()) {
    					lamCost=obj.getCustomExtrasPrice(4, ui);
    					lamLabel.setText("$"+String.format("%.2f", lamCost));
    				} else lamLabel.setText("$0.00");
	                calcTotalCost();
    	        } else {
    	        	sash1CostLabel.setText("$0.00");					
    			    sash2CostLabel.setText("$0.00");
    			    frameColorCostLabel.setText("$0.00");
    			    energyOptionsCostLabel.setText("$0.00");
    			    glassStrengthCostLabel.setText("$0.00");
    			    glassCostLabel.setText("$0.00");
    			    screenCostLabel.setText("$0.00");
    			    screenMeshCostLabel.setText("$0.00");
    			    spacerCostLabel.setText("$0.00"); 
    			    mullCostLabel.setText("$0.00");
    			    lockColorCostLabel.setText("$0.00");
    			    reinforcementCostLabel.setText("$0.00");
    			    glassTintCostLabel.setText("$0.00");
    				exteriorPaintCostLabel.setText("$0.00");	
    				tiltMiniblindsCostLabel.setText("$0.00");

    				foamLabel.setText("$0.00");
    				orielsLabel.setText("$0.00");
    				wocdLabel.setText("$0.00");
    				wrapLabel.setText("$0.00");				
    				lamLabel.setText("$0.00");	    				
    				totalLabel.setText("$0.00");
    	        }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {	            	
            }
        });
        
        
        
        //does the start up prices
        calcUI();	
    	status = obj.checkSize(width, height, 
        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
        		!String.valueOf(tiltMiniblindsList.getSelectedItem()).toLowerCase().contains("none"));
        UILabel.setText(status);
        if (UILabel.getText().toLowerCase().equals(good)){
        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
        	
		    sash2Cost=obj.getGridOptionsPrice(grid3.getSelectedIndex(), grid4.getSelectedIndex(), ui);					
		    sash2CostLabel.setText("$"+String.format("%.2f", sash2Cost));
		    
		    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
		    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
		    
		    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
		    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
		    
		    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
		    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
		    
		    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
		    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
		    
		    screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
            screenCostLabel.setText("$"+String.format("%.2f", screenCost));
		    
		    meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
		    screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
		    
		    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
		    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
		    
		    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
		    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
		    
		    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
		    reinforcementCostLabel.setText("$"+String.format("%.2f", reinforcementCost));
		    
			winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
			glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
			
			winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
			exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
			
			lockColorCost=obj.getLockColorPrice(lockColorList.getSelectedIndex(), chckbxExtraLock.isSelected());	                
			lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
			
			tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
			tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
			
			if (chckbxFoamFilledMain.isSelected()) {
				foamCost=obj.getCustomExtrasPrice(0, ui);
				foamLabel.setText("$"+String.format("%.2f", foamCost));
			} else foamLabel.setText("$0.00");
			if (chckbxOriels.isSelected()) {
				orielCost=obj.getCustomExtrasPrice(1, ui);
				orielsLabel.setText("$"+String.format("%.2f", orielCost));
			} else orielsLabel.setText("$0.00");
			if (chckbxWindowOpeningControl.isSelected()) {
				wocdCost=obj.getCustomExtrasPrice(2, ui);
				wocdLabel.setText("$"+String.format("%.2f", wocdCost));
			} else wocdLabel.setText("$0.00");
			if (chckbxPolyfoamWrap.isSelected()) {
				wrapCost=obj.getCustomExtrasPrice(3, ui);
				wrapLabel.setText("$"+String.format("%.2f", wrapCost));
			} else wrapLabel.setText("$0.00");
			if (chckbxLaminated.isSelected()) {
				lamCost=obj.getCustomExtrasPrice(4, ui);
				lamLabel.setText("$"+String.format("%.2f", lamCost));
			} else lamLabel.setText("$0.00");
            calcTotalCost();
        } else {
        	sash1CostLabel.setText("$0.00");					
		    sash2CostLabel.setText("$0.00");
		    frameColorCostLabel.setText("$0.00");
		    energyOptionsCostLabel.setText("$0.00");
		    glassStrengthCostLabel.setText("$0.00");
		    glassCostLabel.setText("$0.00");
		    screenCostLabel.setText("$0.00");
		    screenMeshCostLabel.setText("$0.00");
		    spacerCostLabel.setText("$0.00"); 
		    mullCostLabel.setText("$0.00");
		    reinforcementCostLabel.setText("$0.00");
		    glassTintCostLabel.setText("$0.00");
			exteriorPaintCostLabel.setText("$0.00");	
			tiltMiniblindsCostLabel.setText("$0.00");

			foamLabel.setText("$0.00");
			orielsLabel.setText("$0.00");
			wocdLabel.setText("$0.00");
			wrapLabel.setText("$0.00");				
			lamLabel.setText("$0.00");	    				
			totalLabel.setText("$0.00");
        } 
        
        return panel;
        
    }


	public void actionPerformed(ActionEvent e){
	}
}
