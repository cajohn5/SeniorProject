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
import java.util.Vector;

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
import javax.swing.SwingConstants;
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

public class UW_Picture_Frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	
	private JFormattedTextField widthText;
	private JFormattedTextField heightText;
	private double energyCost = 0;
	private double glassTypeCost = 0;
	private double glassStrengthCost = 0;
	private double spaceCost = 0;
	private double winColorCost = 0;
	private double winTintCost = 0;
	private double mullCost = 0;
	private double tiltMiniblindsCost = 0;
	private double frameColorCost = 0;
	private double woodgrainCost = 0;
	private double foamCost = 0;
	private double wrapCost = 0;
	private double lamCost = 0;
	private double trimGroove1Cost = 0;
	private double trimGroove2Cost = 0;
	private double trimGroove3Cost = 0;
	private double sash1Cost = 0;
	private double sash2Cost = 0;
	private double totalCost = 0;
//	private Holder holder = new Holder();
	private Float ui = (float) 0;
	private int index;
	private Windows obj;
	private float height;
	private float width;
	
	private String status;
	private String good = "good ui";
//	private MasterExcelReading mer = new MasterExcelReading();
//	{
//	
//	try
//		{
//			mer.returnUpdatedHolder(holder);
//		}
//	catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	JLabel totalLabel = new JLabel("$0.00");
	
//creates the frame
	public UW_Picture_Frame(int index, Holder holder) {
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
		totalCost = energyCost +glassTypeCost +glassStrengthCost +spaceCost +winColorCost +winTintCost +mullCost +tiltMiniblindsCost +frameColorCost +woodgrainCost +foamCost +wrapCost +lamCost +trimGroove1Cost +trimGroove2Cost +trimGroove3Cost +sash1Cost +sash2Cost ;
		totalLabel.setText("$"+String.format("%.2f", totalCost));
		}
	private void calcUI() {
		if (heightText.getText().equals("") || heightText.getText().contains("-")) height = 0;
		else height = Float.valueOf(heightText.getText());
		if (widthText.getText().equals("") || widthText.getText().contains("-")) width = 0;
		else width = Float.valueOf(widthText.getText());
		ui = width + height;	}
	
//This is the panel of the home tab
	protected JComponent makeWindowPanel() {
		 JPanel panel = new JPanel();
	        panel.setLayout(null);
	        	       
	        //Width and Height
	        JPanel panel_4_1 = new JPanel();
	        panel_4_1.setBounds(12, 20, 107, 30);
	        panel.add(panel_4_1);
	        
	        JLabel label_26 = new JLabel("Windows Size");
	        panel_4_1.add(label_26);
	        label_26.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        	        
	        //regex for width height input
	        NumberFormat num = NumberFormat.getNumberInstance();

	        JPanel panel_2_1 = new JPanel();
	        panel_2_1.setBounds(131, 20, 162, 30);
	        panel.add(panel_2_1);
	        
	        JLabel label_2_1 = new JLabel("Width");
	        panel_2_1.add(label_2_1);
	        
	        widthText = new JFormattedTextField(num);
	        widthText.setValue(new Float(obj.getSize().getWidth().get(0)));	        
	        panel_2_1.add(widthText);
	        widthText.setColumns(10);
	        
	        JLabel label_28 = new JLabel(obj.getWidthLabel());
	        label_28.setHorizontalAlignment(SwingConstants.CENTER);
	        label_28.setFont(new Font("Dialog", Font.PLAIN, 12));
	        label_28.setBounds(131, 3, 162, 16);
	        panel.add(label_28);
	        
	        JPanel panel_3_1 = new JPanel();
	        panel_3_1.setBounds(298, 20, 165, 30);
	        panel.add(panel_3_1);
	        
	        JLabel label_3_1 = new JLabel("Height");
	        panel_3_1.add(label_3_1);
	        
	        heightText = new JFormattedTextField(num);
	        heightText.setValue(new Float(obj.getSize().getWidth().get(0)));
	        panel_3_1.add(heightText);
	        heightText.setColumns(10);
	        
	        JLabel label_29 = new JLabel(obj.getHeightLabel());
	        label_29.setHorizontalAlignment(SwingConstants.CENTER);
	        label_29.setFont(new Font("Dialog", Font.PLAIN, 12));
	        label_29.setBounds(298, 3, 165, 16);
	        panel.add(label_29);
	        
	        JLabel UILabel = new JLabel("New label");
	        UILabel.setBounds(468, 20, 471, 30);
	        panel.add(UILabel);
	        
	        
	        
	        //grid options
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
	        grid2.setSelectedIndex(0);
	        grid2.setEnabled(false);
	        grid2.setBounds(230, 0, 120, 20);
	        panel_4.add(grid2);;
	        
	        JLabel sash1CostLabel = new JLabel();
	        sash1CostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        sash1CostLabel.setBounds(360, 3, 60, 14);
	        panel_4.add(sash1CostLabel);
	        
	        
	        
	        //Window Options
	        JPanel panel_9 = new JPanel();
	        panel_9.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_9.setBounds(12, 168, 435, 444);
	        panel.add(panel_9);
	        panel_9.setLayout(null);
	        
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
	        
	        JLabel spacerLabel = new JLabel(obj.getSpacerLabel());
	        spacerLabel.setBounds(0, 92, 157, 20);
	        panel_1.add(spacerLabel);
	        spacerLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JLabel glassStrengthLabel = new JLabel(obj.getGlassStrengthLabel());
	        glassStrengthLabel.setBounds(0, 66, 157, 20);
	        panel_1.add(glassStrengthLabel);
	        glassStrengthLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
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
	        
	        //glass
	        JLabel glassLabel = new JLabel(obj.getGlassLabel());
	        glassLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	        glassLabel.setBounds(0, 31, 157, 20);
	        panel_1.add(glassLabel);
	        
	        JComboBox glassList = new JComboBox(new Vector(obj.getGlassList()));
	        glassList.setSelectedIndex(0);
	        glassList.setBounds(162, 31, 170, 20);
	        panel_1.add(glassList);
	        	       
	        JLabel glassCostLabel = new JLabel();
	        glassCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        glassCostLabel.setBounds(350, 31, 56, 14);
	        panel_1.add(glassCostLabel);
	        
	        //exterior paint
	        JLabel exteriorPaintLabel = new JLabel(obj.getExteriorPaintLabel());
	        exteriorPaintLabel.setBounds(0, 123, 152, 20);
	        panel_1.add(exteriorPaintLabel);
	        exteriorPaintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JComboBox exteriorPaintList = new JComboBox(new Vector(obj.getExteriorPaintList()));
	        exteriorPaintList.setSelectedIndex(0);
	        exteriorPaintList.setBounds(162, 123, 170, 20);
	        panel_1.add(exteriorPaintList);
	        
	        JLabel exteriorPaintCostLabel = new JLabel();
	        exteriorPaintCostLabel.setBounds(350, 129, 56, 14);
	        panel_1.add(exteriorPaintCostLabel);
	        exteriorPaintCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        
	        //glass tint
	        JLabel glassTintLabel = new JLabel(obj.getGlassTintLabel());
	        glassTintLabel.setBounds(0, 154, 152, 20);
	        panel_1.add(glassTintLabel);
	        glassTintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));

	        JComboBox glassTintList = new JComboBox(new Vector(obj.getGlassTintList()));
	        glassTintList.setSelectedIndex(0);
	        glassTintList.setBounds(162, 154, 170, 20);
	        panel_1.add(glassTintList);

	        JLabel glassTintCostLabel = new JLabel();
	        glassTintCostLabel.setBounds(350, 160, 56, 14);
	        panel_1.add(glassTintCostLabel);
	        glassTintCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));	        
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBounds(5, 204, 418, 62);
	        panel_9.add(panel_3);
	        panel_3.setLayout(null);
	        
	        JLabel mullLabel = new JLabel(obj.getMullLabel());
	        mullLabel.setBounds(0, 0, 152, 20);
	        panel_3.add(mullLabel);
	        mullLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        JLabel mullCostLabel = new JLabel();
	        mullCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        mullCostLabel.setBounds(350, 1, 56, 14);
	        panel_3.add(mullCostLabel);
	        
	        JComboBox mullList = new JComboBox(new Vector(obj.getMullList()));
	        mullList.setSelectedIndex(0);
	        mullList.setBounds(162, 0, 118, 20);
	        panel_3.add(mullList);
	        
	        JComboBox mullOptionBox = new JComboBox();
	        mullOptionBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
	        mullOptionBox.setSelectedIndex(0);
	        mullOptionBox.setBounds(287, 0, 43, 20);
	        panel_3.add(mullOptionBox);
	        
	        JLabel tiltMiniblindsLabel = new JLabel(obj.getMiniblindsLabel());
	        tiltMiniblindsLabel.setBounds(0, 31, 152, 20);
	        panel_3.add(tiltMiniblindsLabel);
	        tiltMiniblindsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	        
	        JComboBox tiltMiniblindsList = new JComboBox(new Vector(obj.getMiniblindsList()));
	        tiltMiniblindsList.setBounds(162, 31, 170, 20);
	        panel_3.add(tiltMiniblindsList);
	        tiltMiniblindsList.setSelectedIndex(0);
	        
	        JLabel tiltMiniblindsCostLabel = new JLabel();
	        tiltMiniblindsCostLabel.setBounds(350, 31, 53, 14);
	        panel_3.add(tiltMiniblindsCostLabel);
	        tiltMiniblindsCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        tiltMiniblindsList.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if (status.toLowerCase().equals(good)){
		        		tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
		        		tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
		            	calcTotalCost();
	        		}
	        	}
	        });
	        status = obj.checkSize(width, height, 
	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
	        		!String.valueOf(tiltMiniblindsList.getSelectedItem()).toLowerCase().contains("none"));
	        
	        JPanel panel_8 = new JPanel();
	        panel_8.setBounds(5, 271, 418, 116);
	        panel_9.add(panel_8);
	        panel_8.setLayout(null);
	        
	        JLabel frameColorLabel = new JLabel(obj.getFrameColorLabel());
	        frameColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	        frameColorLabel.setBounds(0, 0, 152, 20);
	        panel_8.add(frameColorLabel);
	        
	        JComboBox frameColorList = new JComboBox(new Vector(obj.getFrameColorList()));
	        frameColorList.setSelectedIndex(0);
	        frameColorList.setBounds(162, 0, 170, 20);
	        panel_8.add(frameColorList);
	        
	        JLabel frameColorCostLabel = new JLabel();
	        frameColorCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        frameColorCostLabel.setBounds(350, 0, 53, 14);
	        panel_8.add(frameColorCostLabel);
	        
	        JLabel woodgrainLabel = new JLabel(obj.getWoodgrainsLabel());
	        woodgrainLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	        woodgrainLabel.setBounds(0, 27, 152, 20);
	        panel_8.add(woodgrainLabel);
	        
	        JComboBox woodgrainList = new JComboBox(new Vector(obj.getWoodgrainsList()));
	        woodgrainList.setSelectedIndex(0);
	        woodgrainList.setBounds(162, 27, 170, 20);
	        panel_8.add(woodgrainList);
	        

	        
	        //custom extras
	        JPanel panel_7 = new JPanel();
	        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_7.setBounds(459, 62, 480, 301);
	        panel.add(panel_7);
	        panel_7.setLayout(null);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBounds(6, 16, 464, 192);
	        panel_7.add(panel_2);
	        panel_2.setLayout(null);
	        
	        JCheckBox chckbxPolyfoamWrap = new JCheckBox(obj.getCustomExtrasList().get(4));
	        chckbxPolyfoamWrap.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxPolyfoamWrap.setBounds(-2, 33, 393, 23);
	        panel_2.add(chckbxPolyfoamWrap);
	        
	        JCheckBox chckbxFoamFilledMain = new JCheckBox(obj.getCustomExtrasList().get(0));
	        chckbxFoamFilledMain.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxFoamFilledMain.setBounds(-2, 7, 393, 23);
	        panel_2.add(chckbxFoamFilledMain);
	        
	        JCheckBox chckbxLaminated = new JCheckBox(obj.getCustomExtrasList().get(5));
	        chckbxLaminated.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxLaminated.setBounds(-2, 56, 393, 23);
	        panel_2.add(chckbxLaminated);
	        
	        JLabel wrapLabel = new JLabel();
	        wrapLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        wrapLabel.setBounds(397, 39, 53, 14);
	        panel_2.add(wrapLabel);
	        
	        JLabel foamLabel = new JLabel();
	        foamLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        foamLabel.setBounds(397, 13, 57, 14);
	        panel_2.add(foamLabel);
	        
	        JLabel lamLabel = new JLabel();
	        lamLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        lamLabel.setBounds(397, 62, 57, 14);
	        panel_2.add(lamLabel);
	        
	        JLabel trimGroove3Label = new JLabel();
	        trimGroove3Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        trimGroove3Label.setBounds(397, 137, 57, 14);
	        panel_2.add(trimGroove3Label);
	        
	        JLabel trimGroove2Label = new JLabel();
	        trimGroove2Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        trimGroove2Label.setBounds(397, 114, 53, 14);
	        panel_2.add(trimGroove2Label);
	        
	        JLabel trimGroove1Label = new JLabel();
	        trimGroove1Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        trimGroove1Label.setBounds(397, 88, 57, 14);
	        panel_2.add(trimGroove1Label);
	        
	        JCheckBox chckbxTrimGroove = new JCheckBox(obj.getCustomExtrasList().get(1));
	        chckbxTrimGroove.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxTrimGroove.setBounds(-2, 82, 393, 23);
	        panel_2.add(chckbxTrimGroove);
	        
	        JCheckBox chckbxTrimGroove_1 = new JCheckBox(obj.getCustomExtrasList().get(2));
	        chckbxTrimGroove_1.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxTrimGroove_1.setBounds(-2, 108, 393, 23);
	        panel_2.add(chckbxTrimGroove_1);
	        
	        JCheckBox chckbxTrimGroove_2 = new JCheckBox(obj.getCustomExtrasList().get(3));
	        chckbxTrimGroove_2.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxTrimGroove_2.setBounds(-2, 131, 393, 23);
	        panel_2.add(chckbxTrimGroove_2);
	        
	        
	        
	        //close button
	        JButton button = new JButton("Close");
	        button.setFont(new Font("Dialog", Font.BOLD, 14));
	        button.setBounds(868, 569, 83, 30);
	        panel.add(button);
	        
	        //closes the current window
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        	}
	        });

	        

	        //actions
	        energyOptionsList.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if (status.toLowerCase().equals(good)){
	        			energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
	        			energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
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
	        spacerList.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if (status.toLowerCase().equals(good)){
		        		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
		                spacerCostLabel.setText("$"+String.format("%.2f", spaceCost));
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
			frameColorList.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if (status.toLowerCase().equals(good)){
		        		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
		                frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
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
	        exteriorPaintList.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if (status.toLowerCase().equals(good)){
		        		winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
		        		exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));
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


	        chckbxPolyfoamWrap.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent arg0) {
	        		if(chckbxPolyfoamWrap.isSelected() && status.toLowerCase().equals(good)){
	        			wrapCost=obj.getCustomExtrasPrice(4, ui);
	                    wrapLabel.setText("$"+String.format("%.2f", wrapCost));       			
	        		}else{wrapLabel.setText("$0.00");wrapCost=0;}
					calcTotalCost();
	        	}
	        });
	        chckbxLaminated.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent arg0) {
	        		if(chckbxLaminated.isSelected() && status.toLowerCase().equals(good)){
	        			lamCost=obj.getCustomExtrasPrice(5, ui);
	                    lamLabel.setText("$"+String.format("%.2f", lamCost));       			
	        		}else{lamLabel.setText("$0.00");lamCost=0;}
					calcTotalCost();
	        	}
	        });
	        chckbxTrimGroove.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent arg0) {
	        		if(chckbxTrimGroove.isSelected() && status.toLowerCase().equals(good)){
	        			trimGroove1Cost=obj.getCustomExtrasPrice(1, ui);
	                    trimGroove1Label.setText("$"+String.format("%.2f", trimGroove1Cost));       			
	        		}else{trimGroove1Label.setText("$0.00");trimGroove1Cost=0;}
					calcTotalCost();
	        	}
	        });
	        chckbxTrimGroove_1.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent arg0) {
	        		if(chckbxTrimGroove_1.isSelected() && status.toLowerCase().equals(good)){
	        			trimGroove2Cost=obj.getCustomExtrasPrice(2, ui);
	                    trimGroove2Label.setText("$"+String.format("%.2f", trimGroove2Cost));       			
	        		}else{trimGroove2Label.setText("$0.00");trimGroove2Cost=0;}
					calcTotalCost();
	        	}
	        });
	        chckbxTrimGroove_2.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent arg0) {
	        		if(chckbxTrimGroove_2.isSelected() && status.toLowerCase().equals(good)){
	        			trimGroove3Cost=obj.getCustomExtrasPrice(3, ui);
	                    trimGroove3Label.setText("$"+String.format("%.2f", trimGroove3Cost));       			
	        		}else{trimGroove3Label.setText("$0.00");trimGroove3Cost=0;}
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
	    	        
	    	        int i = glassList.getSelectedIndex();
	    	        glassList.setModel(new DefaultComboBoxModel(new Vector(obj.getGlassList2(ui))));
	    	        if (glassList.getItemCount() > i) glassList.setSelectedIndex(i);	  
	    	        
	    	        if (UILabel.getText().toLowerCase().equals(good)){
	    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    			    
	    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
	    			    
	    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
	    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
	    			    
	    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
	    			    
	    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
	    			    
	    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
	    			    
	    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
	    			    
	    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
	    				
	    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
	    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
	    				
	    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
	    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
	    				
	    				if (chckbxFoamFilledMain.isSelected()) {
	    					foamCost=obj.getCustomExtrasPrice(0, ui);
	    					foamLabel.setText("$"+String.format("%.2f", foamCost));
	    				} else foamLabel.setText("$0.00");
	    				if (chckbxPolyfoamWrap.isSelected()) {
	    					wrapCost=obj.getCustomExtrasPrice(4, ui);
	    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
	    				} else wrapLabel.setText("$0.00");
	    				if (chckbxLaminated.isSelected()) {
	    					lamCost=obj.getCustomExtrasPrice(5, ui);
	    					lamLabel.setText("$"+String.format("%.2f", lamCost));
	    				}	 else lamLabel.setText("$0.00");
	    				if (chckbxTrimGroove.isSelected()) {
	    					trimGroove1Cost=obj.getCustomExtrasPrice(1, ui);
	    					trimGroove1Label.setText("$"+String.format("%.2f", trimGroove1Cost));
	    				} else trimGroove1Label.setText("$0.00");
	    				if (chckbxTrimGroove_1.isSelected()) {
	    					trimGroove2Cost=obj.getCustomExtrasPrice(2, ui);
	    					trimGroove2Label.setText("$"+String.format("%.2f", trimGroove2Cost));
	    				} else trimGroove2Label.setText("$0.00");
	    				if (chckbxTrimGroove_2.isSelected()) {
	    					trimGroove3Cost=obj.getCustomExtrasPrice(3, ui);
	    					trimGroove3Label.setText("$"+String.format("%.2f", trimGroove3Cost));
	    				} else trimGroove3Label.setText("$0.00");
	    				calcTotalCost();
	    	        } else {
	    	        	sash1CostLabel.setText("$0.00");
	    			    frameColorCostLabel.setText("$0.00");
	    			    energyOptionsCostLabel.setText("$0.00");
	    			    glassStrengthCostLabel.setText("$0.00");
	    			    glassCostLabel.setText("$0.00");
	    			    spacerCostLabel.setText("$0.00"); 
	    			    mullCostLabel.setText("$0.00");
	    			    glassTintCostLabel.setText("$0.00");
	    				exteriorPaintCostLabel.setText("$0.00");	
	    				tiltMiniblindsCostLabel.setText("$0.00");

	    				foamLabel.setText("$0.00");
	    				wrapLabel.setText("$0.00");				
	    				lamLabel.setText("$0.00");
	    				trimGroove1Label.setText("$0.00");
	    				trimGroove2Label.setText("$0.00");				
	    				trimGroove3Label.setText("$0.00");
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
	    	        
	    	        int i = glassList.getSelectedIndex();
	    	        glassList.setModel(new DefaultComboBoxModel(new Vector(obj.getGlassList2(ui))));
	    	        if (glassList.getItemCount() > i) glassList.setSelectedIndex(i);	  
	    	        
	    	        if (UILabel.getText().toLowerCase().equals(good)){
	    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    			    
	    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
	    			    
	    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
	    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
	    			    
	    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
	    			    
	    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
	    			    
	    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
	    			    
	    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
	    			    
	    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
	    				
	    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
	    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
	    				
	    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
	    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
	    				
	    				if (chckbxFoamFilledMain.isSelected()) {
	    					foamCost=obj.getCustomExtrasPrice(0, ui);
	    					foamLabel.setText("$"+String.format("%.2f", foamCost));
	    				} else foamLabel.setText("$0.00");
	    				if (chckbxPolyfoamWrap.isSelected()) {
	    					wrapCost=obj.getCustomExtrasPrice(4, ui);
	    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
	    				} else wrapLabel.setText("$0.00");
	    				if (chckbxLaminated.isSelected()) {
	    					lamCost=obj.getCustomExtrasPrice(5, ui);
	    					lamLabel.setText("$"+String.format("%.2f", lamCost));
	    				}	 else lamLabel.setText("$0.00");
	    				if (chckbxTrimGroove.isSelected()) {
	    					trimGroove1Cost=obj.getCustomExtrasPrice(1, ui);
	    					trimGroove1Label.setText("$"+String.format("%.2f", trimGroove1Cost));
	    				} else trimGroove1Label.setText("$0.00");
	    				if (chckbxTrimGroove_1.isSelected()) {
	    					trimGroove2Cost=obj.getCustomExtrasPrice(2, ui);
	    					trimGroove2Label.setText("$"+String.format("%.2f", trimGroove2Cost));
	    				} else trimGroove2Label.setText("$0.00");
	    				if (chckbxTrimGroove_2.isSelected()) {
	    					trimGroove3Cost=obj.getCustomExtrasPrice(3, ui);
	    					trimGroove3Label.setText("$"+String.format("%.2f", trimGroove3Cost));
	    				} else trimGroove3Label.setText("$0.00");
	    				calcTotalCost();
	    	        } else {
	    	        	sash1CostLabel.setText("$0.00");
	    			    frameColorCostLabel.setText("$0.00");
	    			    energyOptionsCostLabel.setText("$0.00");
	    			    glassStrengthCostLabel.setText("$0.00");
	    			    glassCostLabel.setText("$0.00");
	    			    spacerCostLabel.setText("$0.00"); 
	    			    mullCostLabel.setText("$0.00");
	    			    glassTintCostLabel.setText("$0.00");
	    				exteriorPaintCostLabel.setText("$0.00");	
	    				tiltMiniblindsCostLabel.setText("$0.00");

	    				foamLabel.setText("$0.00");
	    				wrapLabel.setText("$0.00");				
	    				lamLabel.setText("$0.00");
	    				trimGroove1Label.setText("$0.00");
	    				trimGroove2Label.setText("$0.00");				
	    				trimGroove3Label.setText("$0.00");
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
	    	        
	    	        int i = glassList.getSelectedIndex();
	    	        glassList.setModel(new DefaultComboBoxModel(new Vector(obj.getGlassList2(ui))));
	    	        if (glassList.getItemCount() > i) glassList.setSelectedIndex(i);	  
	    	        
	    	        if (UILabel.getText().toLowerCase().equals(good)){
	    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    			    
	    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
	    			    
	    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
	    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
	    			    
	    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
	    			    
	    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
	    			    
	    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
	    			    
	    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
	    			    
	    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
	    				
	    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
	    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
	    				
	    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
	    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
	    				
	    				if (chckbxFoamFilledMain.isSelected()) {
	    					foamCost=obj.getCustomExtrasPrice(0, ui);
	    					foamLabel.setText("$"+String.format("%.2f", foamCost));
	    				} else foamLabel.setText("$0.00");
	    				if (chckbxPolyfoamWrap.isSelected()) {
	    					wrapCost=obj.getCustomExtrasPrice(4, ui);
	    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
	    				} else wrapLabel.setText("$0.00");
	    				if (chckbxLaminated.isSelected()) {
	    					lamCost=obj.getCustomExtrasPrice(5, ui);
	    					lamLabel.setText("$"+String.format("%.2f", lamCost));
	    				}	 else lamLabel.setText("$0.00");
	    				if (chckbxTrimGroove.isSelected()) {
	    					trimGroove1Cost=obj.getCustomExtrasPrice(1, ui);
	    					trimGroove1Label.setText("$"+String.format("%.2f", trimGroove1Cost));
	    				} else trimGroove1Label.setText("$0.00");
	    				if (chckbxTrimGroove_1.isSelected()) {
	    					trimGroove2Cost=obj.getCustomExtrasPrice(2, ui);
	    					trimGroove2Label.setText("$"+String.format("%.2f", trimGroove2Cost));
	    				} else trimGroove2Label.setText("$0.00");
	    				if (chckbxTrimGroove_2.isSelected()) {
	    					trimGroove3Cost=obj.getCustomExtrasPrice(3, ui);
	    					trimGroove3Label.setText("$"+String.format("%.2f", trimGroove3Cost));
	    				} else trimGroove3Label.setText("$0.00");
	    				calcTotalCost();
	    	        } else {
	    	        	sash1CostLabel.setText("$0.00");
	    			    frameColorCostLabel.setText("$0.00");
	    			    energyOptionsCostLabel.setText("$0.00");
	    			    glassStrengthCostLabel.setText("$0.00");
	    			    glassCostLabel.setText("$0.00");
	    			    spacerCostLabel.setText("$0.00"); 
	    			    mullCostLabel.setText("$0.00");
	    			    glassTintCostLabel.setText("$0.00");
	    				exteriorPaintCostLabel.setText("$0.00");	
	    				tiltMiniblindsCostLabel.setText("$0.00");

	    				foamLabel.setText("$0.00");
	    				wrapLabel.setText("$0.00");				
	    				lamLabel.setText("$0.00");
	    				trimGroove1Label.setText("$0.00");
	    				trimGroove2Label.setText("$0.00");				
	    				trimGroove3Label.setText("$0.00");
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
	    	        
	    	        int i = glassList.getSelectedIndex();
	    	        glassList.setModel(new DefaultComboBoxModel(new Vector(obj.getGlassList2(ui))));
	    	        if (glassList.getItemCount() > i) glassList.setSelectedIndex(i);	  
	    	        
	    	        if (UILabel.getText().toLowerCase().equals(good)){
	    	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	    	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    			    
	    			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	    			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
	    			    
	    			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
	    			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
	    			    
	    			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	    			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
	    			    
	    			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	    			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
	    			    
	    			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	    			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
	    			    
	    			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	    			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
	    			    
	    				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	    				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
	    				
	    				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
	    				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
	    				
	    				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
	    				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
	    				
	    				if (chckbxFoamFilledMain.isSelected()) {
	    					foamCost=obj.getCustomExtrasPrice(0, ui);
	    					foamLabel.setText("$"+String.format("%.2f", foamCost));
	    				} else foamLabel.setText("$0.00");
	    				if (chckbxPolyfoamWrap.isSelected()) {
	    					wrapCost=obj.getCustomExtrasPrice(4, ui);
	    					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
	    				} else wrapLabel.setText("$0.00");
	    				if (chckbxLaminated.isSelected()) {
	    					lamCost=obj.getCustomExtrasPrice(5, ui);
	    					lamLabel.setText("$"+String.format("%.2f", lamCost));
	    				}	 else lamLabel.setText("$0.00");
	    				if (chckbxTrimGroove.isSelected()) {
	    					trimGroove1Cost=obj.getCustomExtrasPrice(1, ui);
	    					trimGroove1Label.setText("$"+String.format("%.2f", trimGroove1Cost));
	    				} else trimGroove1Label.setText("$0.00");
	    				if (chckbxTrimGroove_1.isSelected()) {
	    					trimGroove2Cost=obj.getCustomExtrasPrice(2, ui);
	    					trimGroove2Label.setText("$"+String.format("%.2f", trimGroove2Cost));
	    				} else trimGroove2Label.setText("$0.00");
	    				if (chckbxTrimGroove_2.isSelected()) {
	    					trimGroove3Cost=obj.getCustomExtrasPrice(3, ui);
	    					trimGroove3Label.setText("$"+String.format("%.2f", trimGroove3Cost));
	    				} else trimGroove3Label.setText("$0.00");
	    				calcTotalCost();
	    	        } else {
	    	        	sash1CostLabel.setText("$0.00");
	    			    frameColorCostLabel.setText("$0.00");
	    			    energyOptionsCostLabel.setText("$0.00");
	    			    glassStrengthCostLabel.setText("$0.00");
	    			    glassCostLabel.setText("$0.00");
	    			    spacerCostLabel.setText("$0.00"); 
	    			    mullCostLabel.setText("$0.00");
	    			    glassTintCostLabel.setText("$0.00");
	    				exteriorPaintCostLabel.setText("$0.00");	
	    				tiltMiniblindsCostLabel.setText("$0.00");

	    				foamLabel.setText("$0.00");
	    				wrapLabel.setText("$0.00");				
	    				lamLabel.setText("$0.00");
	    				trimGroove1Label.setText("$0.00");
	    				trimGroove2Label.setText("$0.00");				
	    				trimGroove3Label.setText("$0.00");
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
	        
	        int i = glassList.getSelectedIndex();
	        glassList.setModel(new DefaultComboBoxModel(new Vector(obj.getGlassList2(ui))));
	        if (glassList.getItemCount() > i) glassList.setSelectedIndex(i);	  
	        
	        if (UILabel.getText().toLowerCase().equals(good)){
	        	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	        	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
			    
			    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
			    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
			    
			    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
			    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
			    
			    glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
			    glassStrengthCostLabel.setText("$"+String.format("%.2f", glassStrengthCost));
			    
			    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
			    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
			    
			    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
			    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 
			    
			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
			    mullCostLabel.setText("$"+String.format("%.2f", mullCost));
			    
				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
				glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
				
				winColorCost=obj.getExteriorPaintPrice(exteriorPaintList.getSelectedIndex());
				exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
				
				tiltMiniblindsCost=obj.getMiniblindsPrice(tiltMiniblindsList.getSelectedIndex(), ui);
				tiltMiniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
				
				if (chckbxFoamFilledMain.isSelected()) {
					foamCost=obj.getCustomExtrasPrice(0, ui);
					foamLabel.setText("$"+String.format("%.2f", foamCost));
				} else foamLabel.setText("$0.00");
				if (chckbxPolyfoamWrap.isSelected()) {
					wrapCost=obj.getCustomExtrasPrice(4, ui);
					wrapLabel.setText("$"+String.format("%.2f", wrapCost));
				} else wrapLabel.setText("$0.00");
				if (chckbxLaminated.isSelected()) {
					lamCost=obj.getCustomExtrasPrice(5, ui);
					lamLabel.setText("$"+String.format("%.2f", lamCost));
				}	 else lamLabel.setText("$0.00");
				if (chckbxTrimGroove.isSelected()) {
					trimGroove1Cost=obj.getCustomExtrasPrice(1, ui);
					trimGroove1Label.setText("$"+String.format("%.2f", trimGroove1Cost));
				} else trimGroove1Label.setText("$0.00");
				if (chckbxTrimGroove_1.isSelected()) {
					trimGroove2Cost=obj.getCustomExtrasPrice(2, ui);
					trimGroove2Label.setText("$"+String.format("%.2f", trimGroove2Cost));
				} else trimGroove2Label.setText("$0.00");
				if (chckbxTrimGroove_2.isSelected()) {
					trimGroove3Cost=obj.getCustomExtrasPrice(3, ui);
					trimGroove3Label.setText("$"+String.format("%.2f", trimGroove3Cost));
				} else trimGroove3Label.setText("$0.00");
				calcTotalCost();
	        } else {
	        	sash1CostLabel.setText("$0.00");
			    frameColorCostLabel.setText("$0.00");
			    energyOptionsCostLabel.setText("$0.00");
			    glassStrengthCostLabel.setText("$0.00");
			    glassCostLabel.setText("$0.00");
			    spacerCostLabel.setText("$0.00"); 
			    mullCostLabel.setText("$0.00");
			    glassTintCostLabel.setText("$0.00");
				exteriorPaintCostLabel.setText("$0.00");	
				tiltMiniblindsCostLabel.setText("$0.00");

				foamLabel.setText("$0.00");
				wrapLabel.setText("$0.00");				
				lamLabel.setText("$0.00");
				trimGroove1Label.setText("$0.00");
				trimGroove2Label.setText("$0.00");				
				trimGroove3Label.setText("$0.00");
				totalLabel.setText("$0.00");
	        }          
	        
	        return panel;        
 }


	public void actionPerformed(ActionEvent e){
	}
}
