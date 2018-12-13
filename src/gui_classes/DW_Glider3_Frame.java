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
import java.util.Vector;

public class DW_Glider3_Frame extends JFrame implements ActionListener{
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
	private double frameColorCost = 0;
	private double foamCost = 0;
	private double orielCost = 0;
	private double wrapCost = 0;
	private double lamCost = 0;
	private double sash1Cost = 0;
	private double sash2Cost = 0;
	private double reinforcementCost = 0;
	private double mullCost = 0;
	private double totalCost = 0;
//	private Holder holder = new Holder();
	private Float ui = (float) 0;
	private int index;
	private Windows obj;
	private float height;
	private float width;
	private String status = "good ui";
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
	public DW_Glider3_Frame(int index, Holder holder) {
		index = holder.getProductIndex(index);
		obj = ((Windows) holder.getDynaWeld().get(index));
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
		lblWindowTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(lblWindowTypeLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Price");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(label_1);
		

		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(totalLabel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	private void calcTotalCost() {
		totalCost = energyCost +glassTypeCost +glassStrengthCost +spaceCost +screenCost +meshCost +winColorCost +winTintCost +frameColorCost +foamCost +orielCost +wrapCost +lamCost +sash1Cost +sash2Cost +reinforcementCost +mullCost;
		totalLabel.setText("$"+String.format("%.2f", totalCost));
		}
	private void calcUI() {
		if (heightText.getText().equals("") || heightText.getText().contains("-")) height = 0;
		else height = Float.valueOf(heightText.getText());
		if (widthText.getText().equals("") || widthText.getText().contains("-")) width = 0;
		else width = Float.valueOf(widthText.getText());
		ui = width+height;			}
//This is the panel of the home tab
	protected JComponent makeWindowPanel() {
		 JPanel panel = new JPanel();
	        //panel.setLayout(new AbsoluteLayout(0,0));
	        panel.setLayout(null);
	        
	        JPanel panel_7 = new JPanel();
	        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_7.setBounds(482, 70, 367, 301);
	        panel_7.setSize(480, 301);
	        panel.add(panel_7);
	        panel_7.setLayout(null);
	        NumberFormat num = NumberFormat.getNumberInstance();
	        JPanel panel_2 = new JPanel();
	        JPanel panel_2_1 = new JPanel();
	        panel_2_1.setBounds(128, 28, 162, 30);
	        panel.add(panel_2_1);
	        JLabel label_2_1 = new JLabel("Width");
	        panel_2_1.add(label_2_1);
	        
	        widthText = new JFormattedTextField(num);
	        widthText.setValue(new Float(obj.getSize().getWidth().get(0)));
	        panel_2_1.add(widthText);
	        widthText.setColumns(10);
	        
	        JPanel panel_3_1 = new JPanel();
	        panel_3_1.setBounds(302, 28, 165, 30);
	        panel.add(panel_3_1);
	        
	        JLabel label_3_1 = new JLabel("Height");
	        panel_3_1.add(label_3_1);
	        
	        heightText = new JFormattedTextField(new Float(obj.getSize().getHeight().get(0)));
	        heightText = new JFormattedTextField(num);
	        heightText.setValue(new Float(obj.getSize().getWidth().get(0)));
	        panel_3_1.add(heightText);
	        heightText.setColumns(10);

	        panel_2.setBounds(6, 16, 462, 273);
	        panel_7.add(panel_2);
	        panel_2.setLayout(null);
	    	ui = Float.valueOf(widthText.getText())+Float.valueOf(heightText.getText());
            JLabel UILabel = new JLabel("Good UI");
            UILabel.setBounds(482, 28, 471, 30);
            panel.add(UILabel);
	        JLabel lblMinMax = new JLabel(obj.getWidthLabel());
	        lblMinMax.setHorizontalAlignment(SwingConstants.CENTER);        
	        JCheckBox chckbxPolyfoamWrap = new JCheckBox(obj.getCustomExtrasList().get(2));
	        chckbxPolyfoamWrap.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxPolyfoamWrap.setBounds(8, 58, 380, 23);
	        panel_2.add(chckbxPolyfoamWrap);
	        JLabel foamLabel = new JLabel("+$0.00");
	        foamLabel.setBounds(394, 16, 58, 14);
	        panel_2.add(foamLabel);
	        JCheckBox chckbxFoamFilledMain = new JCheckBox(obj.getCustomExtrasList().get(0));
	        chckbxFoamFilledMain.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxFoamFilledMain.addChangeListener(new ChangeListener() {
	        	public void stateChanged(ChangeEvent arg0) {
	        		if(chckbxFoamFilledMain.isSelected()){
	        			foamCost=obj.getCustomExtrasPrice(0, ui);
	                    foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
	        		}else{foamLabel.setText("+$0.00");foamCost=0;}
					calcTotalCost();
	        	}
	        });
	        chckbxFoamFilledMain.setBounds(8, 8, 380, 23);
	        panel_2.add(chckbxFoamFilledMain);
	        JLabel orielLabel = new JLabel("+$0.00");
	        orielLabel.setBounds(394, 43, 53, 14);
	        panel_2.add(orielLabel);
	        JCheckBox chckbxOriels = new JCheckBox(obj.getCustomExtrasList().get(1));
	        chckbxOriels.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxOriels.setBounds(8, 34, 380, 23);
	        panel_2.add(chckbxOriels);
	        
	        JCheckBox chckbxLaminated = new JCheckBox(obj.getCustomExtrasList().get(3));
	        chckbxLaminated.setFont(new Font("Dialog", Font.PLAIN, 14));
	        chckbxLaminated.setBounds(8, 85, 380, 23);
	        panel_2.add(chckbxLaminated);
	        
	        JLabel wrapLabel = new JLabel("+$0.00");
	        wrapLabel.setBounds(394, 67, 53, 14);
	        panel_2.add(wrapLabel);
	        JComboBox energyOptionList = new JComboBox(new Vector((obj.getEnergyOptionsList())));
	        energyOptionList.setSelectedIndex(0);
	        JComboBox glassStrengthList = new JComboBox();
	        JComboBox spacerList = new JComboBox();
	        JComboBox screenList = new JComboBox();
	        JComboBox glassList = new JComboBox();
	        JLabel screenCostLabel = new JLabel("+$0.00");
	        JLabel spacerCostLabel = new JLabel("+$0.00");
	        JLabel glassStrengthCostLabel = new JLabel("+$0.00");
	        JLabel energyOptionCostLabel = new JLabel("+$0.00");
	        JLabel glassCostLabel = new JLabel("+$0.00");

	        

	        
	        JLabel lamLabel = new JLabel("+$0.00");
	        lamLabel.setBounds(394, 94, 53, 14);
	        panel_2.add(lamLabel);
	        
	        JPanel panel_9 = new JPanel();
	        panel_9.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_9.setBounds(10, 180, 467, 360);
	        panel.add(panel_9);
	        panel_9.setLayout(null);
	        

	        
	        JPanel panel_5 = new JPanel();
	        panel_5.setBounds(5, 161, 457, 152);
	        panel_9.add(panel_5);
	        panel_5.setLayout(null);
	        

	        
	        JLabel glassTintCostLabel = new JLabel("+$0.00");
	        glassTintCostLabel.setBounds(387, 43, 70, 14);
	        panel_5.add(glassTintCostLabel);
	        
	        JComboBox glassTintList = new JComboBox();
	        glassTintList.setModel(new DefaultComboBoxModel(obj.getGlassTintList().toArray(new String[obj.getGlassTintList().size()])));
	        glassTintList.setSelectedIndex(0);
	        glassTintList.setBounds(207, 40, 170, 20);
	        panel_5.add(glassTintList);
	        
	        JLabel glassTintLabel = new JLabel(obj.getGlassTintLabel());
	        glassTintLabel.setBounds(0, 40, 197, 20);
	        panel_5.add(glassTintLabel);
	        glassTintLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        JLabel meshCostLabel = new JLabel("+$0.00");
	        meshCostLabel.setBounds(387, 14, 70, 14);
	        panel_5.add(meshCostLabel);
	        JComboBox meshList = new JComboBox();

	        meshList.setBounds(207, 11, 170, 20);
	        panel_5.add(meshList);
	        meshList.setModel(new DefaultComboBoxModel(obj.getScreenMeshList().toArray(new String[obj.getScreenMeshList().size()])));
	        meshList.setSelectedIndex(0);
	        

	        
	        JLabel meshLabel = new JLabel(obj.getScreenMeshLabel());
	        meshLabel.setBounds(0, 11, 197, 20);
	        panel_5.add(meshLabel);
	        meshLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        JLabel frameColorLabel = new JLabel(obj.getFrameColorLabel());
	        frameColorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        frameColorLabel.setBounds(0, 68, 197, 20);
	        panel_5.add(frameColorLabel);
	        
	        JLabel frameColorCostLabel = new JLabel("+$0.00");
	        frameColorCostLabel.setBounds(387, 72, 70, 14);
	        panel_5.add(frameColorCostLabel);
	        
	        JComboBox frameColorList = new JComboBox();
	        frameColorList.setModel(new DefaultComboBoxModel(obj.getFrameColorList().toArray(new String[obj.getFrameColorList().size()])));
	        frameColorList.setSelectedIndex(0);
	        frameColorList.setBounds(207, 68, 170, 20);
	        panel_5.add(frameColorList);
	        
	        JLabel reinforcementLabel = new JLabel(obj.getReinforcementLabel());
	        reinforcementLabel.setBounds(0, 98, 197, 20);
	        panel_5.add(reinforcementLabel);
	        reinforcementLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	       
	        
	        JComboBox reinforcementList = new JComboBox();
	        reinforcementList.setBounds(206, 98, 170, 20);
	        panel_5.add(reinforcementList);
	        reinforcementList.setModel(new DefaultComboBoxModel(obj.getReinforcementList().toArray(new String[obj.getReinforcementList().size()])));
	        reinforcementList.setSelectedIndex(0);
	        JLabel reinforcementCostLabel = new JLabel("+$0.00");
	        reinforcementCostLabel.setBounds(387, 102, 70, 14);
	        panel_5.add(reinforcementCostLabel);
	        
	        JLabel mullLabel = new JLabel(obj.getMullLabel());
	        mullLabel.setBounds(0, 131, 197, 20);
	        panel_5.add(mullLabel);
	        mullLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        JComboBox mullList = new JComboBox();
	        mullList.setBounds(206, 130, 118, 20);
	        panel_5.add(mullList);
	        mullList.setModel(new DefaultComboBoxModel(obj.getMullList().toArray(new String[obj.getMullList().size()])));
	        mullList.setSelectedIndex(0);
	        JLabel mullCostLabel = new JLabel("+$0.00");
	        mullCostLabel.setBounds(387, 135, 70, 14);
	        panel_5.add(mullCostLabel);
	        
	        JComboBox mullOptionBox = new JComboBox();
	        mullOptionBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
	        mullOptionBox.setSelectedIndex(0);
	        
	         	
	        mullOptionBox.setBounds(327, 130, 50, 20);
	        panel_5.add(mullOptionBox);
	        mullList.addActionListener(new ActionListener() {
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
	                reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	            			calcTotalCost();
	        	}
	        });
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(5, 18, 457, 142);
	        panel_9.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel energyOptionsLabel = new JLabel(obj.getEnergyOptionsLabel());
	        energyOptionsLabel.setBounds(0, 0, 197, 20);
	        panel_1.add(energyOptionsLabel);
	        energyOptionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        

	        
	        energyOptionList.setBounds(207, 1, 170, 20);
	        panel_1.add(energyOptionList);
	        
	        glassStrengthList.setModel(new DefaultComboBoxModel(obj.getGlassStrengthList().toArray(new String[obj.getGlassStrengthList().size()])));
	        glassStrengthList.setSelectedIndex(0);
	        glassStrengthList.setBounds(207, 65, 170, 20);
	        panel_1.add(glassStrengthList);
	        
	        spacerList.setModel(new DefaultComboBoxModel(obj.getSpacerList().toArray(new String[obj.getSpacerList().size()])));
	        spacerList.setSelectedIndex(0);
	        spacerList.setBounds(207, 91, 170, 20);
	        panel_1.add(spacerList);
	        
	       // String[] screenBoxArray = ;
	        screenList.setModel(new DefaultComboBoxModel(obj.getScreenList().toArray(new String[obj.getScreenList().size()])));
	        screenList.setSelectedIndex(0);
	        screenList.setBounds(207, 122, 170, 20);
	        panel_1.add(screenList);
	        screenCostLabel.setBounds(387, 126, 70, 14);
	        panel_1.add(screenCostLabel);
	        screenList.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	            screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
	            screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
				calcTotalCost();
	        	}
	        });

	        
	        JLabel screenLabel = new JLabel(obj.getScreenLabel());
	        screenLabel.setBounds(0, 122, 197, 20);
	        panel_1.add(screenLabel);
	        screenLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        JLabel spacerLabel = new JLabel(obj.getSpacerLabel());
	        spacerLabel.setBounds(0, 90, 197, 20);
	        panel_1.add(spacerLabel);
	        spacerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        JLabel glassStrengthLabel = new JLabel(obj.getGlassStrengthLabel());
	        glassStrengthLabel.setBounds(0, 64, 197, 20);
	        panel_1.add(glassStrengthLabel);
	        glassStrengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        

	        


	        spacerCostLabel.setBounds(387, 94, 70, 14);
	        panel_1.add(spacerCostLabel);
	        
	        glassStrengthCostLabel.setBounds(387, 68, 70, 14);
	        panel_1.add(glassStrengthCostLabel);
	        
	        energyOptionCostLabel.setBounds(387, 4, 70, 14);
	        panel_1.add(energyOptionCostLabel);
	        
	        glassList.setModel(new DefaultComboBoxModel(obj.getGlassList().toArray(new String[obj.getGlassList().size()])));
	        glassList.setSelectedIndex(0);
	        glassList.setBounds(207, 32, 170, 20);
	        panel_1.add(glassList);
	        
	        glassCostLabel.setBounds(387, 35, 70, 14);
	        panel_1.add(glassCostLabel);
	        
	        JLabel glassLabel = new JLabel(obj.getGlassLabel());
	        glassLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        glassLabel.setBounds(0, 31, 197, 20);
	        panel_1.add(glassLabel);
	                

	                

	                lblMinMax.setBounds(171, 12, 93, 16);
	                panel.add(lblMinMax);
	                lblMinMax.setFont(new Font("Dialog", Font.PLAIN, 12));
	                
	                JLabel lblMinMax_1 = new JLabel(obj.getHeightLabel());
	                lblMinMax_1.setHorizontalAlignment(SwingConstants.CENTER);
	                lblMinMax_1.setBounds(348, 12, 93, 16);
	                panel.add(lblMinMax_1);
	                lblMinMax_1.setFont(new Font("Dialog", Font.PLAIN, 12));
	                
	                JPanel panel_8 = new JPanel();
	                panel_8.setBounds(10, 28, 106, 29);
	                panel.add(panel_8);
	                
	                JLabel label = new JLabel("Windows Size");
	                panel_8.add(label);
	                label.setFont(new Font("Tahoma", Font.PLAIN, 16));
	                
	                JButton button = new JButton("Add");
	                button.setFont(new Font("Dialog", Font.BOLD, 14));
	                button.setBounds(868, 569, 83, 30);
	                panel.add(button);
	                
	                JPanel panel_10 = new JPanel();
	                panel_10.setBounds(10, 70, 467, 108);
	                panel.add(panel_10);
	                panel_10.setBorder(new TitledBorder(null, "Grid Options Per Sash", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	                panel_10.setLayout(null);
	                
	                JPanel panel_3 = new JPanel();
	                panel_3.setLayout(null);
	                panel_3.setBounds(10, 11, 417, 85);
	                panel_10.add(panel_3);
	                
	                JLabel label_1 = new JLabel("Sash 1");
	                label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
	                label_1.setBounds(0, 0, 100, 20);
	                panel_3.add(label_1);
	                
	                JComboBox grid1 = new JComboBox(new Vector(obj.getGridOptionsList()));
	                grid1.setSelectedIndex(0);
	                grid1.setBounds(100, 0, 120, 20);
	                panel_3.add(grid1);
	                
	                JComboBox grid2 = new JComboBox(new Vector(obj.getGridList2(grid1.getSelectedIndex())));
	                grid2.setSelectedIndex(0);
	                grid2.setEnabled(false);
	                grid2.setBounds(230, 0, 120, 20);
	                panel_3.add(grid2);
	                
	                JLabel label_2 = new JLabel("Sash 2");
	                label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
	                label_2.setBounds(0, 35, 100, 20);
	                panel_3.add(label_2);
	                
	                JComboBox grid3 = new JComboBox(new Vector(obj.getGridOptionsList()));
	                grid3.setSelectedIndex(0);
	                grid3.setEnabled(false);
	                grid3.setBounds(100, 35, 120, 20);
	                panel_3.add(grid3);
	                
	                JComboBox grid4 = new JComboBox(new Vector(obj.getGridList2(grid3.getSelectedIndex())));
	                grid4.setSelectedIndex(0);
	                grid4.setEnabled(false);
	                grid4.setBounds(230, 35, 120, 20);
	                panel_3.add(grid4);
	                
	                JCheckBox chckbxSameCheck = new JCheckBox("Same for both Sash");
	                chckbxSameCheck.setSelected(true);
	                chckbxSameCheck.setFont(new Font("Tahoma", Font.BOLD, 11));
	                chckbxSameCheck.setBounds(10, 62, 140, 23);
	                panel_3.add(chckbxSameCheck);
	                
	                JLabel sash1CostLabel = new JLabel();
	                sash1CostLabel.setText("$0.00");
	                sash1CostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	                sash1CostLabel.setBounds(360, 3, 60, 14);
	                panel_3.add(sash1CostLabel);
	                
	                JLabel sash2CostLabel = new JLabel();
	                sash2CostLabel.setText("$0.00");
	                sash2CostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	                sash2CostLabel.setBounds(360, 38, 60, 14);
	                panel_3.add(sash2CostLabel);
	                energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	    			glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	    			glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	    			spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	    			screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
	    			meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	    			winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	    			frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	    		    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	    		    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	    	        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	    			glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	    			glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
	    	        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
	    	        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
	    	        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	    	        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	    			glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	    	        reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	    	        mullCostLabel.setText("+$"+String.format("%.2f", mullCost)); 
	                energyOptionList.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent arg0) {
	                		calcUI();
	                		energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	                        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	            			calcTotalCost();
	                	}
	                });
	                glassList.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent arg0) {
	                		calcUI();
	                		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	                        glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	            			calcTotalCost();
	                	}
	                });
	                glassStrengthList.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent arg0) {
	                		calcUI();
	                		glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	                        glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
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
	                glassTintList.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent arg0) {
	                		calcUI();
	                		winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	                        glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	            			calcTotalCost();
	                	}
	                });
	                frameColorList.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent arg0) {
	                		calcUI();
	                		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	                        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	            			calcTotalCost();
	                	}
	                });
	                meshList.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                		calcUI();
	                		meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	                        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	            			calcTotalCost();
	                	}
	                });
	                chckbxOriels.addChangeListener(new ChangeListener() {
	                	public void stateChanged(ChangeEvent arg0) {
	                		if(chckbxOriels.isSelected()){
	                			orielCost=obj.getCustomExtrasPrice(1, ui);
	                            orielLabel.setText("+$"+String.format("%.2f", orielCost));       			
	                		}else{orielLabel.setText("+$0.00");orielCost=0;}
	        				calcTotalCost();
	                	}
	                });
	                chckbxPolyfoamWrap.addChangeListener(new ChangeListener() {
	                	public void stateChanged(ChangeEvent arg0) {
	                		if(chckbxPolyfoamWrap.isSelected()){
	                			wrapCost=obj.getCustomExtrasPrice(2, ui);
	                            wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
	                		}else{wrapLabel.setText("+$0.00");wrapCost=0;}
	        				calcTotalCost();
	                	}
	                });
	                chckbxLaminated.addChangeListener(new ChangeListener() {
	                	public void stateChanged(ChangeEvent arg0) {
	                		if(chckbxLaminated.isSelected()){
	                			lamCost=obj.getCustomExtrasPrice(3, ui);
	                            lamLabel.setText("+$"+String.format("%.2f", lamCost));       			
	                		}else{lamLabel.setText("+$0.00");lamCost=0;}
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
	                button.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                		switch(widthText.getText().toString()){
	                		case "0":
	                		emptyDimensionError_Frame edef = new emptyDimensionError_Frame("ERROR");
	                		edef.setVisible(true);
	                		break;
	                		default:
	                		if(Double.parseDouble(widthText.getText().toString())<14.5)
	                		{wrongWidthError_Frame wwef = new wrongWidthError_Frame("ERROR"); wwef.setVisible(true);}
	                		else if(Double.parseDouble(widthText.getText().toString())>48)
	                		{wrongWidthError_Frame wHef = new wrongWidthError_Frame("ERROR"); wHef.setVisible(true);};
	                		}
	                		switch(heightText.getText().toString()){
	                		case "0":
	                		emptyDimensionError_Frame edef = new emptyDimensionError_Frame("ERROR");
	                		edef.setVisible(true);
	                		break;
	                		default:
	                		if(Double.parseDouble(heightText.getText().toString())<22.5)
	                		{wrongHeightError_Frame wHef = new wrongHeightError_Frame("ERROR"); wHef.setVisible(true);}
	                		else if(Double.parseDouble(heightText.getText().toString())>76)
	                		{wrongHeightError_Frame wHef = new wrongHeightError_Frame("ERROR"); wHef.setVisible(true);};
	                		}
	                	}
	                });
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
	            			if (chckbxSameCheck.isSelected()) {
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
	            			if (chckbxSameCheck.isSelected()) {
	            				grid3.setSelectedIndex(grid1.getSelectedIndex());
	            				grid4.setModel(new DefaultComboBoxModel(new Vector(obj.getGridList2(grid3.getSelectedIndex()))));            		
	            				grid4.setSelectedIndex(grid2.getSelectedIndex());
	            			}
	                	}
	                });
	                grid3.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                		//update next box
	                		if (grid3.getSelectedIndex() != 0 && !chckbxSameCheck.isSelected()) grid4.setEnabled(true);
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
	                chckbxSameCheck.addItemListener(new ItemListener() {
	                	public void itemStateChanged(ItemEvent arg0) {
	            			if (chckbxSameCheck.isSelected()) {
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
	            	        		false);
	            	        UILabel.setText(status);
	            	        if (UILabel.getText().toLowerCase().equals(good)){
	        				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	        				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	        				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	        				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	        				screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
	        				meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	        				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	        				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	        				foamCost=obj.getCustomExtrasPrice(0, ui);
	        				orielCost=obj.getCustomExtrasPrice(1,ui);  
	        				wrapCost=obj.getCustomExtrasPrice(2, ui);
	        				lamCost=obj.getCustomExtrasPrice(3, ui);
	        			    sash1Cost=obj.getGridOptionsPrice(grid2.getSelectedIndex(), grid1.getSelectedIndex(), ui);
	        			    sash2Cost=obj.getGridOptionsPrice(grid4.getSelectedIndex(), grid3.getSelectedIndex(), ui);
	        			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	        			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	                        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	                		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	                		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
	                        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
	                        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
	                        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	                        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	                		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	                        foamLabel.setText("+$"+String.format("%.2f", foamCost)); 
	                        orielLabel.setText("+$"+String.format("%.2f", orielCost));
	                        wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
	                        lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
	                        sash1CostLabel.setText("+$"+String.format("%.2f", sash1Cost));
	                        sash2CostLabel.setText("+$"+String.format("%.2f", sash2Cost));   
	                        reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	                        mullCostLabel.setText("+$"+String.format("%.2f", mullCost));   		
	                		calcTotalCost();{
	            	        	sash1CostLabel.setText("$0.00");					
	            			    sash2CostLabel.setText("$0.00");
	            			    frameColorCostLabel.setText("$0.00");
	            			    energyOptionCostLabel.setText("$0.00");
	            			    glassStrengthCostLabel.setText("$0.00");
	            			    glassCostLabel.setText("$0.00");
	            			    screenCostLabel.setText("$0.00");
	            			    meshCostLabel.setText("$0.00");
	            			    spacerCostLabel.setText("$0.00"); 
	            			    mullCostLabel.setText("$0.00");
	            			    reinforcementCostLabel.setText("$0.00");
	            			    glassTintCostLabel.setText("$0.00");
	            				frameColorCostLabel.setText("$0.00");	
	            				foamLabel.setText("$0.00");
	            				orielLabel.setText("$0.00");
	            				wrapLabel.setText("$0.00");				
	            				lamLabel.setText("$0.00");	    				
	            				totalLabel.setText("$0.00");
	                		}
	            	        }
	                    }

	                    @Override
	                    public void removeUpdate(DocumentEvent de) {
	                    	calcUI();
	                    	status = obj.checkSize(width, height, 
	            	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
	            	        		false);
	            	        UILabel.setText(status);
	            	        if (UILabel.getText().toLowerCase().equals(good)){
	        				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	        				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	        				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	        				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	        				screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
	        				meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	        				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	        				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	        				foamCost=obj.getCustomExtrasPrice(0, ui);
	        				orielCost=obj.getCustomExtrasPrice(1,ui);  
	        				wrapCost=obj.getCustomExtrasPrice(2, ui);
	        				lamCost=obj.getCustomExtrasPrice(3, ui);
	        			    sash1Cost=obj.getGridOptionsPrice(grid2.getSelectedIndex(), grid1.getSelectedIndex(), ui);
	        			    sash2Cost=obj.getGridOptionsPrice(grid4.getSelectedIndex(), grid3.getSelectedIndex(), ui);
	        			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	        			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	                        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	                		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	                		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
	                        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
	                        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
	                        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	                        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	                		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	                        foamLabel.setText("+$"+String.format("%.2f", foamCost)); 
	                        orielLabel.setText("+$"+String.format("%.2f", orielCost));
	                        wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
	                        lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
	                        sash1CostLabel.setText("+$"+String.format("%.2f", sash1Cost));
	                        sash2CostLabel.setText("+$"+String.format("%.2f", sash2Cost));   
	                        reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	                        mullCostLabel.setText("+$"+String.format("%.2f", mullCost));   		
	                		calcTotalCost();{
	            	        	sash1CostLabel.setText("$0.00");					
	            			    sash2CostLabel.setText("$0.00");
	            			    frameColorCostLabel.setText("$0.00");
	            			    energyOptionCostLabel.setText("$0.00");
	            			    glassStrengthCostLabel.setText("$0.00");
	            			    glassCostLabel.setText("$0.00");
	            			    screenCostLabel.setText("$0.00");
	            			    meshCostLabel.setText("$0.00");
	            			    spacerCostLabel.setText("$0.00"); 
	            			    mullCostLabel.setText("$0.00");
	            			    reinforcementCostLabel.setText("$0.00");
	            			    glassTintCostLabel.setText("$0.00");
	            				frameColorCostLabel.setText("$0.00");	
	            				foamLabel.setText("$0.00");
	            				orielLabel.setText("$0.00");
	            				wrapLabel.setText("$0.00");				
	            				lamLabel.setText("$0.00");	    				
	            				totalLabel.setText("$0.00");
	                		}
	            	        }
	                    }

	                    @Override
	                    public void changedUpdate(DocumentEvent de) {
	                    	calcUI();
	                    	status = obj.checkSize(width, height, 
	            	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
	            	        		false);
	            	        UILabel.setText(status);
	            	        if (UILabel.getText().toLowerCase().equals(good)){
	        				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	        				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	        				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	        				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	        				screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
	        				meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	        				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	        				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	        				foamCost=obj.getCustomExtrasPrice(0, ui);
	        				orielCost=obj.getCustomExtrasPrice(1,ui);  
	        				wrapCost=obj.getCustomExtrasPrice(2, ui);
	        				lamCost=obj.getCustomExtrasPrice(3, ui);
	        			    sash1Cost=obj.getGridOptionsPrice(grid2.getSelectedIndex(), grid1.getSelectedIndex(), ui);
	        			    sash2Cost=obj.getGridOptionsPrice(grid4.getSelectedIndex(), grid3.getSelectedIndex(), ui);
	        			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	        			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	                        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	                		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	                		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
	                        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
	                        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
	                        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	                        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	                		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	                        foamLabel.setText("+$"+String.format("%.2f", foamCost)); 
	                        orielLabel.setText("+$"+String.format("%.2f", orielCost));
	                        wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
	                        lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
	                        sash1CostLabel.setText("+$"+String.format("%.2f", sash1Cost));
	                        sash2CostLabel.setText("+$"+String.format("%.2f", sash2Cost));   
	                        reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	                        mullCostLabel.setText("+$"+String.format("%.2f", mullCost));   		
	                		calcTotalCost();{
	            	        	sash1CostLabel.setText("$0.00");					
	            			    sash2CostLabel.setText("$0.00");
	            			    frameColorCostLabel.setText("$0.00");
	            			    energyOptionCostLabel.setText("$0.00");
	            			    glassStrengthCostLabel.setText("$0.00");
	            			    glassCostLabel.setText("$0.00");
	            			    screenCostLabel.setText("$0.00");
	            			    meshCostLabel.setText("$0.00");
	            			    spacerCostLabel.setText("$0.00"); 
	            			    mullCostLabel.setText("$0.00");
	            			    reinforcementCostLabel.setText("$0.00");
	            			    glassTintCostLabel.setText("$0.00");
	            				frameColorCostLabel.setText("$0.00");	
	            				foamLabel.setText("$0.00");
	            				orielLabel.setText("$0.00");
	            				wrapLabel.setText("$0.00");				
	            				lamLabel.setText("$0.00");	    				
	            				totalLabel.setText("$0.00");
	                		}
	            	        }
	                    }
	                });
	                heightText.getDocument().addDocumentListener(new DocumentListener() {

	                    @Override
	                    public void insertUpdate(DocumentEvent de) {
	                    	calcUI();
	                    	status = obj.checkSize(width, height, 
	            	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
	            	        		false);
	            	        UILabel.setText(status);
	            	        if (UILabel.getText().toLowerCase().equals(good)){
	        				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	        				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	        				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	        				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	        				screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
	        				meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	        				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	        				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	        				foamCost=obj.getCustomExtrasPrice(0, ui);
	        				orielCost=obj.getCustomExtrasPrice(1,ui);  
	        				wrapCost=obj.getCustomExtrasPrice(2, ui);
	        				lamCost=obj.getCustomExtrasPrice(3, ui);
	        			    sash1Cost=obj.getGridOptionsPrice(grid2.getSelectedIndex(), grid1.getSelectedIndex(), ui);
	        			    sash2Cost=obj.getGridOptionsPrice(grid4.getSelectedIndex(), grid3.getSelectedIndex(), ui);
	        			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	        			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	                        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	                		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	                		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
	                        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
	                        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
	                        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	                        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	                		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	                        foamLabel.setText("+$"+String.format("%.2f", foamCost)); 
	                        orielLabel.setText("+$"+String.format("%.2f", orielCost));
	                        wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
	                        lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
	                        sash1CostLabel.setText("+$"+String.format("%.2f", sash1Cost));
	                        sash2CostLabel.setText("+$"+String.format("%.2f", sash2Cost));   
	                        reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	                        mullCostLabel.setText("+$"+String.format("%.2f", mullCost));   		
	                		calcTotalCost();{
	            	        	sash1CostLabel.setText("$0.00");					
	            			    sash2CostLabel.setText("$0.00");
	            			    frameColorCostLabel.setText("$0.00");
	            			    energyOptionCostLabel.setText("$0.00");
	            			    glassStrengthCostLabel.setText("$0.00");
	            			    glassCostLabel.setText("$0.00");
	            			    screenCostLabel.setText("$0.00");
	            			    meshCostLabel.setText("$0.00");
	            			    spacerCostLabel.setText("$0.00"); 
	            			    mullCostLabel.setText("$0.00");
	            			    reinforcementCostLabel.setText("$0.00");
	            			    glassTintCostLabel.setText("$0.00");
	            				frameColorCostLabel.setText("$0.00");	
	            				foamLabel.setText("$0.00");
	            				orielLabel.setText("$0.00");
	            				wrapLabel.setText("$0.00");				
	            				lamLabel.setText("$0.00");	    				
	            				totalLabel.setText("$0.00");
	                		}
	            	        }
	                    }

	                    @Override
	                    public void removeUpdate(DocumentEvent de) {
	                    	calcUI();
	                    	status = obj.checkSize(width, height, 
	            	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
	            	        		false);
	            	        UILabel.setText(status);
	            	        if (UILabel.getText().toLowerCase().equals(good)){
	        				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	        				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	        				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	        				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	        				screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
	        				meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	        				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	        				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	        				foamCost=obj.getCustomExtrasPrice(0, ui);
	        				orielCost=obj.getCustomExtrasPrice(1,ui);  
	        				wrapCost=obj.getCustomExtrasPrice(2, ui);
	        				lamCost=obj.getCustomExtrasPrice(3, ui);
	        			    sash1Cost=obj.getGridOptionsPrice(grid2.getSelectedIndex(), grid1.getSelectedIndex(), ui);
	        			    sash2Cost=obj.getGridOptionsPrice(grid4.getSelectedIndex(), grid3.getSelectedIndex(), ui);
	        			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	        			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	                        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	                		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	                		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
	                        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
	                        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
	                        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	                        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	                		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	                        foamLabel.setText("+$"+String.format("%.2f", foamCost)); 
	                        orielLabel.setText("+$"+String.format("%.2f", orielCost));
	                        wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
	                        lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
	                        sash1CostLabel.setText("+$"+String.format("%.2f", sash1Cost));
	                        sash2CostLabel.setText("+$"+String.format("%.2f", sash2Cost));   
	                        reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	                        mullCostLabel.setText("+$"+String.format("%.2f", mullCost));   		
	                		calcTotalCost();{
	            	        	sash1CostLabel.setText("$0.00");					
	            			    sash2CostLabel.setText("$0.00");
	            			    frameColorCostLabel.setText("$0.00");
	            			    energyOptionCostLabel.setText("$0.00");
	            			    glassStrengthCostLabel.setText("$0.00");
	            			    glassCostLabel.setText("$0.00");
	            			    screenCostLabel.setText("$0.00");
	            			    meshCostLabel.setText("$0.00");
	            			    spacerCostLabel.setText("$0.00"); 
	            			    mullCostLabel.setText("$0.00");
	            			    reinforcementCostLabel.setText("$0.00");
	            			    glassTintCostLabel.setText("$0.00");
	            				frameColorCostLabel.setText("$0.00");	
	            				foamLabel.setText("$0.00");
	            				orielLabel.setText("$0.00");
	            				wrapLabel.setText("$0.00");				
	            				lamLabel.setText("$0.00");	    				
	            				totalLabel.setText("$0.00");
	                		}
	            	        }
	                    }

	                    @Override
	                    public void changedUpdate(DocumentEvent de) {
	                    	calcUI();
	                    	status = obj.checkSize(width, height, 
	            	        		String.valueOf(glassStrengthList.getSelectedItem()).toLowerCase().contains("temp"), 
	            	        		false);
	            	        UILabel.setText(status);
	            	        if (UILabel.getText().toLowerCase().equals(good)){
	        				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
	        				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	        				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
	        				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
	        				screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
	        				meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
	        				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
	        				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	        				foamCost=obj.getCustomExtrasPrice(0, ui);
	        				orielCost=obj.getCustomExtrasPrice(1,ui);  
	        				wrapCost=obj.getCustomExtrasPrice(2, ui);
	        				lamCost=obj.getCustomExtrasPrice(3, ui);
	        			    sash1Cost=obj.getGridOptionsPrice(grid2.getSelectedIndex(), grid1.getSelectedIndex(), ui);
	        			    sash2Cost=obj.getGridOptionsPrice(grid4.getSelectedIndex(), grid3.getSelectedIndex(), ui);
	        			    reinforcementCost=obj.getReinforcementPrice(reinforcementList.getSelectedIndex());
	        			    mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
	                        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
	                		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
	                		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
	                        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
	                        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
	                        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	                        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
	                		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
	                        foamLabel.setText("+$"+String.format("%.2f", foamCost)); 
	                        orielLabel.setText("+$"+String.format("%.2f", orielCost));
	                        wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
	                        lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
	                        sash1CostLabel.setText("+$"+String.format("%.2f", sash1Cost));
	                        sash2CostLabel.setText("+$"+String.format("%.2f", sash2Cost));   
	                        reinforcementCostLabel.setText("+$"+String.format("%.2f", reinforcementCost));
	                        mullCostLabel.setText("+$"+String.format("%.2f", mullCost));   		
	                		calcTotalCost();{
	            	        	sash1CostLabel.setText("$0.00");					
	            			    sash2CostLabel.setText("$0.00");
	            			    frameColorCostLabel.setText("$0.00");
	            			    energyOptionCostLabel.setText("$0.00");
	            			    glassStrengthCostLabel.setText("$0.00");
	            			    glassCostLabel.setText("$0.00");
	            			    screenCostLabel.setText("$0.00");
	            			    meshCostLabel.setText("$0.00");
	            			    spacerCostLabel.setText("$0.00"); 
	            			    mullCostLabel.setText("$0.00");
	            			    reinforcementCostLabel.setText("$0.00");
	            			    glassTintCostLabel.setText("$0.00");
	            				frameColorCostLabel.setText("$0.00");	
	            				foamLabel.setText("$0.00");
	            				orielLabel.setText("$0.00");
	            				wrapLabel.setText("$0.00");				
	            				lamLabel.setText("$0.00");	    				
	            				totalLabel.setText("$0.00");
	                		}
	            	        }
	                    }
	                });
	        		calcTotalCost();
	        return panel;
        
    }


	public void actionPerformed(ActionEvent e){
	}
}
