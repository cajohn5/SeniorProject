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
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import excel_reader_classes.MasterExcelReading;
import product_classes.Holder;
import product_classes.Windows;

public class DW_PatioDoor_Frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	

	private double energyCost = 0;
	private double glassTypeCost = 0;
	private double screenCost = 0;
	private double meshCost = 0;
	private double spaceCost = 0;
	private double hardwareColorCost = 0;
	private double glassTintCost = 0;
	private double frameColorCost = 0;
	private double foamCost = 0;
	private double keyedCost = 0;
	private double sash1Cost = 0;
	private double sash2Cost = 0;
	private double totalCost = 0;
//	private Holder holder = new Holder();
	private Float ui = (float) 0;
	private int index;
	private Windows obj;
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
	public DW_PatioDoor_Frame(int index, Holder holder) {
		this.index = holder.getProductIndex(index);
		obj = ((Windows) holder.getDynaWeld().get(index));
//sets up the frame
		setTitle("Door");
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
		
		JLabel totalLabel = new JLabel("$0.00");
		panel_1.add(totalLabel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	private void calcTotalCost() {
		totalCost = energyCost +glassTypeCost +spaceCost +screenCost +meshCost +hardwareColorCost +foamCost +keyedCost +glassTintCost +frameColorCost +sash1Cost +sash2Cost;
		totalLabel.setText("$"+String.format("%.2f", totalCost));
		}
	
//This is the panel of the home tab
	protected JComponent makeWindowPanel() {
        JPanel panel = new JPanel();
        //panel.setLayout(new AbsoluteLayout(0,0));
        panel.setLayout(null);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Grid Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(11, 7, 467, 116);
        panel.add(panel_6);
        panel_6.setLayout(null);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(6, 16, 449, 89);
        panel_6.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel label_1 = new JLabel("Sash 1");
        label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
        label_1.setBounds(0, 0, 100, 20);
        panel_4.add(label_1);
        
        JComboBox grid1 = new JComboBox(new Vector(obj.getGridOptionsList()));
        grid1.setSelectedIndex(0);
        grid1.setBounds(100, 0, 120, 20);
        panel_4.add(grid1);
        
        JComboBox grid2 = new JComboBox(new Vector(obj.getGridList2(grid1.getSelectedIndex())));
        grid2.setSelectedIndex(0);
        grid2.setEnabled(false);
        grid2.setBounds(230, 0, 120, 20);
        panel_4.add(grid2);
        
        JLabel label_2 = new JLabel("Sash 2");
        label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
        label_2.setBounds(0, 35, 100, 20);
        panel_4.add(label_2);
        
        JComboBox grid3 = new JComboBox(new Vector(obj.getGridOptionsList()));
        grid3.setSelectedIndex(0);
        grid3.setEnabled(false);
        grid3.setBounds(100, 35, 120, 20);
        panel_4.add(grid3);
        
        JComboBox grid4 = new JComboBox(new Vector(obj.getGridList2(grid3.getSelectedIndex())));
        grid4.setSelectedIndex(0);
        grid4.setEnabled(false);
        grid4.setBounds(230, 35, 120, 20);
        panel_4.add(grid4);
        
        JCheckBox chckbxSameCheck = new JCheckBox("Same for both Sash");
        chckbxSameCheck.setSelected(true);
        chckbxSameCheck.setFont(new Font("Tahoma", Font.BOLD, 11));
        chckbxSameCheck.setBounds(10, 62, 140, 23);
        panel_4.add(chckbxSameCheck);
        
        JLabel sash1CostLabel = new JLabel();
        sash1CostLabel.setText("$0.00");
        sash1CostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        sash1CostLabel.setBounds(360, 3, 60, 14);
        panel_4.add(sash1CostLabel);
        
        JLabel sash2CostLabel = new JLabel();
        sash2CostLabel.setText("$0.00");
        sash2CostLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        sash2CostLabel.setBounds(360, 38, 60, 14);
        panel_4.add(sash2CostLabel);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(484, 6, 480, 301);
        panel.add(panel_7);
        panel_7.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 16, 464, 119);
        panel_7.add(panel_2);
        panel_2.setLayout(null);
        
        JCheckBox chckbxKeyedCylinder = new JCheckBox(obj.getCustomExtrasList().get(1));
        chckbxKeyedCylinder.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxKeyedCylinder.setBounds(-2, 33, 121, 23);
        panel_2.add(chckbxKeyedCylinder);
        
        JCheckBox chckbxFoamFilledMain = new JCheckBox(obj.getCustomExtrasList().get(0));
        chckbxFoamFilledMain.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxFoamFilledMain.setBounds(-2, 7, 145, 23);
        panel_2.add(chckbxFoamFilledMain);
        
        JLabel keyedLabel = new JLabel("+$0.00");
        keyedLabel.setBounds(399, 39, 55, 14);
        panel_2.add(keyedLabel);
        
        JLabel foamLabel = new JLabel("+$0.00");
        foamLabel.setBounds(399, 13, 55, 14);
        panel_2.add(foamLabel);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(13, 129, 467, 360);
        panel.add(panel_5);
        panel_5.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(6, 16, 449, 344);
        panel_5.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel energyOptionsLabel = new JLabel(obj.getEnergyOptionsLabel());
        energyOptionsLabel.setBounds(0, 0, 189, 20);
        panel_1.add(energyOptionsLabel);
        energyOptionsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox energyOptionsList = new JComboBox(new Vector(obj.getEnergyOptionsList()));
        energyOptionsList.setBounds(199, 0, 170, 20);
        panel_1.add(energyOptionsList);
        
        JComboBox screenList = new JComboBox(new Vector(obj.getScreenList()));
        screenList.setBounds(199, 64, 170, 20);
        panel_1.add(screenList);
        
        JComboBox spacerList = new JComboBox(new Vector(obj.getSpacerList()));
        spacerList.setBounds(199, 129, 170, 20);
        panel_1.add(spacerList);
        
        JLabel spacerLabel = new JLabel(obj.getSpacerLabel());
        spacerLabel.setBounds(0, 129, 189, 20);
        panel_1.add(spacerLabel);
        spacerLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel screenLabel = new JLabel(obj.getScreenLabel());
        screenLabel.setBounds(0, 64, 189, 20);
        panel_1.add(screenLabel);
        screenLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel spacerCostLabel = new JLabel("+$0.00");
        spacerCostLabel.setBounds(387, 129, 50, 14);
        panel_1.add(spacerCostLabel);
        
        JLabel screenCostLabel = new JLabel("+$0.00");
        screenCostLabel.setBounds(387, 64, 50, 14);
        panel_1.add(screenCostLabel);
        
        JLabel energyOptionsCostLabel = new JLabel("+$0.00");
        energyOptionsCostLabel.setBounds(387, 0, 50, 14);
        panel_1.add(energyOptionsCostLabel);
        
        JComboBox glassList = new JComboBox(new Vector(obj.getGlassList()));
        glassList.setBounds(199, 31, 170, 20);
        panel_1.add(glassList);
        
        JLabel glassCostLabel = new JLabel("+$0.00");
        glassCostLabel.setBounds(387, 31, 50, 14);
        panel_1.add(glassCostLabel);
        
        JLabel glassLabel = new JLabel(obj.getGlassLabel());
        glassLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        glassLabel.setBounds(0, 31, 189, 20);
        panel_1.add(glassLabel);
        
        JLabel glassTintCostLabel = new JLabel("+$0.00");
        glassTintCostLabel.setBounds(387, 160, 50, 14);
        panel_1.add(glassTintCostLabel);
        
        JComboBox glassTintList = new JComboBox(new Vector(obj.getGlassTintList()));

        glassTintList.setBounds(199, 160, 170, 20);
        panel_1.add(glassTintList);
        
        JLabel glassTintLabel = new JLabel(obj.getGlassTintLabel());
        glassTintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        glassTintLabel.setBounds(0, 160, 189, 20);
        panel_1.add(glassTintLabel);
        
        JLabel hardwareColorLabel = new JLabel(obj.getLockColorLabel());
        hardwareColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        hardwareColorLabel.setBounds(0, 193, 189, 20);
        panel_1.add(hardwareColorLabel);
        
        JComboBox hardwareColorList = new JComboBox(new Vector(obj.getLockColorList()));
        hardwareColorList.setBounds(199, 193, 170, 20);
        panel_1.add(hardwareColorList);
        
        JLabel hardwareColorCostLabel = new JLabel("+$0.00");
        hardwareColorCostLabel.setBounds(387, 193, 50, 14);
        panel_1.add(hardwareColorCostLabel);
        
        JLabel screenMeshLabel = new JLabel(obj.getScreenMeshLabel());
        screenMeshLabel.setBounds(0, 98, 189, 20);
        panel_1.add(screenMeshLabel);
        screenMeshLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel meshCostLabel = new JLabel("+$0.00");
        meshCostLabel.setBounds(387, 95, 50, 14);
        panel_1.add(meshCostLabel);
        
        JComboBox meshList = new JComboBox(new Vector(obj.getScreenMeshList()));
        meshList.setBounds(199, 95, 170, 20);
        panel_1.add(meshList);
        
        JLabel frameColorLabel = new JLabel(obj.getFrameColorLabel());
        frameColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        frameColorLabel.setBounds(0, 224, 189, 20);
        panel_1.add(frameColorLabel);
        
        JComboBox frameColorList = new JComboBox(new Vector(obj.getFrameColorList()));
        frameColorList.setBounds(199, 224, 170, 20);
        panel_1.add(frameColorList);
        
        JLabel frameColorCostLabel = new JLabel("+$0.00");
        frameColorCostLabel.setBounds(387, 224, 50, 14);
        panel_1.add(frameColorCostLabel);
        
        JButton button = new JButton("Add");
        button.setFont(new Font("Dialog", Font.BOLD, 14));
        button.setBounds(868, 569, 83, 30);
        panel.add(button);
		energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
		screenCost=obj.getScreenMeshPrice(screenList.getSelectedIndex());
		meshCost=obj.getScreenMeshPrice(meshList.getSelectedIndex());
		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
		hardwareColorCost=obj.getLockColorPrice(hardwareColorList.getSelectedIndex(), false);
		glassTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
        energyOptionsCostLabel.setText("+$"+String.format("%.2f", energyCost));
		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
        screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
        meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
	    spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
        hardwareColorCostLabel.setText("+$"+String.format("%.2f", hardwareColorCost));
		glassTintCostLabel.setText("+$"+String.format("%.2f", glassTintCost));
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        energyOptionsList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		energyCost=obj.getEnergyOptionsPrice(energyOptionsList.getSelectedIndex(),ui);
                energyOptionsCostLabel.setText("+$"+String.format("%.2f", energyCost));
    			calcTotalCost();
        	}
        });
        glassList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
    			calcTotalCost();
        	}
        });
        screenList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		screenCost=obj.getScreenPrice(index);
                screenCostLabel.setText("+$"+String.format("%.2f", screenCost));
    			calcTotalCost();
        	}
        });
        meshList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		meshCost=obj.getScreenMeshPrice(index);
        		meshCostLabel.setText("+$"+String.format("%.2f", meshCost));
    			calcTotalCost();
        	}
        });
        spacerList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
    			calcTotalCost();
        	}
        });
        glassTintList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		glassTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
        		glassTintCostLabel.setText("+$"+String.format("%.2f", glassTintCost));
    			calcTotalCost();
        	}
        });
        hardwareColorList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		hardwareColorCost=obj.getLockColorPrice(index, false);
        		hardwareColorCostLabel.setText("+$"+String.format("%.2f", hardwareColorCost));
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
        return panel;
        
    }


	public void actionPerformed(ActionEvent e){
	}
}
