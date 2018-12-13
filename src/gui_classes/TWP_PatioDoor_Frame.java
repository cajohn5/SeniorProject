package gui_classes;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TWP_PatioDoor_Frame extends JFrame implements ActionListener{
	//list of all components of the frame
	private JPanel contentPane;
	JLabel totalLabel = new JLabel("$0.00");
	private double energyCost = 0;
	private double glassTypeCost = 0;
	private double spaceCost = 0;
	private double screenCost = 0;
	private double meshCost = 0;
	private double winColorCost = 0;
	private double winTintCost = 0;
	private double lockColorCost = 0;
	private double tiltMiniblindsCost = 0;
	private double frameColorCost = 0;
	private double woodgrainCost = 0;
	private double custCost1 = 0;
	private double custCost2 = 0;
	private double custCost3 = 0;
	private double custCost4 = 0;
	private double sash1Cost = 0;
	private double sash2Cost = 0;
	private double totalCost = 0;
	
	private int energyHolder;
	private Float realUI;
	private float ui;
	
	private Windows obj;
	
	//creates the frame
	public TWP_PatioDoor_Frame(int index, Holder holder) {
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
		lblWindowTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(lblWindowTypeLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Price");
		panel_1.add(label_1);
		
		panel_1.add(totalLabel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
	
	
	//private methods
		private void calcTotalCost() {
			totalCost = energyCost + glassTypeCost + screenCost + meshCost + spaceCost + winColorCost + winTintCost + lockColorCost + tiltMiniblindsCost + frameColorCost + woodgrainCost + custCost1 + custCost2 + custCost3 + custCost4 + sash1Cost + sash2Cost ;
			totalLabel.setText("$"+String.format("%.2f", totalCost));
		}	
	
	//This is the panel of the home tab
	protected JComponent makeWindowPanel() {
        JPanel panel = new JPanel();       
        panel.setLayout(null);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Grid Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(11, 83, 467, 116);
        panel.add(panel_6);
        panel_6.setLayout(null);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(6, 16, 449, 89);
        panel_6.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel grid = new JLabel("Sash");
        grid.setBounds(0, 0, 100, 20);
        panel_4.add(grid);
        grid.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox grid1 = new JComboBox(new Vector(obj.getGridOptionsList()));
        grid1.setSelectedIndex(0);
        grid1.setBounds(100, 0, 120, 20);
        panel_4.add(grid1);
        
        JComboBox grid2 = new JComboBox(new Vector(obj.getGridList2(grid1.getSelectedIndex())));
        grid2.setEnabled(false);
        grid2.setSelectedIndex(0);
        grid2.setBounds(230, 0, 120, 20);
        panel_4.add(grid2);
        
        JLabel sash1CostLabel = new JLabel();
        sash1CostLabel.setBounds(360, 3, 53, 14);
        panel_4.add(sash1CostLabel);
        
        
        
        
        JLabel label_9 = new JLabel();
        label_9.setBounds(360, 38, 53, 14);
        panel_4.add(label_9);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(484, 6, 480, 301);
        panel.add(panel_7);
        panel_7.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 16, 377, 119);
        panel_7.add(panel_2);
        panel_2.setLayout(null);
        
        //custom extras       
        JCheckBox customExtra1 = new JCheckBox(obj.getCustomExtrasList().get(0));
        customExtra1.setFont(new Font("Dialog", Font.PLAIN, 14));
        customExtra1.setBounds(-2, 7, 294, 23);
        panel_2.add(customExtra1);
        
        JCheckBox customExtra2 = new JCheckBox(obj.getCustomExtrasList().get(1));
        customExtra2.setFont(new Font("Dialog", Font.PLAIN, 14));
        customExtra2.setBounds(-2, 33, 294, 23);
        panel_2.add(customExtra2);
        
        JCheckBox customExtra3 = new JCheckBox(obj.getCustomExtrasList().get(2));
        customExtra3.setFont(new Font("Dialog", Font.PLAIN, 14));
        customExtra3.setBounds(-2, 59, 294, 23);
        panel_2.add(customExtra3);
        
        JCheckBox customExtra4 = new JCheckBox(obj.getCustomExtrasList().get(3));
        customExtra4.setFont(new Font("Dialog", Font.PLAIN, 14));
        customExtra4.setBounds(-2, 85, 294, 23);
        panel_2.add(customExtra4);
        
        
        JLabel extraPrice2 = new JLabel();
        extraPrice2.setBounds(300, 33, 55, 14);
        panel_2.add(extraPrice2);
        
        JLabel label = new JLabel();
        label.setBounds(186, 13, 55, 14);
        panel_2.add(label);

        JLabel extraPrice3 = new JLabel();
        extraPrice3.setBounds(300, 59, 55, 14);
        panel_2.add(extraPrice3);

        JLabel extraPrice4 = new JLabel();
        extraPrice4.setBounds(300, 85, 55, 14);
        panel_2.add(extraPrice4);
        
        JLabel extraPrice1 = new JLabel();
        extraPrice1.setBounds(300, 7, 55, 14);
        panel_2.add(extraPrice1);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(11, 223, 467, 376);
        panel.add(panel_5);
        panel_5.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(6, 16, 449, 359);
        panel_5.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel label_3 = new JLabel(obj.getEnergyOptionsLabel());
        label_3.setBounds(0, 0, 189, 20);
        panel_1.add(label_3);
        label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox energyOptionsList = new JComboBox(new Vector(obj.getEnergyOptionsList()));
        energyOptionsList.setSelectedIndex(0);
        energyOptionsList.setBounds(199, 0, 170, 20);
        panel_1.add(energyOptionsList);
        
        JComboBox screenList = new JComboBox(new Vector(obj.getScreenList()));
        screenList.setSelectedIndex(0);
        screenList.setBounds(199, 64, 170, 20);
        panel_1.add(screenList);
        
        JComboBox spacerList = new JComboBox(new Vector(obj.getSpacerList()));
        spacerList.setSelectedIndex(0);
        spacerList.setBounds(199, 129, 170, 20);
        panel_1.add(spacerList);
        
        JLabel label_5 = new JLabel(obj.getSpacerLabel());
        label_5.setBounds(0, 129, 189, 20);
        panel_1.add(label_5);
        label_5.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel lblScreen = new JLabel(obj.getScreenLabel());
        lblScreen.setBounds(0, 64, 189, 20);
        panel_1.add(lblScreen);
        lblScreen.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel spacerCostLabel = new JLabel();
        spacerCostLabel.setBounds(387, 129, 50, 14);
        panel_1.add(spacerCostLabel);
        
        JLabel screenCostLabel = new JLabel();
        screenCostLabel.setBounds(387, 64, 50, 14);
        panel_1.add(screenCostLabel);
        
        JLabel energyOptionsCostLabel = new JLabel();
        energyOptionsCostLabel.setBounds(387, 0, 50, 14);
        panel_1.add(energyOptionsCostLabel);
        
        JComboBox glassList = new JComboBox(new Vector(obj.getGlassList()));
        glassList.setSelectedIndex(0);
        glassList.setBounds(199, 31, 170, 20);
        panel_1.add(glassList);
        
        JLabel glassCostLabel = new JLabel();
        glassCostLabel.setBounds(387, 31, 50, 14);
        panel_1.add(glassCostLabel);
        
        JLabel lblGlass = new JLabel(obj.getGlassLabel());
        lblGlass.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblGlass.setBounds(0, 31, 189, 20);
        panel_1.add(lblGlass);
        
        JLabel glassTintCostLabel = new JLabel();
        glassTintCostLabel.setBounds(387, 160, 50, 14);
        panel_1.add(glassTintCostLabel);
        
        JComboBox tintList = new JComboBox(new Vector(obj.getGlassTintList()));
        tintList.setSelectedIndex(0);
        tintList.setBounds(199, 160, 170, 20);
        panel_1.add(tintList);
        
        JLabel label_10 = new JLabel(obj.getGlassTintLabel());
        label_10.setFont(new Font("Dialog", Font.PLAIN, 14));
        label_10.setBounds(0, 160, 189, 20);
        panel_1.add(label_10);
        
        JLabel lblHardwareColor = new JLabel(obj.getLockColorLabel());
        lblHardwareColor.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblHardwareColor.setBounds(0, 222, 189, 20);
        panel_1.add(lblHardwareColor);
        
        JComboBox handleColorList = new JComboBox(new Vector(obj.getLockColorList()));
        handleColorList.setSelectedIndex(0);
        handleColorList.setBounds(199, 222, 170, 20);
        panel_1.add(handleColorList);
        
        JLabel lockColorCostLabel = new JLabel();
        lockColorCostLabel.setBounds(387, 222, 50, 14);
        panel_1.add(lockColorCostLabel);
        
        JLabel lblscreenMesh = new JLabel(obj.getScreenMeshLabel());
        lblscreenMesh.setBounds(0, 98, 189, 20);
        panel_1.add(lblscreenMesh);
        lblscreenMesh.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel screenMeshCostLabel = new JLabel();
        screenMeshCostLabel.setBounds(387, 95, 50, 14);
        panel_1.add(screenMeshCostLabel);
        
        JComboBox screenMeshList = new JComboBox(new Vector(obj.getScreenMeshList()));
        screenMeshList.setSelectedIndex(0);
        screenMeshList.setBounds(199, 95, 170, 20);
        panel_1.add(screenMeshList);
        
        JLabel lblFrame = new JLabel(obj.getExteriorPaintLabel());
        lblFrame.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblFrame.setBounds(0, 191, 189, 20);
        panel_1.add(lblFrame);
        
        JComboBox exteriorList = new JComboBox(new Vector(obj.getExteriorPaintList()));
        exteriorList.setSelectedIndex(0);
        exteriorList.setBounds(199, 191, 170, 20);
        panel_1.add(exteriorList);
        
        JLabel exteriorPaintCostLabel = new JLabel();
        exteriorPaintCostLabel.setBounds(387, 191, 50, 14);
        panel_1.add(exteriorPaintCostLabel);
        
        JLabel lblWoodgrain = new JLabel(obj.getWoodgrainsLabel());
        lblWoodgrain.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblWoodgrain.setBounds(0, 253, 189, 20);
        panel_1.add(lblWoodgrain);
        
        JComboBox comboBox_2 = new JComboBox(new Vector(obj.getWoodgrainsList()));
        comboBox_2.setSelectedIndex(0);
        comboBox_2.setBounds(199, 253, 170, 20);
        panel_1.add(comboBox_2);
        
        JLabel label_11 = new JLabel();
        label_11.setBounds(387, 253, 50, 14);
        panel_1.add(label_11);
        
        JLabel lblFrameColor = new JLabel(obj.getFrameColorLabel());
        lblFrameColor.setFont(new Font("Dialog", Font.PLAIN, 14));
        lblFrameColor.setBounds(0, 284, 189, 20);
        panel_1.add(lblFrameColor);
        
        JComboBox frameColorList = new JComboBox(new Vector(obj.getFrameColorList()));
        frameColorList.setSelectedIndex(0);
        frameColorList.setBounds(199, 284, 170, 20);
        panel_1.add(frameColorList);
        
        JLabel frameColorCostLabel = new JLabel();
        frameColorCostLabel.setBounds(387, 284, 50, 14);
        panel_1.add(frameColorCostLabel);
        
        JLabel miniblindLabel = new JLabel(obj.getMiniblindsLabel());
        miniblindLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        miniblindLabel.setBounds(0, 315, 189, 20);
        panel_1.add(miniblindLabel);
        
        JComboBox miniblindList = new JComboBox(new Vector(obj.getMiniblindsList()));
        miniblindList.setSelectedIndex(0);
        miniblindList.setBounds(199, 315, 170, 20);
        panel_1.add(miniblindList);
               
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "Size", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.setBounds(10, 6, 468, 70);
        panel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Size");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 23, 47, 20);
        panel_3.add(lblNewLabel);
        
        JComboBox sizeComboBox = new JComboBox(new Vector(obj.getPatioSize()));
        sizeComboBox.setSelectedIndex(0);
        sizeComboBox.setBounds(67, 23, 196, 20);
        panel_3.add(sizeComboBox);
        
        JLabel miniblindsCostLabel = new JLabel();
		miniblindsCostLabel.setBounds(387, 320, 50, 14);
		panel_1.add(miniblindsCostLabel);
        
		
        //close button
        JButton button = new JButton("Close");
        button.setFont(new Font("Dialog", Font.BOLD, 14));
        button.setBounds(868, 569, 83, 30);
        panel.add(button);
        
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        
         
        //actions
        sizeComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {       		
        		realUI = obj.getPatioUI(sizeComboBox.getSelectedIndex());		     
                ui = obj.getPatioNum(sizeComboBox.getSelectedIndex());
                
            	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
            	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
        	    
        	    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
        	    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
        	    
        	    //sets the energyOptions based on size selected
        	    energyHolder = energyOptionsList.getSelectedIndex();
        		energyOptionsList.setModel(new DefaultComboBoxModel(new Vector(obj.getPatioEnergyList(sizeComboBox.getSelectedIndex()))));
        	    //energyOptionsList.anew JComboBox(new Vector(obj.getPatioEnergyList(sizeComboBox.getSelectedIndex())));
        	    energyOptionsList.setSelectedIndex(energyHolder);
        	    energyOptionsList.setSelectedIndex(energyHolder);
        		energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
        	    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
        	    
        	    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
        	    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
        	    
        	    screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
                screenCostLabel.setText("$"+String.format("%.2f", screenCost));
        	    
        	    meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
        	    screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
        	    
        	    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
        	    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 	    

        		winTintCost=obj.getGlassTintPrice(tintList.getSelectedIndex(),ui);
        		glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
        		
        		winColorCost=obj.getExteriorPaintPrice(exteriorList.getSelectedIndex());
        		exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
        		
        		lockColorCost=obj.getLockColorPrice(handleColorList.getSelectedIndex(), false);	                
        		lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
        		        		
        		energyHolder = miniblindList.getSelectedIndex();
        		miniblindList.setModel(new DefaultComboBoxModel(new Vector(obj.getPatioMiniblindList(sizeComboBox.getSelectedIndex()))));
        		miniblindList.setSelectedIndex(energyHolder);
        		tiltMiniblindsCost=obj.getMiniblindsPrice(miniblindList.getSelectedIndex(), ui);
        		miniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
        		
        		if (customExtra1.isSelected()) {
        			custCost1=obj.getCustomExtrasPrice(0, ui);
        			extraPrice1.setText("$"+String.format("%.2f", custCost1));
        		} else extraPrice1.setText("$0.00");
        		if (customExtra2.isSelected()) {
        			custCost2=obj.getCustomExtrasPrice(1, ui);
        			extraPrice2.setText("$"+String.format("%.2f", custCost2));
        		} else extraPrice2.setText("$0.00");
        		if (customExtra3.isSelected()) {
        			custCost3=obj.getCustomExtrasPrice(2, ui);
        			extraPrice3.setText("$"+String.format("%.2f", custCost3));
        		} else extraPrice3.setText("$0.00");
        		if (customExtra4.isSelected()) {
        			custCost4=obj.getCustomExtrasPrice(3, ui);
        			extraPrice4.setText("$"+String.format("%.2f", custCost4));
        		} else extraPrice4.setText("$0.00");
    			calcTotalCost();
        	}
        });
        
        frameColorList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {       		
        		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
                frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
    			calcTotalCost();
        	}
        });
        
        energyOptionsList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
    			energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
    			energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
    			calcTotalCost();
        	}
        });
 
        glassList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
        		glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
    			calcTotalCost();
        	}
        });
        
        screenList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
                screenCostLabel.setText("$"+String.format("%.2f", screenCost));
    			calcTotalCost();
        	}
        });
        
        screenMeshList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
        		screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
    			calcTotalCost();
        	}
        });
        
        spacerList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),realUI);
                spacerCostLabel.setText("$"+String.format("%.2f", spaceCost));
    			calcTotalCost();
        	}
        });
        
				
        miniblindList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tiltMiniblindsCost=obj.getMiniblindsPrice(miniblindList.getSelectedIndex(), ui);
        		miniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
            	calcTotalCost();
        	}
        });
        
        tintList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		winTintCost=obj.getGlassTintPrice(tintList.getSelectedIndex(),ui);
        		glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
    			calcTotalCost();
        	}
        });
        

        exteriorList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		winColorCost=obj.getExteriorPaintPrice(exteriorList.getSelectedIndex());
        		exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));
    			calcTotalCost();
        	}
        });
        
        handleColorList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {   		
        		lockColorCost=obj.getLockColorPrice(handleColorList.getSelectedIndex(), false);	                
        		lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
            	calcTotalCost();		
        	}
        });
 
        //custom extra actions
        customExtra1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(customExtra1.isSelected()){
        			custCost1=obj.getCustomExtrasPrice(0, ui);
        			extraPrice1.setText("$"+String.format("%.2f", custCost1));       			
        		}else{extraPrice1.setText("$0.00");custCost1=0;}
				calcTotalCost();
        	}
        });

        customExtra2.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(customExtra2.isSelected()){
        			custCost2=obj.getCustomExtrasPrice(1, ui);
        			extraPrice2.setText("$"+String.format("%.2f", custCost2));       			
        		}else{extraPrice2.setText("$0.00");custCost2=0;}
				calcTotalCost();
        	}
        });	      

        customExtra3.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent arg0) {
        		if(customExtra3.isSelected()){
        			custCost3=obj.getCustomExtrasPrice(2, ui);
        			extraPrice3.setText("$"+String.format("%.2f", custCost3));       			
        		}else{extraPrice3.setText("$0.00");custCost3=0;}
				calcTotalCost();
        	}
        });
        
        customExtra4.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent arg0) {
        		if(customExtra4.isSelected()){
        			custCost4=obj.getCustomExtrasPrice(3, ui);
        			extraPrice4.setText("$"+String.format("%.2f", custCost4));       			
        		}else{extraPrice4.setText("$0.00");custCost4=0;}
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
        		sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
        		sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
    			calcTotalCost(); 			
        	}
        });
        grid2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//update cost       		
	        		sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
	        		sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    			calcTotalCost();   			
        	}
        });     
        
        
        //does the start up prices
        realUI = obj.getPatioUI(sizeComboBox.getSelectedIndex());
        ui = obj.getPatioNum(sizeComboBox.getSelectedIndex());
        
    	sash1Cost=obj.getGridOptionsPrice(grid1.getSelectedIndex(), grid2.getSelectedIndex(), ui);
    	sash1CostLabel.setText("$"+String.format("%.2f", sash1Cost));
	    
	    frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
	    frameColorCostLabel.setText("$"+String.format("%.2f", frameColorCost));
	    
	    energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
	    energyOptionsCostLabel.setText("$"+String.format("%.2f", energyCost));
	    
	    glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
	    glassCostLabel.setText("$"+String.format("%.2f", glassTypeCost));
	    
	    screenCost=obj.getScreenPrice(screenList.getSelectedIndex());
        screenCostLabel.setText("$"+String.format("%.2f", screenCost));
	    
	    meshCost=obj.getScreenMeshPrice(screenMeshList.getSelectedIndex());
	    screenMeshCostLabel.setText("$"+String.format("%.2f", meshCost));
	    
	    spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),realUI);
	    spacerCostLabel.setText("$"+String.format("%.2f", spaceCost)); 	    

		winTintCost=obj.getGlassTintPrice(tintList.getSelectedIndex(),ui);
		glassTintCostLabel.setText("$"+String.format("%.2f", winTintCost));
		
		winColorCost=obj.getExteriorPaintPrice(exteriorList.getSelectedIndex());
		exteriorPaintCostLabel.setText("$"+String.format("%.2f", winColorCost));	
		
		lockColorCost=obj.getLockColorPrice(handleColorList.getSelectedIndex(), false);	                
		lockColorCostLabel.setText("$"+String.format("%.2f", lockColorCost));
		
		energyHolder = miniblindList.getSelectedIndex();
		miniblindList.setModel(new DefaultComboBoxModel(new Vector(obj.getPatioMiniblindList(sizeComboBox.getSelectedIndex()))));
		miniblindList.setSelectedIndex(energyHolder);
		tiltMiniblindsCost=obj.getMiniblindsPrice(miniblindList.getSelectedIndex(), ui);
		miniblindsCostLabel.setText("$"+String.format("%.2f", tiltMiniblindsCost));
		
		if (customExtra1.isSelected()) {
			custCost1=obj.getCustomExtrasPrice(0, ui);
			extraPrice1.setText("$"+String.format("%.2f", custCost1));
		} else extraPrice1.setText("$0.00");
		if (customExtra2.isSelected()) {
			custCost2=obj.getCustomExtrasPrice(1, ui);
			extraPrice2.setText("$"+String.format("%.2f", custCost2));
		} else extraPrice2.setText("$0.00");
		if (customExtra3.isSelected()) {
			custCost3=obj.getCustomExtrasPrice(2, ui);
			extraPrice3.setText("$"+String.format("%.2f", custCost3));
		} else extraPrice3.setText("$0.00");
		if (customExtra4.isSelected()) {
			custCost4=obj.getCustomExtrasPrice(3, ui);
			extraPrice4.setText("$"+String.format("%.2f", custCost4));
		} else extraPrice4.setText("$0.00");
		
        calcTotalCost();
        
        return panel;
        
    }

	public void actionPerformed(ActionEvent e){
	}
}
